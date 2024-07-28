package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class PgResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "BANKNAME")
    private String BANKNAME;
    @b(a = "CUSTID")
    private String CUSTID;
    @b(a = "GATEWAYNAME")
    private String GATEWAYNAME;
    @b(a = "ORDERID")
    private String ORDERID;
    @b(a = "PAYMENTMODE")
    private String PAYMENTMODE;
    @b(a = "RESPCODE")
    private String RESPCODE;
    @b(a = "RESPMSG")
    private String RESPMSG;
    @b(a = "STATUS")
    private String STATUS;
    @b(a = "TXNAMOUNT")
    private String TXNAMOUNT;
    @b(a = "TXNDATE")
    private String TXNDATE;

    public PgResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (g) null);
    }

    public static /* synthetic */ PgResponseModel copy$default(PgResponseModel pgResponseModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, Object obj) {
        PgResponseModel pgResponseModel2 = pgResponseModel;
        int i3 = i2;
        return pgResponseModel.copy((i3 & 1) != 0 ? pgResponseModel2.ORDERID : str, (i3 & 2) != 0 ? pgResponseModel2.STATUS : str2, (i3 & 4) != 0 ? pgResponseModel2.TXNAMOUNT : str3, (i3 & 8) != 0 ? pgResponseModel2.RESPCODE : str4, (i3 & 16) != 0 ? pgResponseModel2.RESPMSG : str5, (i3 & 32) != 0 ? pgResponseModel2.TXNDATE : str6, (i3 & 64) != 0 ? pgResponseModel2.GATEWAYNAME : str7, (i3 & 128) != 0 ? pgResponseModel2.BANKNAME : str8, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? pgResponseModel2.PAYMENTMODE : str9, (i3 & 512) != 0 ? pgResponseModel2.CUSTID : str10);
    }

    public final String component1() {
        return this.ORDERID;
    }

    public final String component10() {
        return this.CUSTID;
    }

    public final String component2() {
        return this.STATUS;
    }

    public final String component3() {
        return this.TXNAMOUNT;
    }

    public final String component4() {
        return this.RESPCODE;
    }

    public final String component5() {
        return this.RESPMSG;
    }

    public final String component6() {
        return this.TXNDATE;
    }

    public final String component7() {
        return this.GATEWAYNAME;
    }

    public final String component8() {
        return this.BANKNAME;
    }

    public final String component9() {
        return this.PAYMENTMODE;
    }

    public final PgResponseModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return new PgResponseModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PgResponseModel)) {
            return false;
        }
        PgResponseModel pgResponseModel = (PgResponseModel) obj;
        return k.a((Object) this.ORDERID, (Object) pgResponseModel.ORDERID) && k.a((Object) this.STATUS, (Object) pgResponseModel.STATUS) && k.a((Object) this.TXNAMOUNT, (Object) pgResponseModel.TXNAMOUNT) && k.a((Object) this.RESPCODE, (Object) pgResponseModel.RESPCODE) && k.a((Object) this.RESPMSG, (Object) pgResponseModel.RESPMSG) && k.a((Object) this.TXNDATE, (Object) pgResponseModel.TXNDATE) && k.a((Object) this.GATEWAYNAME, (Object) pgResponseModel.GATEWAYNAME) && k.a((Object) this.BANKNAME, (Object) pgResponseModel.BANKNAME) && k.a((Object) this.PAYMENTMODE, (Object) pgResponseModel.PAYMENTMODE) && k.a((Object) this.CUSTID, (Object) pgResponseModel.CUSTID);
    }

    public final int hashCode() {
        String str = this.ORDERID;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.STATUS;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.TXNAMOUNT;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.RESPCODE;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.RESPMSG;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.TXNDATE;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.GATEWAYNAME;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.BANKNAME;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.PAYMENTMODE;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.CUSTID;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "PgResponseModel(ORDERID=" + this.ORDERID + ", STATUS=" + this.STATUS + ", TXNAMOUNT=" + this.TXNAMOUNT + ", RESPCODE=" + this.RESPCODE + ", RESPMSG=" + this.RESPMSG + ", TXNDATE=" + this.TXNDATE + ", GATEWAYNAME=" + this.GATEWAYNAME + ", BANKNAME=" + this.BANKNAME + ", PAYMENTMODE=" + this.PAYMENTMODE + ", CUSTID=" + this.CUSTID + ")";
    }

    public final String getORDERID() {
        return this.ORDERID;
    }

    public final void setORDERID(String str) {
        this.ORDERID = str;
    }

    public final String getSTATUS() {
        return this.STATUS;
    }

    public final void setSTATUS(String str) {
        this.STATUS = str;
    }

    public final String getTXNAMOUNT() {
        return this.TXNAMOUNT;
    }

    public final void setTXNAMOUNT(String str) {
        this.TXNAMOUNT = str;
    }

    public final String getRESPCODE() {
        return this.RESPCODE;
    }

    public final void setRESPCODE(String str) {
        this.RESPCODE = str;
    }

    public final String getRESPMSG() {
        return this.RESPMSG;
    }

    public final void setRESPMSG(String str) {
        this.RESPMSG = str;
    }

    public final String getTXNDATE() {
        return this.TXNDATE;
    }

    public final void setTXNDATE(String str) {
        this.TXNDATE = str;
    }

    public final String getGATEWAYNAME() {
        return this.GATEWAYNAME;
    }

    public final void setGATEWAYNAME(String str) {
        this.GATEWAYNAME = str;
    }

    public final String getBANKNAME() {
        return this.BANKNAME;
    }

    public final void setBANKNAME(String str) {
        this.BANKNAME = str;
    }

    public final String getPAYMENTMODE() {
        return this.PAYMENTMODE;
    }

    public final void setPAYMENTMODE(String str) {
        this.PAYMENTMODE = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PgResponseModel(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.g.b.g r23) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.model.PgResponseModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getCUSTID() {
        return this.CUSTID;
    }

    public final void setCUSTID(String str) {
        this.CUSTID = str;
    }

    public PgResponseModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.ORDERID = str;
        this.STATUS = str2;
        this.TXNAMOUNT = str3;
        this.RESPCODE = str4;
        this.RESPMSG = str5;
        this.TXNDATE = str6;
        this.GATEWAYNAME = str7;
        this.BANKNAME = str8;
        this.PAYMENTMODE = str9;
        this.CUSTID = str10;
    }
}
