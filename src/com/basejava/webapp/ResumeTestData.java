package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = createResume("1", "Grigory");
    }

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.addContact(ContactType.MOBILE_PHONE, "+7(921) 855-0482");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "someURL");
        resume.addContact(ContactType.GITHUB, "someURL");
        resume.addContact(ContactType.STACKOVERFLOW, "someURL");
        resume.addContact(ContactType.HOMEPAGE, "someURL");
        resume.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры."));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного " +
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
        List<Organization> educationList = new ArrayList<>();
        educationList.add(new Organization("Санкт-Петербургский национальный исследовательский университет информационных " +
                "технологий, механики и оптики", "someURL", new Organization.Position("Аспирантура (программист С, С++)", 1993,
                Month.SEPTEMBER, 1996, Month.JULY, null), new Organization.Position("Инженер (программист Fortran, C)", 1987,
                Month.SEPTEMBER, 1993, Month.JULY, null)));
        OraganizationSection education = new OraganizationSection(educationList);
        resume.addSection(SectionType.ACHIEVEMENT, achievements);
        resume.addSection(SectionType.QUALIFICATIONS, qualification);
        resume.addSection(SectionType.EDUCATION, education);
        return resume;
    }
}