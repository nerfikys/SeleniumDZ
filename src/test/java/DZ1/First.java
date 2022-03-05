package DZ1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;


public class First {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10, 2000);
        driver.manage().window().maximize();
        driver.get("https://www.rgs.ru"); // Шаг 1
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement baseMenu = driver.findElement(By.linkText("Компаниям"));
        baseMenu.click(); // Шаг 2,3.1
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement health = driver.findElement(By.xpath("//span[@class='padding' and contains(text(),'Здоровье')]"));
        health.click(); // Шаг 3.2
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement strahov = driver.findElement(By.xpath("//a[@href='/for-companies/zdorove/dobrovolnoe-meditsinskoe-strakhovanie']"));
        strahov.click(); // Шаг 3.3
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Отправить заявку')]"));
        button.click(); // Шаг 4
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebElement erorr1 = driver.findElement(By.xpath("//*[contains(text(),'Оперативно перезвоним')]"));//Шаг 9
        } catch (NoSuchElementException e) {
            Assert.fail("Не найден необходимый заголовок с содержанием \"Оперативно перезвоним\"");
        }
        WebElement nameFolder = driver.findElement(By.xpath("//*[@name = 'userName']")); // Шаг 6.1
        nameFolder.sendKeys("Ryzhov Oleg Romanovich");
        WebElement telFolder = driver.findElement(By.xpath("//*[@name = 'userTel']")); // Шаг 6.2
        telFolder.sendKeys("(800) 555-5353");
        WebElement emlFolder = driver.findElement(By.xpath("//*[@name = 'userEmail']")); // Шаг 6.3
        emlFolder.sendKeys("qwertyqwerty");
        //emlFolder.sendKeys("oryznov@mail.ru"); //Для проверки ошибки шага 9
        WebElement box = driver.findElement(By.xpath("//label[@data-v-973e6056='']"));// Шаг 6.5
        box.click();
        WebElement plcFolder = driver.findElement(By.xpath("//input[@placeholder='Введите']")); // Шаг 6.4.1
        plcFolder.sendKeys("г Москва, проезд Черепановых, д 56 к 1, кв 20");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement truble = driver.findElement(By.xpath("//*[@class='vue-dadata__suggestions']"));// Шаг 6.4.2
        truble.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        { // Шаг 7
            Assert.assertEquals("Введённые данные ФИО не совпадют с ожидаемыми", "Ryzhov Oleg Romanovich", nameFolder.getAttribute("value"));
            Assert.assertEquals("Введённые данные Телефона не совпадют с ожидаемыми", "+7 (800) 555-5353", telFolder.getAttribute("value"));
            Assert.assertEquals("Введённые данные Почты не совпадют с ожидаемыми", "qwertyqwerty", emlFolder.getAttribute("value"));
            Assert.assertEquals("Введённые данные Чекбокс не совпадют с ожидаемыми", "true", driver.findElement(By.xpath("//input[@data-v-973e6056='']")).getAttribute("checked"));
            Assert.assertEquals("Введённые данные не совпадют с ожидаемыми", "г Москва, проезд Черепановых, д 56 к 1, кв 20", plcFolder.getAttribute("value"));
        }
        WebElement submit = driver.findElement(By.xpath("//*[@type='submit']")); // Шаг 8
        submit.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebElement erorr3 = driver.findElement(By.xpath("//span[@class='input__error text--small']"));//Шаг 9
        } catch (NoSuchElementException e) {
            Assert.fail("Не появилась ошибка об неккоректном адресе");
        }
    }
}
