package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.storage.serialization.SerializationStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;
    private SerializationStrategy serializationStrategy;

    public FileStorage(File directory, SerializationStrategy serializationStrategy) {
        Objects.requireNonNull(directory, "directory must be not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " directory is not readable/writable");
        }
        this.directory = directory;
        this.serializationStrategy = serializationStrategy;
    }

    @Override
    public void clear() {
        for (File file : getFilesInDirectory()) {
            doDelete(file);
        }
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            serializationStrategy.doWrite(new BufferedOutputStream(new FileOutputStream(file)), resume);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
        doUpdate(resume, file);
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return serializationStrategy.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("File not deleted", file.getName());
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        File[] filesInDirectory = getFilesInDirectory();
        List<Resume> resumes = new ArrayList<>(filesInDirectory.length);
        for (File file : filesInDirectory) {
            resumes.add(doGet(file));
        }
        return resumes;
    }

    @Override
    protected boolean isSearchKeyFound(File file) {
        return file.exists();
    }

    @Override
    public int size() {
        return getFilesInDirectory().length;
    }

    private File[] getFilesInDirectory() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", "null");
        }
        return files;
    }
}