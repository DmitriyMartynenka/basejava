package com.basejava.webapp.model;

import java.util.Objects;

public class TextSection extends Section {

    private static final long serialVersionUID = 1L;

    private final String commonInfo;

    public TextSection(String commonInfo) {
        Objects.requireNonNull(commonInfo, "commonInfo must not be null");
        this.commonInfo = commonInfo;
    }

    public String getCommonInfo() {
        return commonInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return Objects.equals(commonInfo, that.commonInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commonInfo);
    }

    @Override
    public String toString() {
        return commonInfo + "\n";
    }
}