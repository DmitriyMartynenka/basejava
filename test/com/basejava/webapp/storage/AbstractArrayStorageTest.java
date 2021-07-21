package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.CAPACITY; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("Overflow happened ahead of time");
        }
        storage.save(new Resume());
    }
}