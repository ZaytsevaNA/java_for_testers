import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase1 {

    @Test
    public void canContactRemove() {
        openHomePage();
        if (!isContactPresent()) {
            createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        removeContact();
    }
}
