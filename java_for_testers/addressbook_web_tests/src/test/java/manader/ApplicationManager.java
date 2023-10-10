package manader;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ApplicationManager {
    protected static WebDriver driver;

    public void init() {
        if (driver == null) {
            var service = ChromeDriverService.createDefaultService();
            service.setExecutable("c:/windows/system32/chromedriver.exe");
            driver = new ChromeDriver(service);
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1936, 1048));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createGroup(GroupData group) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(group.name());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(group.header());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    public void openGroupPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void removeGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
    }

    public void openAddNewPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    public void openHomePage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("home")).click();
        }
    }

    public void createContact(ContactData contact) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(contact.first_name());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(contact.last_name());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys(contact.address());
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).sendKeys(contact.mobile());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(contact.e_mail());
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("home page")).click();

    }

    public boolean isContactPresent() {
        return isElementPresent(By.xpath("//img[@alt=\'Edit\']"));
    }

    public void removeContact() {
        driver.findElement(By.xpath("//img[@alt=\'Edit\']")).click();
        driver.findElement(By.xpath("(//input[@name=\'update\'])[3]")).click();
    }
}
