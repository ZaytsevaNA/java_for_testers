import model.ContactData;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class TestBase1 {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
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

    protected void createContact(ContactData contact) {
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

    protected void openAddNewPage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("add new")).click();
        }
    }

    protected void openHomePage() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("home")).click();
        }
    }

    protected boolean isContactPresent() {
        return isElementPresent(By.xpath("//img[@alt=\'Edit\']"));
    }

    protected void removeContact() {
        driver.findElement(By.xpath("//img[@alt=\'Edit\']")).click();
        driver.findElement(By.xpath("(//input[@name=\'update\'])[3]")).click();
    }
}
