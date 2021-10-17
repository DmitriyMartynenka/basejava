package com.basejava.webapp.storage;

import com.basejava.webapp.storage.serialization.DataStreamSerializer;

public class DataStreamPathStorageTest extends AbstractStorageTest {

    public DataStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}
