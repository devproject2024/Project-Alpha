package com.paytmmall.clpartifact.modal.clpCommon;

import android.text.TextUtils;
import androidx.databinding.a;
import com.google.gson.a.c;
import com.paytmmall.clpartifact.BR;
import java.io.Serializable;

public class CJRStoreInfo extends a implements Serializable {
    @c(a = "about")
    String about;
    @c(a = "address")
    String address;
    @c(a = "city")
    String city;
    @c(a = "contact")
    String contact;
    @c(a = "coverPic")
    String coverPic;
    @c(a = "distance")
    String distance;
    @c(a = "district")
    String district;
    @c(a = "isFollowing")
    boolean isFollowing;
    @c(a = "logo")
    String logo;
    @c(a = "logoUrl")
    String logoUrl;
    @c(a = "name")
    String name;
    @c(a = "numberOfFollowers")
    Integer numberOfFollowers;
    @c(a = "openingTime")
    String openingTime;
    @c(a = "see_all_stores")
    String see_all_stores;
    @c(a = "state")
    String state;
    @c(a = "type")
    String type;
    @c(a = "wkdayCloseTime")
    String wkdayCloseTime;
    @c(a = "wkdayOpenTime")
    String wkdayOpenTime;
    @c(a = "wkendOpenTime")
    String wkendOpenTime;
    @c(a = "wkendcloseTime")
    String wkendcloseTime;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLogoUrl() {
        return TextUtils.isEmpty(this.logoUrl) ? this.logo : this.logoUrl;
    }

    public void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String str) {
        this.about = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getOpeningTime() {
        return this.openingTime;
    }

    public void setOpeningTime(String str) {
        this.openingTime = str;
    }

    public String getWkdayCloseTime() {
        return this.wkdayCloseTime;
    }

    public void setWkdayCloseTime(String str) {
        this.wkdayCloseTime = str;
    }

    public String getWkendcloseTime() {
        return this.wkendcloseTime;
    }

    public void setWkendcloseTime(String str) {
        this.wkendcloseTime = str;
    }

    public String getWkdayOpenTime() {
        return this.wkdayOpenTime;
    }

    public void setWkdayOpenTime(String str) {
        this.wkdayOpenTime = str;
    }

    public String getWkendOpenTime() {
        return this.wkendOpenTime;
    }

    public void setWkendOpenTime(String str) {
        this.wkendOpenTime = str;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public String getCoverPic() {
        return this.coverPic;
    }

    public void setCoverPic(String str) {
        this.coverPic = str;
    }

    public String getSee_all_stores() {
        return this.see_all_stores;
    }

    public void setSee_all_stores(String str) {
        this.see_all_stores = str;
    }

    public boolean isFollowing() {
        return this.isFollowing;
    }

    public void setFollowing(boolean z) {
        this.isFollowing = z;
        notifyPropertyChanged(BR.following);
    }

    public Integer getNumberOfFollowers() {
        return this.numberOfFollowers;
    }

    public void setNumberOfFollowers(Integer num) {
        this.numberOfFollowers = num;
    }
}
