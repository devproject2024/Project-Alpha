package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class KycAddDetail implements Serializable {
    @b(a = "addressLine1")
    private String addressLine1;
    @b(a = "addressLine2")
    private String addressLine2;
    @b(a = "addressLine3")
    private String addressLine3;
    @b(a = "addressType")
    private String addressType;
    @b(a = "city")
    private String city;
    @b(a = "pincode")
    private String pincode;
    @b(a = "state")
    private String state;

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String str) {
        this.addressLine2 = str;
    }

    public String getAddressLine3() {
        return this.addressLine3;
    }

    public void setAddressLine3(String str) {
        this.addressLine3 = str;
    }

    public String getPincodeC() {
        return this.pincode;
    }

    public void setPincodeC(String str) {
        this.pincode = str;
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

    public String getAddressType() {
        return this.addressType;
    }

    public void setAddressType(String str) {
        this.addressType = str;
    }
}
