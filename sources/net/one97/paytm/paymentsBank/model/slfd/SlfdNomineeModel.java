package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdNomineeModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "active")
    private boolean active;
    @b(a = "areaName")
    private String areaName;
    @b(a = "city")
    private String city;
    @b(a = "custId")
    private String custId;
    @b(a = "dob")
    private String dob;
    @b(a = "email")
    private String email;
    @b(a = "houseNo")
    private String houseNo;
    private boolean isSelected;
    @b(a = "latitude")
    private String latitude;
    @b(a = "longitude")
    private String longitude;
    @b(a = "name")
    private String name;
    @b(a = "nomineeFinservId")
    private String nomineeFinservId;
    @b(a = "oauthId")
    private String oauthId;
    @b(a = "pinCode")
    private String pincode;
    @b(a = "relationship")
    private String relationship;
    @b(a = "state")
    private String state;
    @b(a = "streetName")
    private String streetName;

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean z) {
        this.active = z;
    }

    public final String getAreaName() {
        return this.areaName;
    }

    public final void setAreaName(String str) {
        this.areaName = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getCustId() {
        return this.custId;
    }

    public final void setCustId(String str) {
        this.custId = str;
    }

    public final String getDob() {
        return this.dob;
    }

    public final void setDob(String str) {
        this.dob = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getHouseNo() {
        return this.houseNo;
    }

    public final void setHouseNo(String str) {
        this.houseNo = str;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final void setLatitude(String str) {
        this.latitude = str;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final void setLongitude(String str) {
        this.longitude = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getNomineeFinservId() {
        return this.nomineeFinservId;
    }

    public final void setNomineeFinservId(String str) {
        this.nomineeFinservId = str;
    }

    public final String getOauthId() {
        return this.oauthId;
    }

    public final void setOauthId(String str) {
        this.oauthId = str;
    }

    public final String getPincode() {
        return this.pincode;
    }

    public final void setPincode(String str) {
        this.pincode = str;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public final void setRelationship(String str) {
        this.relationship = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        this.state = str;
    }

    public final String getStreetName() {
        return this.streetName;
    }

    public final void setStreetName(String str) {
        this.streetName = str;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
