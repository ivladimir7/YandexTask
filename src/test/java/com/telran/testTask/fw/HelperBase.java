package com.telran.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            wd.findElement(locator).clear();
        }
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By by) {
        wd.findElement(by).click();
    }

    public boolean switchToNextTab(int number) {
        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            WebDriver window = wd.switchTo().window(availableWindows.get(number));
        }
        return true;
    }

    public void acceptCookies() {
        click(By.cssSelector("[data-id='button-all']"));
    }
}

