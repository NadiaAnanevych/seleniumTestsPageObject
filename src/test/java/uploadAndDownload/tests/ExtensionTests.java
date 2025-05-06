package uploadAndDownload.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import uploadAndDownload.extensions.AllureExtension;
import uploadAndDownload.steps.AllureSteps;
import uploadAndDownload.steps.BaseSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Extensions")
@ExtendWith(AllureExtension.class)
public class ExtensionTests extends BaseSteps {

    @Test
    void signInTestSuccess(){
        WebDriver driver = getDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        WebElement loginField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        loginField.sendKeys("user");
        passwordField.sendKeys("user");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        WebElement message = driver.findElement(By.id("success"));

        assertEquals("Login successful", message.getText());
    }
    @Test
    void signInTestFailure(){
        WebDriver driver = getDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        WebElement loginField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        loginField.sendKeys("test");
        passwordField.sendKeys("test");
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        WebElement message = driver.findElement(By.id("success"));

        assertEquals("Login successful", message.getText());
    }

}
