package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canContactRemove() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        app.contact().removeContact();
    }
}
