package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.Base;

public class Home extends Base {

    private final WebDriver driver;
    By loginLink = By.cssSelector("a[href*='https://www.appdirect.com/login']");

    public Home(WebDriver driver) {
    	super();
        this.driver = driver;
    }
    
    public void goToHomePage(){
        driver.get("http://www.appdirect.com");
    }
    
    public Login clickLogin(){
    	driver.findElement(loginLink).click();
    	return new Login(driver);
    }

}