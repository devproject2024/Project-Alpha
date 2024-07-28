package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRDetailedFare implements IJRDataModel {
    @a
    @b(a = "base_fare")
    private Double baseFare;
    @a
    @b(a = "deal")
    private CJRDeal deal;
    @a
    @b(a = "gst")
    private Double gst;
    private boolean hasDeals;
    @a
    @b(a = "other_fees")
    private Double otherFees;

    public CJRDetailedFare() {
        this((Double) null, (Double) null, (Double) null, (CJRDeal) null, false, 31, (g) null);
    }

    public static /* synthetic */ CJRDetailedFare copy$default(CJRDetailedFare cJRDetailedFare, Double d2, Double d3, Double d4, CJRDeal cJRDeal, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = cJRDetailedFare.baseFare;
        }
        if ((i2 & 2) != 0) {
            d3 = cJRDetailedFare.gst;
        }
        Double d5 = d3;
        if ((i2 & 4) != 0) {
            d4 = cJRDetailedFare.otherFees;
        }
        Double d6 = d4;
        if ((i2 & 8) != 0) {
            cJRDeal = cJRDetailedFare.deal;
        }
        CJRDeal cJRDeal2 = cJRDeal;
        if ((i2 & 16) != 0) {
            z = cJRDetailedFare.hasDeals;
        }
        return cJRDetailedFare.copy(d2, d5, d6, cJRDeal2, z);
    }

    public final Double component1() {
        return this.baseFare;
    }

    public final Double component2() {
        return this.gst;
    }

    public final Double component3() {
        return this.otherFees;
    }

    public final CJRDeal component4() {
        return this.deal;
    }

    public final boolean component5() {
        return this.hasDeals;
    }

    public final CJRDetailedFare copy(Double d2, Double d3, Double d4, CJRDeal cJRDeal, boolean z) {
        return new CJRDetailedFare(d2, d3, d4, cJRDeal, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRDetailedFare)) {
            return false;
        }
        CJRDetailedFare cJRDetailedFare = (CJRDetailedFare) obj;
        return k.a((Object) this.baseFare, (Object) cJRDetailedFare.baseFare) && k.a((Object) this.gst, (Object) cJRDetailedFare.gst) && k.a((Object) this.otherFees, (Object) cJRDetailedFare.otherFees) && k.a((Object) this.deal, (Object) cJRDetailedFare.deal) && this.hasDeals == cJRDetailedFare.hasDeals;
    }

    public final int hashCode() {
        Double d2 = this.baseFare;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Double d3 = this.gst;
        int hashCode2 = (hashCode + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.otherFees;
        int hashCode3 = (hashCode2 + (d4 != null ? d4.hashCode() : 0)) * 31;
        CJRDeal cJRDeal = this.deal;
        if (cJRDeal != null) {
            i2 = cJRDeal.hashCode();
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z = this.hasDeals;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CJRDetailedFare(baseFare=" + this.baseFare + ", gst=" + this.gst + ", otherFees=" + this.otherFees + ", deal=" + this.deal + ", hasDeals=" + this.hasDeals + ")";
    }

    public CJRDetailedFare(Double d2, Double d3, Double d4, CJRDeal cJRDeal, boolean z) {
        this.baseFare = d2;
        this.gst = d3;
        this.otherFees = d4;
        this.deal = cJRDeal;
        this.hasDeals = z;
    }

    public final Double getBaseFare() {
        return this.baseFare;
    }

    public final void setBaseFare(Double d2) {
        this.baseFare = d2;
    }

    public final Double getGst() {
        return this.gst;
    }

    public final void setGst(Double d2) {
        this.gst = d2;
    }

    public final Double getOtherFees() {
        return this.otherFees;
    }

    public final void setOtherFees(Double d2) {
        this.otherFees = d2;
    }

    public final CJRDeal getDeal() {
        return this.deal;
    }

    public final void setDeal(CJRDeal cJRDeal) {
        this.deal = cJRDeal;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRDetailedFare(java.lang.Double r4, java.lang.Double r5, java.lang.Double r6, com.travel.bus.pojo.bussearch.CJRDeal r7, boolean r8, int r9, kotlin.g.b.g r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r8 = 0
            r9 = 0
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.pojo.bussearch.CJRDetailedFare.<init>(java.lang.Double, java.lang.Double, java.lang.Double, com.travel.bus.pojo.bussearch.CJRDeal, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean getHasDeals() {
        return this.hasDeals;
    }

    public final void setHasDeals(boolean z) {
        this.hasDeals = z;
    }

    public final boolean bHasDeals() {
        return this.deal != null;
    }
}
