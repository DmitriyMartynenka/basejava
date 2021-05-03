import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public static final int ARRAY_SIZE = 10000;

    Resume[] storage = new Resume[ARRAY_SIZE];
    private static int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < ARRAY_SIZE ; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                size--;
                for (int j = i+1; j < ARRAY_SIZE; i++, j++) {
                    if (storage[j] != null) {
                        storage[i] = storage[j];
                    } else {
                        break;
                    }
                }
            }
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
}
