package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.LaptopsAndNoteBooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LaptopsAndNoteBooksPageTest extends BaseTest {

    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage = new LaptopsAndNoteBooksPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        laptopsAndNoteBooksPage.verifyProductsPriceDisplayHighToLowSuccessfully();
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        laptopsAndNoteBooksPage.verifyProductsPriceDisplayHighToLowSuccessfully();
        //2.4 Select Product “MacBook”
        laptopsAndNoteBooksPage.clickOnMacBook();
        //2.5 Verify the text “MacBook”
        assertAssert("MacBook not selected", laptopsAndNoteBooksPage.exptectedTextMessage("MacBook"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//h1[contains(text(),'MacBook')]")));
        //2.6 Click on ‘Add To Cart’ button
        laptopsAndNoteBooksPage.clickOnAddToCart();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertAssert("Product has not been added to Cart", laptopsAndNoteBooksPage.exptectedTextMessage("Success: You have added MacBook to your shopping cart!"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 54));
        //2.8 Click on link “shopping cart” display into success message
        laptopsAndNoteBooksPage.clickOnShoppingCart();
        //2.9 Verify the text "Shopping Cart"
        assertAssert("Not on Shopping cart", laptopsAndNoteBooksPage.exptectedTextMessage("Shopping Cart"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//h1[contains(text(), 'Shopping Cart')]")).substring(0,13));

        //2.10 Verify the Product name "MacBook"
        assertAssert("MacBook is not on cart", laptopsAndNoteBooksPage.exptectedTextMessage("MacBook"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));

        //2.11 Change Quantity "2"
        laptopsAndNoteBooksPage.sendTextToElement();

        //2.12 Click on “Update” Tab
        laptopsAndNoteBooksPage.clickOnUpdate();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        assertAssert("Cart not modified", laptopsAndNoteBooksPage.exptectedTextMessage("Success: You have modified your shopping cart!"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0,46));

        //Convert Currency to pounds
        laptopsAndNoteBooksPage.currencyConverter();

        //2.14 Verify the Total £737.45
        assertAssert("Total is not Matching", laptopsAndNoteBooksPage.exptectedTextMessage("£737.45"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));

        //2.15 Click on “Checkout” button
        laptopsAndNoteBooksPage.clickOnCheckoutButton();

        //2.16 Verify the text “Checkout”
        assertAssert("Not on Checkout", laptopsAndNoteBooksPage.exptectedTextMessage("Checkout"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//h1[contains(text(),'Checkout')]")));
        Thread.sleep(2000);
        //2.17 Verify the Text “New Customer”
        assertAssert("New customer text is not display", laptopsAndNoteBooksPage.exptectedTextMessage("New Customer"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//h2[text()='New Customer']")));

        //2.18 Click on “Guest Checkout” radio button
        laptopsAndNoteBooksPage.clickOnRadioButton();

        //2.19 Click on “Continue” tab
        laptopsAndNoteBooksPage.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter First Name", "Raghav", By.id("input-payment-firstname"));
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter Last Name", "Raja", By.id("input-payment-lastname"));
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter Email", "RaghavRaja@gmail.com", By.id("input-payment-email"));
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter Telephone", "02089056066", By.id("input-payment-telephone"));
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter Address1", "95 Harrow Road", By.id("input-payment-address-1"));
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter City","London", By.id("input-payment-city"));
        laptopsAndNoteBooksPage.addingMandatoryFields("Enter Postcode", "HA8 9ZZ", By.id("input-payment-postcode"));
        laptopsAndNoteBooksPage.selectCountry();
        laptopsAndNoteBooksPage.selectState();


        //2.21 Click on “Continue” Button
        laptopsAndNoteBooksPage.clickOnContinueButtonPayment();

        //2.22 Add Comments About your order into text area
        laptopsAndNoteBooksPage.addComment();

        //2.23 Check the Terms & Conditions check box
        laptopsAndNoteBooksPage.checkBoxClick();

        //2.24 Click on “Continue” button
        laptopsAndNoteBooksPage.clickOnLastContinueButton();

        //2.25 Verify the message “Warning: Payment method required!”
        assertAssert("Not checking payment method", laptopsAndNoteBooksPage.exptectedTextMessage("Warning: Payment method required!"), laptopsAndNoteBooksPage.actualTextToVerify(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).substring(0,33));

    }


}
