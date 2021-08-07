package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int CAPACITY = 4;

    protected Resume[] storage = new Resume[CAPACITY];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Integer searchKey, Resume resume) {
        storage[searchKey] = resume;
    }

    @Override
    protected void doSave(Integer searchKey, Resume resume) {
        if (size == CAPACITY) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveResumeToArray(searchKey, resume);
        size++;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected void doDelete(Integer searchKey) {
        deleteResumeFromArray(searchKey);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void saveResumeToArray(int index, Resume resume);

    protected abstract void deleteResumeFromArray(int index);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    @Override
    protected List<Resume> doGetAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract Integer findSearchKey(String uuid);

    @Override
    protected boolean isSearchKeyFound(Integer searchKey) {
        return searchKey >= 0;
    }
}