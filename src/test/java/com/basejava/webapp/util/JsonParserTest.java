package com.basejava.webapp.util;

import com.basejava.webapp.model.Resume;
import com.basejava.webapp.model.Section;
import com.basejava.webapp.model.TextSection;
import org.junit.Assert;
import org.junit.Test;

import static com.basejava.webapp.TestData.*;

public class JsonParserTest {

    @Test
    public void test() {
        String obj = JsonParser.write(resume1);
        System.out.println(obj);
        Resume resume = JsonParser.read(obj, Resume.class);
        Assert.assertEquals(resume1, resume);
    }

    @Test
    public void write() {
        Section section = new TextSection("some info");
        String str = JsonParser.write(section, Section.class);
        System.out.println(str);
        Section section1 = JsonParser.read(str, Section.class);
        Assert.assertEquals(section, section1);
    }
}