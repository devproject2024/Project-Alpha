package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class MlvInfo2 extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "amount")
    private Double amount;
    @b(a = "created_at")
    private String createdAt;
    @b(a = "custom_int")
    private Object customInt;
    @b(a = "id")
    private String id;
    @b(a = "kind")
    private Integer kind;
    @b(a = "kind_text")
    private String kindText;
    @b(a = "pgmid")
    private String pgmid;
    @b(a = "provider")
    private String provider;
    @b(a = "req_id")
    private String reqId;
    @b(a = "source")
    private String source;
    @b(a = "source_id")
    private String sourceId;
    @b(a = "status")
    private Integer status;
    @b(a = "status_text")
    private String statusText;
    @b(a = "txn_payload")
    private String txnPayload;
    @b(a = "updated_at")
    private String updatedAt;

    public MlvInfo2() {
        this((String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Double) null, (String) null, (String) null, (Object) null, (String) null, (String) null, (String) null, 32767, (g) null);
    }

    public static /* synthetic */ MlvInfo2 copy$default(MlvInfo2 mlvInfo2, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Double d2, String str7, String str8, Object obj, String str9, String str10, String str11, int i2, Object obj2) {
        MlvInfo2 mlvInfo22 = mlvInfo2;
        int i3 = i2;
        return mlvInfo2.copy((i3 & 1) != 0 ? mlvInfo22.id : str, (i3 & 2) != 0 ? mlvInfo22.pgmid : str2, (i3 & 4) != 0 ? mlvInfo22.source : str3, (i3 & 8) != 0 ? mlvInfo22.sourceId : str4, (i3 & 16) != 0 ? mlvInfo22.status : num, (i3 & 32) != 0 ? mlvInfo22.kind : num2, (i3 & 64) != 0 ? mlvInfo22.createdAt : str5, (i3 & 128) != 0 ? mlvInfo22.updatedAt : str6, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? mlvInfo22.amount : d2, (i3 & 512) != 0 ? mlvInfo22.txnPayload : str7, (i3 & TarConstants.EOF_BLOCK) != 0 ? mlvInfo22.provider : str8, (i3 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? mlvInfo22.customInt : obj, (i3 & 4096) != 0 ? mlvInfo22.reqId : str9, (i3 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? mlvInfo22.kindText : str10, (i3 & 16384) != 0 ? mlvInfo22.statusText : str11);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.txnPayload;
    }

    public final String component11() {
        return this.provider;
    }

    public final Object component12() {
        return this.customInt;
    }

    public final String component13() {
        return this.reqId;
    }

    public final String component14() {
        return this.kindText;
    }

    public final String component15() {
        return this.statusText;
    }

    public final String component2() {
        return this.pgmid;
    }

    public final String component3() {
        return this.source;
    }

    public final String component4() {
        return this.sourceId;
    }

    public final Integer component5() {
        return this.status;
    }

    public final Integer component6() {
        return this.kind;
    }

    public final String component7() {
        return this.createdAt;
    }

    public final String component8() {
        return this.updatedAt;
    }

    public final Double component9() {
        return this.amount;
    }

    public final MlvInfo2 copy(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Double d2, String str7, String str8, Object obj, String str9, String str10, String str11) {
        return new MlvInfo2(str, str2, str3, str4, num, num2, str5, str6, d2, str7, str8, obj, str9, str10, str11);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MlvInfo2)) {
            return false;
        }
        MlvInfo2 mlvInfo2 = (MlvInfo2) obj;
        return k.a((Object) this.id, (Object) mlvInfo2.id) && k.a((Object) this.pgmid, (Object) mlvInfo2.pgmid) && k.a((Object) this.source, (Object) mlvInfo2.source) && k.a((Object) this.sourceId, (Object) mlvInfo2.sourceId) && k.a((Object) this.status, (Object) mlvInfo2.status) && k.a((Object) this.kind, (Object) mlvInfo2.kind) && k.a((Object) this.createdAt, (Object) mlvInfo2.createdAt) && k.a((Object) this.updatedAt, (Object) mlvInfo2.updatedAt) && k.a((Object) this.amount, (Object) mlvInfo2.amount) && k.a((Object) this.txnPayload, (Object) mlvInfo2.txnPayload) && k.a((Object) this.provider, (Object) mlvInfo2.provider) && k.a(this.customInt, mlvInfo2.customInt) && k.a((Object) this.reqId, (Object) mlvInfo2.reqId) && k.a((Object) this.kindText, (Object) mlvInfo2.kindText) && k.a((Object) this.statusText, (Object) mlvInfo2.statusText);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pgmid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.source;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.sourceId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.status;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.kind;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str5 = this.createdAt;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.updatedAt;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode9 = (hashCode8 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str7 = this.txnPayload;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.provider;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Object obj = this.customInt;
        int hashCode12 = (hashCode11 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str9 = this.reqId;
        int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.kindText;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.statusText;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        return hashCode14 + i2;
    }

    public final String toString() {
        return "MlvInfo2(id=" + this.id + ", pgmid=" + this.pgmid + ", source=" + this.source + ", sourceId=" + this.sourceId + ", status=" + this.status + ", kind=" + this.kind + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", amount=" + this.amount + ", txnPayload=" + this.txnPayload + ", provider=" + this.provider + ", customInt=" + this.customInt + ", reqId=" + this.reqId + ", kindText=" + this.kindText + ", statusText=" + this.statusText + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getPgmid() {
        return this.pgmid;
    }

    public final void setPgmid(String str) {
        this.pgmid = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final void setSourceId(String str) {
        this.sourceId = str;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final Integer getKind() {
        return this.kind;
    }

    public final void setKind(Integer num) {
        this.kind = num;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final void setAmount(Double d2) {
        this.amount = d2;
    }

    public final String getTxnPayload() {
        return this.txnPayload;
    }

    public final void setTxnPayload(String str) {
        this.txnPayload = str;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final void setProvider(String str) {
        this.provider = str;
    }

    public final Object getCustomInt() {
        return this.customInt;
    }

    public final void setCustomInt(Object obj) {
        this.customInt = obj;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final void setReqId(String str) {
        this.reqId = str;
    }

    public final String getKindText() {
        return this.kindText;
    }

    public final void setKindText(String str) {
        this.kindText = str;
    }

    public MlvInfo2(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Double d2, String str7, String str8, Object obj, String str9, String str10, String str11) {
        this.id = str;
        this.pgmid = str2;
        this.source = str3;
        this.sourceId = str4;
        this.status = num;
        this.kind = num2;
        this.createdAt = str5;
        this.updatedAt = str6;
        this.amount = d2;
        this.txnPayload = str7;
        this.provider = str8;
        this.customInt = obj;
        this.reqId = str9;
        this.kindText = str10;
        this.statusText = str11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MlvInfo2(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.String r23, java.lang.String r24, java.lang.Double r25, java.lang.String r26, java.lang.String r27, java.lang.Object r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, int r32, kotlin.g.b.g r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r28
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r29
        L_0x006b:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0071
            r15 = r2
            goto L_0x0073
        L_0x0071:
            r15 = r30
        L_0x0073:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r2 = r31
        L_0x007a:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.entity.mlv.myorders.MlvInfo2.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Double, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final void setStatusText(String str) {
        this.statusText = str;
    }
}
