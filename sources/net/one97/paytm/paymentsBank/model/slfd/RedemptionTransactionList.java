package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class RedemptionTransactionList extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "net_amount_payout")
    private final double net_amount_payout;
    @b(a = "rate_of_interest")
    private final Double rate_of_interest;
    @b(a = "transaction_date")
    private final String redemption_date;
    @b(a = "amount")
    private final double transaction_amount;
    @b(a = "transaction_type")
    private final String transaction_type;

    public RedemptionTransactionList() {
        this(0.0d, 0.0d, (String) null, (String) null, (Double) null, 31, (g) null);
    }

    public static /* synthetic */ RedemptionTransactionList copy$default(RedemptionTransactionList redemptionTransactionList, double d2, double d3, String str, String str2, Double d4, int i2, Object obj) {
        RedemptionTransactionList redemptionTransactionList2 = redemptionTransactionList;
        return redemptionTransactionList.copy((i2 & 1) != 0 ? redemptionTransactionList2.net_amount_payout : d2, (i2 & 2) != 0 ? redemptionTransactionList2.transaction_amount : d3, (i2 & 4) != 0 ? redemptionTransactionList2.redemption_date : str, (i2 & 8) != 0 ? redemptionTransactionList2.transaction_type : str2, (i2 & 16) != 0 ? redemptionTransactionList2.rate_of_interest : d4);
    }

    public final double component1() {
        return this.net_amount_payout;
    }

    public final double component2() {
        return this.transaction_amount;
    }

    public final String component3() {
        return this.redemption_date;
    }

    public final String component4() {
        return this.transaction_type;
    }

    public final Double component5() {
        return this.rate_of_interest;
    }

    public final RedemptionTransactionList copy(double d2, double d3, String str, String str2, Double d4) {
        k.c(str, "redemption_date");
        return new RedemptionTransactionList(d2, d3, str, str2, d4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedemptionTransactionList)) {
            return false;
        }
        RedemptionTransactionList redemptionTransactionList = (RedemptionTransactionList) obj;
        return Double.compare(this.net_amount_payout, redemptionTransactionList.net_amount_payout) == 0 && Double.compare(this.transaction_amount, redemptionTransactionList.transaction_amount) == 0 && k.a((Object) this.redemption_date, (Object) redemptionTransactionList.redemption_date) && k.a((Object) this.transaction_type, (Object) redemptionTransactionList.transaction_type) && k.a((Object) this.rate_of_interest, (Object) redemptionTransactionList.rate_of_interest);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.net_amount_payout);
        long doubleToLongBits2 = Double.doubleToLongBits(this.transaction_amount);
        int i2 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str = this.redemption_date;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.transaction_type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.rate_of_interest;
        if (d2 != null) {
            i3 = d2.hashCode();
        }
        return hashCode2 + i3;
    }

    public final String toString() {
        return "RedemptionTransactionList(net_amount_payout=" + this.net_amount_payout + ", transaction_amount=" + this.transaction_amount + ", redemption_date=" + this.redemption_date + ", transaction_type=" + this.transaction_type + ", rate_of_interest=" + this.rate_of_interest + ")";
    }

    public final double getNet_amount_payout() {
        return this.net_amount_payout;
    }

    public final double getTransaction_amount() {
        return this.transaction_amount;
    }

    public final String getRedemption_date() {
        return this.redemption_date;
    }

    public final String getTransaction_type() {
        return this.transaction_type;
    }

    public RedemptionTransactionList(double d2, double d3, String str, String str2, Double d4) {
        k.c(str, "redemption_date");
        this.net_amount_payout = d2;
        this.transaction_amount = d3;
        this.redemption_date = str;
        this.transaction_type = str2;
        this.rate_of_interest = d4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedemptionTransactionList(double r10, double r12, java.lang.String r14, java.lang.String r15, java.lang.Double r16, int r17, kotlin.g.b.g r18) {
        /*
            r9 = this;
            r0 = r17 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r10
        L_0x0009:
            r0 = r17 & 2
            if (r0 == 0) goto L_0x000f
            r5 = r1
            goto L_0x0010
        L_0x000f:
            r5 = r12
        L_0x0010:
            r0 = r17 & 4
            java.lang.String r7 = ""
            if (r0 == 0) goto L_0x0018
            r0 = r7
            goto L_0x0019
        L_0x0018:
            r0 = r14
        L_0x0019:
            r8 = r17 & 8
            if (r8 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r7 = r15
        L_0x001f:
            r8 = r17 & 16
            if (r8 == 0) goto L_0x0028
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            goto L_0x002a
        L_0x0028:
            r1 = r16
        L_0x002a:
            r10 = r9
            r11 = r3
            r13 = r5
            r15 = r0
            r16 = r7
            r17 = r1
            r10.<init>(r11, r13, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.RedemptionTransactionList.<init>(double, double, java.lang.String, java.lang.String, java.lang.Double, int, kotlin.g.b.g):void");
    }

    public final Double getRate_of_interest() {
        return this.rate_of_interest;
    }
}
