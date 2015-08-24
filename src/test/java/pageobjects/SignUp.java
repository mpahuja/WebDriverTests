package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.Common;

public class SignUp extends Common{

    private final WebDriver driver;
//    private Common common;
    
    By emailAddress = By.name("emailAddress");
    By signUpButton = By.className("userSignupButton");
    By signUpConfirmation = By.className("signupConfirmationPanel");

    public SignUp(WebDriver driver) {
    	super();
        this.driver = driver;
    }
    
    public void enterEmail(String email){
    	driver.findElement(emailAddress).sendKeys(email);
    }
    
    public void enterInValidEmail(){
    	String inValidEmail = "123atabc";
    	driver.findElement(emailAddress).sendKeys(inValidEmail);
    }
    
    
    
    public void clickSignUp(){
    	driver.findElement(signUpButton).click();
    }

    public Boolean isSignUpConfirmationDisplayed() {
        return waitForIsDisplayed(driver,signUpConfirmation, 10);
    }
    
}