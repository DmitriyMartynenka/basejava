package com.basejava.webapp.model;

import java.util.List;

public class ExperienceSection extends AbstractSection {

    private final List<Experience> experience;

    public ExperienceSection(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExperienceSection that = (ExperienceSection) o;

        return experience.equals(that.experience);
    }

    @Override
    public int hashCode() {
        return experience.hashCode();
    }

    @Override
    public String toString() {
        return experience.toString();
    }
}
