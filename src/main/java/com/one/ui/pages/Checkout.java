package com.one.ui.pages;

import com.one.framework.Browser;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.one.locators.ClassName.*;
import static com.one.locators.ClassName.INVENTORY_ITEM_NAME;
import static com.one.locators.Id.*;
import static com.one.locators.LinkText.*;

/**
 * Created by Sekar.
 */
public class Checkout {
    private Browser browser;

    public Checkout(Browser browser) {
        this.browser = browser;
    }

    public void fillFirstName(String firstName) {
        browser.await(FIRST_NAME).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        browser.await(LAST_NAME).sendKeys(lastName);
    }

    public void fillZipCode(String zipCode) {
        browser.await(ZIP_CODE).sendKeys(zipCode);
    }

    public void clickContinueCheckout() {
        browser.click(CHECKOUT_CONTINUE);
    }

    public String getPageTitle(){
        return browser.getText(PAGE_TITLE);
    }

    public void checkPaymentAndShippingInfo() {
        List<String> elmText = new ArrayList<>();
        elmText.add("Payment Information:");
        elmText.add("Shipping Information:");

         browser.findElements(PAYMENT_SHIP_INFO).forEach(e -> elmText.contains(e.getText()));
    }

    public String getInventoryItemName() {
        return browser.getText(INVENTORY_ITEM_NAME);
    }

    public String getInventoryItemPrice() {
        return browser.getText(INVENTORY_ITEM_PRICE);
    }

    public int getCartQuantity() {
        browser.await(CART_QUANTITY).isDisplayed();
        return Integer.parseInt(browser.getText(CART_QUANTITY));
    }

    public double getItemTotal() {
        return Double.parseDouble(browser.getText(SUMMARY_SUBTOTAL).replace("Item total: $",""));
    }

    public double getTax() {
        return Double.parseDouble(browser.getText(SUMMARY_TAX_LABEL).replace("Tax: $",""));
    }

    public double getTotal() {
        return Double.parseDouble(browser.getText(SUMMARY_TOTAL_LABEL).replace("Total: $",""));
    }

    public double calculateTax(double price) {
        double tax = price * 0.08;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble(decimalFormat.format(tax));
    }

    public void clickFinishCheckout() {
        browser.click(CHECKOUT_FINISH);
    }

    public String getCheckoutCompleteHeader(){
        return browser.getText(CHECKOUT_COMPLETE_HEADER);
    }

    public String getCheckoutCompleteText(){
        return browser.getText(CHECKOUT_COMPLETE_TEXT);
    }
}
