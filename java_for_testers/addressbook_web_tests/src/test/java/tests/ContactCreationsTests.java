package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationsTests extends TestBase {

    @Test
    public void canContactCreations() {
        app.contact().createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
    }

    @Test
    public void canContactEmptyCreations() {
        app.contact().createContact(new ContactData());
    }

    @Test
    public void canCreateContactwithFirstNameOnly() {
        app.contact().createContact(new ContactData().withFirstName("Anna"));
    }
}

