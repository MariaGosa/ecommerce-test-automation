
package pl.testautomation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.testautomation.pages.CartPage;
import pl.testautomation.pages.LoginPage;
import pl.testautomation.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeEach
    void setUpPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        loginAsStandardUser();
    }

    @Test
    void shouldAddBackpackToCart() {
        assertEquals("Products", productsPage.getPageTitle());

        productsPage.addBackpackToCart();

        assertEquals(1, productsPage.getCartItemCount());

        productsPage.openCart();

        assertEquals("Your Cart", cartPage.getCartTitle());

        assertTrue(
                cartPage.containsBackpack(),
                "Koszyk powinien zawierać Sauce Labs Backpack"
        );
    }
}
