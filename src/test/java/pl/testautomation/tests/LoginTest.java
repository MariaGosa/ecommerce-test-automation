
package pl.testautomation.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.testautomation.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    void shouldLoginWithValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(
                loginPage.getCurrentUrl().contains("inventory.html"),
                "Po poprawnym logowaniu powinna otworzyć się lista produktów"
        );
    }

    @Test
    void shouldShowErrorWhenPasswordIsInvalid() {
        loginPage.login("standard_user", "wrong_password");

        String errorMessage = loginPage.getErrorMessage();

        assertTrue(
                errorMessage.contains("Username and password do not match"),
                "Powinien pojawić się komunikat o nieprawidłowym loginie lub haśle"
        );
    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
