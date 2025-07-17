package org.example.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

        public static void main(String[] args) throws InterruptedException{

            WebDriver driver = new ChromeDriver();
            driver.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=B6CD47FCA7B2FA025DA0197368377D6A");

            Thread.sleep(3000);

            WebElement Register = driver.findElement(By.xpath("//a[text()='Register']"));
            Register.click();
            Thread.sleep(3000);

            WebElement customerfirstname = driver.findElement(By.id("customer.firstName"));
            try {
                WebElement element = driver.findElement(By.id("customer.firstName"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the firstname.");
                } else {
                    System.out.println("firstname is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("firstname is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerlastname = driver.findElement(By.id("customer.lastName"));
            try {
                WebElement element = driver.findElement(By.id("customer.lastName"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the lastname.");
                } else {
                    System.out.println("lastname is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("lastname is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customeraddress = driver.findElement(By.id("customer.address.street"));
            try {
                WebElement element = driver.findElement(By.id("customer.address.street"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the address.");
                } else {
                    System.out.println("address is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("address is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customeraddresscity = driver.findElement(By.id("customer.address.city"));
            try {
                WebElement element = driver.findElement(By.id("customer.address.city"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the city.");
                } else {
                    System.out.println("city is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("city is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customeraddressstate = driver.findElement(By.id("customer.address.state"));
            try {
                WebElement element = driver.findElement(By.id("customer.address.state"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the state.");
                } else {
                    System.out.println("state is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("state is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customeraddresszipcode = driver.findElement(By.id("customer.address.zipCode"));
            try {
                WebElement element = driver.findElement(By.id("customer.address.zipCode"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the zipCode.");
                } else {
                    System.out.println("zipCode is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("zipCode is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerphonenumber = driver.findElement(By.id("customer.phoneNumber"));
            try {
                WebElement element = driver.findElement(By.id("customer.phoneNumber"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the phonenumber");
                } else {
                    System.out.println("phonenumber is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("phonenumber is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerssn = driver.findElement(By.id("customer.ssn"));
            try {
                WebElement element = driver.findElement(By.id("customer.ssn"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the ssn.");
                } else {
                    System.out.println("ssn is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("ssn is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerusername = driver.findElement(By.id("customer.username"));
            try {
                WebElement element = driver.findElement(By.id("customer.username"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the username.");
                } else {
                    System.out.println("username is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("username is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerpassword = driver.findElement(By.id("customer.password"));
            try {
                WebElement element = driver.findElement(By.id("customer.password"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the password.");
                } else {
                    System.out.println("password is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("password is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerconformpassword = driver.findElement(By.id("repeatedPassword"));
            try {
                WebElement element = driver.findElement(By.id("repeatedPassword"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the conformpassword.");
                } else {
                    System.out.println("conformpassword is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("conformpassword is not present in the DOM.");
            }
            Thread.sleep(1000);

            WebElement customerRegister = driver.findElement(By.xpath("//input[@type='submit' and @class = 'button' and @value= 'Register']"));
            try {
                WebElement element = driver.findElement(By.xpath("//input[@type='submit' and @class = 'button' and @value = 'Register']"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the register.");
                } else {
                    System.out.println("register is not entered");
                }
            }
            catch (NoSuchElementException e) {
                System.out.println("register is not present in the DOM.");
            }


            customerfirstname.sendKeys("ayyub");
            customerlastname.sendKeys("ansaari");
            customeraddress.sendKeys("tc 34/3344 swagath nagar ");
            customeraddresscity.sendKeys("trivandrum");
            customeraddressstate.sendKeys("kerala");
            customeraddresszipcode.sendKeys("695009");
            customerphonenumber.sendKeys("9875421303");
            customerssn.sendKeys("8794521");
            customerusername.sendKeys("auba");
            customerpassword.sendKeys("12345");
            customerconformpassword.sendKeys("12345");
            customerRegister.click();

            Thread.sleep(4000); // Wait for 4 seconds before logout
            try {
                WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
                if (logout.isDisplayed()) {
                    logout.click();
                    System.out.println("Successfully logged out.");
                } else {
                    System.out.println("Logout link is not displayed.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Logout link not found in the DOM.");
            }
            Thread.sleep(3000);

            System.out.println("/t successfully registered /t");

            Thread.sleep(2000);
            WebElement username = driver.findElement(By.name("username"));
            try {
                WebElement element = driver.findElement(By.name("username"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the username.");
                } else {
                    System.out.println("username is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("username is not present in the DOM.");
            }
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.name("password"));
            try {
                WebElement element = driver.findElement(By.name("password"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the password.");
                } else {
                    System.out.println("password is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("password is not present in the DOM.");
            }
            Thread.sleep(1000);
            WebElement login = driver.findElement(By.xpath("//input[@type='submit' and @class = 'button' and @value = 'Log In']"));
            try {
                WebElement element = driver.findElement(By.xpath("//input[@type='submit' and @class = 'button' and @value = 'Log In']"));
                if (element.isDisplayed()) {
                    System.out.println("successfully enter the password.");
                } else {
                    System.out.println("password is not entered");
                }
            } catch (NoSuchElementException e) {
                System.out.println("password is not present in the DOM.");
            }

            username.sendKeys("auba");
            password.sendKeys("12345");
            login.click();








        }
    }