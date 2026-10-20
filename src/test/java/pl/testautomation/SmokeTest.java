
package pl.testautomation.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmokeTest extends BaseTest {

    @Test
    void shouldOpenSauceDemoPage() {
        driver.get("https://www.saucedemo.com/");

        String actualTitle = driver.getTitle();

        assertEquals(
                "Swag Labs",
                actualTitle,
                "Strona SauceDemo powinna mieć tytuł 'Swag Labs'"
        );
    }
}
