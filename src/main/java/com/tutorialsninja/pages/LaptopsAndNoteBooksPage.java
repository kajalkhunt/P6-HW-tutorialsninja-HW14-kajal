package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBooksPage extends Utility {

    By mouseHoverOnLapNotBooks = By.linkText("Laptops & Notebooks");
    By mouseHoverShowAllLapNotBooks = By.linkText("Show All Laptops & Notebooks");
    By macBook = By.linkText("MacBook");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By qty = By.xpath("//input[contains(@name, 'quantity')]");
    By update = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");

    By radioButton = By.xpath("//input[@value='guest']");
    By continueButton = By.xpath("//input[@id='button-account']");
    By country = By.id("input-payment-country");
    By state = By.id("input-payment-zone");

    By contButton = By.xpath("//input[@id='button-guest']");

    By addCommentText = By.xpath("//textarea[@name='comment']");

    By checkBox = By.xpath("//input[@name='agree']");

    By lastContButton = By.xpath("//input[@id='button-payment-method']");




    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        mouseHoverToElementAndClick(mouseHoverOnLapNotBooks);
        clickOnElement(mouseHoverShowAllLapNotBooks);

        // Selecting Price High to Low
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println("Original Price List: " + originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        //  Assert.assertEquals("Product not sorted by price High to Low", originalProductsPrice, afterSortByPrice);
        Assert.assertEquals(originalProductsPrice, afterSortByPrice, "Product not sorted by price High to Low");
    }

    public void clickOnMacBook() {
        clickOnElement(macBook);
    }

    public String exptectedTextMessage(String exp) {
        return exp;
    }

    public String actualTextToVerify(By by) {
        String act = driver.findElement(by).getText();
        System.out.println(act);
        return act;
    }

    public void clickOnAddToCart(){
        clickOnElement(addToCart);
    }
    public void clickOnShoppingCart(){
        clickOnElement(shoppingCart);
    }
    public void sendTextToElement(){
        driver.findElement(qty).clear();
        sendTextToElement((qty),"2");
    }


    public void clickOnUpdate() {
        clickOnElement(update);
    }

    public void currencyConverter(){
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e:currencyList ) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")){
                e.click();
                break;
            }
        }
    }
    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }
    public void clickOnRadioButton() {
        clickOnElement(radioButton);
        clickOnElement(continueButton);
    }
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void addingMandatoryFields(String fieldName, String sendText, By by){
        sendTextToElement(by, sendText);
    }
    public void selectCountry(){
        selectByVisibleTextFromDropDown(country, "United Kingdom");
    }
    public void selectState(){
        selectByVisibleTextFromDropDown(state, "Surrey");
    }
    public void clickOnContinueButtonPayment(){
        clickOnElement(contButton);
    }
    public void addComment(){
        sendTextToElement(addCommentText, "Please BE AWARE of the TIGERS.......................");
    }
    public void checkBoxClick(){
        clickOnElement(checkBox);
    }
    public void clickOnLastContinueButton(){
        clickOnElement(lastContButton);
    }

}
