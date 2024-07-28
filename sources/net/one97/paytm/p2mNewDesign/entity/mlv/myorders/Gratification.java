package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class Gratification extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "amount")
    private Double amount;
    @b(a = "crosspromo")
    private Object crosspromo;
    @b(a = "crosspromo_valid_from")
    private Object crosspromoValidFrom;
    @b(a = "crosspromo_valid_upto")
    private Object crosspromoValidUpto;
    @b(a = "cta")
    private Object cta;
    @b(a = "icon")
    private String icon;
    @b(a = "promocode")
    private String promocode;
    @b(a = "sub_redemption_type")
    private String subRedemptionType;
    @b(a = "text")
    private Object text;
    @b(a = "title")
    private String title;

    public Gratification() {
        this((String) null, (String) null, (String) null, (String) null, (Object) null, (Double) null, (Object) null, (Object) null, (Object) null, (Object) null, 1023, (g) null);
    }

    public static /* synthetic */ Gratification copy$default(Gratification gratification, String str, String str2, String str3, String str4, Object obj, Double d2, Object obj2, Object obj3, Object obj4, Object obj5, int i2, Object obj6) {
        Gratification gratification2 = gratification;
        int i3 = i2;
        return gratification.copy((i3 & 1) != 0 ? gratification2.promocode : str, (i3 & 2) != 0 ? gratification2.icon : str2, (i3 & 4) != 0 ? gratification2.title : str3, (i3 & 8) != 0 ? gratification2.subRedemptionType : str4, (i3 & 16) != 0 ? gratification2.text : obj, (i3 & 32) != 0 ? gratification2.amount : d2, (i3 & 64) != 0 ? gratification2.cta : obj2, (i3 & 128) != 0 ? gratification2.crosspromo : obj3, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? gratification2.crosspromoValidFrom : obj4, (i3 & 512) != 0 ? gratification2.crosspromoValidUpto : obj5);
    }

    public final String component1() {
        return this.promocode;
    }

    public final Object component10() {
        return this.crosspromoValidUpto;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.subRedemptionType;
    }

    public final Object component5() {
        return this.text;
    }

    public final Double component6() {
        return this.amount;
    }

    public final Object component7() {
        return this.cta;
    }

    public final Object component8() {
        return this.crosspromo;
    }

    public final Object component9() {
        return this.crosspromoValidFrom;
    }

    public final Gratification copy(String str, String str2, String str3, String str4, Object obj, Double d2, Object obj2, Object obj3, Object obj4, Object obj5) {
        return new Gratification(str, str2, str3, str4, obj, d2, obj2, obj3, obj4, obj5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Gratification)) {
            return false;
        }
        Gratification gratification = (Gratification) obj;
        return k.a((Object) this.promocode, (Object) gratification.promocode) && k.a((Object) this.icon, (Object) gratification.icon) && k.a((Object) this.title, (Object) gratification.title) && k.a((Object) this.subRedemptionType, (Object) gratification.subRedemptionType) && k.a(this.text, gratification.text) && k.a((Object) this.amount, (Object) gratification.amount) && k.a(this.cta, gratification.cta) && k.a(this.crosspromo, gratification.crosspromo) && k.a(this.crosspromoValidFrom, gratification.crosspromoValidFrom) && k.a(this.crosspromoValidUpto, gratification.crosspromoValidUpto);
    }

    public final int hashCode() {
        String str = this.promocode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subRedemptionType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Object obj = this.text;
        int hashCode5 = (hashCode4 + (obj != null ? obj.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode6 = (hashCode5 + (d2 != null ? d2.hashCode() : 0)) * 31;
        Object obj2 = this.cta;
        int hashCode7 = (hashCode6 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.crosspromo;
        int hashCode8 = (hashCode7 + (obj3 != null ? obj3.hashCode() : 0)) * 31;
        Object obj4 = this.crosspromoValidFrom;
        int hashCode9 = (hashCode8 + (obj4 != null ? obj4.hashCode() : 0)) * 31;
        Object obj5 = this.crosspromoValidUpto;
        if (obj5 != null) {
            i2 = obj5.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "Gratification(promocode=" + this.promocode + ", icon=" + this.icon + ", title=" + this.title + ", subRedemptionType=" + this.subRedemptionType + ", text=" + this.text + ", amount=" + this.amount + ", cta=" + this.cta + ", crosspromo=" + this.crosspromo + ", crosspromoValidFrom=" + this.crosspromoValidFrom + ", crosspromoValidUpto=" + this.crosspromoValidUpto + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getPromocode() {
        return this.promocode;
    }

    public final void setPromocode(String str) {
        this.promocode = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSubRedemptionType() {
        return this.subRedemptionType;
    }

    public final void setSubRedemptionType(String str) {
        this.subRedemptionType = str;
    }

    public final Object getText() {
        return this.text;
    }

    public final void setText(Object obj) {
        this.text = obj;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final void setAmount(Double d2) {
        this.amount = d2;
    }

    public final Object getCta() {
        return this.cta;
    }

    public final void setCta(Object obj) {
        this.cta = obj;
    }

    public final Object getCrosspromo() {
        return this.crosspromo;
    }

    public final void setCrosspromo(Object obj) {
        this.crosspromo = obj;
    }

    public final Object getCrosspromoValidFrom() {
        return this.crosspromoValidFrom;
    }

    public final void setCrosspromoValidFrom(Object obj) {
        this.crosspromoValidFrom = obj;
    }

    public Gratification(String str, String str2, String str3, String str4, Object obj, Double d2, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.promocode = str;
        this.icon = str2;
        this.title = str3;
        this.subRedemptionType = str4;
        this.text = obj;
        this.amount = d2;
        this.cta = obj2;
        this.crosspromo = obj3;
        this.crosspromoValidFrom = obj4;
        this.crosspromoValidUpto = obj5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Gratification(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Object r16, java.lang.Double r17, java.lang.Object r18, java.lang.Object r19, java.lang.Object r20, java.lang.Object r21, int r22, kotlin.g.b.g r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.Gratification.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Double, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, int, kotlin.g.b.g):void");
    }

    public final Object getCrosspromoValidUpto() {
        return this.crosspromoValidUpto;
    }

    public final void setCrosspromoValidUpto(Object obj) {
        this.crosspromoValidUpto = obj;
    }
}
