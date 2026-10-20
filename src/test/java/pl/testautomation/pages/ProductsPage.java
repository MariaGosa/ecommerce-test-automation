
package pl.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageTitle =
            By.cssSelector("[data-test='title']");

    private final By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private final By shoppingCartBadge =
            By.cssSelector("[data-test='shopping-cart-badge']");

    private final By shoppingCartLink =
            By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    public String getPageTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageTitle)
        ).getText();
    }

    public void addBackpackToCart() {
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(backpackAddButton)
        );

        button.click();
    }

    public int getCartItemCount() {
        List<WebElement> badges =
                driver.findElements(shoppingCartBadge);

        if (badges.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(badges.get(0).getText());
    }

    public void openCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(shoppingCartLink)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );
    }
}
