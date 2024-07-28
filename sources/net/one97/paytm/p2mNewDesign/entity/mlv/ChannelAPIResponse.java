package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class ChannelAPIResponse extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "errorCode")
    private final String errorCode;
    @b(a = "hitPG")
    private final String hitPG;
    @b(a = "MID")
    private final String mID;
    @b(a = "message")
    private final Object message;
    @b(a = "mid")
    private final String mid;
    @b(a = "native_withdraw")
    private final String nativeWithdraw;
    @b(a = "native_withdraw_details")
    private final NativeWithdrawDetails nativeWithdrawDetails;
    @b(a = "ORDER_ID")
    private final String oRDERID;
    @b(a = "pgUrlToHit")
    private final String pgUrlToHit;
    @b(a = "status")
    private final Object status;
    @b(a = "THEME")
    private final String tHEME;
    @b(a = "TOKEN_TYPE")
    private final String tOKENTYPE;
    @b(a = "TXN_AMOUNT")
    private final String tXNAMOUNT;

    public ChannelAPIResponse() {
        this((String) null, (String) null, (NativeWithdrawDetails) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Object) null, (Object) null, (String) null, (String) null, 8191, (g) null);
    }

    public static /* synthetic */ ChannelAPIResponse copy$default(ChannelAPIResponse channelAPIResponse, String str, String str2, NativeWithdrawDetails nativeWithdrawDetails2, String str3, String str4, String str5, String str6, String str7, String str8, Object obj, Object obj2, String str9, String str10, int i2, Object obj3) {
        ChannelAPIResponse channelAPIResponse2 = channelAPIResponse;
        int i3 = i2;
        return channelAPIResponse.copy((i3 & 1) != 0 ? channelAPIResponse2.mid : str, (i3 & 2) != 0 ? channelAPIResponse2.nativeWithdraw : str2, (i3 & 4) != 0 ? channelAPIResponse2.nativeWithdrawDetails : nativeWithdrawDetails2, (i3 & 8) != 0 ? channelAPIResponse2.oRDERID : str3, (i3 & 16) != 0 ? channelAPIResponse2.mID : str4, (i3 & 32) != 0 ? channelAPIResponse2.tXNAMOUNT : str5, (i3 & 64) != 0 ? channelAPIResponse2.pgUrlToHit : str6, (i3 & 128) != 0 ? channelAPIResponse2.tOKENTYPE : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? channelAPIResponse2.tHEME : str8, (i3 & 512) != 0 ? channelAPIResponse2.status : obj, (i3 & TarConstants.EOF_BLOCK) != 0 ? channelAPIResponse2.message : obj2, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? channelAPIResponse2.hitPG : str9, (i3 & 4096) != 0 ? channelAPIResponse2.errorCode : str10);
    }

    public final String component1() {
        return this.mid;
    }

    public final Object component10() {
        return this.status;
    }

    public final Object component11() {
        return this.message;
    }

    public final String component12() {
        return this.hitPG;
    }

    public final String component13() {
        return this.errorCode;
    }

    public final String component2() {
        return this.nativeWithdraw;
    }

    public final NativeWithdrawDetails component3() {
        return this.nativeWithdrawDetails;
    }

    public final String component4() {
        return this.oRDERID;
    }

    public final String component5() {
        return this.mID;
    }

    public final String component6() {
        return this.tXNAMOUNT;
    }

    public final String component7() {
        return this.pgUrlToHit;
    }

    public final String component8() {
        return this.tOKENTYPE;
    }

    public final String component9() {
        return this.tHEME;
    }

    public final ChannelAPIResponse copy(String str, String str2, NativeWithdrawDetails nativeWithdrawDetails2, String str3, String str4, String str5, String str6, String str7, String str8, Object obj, Object obj2, String str9, String str10) {
        return new ChannelAPIResponse(str, str2, nativeWithdrawDetails2, str3, str4, str5, str6, str7, str8, obj, obj2, str9, str10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelAPIResponse)) {
            return false;
        }
        ChannelAPIResponse channelAPIResponse = (ChannelAPIResponse) obj;
        return k.a((Object) this.mid, (Object) channelAPIResponse.mid) && k.a((Object) this.nativeWithdraw, (Object) channelAPIResponse.nativeWithdraw) && k.a((Object) this.nativeWithdrawDetails, (Object) channelAPIResponse.nativeWithdrawDetails) && k.a((Object) this.oRDERID, (Object) channelAPIResponse.oRDERID) && k.a((Object) this.mID, (Object) channelAPIResponse.mID) && k.a((Object) this.tXNAMOUNT, (Object) channelAPIResponse.tXNAMOUNT) && k.a((Object) this.pgUrlToHit, (Object) channelAPIResponse.pgUrlToHit) && k.a((Object) this.tOKENTYPE, (Object) channelAPIResponse.tOKENTYPE) && k.a((Object) this.tHEME, (Object) channelAPIResponse.tHEME) && k.a(this.status, channelAPIResponse.status) && k.a(this.message, channelAPIResponse.message) && k.a((Object) this.hitPG, (Object) channelAPIResponse.hitPG) && k.a((Object) this.errorCode, (Object) channelAPIResponse.errorCode);
    }

    public final int hashCode() {
        String str = this.mid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nativeWithdraw;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        NativeWithdrawDetails nativeWithdrawDetails2 = this.nativeWithdrawDetails;
        int hashCode3 = (hashCode2 + (nativeWithdrawDetails2 != null ? nativeWithdrawDetails2.hashCode() : 0)) * 31;
        String str3 = this.oRDERID;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mID;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.tXNAMOUNT;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.pgUrlToHit;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.tOKENTYPE;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.tHEME;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Object obj = this.status;
        int hashCode10 = (hashCode9 + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.message;
        int hashCode11 = (hashCode10 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        String str9 = this.hitPG;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.errorCode;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        return hashCode12 + i2;
    }

    public final String toString() {
        return "ChannelAPIResponse(mid=" + this.mid + ", nativeWithdraw=" + this.nativeWithdraw + ", nativeWithdrawDetails=" + this.nativeWithdrawDetails + ", oRDERID=" + this.oRDERID + ", mID=" + this.mID + ", tXNAMOUNT=" + this.tXNAMOUNT + ", pgUrlToHit=" + this.pgUrlToHit + ", tOKENTYPE=" + this.tOKENTYPE + ", tHEME=" + this.tHEME + ", status=" + this.status + ", message=" + this.message + ", hitPG=" + this.hitPG + ", errorCode=" + this.errorCode + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getMID() {
        return this.mID;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getNativeWithdraw() {
        return this.nativeWithdraw;
    }

    public final NativeWithdrawDetails getNativeWithdrawDetails() {
        return this.nativeWithdrawDetails;
    }

    public final String getORDERID() {
        return this.oRDERID;
    }

    public final String getPgUrlToHit() {
        return this.pgUrlToHit;
    }

    public final String getTXNAMOUNT() {
        return this.tXNAMOUNT;
    }

    public ChannelAPIResponse(String str, String str2, NativeWithdrawDetails nativeWithdrawDetails2, String str3, String str4, String str5, String str6, String str7, String str8, Object obj, Object obj2, String str9, String str10) {
        this.mid = str;
        this.nativeWithdraw = str2;
        this.nativeWithdrawDetails = nativeWithdrawDetails2;
        this.oRDERID = str3;
        this.mID = str4;
        this.tXNAMOUNT = str5;
        this.pgUrlToHit = str6;
        this.tOKENTYPE = str7;
        this.tHEME = str8;
        this.status = obj;
        this.message = obj2;
        this.hitPG = str9;
        this.errorCode = str10;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelAPIResponse(java.lang.String r15, java.lang.String r16, net.one97.paytm.p2mNewDesign.entity.mlv.NativeWithdrawDetails r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.Object r24, java.lang.Object r25, java.lang.String r26, java.lang.String r27, int r28, kotlin.g.b.g r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r2
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r2
            goto L_0x0032
        L_0x0030:
            r7 = r20
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = r2
            goto L_0x003a
        L_0x0038:
            r8 = r21
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = r2
            goto L_0x0042
        L_0x0040:
            r9 = r22
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = r2
            goto L_0x004a
        L_0x0048:
            r10 = r23
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = r2
            goto L_0x0052
        L_0x0050:
            r11 = r24
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = r2
            goto L_0x005a
        L_0x0058:
            r12 = r25
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = r2
            goto L_0x0062
        L_0x0060:
            r13 = r26
        L_0x0062:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r2 = r27
        L_0x0069:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.ChannelAPIResponse.<init>(java.lang.String, java.lang.String, net.one97.paytm.p2mNewDesign.entity.mlv.NativeWithdrawDetails, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getHitPG() {
        return this.hitPG;
    }

    public final Object getMessage() {
        return this.message;
    }

    public final Object getStatus() {
        return this.status;
    }

    public final String getTHEME() {
        return this.tHEME;
    }

    public final String getTOKENTYPE() {
        return this.tOKENTYPE;
    }
}
