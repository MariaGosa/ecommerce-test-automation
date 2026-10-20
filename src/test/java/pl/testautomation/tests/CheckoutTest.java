
package pl.testautomation.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.testautomation.pages.CartPage;
import pl.testautomation.pages.CheckoutPage;
import pl.testautomation.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

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
    void shouldCompleteOrderSuccessfully() {

        // Krok 1: Dodanie produktu do koszyka
        productsPage.addBackpackToCart();

        // Krok 2: Otwarcie koszyka
        productsPage.openCart();

        // Krok 3: Sprawdzenie zawartości koszyka
        assertEquals(
                "Your Cart",
                cartPage.getCartTitle(),
                "Tytuł strony koszyka powinien być poprawny"
        );

        assertTrue(
                cartPage.isBackpackInCart(),
                "Plecak powinien znajdować się w koszyku"
        );

        // Krok 4: Przejście do checkout
        cartPage.clickCheckout();

        // Krok 5: Wypełnienie danych klienta
        checkoutPage.enterCustomerDetails(
                "Jan",
                "Kowalski",
                "00001"
        );

        // Krok 6: Przejście do podsumowania zamówienia
        checkoutPage.clickContinue();

        assertEquals(
                "Checkout: Overview",
                checkoutPage.getPageTitle(),
                "Powinna wyświetlić się strona podsumowania zamówienia"
        );

        // Krok 7: Złożenie zamówienia
        checkoutPage.clickFinish();

        // Krok 8: Sprawdzenie potwierdzenia zamówienia
        assertEquals(
                "Thank you for your order!",
                checkoutPage.getConfirmationMessage(),
                "Zamówienie powinno zostać złożone poprawnie"
        );
    }
}
