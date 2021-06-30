package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int CAPACITY = 4;

    protected Resume[] storage = new Resume[CAPACITY];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findResumeIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage[index] = resume;
    }

    public void save(Resume resume) {
        int index = findResumeIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        if (size == CAPACITY) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveResumeToArray(index, resume);
        size++;

    }

    protected abstract void saveResumeToArray(int index, Resume resume);

    public Resume get(String uuid) {
        int index = findResumeIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findResumeIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        deleteResumeFromArray(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void deleteResumeFromArray(int index);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findResumeIndex(String uuid);
}