package net.one97.paytm.appsflyerModel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class ReferalResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private ReferalData data;
    @b(a = "errors")
    private ArrayList<Error> errors;
    @b(a = "status")
    private Integer status;

    public ReferalResponse() {
        this((Integer) null, (ReferalData) null, (ArrayList) null, 7, (g) null);
    }

    public static /* synthetic */ ReferalResponse copy$default(ReferalResponse referalResponse, Integer num, ReferalData referalData, ArrayList<Error> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = referalResponse.status;
        }
        if ((i2 & 2) != 0) {
            referalData = referalResponse.data;
        }
        if ((i2 & 4) != 0) {
            arrayList = referalResponse.errors;
        }
        return referalResponse.copy(num, referalData, arrayList);
    }

    public final Integer component1() {
        return this.status;
    }

    public final ReferalData component2() {
        return this.data;
    }

    public final ArrayList<Error> component3() {
        return this.errors;
    }

    public final ReferalResponse copy(Integer num, ReferalData referalData, ArrayList<Error> arrayList) {
        return new ReferalResponse(num, referalData, arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReferalResponse)) {
            return false;
        }
        ReferalResponse referalResponse = (ReferalResponse) obj;
        return k.a((Object) this.status, (Object) referalResponse.status) && k.a((Object) this.data, (Object) referalResponse.data) && k.a((Object) this.errors, (Object) referalResponse.errors);
    }

    public final int hashCode() {
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        ReferalData referalData = this.data;
        int hashCode2 = (hashCode + (referalData != null ? referalData.hashCode() : 0)) * 31;
        ArrayList<Error> arrayList = this.errors;
        if (arrayList != null) {
            i2 = arrayList.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ReferalResponse(status=" + this.status + ", data=" + this.data + ", errors=" + this.errors + ")";
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final ReferalData getData() {
        return this.data;
    }

    public final void setData(ReferalData referalData) {
        this.data = referalData;
    }

    public ReferalResponse(Integer num, ReferalData referalData, ArrayList<Error> arrayList) {
        this.status = num;
        this.data = referalData;
        this.errors = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReferalResponse(Integer num, ReferalData referalData, ArrayList arrayList, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : referalData, (i2 & 4) != 0 ? null : arrayList);
    }

    public final ArrayList<Error> getErrors() {
        return this.errors;
    }

    public final void setErrors(ArrayList<Error> arrayList) {
        this.errors = arrayList;
    }
}
