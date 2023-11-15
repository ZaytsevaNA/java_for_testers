package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.util.Properties;

public class ApplicationManager {
    private WebDriver driver;
    private String string;
    private Properties properties;
    private SessionHelper sessionHelper;

    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;
    }

    public WebDriver driver() {
        if (driver == null) {
            if ("chrome".equals(string)) {
                var service = ChromeDriverService.createDefaultService();
                service.setExecutable("c:/windows/system32/chromedriver.exe");
                driver = new ChromeDriver(service);
            } else if ("firefox".equals(string)) {
                var service = GeckoDriverService.createDefaultService();
                service.setExecutable("c:/windows/system32/geckodriver.exe");
                driver = new FirefoxDriver(service);
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %f", string));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1000, 1000));
            }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }

}
