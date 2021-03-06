package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String NAME_1 = "person1";
    private static final String NAME_2 = "person2";
    private static final String NAME_3 = "person3";
    private static final String NAME_4 = "person4";

    private static final Resume resume1 = new Resume(UUID_1, NAME_1);
    private static final Resume resume2 = new Resume(UUID_2, NAME_2);
    private static final Resume resume3 = new Resume(UUID_3, NAME_3);
    private static final Resume resume4 = new Resume(UUID_4, NAME_4);

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(resume2);
        storage.save(resume1);
        storage.save(resume3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume anotherResume = new Resume(UUID_1, NAME_1);
        storage.update(anotherResume);
        assertSame(anotherResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(resume4);
    }

    @Test
    public void save() throws Exception {
        storage.save(resume4);
        assertEquals(4, storage.size());
        assertEquals(resume4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() throws Exception {
        storage.save(resume1);
    }

    @Test
    public void get() throws Exception {
        assertEquals(resume1, storage.get(UUID_1));
        assertEquals(resume2, storage.get(UUID_2));
        assertEquals(resume3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(resume4.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws NotExistStorageException {
        storage.delete(UUID_2);
        assertEquals(2, storage.size());
        assertEquals(resume2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(resume4.getUuid());
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> expectedList = new ArrayList<>() {
        };
        expectedList.add(resume1);
        expectedList.add(resume2);
        expectedList.add(resume3);
        Collections.sort(expectedList);
        assertEquals(expectedList.size(), storage.size());
        assertEquals(expectedList, storage.getAllSorted());
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }
}