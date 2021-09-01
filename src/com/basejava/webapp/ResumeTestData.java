package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = createResume("1", "Grigory");
    }

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.getContacts().put(ContactType.MOBILE_PHONE, "+7(921) 855-0482");
        resume.getContacts().put(ContactType.SKYPE, "grigory.kislin");
        resume.getContacts().put(ContactType.MAIL, "gkislin@yandex.ru");
        resume.getContacts().put(ContactType.LINKEDIN, "someURL");
        resume.getContacts().put(ContactType.GITHUB, "someURL");
        resume.getContacts().put(ContactType.STACKOVERFLOW, "someURL");
        resume.getContacts().put(ContactType.HOMEPAGE, "someURL");
        resume.getSections().put(SectionType.PERSONAL, new StringSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры."));
        resume.getSections().put(SectionType.OBJECTIVE, new StringSection("Ведущий стажировок и корпоративного " +
                "обучения по Java Web и Enterprise технологиям"));
        ListSection achievements = new ListSection(new ArrayList<>());
        achievements.getArticle().add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное " +
                "взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements.getArticle().add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами" +
                " Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        ListSection qualification = new ListSection(new ArrayList<>());
        qualification.getArticle().add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualification.getArticle().add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualification.getArticle().add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        List<Experience> educationList = new ArrayList<>();
        educationList.add(new Experience("Санкт-Петербургский национальный исследовательский университет информационных " +
                "технологий, механики и оптики", "someURL", new Experience.EducationStage("Аспирантура (программист С, С++)", 1993,
                Month.SEPTEMBER, 1996, Month.JULY, null), new Experience.EducationStage("Инженер (программист Fortran, C)", 1987,
                Month.SEPTEMBER, 1993, Month.JULY, null)));
        resume.getSections().put(SectionType.ACHIEVEMENT, achievements);
        resume.getSections().put(SectionType.QUALIFICATIONS, qualification);
        resume.getSections().put(SectionType.EDUCATION, new ExperienceSection(educationList));

        for (Map.Entry<ContactType, String> entry : resume.getContacts().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<SectionType, AbstractSection> entry : resume.getSections().entrySet()) {
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }
        return resume;
    }
}
