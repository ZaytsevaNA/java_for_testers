package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canContactRemove() {
        app.openHomePage();
        if (!app.isContactPresent()) {
            app.createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        app.removeContact();
    }
}
