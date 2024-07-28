package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ReferralMain extends IJRPaytmDataModel {
    @b(a = "data")
    private ReferralData data;
    @b(a = "errors")
    private ArrayList<Error> errors;
    @b(a = "status")
    private String status;

    public ReferralMain() {
        this((String) null, (ArrayList) null, (ReferralData) null, 7, (g) null);
    }

    public static /* synthetic */ ReferralMain copy$default(ReferralMain referralMain, String str, ArrayList<Error> arrayList, ReferralData referralData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = referralMain.status;
        }
        if ((i2 & 2) != 0) {
            arrayList = referralMain.errors;
        }
        if ((i2 & 4) != 0) {
            referralData = referralMain.data;
        }
        return referralMain.copy(str, arrayList, referralData);
    }

    public final String component1() {
        return this.status;
    }

    public final ArrayList<Error> component2() {
        return this.errors;
    }

    public final ReferralData component3() {
        return this.data;
    }

    public final ReferralMain copy(String str, ArrayList<Error> arrayList, ReferralData referralData) {
        return new ReferralMain(str, arrayList, referralData);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReferralMain)) {
            return false;
        }
        ReferralMain referralMain = (ReferralMain) obj;
        return k.a((Object) this.status, (Object) referralMain.status) && k.a((Object) this.errors, (Object) referralMain.errors) && k.a((Object) this.data, (Object) referralMain.data);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<Error> arrayList = this.errors;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        ReferralData referralData = this.data;
        if (referralData != null) {
            i2 = referralData.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ReferralMain(status=" + this.status + ", errors=" + this.errors + ", data=" + this.data + ")";
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
    public /* synthetic */ ReferralMain(String str, ArrayList arrayList, ReferralData referralData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : arrayList, (i2 & 4) != 0 ? null : referralData);
    }

    public final ReferralData getData() {
        return this.data;
    }

    public final void setData(ReferralData referralData) {
        this.data = referralData;
    }

    public ReferralMain(String str, ArrayList<Error> arrayList, ReferralData referralData) {
        this.status = str;
        this.errors = arrayList;
        this.data = referralData;
    }
}
