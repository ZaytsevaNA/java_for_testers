import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase {

    @Test
    public void canCreateGroup() {
        openGroupPage();
        createGroup(new GroupData("group name", "group header", "group footer"));
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupPage();
        createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        openGroupPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        createGroup(groupWithName);
    }
}
