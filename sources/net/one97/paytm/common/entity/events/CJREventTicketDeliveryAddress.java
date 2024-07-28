package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventTicketDeliveryAddress implements IJRDataModel {
    @b(a = "Address_1")
    String Address_1;
    @b(a = "Address_2")
    String Address_2;
    @b(a = "Address_type")
    String Address_type;
    @b(a = "City")
    String City;
    @b(a = "Landmark")
    String Landmark;
    @b(a = "Mobile")
    String Mobile;
    @b(a = "Name")
    String Name;
    @b(a = "Pincode")
    String Pincode;
    @b(a = "State")
    String State;

    public String getAddress1() {
        return this.Address_1;
    }

    public void setAddress1(String str) {
        this.Address_1 = str;
    }

    public String getAddress2() {
        return this.Address_2;
    }

    public void setAddress2(String str) {
        this.Address_2 = str;
    }

    public String getLandmark() {
        return this.Landmark;
    }

    public void setLandmark(String str) {
        this.Landmark = str;
    }

    public String getPincode() {
        return this.Pincode;
    }

    public void setPincode(String str) {
        this.Pincode = str;
    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public String getState() {
        return this.State;
    }

    public void setState(String str) {
        this.State = str;
    }

    public String getAddressType() {
        return this.Address_type;
    }

    public void setAddressType(String str) {
        this.Address_type = str;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public String getMobile() {
        return this.Mobile;
    }

    public void setMobile(String str) {
        this.Mobile = str;
    }
}
