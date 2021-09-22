package com.basejava.webapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.basejava.webapp.util.DateUtil.NOW;
import static com.basejava.webapp.util.DateUtil.of;

public class OrganizationSection implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Link homePage;
    private final List<Position> positions;

    public OrganizationSection(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public OrganizationSection(Link homePage, Position... positions) {
        this(homePage, Arrays.asList(positions));
    }

    public OrganizationSection(Link homePage, List<Position> positions) {
        Objects.requireNonNull(positions, "positions must not be null");
        this.homePage = homePage;
        this.positions = positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        if (homePage != null ? !homePage.equals(that.homePage) : that.homePage != null) return false;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + positions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        for (Position stage : positions) {
            strings = strings.append(stage.toString()).append("\n");
        }
        return homePage +
                strings.toString();
    }

    public static class Position implements Serializable {
        private final String title;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String description;

        public Position(String title, int startYear, Month startMonth, int endYear, Month endMonth, String description) {
            this(title, of(startYear, startMonth), of(endYear, endMonth), description);
        }

        public Position(String title, int startYear, Month startMonth, String description) {
            this(title, of(startYear, startMonth), NOW, description);
        }

        public Position(String title, LocalDate startDate, LocalDate endDate, String description) {
            Objects.requireNonNull(title, "title must not be null");
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            this.title = title;
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position that = (Position) o;

            if (!startDate.equals(that.startDate)) return false;
            if (!endDate.equals(that.endDate)) return false;
            return description != null ? description.equals(that.description) : that.description == null;
        }

        @Override
        public int hashCode() {
            int result = startDate.hashCode();
            result = 31 * result + endDate.hashCode();
            result = 31 * result + (description != null ? description.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "startDate=" + startDate +
                    ", endDate=" + endDate + ", title=" +
                    title + ", description='" + description + '\'';
        }
    }
}
