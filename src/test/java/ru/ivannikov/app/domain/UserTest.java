package ru.ivannikov.app.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {

    @Test
    public void shouldReturnNotNullUser() {
        final String password = "password";
        final String name = "name";
        final String email = "email@ya.ru";

        User user = new User(name, email, password);
        assertThat(user.getUserName().equals(name));
        assertThat(user.getEmail().equals(email));
        assertThat(user.getPassword().equals(password));
    }

    @Test
    public void shouldSetNotNullValues() {
        final String password = "password";
        final String name = "name";
        final String email = "email@ya.ru";

        User user = new User(name, email, password);
        user.setUserName(name + "!");
        user.setEmail(email + "!");
        user.setPassword(password + "!");
        assertThat(user.getUserName().equals(name + "!"));
        assertThat(user.getEmail().equals(email + "!"));
        assertThat(user.getPassword().equals(password + "!"));
        assertThat(user.isValid());
    }
}