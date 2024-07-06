package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasicTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
    String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "chrome":
        default:
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
    }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
}

    @After
    public void teardown() {
        driver.quit();
    }
}
