package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void canModifyGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
