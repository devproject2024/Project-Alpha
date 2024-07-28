package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class SlfdTransactionItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    private final Double amount;
    @b(a = "failed_amount")
    private final Double failedAmount;
    @b(a = "fd_id")
    private final String fdId;
    @b(a = "interest_earned")
    private final Double interestEarned;
    @b(a = "net_tds")
    private final Double netTds;
    @b(a = "order_id")
    private final String orderId;
    @b(a = "projected_interest")
    private final Double projectedInterest;
    @b(a = "status")
    private final Integer status;
    @b(a = "txn_date")
    private final Long txnDate;
    @b(a = "txn_type")
    private final String txnType;

    public SlfdTransactionItem() {
        this((Double) null, (Integer) null, (String) null, (Long) null, (String) null, (Double) null, (Double) null, (Double) null, (Double) null, (String) null, 1023, (g) null);
    }

    public static /* synthetic */ SlfdTransactionItem copy$default(SlfdTransactionItem slfdTransactionItem, Double d2, Integer num, String str, Long l, String str2, Double d3, Double d4, Double d5, Double d6, String str3, int i2, Object obj) {
        SlfdTransactionItem slfdTransactionItem2 = slfdTransactionItem;
        int i3 = i2;
        return slfdTransactionItem.copy((i3 & 1) != 0 ? slfdTransactionItem2.amount : d2, (i3 & 2) != 0 ? slfdTransactionItem2.status : num, (i3 & 4) != 0 ? slfdTransactionItem2.orderId : str, (i3 & 8) != 0 ? slfdTransactionItem2.txnDate : l, (i3 & 16) != 0 ? slfdTransactionItem2.fdId : str2, (i3 & 32) != 0 ? slfdTransactionItem2.netTds : d3, (i3 & 64) != 0 ? slfdTransactionItem2.interestEarned : d4, (i3 & 128) != 0 ? slfdTransactionItem2.projectedInterest : d5, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? slfdTransactionItem2.failedAmount : d6, (i3 & 512) != 0 ? slfdTransactionItem2.txnType : str3);
    }

    public final Double component1() {
        return this.amount;
    }

    public final String component10() {
        return this.txnType;
    }

    public final Integer component2() {
        return this.status;
    }

    public final String component3() {
        return this.orderId;
    }

    public final Long component4() {
        return this.txnDate;
    }

    public final String component5() {
        return this.fdId;
    }

    public final Double component6() {
        return this.netTds;
    }

    public final Double component7() {
        return this.interestEarned;
    }

    public final Double component8() {
        return this.projectedInterest;
    }

    public final Double component9() {
        return this.failedAmount;
    }

    public final SlfdTransactionItem copy(Double d2, Integer num, String str, Long l, String str2, Double d3, Double d4, Double d5, Double d6, String str3) {
        return new SlfdTransactionItem(d2, num, str, l, str2, d3, d4, d5, d6, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlfdTransactionItem)) {
            return false;
        }
        SlfdTransactionItem slfdTransactionItem = (SlfdTransactionItem) obj;
        return k.a((Object) this.amount, (Object) slfdTransactionItem.amount) && k.a((Object) this.status, (Object) slfdTransactionItem.status) && k.a((Object) this.orderId, (Object) slfdTransactionItem.orderId) && k.a((Object) this.txnDate, (Object) slfdTransactionItem.txnDate) && k.a((Object) this.fdId, (Object) slfdTransactionItem.fdId) && k.a((Object) this.netTds, (Object) slfdTransactionItem.netTds) && k.a((Object) this.interestEarned, (Object) slfdTransactionItem.interestEarned) && k.a((Object) this.projectedInterest, (Object) slfdTransactionItem.projectedInterest) && k.a((Object) this.failedAmount, (Object) slfdTransactionItem.failedAmount) && k.a((Object) this.txnType, (Object) slfdTransactionItem.txnType);
    }

    public final int hashCode() {
        Double d2 = this.amount;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.orderId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Long l = this.txnDate;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.fdId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d3 = this.netTds;
        int hashCode6 = (hashCode5 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.interestEarned;
        int hashCode7 = (hashCode6 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.projectedInterest;
        int hashCode8 = (hashCode7 + (d5 != null ? d5.hashCode() : 0)) * 31;
        Double d6 = this.failedAmount;
        int hashCode9 = (hashCode8 + (d6 != null ? d6.hashCode() : 0)) * 31;
        String str3 = this.txnType;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "SlfdTransactionItem(amount=" + this.amount + ", status=" + this.status + ", orderId=" + this.orderId + ", txnDate=" + this.txnDate + ", fdId=" + this.fdId + ", netTds=" + this.netTds + ", interestEarned=" + this.interestEarned + ", projectedInterest=" + this.projectedInterest + ", failedAmount=" + this.failedAmount + ", txnType=" + this.txnType + ")";
    }

    public final Double getAmount() {
        return this.amount;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SlfdTransactionItem(java.lang.Double r13, java.lang.Integer r14, java.lang.String r15, java.lang.Long r16, java.lang.String r17, java.lang.Double r18, java.lang.Double r19, java.lang.Double r20, java.lang.Double r21, java.lang.String r22, int r23, kotlin.g.b.g r24) {
        /*
            r12 = this;
            r0 = r23
            r1 = r0 & 1
            r2 = 0
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            if (r1 == 0) goto L_0x000e
            r1 = r2
            goto L_0x000f
        L_0x000e:
            r1 = r13
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0019
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x001a
        L_0x0019:
            r3 = r14
        L_0x001a:
            r4 = r0 & 4
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0022
            r4 = r5
            goto L_0x0023
        L_0x0022:
            r4 = r15
        L_0x0023:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x002e
            r6 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            goto L_0x0030
        L_0x002e:
            r6 = r16
        L_0x0030:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0036
            r7 = r5
            goto L_0x0038
        L_0x0036:
            r7 = r17
        L_0x0038:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x003e
            r8 = r2
            goto L_0x0040
        L_0x003e:
            r8 = r18
        L_0x0040:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0046
            r9 = r2
            goto L_0x0048
        L_0x0046:
            r9 = r19
        L_0x0048:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004e
            r10 = r2
            goto L_0x0050
        L_0x004e:
            r10 = r20
        L_0x0050:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0055
            goto L_0x0057
        L_0x0055:
            r2 = r21
        L_0x0057:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r5 = r22
        L_0x005e:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r23 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.SlfdTransactionItem.<init>(java.lang.Double, java.lang.Integer, java.lang.String, java.lang.Long, java.lang.String, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final Long getTxnDate() {
        return this.txnDate;
    }

    public final String getFdId() {
        return this.fdId;
    }

    public final Double getNetTds() {
        return this.netTds;
    }

    public final Double getInterestEarned() {
        return this.interestEarned;
    }

    public final Double getProjectedInterest() {
        return this.projectedInterest;
    }

    public final Double getFailedAmount() {
        return this.failedAmount;
    }

    public SlfdTransactionItem(Double d2, Integer num, String str, Long l, String str2, Double d3, Double d4, Double d5, Double d6, String str3) {
        this.amount = d2;
        this.status = num;
        this.orderId = str;
        this.txnDate = l;
        this.fdId = str2;
        this.netTds = d3;
        this.interestEarned = d4;
        this.projectedInterest = d5;
        this.failedAmount = d6;
        this.txnType = str3;
    }

    public final String getTxnType() {
        return this.txnType;
    }
}
