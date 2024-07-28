package com.business.merchant_payments.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.Map;

public class AcceptedPaymentMode extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "CC")
    @a
    public Map<String, String> cc;
    @c(a = "DC")
    @a
    public Map<String, String> dc;
    @c(a = "NB")
    @a
    public Map<String, String> nB;
    @c(a = "PPI")
    @a
    public Map<String, String> pPI;
    @c(a = "UPI")
    @a
    public Map<String, String> uPI;

    public Map<String, String> getPPI() {
        return this.pPI;
    }

    public Map<String, String> getNB() {
        return this.nB;
    }

    public Map<String, String> getUPI() {
        return this.uPI;
    }

    public Map<String, String> getCc() {
        return this.cc;
    }

    public Map<String, String> getDc() {
        return this.dc;
    }
}
