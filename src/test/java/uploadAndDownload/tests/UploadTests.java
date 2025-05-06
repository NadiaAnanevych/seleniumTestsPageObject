package uploadAndDownload.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uploadAndDownload.steps.BaseSteps;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UploadTests extends BaseSteps {


    @Test
    void fileInputTest() throws InterruptedException, IOException {
        WebDriver driver = getDriver();
        Actions actions;
        actions = new Actions(driver);
        String initUrl = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
        driver.get(initUrl);
        WebElement fileInput = driver.findElement(By.name("my-file"));
        File uploadFile = new File("src/main/resources/textFile");
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(By.tagName("button"));
        actions.moveToElement(submitButton).perform();
        submitButton.click();
        Thread.sleep(3000);
        assertThat(driver.getCurrentUrl()).isNotEqualTo(initUrl);
    }
}
