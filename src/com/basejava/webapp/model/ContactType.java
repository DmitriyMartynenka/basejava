package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    MOBILE_PHONE("Моб. телефон"),
    MAIL("Почта"),
    SKYPE("Профиль Skype"),
    GITHUB("Профиль GitHub"),
    LINKEDIN("Профиль LinkedIn"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    SLACK("Профиль Slack"),
    TELEGRAM("Профиль Telegram"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

