package de.zettsystems.loesung1415;

public class QueryProvider {

    public String getQuery() {
        return """
            SELECT new de.zettsystems.loesung1416.BookAuthorReviewCount(b.title,
            concat(a.firstName, ' ', a.lastName), size(b.reviews))
            FROM Book b JOIN b.author a GROUP BY b.title, a.firstName, a.lastName""";
    }
}
