package de.zettsystems.uebung1617;

import java.util.Objects;

// TODO use new java api, make more compact
public class BookAuthorReviewCount {
    private final String title;
    private final String author;
    private final Long reviewCount;

    public BookAuthorReviewCount(String title, String author, Long reviewCount) {
        this.title = title;
        this.author = author;
        this.reviewCount = reviewCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getReviewCount() {
        return reviewCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAuthorReviewCount that = (BookAuthorReviewCount) o;
        return Objects.equals(title, that.title) && Objects.equals(author, that.author) && Objects.equals(reviewCount, that.reviewCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, reviewCount);
    }

    @Override
    public String toString() {
        return "BookAuthorReviewCount{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviewCount=" + reviewCount +
                '}';
    }
}
