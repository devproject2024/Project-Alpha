package net.one97.paytm.o2o.movies.common.movies.booking;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAddSeat extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "bookingId")
    private String bookingId;
    @b(a = "bookingIndex")
    private String bookingIndex;
    @b(a = "seatCodes")
    private ArrayList<String> seatCodes = new ArrayList<>();
    @b(a = "seatInfo")
    private String seatInfo;
    @b(a = "tempTransId")
    private String tempTransId;
    @b(a = "totalAmount")
    private String totalAmount;
    @b(a = "uniqueBookingId")
    private String uniqueBookingId;

    public String getBookingId() {
        return this.bookingId;
    }

    public String getSeatInfo() {
        return this.seatInfo;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTempTransId() {
        return this.tempTransId;
    }

    public String getBookingIndex() {
        return this.bookingIndex;
    }

    public String getUniqueBookingId() {
        return this.uniqueBookingId;
    }

    public ArrayList<String> getSeatCodes() {
        return this.seatCodes;
    }
}
