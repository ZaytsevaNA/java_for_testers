package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.contact().createContact(new ContactData("first_name", "last_name", "address", "mobile", "e_mail"));
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
