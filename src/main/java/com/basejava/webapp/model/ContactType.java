package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    MOBILE_PHONE("Моб. телефон"),
    MAIL("Почта") {
        @Override
        protected String toHtml0(String value) {
            return "<a href='mailto:"+ value +"'>" + value +"</a>";
        }
    },
    SKYPE("Профиль Skype") {
        @Override
        protected String toHtml0(String value) {
            return "<a href='skype:"+value+"'>" + value + "</a>";
        }
    },
    GITHUB("Профиль GitHub"),
    LINKEDIN("Профиль LinkedIn"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    SLACK("Профиль Slack"),
    TELEGRAM("Профиль Telegram"),
    HOMEPAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toHtml(String value) {
        return value == null ? "" : toHtml0(value);
    }

    protected String toHtml0(String value) {
        return title + ": " + value;
    }
}