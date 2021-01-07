package core;

import com.codeborne.selenide.WebDriverRunner;
import configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected static Config config;

    @BeforeAll
    public static void setupAll() {
        config = Config.getInstance();

        WebDriverManager.chromedriver().setup();
        WebDriverRunner.setWebDriver(new ChromeDriver());
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Calling Tear Down All");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Calling Setup for each");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Calling Tear Down  for each");
        WebDriverRunner.webdriverContainer.closeWebDriver();
    }

}
