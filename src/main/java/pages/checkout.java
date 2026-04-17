// pages/checkout.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class checkout {

    WebDriver driver;
    WebDriverWait wait;

    public checkout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Click Checkout button on cart page
    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout"))).click();
        System.out.println("STEP: Clicked Checkout button");
    }

    // Fill shipping details
    public void fillDetails(String firstName, String lastName, String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("first-name"))).sendKeys(firstName);
        System.out.println("STEP: Entered First Name - " + firstName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("last-name"))).sendKeys(lastName);
        System.out.println("STEP: Entered Last Name - " + lastName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("postal-code"))).sendKeys(zip);
        System.out.println("STEP: Entered Postal Code - " + zip);
    }
    // ✅ FIXED: use By.id and elementToBeClickable for Continue button
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("continue"))).click();
        System.out.println("STEP: Clicked Continue button");
    }

    // Click Finish button
    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("finish"))).click();
        System.out.println("STEP: Clicked Finish button");
    }

    // Get confirmation message
    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("complete-header"))).getText();
    }
}