package com.one.ui.pages;

import com.one.framework.Browser;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.TimeoutException;

import static com.one.locators.ClassName.*;
import static com.one.locators.Id.ADD_TO_CART_BACKPACK;

public class Inventory {


        private Browser browser;

        public Inventory(Browser browser) {
            this.browser = browser;
        }

        public boolean isProductLabelPresent() {
            return browser.elementIsDisplayed(PRODUCT_LABEL);
        }

        public String getProductLabel() {
            return browser.getText(PRODUCT_LABEL);
        }

        public void clickAddToCartBackpack() {
            browser.click(ADD_TO_CART_BACKPACK);
        }

        public void clickShoppingCart() {
            browser.click(SHOPPING_CART);
        }

}
