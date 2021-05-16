package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int CAPACITY = 10_000;

    protected Resume[] storage = new Resume[CAPACITY];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = findResumeIndex(uuid);
        if (index == -1) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int findResumeIndex(String uuid);
}