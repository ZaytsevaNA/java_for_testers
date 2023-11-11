package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    public void canModifyContact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData("", "firstname", "lastname", "address", "mobile", "email", "src/test/resources/images/avatar.png"));
        }
        var oldContact = app.contact().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testData = new ContactData().withFirstName("modified firstname");
        app.contact().modifyContact(oldContact.get(index), testData);
        var newContact = app.contact().getList();
        var expectedTable = new ArrayList<>(oldContact);
        expectedTable.set(index, testData.withId(oldContact.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        expectedTable.sort(compareById);
        Assertions.assertEquals(newContact, expectedTable);
    }
}