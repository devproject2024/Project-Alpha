package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRDealDecorator extends IJRPaytmDataModel {
    @a
    @b(a = "colour_tag")
    private String colourTag;
    @a
    @b(a = "deal_txt")
    private String dealTxt;

    public CJRDealDecorator() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRDealDecorator copy$default(CJRDealDecorator cJRDealDecorator, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRDealDecorator.dealTxt;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRDealDecorator.colourTag;
        }
        return cJRDealDecorator.copy(str, str2);
    }

    public final String component1() {
        return this.dealTxt;
    }

    public final String component2() {
        return this.colourTag;
    }

    public final CJRDealDecorator copy(String str, String str2) {
        return new CJRDealDecorator(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRDealDecorator)) {
            return false;
        }
        CJRDealDecorator cJRDealDecorator = (CJRDealDecorator) obj;
        return k.a((Object) this.dealTxt, (Object) cJRDealDecorator.dealTxt) && k.a((Object) this.colourTag, (Object) cJRDealDecorator.colourTag);
    }

    public final int hashCode() {
        String str = this.dealTxt;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.colourTag;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRDealDecorator(dealTxt=" + this.dealTxt + ", colourTag=" + this.colourTag + ")";
    }

    public final String getDealTxt() {
        return this.dealTxt;
    }

    public final void setDealTxt(String str) {
        this.dealTxt = str;
    }

    public CJRDealDecorator(String str, String str2) {
        this.dealTxt = str;
        this.colourTag = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRDealDecorator(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getColourTag() {
        return this.colourTag;
    }

    public final void setColourTag(String str) {
        this.colourTag = str;
    }
}
