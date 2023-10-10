package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import tests.TestBase;

public class ContactCreationsTests extends TestBase {

    @Test
    public void canContactCreations() {
        app.openAddNewPage();
        app.createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
    }

    @Test
    public void canContactEmptyCreations() {
        app.openAddNewPage();
        app.createContact(new ContactData());
    }

    @Test
    public void canCreateContactwithFirstNameOnly() {
        app.openAddNewPage();
        var emptyContact = new ContactData();
        var contactWithFirstName = emptyContact.withFirstName("Anna");
        app.createContact(contactWithFirstName);
    }
}

