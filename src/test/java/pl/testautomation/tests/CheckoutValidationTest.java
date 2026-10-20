
package pl.testautomation.tests;

import org.junit.jupiter.api.Test;
import pl.testautomation.pages.CheckoutPage;
import pl.testautomation.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckoutValidationTest extends BaseTest {

    @Test
    void shouldShowErrorWhenFirstNameIsMissing() {
        loginAsStandardUser();

        ProductsPage productsPage = new ProductsPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        checkoutPage.startCheckout();

        checkoutPage.enterCustomerDetails(
                "",
                "Kowalski",
                "00-001"
        );

        checkoutPage.continueToOverview();

        assertTrue(
                checkoutPage.getErrorMessage()
                        .contains("First Name is required"),
                "Powinien pojawić się błąd, gdy imię nie zostało podane"
        );
    }
}
