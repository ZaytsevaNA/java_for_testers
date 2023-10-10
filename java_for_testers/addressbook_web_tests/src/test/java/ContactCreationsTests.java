import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class ContactCreationsTests extends TestBase1 {

    @Test
    public void canContactCreations() {
        openAddNewPage();
        createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
    }

    @Test
    public void canContactEmptyCreations() {
        openAddNewPage();
        createContact(new ContactData());
    }

    @Test
    public void canCreateContactwithFirstNameOnly() {
        openAddNewPage();
        var emptyContact = new ContactData();
        var contactWithFirstName = emptyContact.withFirstName("Anna");
        createContact(contactWithFirstName);
    }

}

