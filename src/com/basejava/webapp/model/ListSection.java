package com.basejava.webapp.model;

import java.util.List;
import java.util.Objects;

public class ListSection extends AbstractSection {

    private final List<String> article;

    public ListSection(List<String> article) {
        Objects.requireNonNull(article, "article must not be null");
        this.article = article;
    }

    public List<String> getArticle() {
        return article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return article.equals(that.article);
    }

    @Override
    public int hashCode() {
        return article.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder strings = new StringBuilder();
        for (String s : article) {
            strings = strings.append(s).append("\n");
        }
        return strings.toString();
    }
}
