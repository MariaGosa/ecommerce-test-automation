
package pl.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartTitle =
            By.cssSelector("[data-test='title']");

    private final By backpackName =
            By.id("item_4_title_link");

    private final By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    public String getCartTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartTitle)
        ).getText();
    }

    public boolean containsBackpack() {
        return !driver.findElements(backpackName).isEmpty();
    }

    public boolean isBackpackInCart() {
        return containsBackpack();
    }

    public void clickCheckout() {
        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();
    }
}
