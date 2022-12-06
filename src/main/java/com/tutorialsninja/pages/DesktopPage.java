package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {
    By mouseHoverOnDesktop = By.linkText("Desktops");
    By mouseHoverShowAllDesktop = By.linkText("Show All Desktops");
    By hPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");

    By hPLP3065Text = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    By successShoppingCart = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");


    public void getMouseHoverDesktop() {
        mouseHoverToElement(mouseHoverOnDesktop);
        mouseHoverToElementAndClick(mouseHoverShowAllDesktop);
    }

    public void alphabeticalOrder() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        Assert.assertEquals(originalProductsName, afterSortByZToAProductsName, "Product not sorted into Z to A order");
    }

    public void aToZAlphabeticalOrder() {
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");
        clickOnElement(hPLP3065);
    }

    public String verifyHPL3065Text() {
        return getTextFromElement(hPLP3065Text);
    }

    public void deliveryDate() {
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public String exptectedTextMessage(String exp){
        return exp;
    }
    public String actualTextToVerify(By by){
        String act = driver.findElement(by).getText();
        System.out.println(act);
        return act;
    }

    public void clickOnAddToCart(){
        clickOnElement(By.xpath("//button[@id='button-cart']"));
    }
    public void clickOnShoppingCart(){
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
    }

    public void currencyConverter() {
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

}
