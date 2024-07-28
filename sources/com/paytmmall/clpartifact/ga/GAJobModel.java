package com.paytmmall.clpartifact.ga;

import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;

public class GAJobModel {
    public static final int JOB_TYPE_ITEM = 1001;
    public static final int JOB_TYPE_PRODUCT_ITEM = 1003;
    public static final int JOB_TYPE_VIEW_ITEM = 1002;
    private Item data;
    private int position;
    private CJRGridProduct productData;
    private int type = 1001;
    private View viewData;

    public GAJobModel(Item item, int i2) {
        this.data = item;
        this.position = i2;
    }

    public GAJobModel(CJRGridProduct cJRGridProduct, int i2) {
        this.productData = cJRGridProduct;
        this.position = i2;
    }

    public GAJobModel(View view, int i2) {
        this.viewData = view;
        this.position = i2;
    }

    public Item getData() {
        return this.data;
    }

    public void setData(Item item) {
        this.data = item;
    }

    public View getViewData() {
        return this.viewData;
    }

    public void setViewData(View view) {
        this.viewData = view;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public CJRGridProduct getProductData() {
        return this.productData;
    }
}
