package selenide;

import bednarek.selenide.WebFormPage;
import bednarek.selenide.HomePage;
import static bednarek.pageObjects.HomePage.BASE_URL;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.value;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideTests {
    HomePage homePage;

    @BeforeEach
    void setup() {
        homePage = new HomePage();
    }

    @Test
    void openHomePageTest() {
        homePage.open();

        assertEquals(BASE_URL, homePage.getCurrentUrl());
    }

    @Test
    void openWebFormPageTest() {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        assertEquals(BASE_URL + webFormPage.getWebFormUrl(), webFormPage.getCurrentUrl());
        assertEquals("Hands-On Selenium WebDriver with Java", webFormPage.getWebTitle());
    }

    @Test
    void readonlyTextTest() {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.getReadonlyInput().shouldHave(value("Readonly input"));
    }


    @Test
    void submitFormTest() throws InterruptedException {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();
        webFormPage.submitForm();
        Thread.sleep(2000);
        assertEquals("Form submitted", webFormPage.getTitle());
    }

}
