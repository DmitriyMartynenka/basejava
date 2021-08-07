package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doUpdate(Resume searchKey, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume searchKey, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Resume searchKey_Resume) {
        return searchKey_Resume;
    }

    @Override
    protected void doDelete(Resume searchKey_Resume) {
        map.remove((searchKey_Resume).getUuid());
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected List<Resume> doGetAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected boolean isSearchKeyFound(Resume searchKey_Resume) {
        return searchKey_Resume != null;
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
