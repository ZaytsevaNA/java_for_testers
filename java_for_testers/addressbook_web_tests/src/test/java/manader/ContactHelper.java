package manader;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {
    private final ApplicationManager manager;

    public ContactHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    public void openAddNewPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public void openHomePage() {
        if (!manager.isElementPresent(By.name("new"))) {
            manager.driver.findElement(By.linkText("home")).click();
        }
    }

    public void createContact(ContactData contact) {
        openHomePage();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.first_name());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.last_name());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.e_mail());
        manager.driver.findElement(By.name("submit")).click();
        manager.driver.findElement(By.linkText("home page")).click();

    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.xpath("//img[@alt=\'Edit\']"));
    }

    public void removeContact() {
        openHomePage();
        manager.driver.findElement(By.xpath("//img[@alt=\'Edit\']")).click();
        manager.driver.findElement(By.xpath("(//input[@name=\'update\'])[3]")).click();
    }
}
