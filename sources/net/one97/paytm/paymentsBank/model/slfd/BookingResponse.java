package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class BookingResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "booking_response_list")
    private final List<BookingResponseListItem> bookingResponseList;
    @b(a = "status")
    private final Integer masterStatus;
    @b(a = "message")
    private final String message;

    public static /* synthetic */ BookingResponse copy$default(BookingResponse bookingResponse, String str, Integer num, List<BookingResponseListItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bookingResponse.message;
        }
        if ((i2 & 2) != 0) {
            num = bookingResponse.masterStatus;
        }
        if ((i2 & 4) != 0) {
            list = bookingResponse.bookingResponseList;
        }
        return bookingResponse.copy(str, num, list);
    }

    public final String component1() {
        return this.message;
    }

    public final Integer component2() {
        return this.masterStatus;
    }

    public final List<BookingResponseListItem> component3() {
        return this.bookingResponseList;
    }

    public final BookingResponse copy(String str, Integer num, List<BookingResponseListItem> list) {
        return new BookingResponse(str, num, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookingResponse)) {
            return false;
        }
        BookingResponse bookingResponse = (BookingResponse) obj;
        return k.a((Object) this.message, (Object) bookingResponse.message) && k.a((Object) this.masterStatus, (Object) bookingResponse.masterStatus) && k.a((Object) this.bookingResponseList, (Object) bookingResponse.bookingResponseList);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.masterStatus;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        List<BookingResponseListItem> list = this.bookingResponseList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "BookingResponse(message=" + this.message + ", masterStatus=" + this.masterStatus + ", bookingResponseList=" + this.bookingResponseList + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getMasterStatus() {
        return this.masterStatus;
    }

    public BookingResponse(String str, Integer num, List<BookingResponseListItem> list) {
        this.message = str;
        this.masterStatus = num;
        this.bookingResponseList = list;
    }

    public final List<BookingResponseListItem> getBookingResponseList() {
        return this.bookingResponseList;
    }
}
