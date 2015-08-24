import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.facebook.com");
		driver.close();
		
	}
	
}
