package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<Resume>();

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected void doUpdate(int searchKey, Resume resume) {
        list.set(searchKey, resume);
    }

    @Override
    protected void doSave(int searchKey, Resume resume) {
        list.add(resume);
    }

    @Override
    protected Resume doGet(int searchKey) {
        return list.get(searchKey);
    }

    @Override
    protected void doDelete(int searchKey) {
        list.remove(searchKey);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected Integer findResumeIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (uuid.equals(list.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
