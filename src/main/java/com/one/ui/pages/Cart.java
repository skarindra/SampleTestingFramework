package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.ClassName.*;
import static com.one.locators.Id.CHECKOUT;

/**
 * Created by Sekar.
 */
public class Cart {

    private Browser browser;

    public Cart(Browser browser) {
        this.browser = browser;
    }

    public int getCartQuantity() {
        browser.await(CART_QUANTITY).isDisplayed();
        return Integer.parseInt(browser.getText(CART_QUANTITY));
    }

    public void clickCheckout() {
        browser.awaitClickable(CHECKOUT);
        browser.click(CHECKOUT);
    }

    public String getInventoryItemName() {
        return browser.getText(INVENTORY_ITEM_NAME);
    }

    public String getInventoryItemPrice() {
        return browser.getText(INVENTORY_ITEM_PRICE);
    }
}
