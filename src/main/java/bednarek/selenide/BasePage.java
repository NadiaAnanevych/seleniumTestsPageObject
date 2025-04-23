package bednarek.selenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    @Step("Get web title")
    public String getWebTitle() {
        return Selenide.title();
    }

    @Step("Get title")
    public String getTitle() {
        return $(By.className ("display-6")).getText();

    }
    @Step("Get current url")
    public String getCurrentUrl() {
        return url();
    }
}
