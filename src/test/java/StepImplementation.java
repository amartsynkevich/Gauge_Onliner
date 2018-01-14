import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class StepImplementation {
    private final By loginButtonLocator = By.cssSelector("div.auth-bar__item:nth-child(1)");
    private final By loginFieldLocator = By.cssSelector("div.auth-box__part:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
    private final By passwordFieldLocator = By.cssSelector("div.auth-box__part:nth-child(1) > div:nth-child(2) > input:nth-child(1)");
    private final By enterButtonLocator = By.cssSelector("div.auth-box__field > form > div:nth-child(3) > div > button");
    private final By phoneLinkLocator = By.cssSelector("div.schema-product__part.schema-product__part_2 >" +
            " div.schema-product__part.schema-product__part_4 > div.schema-product__title > a");
    private final By offersLocator = By.cssSelector("div.offers-description__part.offers-description__part_1 > a");
    private final By buttonBasketLocator = By.linkText("В корзину");
    private final By basketOpenLocator = By.xpath("//*[@id=\"b-top-navigation-cart\"]/li/a/span");
    private final By basketPageLocator = By.xpath("//*[@id=\"cart-main-container\"]/div[3]/div[2]/a");
    private final By productLocator = By.cssSelector("div.cart-product__part.cart-product__part_2 > div.cart-product-title > div > span");
    private final WebDriver driver = Driver.driver;

    @Step("Open URL")
    public void getUrl() {
        driver.get("https://catalog.onliner.by/mobile");
   }

    @Step("Open page and find login button")
    public void getLoginButton() {
        waitCssSearch(driver, loginButtonLocator);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    @Step("Enter login and password")
    public void loginAndPassword() {
        waitCssSearch(driver, loginFieldLocator);
        WebElement loginField = driver.findElement(loginFieldLocator);
        loginField.sendKeys("fanhead86");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("123onliner");
        WebElement enterButton = driver.findElement(enterButtonLocator);
        enterButton.click();
        try {
            sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Step("Choose phone")
    public void choosePhoneLink () {
        waitCssSearch(driver, phoneLinkLocator);
        WebElement phoneLink = driver.findElement(phoneLinkLocator);
        phoneLink.click();
    }

    @Step("Open phone offers")
    public void openOffersPage () {
        waitCssSearch(driver, offersLocator);
        WebElement offersLink = driver.findElement(offersLocator);
        offersLink.click();
    }

    @Step("Put phone in basket")
    public void putPhoneInBasket () {
        waitLinkTextSearch(driver, buttonBasketLocator);
        WebElement buttonBasket = driver.findElement(buttonBasketLocator);
        buttonBasket.click();
    }

    @Step("Open basket")
    public void openBasket () {
        waitXpathSearch(driver, basketOpenLocator);
        WebElement basketOpen = driver.findElement(basketOpenLocator);
        basketOpen.click();
    }

    @Step("Check phone in basket")
    public void checkPhoneInBasket() {
        waitXpathSearch(driver, basketPageLocator);
        WebElement product = driver.findElement(productLocator);
    }

    private void waitCssSearch(WebDriver driver, final By cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(cssSelector) != null) ? Boolean.TRUE : null;
            }
        });
    }

    private void waitLinkTextSearch(WebDriver driver, final By linkText) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(linkText) != null) ? Boolean.TRUE : null;
            }
        });
    }

    private void waitXpathSearch(WebDriver driver, final By xPath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (driver.findElement(xPath) != null) ? Boolean.TRUE : null;
            }
        });
    }
}
