package net.one97.paytm.coins.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CheckoutModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "ORDER_ID")
    private String ORDER_ID;
    @b(a = "hitPG")
    private String hitPG;
    @b(a = "message")
    private String message;
    @b(a = "paymentPayload")
    private Object paymentPayload;
    @b(a = "pgUrlToHit")
    private String pgUrlToHit;
    @b(a = "status")
    private String status;

    public CheckoutModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Object) null, 63, (g) null);
    }

    public static /* synthetic */ CheckoutModel copy$default(CheckoutModel checkoutModel, String str, String str2, String str3, String str4, String str5, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = checkoutModel.status;
        }
        if ((i2 & 2) != 0) {
            str2 = checkoutModel.message;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = checkoutModel.hitPG;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = checkoutModel.ORDER_ID;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = checkoutModel.pgUrlToHit;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            obj = checkoutModel.paymentPayload;
        }
        return checkoutModel.copy(str, str6, str7, str8, str9, obj);
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

    public final Object component6() {
        return this.paymentPayload;
    }

    public final CheckoutModel copy(String str, String str2, String str3, String str4, String str5, Object obj) {
        return new CheckoutModel(str, str2, str3, str4, str5, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckoutModel)) {
            return false;
        }
        CheckoutModel checkoutModel = (CheckoutModel) obj;
        return k.a((Object) this.status, (Object) checkoutModel.status) && k.a((Object) this.message, (Object) checkoutModel.message) && k.a((Object) this.hitPG, (Object) checkoutModel.hitPG) && k.a((Object) this.ORDER_ID, (Object) checkoutModel.ORDER_ID) && k.a((Object) this.pgUrlToHit, (Object) checkoutModel.pgUrlToHit) && k.a(this.paymentPayload, checkoutModel.paymentPayload);
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
        Object obj = this.paymentPayload;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "CheckoutModel(status=" + this.status + ", message=" + this.message + ", hitPG=" + this.hitPG + ", ORDER_ID=" + this.ORDER_ID + ", pgUrlToHit=" + this.pgUrlToHit + ", paymentPayload=" + this.paymentPayload + ")";
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

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CheckoutModel(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Object r11, int r12, kotlin.g.b.g r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.coins.model.CheckoutModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, int, kotlin.g.b.g):void");
    }

    public final Object getPaymentPayload() {
        return this.paymentPayload;
    }

    public final void setPaymentPayload(Object obj) {
        this.paymentPayload = obj;
    }

    public CheckoutModel(String str, String str2, String str3, String str4, String str5, Object obj) {
        this.status = str;
        this.message = str2;
        this.hitPG = str3;
        this.ORDER_ID = str4;
        this.pgUrlToHit = str5;
        this.paymentPayload = obj;
    }
}
