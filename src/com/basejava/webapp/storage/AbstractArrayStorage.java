package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        storage[searchKey] = resume;
    }

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveResumeToArray(resume, searchKey);
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

    @Override
    protected boolean isSearchKeyFound(Integer searchKey) {
        return searchKey >= 0;
    }

    protected abstract void saveResumeToArray(Resume resume, int index);

    protected abstract void deleteResumeFromArray(int index);

    protected abstract Integer getSearchKey(String uuid);
}