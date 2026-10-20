
package pl.testautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private final WebDriver driver;

    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");
    private final By shoppingCartBadge =
            By.cssSelector("[data-test='shopping-cart-badge']");
    private final By shoppingCartLink =
            By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }

    public String getCartItemCount() {
        return driver.findElement(shoppingCartBadge).getText();
    }

    public void openCart() {
        driver.findElement(shoppingCartLink).click();
    }
}
