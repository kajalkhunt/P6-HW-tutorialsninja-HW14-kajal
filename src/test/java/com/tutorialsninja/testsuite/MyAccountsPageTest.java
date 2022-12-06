package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAccountsPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountsPageTest extends BaseTest {

    MyAccountsPage myAccountsPage = new MyAccountsPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccountsPage.clickOnMyAccounts();
        myAccountsPage.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccountsPage.getRegisterText(),"Register Account","Not Matching");

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccountsPage.clickOnMyAccounts();
        myAccountsPage.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccountsPage.getReturningCustomerText(),"Returning Customer","Not Matching");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccountsPage.clickOnMyAccounts();
        myAccountsPage.selectMyAccountOptions("Register");
        myAccountsPage.fieldRegisterAccountDetails();
        myAccountsPage.clickOnRadioButton();
        myAccountsPage.clickOnAgree();
        myAccountsPage.clickOnContinue();
        Assert.assertEquals(myAccountsPage.getAccountText(),"Your Account Has Been Created!","Not Matching");
        myAccountsPage.clickOnCont();
        myAccountsPage.clickOnMyAccounts();
        myAccountsPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountsPage.getLogOutText(),"Account Logout","Not matching");
        myAccountsPage.clickOnCont();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccountsPage.clickOnMyAccounts();
        myAccountsPage.selectMyAccountOptions("Login");
        myAccountsPage.sendEmailPasswordDetails();
        myAccountsPage.clickOnSubmit();
        myAccountsPage.clickOnMyAccounts();
        myAccountsPage.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccountsPage.getAccountLogOutText(),"Account Logout","Not matching");
    }

}
