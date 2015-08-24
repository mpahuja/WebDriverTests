//package tests;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import pageobjects.Login;
//
//public class TestLogin {
//
//    private WebDriver driver;
//    private Login login;
//
//    @Before
//    public void setUp() {
//        driver = new FirefoxDriver();
//        login = new Login(driver);
//    }
//
//    @Test
//    public void succeeded() {
//        login.with("tomsmith", "SuperSecretPassword!");
//        assertTrue("success message not present",
//                login.successMessagePresent());
//    }
//
//    @After
//    public void tearDown() {
//        driver.quit();
//    }
//}

package tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import pageobjects.Home;
import pageobjects.Login;
import pageobjects.SignUp;

public class TestLogin extends Base {

    private Home home;
	String randomEmail = randomEmail();

    @Before
    public void setUp() {
        home = new Home(driver);
    }

    @Test
    public void testSignUpValidEmail() {
    	home.goToHomePage();
    	Login login = home.clickLogin();
    	login.waitForEmailField();
        SignUp signUp = login.clickSignup();
        signUp.enterEmail(randomEmail);
        signUp.clickSignUp();
        assertTrue(signUp.isSignUpConfirmationDisplayed());
    }
    
    @Test
    public void testSignUpInvalidEmail() {
    	home.goToHomePage();
    	Login login = home.clickLogin();
    	login.waitForEmailField();
        SignUp signUp = login.clickSignup();
        signUp.enterEmail("123atabc");
        signUp.clickSignUp();
        assertFalse(signUp.isSignUpConfirmationDisplayed());
    }
    
    @Test
    public void testSignUpDuplicateEmail() {
    	home.goToHomePage();
    	Login login = home.clickLogin();
    	login.waitForEmailField();
        SignUp signUp = login.clickSignup();
        signUp.enterEmail("email@email.com");
        signUp.clickSignUp();
        assertFalse(signUp.isSignUpConfirmationDisplayed());
    }
}