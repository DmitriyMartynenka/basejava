package com.basejava.webapp.model;

import java.time.YearMonth;

public class Experience {

    private final String title;
    private final String time;
    private final YearMonth startDate;
    private final YearMonth endDate;
    private final String description;

    public Experience(String title, String time, YearMonth startDate, YearMonth endDate, String description) {
        this.title = title;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!title.equals(that.title)) return false;
        if (!time.equals(that.time)) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'';
    }
}
