package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        Thread.sleep(2000);

        FileInputStream fis = new FileInputStream("C:\\Users\\Ayyub\\samplescreenshort\\src\\main\\resources\\users1.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            String firstName = row.getCell(0).getStringCellValue();
            String lastName = row.getCell(1).getStringCellValue();
            String address = row.getCell(2).getStringCellValue();
            String city = row.getCell(3).getStringCellValue();
            String state = row.getCell(4).getStringCellValue();
            String zipCode = row.getCell(5).getStringCellValue();
            String phone = row.getCell(6).getStringCellValue();
            String ssn = row.getCell(7).getStringCellValue();
            String username = row.getCell(8).getStringCellValue();
            String password = row.getCell(9).getStringCellValue();

            driver.findElement(By.linkText("Register")).click();
            Thread.sleep(1000);

            driver.findElement(By.id("customer.firstName")).sendKeys(firstName);
            driver.findElement(By.id("customer.lastName")).sendKeys(lastName);
            driver.findElement(By.id("customer.address.street")).sendKeys(address);
            driver.findElement(By.id("customer.address.city")).sendKeys(city);
            driver.findElement(By.id("customer.address.state")).sendKeys(state);
            driver.findElement(By.id("customer.address.zipCode")).sendKeys(zipCode);
            driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);
            driver.findElement(By.id("customer.ssn")).sendKeys(ssn);
            driver.findElement(By.id("customer.username")).sendKeys(username);
            driver.findElement(By.id("customer.password")).sendKeys(password);
            driver.findElement(By.id("repeatedPassword")).sendKeys(password);

            driver.findElement(By.xpath("//input[@value='Register']")).click();
            Thread.sleep(2000);

            try {
                // Check if username already exists or registration failed
                WebElement error = driver.findElement(By.cssSelector(".error"));
                if (error.isDisplayed() && error.getText().toLowerCase().contains("username")) {
                    System.out.println("Username already exists: " + username);
                    continue;
                }
            } catch (NoSuchElementException e) {
                // No error found, now check if registration was successful
                try {
                    WebElement logout = driver.findElement(By.linkText("Log Out"));
                    if (logout.isDisplayed()) {
                        takeScreenshot(driver, "Registered_" + username);
                        logout.click();
                        System.out.println("Successfully registered and logged out: " + username);
                    }
                } catch (NoSuchElementException ex) {
                    System.out.println("Registration failed for: " + username);
                }
            }

            Thread.sleep(1000);
        }

        workbook.close();
        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + fileName + ".png");
        dest.getParentFile().mkdirs(); // Create folder if not exists
        try {
            FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot failed to save.");
        }
    }
}
