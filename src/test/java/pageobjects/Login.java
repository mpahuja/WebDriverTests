package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.Common;

public class Login extends Common{

    private final WebDriver driver;
    By signUpLink = By.cssSelector("a[href*='./signup");
    By email = By.id("username");

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    
    public void waitForEmailField(){
    	waitForElement(driver,email,10);
    }
    
    public SignUp clickSignup(){
    	driver.findElement(signUpLink).click();
    	return new SignUp(driver);
    }
}