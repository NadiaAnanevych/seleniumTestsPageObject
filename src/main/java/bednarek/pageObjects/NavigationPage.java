package bednarek.pageObjects;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {
    private static final String NAVIGATION_URL = "navigation1.html";


    //By textBlock = By.className("lead");
    @FindBy(className="lead")
    private WebElement textBlock;
    //WebElement previousPage = driver.findElement(By.xpath("//a[text() = \"Previous\"]/parent::li[@class='page-item disabled']"));
    @FindBy(xpath = "//a[text() = \"Previous\"]/parent::li[@class='page-item disabled']")
    private WebElement previousPage;
    //WebElement nextButton = driver.findElement(By.xpath("//a[text() = \"Next\"]"));
    @FindBy(linkText = "Next")
    private WebElement nextButton;


    public NavigationPage(WebDriver driver) {

        super(driver);
    }


    @Step("get nav url")
    public String getUrl() {

        return NAVIGATION_URL;
    }

    @Step("get text block")
    public String getTextBlock() {
        return textBlock.getText();
    }

    @Step("checking whether previous button is disabled")
    public boolean isPreviousButtonDisabled() {
        return previousPage.getDomAttribute("class").contains("disabled");
    }

    @Step("go to next page")
    public void goToNextPage() {
        nextButton.click();
    }
}
