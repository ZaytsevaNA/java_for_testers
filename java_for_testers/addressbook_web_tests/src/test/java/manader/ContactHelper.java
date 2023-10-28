package manader;

import model.ContactData;
import org.openqa.selenium.By;

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

    public void modifyContact(ContactData modifiedName) {
        openHomePage();
        editContact();
        fillContacttForm(modifiedName);
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
        type(By.name("firstname"), contact.first_name());
        type(By.name("lastname"), contact.last_name());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.e_mail());

    }

    public void removeContact() {
        openHomePage();
        dellOneContact();
        deletContact();
    }

    public void editContact() {
        openHomePage();
        click(By.xpath("//img[@alt=\'Edit\']"));
    }

    public void dellOneContact() {
        openHomePage();
        click(By.name("selected[]"));
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
}



