package com.travel.bus.pojo.busticket;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusOriginCityItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "alias_type")
    private String aliasType;
    @b(a = "id")
    private long cityId;
    @b(a = "city_name")
    private String cityName;
    private String destinationCityName;
    @b(a = "text_to_display")
    private String displayCityName;
    @b(a = "district")
    private String district;
    @b(a = "heading_text")
    private String headingCityName;
    @b(a = "is_multi_district")
    private boolean isMultiDistrict;
    private int itemType = 0;
    @b(a = "match_type")
    private String matchType;
    @b(a = "name")
    private String name;
    @b(a = "selected_text")
    private String selectedCityName;
    @b(a = "short_name")
    private String shortCityName;
    @b(a = "state")
    private String state;

    public String getMatchType() {
        return this.matchType;
    }

    public void setMatchType(String str) {
        this.matchType = str;
    }

    public String getDisplayCityName() {
        if (TextUtils.isEmpty(this.displayCityName)) {
            return "";
        }
        return this.displayCityName;
    }

    public void setDisplayCityName(String str) {
        this.displayCityName = str;
    }

    public String getSelectedCityName() {
        return this.selectedCityName;
    }

    public void setSelectedCityName(String str) {
        this.selectedCityName = str;
    }

    public String getHeadingCityName() {
        return this.headingCityName;
    }

    public void setHeadingCityName(String str) {
        this.headingCityName = str;
    }

    public String getDestinationCityName() {
        return this.destinationCityName;
    }

    public void setDestinationCityName(String str) {
        this.destinationCityName = str;
    }

    public void setCityId(long j) {
        this.cityId = j;
    }

    public long getCityId() {
        return this.cityId;
    }

    public String getName() {
        if (TextUtils.isEmpty(this.name)) {
            this.name = "";
        }
        return this.name;
    }

    public String getShortCityName() {
        return this.shortCityName;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShortCityName(String str) {
        this.shortCityName = str;
    }

    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getAliasType() {
        return this.aliasType;
    }

    public void setAliasType(String str) {
        this.aliasType = str;
    }

    public boolean isMultiDistrict() {
        return this.isMultiDistrict;
    }

    public void setMultiDistrict(boolean z) {
        this.isMultiDistrict = z;
    }

    public String toString() {
        return "CJRBusOriginCityItem{cityId=" + this.cityId + ", name='" + this.name + '\'' + ", district='" + this.district + '\'' + ", cityName='" + this.cityName + '\'' + ", displayCityName='" + this.displayCityName + '\'' + ", selectedCityName='" + this.selectedCityName + '\'' + ", headingCityName='" + this.headingCityName + '\'' + ", shortCityName='" + this.shortCityName + '\'' + ", itemType=" + this.itemType + ", destinationCityName='" + this.destinationCityName + '\'' + ", alias type='" + this.aliasType + '\'' + ", is_multi_district='" + this.isMultiDistrict + '\'' + '}';
    }
}
