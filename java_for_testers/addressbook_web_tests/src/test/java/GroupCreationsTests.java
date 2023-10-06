import org.junit.jupiter.api.Test;

public class GroupCreationsTests extends TestBase{

    @Test
    public void canCreateGroup() {
        openGroupPage();
        createGroup("group name", "group header", "group footer");
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupPage();
        createGroup("", "", "");
    }

}
