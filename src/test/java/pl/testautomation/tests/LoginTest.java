
package pl.testautomation.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testautomation.pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login("standard_user", "secret_sauce");

        boolean redirected = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        ).until(
                ExpectedConditions.urlContains("inventory.html")
        );

        assertTrue(
                redirected,
                "Po poprawnym logowaniu powinna otworzyć się lista produktów"
        );
    }
}
