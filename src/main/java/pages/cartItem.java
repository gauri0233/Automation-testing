// pages/cartItem.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class cartItem {

    private WebDriver driver;
    private WebDriverWait wait;

    public cartItem(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By addBackpack  = By.id("add-to-cart-sauce-labs-backpack");
    private By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBadge    = By.className("shopping_cart_badge");
    private By cartIcon     = By.xpath("//a[@class='shopping_cart_link']");
    private By cartPage     = By.xpath("//button[@id='checkout']"); // wait for this after going to cart

    public void addTwoProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(addBackpack)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addBikeLight)).click();
    }

    public String getCartBadgeCount() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge)
        ).getText();
    }

    // ✅ FIXED: wait until checkout button is visible after going to cart
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage)); // wait for cart page to load
        System.out.println("STEP: Cart page loaded");
    }
}