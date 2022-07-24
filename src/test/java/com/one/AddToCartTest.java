package com.one;

import com.one.framework.Browser;
import com.one.framework.WebDriverConfig;
import com.one.ui.pages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.inject.Inject;

import static org.testng.Assert.assertEquals;

/**
 * Created by Sekar.
 */
@ContextConfiguration(classes = {LoginForm.class, WebDriverConfig.class, Browser.class})
public class AddToCartTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LoginForm loginForm;

    @Inject
    private Browser browser;
    private Inventory inventory;
    private Cart cart;
    private Checkout checkout;

    @Test
    @Parameters({"firstname", "lastname", "zipcode"})
    public void addToCart(String firstname, String lastname, String zipcode) {
        //choose backpack
        inventory.clickAddToCartBackpack();
        inventory.clickShoppingCart();
        //check quantity
        assertEquals(cart.getCartQuantity(), 1);
        //check item name
        assertEquals(cart.getInventoryItemName(), "Sauce Labs Backpack");
        assertEquals(cart.getInventoryItemPrice(), "$29.99");
        cart.clickCheckout();
        //checkout
        checkout.fillFirstName(firstname);
        checkout.fillLastName(lastname);
        checkout.fillZipCode(zipcode);
        checkout.clickContinueCheckout();
        //checkout overview
        assertEquals(checkout.getPageTitle(),"CHECKOUT: OVERVIEW");
        assertEquals(checkout.getInventoryItemName(), "Sauce Labs Backpack");
        assertEquals(checkout.getInventoryItemPrice(), "$29.99");
        assertEquals(checkout.getCartQuantity(), 1);
        checkout.checkPaymentAndShippingInfo();
        assertEquals(checkout.getItemTotal(), 29.99);
        //tax 8%
        assertEquals(checkout.getTax(),
                checkout.calculateTax(checkout.getItemTotal()));
        //total
        assertEquals(checkout.getItemTotal()+checkout.calculateTax(checkout.getItemTotal()), checkout.getTotal());
        checkout.clickFinishCheckout();
        //checkout complete
        assertEquals(checkout.getPageTitle(),"CHECKOUT: COMPLETE!");
        assertEquals(checkout.getCheckoutCompleteHeader(), "THANK YOU FOR YOUR ORDER");
        assertEquals(checkout.getCheckoutCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void beforeTestMethod(String username, String password) {
        loginForm.loginAs(username, password);
        inventory = new Inventory(browser);
        checkout = new Checkout(browser);
        cart = new Cart(browser);
    }
}
