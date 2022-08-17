package com.telran.testTask.fw;

import com.telran.testTask.utilits.MyListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
//    WebDriver wd;
    EventFiringWebDriver wd;
    ItemHelper item;
    HelperSearch search;

    public ItemHelper getItem() {
        return item;
    }

    public HelperSearch getSearch() {
        return search;
    }

    public void init() {
//      wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        item = new ItemHelper(wd);
        search = new HelperSearch(wd);

        wd.register(new MyListener());
    }

    public void stop() {
        wd.quit();
    }
}
