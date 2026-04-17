// tests/checkoutTest.java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

import pages.Login;
import pages.cartItem;
import pages.checkout;

public class checkoutTest {

    public static void main(String[] args) {

        // 🔥 Added popup fix (ONLY ADDITION)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        // 🔥 Only this line changed
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 1. Login
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // 2. Add 2 products
        cartItem productsPage = new cartItem(driver);
        productsPage.addTwoProducts();

        // 3. Check cart badge
        String badge = productsPage.getCartBadgeCount();
        if (!"2".equals(badge)) {
            throw new AssertionError("Expected cart badge 2 but was: " + badge);
        }
        System.out.println("PASS: Cart badge is 2");

        // 4. Go to cart
        productsPage.goToCart();

        // 5. Checkout
        checkout checkoutPage = new checkout(driver);
        checkoutPage.clickCheckout();
        checkoutPage.fillDetails("Test", "Doe", "110001");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        // 6. Verify confirmation
        String message = checkoutPage.getConfirmationMessage();
        if (!"Thank you for your order!".equals(message)) {
            throw new AssertionError("Expected confirmation but got: " + message);
        }
        System.out.println("PASS: Order confirmed - " + message);

        // 7. Close browser
        // driver.quit();
    }
}