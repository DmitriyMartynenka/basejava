package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Resume resume, String searchKey) {
        map.put(searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, String searchKey) {
        map.put(searchKey, resume);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected boolean isSearchKeyFound(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}
