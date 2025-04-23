package bednarek.selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    @Step("get web-form url")
    public String getWebFormUrl() {
        return WEB_FORM_URL;
    }


    @Step("Get readonly input")
    public SelenideElement getReadonlyInput() {
        return $(By.name("my-readonly"));
    }

    @Step("submit form")
    public void submitForm() {

        actions().moveToElement($(By.tagName("button"))).perform();

        $(By.tagName("button")).click();
    }

}
