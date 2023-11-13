package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    public void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "firstname", "lastname", "src/test/resources/images/avatar.png", "", "", "", "","", "", "", "",""));
        }
        var oldContact = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContact.size());
        var testData = new ContactData().withFirstName("modified firstname");
        app.contact().modifyContact(oldContact.get(index), testData);
        var newContact = app.hbm().getContactList();
        var expectedTable = new ArrayList<>(oldContact);
        expectedTable.set(index, testData.withId(oldContact.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContact.sort(compareById);
        expectedTable.sort(compareById);
        Assertions.assertEquals(newContact, expectedTable);
    }

    @Test
    public void canAddGroupInContact() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "1", "2", "3"));
        }
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images")));
        }

        var group = app.hbm().getGroupList().get(0);

        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());

        app.contact().addGroup(group);

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };

        var newContacts = app.hbm().getContactList();
        newContacts.sort(compareById);
        oldContacts.sort(compareById);

        Assertions.assertEquals(newContacts, oldContacts);


    }
}