package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountsPage extends Utility {

        By myAccount = By.xpath("//span[contains(text(),'My Account')]");
        By registerAccount = By.xpath("//h1[contains(text(),'Register Account')]");

        By returningCustomerText = By.xpath("//h2[contains(text(),'Returning Customer')]");

        By firstNameField = By.id("input-firstname");
        By lastNameField = By.id("input-lastname");
        By emailField = By.id("input-email");
        By telephoneField = By.id("input-telephone");
        By passwordField = By.id("input-password");
        By confirmPasswordField = By.id("input-confirm");
        By clickOnRadio = By.xpath("(//input[@type='radio'])[2]");


        By clickAgree = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
        By clickContinue = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");

        By accountMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

        By clickCont = By.xpath("//a[contains(text(),'Continue')]");
        By clickAcc = By.xpath("//span[contains(text(),'My Account')]");

        By logoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

        By email = By.id("input-email");
        By password = By.id("input-password");
        By clickSubmit = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");

        By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");

        public void selectMyAccountOptions(String option) {
            List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
            try {
                for (WebElement options : myAccountList) {
                    if (options.getText().equalsIgnoreCase(option)) {
                        options.click();
                    }
                }
            } catch (
                    StaleElementReferenceException e) {
                myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
            }

        }

        public void clickOnMyAccounts() {
            clickOnElement(myAccount);
        }

        public String getRegisterText() {
            return getTextFromElement(registerAccount);
        }

        public String getReturningCustomerText() {
            return getTextFromElement(returningCustomerText);
        }

        public void fieldRegisterAccountDetails() {
            sendTextToElement(firstNameField, "prime" + getAlphaNumericString(4));
            sendTextToElement(lastNameField, "test" + getAlphaNumericString(4));
            sendTextToElement(emailField, "prime" + getAlphaNumericString(4) + "@gmail.com");
            sendTextToElement(telephoneField, "07988112233");
            sendTextToElement(passwordField, "test123");
            sendTextToElement(confirmPasswordField, "test123");


        }

        public void clickOnRadioButton() {
            clickOnElement(clickOnRadio);

        }

        public void clickOnAgree() {
            clickOnElement(clickAgree);
        }

        public void clickOnContinue() {
            clickOnElement(clickContinue);
        }

        public String getAccountText() {
            return getTextFromElement(accountMessage);
        }

        public void clickOnCont() {
            clickOnElement(clickCont);
        }

        public String getOnAccount() {
            return getTextFromElement(clickAcc);
        }

        public String getLogOutText() {
            return getTextFromElement(logoutText);
        }

        public void sendEmailPasswordDetails() {
            sendTextToElement(email, "prime123@gmail.com");
            sendTextToElement(password, "test123");
        }

        public void clickOnSubmit() {
            clickOnElement(clickSubmit);
        }

        public String getAccountLogOutText() {
            return getTextFromElement(accountLogoutText);
        }
    }

