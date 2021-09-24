package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class OraganizationSection extends Section {
    private static final long serialVersionUID = 1L;

    private final List<Organization> organizations;

    public OraganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OraganizationSection that = (OraganizationSection) o;
        return Objects.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizations);
    }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        for (Organization exp : organizations) {
            strings = strings.append(exp).append("\n");
        }
        return strings.toString();
    }
}