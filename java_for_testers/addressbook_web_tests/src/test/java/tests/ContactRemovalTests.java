package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData("", "first_name", "last_name", "address", "mobile", "e_mail", "src/test/resources/images/avatar.png"));
        }
        var oldContact = app.contact().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        app.contact().removeContact(oldContact.get(index));
        var newContact = app.contact().getList();
        var expectedTable = new ArrayList<>(oldContact);
        expectedTable.remove(index);
        Assertions.assertEquals(newContact, expectedTable);
    }

    @Test
    public void canRemoveAllContactAtOnce() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData("", "first_name", "last_name", "address", "mobile", "e_mail","src/test/resources/images/avatar.png"));
        }
        app.contact().removeAllContact();
        Assertions.assertEquals(0, app.contact().getCountContact());
    }
}
