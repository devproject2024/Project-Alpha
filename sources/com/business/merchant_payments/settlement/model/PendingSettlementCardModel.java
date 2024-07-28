package com.business.merchant_payments.settlement.model;

import com.alipay.mobile.nebulacore.wallet.H5Logger;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class PendingSettlementCardModel {
    public String header;
    public boolean isCardVisible;
    public String summary;

    public static /* synthetic */ PendingSettlementCardModel copy$default(PendingSettlementCardModel pendingSettlementCardModel, boolean z, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = pendingSettlementCardModel.isCardVisible;
        }
        if ((i2 & 2) != 0) {
            str = pendingSettlementCardModel.header;
        }
        if ((i2 & 4) != 0) {
            str2 = pendingSettlementCardModel.summary;
        }
        return pendingSettlementCardModel.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.isCardVisible;
    }

    public final String component2() {
        return this.header;
    }

    public final String component3() {
        return this.summary;
    }

    public final PendingSettlementCardModel copy(boolean z, String str, String str2) {
        k.d(str, H5Logger.HEADER);
        k.d(str2, "summary");
        return new PendingSettlementCardModel(z, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingSettlementCardModel)) {
            return false;
        }
        PendingSettlementCardModel pendingSettlementCardModel = (PendingSettlementCardModel) obj;
        return this.isCardVisible == pendingSettlementCardModel.isCardVisible && k.a((Object) this.header, (Object) pendingSettlementCardModel.header) && k.a((Object) this.summary, (Object) pendingSettlementCardModel.summary);
    }

    public final int hashCode() {
        boolean z = this.isCardVisible;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.header;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.summary;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "PendingSettlementCardModel(isCardVisible=" + this.isCardVisible + ", header=" + this.header + ", summary=" + this.summary + ")";
    }

    public PendingSettlementCardModel(boolean z, String str, String str2) {
        k.d(str, H5Logger.HEADER);
        k.d(str2, "summary");
        this.isCardVisible = z;
        this.header = str;
        this.summary = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PendingSettlementCardModel(boolean z, String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, str, str2);
    }

    public final boolean isCardVisible() {
        return this.isCardVisible;
    }

    public final void setCardVisible(boolean z) {
        this.isCardVisible = z;
    }

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String str) {
        k.d(str, "<set-?>");
        this.header = str;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final void setSummary(String str) {
        k.d(str, "<set-?>");
        this.summary = str;
    }
}
