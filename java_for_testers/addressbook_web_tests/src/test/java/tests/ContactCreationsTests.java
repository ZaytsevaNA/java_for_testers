package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationsTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var last_name : List.of("", "last_name")) {
            for (var first_name : List.of("", "first_name")) {
                for (var address : List.of("", "address")) {
                    for (var e_mail : List.of("", "e_mail")) {
                        for (var mobile : List.of("", "mobile")) {
                            result.add(new ContactData()
                                    .withLastName(last_name)
                                    .withFirstName(first_name)
                                    .withAddress(address)
                                    .withMobile(e_mail)
                                    .withEmail(mobile));
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
                .withEmail("")
                .withMobile(""));
        expectedTable.sort(compareById);
        Assertions.assertEquals(newContact, expectedTable);
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "", "first_name'", "", "", "")));
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
}

