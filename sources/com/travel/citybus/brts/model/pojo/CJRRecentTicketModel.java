package com.travel.citybus.brts.model.pojo;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class CJRRecentTicketModel {
    private boolean acFlag;
    private String busNumber;
    private String date;
    private String from;
    private String to;

    public static /* synthetic */ CJRRecentTicketModel copy$default(CJRRecentTicketModel cJRRecentTicketModel, String str, String str2, boolean z, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRRecentTicketModel.busNumber;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRRecentTicketModel.date;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            z = cJRRecentTicketModel.acFlag;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = cJRRecentTicketModel.from;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = cJRRecentTicketModel.to;
        }
        return cJRRecentTicketModel.copy(str, str5, z2, str6, str4);
    }

    public final String component1() {
        return this.busNumber;
    }

    public final String component2() {
        return this.date;
    }

    public final boolean component3() {
        return this.acFlag;
    }

    public final String component4() {
        return this.from;
    }

    public final String component5() {
        return this.to;
    }

    public final CJRRecentTicketModel copy(String str, String str2, boolean z, String str3, String str4) {
        k.c(str, "busNumber");
        k.c(str2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        k.c(str3, "from");
        k.c(str4, "to");
        return new CJRRecentTicketModel(str, str2, z, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRecentTicketModel)) {
            return false;
        }
        CJRRecentTicketModel cJRRecentTicketModel = (CJRRecentTicketModel) obj;
        return k.a((Object) this.busNumber, (Object) cJRRecentTicketModel.busNumber) && k.a((Object) this.date, (Object) cJRRecentTicketModel.date) && this.acFlag == cJRRecentTicketModel.acFlag && k.a((Object) this.from, (Object) cJRRecentTicketModel.from) && k.a((Object) this.to, (Object) cJRRecentTicketModel.to);
    }

    public final int hashCode() {
        String str = this.busNumber;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.date;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.acFlag;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.from;
        int hashCode3 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.to;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRRecentTicketModel(busNumber=" + this.busNumber + ", date=" + this.date + ", acFlag=" + this.acFlag + ", from=" + this.from + ", to=" + this.to + ")";
    }

    public CJRRecentTicketModel(String str, String str2, boolean z, String str3, String str4) {
        k.c(str, "busNumber");
        k.c(str2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
        k.c(str3, "from");
        k.c(str4, "to");
        this.busNumber = str;
        this.date = str2;
        this.acFlag = z;
        this.from = str3;
        this.to = str4;
    }

    public final String getBusNumber() {
        return this.busNumber;
    }

    public final void setBusNumber(String str) {
        k.c(str, "<set-?>");
        this.busNumber = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        k.c(str, "<set-?>");
        this.date = str;
    }

    public final boolean getAcFlag() {
        return this.acFlag;
    }

    public final void setAcFlag(boolean z) {
        this.acFlag = z;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        k.c(str, "<set-?>");
        this.from = str;
    }

    public final String getTo() {
        return this.to;
    }

    public final void setTo(String str) {
        k.c(str, "<set-?>");
        this.to = str;
    }
}
