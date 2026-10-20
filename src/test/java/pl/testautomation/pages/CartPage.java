
package pl.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cartTitle = By.cssSelector("[data-test='title']");
    private final By backpackItem = By.id("item_4_title_link");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCartTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartTitle)
        ).getText();
    }

    public boolean containsBackpack() {
        return !wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(backpackItem)
        ).isEmpty();
    }
}
