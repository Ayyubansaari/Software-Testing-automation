package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Ayyub\\sampleexcel\\src\\main\\resources\\users.xlsx"));
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
            String zip = row.getCell(5).getStringCellValue();
            String phone = row.getCell(6).getStringCellValue();
            String ssn = row.getCell(7).getStringCellValue();
            String username = row.getCell(8).getStringCellValue();
            String password = row.getCell(9).getStringCellValue();

            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            Thread.sleep(2000);

            driver.findElement(By.linkText("Register")).click();
            Thread.sleep(2000);

            driver.findElement(By.id("customer.firstName")).sendKeys(firstName);
            driver.findElement(By.id("customer.lastName")).sendKeys(lastName);
            driver.findElement(By.id("customer.address.street")).sendKeys(address);
            driver.findElement(By.id("customer.address.city")).sendKeys(city);
            driver.findElement(By.id("customer.address.state")).sendKeys(state);
            driver.findElement(By.id("customer.address.zipCode")).sendKeys(zip);
            driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);
            driver.findElement(By.id("customer.ssn")).sendKeys(ssn);
            driver.findElement(By.id("customer.username")).sendKeys(username);
            driver.findElement(By.id("customer.password")).sendKeys(password);
            driver.findElement(By.id("repeatedPassword")).sendKeys(password);

            driver.findElement(By.xpath("//input[@value='Register']")).click();
            Thread.sleep(3000);


            if (driver.getPageSource().contains("This username already exists")) {
                System.out.println("Username '" + username + "' already exists. Skipping registration.");
                Thread.sleep(2000);
                continue; // Skip to next user
            }

            try {
                WebElement logout = driver.findElement(By.linkText("Log Out"));
                if (logout.isDisplayed()) {
                    logout.click();
                    System.out.println("User " + username + " registered and logged out.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("User " + username + " registration failed or logout not found.");
            }

            Thread.sleep(2000);
        }

        driver.quit();
        workbook.close();
        fis.close();
    }
}
