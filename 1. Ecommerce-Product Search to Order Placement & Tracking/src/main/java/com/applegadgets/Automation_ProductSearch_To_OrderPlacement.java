package com.applegadgets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_ProductSearch_To_OrderPlacement {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https:www.applegadgetsbd.com");  //Step 1
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("iPhone 13"); //Step 2,3
		driver.findElement(By.xpath("//button[@type='submit']")).click(); //Step 4,5
		Thread.sleep(4000); //Delay
		driver.findElement(By.xpath("//input[@id='filter_item_436']")).click(); //Step 6
		Thread.sleep(4000); //Delay
		driver.findElement(By.xpath("//body/div[@id='__next']/section[1]/div[1]/div[2]/div[2]/div[1]")).click(); //Step 7
		Thread.sleep(2000); //Delay
		driver.findElement(By.xpath("//div[@data-tip='Green']")).click(); //Step 8
		driver.findElement(By.xpath("//body/div[@id='__next']/div[@id='product']/section[1]/div[2]/div[2]/div[9]/div[1]/button[2]")).click(); //Step 9
		Thread.sleep(1000); //Delay
		driver.findElement(By.xpath("//div[@class='text-white']//p[contains(text(),'Cart')]")).click();//Step 10
		Thread.sleep(2000); //Delay
		driver.findElement(By.xpath("//button[contains(text(),'Check out')]")).click();//Step 11
		Thread.sleep(2000); //Delay
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Test"); //Step 12,13
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Automation"); //Step 14,15
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmail.com"); //Step 16,17
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("01812345678"); //Step 18,19
		
		WebElement division = driver.findElement(By.xpath("//select[@id='division']")); //Step 20
		selectOptionFromDropDown(division,"Dhaka"); //Step 21
		
		Thread.sleep(2000); //Delay
		
		WebElement city = driver.findElement(By.xpath("//select[@id='city']")); //Step 22
		selectOptionFromDropDown(city,"Dhaka Metro"); //Step 23
		
		Thread.sleep(2000); //Delay
		
		WebElement area = driver.findElement(By.xpath("//select[@id='area']")); //Step 24
		selectOptionFromDropDown(area,"Gulshan"); //Step 25
		
		Thread.sleep(3000); //Delay
		
		WebElement deliveryType = driver.findElement(By.xpath("//select[@name='delivery_type']"));//Step 26
		selectDropDownByIndex(deliveryType,3); //Step 27
		
		Thread.sleep(2000); //Delay
		
		driver.findElement(By.xpath("//input[@name='address_1']")).sendKeys("Road No:7, House Number:8, Gulshan, Dhaka");//Step 28, 29
		
		driver.findElement(By.xpath("//input[@id='payment-1']")).click(); //Step 30,31
		
		Thread.sleep(3000); //Delay
		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click(); //Step 32,33
		
		Thread.sleep(5000); //Delay
		
		WebElement orderIdElement = driver.findElement(By.xpath("//p[@class='text-primary text-tiny']")); //Step 34
		
		String orderIdText = orderIdElement.getText();
		String orderId = orderIdText.replace("Your order id is: ", "");//Step 35
		
		driver.findElement(By.xpath("//a[contains(text(),'Order Tracking')]")).click(); //Step 36,37
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='orderId']")).sendKeys(orderId); //Step 38,39
		driver.findElement(By.xpath("//body/div[@id='__next']/section[1]/form[1]/div[1]/button[1]")).click();//Step 40,41
		
		Thread.sleep(5000); //Delay
		driver.close();
	}
	
	public static void selectOptionFromDropDown(WebElement selectElement, String value)
	{
		Select dropDown = new Select(selectElement);
		List<WebElement> allOptions = dropDown.getOptions();
		
		for(WebElement option:allOptions)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}
	
	
	public static void selectDropDownByIndex(WebElement selectElement, int index)
	{
		Select dropDown = new Select(selectElement);
		dropDown.selectByIndex(index);
	}
	
	


}
