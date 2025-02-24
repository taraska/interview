package it.ivannikov.patterns.creational.builderPattern;


/*
The Builder Pattern in Java
The Builder pattern is a creational design pattern that separates the construction of a complex object from
its representation, allowing the same construction process to create different representations.

Key Characteristics:
Separates object construction from representation

Provides step-by-step construction

Produces different representations using the same construction process

Improves readability for objects with many parameters

Makes the code more maintainable

When to Use the Builder Pattern?

When an object requires many constructor parameters (especially optional ones)

When you need to create immutable objects with complex initialization

When you want to make object creation more readable and self-documenting

When you need to construct different representations of the same object

When you want to enforce invariants during object construction
* */
public class User {
    // Required fields
    private final String firstName;
    private final String lastName;

    // Optional fields
    private final int age;
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            '}';
    }

    // Getters (no setters to maintain immutability)

    public static class UserBuilder {
        // Required fields
        private final String firstName;
        private final String lastName;

        // Optional fields - initialized to default values
        private int age = 0;
        private String phone = "";
        private String address = "";

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User(this);
            validateUserObject(user);
            return user;
        }

        private void validateUserObject(User user) {
            // Validation logic here
            if (user.age < 0) {
                throw new IllegalStateException("Age cannot be negative");
            }
        }
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder("John", "Doe")
            .age(30)
            .phone("1234567890")
            .address("123 Main St")
            .build();
        System.out.println(user.toString());
    }
}
