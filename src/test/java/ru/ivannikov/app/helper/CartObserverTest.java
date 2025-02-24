package ru.ivannikov.app.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartObserverTest {

    private final CartObserver cartObserver = new CartObserver();

    @BeforeEach
    public void init() {
        cartObserver.addObserver(new EmailNotification());
        cartObserver.addObserver(new MobileNotification());
    }

    @Test
    public void shouldUpdateAllObservers() {
        cartObserver.update("Message");
    }

}
