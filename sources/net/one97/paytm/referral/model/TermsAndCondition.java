package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TermsAndCondition extends IJRPaytmDataModel {
    @b(a = "data")
    private TermsAndConditionData data;
    @b(a = "errors")
    private ArrayList<Error> errors;
    @b(a = "status")
    private String status;

    public TermsAndCondition() {
        this((String) null, (ArrayList) null, (TermsAndConditionData) null, 7, (g) null);
    }

    public static /* synthetic */ TermsAndCondition copy$default(TermsAndCondition termsAndCondition, String str, ArrayList<Error> arrayList, TermsAndConditionData termsAndConditionData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = termsAndCondition.status;
        }
        if ((i2 & 2) != 0) {
            arrayList = termsAndCondition.errors;
        }
        if ((i2 & 4) != 0) {
            termsAndConditionData = termsAndCondition.data;
        }
        return termsAndCondition.copy(str, arrayList, termsAndConditionData);
    }

    public final String component1() {
        return this.status;
    }

    public final ArrayList<Error> component2() {
        return this.errors;
    }

    public final TermsAndConditionData component3() {
        return this.data;
    }

    public final TermsAndCondition copy(String str, ArrayList<Error> arrayList, TermsAndConditionData termsAndConditionData) {
        return new TermsAndCondition(str, arrayList, termsAndConditionData);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermsAndCondition)) {
            return false;
        }
        TermsAndCondition termsAndCondition = (TermsAndCondition) obj;
        return k.a((Object) this.status, (Object) termsAndCondition.status) && k.a((Object) this.errors, (Object) termsAndCondition.errors) && k.a((Object) this.data, (Object) termsAndCondition.data);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<Error> arrayList = this.errors;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        TermsAndConditionData termsAndConditionData = this.data;
        if (termsAndConditionData != null) {
            i2 = termsAndConditionData.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "TermsAndCondition(status=" + this.status + ", errors=" + this.errors + ", data=" + this.data + ")";
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
    public /* synthetic */ TermsAndCondition(String str, ArrayList arrayList, TermsAndConditionData termsAndConditionData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : arrayList, (i2 & 4) != 0 ? null : termsAndConditionData);
    }

    public final TermsAndConditionData getData() {
        return this.data;
    }

    public final void setData(TermsAndConditionData termsAndConditionData) {
        this.data = termsAndConditionData;
    }

    public TermsAndCondition(String str, ArrayList<Error> arrayList, TermsAndConditionData termsAndConditionData) {
        this.status = str;
        this.errors = arrayList;
        this.data = termsAndConditionData;
    }
}
