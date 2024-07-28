package com.travel.flight.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class GSTDetailsReviewPage extends IJRPaytmDataModel {
    @b(a = "invoice_number")
    private final String InvoiceNumber;
    @b(a = "company_gst_email")
    private final String companyGstEmail;
    @b(a = "company_name")
    private final String companyName;
    @b(a = "gst_number")
    private final String gstNumber;
    @b(a = "place_of_supply")
    private final String placeOfSupply;
    @b(a = "state_code")
    private final String stateCode;

    public final String getGstNumber() {
        return this.gstNumber;
    }

    public final String getStateCode() {
        return this.stateCode;
    }

    public final String getCompanyName() {
        return this.companyName;
    }

    public final String getInvoiceNumber() {
        return this.InvoiceNumber;
    }

    public final String getCompanyGstEmail() {
        return this.companyGstEmail;
    }

    public final String getPlaceOfSupply() {
        return this.placeOfSupply;
    }

    public GSTDetailsReviewPage(String str, String str2, String str3, String str4, String str5, String str6) {
        this.gstNumber = str;
        this.stateCode = str2;
        this.companyName = str3;
        this.InvoiceNumber = str4;
        this.companyGstEmail = str5;
        this.placeOfSupply = str6;
    }
}
