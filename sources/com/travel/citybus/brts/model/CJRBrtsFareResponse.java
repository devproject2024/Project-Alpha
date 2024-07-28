package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrtsFareResponse implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String brandId;
    private String city;
    @b(a = "busType")
    private String mBusType;
    @b(a = "destinationId")
    private String mDestinationId;
    @b(a = "destinationName")
    private String mDestinationName;
    @b(a = "industryType")
    private String mIndustryType;
    @b(a = "merchantGuid")
    private String mMerchantGuid;
    @b(a = "fareDetails")
    private ArrayList<CJRBrtsPaxInfo> mPaxInfo;
    @b(a = "routeId")
    private String mRouteId;
    @b(a = "routeName")
    private String mRouteName;
    @b(a = "sourceId")
    private String mSourceId;
    @b(a = "sourceName")
    private String mSourceName;
    private String productId;
    private String vehicleNumber;

    public String getSourceId() {
        return this.mSourceId;
    }

    public String getSourceName() {
        return this.mSourceName;
    }

    public String getDestinationId() {
        return this.mDestinationId;
    }

    public String getDestinationName() {
        return this.mDestinationName;
    }

    public String getRouteId() {
        return this.mRouteId;
    }

    public String getRouteName() {
        return this.mRouteName;
    }

    public String getBusType() {
        return this.mBusType;
    }

    public String getMerchantGuid() {
        return this.mMerchantGuid;
    }

    public String getIndustryType() {
        return this.mIndustryType;
    }

    public ArrayList<CJRBrtsPaxInfo> getPaxInfo() {
        return this.mPaxInfo;
    }

    public void setPaxInfo(ArrayList<CJRBrtsPaxInfo> arrayList) {
        this.mPaxInfo = arrayList;
    }

    public void setmMerchantGuid(String str) {
        this.mMerchantGuid = str;
    }

    public void setmIndustryType(String str) {
        this.mIndustryType = str;
    }

    public void setmSourceName(String str) {
        this.mSourceName = str;
    }

    public void setmDestinationId(String str) {
        this.mDestinationId = str;
    }

    public void setmDestinationName(String str) {
        this.mDestinationName = str;
    }

    public void setmRouteId(String str) {
        this.mRouteId = str;
    }

    public void setmRouteName(String str) {
        this.mRouteName = str;
    }

    public void setmSourceId(String str) {
        this.mSourceId = str;
    }

    public void setmBusType(String str) {
        this.mBusType = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getBrandId() {
        return this.brandId;
    }

    public void setBrandId(String str) {
        this.brandId = str;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public void setVehicleNumber(String str) {
        this.vehicleNumber = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }
}
