package hello.dao.model;

public class Person {
    private static String name;
    private static int age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static String getName() {
        return name;
    }
}
