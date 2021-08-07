package com.basejava.webapp.model;

public class StringSection extends AbstractSection {
    private final String commonInfo;

    public StringSection(String commonInfo) {
        this.commonInfo = commonInfo;
    }

    public String getCommonInfo() {
        return commonInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringSection that = (StringSection) o;

        return commonInfo.equals(that.commonInfo);
    }

    @Override
    public int hashCode() {
        return commonInfo.hashCode();
    }

    @Override
    public String toString() {
        return commonInfo;
    }
}
