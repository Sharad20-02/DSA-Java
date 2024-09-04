package JavaOOPS2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Person p1 = new Person();
        p1.age = 20;
        p1.name = "John";
        System.out.println(p1.age + " " + p1.name);
    }
}

class Person{
    String name;
    int age;
}