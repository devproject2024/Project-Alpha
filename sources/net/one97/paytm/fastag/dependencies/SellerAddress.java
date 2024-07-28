package net.one97.paytm.fastag.dependencies;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class SellerAddress extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String address;
    @b(a = "city")
    private String city;
    @b(a = "email")
    private String email;
    @b(a = "name")
    private String name;
    @b(a = "phn")
    private String phn;
    @b(a = "pincode")
    private String pincode;
    @b(a = "state")
    private String state;

    public static long getSerialVersionUID() {
        return 1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
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

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getPhn() {
        return this.phn;
    }

    public void setPhn(String str) {
        this.phn = str;
    }
}
