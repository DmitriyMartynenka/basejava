package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int CAPACITY = 10_000;

    private Resume[] storage = new Resume[CAPACITY];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Error. Resume with identifier " + resume.getUuid() + " not exist");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (getResumeIndex(resume.getUuid()) != -1) {
            System.out.println("Error! Resume with identifier " + resume.getUuid() + " has already exist");
        } else if (size == CAPACITY) {
            System.out.println("Error! Storage is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getResumeIndex(uuid);
        if (index == -1) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getResumeIndex(uuid);
        if (index == -1) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getResumeIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                int index = i;
                return index;
            }
        }
        return -1;
    }
}