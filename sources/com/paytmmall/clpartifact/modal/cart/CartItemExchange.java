package com.paytmmall.clpartifact.modal.cart;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class CartItemExchange {
    @c(a = "attributes")
    @a
    private CartItemAttribute attributes;
    @c(a = "brand")
    @a
    private String brand;
    @c(a = "category_name")
    @a
    private String categoryName;
    @c(a = "exchange_amount")
    @a
    private double exchangeAmount;
    @c(a = "exchange_id")
    @a
    private String exchangeId;
    @c(a = "exchange_with_text")
    @a
    private String exchangeWithText;
    @c(a = "expiry_date")
    @a
    private String expiryDate;
    @c(a = "imei")
    @a
    private String imei;
    @c(a = "instruction_text")
    @a
    private String instructionText;
    @c(a = "markup_amount")
    @a
    private double markupAmount;
    @c(a = "model")
    @a
    private String model;
    @c(a = "partner_id")
    @a
    private long partnerId;
    @c(a = "product")
    @a
    private CartItemProduct product;
    @c(a = "product_id")
    @a
    private long productId;
    @c(a = "quantity_text")
    @a
    private String quantityText;
    @c(a = "quote_id")
    @a
    private String quoteId;
    @c(a = "quote_total_amount")
    @a
    private double quoteTotalAmount;
    @c(a = "sub_title")
    @a
    private String subTitle;
    @c(a = "title")
    @a
    private String title;
    @c(a = "total_amount")
    @a
    private double totalAmount;
    @c(a = "warehouse_id")
    @a
    private String warehouseId;

    public String getQuoteId() {
        return this.quoteId;
    }

    public void setQuoteId(String str) {
        this.quoteId = str;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long j) {
        this.productId = j;
    }

    public double getQuoteTotalAmount() {
        return this.quoteTotalAmount;
    }

    public void setQuoteTotalAmount(double d2) {
        this.quoteTotalAmount = d2;
    }

    public String getInstructionText() {
        return this.instructionText;
    }

    public void setInstructionText(String str) {
        this.instructionText = str;
    }

    public String getQuantityText() {
        return this.quantityText;
    }

    public void setQuantityText(String str) {
        this.quantityText = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public double getExchangeAmount() {
        return this.exchangeAmount;
    }

    public void setExchangeAmount(double d2) {
        this.exchangeAmount = d2;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public String getExchangeId() {
        return this.exchangeId;
    }

    public void setExchangeId(String str) {
        this.exchangeId = str;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double d2) {
        this.totalAmount = d2;
    }

    public double getMarkupAmount() {
        return this.markupAmount;
    }

    public void setMarkupAmount(double d2) {
        this.markupAmount = d2;
    }

    public String getExchangeWithText() {
        return this.exchangeWithText;
    }

    public void setExchangeWithText(String str) {
        this.exchangeWithText = str;
    }

    public CartItemAttribute getAttributes() {
        return this.attributes;
    }

    public void setAttributes(CartItemAttribute cartItemAttribute) {
        this.attributes = cartItemAttribute;
    }

    public long getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(long j) {
        this.partnerId = j;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public CartItemProduct getProduct() {
        return this.product;
    }

    public void setProduct(CartItemProduct cartItemProduct) {
        this.product = cartItemProduct;
    }

    public String getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(String str) {
        this.warehouseId = str;
    }
}
