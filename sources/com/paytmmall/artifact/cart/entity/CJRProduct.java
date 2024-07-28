package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRDataModelItem;

public abstract class CJRProduct extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "brand")
    protected String mBrand;
    @b(a = "name")
    protected String mName;
    @b(a = "product_type")
    protected String mProductType;

    public abstract String getBrand();

    public abstract String getName();

    public abstract String getProductType();
}
