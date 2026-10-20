
package pl.testautomation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.testautomation.pages.CartPage;
import pl.testautomation.pages.CheckoutPage;
import pl.testautomation.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutValidationTest extends BaseTest {

    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    void setUpPages() {
        loginAsStandardUser();

        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    void shouldShowErrorWhenFirstNameIsMissing() {

        productsPage.addBackpackToCart();
        productsPage.openCart();

        assertEquals(
                "Your Cart",
                cartPage.getCartTitle()
        );

        assertTrue(
                cartPage.containsBackpack(),
                "Plecak powinien znajdować się w koszyku"
        );

        cartPage.clickCheckout();

        assertEquals(
                "Checkout: Your Information",
                checkoutPage.getPageTitle()
        );

        checkoutPage.enterCustomerDetails(
                "",
                "Kowalski",
                "00001"
        );

        // Upewniamy się, że imię faktycznie jest puste.
        assertEquals(
                "",
                checkoutPage.getFirstNameValue(),
                "Pole First Name powinno pozostać puste"
        );

        checkoutPage.clickContinue();

        // Jeśli błąd się nie pojawi, wyświetlamy informacje diagnostyczne.
        assertTrue(
                checkoutPage.isErrorMessageDisplayed(),
                "Nie pojawił się komunikat walidacyjny. "
                        + "Aktualny adres: "
                        + checkoutPage.getCurrentUrl()
        );

        assertEquals(
                "Error: First Name is required",
                checkoutPage.getErrorMessage()
        );
    }
}
