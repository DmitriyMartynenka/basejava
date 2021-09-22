package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class OraganizationList extends Section {
    private static final long serialVersionUID = 1L;

    private final List<OrganizationSection> organizationSection;

    public OraganizationList(List<OrganizationSection> organizationSection) {
        Objects.requireNonNull(organizationSection, "organizationSection must not be null");
        this.organizationSection = organizationSection;
    }

    public List<OrganizationSection> getOrganizationSection() {
        return organizationSection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OraganizationList that = (OraganizationList) o;

        return organizationSection.equals(that.organizationSection);
    }

    @Override
    public int hashCode() {
        return organizationSection.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        for (OrganizationSection exp : organizationSection) {
            strings = strings.append(exp).append("\n");
        }
        return strings.toString();
    }
}
