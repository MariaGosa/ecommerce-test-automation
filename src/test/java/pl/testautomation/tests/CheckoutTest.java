
package pl.testautomation.tests;

import org.junit.jupiter.api.Test;
import pl.testautomation.pages.CartPage;
import pl.testautomation.pages.CheckoutPage;
import pl.testautomation.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutTest extends BaseTest {

    @Test
    void shouldCompleteOrderSuccessfully() {
        loginAsStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        assertEquals("Your Cart", cartPage.getCartTitle());

        checkoutPage.startCheckout();
        checkoutPage.enterCustomerDetails("Jan", "Kowalski", "00-001");
        checkoutPage.continueToOverview();

        assertEquals("Checkout: Overview", checkoutPage.getPageTitle());

        checkoutPage.finishOrder();

        assertEquals(
                "Thank you for your order!",
                checkoutPage.getConfirmationMessage()
        );
    }
}
