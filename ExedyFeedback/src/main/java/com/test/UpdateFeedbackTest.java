package com.test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class UpdateFeedbackTest {
	public static void main(String[] args) {
		// Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhananjay\\Desktop\\chromedriver_win32\\chromedriver.exe");

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); 


        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the registration page
            driver.get("http://localhost:8080/ExedyFeedback/UpateFeedback.jsp");

            // Fill in the registration form
            driver.findElement(By.name("productId")).sendKeys("1");
            driver.findElement(By.name("category")).sendKeys("Category 2");
            driver.findElement(By.name("functionality")).sendKeys("3");
            driver.findElement(By.name("performance")).sendKeys("6");
            driver.findElement(By.name("usability")).sendKeys("7");
            driver.findElement(By.name("cost")).sendKeys("9");
            driver.findElement(By.name("value")).sendKeys("8");
            driver.findElement(By.name("customerFeedback")).sendKeys("Satisfied");
            driver.findElement(By.name("environmentalFeedback")).sendKeys("Environmentally friendly");

            // Submit the registration form
            driver.findElement(By.name("updateBtn")).click();

            // Wait for the success page to load
            Thread.sleep(2000);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}
}
