package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;

public class CartItemExchange {
    @a
    @b(a = "attributes")
    private CartItemAttribute attributes;
    @a
    @b(a = "brand")
    private String brand;
    @a
    @b(a = "category_name")
    private String categoryName;
    @a
    @b(a = "exchange_amount")
    private double exchangeAmount;
    @a
    @b(a = "exchange_id")
    private String exchangeId;
    @a
    @b(a = "exchange_with_text")
    private String exchangeWithText;
    @a
    @b(a = "expiry_date")
    private String expiryDate;
    @a
    @b(a = "imei")
    private String imei;
    @a
    @b(a = "instruction_text")
    private String instructionText;
    @a
    @b(a = "markup_amount")
    private double markupAmount;
    @a
    @b(a = "model")
    private String model;
    @a
    @b(a = "partner_id")
    private long partnerId;
    @a
    @b(a = "product")
    private CartItemProduct product;
    @a
    @b(a = "product_id")
    private long productId;
    @a
    @b(a = "quantity_text")
    private String quantityText;
    @a
    @b(a = "quote_id")
    private String quoteId;
    @a
    @b(a = "quote_total_amount")
    private double quoteTotalAmount;
    @a
    @b(a = "sub_title")
    private String subTitle;
    @a
    @b(a = "title")
    private String title;
    @a
    @b(a = "total_amount")
    private double totalAmount;
    @a
    @b(a = "warehouse_id")
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
