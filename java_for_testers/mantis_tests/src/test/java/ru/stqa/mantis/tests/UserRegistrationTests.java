package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.model.DeveloperMailUser;


public class UserRegistrationTests extends TestBase {

    DeveloperMailUser user;

    @Test
    void canRegisterUser() throws InterruptedException {
        var password = "password";
        user = app.developerMail().addUser();
        var email = String.format("%s@developermail.com", user.name());

//       app.session().signup(username, email);
//
//        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
//        var text = messages.get(0).content();
//        var pattern = Pattern.compile("http://\\S*");
//        var matcher = pattern.matcher(text);
//
//        var url = "";
//        if (matcher.find()) {
//            url = text.substring(matcher.start(),matcher.end());
//            System.out.println(url);
//        }
//        app.session().finishedRegistration(url, username, password);
//
//        Assertions.assertTrue(app.session().isLoggedIn());
//
//        app.http().login(username, password);
//        Assertions.assertTrue(app.http().isLoggedIn());

    }

    @AfterEach
    void deleteMailUser() {
        app.developerMail().deleteUser(user);
    }
}