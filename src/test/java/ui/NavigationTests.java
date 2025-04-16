package ui;

import bednarek.pageObjects.HomePage;
import bednarek.pageObjects.NavigationPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import static bednarek.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Story("navigation test")
public class NavigationTests extends BaseTest{




    @Test
    void openNavigationTest(){
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String navUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + navUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }


    @Test
    void checkTextTest() {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        WebElement textBlock = navigationPage.getTextBlock();

        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", textBlock.getText());
    }

    @Test
    void previousButtonDisabledTest(){
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        boolean isPreviousDisabled = navigationPage.isPreviousButtonDisabled();

        assertTrue(isPreviousDisabled);
    }

    @Test
    void clickNextButtonTest() {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        navigationPage.goToNextPage();
        String currentUrl = navigationPage.getCurrentUrl();

        assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation2.html", currentUrl);
    }

}
