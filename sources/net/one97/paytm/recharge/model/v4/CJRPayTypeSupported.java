package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class CJRPayTypeSupported implements IJRDataModel {
    @b(a = "cc")
    private final Integer cc;
    @b(a = "cod")
    private final Integer cod;
    @b(a = "dc")
    private final Integer dc;
    @b(a = "emi")
    private final Integer emi;
    @b(a = "escrow")
    private final Integer escrow;
    @b(a = "nb")
    private final Integer nb;
    @b(a = "paytmDigitalCredit")
    private final Integer paytmDigitalCredit;
    @b(a = "ppi")
    private final Integer ppi;
    @b(a = "upi")
    private final Integer upi;

    public CJRPayTypeSupported() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 511, (g) null);
    }

    public static /* synthetic */ CJRPayTypeSupported copy$default(CJRPayTypeSupported cJRPayTypeSupported, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, int i2, Object obj) {
        CJRPayTypeSupported cJRPayTypeSupported2 = cJRPayTypeSupported;
        int i3 = i2;
        return cJRPayTypeSupported.copy((i3 & 1) != 0 ? cJRPayTypeSupported2.cc : num, (i3 & 2) != 0 ? cJRPayTypeSupported2.emi : num2, (i3 & 4) != 0 ? cJRPayTypeSupported2.nb : num3, (i3 & 8) != 0 ? cJRPayTypeSupported2.ppi : num4, (i3 & 16) != 0 ? cJRPayTypeSupported2.cod : num5, (i3 & 32) != 0 ? cJRPayTypeSupported2.escrow : num6, (i3 & 64) != 0 ? cJRPayTypeSupported2.paytmDigitalCredit : num7, (i3 & 128) != 0 ? cJRPayTypeSupported2.dc : num8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? cJRPayTypeSupported2.upi : num9);
    }

    public final Integer component1() {
        return this.cc;
    }

    public final Integer component2() {
        return this.emi;
    }

    public final Integer component3() {
        return this.nb;
    }

    public final Integer component4() {
        return this.ppi;
    }

    public final Integer component5() {
        return this.cod;
    }

    public final Integer component6() {
        return this.escrow;
    }

    public final Integer component7() {
        return this.paytmDigitalCredit;
    }

    public final Integer component8() {
        return this.dc;
    }

    public final Integer component9() {
        return this.upi;
    }

    public final CJRPayTypeSupported copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9) {
        return new CJRPayTypeSupported(num, num2, num3, num4, num5, num6, num7, num8, num9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPayTypeSupported)) {
            return false;
        }
        CJRPayTypeSupported cJRPayTypeSupported = (CJRPayTypeSupported) obj;
        return k.a((Object) this.cc, (Object) cJRPayTypeSupported.cc) && k.a((Object) this.emi, (Object) cJRPayTypeSupported.emi) && k.a((Object) this.nb, (Object) cJRPayTypeSupported.nb) && k.a((Object) this.ppi, (Object) cJRPayTypeSupported.ppi) && k.a((Object) this.cod, (Object) cJRPayTypeSupported.cod) && k.a((Object) this.escrow, (Object) cJRPayTypeSupported.escrow) && k.a((Object) this.paytmDigitalCredit, (Object) cJRPayTypeSupported.paytmDigitalCredit) && k.a((Object) this.dc, (Object) cJRPayTypeSupported.dc) && k.a((Object) this.upi, (Object) cJRPayTypeSupported.upi);
    }

    public final int hashCode() {
        Integer num = this.cc;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.emi;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.nb;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.ppi;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.cod;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.escrow;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.paytmDigitalCredit;
        int hashCode7 = (hashCode6 + (num7 != null ? num7.hashCode() : 0)) * 31;
        Integer num8 = this.dc;
        int hashCode8 = (hashCode7 + (num8 != null ? num8.hashCode() : 0)) * 31;
        Integer num9 = this.upi;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        return hashCode8 + i2;
    }

    public final String toString() {
        return "CJRPayTypeSupported(cc=" + this.cc + ", emi=" + this.emi + ", nb=" + this.nb + ", ppi=" + this.ppi + ", cod=" + this.cod + ", escrow=" + this.escrow + ", paytmDigitalCredit=" + this.paytmDigitalCredit + ", dc=" + this.dc + ", upi=" + this.upi + ")";
    }

    public CJRPayTypeSupported(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9) {
        this.cc = num;
        this.emi = num2;
        this.nb = num3;
        this.ppi = num4;
        this.cod = num5;
        this.escrow = num6;
        this.paytmDigitalCredit = num7;
        this.dc = num8;
        this.upi = num9;
    }

    public final Integer getCc() {
        return this.cc;
    }

    public final Integer getEmi() {
        return this.emi;
    }

    public final Integer getNb() {
        return this.nb;
    }

    public final Integer getPpi() {
        return this.ppi;
    }

    public final Integer getCod() {
        return this.cod;
    }

    public final Integer getEscrow() {
        return this.escrow;
    }

    public final Integer getPaytmDigitalCredit() {
        return this.paytmDigitalCredit;
    }

    public final Integer getDc() {
        return this.dc;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRPayTypeSupported(java.lang.Integer r11, java.lang.Integer r12, java.lang.Integer r13, java.lang.Integer r14, java.lang.Integer r15, java.lang.Integer r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.Integer r19, int r20, kotlin.g.b.g r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r15
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r16
        L_0x002e:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r17
        L_0x0036:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r18
        L_0x003e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r2 = r19
        L_0x0045:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.model.v4.CJRPayTypeSupported.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.g.b.g):void");
    }

    public final Integer getUpi() {
        return this.upi;
    }
}
