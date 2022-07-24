package com.one.locators;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.className;

public enum ClassName implements Supplier<By> {

    PRODUCT_LABEL("title"),
    LOGO("login_logo"),
    SORT("product_sort_container"),
    SHOPPING_CART("shopping_cart_link"),
    CART_QUANTITY("cart_quantity"),
    INVENTORY_ITEM_NAME("inventory_item_name"),
    INVENTORY_ITEM_PRICE("inventory_item_price"),
    PAGE_TITLE("title"),
    PAYMENT_SHIP_INFO("summary_info_label"),
    SUMMARY_SUBTOTAL("summary_subtotal_label"),
    SUMMARY_TAX_LABEL("summary_tax_label"),
    SUMMARY_TOTAL_LABEL("summary_total_label"),
    CHECKOUT_COMPLETE_HEADER("complete-header"),
    CHECKOUT_COMPLETE_TEXT("complete-text");

    //INVENTORY_LIST("inventory_list"),
    //INVENTORY_ITEM("inventory_item");



    private final By by;

    ClassName(String id) {
        this.by = className(id);
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