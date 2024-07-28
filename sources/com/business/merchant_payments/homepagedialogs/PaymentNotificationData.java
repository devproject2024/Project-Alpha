package com.business.merchant_payments.homepagedialogs;

import android.graphics.drawable.Drawable;
import com.business.merchant_payments.payment.model.PaymentsTransactionModel;
import kotlin.g.b.k;

public final class PaymentNotificationData {
    public String amount;
    public final String id;
    public Drawable image;
    public String imageUrl;
    public String mode;
    public String mode_detail;
    public final PaymentsTransactionModel paymentsTransactionModel;
    public String time;

    public static /* synthetic */ PaymentNotificationData copy$default(PaymentNotificationData paymentNotificationData, PaymentsTransactionModel paymentsTransactionModel2, String str, String str2, String str3, String str4, String str5, String str6, Drawable drawable, int i2, Object obj) {
        PaymentNotificationData paymentNotificationData2 = paymentNotificationData;
        int i3 = i2;
        return paymentNotificationData.copy((i3 & 1) != 0 ? paymentNotificationData2.paymentsTransactionModel : paymentsTransactionModel2, (i3 & 2) != 0 ? paymentNotificationData2.id : str, (i3 & 4) != 0 ? paymentNotificationData2.amount : str2, (i3 & 8) != 0 ? paymentNotificationData2.time : str3, (i3 & 16) != 0 ? paymentNotificationData2.mode : str4, (i3 & 32) != 0 ? paymentNotificationData2.mode_detail : str5, (i3 & 64) != 0 ? paymentNotificationData2.imageUrl : str6, (i3 & 128) != 0 ? paymentNotificationData2.image : drawable);
    }

    public final PaymentsTransactionModel component1() {
        return this.paymentsTransactionModel;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.time;
    }

    public final String component5() {
        return this.mode;
    }

    public final String component6() {
        return this.mode_detail;
    }

    public final String component7() {
        return this.imageUrl;
    }

    public final Drawable component8() {
        return this.image;
    }

    public final PaymentNotificationData copy(PaymentsTransactionModel paymentsTransactionModel2, String str, String str2, String str3, String str4, String str5, String str6, Drawable drawable) {
        k.d(paymentsTransactionModel2, "paymentsTransactionModel");
        return new PaymentNotificationData(paymentsTransactionModel2, str, str2, str3, str4, str5, str6, drawable);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentNotificationData)) {
            return false;
        }
        PaymentNotificationData paymentNotificationData = (PaymentNotificationData) obj;
        return k.a((Object) this.paymentsTransactionModel, (Object) paymentNotificationData.paymentsTransactionModel) && k.a((Object) this.id, (Object) paymentNotificationData.id) && k.a((Object) this.amount, (Object) paymentNotificationData.amount) && k.a((Object) this.time, (Object) paymentNotificationData.time) && k.a((Object) this.mode, (Object) paymentNotificationData.mode) && k.a((Object) this.mode_detail, (Object) paymentNotificationData.mode_detail) && k.a((Object) this.imageUrl, (Object) paymentNotificationData.imageUrl) && k.a((Object) this.image, (Object) paymentNotificationData.image);
    }

    public final int hashCode() {
        PaymentsTransactionModel paymentsTransactionModel2 = this.paymentsTransactionModel;
        int i2 = 0;
        int hashCode = (paymentsTransactionModel2 != null ? paymentsTransactionModel2.hashCode() : 0) * 31;
        String str = this.id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.amount;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.time;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mode;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mode_detail;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.imageUrl;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Drawable drawable = this.image;
        if (drawable != null) {
            i2 = drawable.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "PaymentNotificationData(paymentsTransactionModel=" + this.paymentsTransactionModel + ", id=" + this.id + ", amount=" + this.amount + ", time=" + this.time + ", mode=" + this.mode + ", mode_detail=" + this.mode_detail + ", imageUrl=" + this.imageUrl + ", image=" + this.image + ")";
    }

    public PaymentNotificationData(PaymentsTransactionModel paymentsTransactionModel2, String str, String str2, String str3, String str4, String str5, String str6, Drawable drawable) {
        k.d(paymentsTransactionModel2, "paymentsTransactionModel");
        this.paymentsTransactionModel = paymentsTransactionModel2;
        this.id = str;
        this.amount = str2;
        this.time = str3;
        this.mode = str4;
        this.mode_detail = str5;
        this.imageUrl = str6;
        this.image = drawable;
    }

    public final PaymentsTransactionModel getPaymentsTransactionModel() {
        return this.paymentsTransactionModel;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getMode_detail() {
        return this.mode_detail;
    }

    public final void setMode_detail(String str) {
        this.mode_detail = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentNotificationData(com.business.merchant_payments.payment.model.PaymentsTransactionModel r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, android.graphics.drawable.Drawable r16, int r17, kotlin.g.b.g r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r2 = r16
        L_0x0034:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.homepagedialogs.PaymentNotificationData.<init>(com.business.merchant_payments.payment.model.PaymentsTransactionModel, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.graphics.drawable.Drawable, int, kotlin.g.b.g):void");
    }

    public final Drawable getImage() {
        return this.image;
    }

    public final void setImage(Drawable drawable) {
        this.image = drawable;
    }
}
