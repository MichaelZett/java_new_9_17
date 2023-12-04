package de.zettsystems.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentManagement {
    private static final String html = """
            <!DOCTYPE html>
                        <html>
                <head>
                    <title>HTML mit Text Block</title>
                </head>
                <body>
                    <h1>Willkommen in meiner HTML-Seite</h1>
                    <p>Dies ist ein einfaches HTML-Beispiel.</p>
                </body>
                        </html>\
            """;

    public static void main(String[] args) {
        List<Student> studentList = List.of(
                new Graduate("Alice", 20, Gender.FEMALE, "Jever"),
                new Undergraduate("Bob", 17, Gender.MALE),
                new Graduate("Charlie", 21, Gender.OTHER, "Warsteiner")
        );

        for (Student student : studentList) {
            if (student instanceof Undergraduate undergrad) {
                System.out.printf("%s is an Undergraduate student.", undergrad.name());
            } else if (student instanceof Graduate grad) {
                System.out.printf("%s is a Graduate student.", grad.name());
            }
        }

        var adultStudents = studentList.stream()
                .peek(System.out::println)
                .filter(s -> s.age() >= 18)
                .toList();

        adultStudents.forEach(student -> System.out.println("%s is an adult student.".formatted(student.name())));

        adultStudents.forEach(student -> {
            String status = switch (student) {
                case Undergraduate u -> "Undergraduate";
                case Graduate g -> "Graduate";
            };
            System.out.println("%s is a %s student.".formatted(student.name(), status));
        });

        printAverageByGender(studentList);

        printHtml();
    }

    private static void printHtml() {
        System.out.println(html);
    }

    private static void printAverageByGender(List<Student> students) {
        Map<Gender, Double> averageAgeByGender = students.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(person -> person.gender() == Gender.FEMALE, Collectors.averagingInt(Student::age)),
                        Collectors.filtering(person -> person.gender() == Gender.MALE, Collectors.averagingInt(Student::age)),
                        (femaleAvg, maleAvg) -> {
                            Map<Gender, Double> result = new HashMap<>();
                            result.put(Gender.FEMALE, femaleAvg);
                            result.put(Gender.MALE, maleAvg);
                            return result;
                        }
                ));

        System.out.printf("Average Age for Females: %s%n", averageAgeByGender.get(Gender.FEMALE));
        System.out.printf("Average Age for Males: %s%n", averageAgeByGender.get(Gender.MALE));
    }
}

sealed interface Student permits Graduate, Undergraduate {
    String name();

    int age();

    Gender gender();
}

record Undergraduate(String name, int age, Gender gender) implements Student {
    public Undergraduate {
        Objects.requireNonNull(name);
    }

}

record Graduate(String name, int age, Gender gender, String favouriteBeer) implements Student {

    public Graduate {
        Objects.requireNonNull(name);
        Objects.requireNonNull(favouriteBeer);
    }
}

enum Gender {
    MALE, FEMALE, OTHER
}
