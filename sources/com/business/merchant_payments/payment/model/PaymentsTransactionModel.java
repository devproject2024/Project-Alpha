package com.business.merchant_payments.payment.model;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.payment.model.orderDetail.OrderDetail;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class PaymentsTransactionModel {
    public String amount;
    public boolean bgEven;
    public boolean cardErr;
    public boolean isChargeBack;
    public boolean isDividerVisible;
    public boolean isIncentive;
    public boolean isRefund;
    public String name;
    public int no;
    public OrderDetail orderDetail;
    public String payMethodUrl;
    public String time;

    public static /* synthetic */ PaymentsTransactionModel copy$default(PaymentsTransactionModel paymentsTransactionModel, int i2, OrderDetail orderDetail2, String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        PaymentsTransactionModel paymentsTransactionModel2 = paymentsTransactionModel;
        int i4 = i3;
        return paymentsTransactionModel.copy((i4 & 1) != 0 ? paymentsTransactionModel2.no : i2, (i4 & 2) != 0 ? paymentsTransactionModel2.orderDetail : orderDetail2, (i4 & 4) != 0 ? paymentsTransactionModel2.time : str, (i4 & 8) != 0 ? paymentsTransactionModel2.name : str2, (i4 & 16) != 0 ? paymentsTransactionModel2.amount : str3, (i4 & 32) != 0 ? paymentsTransactionModel2.payMethodUrl : str4, (i4 & 64) != 0 ? paymentsTransactionModel2.cardErr : z, (i4 & 128) != 0 ? paymentsTransactionModel2.isIncentive : z2, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? paymentsTransactionModel2.bgEven : z3, (i4 & 512) != 0 ? paymentsTransactionModel2.isDividerVisible : z4, (i4 & TarConstants.EOF_BLOCK) != 0 ? paymentsTransactionModel2.isRefund : z5, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? paymentsTransactionModel2.isChargeBack : z6);
    }

    public final int component1() {
        return this.no;
    }

    public final boolean component10() {
        return this.isDividerVisible;
    }

    public final boolean component11() {
        return this.isRefund;
    }

    public final boolean component12() {
        return this.isChargeBack;
    }

    public final OrderDetail component2() {
        return this.orderDetail;
    }

    public final String component3() {
        return this.time;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.amount;
    }

    public final String component6() {
        return this.payMethodUrl;
    }

    public final boolean component7() {
        return this.cardErr;
    }

    public final boolean component8() {
        return this.isIncentive;
    }

    public final boolean component9() {
        return this.bgEven;
    }

    public final PaymentsTransactionModel copy(int i2, OrderDetail orderDetail2, String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        OrderDetail orderDetail3 = orderDetail2;
        k.d(orderDetail3, "orderDetail");
        String str5 = str;
        k.d(str5, "time");
        String str6 = str2;
        k.d(str6, "name");
        String str7 = str3;
        k.d(str7, "amount");
        String str8 = str4;
        k.d(str8, "payMethodUrl");
        return new PaymentsTransactionModel(i2, orderDetail3, str5, str6, str7, str8, z, z2, z3, z4, z5, z6);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentsTransactionModel)) {
            return false;
        }
        PaymentsTransactionModel paymentsTransactionModel = (PaymentsTransactionModel) obj;
        return this.no == paymentsTransactionModel.no && k.a((Object) this.orderDetail, (Object) paymentsTransactionModel.orderDetail) && k.a((Object) this.time, (Object) paymentsTransactionModel.time) && k.a((Object) this.name, (Object) paymentsTransactionModel.name) && k.a((Object) this.amount, (Object) paymentsTransactionModel.amount) && k.a((Object) this.payMethodUrl, (Object) paymentsTransactionModel.payMethodUrl) && this.cardErr == paymentsTransactionModel.cardErr && this.isIncentive == paymentsTransactionModel.isIncentive && this.bgEven == paymentsTransactionModel.bgEven && this.isDividerVisible == paymentsTransactionModel.isDividerVisible && this.isRefund == paymentsTransactionModel.isRefund && this.isChargeBack == paymentsTransactionModel.isChargeBack;
    }

    public final int hashCode() {
        int i2 = this.no * 31;
        OrderDetail orderDetail2 = this.orderDetail;
        int i3 = 0;
        int hashCode = (i2 + (orderDetail2 != null ? orderDetail2.hashCode() : 0)) * 31;
        String str = this.time;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.payMethodUrl;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        int i4 = (hashCode4 + i3) * 31;
        boolean z = this.cardErr;
        if (z) {
            z = true;
        }
        int i5 = (i4 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isIncentive;
        if (z2) {
            z2 = true;
        }
        int i6 = (i5 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.bgEven;
        if (z3) {
            z3 = true;
        }
        int i7 = (i6 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isDividerVisible;
        if (z4) {
            z4 = true;
        }
        int i8 = (i7 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.isRefund;
        if (z5) {
            z5 = true;
        }
        int i9 = (i8 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.isChargeBack;
        if (z6) {
            z6 = true;
        }
        return i9 + (z6 ? 1 : 0);
    }

    public final String toString() {
        return "PaymentsTransactionModel(no=" + this.no + ", orderDetail=" + this.orderDetail + ", time=" + this.time + ", name=" + this.name + ", amount=" + this.amount + ", payMethodUrl=" + this.payMethodUrl + ", cardErr=" + this.cardErr + ", isIncentive=" + this.isIncentive + ", bgEven=" + this.bgEven + ", isDividerVisible=" + this.isDividerVisible + ", isRefund=" + this.isRefund + ", isChargeBack=" + this.isChargeBack + ")";
    }

    public PaymentsTransactionModel(int i2, OrderDetail orderDetail2, String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        k.d(orderDetail2, "orderDetail");
        k.d(str, "time");
        k.d(str2, "name");
        k.d(str3, "amount");
        k.d(str4, "payMethodUrl");
        this.no = i2;
        this.orderDetail = orderDetail2;
        this.time = str;
        this.name = str2;
        this.amount = str3;
        this.payMethodUrl = str4;
        this.cardErr = z;
        this.isIncentive = z2;
        this.bgEven = z3;
        this.isDividerVisible = z4;
        this.isRefund = z5;
        this.isChargeBack = z6;
    }

    public final int getNo() {
        return this.no;
    }

    public final void setNo(int i2) {
        this.no = i2;
    }

    public final OrderDetail getOrderDetail() {
        return this.orderDetail;
    }

    public final void setOrderDetail(OrderDetail orderDetail2) {
        k.d(orderDetail2, "<set-?>");
        this.orderDetail = orderDetail2;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        k.d(str, "<set-?>");
        this.time = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.d(str, "<set-?>");
        this.name = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        k.d(str, "<set-?>");
        this.amount = str;
    }

    public final String getPayMethodUrl() {
        return this.payMethodUrl;
    }

    public final void setPayMethodUrl(String str) {
        k.d(str, "<set-?>");
        this.payMethodUrl = str;
    }

    public final boolean getCardErr() {
        return this.cardErr;
    }

    public final void setCardErr(boolean z) {
        this.cardErr = z;
    }

    public final boolean isIncentive() {
        return this.isIncentive;
    }

    public final void setIncentive(boolean z) {
        this.isIncentive = z;
    }

    public final boolean getBgEven() {
        return this.bgEven;
    }

    public final void setBgEven(boolean z) {
        this.bgEven = z;
    }

    public final boolean isDividerVisible() {
        return this.isDividerVisible;
    }

    public final void setDividerVisible(boolean z) {
        this.isDividerVisible = z;
    }

    public final boolean isRefund() {
        return this.isRefund;
    }

    public final void setRefund(boolean z) {
        this.isRefund = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentsTransactionModel(int r17, com.business.merchant_payments.payment.model.orderDetail.OrderDetail r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, int r29, kotlin.g.b.g r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 4
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r6 = r2
            goto L_0x000c
        L_0x000a:
            r6 = r19
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0012
            r7 = r2
            goto L_0x0014
        L_0x0012:
            r7 = r20
        L_0x0014:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001a
            r8 = r2
            goto L_0x001c
        L_0x001a:
            r8 = r21
        L_0x001c:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0022
            r9 = r2
            goto L_0x0024
        L_0x0022:
            r9 = r22
        L_0x0024:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x002b
            r10 = 0
            goto L_0x002d
        L_0x002b:
            r10 = r23
        L_0x002d:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0033
            r11 = 0
            goto L_0x0035
        L_0x0033:
            r11 = r24
        L_0x0035:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003b
            r12 = 0
            goto L_0x003d
        L_0x003b:
            r12 = r25
        L_0x003d:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0043
            r13 = 0
            goto L_0x0045
        L_0x0043:
            r13 = r26
        L_0x0045:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004b
            r14 = 0
            goto L_0x004d
        L_0x004b:
            r14 = r27
        L_0x004d:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0053
            r15 = 0
            goto L_0x0055
        L_0x0053:
            r15 = r28
        L_0x0055:
            r3 = r16
            r4 = r17
            r5 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.payment.model.PaymentsTransactionModel.<init>(int, com.business.merchant_payments.payment.model.orderDetail.OrderDetail, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, int, kotlin.g.b.g):void");
    }

    public final boolean isChargeBack() {
        return this.isChargeBack;
    }

    public final void setChargeBack(boolean z) {
        this.isChargeBack = z;
    }
}
