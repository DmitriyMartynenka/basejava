package com.basejava.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListSection extends Section {
    private static final long serialVersionUID = 1L;

    private List<String> articles;

    public ListSection() {
    }

    public ListSection(String... articles) {
        this(Arrays.asList(articles));
    }

    public ListSection(List<String> articles) {
        Objects.requireNonNull(articles, "articles must not be null");
        this.articles = articles;
    }

    public List<String> getArticles() {
        return articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articles);
    }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        for (String s : articles) {
            strings = strings.append(s).append("\n");
        }
        return strings.toString();
    }
}