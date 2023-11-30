package de.zettsystems.uebung1415;

public class QueryProvider {

    public String getQuery() {
        // TODO make it more readable
        return "SELECT new de.zettsystems.uebung1416.BookAuthorReviewCount(b.title, concat(a.firstName, ' ', a.lastName), size(b.reviews)) FROM Book b JOIN b.author a GROUP BY b.title, a.firstName, a.lastName";
    }
}
