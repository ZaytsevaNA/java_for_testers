import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreations extends TestBase1 {

    @Test
    public void canContactCreations() {
        openAddNewPage();
        createContact(new ContactData("contact_first_name", "contact_last_name", "contact_address", "contact_mobile", "contact_e_mail"));
    }

    @Test
    public void canContactEmptyCreations() {
        openAddNewPage();
        createContact(new ContactData("", "", "", "", ""));
    }
}

