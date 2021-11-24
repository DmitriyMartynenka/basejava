package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.util.ArrayList;
import java.util.UUID;

public class TestData {

    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final String NAME_1 = "person1";
    public static final String NAME_2 = "person2";
    public static final String NAME_3 = "person3";
    public static final String NAME_4 = "person4";

    public static final Resume resume1;
    public static final Resume resume2;
    public static final Resume resume3;
    public static final Resume resume4;

    static {
        resume1 = new Resume(UUID_1, NAME_1);
        resume2 = new Resume(UUID_2, NAME_2);
        resume3 = new Resume(UUID_3, NAME_3);
        resume4 = new Resume(UUID_4, NAME_4);
        resume1.addContact(ContactType.MOBILE_PHONE, "+7(921) 855-04821");
        resume1.addContact(ContactType.MAIL, "gkislin@yandex.ru1");
        resume2.addContact(ContactType.MOBILE_PHONE, "+7(921) 855-04822");
        resume2.addContact(ContactType.MAIL, "gkislin@yandex.ru2");
        resume3.addContact(ContactType.MOBILE_PHONE, "+7(921) 855-04823");
        resume3.addContact(ContactType.MAIL, "gkislin@yandex.ru3");
        resume4.addContact(ContactType.MOBILE_PHONE, "+7(921) 855-04824");
        resume4.addContact(ContactType.MAIL, "gkislin@yandex.ru4");
        resume1.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры."));
        resume1.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям"));
        ListSection achievements = new ListSection(new ArrayList<>());
        achievements.getArticles().add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное " +
                "взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements.getArticles().add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами" +
                " Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        ListSection qualification = new ListSection(new ArrayList<>());
        qualification.getArticles().add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualification.getArticles().add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualification.getArticles().add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        resume1.addSection(SectionType.ACHIEVEMENT, achievements);
        resume1.addSection(SectionType.QUALIFICATIONS, qualification);
    }
}
