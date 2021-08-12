package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Grigiry Kislin");
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
        List<Experience> jobExperienceList = new ArrayList<>();
        jobExperienceList.add(new Experience("Alcatel", "09/1997 - 03/1998", YearMonth.of(1997, 9),
                YearMonth.of(1998, 03), "6 месяцев обучения цифровым телефонным сетям (Москва)"));
        educationList.add(new Experience("Заочная физико-техническая школа при МФТИ", "09/1984 - 06/1987",
                YearMonth.of(1984, 9), YearMonth.of(1987, 06), "Закончил с отличием"));
        resume.getSections().put(SectionType.ACHIEVEMENT, achievements);
        resume.getSections().put(SectionType.QUALIFICATIONS, qualification);
        resume.getSections().put(SectionType.EXPERIENCE, new ExperienceSection(jobExperienceList));
        resume.getSections().put(SectionType.EDUCATION, new ExperienceSection(educationList));

        System.out.println(resume.getContacts());
        System.out.println(resume.getSections());
    }
}
