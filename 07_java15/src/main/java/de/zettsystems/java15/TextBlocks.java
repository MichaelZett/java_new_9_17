package de.zettsystems.java15;

public class TextBlocks {

    public static void main(String[] args) {
        System.out.println(getSimpleTextBlock());
        System.out.println("*****_New_*****");
        System.out.println(getBlockOfHtml());
        System.out.println("*****_Old_*****");
        System.out.println(getBlockOfHtmlOldschool());
        System.out.println(getFormattedText("Wert"));
        System.out.println(getIgnoredNewLines());
        helpfulNpe(null);
    }

    private static String getSimpleTextBlock() {
        String textBlock = """
                Example text""";
        return textBlock;
    }

    public static String getBlockOfHtml() {
        return """
                <html>

                    <body>
                        <span>example text</span>
                    </body>
                </html>""";
    }

    public static String getBlockOfHtmlOldschool() {
        return "<html>\n"
                + "\n"
                + "    <body>\n"
                + "        <span>example text</span>\n"
                + "    </body>\n"
                + "</html>";
    }

    public static String getFormattedText(String parameter) {
//        String.format("Ein Parameter: %s", parameter); ist jetzt discouraged, man möge mit .formatted arbeiten
        return """
                Ein Parameter: %s
                """.formatted(parameter);
    }

    public static String getIgnoredNewLines() {
        return """
                This is a long test which looks to \
                have a newline but actually does not""";
    }

    private static void helpfulNpe(String value) {
        System.out.println(value.isBlank());
    }

}
