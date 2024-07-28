package net.one97.paytm.hotel4.service.model;

import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class GSTDetails {
    private BillingAddress billing_address;
    private String gstin;
    private Boolean has_gstin;

    public GSTDetails(String str, Boolean bool, BillingAddress billingAddress) {
        k.c(str, AddEditGstinViewModelKt.BODY_PARAM_GSTIN);
        this.gstin = str;
        this.has_gstin = bool;
        this.billing_address = billingAddress;
    }

    public final String getGstin() {
        return this.gstin;
    }

    public final void setGstin(String str) {
        k.c(str, "<set-?>");
        this.gstin = str;
    }

    public final Boolean getHas_gstin() {
        return this.has_gstin;
    }

    public final void setHas_gstin(Boolean bool) {
        this.has_gstin = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GSTDetails(String str, Boolean bool, BillingAddress billingAddress, int i2, g gVar) {
        this(str, (i2 & 2) != 0 ? null : bool, (i2 & 4) != 0 ? null : billingAddress);
    }

    public final BillingAddress getBilling_address() {
        return this.billing_address;
    }

    public final void setBilling_address(BillingAddress billingAddress) {
        this.billing_address = billingAddress;
    }
}
