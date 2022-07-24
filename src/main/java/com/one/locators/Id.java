package com.one.locators;


import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.id;

public enum Id implements Supplier<By> {

    LOGIN("login-button"),
    USERNAME("user-name"),
    PASSWORD("password"),
    INVENTORY_CONTAINER("inventory_container"),

    ADD_TO_CART_BACKPACK("add-to-cart-sauce-labs-backpack"),
    CHECKOUT("checkout"),
    FIRST_NAME("first-name"),
    LAST_NAME("last-name"),
    ZIP_CODE("postal-code"),
    CHECKOUT_CONTINUE("continue"),
    CHECKOUT_FINISH("finish")
    ;

    private final By by;

    Id(String id) {
        this.by = id(id);
    }

    @Override
    public By get() {
        return by;
    }

    @Override
    public String toString() {
        return by.toString();
    }
}