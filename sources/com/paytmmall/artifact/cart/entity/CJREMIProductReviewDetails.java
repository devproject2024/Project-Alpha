package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJREMIProductReviewDetails extends IJRPaytmDataModel {
    @b(a = "deliveryAddress")
    private CJRAddress deliveryAddress;
    @b(a = "exchangeInfo")
    private CJREMIProductExchangeInfo exchangeInfo;
    private GSTINData gstinfo;
    private String middleWareUrl;
    @b(a = "productEMIInfo")
    private CJREMIModel productEMIInfo;
    @b(a = "productPromoInfo")
    private CJREMIProductPromoInfo productPromoInfo;
    @b(a = "selectedProduct")
    private CJRDetailProduct selectedProduct;
    @b(a = "subProduct")
    private String subProduct;
    @b(a = "urlParams")
    private HashMap<String, Object> urlParams;

    public String getMiddleWareUrl() {
        return this.middleWareUrl;
    }

    public void setMiddleWareUrl(String str) {
        this.middleWareUrl = str;
    }

    public String getSubProduct() {
        return this.subProduct;
    }

    public void setSubProduct(String str) {
        this.subProduct = str;
    }

    public CJRAddress getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(CJRAddress cJRAddress) {
        this.deliveryAddress = cJRAddress;
    }

    public CJRDetailProduct getSelectedProduct() {
        return this.selectedProduct;
    }

    public void setSelectedProduct(CJRDetailProduct cJRDetailProduct) {
        this.selectedProduct = cJRDetailProduct;
    }

    public CJREMIProductPromoInfo getProductPromoInfo() {
        return this.productPromoInfo;
    }

    public void setProductPromoInfo(CJREMIProductPromoInfo cJREMIProductPromoInfo) {
        this.productPromoInfo = cJREMIProductPromoInfo;
    }

    public CJREMIModel getProductEMIInfo() {
        return this.productEMIInfo;
    }

    public void setProductEMIInfo(CJREMIModel cJREMIModel) {
        this.productEMIInfo = cJREMIModel;
    }

    public CJREMIProductExchangeInfo getExchangeInfo() {
        return this.exchangeInfo;
    }

    public void setExchangeInfo(CJREMIProductExchangeInfo cJREMIProductExchangeInfo) {
        this.exchangeInfo = cJREMIProductExchangeInfo;
    }

    public GSTINData getGstinfo() {
        return this.gstinfo;
    }

    public void setGstinfo(GSTINData gSTINData) {
        this.gstinfo = gSTINData;
    }

    public HashMap<String, Object> getUrlParams() {
        return this.urlParams;
    }

    public void setUrlParams(HashMap hashMap) {
        this.urlParams = hashMap;
    }
}
