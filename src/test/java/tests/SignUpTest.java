package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pageobjects.Home;
import pageobjects.Login;
import pageobjects.SignUp;

public class SignUpTest extends BaseTest {

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