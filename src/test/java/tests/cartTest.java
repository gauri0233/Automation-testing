// tests/cartTest.java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.cartItem;

public class cartTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
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

        // 4. Close browser at the end
        driver.quit();
    }
}