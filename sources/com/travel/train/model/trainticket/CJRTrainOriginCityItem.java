package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOriginCityItem extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "airport_name")
    private String airportName;
    @b(a = "code")
    private String cityCode;
    @b(a = "name")
    private String cityName;
    @b(a = "display_location")
    private String displayLocation;
    @b(a = "display_name")
    private String displayName;
    @b(a = "distance")
    private String distance;
    @b(a = "distance_value")
    private String distanceValue;
    private boolean isRecentObject = false;
    private String parentName;
    private String parentType;
    @b(a = "type")
    private String type;

    public boolean isRecentObject() {
        return this.isRecentObject;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getDistanceValue() {
        return this.distanceValue;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String str) {
        this.parentName = str;
    }

    public String getParentType() {
        return this.parentType;
    }

    public void setParentType(String str) {
        this.parentType = str;
    }

    public String getDisplayLocation() {
        return this.displayLocation;
    }

    public String getAirportName() {
        return this.airportName;
    }

    public void setAirportName(String str) {
        this.airportName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CJRTrainOriginCityItem cJRTrainOriginCityItem = (CJRTrainOriginCityItem) obj;
            if (this.isRecentObject != cJRTrainOriginCityItem.isRecentObject) {
                return false;
            }
            String str = this.cityName;
            if (str == null ? cJRTrainOriginCityItem.cityName != null : !str.equals(cJRTrainOriginCityItem.cityName)) {
                return false;
            }
            String str2 = this.cityCode;
            if (str2 == null ? cJRTrainOriginCityItem.cityCode != null : !str2.equals(cJRTrainOriginCityItem.cityCode)) {
                return false;
            }
            String str3 = this.displayName;
            String str4 = cJRTrainOriginCityItem.displayName;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.cityName;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cityCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayName;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + (this.isRecentObject ? 1 : 0);
    }
}
