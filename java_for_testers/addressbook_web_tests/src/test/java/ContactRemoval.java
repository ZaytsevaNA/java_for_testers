import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemoval extends TestBase1 {

    @Test
    public void canContactRemove() {
        openHomePage();
        if (!isContactPresent()) {
            createContact(new ContactData("contact_first_name", "contact_last_name", "contact_address", "contact_mobile", "contact_e_mail"));
        }
        removeContact();
    }
}
