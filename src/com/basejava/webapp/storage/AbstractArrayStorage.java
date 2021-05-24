package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int CAPACITY = 3;

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

    public void save(Resume resume) {
        int index = findResumeIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Error! Resume with identifier " + resume.getUuid() + " has already exist");
        } else if (size == CAPACITY) {
            System.out.println("Error! Storage is full");
        } else {
            saveResumeToArray(index, resume);
            size++;
            System.out.println(Arrays.toString(storage));
        }
    }

    protected abstract void saveResumeToArray(int index, Resume resume);

    public Resume get(String uuid) {
        int index = findResumeIndex(uuid);
        if (index < 0) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findResumeIndex(uuid);
        if (index < 0) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
        } else {
            deleteResumeFromArray(index);
            storage[size - 1] = null;
            size--;
            System.out.println(Arrays.toString(storage));
        }
    }

    protected abstract void deleteResumeFromArray(int index);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    protected abstract int findResumeIndex(String uuid);
}