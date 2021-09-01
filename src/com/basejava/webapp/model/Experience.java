package com.basejava.webapp.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.basejava.webapp.util.DateUtil.of;

public class Experience {

    private final Link homePage;
    private final List<EducationStage> stages;

    public Experience(String name, String url, EducationStage... stages) {
        this(new Link(name, url), Arrays.asList(stages));
    }

    public Experience(Link homePage, EducationStage... stages) {
        this(homePage, Arrays.asList(stages));
    }

    public Experience(Link homePage, List<EducationStage> stages) {
        Objects.requireNonNull(stages, "stages must not be null");
        this.homePage = homePage;
        this.stages = stages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (homePage != null ? !homePage.equals(that.homePage) : that.homePage != null) return false;
        return stages.equals(that.stages);
    }

    @Override
    public int hashCode() {
        int result = homePage != null ? homePage.hashCode() : 0;
        result = 31 * result + stages.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        for (EducationStage stage : stages) {
            strings = strings.append(stage.toString()).append("\n");
        }
        return homePage +
                strings.toString();
    }

    public static class EducationStage {
        private final String title;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final String description;

        public EducationStage(String title, int startYear, Month startMonth, int endYear, Month endMonth, String description) {
            this(title, of(startYear, startMonth), of(endYear, endMonth), description);
        }

        public EducationStage(String title, int startYear, Month startMonth, String description) {
            this(title, of(startYear, startMonth), of(2021, Month.DECEMBER), description);
        }

        public EducationStage(String title, LocalDate startDate, LocalDate endDate, String description) {
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

            EducationStage that = (EducationStage) o;

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
