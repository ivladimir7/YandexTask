package com.telran.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase {

    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void SelectCategoryType(String type) {
        click(By.cssSelector("[href='/catalog-- "+ type +"?how=dpop&glfilter=&cvredirect=3&filter-express-delivery=1&searchContext=express&track=srch_ddl']"));

    }

    public void SelectCatalog(String categorie) {
        click(By.cssSelector("[href='/catalog--" + categorie + "/list?filter-express-delivery=1&searchContext=express']"));
    }



    public void selectMarket() {
        click(By.cssSelector("[data-id='market'"));
    }
}