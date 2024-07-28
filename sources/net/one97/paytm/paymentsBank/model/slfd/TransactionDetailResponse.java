package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class TransactionDetailResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_response")
    private final BookingResponse bookingResponse;
    @b(a = "redemption_response")
    private final RedemptionResponse redemptionResponse;

    public TransactionDetailResponse() {
        this((BookingResponse) null, (RedemptionResponse) null, 3, (g) null);
    }

    public static /* synthetic */ TransactionDetailResponse copy$default(TransactionDetailResponse transactionDetailResponse, BookingResponse bookingResponse2, RedemptionResponse redemptionResponse2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bookingResponse2 = transactionDetailResponse.bookingResponse;
        }
        if ((i2 & 2) != 0) {
            redemptionResponse2 = transactionDetailResponse.redemptionResponse;
        }
        return transactionDetailResponse.copy(bookingResponse2, redemptionResponse2);
    }

    public final BookingResponse component1() {
        return this.bookingResponse;
    }

    public final RedemptionResponse component2() {
        return this.redemptionResponse;
    }

    public final TransactionDetailResponse copy(BookingResponse bookingResponse2, RedemptionResponse redemptionResponse2) {
        return new TransactionDetailResponse(bookingResponse2, redemptionResponse2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionDetailResponse)) {
            return false;
        }
        TransactionDetailResponse transactionDetailResponse = (TransactionDetailResponse) obj;
        return k.a((Object) this.bookingResponse, (Object) transactionDetailResponse.bookingResponse) && k.a((Object) this.redemptionResponse, (Object) transactionDetailResponse.redemptionResponse);
    }

    public final int hashCode() {
        BookingResponse bookingResponse2 = this.bookingResponse;
        int i2 = 0;
        int hashCode = (bookingResponse2 != null ? bookingResponse2.hashCode() : 0) * 31;
        RedemptionResponse redemptionResponse2 = this.redemptionResponse;
        if (redemptionResponse2 != null) {
            i2 = redemptionResponse2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TransactionDetailResponse(bookingResponse=" + this.bookingResponse + ", redemptionResponse=" + this.redemptionResponse + ")";
    }

    public final BookingResponse getBookingResponse() {
        return this.bookingResponse;
    }

    public TransactionDetailResponse(BookingResponse bookingResponse2, RedemptionResponse redemptionResponse2) {
        this.bookingResponse = bookingResponse2;
        this.redemptionResponse = redemptionResponse2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransactionDetailResponse(BookingResponse bookingResponse2, RedemptionResponse redemptionResponse2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bookingResponse2, (i2 & 2) != 0 ? null : redemptionResponse2);
    }

    public final RedemptionResponse getRedemptionResponse() {
        return this.redemptionResponse;
    }
}
