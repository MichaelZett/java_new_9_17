package de.zettsystems.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManagement {
    // TODO make more readable
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
        // TODO make List immutable, improve readability
        List<Student> x = new ArrayList<>();
        x.add(new Graduate("Alice", 20, Gender.FEMALE, "Jever"));
        x.add(new Undergraduate("Bob", 17, Gender.MALE));
        x.add(new Graduate("Charlie", 21, Gender.OTHER, "Warsteiner"));

        // TODO make more compact
        for (Student student : x) {
            if (student instanceof Undergraduate undergrad) {
                System.out.printf("%s is an Undergraduate student.", undergrad.getName());
            } else if (student instanceof Graduate grad) {
                System.out.printf("%s is a Graduate student.", grad.getName());
            }
        }

        // TODO use new method
        List<Student> collect = x.stream()
                .peek(System.out::println)
                .filter(s -> s.getAge() >= 18)
                .collect(Collectors.toUnmodifiableList());

        // TODO use new method for String
        collect.forEach(student -> System.out.println(student.getName() + " is an adult student."));

        // TODO make more compact
        x.forEach(student -> {
            String status;
            if (student instanceof Undergraduate) {
                status = "Undergraduate";
            } else if (student instanceof Graduate) {
                status = "Graduate";
            } else {
                status = "Unknown";
            }
            // TODO use new method for String
            System.out.println(student.getName() + " is a " + status + " student.");
        });

        printAverageByGender(x);

        printHtml();
    }

    private static void printHtml() {
        System.out.println(html);
    }

    //TODO make more readable and/or perhaps use teeing collector
    private static void printAverageByGender(List<Student> x) {
        Map<Gender, List<Student>> peopleByGender = x.stream()
                .collect(Collectors.groupingBy(Student::getGender));

        Map<Gender, Double> averageAgeByGender = new HashMap<>();
        for (Map.Entry<Gender, List<Student>> entry : peopleByGender.entrySet()) {
            Gender gender = entry.getKey();
            List<Student> genderPeople = entry.getValue();
            double averageAge = genderPeople.stream()
                    .mapToInt(Student::getAge)
                    .average()
                    .orElse(0.0);
            averageAgeByGender.put(gender, averageAge);
        }

        System.out.printf("Average Age for Females: %s%n", averageAgeByGender.get(Gender.FEMALE));
        System.out.printf("Average Age for Males: %s%n", averageAgeByGender.get(Gender.MALE));
    }
}


// TODO secure inheritance hierarchy
interface Student {
    String getName();

    int getAge();

    Gender getGender();
}

// TODO Reduce Boilerplate
class Undergraduate implements Student {
    private final String name;
    private final int age;
    private final Gender gender;

    public Undergraduate(String name, int age, Gender gender) {
        Objects.requireNonNull(name);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

}

// TODO Reduce Boilerplate
class Graduate implements Student {
    private final String name;
    private final int age;
    private final Gender gender;
    private final String favouriteBeer;

    public Graduate(String name, int age, Gender gender, String favouriteBeer) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(favouriteBeer);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.favouriteBeer = favouriteBeer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public String getFavouriteBeer() {
        return favouriteBeer;
    }
}

enum Gender {
    MALE, FEMALE, OTHER
}
