package net.one97.paytm.paymentsBank.model.slfd;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class FdDetailsResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_amount")
    private final double bookingAmount;
    @b(a = "booking_date")
    private final String bookingDate;
    @b(a = "fd_id")
    private final String fdId;
    @b(a = "transaction_list")
    private final List<RedemptionTransactionList> fdList;
    @b(a = "fd_status")
    private final String fdStatus;
    @b(a = "interest_rate_per_annum")
    private final String interest_rate_per_annum;
    @b(a = "interest_rate_annualized")
    private final String intrestRateAnnual;
    @b(a = "lien_amount")
    private final double lien_amount;
    @b(a = "locked_amount")
    private final double locked_amount;
    @b(a = "maturity_amount")
    private final double maturity_amount;
    @b(a = "maturity_date")
    private final String maturity_date;
    @b(a = "message")
    private final String message;
    @b(a = "net_principal_amount")
    private final Double net_principal_amount;
    @b(a = "nominee_details")
    private final NomineeDetailsResponse nomineeDetails;
    @b(a = "nominee_id")
    private final String nominee_id;
    @b(a = "response_code")
    private final int response_code;
    @b(a = "status")
    private final String status;
    @b(a = "tds_deducted")
    private final double tds_deducted;

    public FdDetailsResponse() {
        this(0.0d, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 0, 0.0d, 0.0d, 0.0d, (String) null, (String) null, (String) null, (String) null, 0.0d, (Double) null, (NomineeDetailsResponse) null, 262143, (g) null);
    }

    public static /* synthetic */ FdDetailsResponse copy$default(FdDetailsResponse fdDetailsResponse, double d2, String str, String str2, String str3, String str4, String str5, List list, int i2, double d3, double d4, double d5, String str6, String str7, String str8, String str9, double d6, Double d7, NomineeDetailsResponse nomineeDetailsResponse, int i3, Object obj) {
        FdDetailsResponse fdDetailsResponse2 = fdDetailsResponse;
        int i4 = i3;
        return fdDetailsResponse.copy((i4 & 1) != 0 ? fdDetailsResponse2.bookingAmount : d2, (i4 & 2) != 0 ? fdDetailsResponse2.bookingDate : str, (i4 & 4) != 0 ? fdDetailsResponse2.fdId : str2, (i4 & 8) != 0 ? fdDetailsResponse2.fdStatus : str3, (i4 & 16) != 0 ? fdDetailsResponse2.intrestRateAnnual : str4, (i4 & 32) != 0 ? fdDetailsResponse2.interest_rate_per_annum : str5, (i4 & 64) != 0 ? fdDetailsResponse2.fdList : list, (i4 & 128) != 0 ? fdDetailsResponse2.response_code : i2, (i4 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? fdDetailsResponse2.lien_amount : d3, (i4 & 512) != 0 ? fdDetailsResponse2.locked_amount : d4, (i4 & TarConstants.EOF_BLOCK) != 0 ? fdDetailsResponse2.maturity_amount : d5, (i4 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? fdDetailsResponse2.maturity_date : str6, (i4 & 4096) != 0 ? fdDetailsResponse2.nominee_id : str7, (i4 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? fdDetailsResponse2.status : str8, (i4 & 16384) != 0 ? fdDetailsResponse2.message : str9, (i4 & 32768) != 0 ? fdDetailsResponse2.tds_deducted : d6, (i4 & 65536) != 0 ? fdDetailsResponse2.net_principal_amount : d7, (i4 & 131072) != 0 ? fdDetailsResponse2.nomineeDetails : nomineeDetailsResponse);
    }

    public final double component1() {
        return this.bookingAmount;
    }

    public final double component10() {
        return this.locked_amount;
    }

    public final double component11() {
        return this.maturity_amount;
    }

    public final String component12() {
        return this.maturity_date;
    }

    public final String component13() {
        return this.nominee_id;
    }

    public final String component14() {
        return this.status;
    }

    public final String component15() {
        return this.message;
    }

    public final double component16() {
        return this.tds_deducted;
    }

    public final Double component17() {
        return this.net_principal_amount;
    }

    public final NomineeDetailsResponse component18() {
        return this.nomineeDetails;
    }

    public final String component2() {
        return this.bookingDate;
    }

    public final String component3() {
        return this.fdId;
    }

    public final String component4() {
        return this.fdStatus;
    }

    public final String component5() {
        return this.intrestRateAnnual;
    }

    public final String component6() {
        return this.interest_rate_per_annum;
    }

    public final List<RedemptionTransactionList> component7() {
        return this.fdList;
    }

    public final int component8() {
        return this.response_code;
    }

    public final double component9() {
        return this.lien_amount;
    }

    public final FdDetailsResponse copy(double d2, String str, String str2, String str3, String str4, String str5, List<RedemptionTransactionList> list, int i2, double d3, double d4, double d5, String str6, String str7, String str8, String str9, double d6, Double d7, NomineeDetailsResponse nomineeDetailsResponse) {
        double d8 = d2;
        k.c(list, "fdList");
        return new FdDetailsResponse(d2, str, str2, str3, str4, str5, list, i2, d3, d4, d5, str6, str7, str8, str9, d6, d7, nomineeDetailsResponse);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FdDetailsResponse) {
                FdDetailsResponse fdDetailsResponse = (FdDetailsResponse) obj;
                if (Double.compare(this.bookingAmount, fdDetailsResponse.bookingAmount) == 0 && k.a((Object) this.bookingDate, (Object) fdDetailsResponse.bookingDate) && k.a((Object) this.fdId, (Object) fdDetailsResponse.fdId) && k.a((Object) this.fdStatus, (Object) fdDetailsResponse.fdStatus) && k.a((Object) this.intrestRateAnnual, (Object) fdDetailsResponse.intrestRateAnnual) && k.a((Object) this.interest_rate_per_annum, (Object) fdDetailsResponse.interest_rate_per_annum) && k.a((Object) this.fdList, (Object) fdDetailsResponse.fdList)) {
                    if (!(this.response_code == fdDetailsResponse.response_code) || Double.compare(this.lien_amount, fdDetailsResponse.lien_amount) != 0 || Double.compare(this.locked_amount, fdDetailsResponse.locked_amount) != 0 || Double.compare(this.maturity_amount, fdDetailsResponse.maturity_amount) != 0 || !k.a((Object) this.maturity_date, (Object) fdDetailsResponse.maturity_date) || !k.a((Object) this.nominee_id, (Object) fdDetailsResponse.nominee_id) || !k.a((Object) this.status, (Object) fdDetailsResponse.status) || !k.a((Object) this.message, (Object) fdDetailsResponse.message) || Double.compare(this.tds_deducted, fdDetailsResponse.tds_deducted) != 0 || !k.a((Object) this.net_principal_amount, (Object) fdDetailsResponse.net_principal_amount) || !k.a((Object) this.nomineeDetails, (Object) fdDetailsResponse.nomineeDetails)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.bookingAmount);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        String str = this.bookingDate;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fdId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fdStatus;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.intrestRateAnnual;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.interest_rate_per_annum;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<RedemptionTransactionList> list = this.fdList;
        int hashCode6 = list != null ? list.hashCode() : 0;
        long doubleToLongBits2 = Double.doubleToLongBits(this.lien_amount);
        long doubleToLongBits3 = Double.doubleToLongBits(this.locked_amount);
        long doubleToLongBits4 = Double.doubleToLongBits(this.maturity_amount);
        int i4 = (((((((((hashCode5 + hashCode6) * 31) + this.response_code) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31;
        String str6 = this.maturity_date;
        int hashCode7 = (i4 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.nominee_id;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.status;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.message;
        int hashCode10 = str9 != null ? str9.hashCode() : 0;
        long doubleToLongBits5 = Double.doubleToLongBits(this.tds_deducted);
        int i5 = (((hashCode9 + hashCode10) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31;
        Double d2 = this.net_principal_amount;
        int hashCode11 = (i5 + (d2 != null ? d2.hashCode() : 0)) * 31;
        NomineeDetailsResponse nomineeDetailsResponse = this.nomineeDetails;
        if (nomineeDetailsResponse != null) {
            i3 = nomineeDetailsResponse.hashCode();
        }
        return hashCode11 + i3;
    }

    public final String toString() {
        return "FdDetailsResponse(bookingAmount=" + this.bookingAmount + ", bookingDate=" + this.bookingDate + ", fdId=" + this.fdId + ", fdStatus=" + this.fdStatus + ", intrestRateAnnual=" + this.intrestRateAnnual + ", interest_rate_per_annum=" + this.interest_rate_per_annum + ", fdList=" + this.fdList + ", response_code=" + this.response_code + ", lien_amount=" + this.lien_amount + ", locked_amount=" + this.locked_amount + ", maturity_amount=" + this.maturity_amount + ", maturity_date=" + this.maturity_date + ", nominee_id=" + this.nominee_id + ", status=" + this.status + ", message=" + this.message + ", tds_deducted=" + this.tds_deducted + ", net_principal_amount=" + this.net_principal_amount + ", nomineeDetails=" + this.nomineeDetails + ")";
    }

    public final double getBookingAmount() {
        return this.bookingAmount;
    }

    public final String getBookingDate() {
        return this.bookingDate;
    }

    public final String getFdId() {
        return this.fdId;
    }

    public final String getFdStatus() {
        return this.fdStatus;
    }

    public final String getIntrestRateAnnual() {
        return this.intrestRateAnnual;
    }

    public final String getInterest_rate_per_annum() {
        return this.interest_rate_per_annum;
    }

    public final List<RedemptionTransactionList> getFdList() {
        return this.fdList;
    }

    public final int getResponse_code() {
        return this.response_code;
    }

    public final double getLien_amount() {
        return this.lien_amount;
    }

    public final double getLocked_amount() {
        return this.locked_amount;
    }

    public final double getMaturity_amount() {
        return this.maturity_amount;
    }

    public final String getMaturity_date() {
        return this.maturity_date;
    }

    public final String getNominee_id() {
        return this.nominee_id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final double getTds_deducted() {
        return this.tds_deducted;
    }

    public final Double getNet_principal_amount() {
        return this.net_principal_amount;
    }

    public FdDetailsResponse(double d2, String str, String str2, String str3, String str4, String str5, List<RedemptionTransactionList> list, int i2, double d3, double d4, double d5, String str6, String str7, String str8, String str9, double d6, Double d7, NomineeDetailsResponse nomineeDetailsResponse) {
        k.c(list, "fdList");
        this.bookingAmount = d2;
        this.bookingDate = str;
        this.fdId = str2;
        this.fdStatus = str3;
        this.intrestRateAnnual = str4;
        this.interest_rate_per_annum = str5;
        this.fdList = list;
        this.response_code = i2;
        this.lien_amount = d3;
        this.locked_amount = d4;
        this.maturity_amount = d5;
        this.maturity_date = str6;
        this.nominee_id = str7;
        this.status = str8;
        this.message = str9;
        this.tds_deducted = d6;
        this.net_principal_amount = d7;
        this.nomineeDetails = nomineeDetailsResponse;
    }

    public final NomineeDetailsResponse getNomineeDetails() {
        return this.nomineeDetails;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FdDetailsResponse(double r25, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.util.List r32, int r33, double r34, double r36, double r38, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, double r44, java.lang.Double r46, net.one97.paytm.paymentsBank.model.slfd.NomineeDetailsResponse r47, int r48, kotlin.g.b.g r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r4 = 0
            goto L_0x000b
        L_0x0009:
            r4 = r25
        L_0x000b:
            r1 = r0 & 2
            java.lang.String r6 = ""
            if (r1 == 0) goto L_0x0013
            r1 = r6
            goto L_0x0015
        L_0x0013:
            r1 = r27
        L_0x0015:
            r7 = r0 & 4
            if (r7 == 0) goto L_0x001b
            r7 = r6
            goto L_0x001d
        L_0x001b:
            r7 = r28
        L_0x001d:
            r8 = r0 & 8
            if (r8 == 0) goto L_0x0023
            r8 = r6
            goto L_0x0025
        L_0x0023:
            r8 = r29
        L_0x0025:
            r9 = r0 & 16
            if (r9 == 0) goto L_0x002b
            r9 = r6
            goto L_0x002d
        L_0x002b:
            r9 = r30
        L_0x002d:
            r10 = r0 & 32
            if (r10 == 0) goto L_0x0033
            r10 = r6
            goto L_0x0035
        L_0x0033:
            r10 = r31
        L_0x0035:
            r11 = r0 & 64
            if (r11 == 0) goto L_0x003e
            kotlin.a.w r11 = kotlin.a.w.INSTANCE
            java.util.List r11 = (java.util.List) r11
            goto L_0x0040
        L_0x003e:
            r11 = r32
        L_0x0040:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0046
            r12 = 0
            goto L_0x0048
        L_0x0046:
            r12 = r33
        L_0x0048:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x004f
            r13 = 0
            goto L_0x0051
        L_0x004f:
            r13 = r34
        L_0x0051:
            r15 = r0 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x0058
            r15 = 0
            goto L_0x005a
        L_0x0058:
            r15 = r36
        L_0x005a:
            r2 = r0 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0061
            r2 = 0
            goto L_0x0063
        L_0x0061:
            r2 = r38
        L_0x0063:
            r25 = r6
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x006c
            r6 = r25
            goto L_0x006e
        L_0x006c:
            r6 = r40
        L_0x006e:
            r49 = r6
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0077
            r6 = r25
            goto L_0x0079
        L_0x0077:
            r6 = r41
        L_0x0079:
            r19 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0082
            r6 = r25
            goto L_0x0084
        L_0x0082:
            r6 = r42
        L_0x0084:
            r20 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x008d
            r6 = r25
            goto L_0x008f
        L_0x008d:
            r6 = r43
        L_0x008f:
            r21 = 32768(0x8000, float:4.5918E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x0099
            r21 = 0
            goto L_0x009b
        L_0x0099:
            r21 = r44
        L_0x009b:
            r23 = 65536(0x10000, float:9.18355E-41)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00a8
            r17 = 0
            java.lang.Double r17 = java.lang.Double.valueOf(r17)
            goto L_0x00aa
        L_0x00a8:
            r17 = r46
        L_0x00aa:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x00b2
            r0 = 0
            goto L_0x00b4
        L_0x00b2:
            r0 = r47
        L_0x00b4:
            r25 = r24
            r26 = r4
            r28 = r1
            r29 = r7
            r30 = r8
            r31 = r9
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r13
            r37 = r15
            r39 = r2
            r41 = r49
            r42 = r19
            r43 = r20
            r44 = r6
            r45 = r21
            r47 = r17
            r48 = r0
            r25.<init>(r26, r28, r29, r30, r31, r32, r33, r34, r35, r37, r39, r41, r42, r43, r44, r45, r47, r48)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.FdDetailsResponse.<init>(double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, double, double, double, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, java.lang.Double, net.one97.paytm.paymentsBank.model.slfd.NomineeDetailsResponse, int, kotlin.g.b.g):void");
    }
}
