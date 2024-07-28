package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusInsuranceItem implements IJRDataModel {
    @b(a = "details")
    private String details;
    @b(a = "id")
    private int id;
    @b(a = "is_selected")
    private boolean isSelected;
    @b(a = "is_visible")
    private boolean isVisible;
    @b(a = "description")
    private String mDescription;
    @b(a = "tip")
    private String mTip;
    @b(a = "title")
    private String mTitle;
    @b(a = "max_claim_amount")
    private String maxClaimAmount;
    @b(a = "name")
    private String name;
    @b(a = "price")
    private double price;
    @b(a = "product_id")
    private int productId;
    @b(a = "tc")
    private String tc;
    @b(a = "text_to_display")
    private String text2Display;
    @b(a = "type")
    private String type;
    @b(a = "vertical_id")
    private int verticalId;

    public int getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(int i2) {
        this.verticalId = i2;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int i2) {
        this.productId = i2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double d2) {
        this.price = d2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String str) {
        this.details = str;
    }

    public String getMaxClaimAmount() {
        return this.maxClaimAmount;
    }

    public void setMaxClaimAmount(String str) {
        this.maxClaimAmount = str;
    }

    public String getText2Display() {
        return this.text2Display;
    }

    public void setText2Display(String str) {
        this.text2Display = str;
    }

    public String getTc() {
        return this.tc;
    }

    public void setTc(String str) {
        this.tc = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getTip() {
        return this.mTip;
    }

    public void setTip(String str) {
        this.mTip = str;
    }
}
