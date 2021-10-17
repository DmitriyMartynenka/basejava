package com.basejava.webapp;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MainCollection {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume resume1 = new Resume(UUID_1);
    private static final Resume resume2 = new Resume(UUID_2);
    private static final Resume resume3 = new Resume(UUID_3);
    private static final Resume resume4 = new Resume(UUID_4);

    public static void main(String[] args) {
        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, resume1);
        map.put(UUID_2, resume2);
        map.put(UUID_3, resume3);
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
