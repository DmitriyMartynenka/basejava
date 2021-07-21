package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        map.put((String) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    protected Object findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isSearchKeyFound(Object searchKey) {
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            if (entry.getKey().equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
