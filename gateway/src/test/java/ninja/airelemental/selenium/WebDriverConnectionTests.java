package ninja.airelemental.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebDriverConnectionTests {


//  WebDriver driverFox = new FirefoxDriver();
//  WebDriver driverChrome = new ChromeDriver();


  public static void main(String[] args) {

//    WebDriver driver = new ChromeDriver();
//    try {
//      driver.get("https://example.com");
//      // Get all the elements available with tag name 'p'
//      List<WebElement> elements = driver.findElements(By.tagName("p"));
//      for (WebElement element : elements) {
//        System.out.println("Paragraph text:" + element.getText());
//      }
//    } finally {
//      driver.quit();
//    }


    System.setProperty("webdriver.gecko.driver","D:\\Git Not Repo Example Code\\Selenium Driver Folder\\WebDriver\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver();
//    Long secDur = 10L; //Duration.ofSeconds(10);
//    WebDriverWait wait = new WebDriverWait(driver, secDur);
    try {
      driver.get("https://google.com/");
//      driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
//      WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
//      System.out.println(firstResult.getAttribute("textContent"));
      List<WebElement> elements = driver.findElements(By.name("name"));
      System.out.println("Number of elements:" + elements.size());

      for (int i=0; i<elements.size();i++){
        System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
      }
    } finally {
      driver.quit();
    }
  }

}
