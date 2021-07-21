package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MapUuidStorageTest extends AbstractStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Override
    public void getAll() throws Exception {
        HashMap<String, Resume> expColl = new HashMap<>() {{
            put(UUID_1, resume1);
            put(UUID_2, resume2);
            put(UUID_3, resume3);
        }};
        assertEquals(expColl.size(), storage.size());
        assertArrayEquals(expColl.values().toArray(new Resume[expColl.size()]), storage.getAll());
    }
}