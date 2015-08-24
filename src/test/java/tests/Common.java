package tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

//    private WebDriver driver;
        
    public void waitForElement(WebDriver driver,By locator, Integer... timeout) {
        try {
            waitFor(driver,ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
        } catch (org.openqa.selenium.TimeoutException exception) {
        }
    }
    
    public Boolean waitForIsDisplayed(WebDriver driver,By locator, Integer... timeout) {
        try {
            waitFor(driver,ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    private void waitFor(WebDriver driver,ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 5;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    public String randomString(String chars, int length) {
	  Random rand = new Random();
	  StringBuilder buf = new StringBuilder();
	  for (int i=0; i<length; i++) {
	    buf.append(chars.charAt(rand.nextInt(chars.length())));
	  }
	  return buf.toString();
	}
    
    public String randomEmail(){
    	String generatedEmail = randomString("appdirect",10) + "@"+ randomString("direct",10) + ".com";
		return generatedEmail;
    	
    }

}
