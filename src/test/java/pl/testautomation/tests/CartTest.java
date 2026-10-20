
package pl.testautomation.tests;

import org.junit.jupiter.api.Test;
import pl.testautomation.pages.CartPage;
import pl.testautomation.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartTest extends BaseTest {

    @Test
    void shouldAddBackpackToCart() {
        loginAsStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        assertEquals("Products", productsPage.getPageTitle());

        productsPage.addBackpackToCart();

        assertEquals("1", productsPage.getCartItemCount());

        productsPage.openCart();

        assertEquals("Your Cart", cartPage.getCartTitle());
        assertTrue(
                cartPage.containsBackpack(),
                "Koszyk powinien zawierać Sauce Labs Backpack"
        );
    }
}
