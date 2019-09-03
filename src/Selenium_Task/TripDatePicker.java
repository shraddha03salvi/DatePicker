package Selenium_Task;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TripDatePicker {
	WebDriver driver;

	@Test
	public void FromValueSelection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.tripadvisor.in/CheapFlightsHome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='taplc_trip_search_home_flights_0']/div[2]/div/div[1]/ul/li[2]/div/a"))
				.click();
		Thread.sleep(3000);

		driver.findElement(By
				.xpath("//div[@class='tabContent oneWay active']/div/div/div/div/input[@class='query origWithLabel']"))
				.clear();
		driver.findElement(By
				.xpath("//div[@class='tabContent oneWay active']/div/div/div/div/input[@class='query origWithLabel']"))
				.sendKeys("GOI");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='tabContent oneWay active']/div/div/div/div[2]/input[2]")).clear();
		driver.findElement(By.xpath("//div[@class='tabContent oneWay active']/div/div/div/div[2]/input[2]"))
				.sendKeys("BOM");
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='ow_ui_picker']")).click();
		Thread.sleep(3000);

		String date = "10-Oct 2019";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];
		selectDate(month_year, day);

	 driver.quit();

	}

	public void selectDate(String monthyear, String Selectday) throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='rsdc-month']/span[1]"));

		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());
			// Selecting the month
			if (elements.get(i).getText().equals(monthyear)) {
				// Selecting the date
				List<WebElement> days = driver.findElements(By.xpath("//div[@class='rsdc-months']/span[2]/span"));

				for (WebElement d : days) {
					System.out.println(d.getText());
					if (d.getText().equals(Selectday)) {
						d.click();
						Thread.sleep(10000);
						return;
					}
				}

			}

		}
		driver.findElement(By.xpath("//div[@class='rsdc-wrapper rsdc-dual-month']/div[2]/div[1]")).click();
		selectDate(monthyear, Selectday);

	}

}
