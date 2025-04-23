package pageFactoryTests;

import bednarek.configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static bednarek.patterns.WebDriverFactory.createWebDriver;

/*public class BaseTest {
    WebDriver driver;*/
public class BaseTest {
    protected WebDriver driver;
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";


    @BeforeEach
    void setup() {
        driver = createWebDriver(configProperties.browser());
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void teardown() {

        driver.quit();
    }
}
