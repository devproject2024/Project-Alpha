package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbTrackingStatusFlow extends IJRPaytmDataModel {
    @b(a = "created_at")
    private final String created_at;
    @b(a = "id")
    private final Integer id;
    @b(a = "text")
    private final String text;

    public static /* synthetic */ CbTrackingStatusFlow copy$default(CbTrackingStatusFlow cbTrackingStatusFlow, String str, Integer num, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbTrackingStatusFlow.text;
        }
        if ((i2 & 2) != 0) {
            num = cbTrackingStatusFlow.id;
        }
        if ((i2 & 4) != 0) {
            str2 = cbTrackingStatusFlow.created_at;
        }
        return cbTrackingStatusFlow.copy(str, num, str2);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component2() {
        return this.id;
    }

    public final String component3() {
        return this.created_at;
    }

    public final CbTrackingStatusFlow copy(String str, Integer num, String str2) {
        return new CbTrackingStatusFlow(str, num, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbTrackingStatusFlow)) {
            return false;
        }
        CbTrackingStatusFlow cbTrackingStatusFlow = (CbTrackingStatusFlow) obj;
        return k.a((Object) this.text, (Object) cbTrackingStatusFlow.text) && k.a((Object) this.id, (Object) cbTrackingStatusFlow.id) && k.a((Object) this.created_at, (Object) cbTrackingStatusFlow.created_at);
    }

    public final int hashCode() {
        String str = this.text;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.created_at;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CbTrackingStatusFlow(text=" + this.text + ", id=" + this.id + ", created_at=" + this.created_at + ")";
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getId() {
        return this.id;
    }

    public CbTrackingStatusFlow(String str, Integer num, String str2) {
        this.text = str;
        this.id = num;
        this.created_at = str2;
    }

    public final String getCreated_at() {
        return this.created_at;
    }
}
