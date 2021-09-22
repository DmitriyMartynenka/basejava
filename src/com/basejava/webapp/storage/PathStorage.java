package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serialization.SerializationStrategy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private SerializationStrategy serializationStrategy;

    public PathStorage(String dir, SerializationStrategy serializationStrategy) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must be not null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(directory + " is not directory or is not writable");
        }
        this.directory = directory;
        this.serializationStrategy = serializationStrategy;
    }

    @Override
    public void clear() {
        getFilesInDirectory().forEach(this::doDelete);
    }

    @Override
    protected void doUpdate(Resume resume, Path path) {
        try {
            serializationStrategy.doWrite(new BufferedOutputStream(Files.newOutputStream(path)), resume);
        } catch (IOException e) {
            throw new StorageException("IO error", path.toString(), e);
        }
    }

    @Override
    protected void doSave(Resume resume, Path path) {
        try {
            Files.createFile(path);
            serializationStrategy.doWrite(new BufferedOutputStream(Files.newOutputStream(path)), resume);
        } catch (IOException e) {
            throw new StorageException("IO error", path.toString(), e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return serializationStrategy.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.toString(), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException(path + " delete error", null, e);
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        return getFilesInDirectory().map(this::doGet).collect(Collectors.toList());
    }

    @Override
    protected boolean isSearchKeyFound(Path path) {
        return Files.exists(path);
    }

    @Override
    public int size() {
        return (int) getFilesInDirectory().count();
    }

    private Stream<Path> getFilesInDirectory() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("Directory read error", null, e);
        }
    }
}