package net.one97.paytm.upi.mandate.data.model;

import com.google.gson.a.c;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class MandateTimeLineItem implements UpiBaseDataModel {
    @c(a = "date")
    private final String date;
    @c(a = "imageUrl")
    private final String imageUrl;
    @c(a = "message")
    private final String message;
    @c(a = "rrn")
    private final String rrn;
    @c(a = "status")
    private final String status;
    @c(a = "subtext")
    private final String subtext;
    @c(a = "txnId")
    private final String txnId;

    public static /* synthetic */ MandateTimeLineItem copy$default(MandateTimeLineItem mandateTimeLineItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mandateTimeLineItem.imageUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = mandateTimeLineItem.message;
        }
        String str8 = str2;
        if ((i2 & 4) != 0) {
            str3 = mandateTimeLineItem.status;
        }
        String str9 = str3;
        if ((i2 & 8) != 0) {
            str4 = mandateTimeLineItem.date;
        }
        String str10 = str4;
        if ((i2 & 16) != 0) {
            str5 = mandateTimeLineItem.rrn;
        }
        String str11 = str5;
        if ((i2 & 32) != 0) {
            str6 = mandateTimeLineItem.txnId;
        }
        String str12 = str6;
        if ((i2 & 64) != 0) {
            str7 = mandateTimeLineItem.subtext;
        }
        return mandateTimeLineItem.copy(str, str8, str9, str10, str11, str12, str7);
    }

    public final String component1() {
        return this.imageUrl;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.status;
    }

    public final String component4() {
        return this.date;
    }

    public final String component5() {
        return this.rrn;
    }

    public final String component6() {
        return this.txnId;
    }

    public final String component7() {
        return this.subtext;
    }

    public final MandateTimeLineItem copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new MandateTimeLineItem(str, str2, str3, str4, str5, str6, str7);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateTimeLineItem)) {
            return false;
        }
        MandateTimeLineItem mandateTimeLineItem = (MandateTimeLineItem) obj;
        return k.a((Object) this.imageUrl, (Object) mandateTimeLineItem.imageUrl) && k.a((Object) this.message, (Object) mandateTimeLineItem.message) && k.a((Object) this.status, (Object) mandateTimeLineItem.status) && k.a((Object) this.date, (Object) mandateTimeLineItem.date) && k.a((Object) this.rrn, (Object) mandateTimeLineItem.rrn) && k.a((Object) this.txnId, (Object) mandateTimeLineItem.txnId) && k.a((Object) this.subtext, (Object) mandateTimeLineItem.subtext);
    }

    public final int hashCode() {
        String str = this.imageUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.date;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.rrn;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.txnId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.subtext;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "MandateTimeLineItem(imageUrl=" + this.imageUrl + ", message=" + this.message + ", status=" + this.status + ", date=" + this.date + ", rrn=" + this.rrn + ", txnId=" + this.txnId + ", subtext=" + this.subtext + ")";
    }

    public MandateTimeLineItem(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.imageUrl = str;
        this.message = str2;
        this.status = str3;
        this.date = str4;
        this.rrn = str5;
        this.txnId = str6;
        this.subtext = str7;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getRrn() {
        return this.rrn;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final String getSubtext() {
        return this.subtext;
    }
}
