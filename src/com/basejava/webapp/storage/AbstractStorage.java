package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract void clear();

    protected abstract void doUpdate(int searchKey, Resume resume);

    protected abstract void doSave(int searchKey, Resume resume);

    protected abstract Resume doGet(int searchKey);

    protected abstract void doDelete(int searchKey);

    protected abstract Integer findResumeIndex(String uuid);

    public void update(Resume resume) {
        int searchKey = getExistedUuid(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    public void save(Resume resume) {
        int searchKey = getNotExistedUuid(resume.getUuid());
        doSave(searchKey, resume);
    }

    public Resume get(String uuid) {
        int searchKey = getExistedUuid(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        int searchKey = getExistedUuid(uuid);
        doDelete(searchKey);
    }

    private int getExistedUuid(String uuid) {
        int searchIndex = findResumeIndex(uuid);
        if (searchIndex < 0) {
            throw new NotExistStorageException(uuid);
        }
        return searchIndex;
    }

    private int getNotExistedUuid(String uuid) {
        int searchIndex = findResumeIndex(uuid);
        if (searchIndex >= 0) {
            throw new ExistStorageException(uuid);
        }
        return searchIndex;
    }
}
