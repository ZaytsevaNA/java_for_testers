package manader;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("searchstring"))) {
            click(By.linkText("home"));
        }
    }

    public void createContact(ContactData contact) {
        openHomePage();
        initContactCreation();
        fillContacttForm(contact);
        sudmitContactCreation();
        returnToContactPage();
    }

    public void createContact(ContactData contact, GroupData group) {
        openHomePage();
        initContactCreation();
        fillContacttForm(contact);
        selectGroup(group);
        sudmitContactCreation();
        returnToContactPage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void modifyContact(ContactData contact, ContactData modifiedFirstName) {
        openHomePage();
        initContactModification(contact);
        fillContacttForm(modifiedFirstName);
        updateContact();
        returnToContactPage();
    }

    private void returnToContactPage() {
        click(By.linkText("home page"));
    }

    private void initContactCreation() {
        click(By.linkText("add new"));
    }

    private void updateContact() {
        click(By.name("update"));
    }

    private void sudmitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContacttForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());
        attach(By.name("photo"), contact.photo());
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectAllGroupOnHomePage();
        selectContact(contact);
        deletContact();
        openHomePage();
    }

    public void deleteContactFromGroup(GroupData group) {
        click(By.linkText("home"));
        selectGroupOnHomePage(group);
        click(By.name("selected[]"));
        submitRemoveFromGroup();
        openHomePage();
    }

    public void addGroup(GroupData group) {
        click(By.linkText("home"));
        selectGroupForAddOnHomePage(group);
        click(By.name("selected[]"));
        submitAddFromGroup();
        click(By.linkText("home"));
    }

    private void selectGroupOnHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void selectAllGroupOnHomePage() {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue("");
    }

    private void selectGroupForAddOnHomePage(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void submitRemoveFromGroup() {
        click(By.xpath("//input[@name='remove']"));
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
        click(By.linkText("home"));
        selectAllGroupOnHomePage();
        selectAllContacts();
        deletContact();
        openHomePage();
    }

    private void selectAllContacts() {
        manager.driver
                .findElements(By.name("selected[]"))
                .forEach(WebElement::click);
    }

        private void submitAddFromGroup () {
            click(By.xpath("//input[@name='add']"));
        }

        private void allContact () {
            click(By.id("MassCB"));
        }

        public List<ContactData> getList () {
            openHomePage();
            var contact = new ArrayList<ContactData>();
            var trs = manager.driver.findElements(By.xpath("//tr[@name=\'entry\']"));
            for (var tr : trs) {
//            var first_name = tr.getText();
//            var last_name = tr.getText();
                var checkbox = tr.findElement(By.name("selected[]"));
                var id = checkbox.getAttribute("value");
                var last_name = tr.findElement(By.xpath("td[2]")).getText();
                var first_name = tr.findElement(By.xpath("td[3]")).getText();
                contact.add(new ContactData().withId(id).withFirstName(first_name).withLastName(last_name));
            }
            return contact;
        }
    }



