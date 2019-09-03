package Selenium_Task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.tripadvisor.in/Flights-o304554-From_Mumbai-Cheap_Discount_Airfares.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='prw_rup prw_flights_trip_search_typeahead ui_column is-6-desktop is-6-tablet rtTypeahead']//input[@placeholder='To where?']"))
				.sendKeys("New Delhi");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"roundtrip_picker\"]/div[1]")).click();
		Thread.sleep(2000);
		String date = "10-October 2019";
		String splitter[] = date.split("-");
		String checkInmonth_year = splitter[1];
		String checkInday = splitter[0];
		//System.out.println(month_year);
		//System.out.println(day);
		driver.findElement(By.xpath("//span[contains(text(),'October 2019')]")).click();
		
	}

}
