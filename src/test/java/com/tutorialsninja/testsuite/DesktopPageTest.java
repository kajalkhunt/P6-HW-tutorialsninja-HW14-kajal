package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DesktopPageTest extends BaseTest {


    DesktopPage desktopPage = new DesktopPage();

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        desktopPage.getMouseHoverDesktop();
        desktopPage.alphabeticalOrder();
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        desktopPage.getMouseHoverDesktop();
        desktopPage.aToZAlphabeticalOrder();
        // String expectedMessage = "HP LP3065";
        // Assert.assertEquals(desktops.verifyHPL3065Text(), expectedMessage, "Not on HP LP3065 Page");
        // desktops.verifyText(By.xpath("")"");
//        desktops.verifyText("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"));
        assertAssert("HP LP3065 Not Matched ", desktopPage.exptectedTextMessage("HP LP3065"), desktopPage.actualTextToVerify(By.xpath("//h1[contains(text(),'HP LP3065')]")));
        desktopPage.deliveryDate();
        desktopPage.clickOnAddToCart();
        assertAssert("Not added to Cart", desktopPage.exptectedTextMessage ("Success: You have added HP LP3065 to your shopping cart!"), desktopPage.actualTextToVerify(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).substring(0, 56));
        desktopPage.clickOnShoppingCart();
        assertAssert("Not on Shopping Cart ", desktopPage.exptectedTextMessage("Shopping Cart"), desktopPage.actualTextToVerify(By.xpath("//div[@id='content']//h1")).substring(0,13));
        assertAssert("HP LP3065 Not found ", desktopPage.exptectedTextMessage("HP LP3065"), desktopPage.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")));
        assertAssert("Invalid Date ", desktopPage.exptectedTextMessage("2022-11-30"), desktopPage.actualTextToVerify(By.xpath("(//small[contains(text(), '2022-11-30')])[2]")).substring(15,25));
        assertAssert("Product 21 Not found", desktopPage.exptectedTextMessage("Product 21"), desktopPage.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]")));
        desktopPage.currencyConverter();
        assertAssert("Price is incorrect", desktopPage.exptectedTextMessage("£74.73"), desktopPage.actualTextToVerify(By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]")));

    }

}
