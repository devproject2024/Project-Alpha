package net.one97.paytm.paymentsBank.model.slfd;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class BookingResponseListItem extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "fdBookingAmount")
    private final Double fdBookingAmount;
    @b(a = "fdBookingDate")
    private final long fdBookingDate;
    @b(a = "fdNumber")
    private final String fdNumber;
    @b(a = "maturityAmount")
    private final Double maturityAmount;
    @b(a = "maturityDate")
    private final String maturityDate;
    @b(a = "message")
    private final String message;
    @b(a = "nomineeId")
    private final String nomineeId;
    @b(a = "rateOfInterestAnnualized")
    private final Double rateOfInterestAnnualized;
    @b(a = "rateOfInterestPa")
    private final Double rateOfInterestPa;
    @b(a = "status")
    private final String status;
    @b(a = "transactionId")
    private final String transactionId;

    public static /* synthetic */ BookingResponseListItem copy$default(BookingResponseListItem bookingResponseListItem, Double d2, long j, String str, Double d3, String str2, String str3, Double d4, String str4, Double d5, String str5, String str6, int i2, Object obj) {
        BookingResponseListItem bookingResponseListItem2 = bookingResponseListItem;
        int i3 = i2;
        return bookingResponseListItem.copy((i3 & 1) != 0 ? bookingResponseListItem2.fdBookingAmount : d2, (i3 & 2) != 0 ? bookingResponseListItem2.fdBookingDate : j, (i3 & 4) != 0 ? bookingResponseListItem2.fdNumber : str, (i3 & 8) != 0 ? bookingResponseListItem2.maturityAmount : d3, (i3 & 16) != 0 ? bookingResponseListItem2.maturityDate : str2, (i3 & 32) != 0 ? bookingResponseListItem2.message : str3, (i3 & 64) != 0 ? bookingResponseListItem2.rateOfInterestPa : d4, (i3 & 128) != 0 ? bookingResponseListItem2.nomineeId : str4, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? bookingResponseListItem2.rateOfInterestAnnualized : d5, (i3 & 512) != 0 ? bookingResponseListItem2.status : str5, (i3 & TarConstants.EOF_BLOCK) != 0 ? bookingResponseListItem2.transactionId : str6);
    }

    public final Double component1() {
        return this.fdBookingAmount;
    }

    public final String component10() {
        return this.status;
    }

    public final String component11() {
        return this.transactionId;
    }

    public final long component2() {
        return this.fdBookingDate;
    }

    public final String component3() {
        return this.fdNumber;
    }

    public final Double component4() {
        return this.maturityAmount;
    }

    public final String component5() {
        return this.maturityDate;
    }

    public final String component6() {
        return this.message;
    }

    public final Double component7() {
        return this.rateOfInterestPa;
    }

    public final String component8() {
        return this.nomineeId;
    }

    public final Double component9() {
        return this.rateOfInterestAnnualized;
    }

    public final BookingResponseListItem copy(Double d2, long j, String str, Double d3, String str2, String str3, Double d4, String str4, Double d5, String str5, String str6) {
        return new BookingResponseListItem(d2, j, str, d3, str2, str3, d4, str4, d5, str5, str6);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BookingResponseListItem) {
                BookingResponseListItem bookingResponseListItem = (BookingResponseListItem) obj;
                if (k.a((Object) this.fdBookingAmount, (Object) bookingResponseListItem.fdBookingAmount)) {
                    if (!(this.fdBookingDate == bookingResponseListItem.fdBookingDate) || !k.a((Object) this.fdNumber, (Object) bookingResponseListItem.fdNumber) || !k.a((Object) this.maturityAmount, (Object) bookingResponseListItem.maturityAmount) || !k.a((Object) this.maturityDate, (Object) bookingResponseListItem.maturityDate) || !k.a((Object) this.message, (Object) bookingResponseListItem.message) || !k.a((Object) this.rateOfInterestPa, (Object) bookingResponseListItem.rateOfInterestPa) || !k.a((Object) this.nomineeId, (Object) bookingResponseListItem.nomineeId) || !k.a((Object) this.rateOfInterestAnnualized, (Object) bookingResponseListItem.rateOfInterestAnnualized) || !k.a((Object) this.status, (Object) bookingResponseListItem.status) || !k.a((Object) this.transactionId, (Object) bookingResponseListItem.transactionId)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Double d2 = this.fdBookingAmount;
        int i2 = 0;
        int hashCode = d2 != null ? d2.hashCode() : 0;
        long j = this.fdBookingDate;
        int i3 = ((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.fdNumber;
        int hashCode2 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        Double d3 = this.maturityAmount;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 31;
        String str2 = this.maturityDate;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d4 = this.rateOfInterestPa;
        int hashCode6 = (hashCode5 + (d4 != null ? d4.hashCode() : 0)) * 31;
        String str4 = this.nomineeId;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Double d5 = this.rateOfInterestAnnualized;
        int hashCode8 = (hashCode7 + (d5 != null ? d5.hashCode() : 0)) * 31;
        String str5 = this.status;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.transactionId;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "BookingResponseListItem(fdBookingAmount=" + this.fdBookingAmount + ", fdBookingDate=" + this.fdBookingDate + ", fdNumber=" + this.fdNumber + ", maturityAmount=" + this.maturityAmount + ", maturityDate=" + this.maturityDate + ", message=" + this.message + ", rateOfInterestPa=" + this.rateOfInterestPa + ", nomineeId=" + this.nomineeId + ", rateOfInterestAnnualized=" + this.rateOfInterestAnnualized + ", status=" + this.status + ", transactionId=" + this.transactionId + ")";
    }

    public final Double getFdBookingAmount() {
        return this.fdBookingAmount;
    }

    public final long getFdBookingDate() {
        return this.fdBookingDate;
    }

    public final String getFdNumber() {
        return this.fdNumber;
    }

    public final Double getMaturityAmount() {
        return this.maturityAmount;
    }

    public final String getMaturityDate() {
        return this.maturityDate;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Double getRateOfInterestPa() {
        return this.rateOfInterestPa;
    }

    public final String getNomineeId() {
        return this.nomineeId;
    }

    public final Double getRateOfInterestAnnualized() {
        return this.rateOfInterestAnnualized;
    }

    public final String getStatus() {
        return this.status;
    }

    public BookingResponseListItem(Double d2, long j, String str, Double d3, String str2, String str3, Double d4, String str4, Double d5, String str5, String str6) {
        this.fdBookingAmount = d2;
        this.fdBookingDate = j;
        this.fdNumber = str;
        this.maturityAmount = d3;
        this.maturityDate = str2;
        this.message = str3;
        this.rateOfInterestPa = d4;
        this.nomineeId = str4;
        this.rateOfInterestAnnualized = d5;
        this.status = str5;
        this.transactionId = str6;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }
}
