package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class AmountDetailsResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "interest")
    private final double interest;
    @b(a = "interest_rate")
    private final double intrest_rate;
    @b(a = "message")
    private final String message;
    @b(a = "net_amount_payout")
    private final double net_amount_payout;
    @b(a = "response_code")
    private final int response_code;
    @b(a = "status")
    private final String status;
    @b(a = "trial_closure_amount")
    private final double trial_closure_amount;
    @b(a = "txn_id")
    private final String txn_id;

    public AmountDetailsResponse() {
        this(0.0d, 0.0d, (String) null, 0.0d, 0, (String) null, 0.0d, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ AmountDetailsResponse copy$default(AmountDetailsResponse amountDetailsResponse, double d2, double d3, String str, double d4, int i2, String str2, double d5, String str3, int i3, Object obj) {
        AmountDetailsResponse amountDetailsResponse2 = amountDetailsResponse;
        int i4 = i3;
        return amountDetailsResponse.copy((i4 & 1) != 0 ? amountDetailsResponse2.interest : d2, (i4 & 2) != 0 ? amountDetailsResponse2.intrest_rate : d3, (i4 & 4) != 0 ? amountDetailsResponse2.message : str, (i4 & 8) != 0 ? amountDetailsResponse2.net_amount_payout : d4, (i4 & 16) != 0 ? amountDetailsResponse2.response_code : i2, (i4 & 32) != 0 ? amountDetailsResponse2.status : str2, (i4 & 64) != 0 ? amountDetailsResponse2.trial_closure_amount : d5, (i4 & 128) != 0 ? amountDetailsResponse2.txn_id : str3);
    }

    public final double component1() {
        return this.interest;
    }

    public final double component2() {
        return this.intrest_rate;
    }

    public final String component3() {
        return this.message;
    }

    public final double component4() {
        return this.net_amount_payout;
    }

    public final int component5() {
        return this.response_code;
    }

    public final String component6() {
        return this.status;
    }

    public final double component7() {
        return this.trial_closure_amount;
    }

    public final String component8() {
        return this.txn_id;
    }

    public final AmountDetailsResponse copy(double d2, double d3, String str, double d4, int i2, String str2, double d5, String str3) {
        String str4 = str;
        k.c(str4, "message");
        String str5 = str2;
        k.c(str5, "status");
        String str6 = str3;
        k.c(str6, "txn_id");
        return new AmountDetailsResponse(d2, d3, str4, d4, i2, str5, d5, str6);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AmountDetailsResponse) {
                AmountDetailsResponse amountDetailsResponse = (AmountDetailsResponse) obj;
                if (Double.compare(this.interest, amountDetailsResponse.interest) == 0 && Double.compare(this.intrest_rate, amountDetailsResponse.intrest_rate) == 0 && k.a((Object) this.message, (Object) amountDetailsResponse.message) && Double.compare(this.net_amount_payout, amountDetailsResponse.net_amount_payout) == 0) {
                    if (!(this.response_code == amountDetailsResponse.response_code) || !k.a((Object) this.status, (Object) amountDetailsResponse.status) || Double.compare(this.trial_closure_amount, amountDetailsResponse.trial_closure_amount) != 0 || !k.a((Object) this.txn_id, (Object) amountDetailsResponse.txn_id)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.interest);
        long doubleToLongBits2 = Double.doubleToLongBits(this.intrest_rate);
        int i2 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str = this.message;
        int i3 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long doubleToLongBits3 = Double.doubleToLongBits(this.net_amount_payout);
        int i4 = (((((i2 + hashCode) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + this.response_code) * 31;
        String str2 = this.status;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        long doubleToLongBits4 = Double.doubleToLongBits(this.trial_closure_amount);
        int i5 = (((i4 + hashCode2) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31;
        String str3 = this.txn_id;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return i5 + i3;
    }

    public final String toString() {
        return "AmountDetailsResponse(interest=" + this.interest + ", intrest_rate=" + this.intrest_rate + ", message=" + this.message + ", net_amount_payout=" + this.net_amount_payout + ", response_code=" + this.response_code + ", status=" + this.status + ", trial_closure_amount=" + this.trial_closure_amount + ", txn_id=" + this.txn_id + ")";
    }

    public final double getInterest() {
        return this.interest;
    }

    public final double getIntrest_rate() {
        return this.intrest_rate;
    }

    public final String getMessage() {
        return this.message;
    }

    public final double getNet_amount_payout() {
        return this.net_amount_payout;
    }

    public final int getResponse_code() {
        return this.response_code;
    }

    public final String getStatus() {
        return this.status;
    }

    public final double getTrial_closure_amount() {
        return this.trial_closure_amount;
    }

    public AmountDetailsResponse(double d2, double d3, String str, double d4, int i2, String str2, double d5, String str3) {
        k.c(str, "message");
        k.c(str2, "status");
        k.c(str3, "txn_id");
        this.interest = d2;
        this.intrest_rate = d3;
        this.message = str;
        this.net_amount_payout = d4;
        this.response_code = i2;
        this.status = str2;
        this.trial_closure_amount = d5;
        this.txn_id = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AmountDetailsResponse(double r15, double r17, java.lang.String r19, double r20, int r22, java.lang.String r23, double r24, java.lang.String r26, int r27, kotlin.g.b.g r28) {
        /*
            r14 = this;
            r0 = r27
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000b
        L_0x000a:
            r4 = r15
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r6 = r2
            goto L_0x0013
        L_0x0011:
            r6 = r17
        L_0x0013:
            r1 = r0 & 4
            java.lang.String r8 = ""
            if (r1 == 0) goto L_0x001b
            r1 = r8
            goto L_0x001d
        L_0x001b:
            r1 = r19
        L_0x001d:
            r9 = r0 & 8
            if (r9 == 0) goto L_0x0023
            r9 = r2
            goto L_0x0025
        L_0x0023:
            r9 = r20
        L_0x0025:
            r11 = r0 & 16
            if (r11 == 0) goto L_0x002b
            r11 = 0
            goto L_0x002d
        L_0x002b:
            r11 = r22
        L_0x002d:
            r12 = r0 & 32
            if (r12 == 0) goto L_0x0033
            r12 = r8
            goto L_0x0035
        L_0x0033:
            r12 = r23
        L_0x0035:
            r13 = r0 & 64
            if (r13 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r24
        L_0x003c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r8 = r26
        L_0x0043:
            r15 = r14
            r16 = r4
            r18 = r6
            r20 = r1
            r21 = r9
            r23 = r11
            r24 = r12
            r25 = r2
            r27 = r8
            r15.<init>(r16, r18, r20, r21, r23, r24, r25, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.AmountDetailsResponse.<init>(double, double, java.lang.String, double, int, java.lang.String, double, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getTxn_id() {
        return this.txn_id;
    }
}
