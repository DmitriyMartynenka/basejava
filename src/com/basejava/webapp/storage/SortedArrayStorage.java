package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void changeIndex(int index) {
        index = -(index + 1);
        System.arraycopy(storage, index, storage, index, size + 1);
    }

    @Override
    protected void removalWay(int index) {
        storage[index] = null;
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected int findResumeIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}