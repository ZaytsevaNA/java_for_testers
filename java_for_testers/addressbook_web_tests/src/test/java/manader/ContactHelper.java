package manader;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("home"));
        }
    }

    public void createContact(ContactData contact) {
        openHomePage();
        initGroupCreation();
        fillContacttForm(contact);
        sudmitContactCreation();
        returnToContactPage();
    }

    public void modifyContact(ContactData contact,ContactData modifiedFirstName) {
        openHomePage();
        initContactModification(contact);
        fillContacttForm(modifiedFirstName);
        updateContact();
        returnToContactPage();
    }

    private void returnToContactPage() {
        click(By.linkText("home page"));
    }

    private void initGroupCreation() {
        click(By.linkText("add new"));
    }

    private void updateContact() {
        click(By.name("update"));
    }

    private void sudmitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContacttForm(ContactData contact) {
        type(By.name("lastname"), contact.last_name());
        type(By.name("firstname"), contact.first_name());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.e_mail());
        type(By.name("mobile"), contact.mobile());

    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        deletContact();
    }

    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("a[href=\'edit.php?id=%s\']", contact.id())));
    }

    public void deletContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
        manager.driver.switchTo().alert().accept();
    }

    public int getCountContact() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContact() {
        openHomePage();
        allContact();
        deletContact();
    }

    private void allContact() {
        click(By.id("MassCB"));
    }

    public List<ContactData> getList() {
        openHomePage();
        var contact = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.xpath("//tr[@name=\'entry\']"));
        for (var tr : trs) {
            var last_name = tr.getText();
            var first_name = tr.getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contact.add(new ContactData().withId(id).withLastName(last_name));

        }
        return contact;
    }
}



