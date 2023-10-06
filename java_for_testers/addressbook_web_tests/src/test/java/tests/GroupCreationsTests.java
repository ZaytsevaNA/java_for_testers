package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {

    @Test
    public void canCreateGroup() {
        app.openGroupPage();
        app.createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.openGroupPage();
        app.createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.openGroupPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }
}
