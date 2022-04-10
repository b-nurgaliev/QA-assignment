//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.net.MalformedURLException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class GoogleSearch {
//
//	public static void main(String[] args) throws InterruptedException, MalformedURLException {
//		// Set Driver path
//		System.setProperty("webdriver.chrome.driver", "/Users/bulatn/Downloads/chromedriver/chromedriver");
//		WebDriver driver = new ChromeDriver();
//
//		//open google
//		driver.get("http://localhost:8000/");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		//enter "java" in search box
//		driver.findElement(By.name("q")).sendKeys("java");
//
//
//		//wait for suggestions
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("wM6W7d")));
//
//		List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
//
//		System.out.println(list.size());
//
//		for(int i = 0; i < list.size(); i++){
//
//			String listitem = list.get(i).getText();
//
//			System.out.println(listitem);
//			if(listitem.contains("java 8")){
//				list.get(i).click();
//				break;
//			}
//		}
//	}
//}
