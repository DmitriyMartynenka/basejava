package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doUpdate(Object searchKey, Resume resume);

    protected abstract void doSave(Object searchKey, Resume resume);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract Object findSearchKey(String uuid);

    public void update(Resume resume) {
        Object searchKey = getExistedUuid(resume.getUuid());
        doUpdate((Object) searchKey, resume);
    }

    public void save(Resume resume) {
        Object searchKey = getNotExistedUuid(resume.getUuid());
        doSave((Object) searchKey, resume);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistedUuid(uuid);
        return doGet((Object) searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistedUuid(uuid);
        doDelete((Object) searchKey);
    }

    private Object getExistedUuid(String uuid) {
        Object searchIndex = findSearchKey(uuid);
        if (!isSearchKeyFound(searchIndex)) {
            throw new NotExistStorageException(uuid);
        }
        return searchIndex;
    }

    private Object getNotExistedUuid(String uuid) {
        Object searchIndex = findSearchKey(uuid);
        if (isSearchKeyFound(searchIndex)) {
            throw new ExistStorageException(uuid);
        }
        return searchIndex;
    }

    protected abstract boolean isSearchKeyFound(Object searchKey);
}
