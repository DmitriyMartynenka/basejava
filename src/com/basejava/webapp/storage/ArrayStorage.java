package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int CAPACITY = 10000;

    private Resume[] storage = new Resume[CAPACITY];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume resume) {
        if (getResumeIndex(resume.getUuid()) == -1) {
            System.out.println("Error. Resume not exist");
        } else {
            storage[getResumeIndex(resume.getUuid())] = resume;
        }
    }

    void save(Resume resume) {
        if (getResumeIndex(resume.getUuid()) != -1) {
            System.out.println("Error! Resume has already exist");
        } else if (size == 10000) {
            System.out.println("Error! Storage is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    Resume get(String uuid) {
        if (getResumeIndex(uuid) == -1) {
            System.out.println("Error. Resume not exist");
            return null;
        } else {
            return storage[getResumeIndex(uuid)];
        }
    }

    void delete(String uuid) {
        if (getResumeIndex(uuid) == -1) {
            System.out.println("Error. Resume not exist");
        } else {
            storage[getResumeIndex(uuid)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

    public int getResumeIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}