package pageFactoryTests;
import bednarek.pageObjects.HomePage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTest extends BaseTest{


    @Test
    void openHomePageTest(){
        HomePage homePage = new HomePage(driver);
        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void openAllLinksTest() throws InterruptedException {
        int qtyLinks = 0;
        List<WebElement> chapters =  driver.findElements(By.cssSelector("h5.card-title"));
        for (WebElement chapter : chapters) {
            List<WebElement> links = chapter.findElements(By.xpath("./../a"));
            qtyLinks += links.size();
            System.out.println(chapter.getText());
            for (WebElement link : links) {
                System.out.println(link.getText());
                new Actions(driver).moveToElement(link).perform();
                link.click();
                Thread.sleep(1000);
                driver.navigate().back();
            }
        }
        assertEquals(6, chapters.size());
        assertEquals(27, qtyLinks);
    }
}