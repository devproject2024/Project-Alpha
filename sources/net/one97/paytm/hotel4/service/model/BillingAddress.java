package net.one97.paytm.hotel4.service.model;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import kotlin.g.b.k;

public final class BillingAddress {
    private String address;
    private String name;
    private String state;

    public BillingAddress(String str, String str2, String str3) {
        k.c(str, "name");
        k.c(str2, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
        k.c(str3, "state");
        this.name = str;
        this.address = str2;
        this.state = str3;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        k.c(str, "<set-?>");
        this.address = str;
    }

    public final String getState() {
        return this.state;
    }

    public final void setState(String str) {
        k.c(str, "<set-?>");
        this.state = str;
    }
}
