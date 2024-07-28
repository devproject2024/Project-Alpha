package net.one97.paytm.hotel4.service.model.details;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.o;
import java.util.ArrayList;
import kotlin.g.b.g;

public final class PriceData {
    private double finalCGST;
    private double finalPrice;
    private double finalSGST;
    @b(a = "taxDetails")
    private ArrayList<o> mTaxesList;
    private double originalPrice;
    private double totalPrice;
    private double totalPriceWithTax;

    public PriceData() {
        this(0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, (ArrayList) null, 127, (g) null);
    }

    public PriceData(double d2, double d3, double d4, double d5, double d6, double d7, ArrayList<o> arrayList) {
        this.originalPrice = d2;
        this.finalPrice = d3;
        this.totalPrice = d4;
        this.totalPriceWithTax = d5;
        this.finalCGST = d6;
        this.finalSGST = d7;
        this.mTaxesList = arrayList;
    }

    public final double getOriginalPrice() {
        return this.originalPrice;
    }

    public final void setOriginalPrice(double d2) {
        this.originalPrice = d2;
    }

    public final double getFinalPrice() {
        return this.finalPrice;
    }

    public final void setFinalPrice(double d2) {
        this.finalPrice = d2;
    }

    public final double getTotalPrice() {
        return this.totalPrice;
    }

    public final void setTotalPrice(double d2) {
        this.totalPrice = d2;
    }

    public final double getTotalPriceWithTax() {
        return this.totalPriceWithTax;
    }

    public final void setTotalPriceWithTax(double d2) {
        this.totalPriceWithTax = d2;
    }

    public final double getFinalCGST() {
        return this.finalCGST;
    }

    public final void setFinalCGST(double d2) {
        this.finalCGST = d2;
    }

    public final double getFinalSGST() {
        return this.finalSGST;
    }

    public final void setFinalSGST(double d2) {
        this.finalSGST = d2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PriceData(double r14, double r16, double r18, double r20, double r22, double r24, java.util.ArrayList r26, int r27, kotlin.g.b.g r28) {
        /*
            r13 = this;
            r0 = r27 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r14
        L_0x0009:
            r0 = r27 & 2
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0011
        L_0x000f:
            r5 = r16
        L_0x0011:
            r0 = r27 & 4
            if (r0 == 0) goto L_0x0017
            r7 = r1
            goto L_0x0019
        L_0x0017:
            r7 = r18
        L_0x0019:
            r0 = r27 & 8
            if (r0 == 0) goto L_0x001f
            r9 = r1
            goto L_0x0021
        L_0x001f:
            r9 = r20
        L_0x0021:
            r0 = r27 & 16
            if (r0 == 0) goto L_0x0027
            r11 = r1
            goto L_0x0029
        L_0x0027:
            r11 = r22
        L_0x0029:
            r0 = r27 & 32
            if (r0 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r1 = r24
        L_0x0030:
            r0 = r27 & 64
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0038
        L_0x0036:
            r0 = r26
        L_0x0038:
            r14 = r13
            r15 = r3
            r17 = r5
            r19 = r7
            r21 = r9
            r23 = r11
            r25 = r1
            r27 = r0
            r14.<init>(r15, r17, r19, r21, r23, r25, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.service.model.details.PriceData.<init>(double, double, double, double, double, double, java.util.ArrayList, int, kotlin.g.b.g):void");
    }

    public final ArrayList<o> getMTaxesList() {
        return this.mTaxesList;
    }

    public final void setMTaxesList(ArrayList<o> arrayList) {
        this.mTaxesList = arrayList;
    }
}
