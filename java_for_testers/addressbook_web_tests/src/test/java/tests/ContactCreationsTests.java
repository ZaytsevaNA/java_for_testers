package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationsTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var first_name : List.of("", "first_name")) {
            for (var last_name : List.of("", "last_name")) {
                for (var address : List.of("", "address")) {
                    for (var mobile : List.of("", "mobile")) {
                        for (var e_mail : List.of("", "e_mail")) {
                                result.add(new ContactData()
                                        .withFirstName(first_name)
                                        .withLastName(last_name)
                                        .withAddress(address)
                                        .withEmail(e_mail)
                                        .withMobile(mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(CommonFunctions.randomString(i * 10))
                    .withLastName(CommonFunctions.randomString(i * 10))
                    .withAddress(CommonFunctions.randomString(i * 10))
                    .withMobile(CommonFunctions.randomString(i * 10))
                    .withEmail(CommonFunctions.randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultupleContact(ContactData contact) {
        var oldContact = app.contact().getList();
        app.contact().createContact(contact);
        var newContact = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        var expectedTable = new ArrayList<>(oldContact);
        expectedTable.add(contact.withId(newContact.get(newContact.size() - 1).id())
                .withAddress("")
                .withMobile("")
                .withEmail("")
                .withPhoto("src/test/resources/images/avatar.png"));
        expectedTable.sort(compareById);
        Assertions.assertEquals(newContact, expectedTable);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "first_name'", "", "", "", "", "src/test/resources/images/avatar.png")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        var oldContact = app.contact().getList();
        app.contact().createContact(contact);
        var newContact = app.contact().getList();
        Assertions.assertEquals(newContact, oldContact);
    }

    @Test
    public void canCreateContacts() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
                .withMobile(CommonFunctions.randomString(10))
                .withEmail(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contact().createContact(contact);
    }
}
