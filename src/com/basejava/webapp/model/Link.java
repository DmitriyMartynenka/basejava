package com.basejava.webapp.model;

import java.io.Serializable;
import java.util.Objects;

public class Link implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String URL;

    public Link(String name, String url) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        URL = url;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(name, link.name) &&
                Objects.equals(URL, link.URL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, URL);
    }

    @Override
    public String toString() {
        return name + ", URL='" + URL + '\'' + "\n";
    }
}