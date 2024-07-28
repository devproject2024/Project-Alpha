package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class TripDetailProvider extends IJRPaytmDataModel {
    @a
    @b(a = "address")
    private String address;
    @a
    @b(a = "contact")
    private String contact;
    @a
    @b(a = "email")
    private String email;
    @a
    @b(a = "name")
    private String name;

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

    public String getContact() {
        return this.contact;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }
}
