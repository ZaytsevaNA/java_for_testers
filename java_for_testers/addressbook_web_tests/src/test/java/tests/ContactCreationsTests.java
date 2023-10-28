package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationsTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var first_name : List.of("", "contact first_name")) {
            for (var last_name : List.of("", "contact last_name")) {
                for (var address : List.of("", "contact address")) {
                    for (var mobile : List.of("", "contact mobile")) {
                        for (var e_mail : List.of("", "contact e_mail")) {
                            result.add(new ContactData().withFirstName(first_name)
                                    .withLastName(last_name)
                                    .withAddress(address)
                                    .withMobile(mobile)
                                    .withEmail(e_mail));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData().withFirstName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withAddress(randomString(i * 10))
                    .withMobile(randomString(i * 10))
                    .withEmail(randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultupleContac(ContactData contact) {
        int contactCount = app.contact().getCountContact();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact first_name'", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        int contactCount = app.contact().getCountContact();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getCountContact();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}

