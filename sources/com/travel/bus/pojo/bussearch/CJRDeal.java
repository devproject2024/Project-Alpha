package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRDeal implements IJRDataModel {
    @a
    @b(a = "code")
    private String code;
    @a
    @b(a = "discount")
    private Double discount;
    @a
    @b(a = "display_text")
    private String displayText;
    @a
    @b(a = "id")
    private String id;
    @a
    @b(a = "revised_base_fare")
    private Double revisedBaseFare;
    @a
    @b(a = "revised_gst")
    private Double revisedGst;

    public CJRDeal() {
        this((String) null, (String) null, (String) null, (Double) null, (Double) null, (Double) null, 63, (g) null);
    }

    public static /* synthetic */ CJRDeal copy$default(CJRDeal cJRDeal, String str, String str2, String str3, Double d2, Double d3, Double d4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRDeal.id;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRDeal.code;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = cJRDeal.displayText;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            d2 = cJRDeal.discount;
        }
        Double d5 = d2;
        if ((i2 & 16) != 0) {
            d3 = cJRDeal.revisedBaseFare;
        }
        Double d6 = d3;
        if ((i2 & 32) != 0) {
            d4 = cJRDeal.revisedGst;
        }
        return cJRDeal.copy(str, str4, str5, d5, d6, d4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.displayText;
    }

    public final Double component4() {
        return this.discount;
    }

    public final Double component5() {
        return this.revisedBaseFare;
    }

    public final Double component6() {
        return this.revisedGst;
    }

    public final CJRDeal copy(String str, String str2, String str3, Double d2, Double d3, Double d4) {
        return new CJRDeal(str, str2, str3, d2, d3, d4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRDeal)) {
            return false;
        }
        CJRDeal cJRDeal = (CJRDeal) obj;
        return k.a((Object) this.id, (Object) cJRDeal.id) && k.a((Object) this.code, (Object) cJRDeal.code) && k.a((Object) this.displayText, (Object) cJRDeal.displayText) && k.a((Object) this.discount, (Object) cJRDeal.discount) && k.a((Object) this.revisedBaseFare, (Object) cJRDeal.revisedBaseFare) && k.a((Object) this.revisedGst, (Object) cJRDeal.revisedGst);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.code;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d2 = this.discount;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.revisedBaseFare;
        int hashCode5 = (hashCode4 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.revisedGst;
        if (d4 != null) {
            i2 = d4.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CJRDeal(id=" + this.id + ", code=" + this.code + ", displayText=" + this.displayText + ", discount=" + this.discount + ", revisedBaseFare=" + this.revisedBaseFare + ", revisedGst=" + this.revisedGst + ")";
    }

    public CJRDeal(String str, String str2, String str3, Double d2, Double d3, Double d4) {
        this.id = str;
        this.code = str2;
        this.displayText = str3;
        this.discount = d2;
        this.revisedBaseFare = d3;
        this.revisedGst = d4;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final void setDisplayText(String str) {
        this.displayText = str;
    }

    public final Double getDiscount() {
        return this.discount;
    }

    public final void setDiscount(Double d2) {
        this.discount = d2;
    }

    public final Double getRevisedBaseFare() {
        return this.revisedBaseFare;
    }

    public final void setRevisedBaseFare(Double d2) {
        this.revisedBaseFare = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRDeal(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.Double r9, java.lang.Double r10, java.lang.Double r11, int r12, kotlin.g.b.g r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.pojo.bussearch.CJRDeal.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getRevisedGst() {
        return this.revisedGst;
    }

    public final void setRevisedGst(Double d2) {
        this.revisedGst = d2;
    }
}
