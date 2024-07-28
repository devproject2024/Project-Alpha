package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class OtherCampaignLink extends IJRPaytmDataModel {
    @b(a = "data")
    private OTCLink data;
    @b(a = "errors")
    private ArrayList<Error> errors;
    @b(a = "status")
    private String status;

    public OtherCampaignLink() {
        this((String) null, (ArrayList) null, (OTCLink) null, 7, (g) null);
    }

    public static /* synthetic */ OtherCampaignLink copy$default(OtherCampaignLink otherCampaignLink, String str, ArrayList<Error> arrayList, OTCLink oTCLink, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = otherCampaignLink.status;
        }
        if ((i2 & 2) != 0) {
            arrayList = otherCampaignLink.errors;
        }
        if ((i2 & 4) != 0) {
            oTCLink = otherCampaignLink.data;
        }
        return otherCampaignLink.copy(str, arrayList, oTCLink);
    }

    public final String component1() {
        return this.status;
    }

    public final ArrayList<Error> component2() {
        return this.errors;
    }

    public final OTCLink component3() {
        return this.data;
    }

    public final OtherCampaignLink copy(String str, ArrayList<Error> arrayList, OTCLink oTCLink) {
        return new OtherCampaignLink(str, arrayList, oTCLink);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtherCampaignLink)) {
            return false;
        }
        OtherCampaignLink otherCampaignLink = (OtherCampaignLink) obj;
        return k.a((Object) this.status, (Object) otherCampaignLink.status) && k.a((Object) this.errors, (Object) otherCampaignLink.errors) && k.a((Object) this.data, (Object) otherCampaignLink.data);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<Error> arrayList = this.errors;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        OTCLink oTCLink = this.data;
        if (oTCLink != null) {
            i2 = oTCLink.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "OtherCampaignLink(status=" + this.status + ", errors=" + this.errors + ", data=" + this.data + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final ArrayList<Error> getErrors() {
        return this.errors;
    }

    public final void setErrors(ArrayList<Error> arrayList) {
        this.errors = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OtherCampaignLink(String str, ArrayList arrayList, OTCLink oTCLink, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : arrayList, (i2 & 4) != 0 ? null : oTCLink);
    }

    public final OTCLink getData() {
        return this.data;
    }

    public final void setData(OTCLink oTCLink) {
        this.data = oTCLink;
    }

    public OtherCampaignLink(String str, ArrayList<Error> arrayList, OTCLink oTCLink) {
        this.status = str;
        this.errors = arrayList;
        this.data = oTCLink;
    }
}
