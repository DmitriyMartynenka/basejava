package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int CAPACITY = 10_000;

    protected Resume[] storage = new Resume[CAPACITY];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findResumeIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("Error. Resume with identifier " + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }

    public abstract void save(Resume resume);

    public Resume get(String uuid) {
        int index = findResumeIndex(uuid);
        if (index < 0) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public abstract void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findResumeIndex(String uuid);
}