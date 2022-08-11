package com.telran.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;



public class SearchItemTest {
    WebDriver wd;


    @BeforeMethod
    public void setUp() {
        wd = new FirefoxDriver();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchItemTest() throws InterruptedException {
        wd.findElement(By.cssSelector("[data-id='market'")).click();
        switchToNextTab(1);
        wd.findElement(By.xpath("//span[contains(text(),'Экспресс')]")).click();
        sleep(600);switchToNextTab(2);
        wd.findElement(By.xpath("//a[contains(text(),'Электроника')]")).click();
        sleep(600);
        wd.findElement(By.xpath("//button[contains(text(),'Принять')]")).click();
        sleep(600);
        wd.findElement(By.xpath("//a[contains(text(),'Смартфоны и аксессуары')]")).click();
        sleep(600);
        Assert.assertTrue(isElementPresent(By.xpath("//span[contains(text(),'Цена, ₽')]")));
        Assert.assertTrue(isElementPresent(By.xpath("//input[@id='textfield5666371307']")));
    }

    public boolean switchToNextTab(int number) {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            WebDriver window = wd.switchTo().window(availableWindows.get(number));
        }
        return true;
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);;
            return true;
        } catch (NoSuchElementException exception ) {

            return false;
        }
    }
        public void sleep(int millis){
            try {
                sleep(millis);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




