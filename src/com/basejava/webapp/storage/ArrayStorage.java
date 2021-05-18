package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (findResumeIndex(resume.getUuid()) != -1) {
            System.out.println("Error! Resume with identifier " + resume.getUuid() + " has already exist");
        } else if (size == CAPACITY) {
            System.out.println("Error! Storage is full");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findResumeIndex(uuid);
        if (index == -1) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int findResumeIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}