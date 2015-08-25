package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pageobjects.Home;
import pageobjects.Login;
import pageobjects.SignUp;

@RunWith(value = Parameterized.class)
public class SignUpNegativeTest extends BaseTest {

    private Home home;
	private String email;

    @Before
    public void setUp() {
        home = new Home(driver);
    }
    
    @Parameters
    public static Collection testData() {
    return Arrays.asList(new Object[][] {
    { "plainaddress" },
    { "#@%^%#$@#$@#.com" },
    { "@domain.com" },
    {"Joe Smith <email@domain.com>"},
    {"email.domain.com"},
    {"email@domain@domain.com"},
    {".email@domain.com"},
    {"email.@domain.com"},
    {"email..email@domain.com"},
    {"あいうえお@domain.com"},
    {"email@domain.com (Joe Smith)"},
    {"email@domain"},
    {"email@-domain.com"},
    {"email@domain.web"},
    {"email@111.222.333.44444"},
    {"email@domain..com"} });
    }
     
    public SignUpNegativeTest(String email) {
    	this.email = email;
    }
    
    @Test
    public void testSignUpInvalidEmail() {
    	home.goToHomePage();
    	Login login = home.clickLogin();
    	login.waitForEmailField();
        SignUp signUp = login.clickSignup();
        signUp.enterEmail(email);
        signUp.clickSignUp();
        assertTrue(signUp.isEmailInValidErrorDisplayed());
    }
}