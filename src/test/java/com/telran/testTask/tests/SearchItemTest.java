package com.telran.testTask.tests;


import com.telran.testTask.model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchItemTest extends TestBase {


    @Test
    public void searchItemTest() throws InterruptedException {
        app.getSearch().selectMarket();
        app.getSearch().switchToNextTab(1);
        app.getItem().selectDepartment("Экспресс");
        app.getSearch().acceptCookies();
        app.getSearch().SelectCatalog("elektronika/23282330");
        app.getSearch().SelectCategoryType("smartfony-i-aksessuary/23282379");

        app.getItem().filterItem(new Item().setPriceFrom("20000").setPriceTo("35000").setBrand("Apple"));
        app.getItem().pause(10000);
        String itemName = app.getItem().getItemNameFromListByNumber(3);
        System.out.println(itemName);
        app.getItem().typeInSearchInputField(itemName);
        String foundItemName= app.getItem().getItemNameFromListByNumber(2);
        app.getSearch().pause(10000);
        System.out.println(foundItemName);
        Assert.assertEquals(foundItemName,itemName);

    }

}






