package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MailTests extends TestBase {

    @Test
    void canReceiveMail() {
        var messages = app.mail().receive("user1@localhost", "password");
        Assertions.assertEquals(1,messages.size());
        System.out.println(messages);
    }
}
