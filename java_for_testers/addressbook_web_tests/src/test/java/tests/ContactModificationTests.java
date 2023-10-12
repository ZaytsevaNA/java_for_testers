package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void canModifyContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        app.contact().modifyContact(new ContactData().withFirstName("modified first name"));
    }
}
