package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        int index = findResumeIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Error! Resume with identifier " + resume.getUuid() + " has already exist");
        } else if (size == CAPACITY) {
            System.out.println("Error! Storage is full");
        } else {
            index = -(index + 1);
            System.arraycopy(storage, index, storage, index, size + 1);
            storage[size] = resume;
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findResumeIndex(uuid);
        if (index < 0) {
            System.out.println("Error. Resume with identifier " + uuid + " not exist");
        } else {
            storage[index] = null;
            System.arraycopy(storage, index + 1, storage, index, size - index);
            size--;
        }
    }

    @Override
    protected int findResumeIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}