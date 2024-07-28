package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CollectModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "ORDER_ID")
    private String ORDER_ID;
    @b(a = "hitPG")
    private String hitPG;
    @b(a = "message")
    private String message;
    @b(a = "payment_status")
    private String payment_status;
    @b(a = "pgResponse")
    private PgResponseModel pgResponse;
    @b(a = "pgUrlToHit")
    private String pgUrlToHit;
    @b(a = "status")
    private String status;

    public CollectModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (PgResponseModel) null, 127, (g) null);
    }

    public static /* synthetic */ CollectModel copy$default(CollectModel collectModel, String str, String str2, String str3, String str4, String str5, String str6, PgResponseModel pgResponseModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = collectModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = collectModel.message;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            str3 = collectModel.hitPG;
        }
        String str8 = str3;
        if ((i2 & 8) != 0) {
            str4 = collectModel.ORDER_ID;
        }
        String str9 = str4;
        if ((i2 & 16) != 0) {
            str5 = collectModel.pgUrlToHit;
        }
        String str10 = str5;
        if ((i2 & 32) != 0) {
            str6 = collectModel.payment_status;
        }
        String str11 = str6;
        if ((i2 & 64) != 0) {
            pgResponseModel = collectModel.pgResponse;
        }
        return collectModel.copy(str, str7, str8, str9, str10, str11, pgResponseModel);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.hitPG;
    }

    public final String component4() {
        return this.ORDER_ID;
    }

    public final String component5() {
        return this.pgUrlToHit;
    }

    public final String component6() {
        return this.payment_status;
    }

    public final PgResponseModel component7() {
        return this.pgResponse;
    }

    public final CollectModel copy(String str, String str2, String str3, String str4, String str5, String str6, PgResponseModel pgResponseModel) {
        return new CollectModel(str, str2, str3, str4, str5, str6, pgResponseModel);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectModel)) {
            return false;
        }
        CollectModel collectModel = (CollectModel) obj;
        return k.a((Object) this.status, (Object) collectModel.status) && k.a((Object) this.message, (Object) collectModel.message) && k.a((Object) this.hitPG, (Object) collectModel.hitPG) && k.a((Object) this.ORDER_ID, (Object) collectModel.ORDER_ID) && k.a((Object) this.pgUrlToHit, (Object) collectModel.pgUrlToHit) && k.a((Object) this.payment_status, (Object) collectModel.payment_status) && k.a((Object) this.pgResponse, (Object) collectModel.pgResponse);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.hitPG;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ORDER_ID;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.pgUrlToHit;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.payment_status;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        PgResponseModel pgResponseModel = this.pgResponse;
        if (pgResponseModel != null) {
            i2 = pgResponseModel.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CollectModel(status=" + this.status + ", message=" + this.message + ", hitPG=" + this.hitPG + ", ORDER_ID=" + this.ORDER_ID + ", pgUrlToHit=" + this.pgUrlToHit + ", payment_status=" + this.payment_status + ", pgResponse=" + this.pgResponse + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getHitPG() {
        return this.hitPG;
    }

    public final void setHitPG(String str) {
        this.hitPG = str;
    }

    public final String getORDER_ID() {
        return this.ORDER_ID;
    }

    public final void setORDER_ID(String str) {
        this.ORDER_ID = str;
    }

    public final String getPgUrlToHit() {
        return this.pgUrlToHit;
    }

    public final void setPgUrlToHit(String str) {
        this.pgUrlToHit = str;
    }

    public final String getPayment_status() {
        return this.payment_status;
    }

    public final void setPayment_status(String str) {
        this.payment_status = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CollectModel(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, net.one97.paytm.coins.model.PgResponseModel r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.model.CollectModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, net.one97.paytm.coins.model.PgResponseModel, int, kotlin.g.b.g):void");
    }

    public final PgResponseModel getPgResponse() {
        return this.pgResponse;
    }

    public final void setPgResponse(PgResponseModel pgResponseModel) {
        this.pgResponse = pgResponseModel;
    }

    public CollectModel(String str, String str2, String str3, String str4, String str5, String str6, PgResponseModel pgResponseModel) {
        this.status = str;
        this.message = str2;
        this.hitPG = str3;
        this.ORDER_ID = str4;
        this.pgUrlToHit = str5;
        this.payment_status = str6;
        this.pgResponse = pgResponseModel;
    }
}
