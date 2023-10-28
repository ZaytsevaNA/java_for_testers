package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveConact() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        int contactCount = app.contact().getCountContact();
        app.contact().removeContact();
        int newContactCount = app.contact().getCountContact();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    public void canRemoveAllContactAtOnce() {
        if (app.contact().getCountContact() == 0) {
            app.contact().createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        app.contact().removeAllContact();
        Assertions.assertEquals(0, app.contact().getCountContact());
    }
}
