// tests/LoginTest.java
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Login loginPage = new Login(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Just to visually confirm input, keep browser open for a moment
        Thread.sleep(3000);
    }
}