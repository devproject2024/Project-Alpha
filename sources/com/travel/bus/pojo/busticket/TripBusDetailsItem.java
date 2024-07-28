package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.pojo.bussearch.CJRDetailedFare;

public class TripBusDetailsItem extends IJRPaytmDataModel {
    @a
    @b(a = "column")
    private long column;
    @a
    @b(a = "detailed_fare")
    public CJRDetailedFare detailedFare;
    @a
    @b(a = "fare")
    private String fare;
    @a
    @b(a = "isAvailable")
    private boolean isAvailable;
    @a
    @b(a = "is_blocked_for_social_distancing")
    private boolean isBlockedForSocialDistancing;
    @a
    @b(a = "isLadiesSeat")
    private Boolean isLadiesSeat;
    @a
    @b(a = "isLowerBerth")
    private Boolean isLowerBerth;
    @a
    @b(a = "isMenSeat")
    private Boolean isMenSeat;
    @a
    @b(a = "length")
    private long length;
    @a
    @b(a = "product_id")
    private String productId;
    @a
    @b(a = "row")
    private long row;
    @b(a = "seatName")
    private String seatName;
    @a
    @b(a = "width")
    private long width;

    public boolean getAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean z) {
        this.isAvailable = z;
    }

    public String getFare() {
        CJRDetailedFare cJRDetailedFare = this.detailedFare;
        if (cJRDetailedFare == null || cJRDetailedFare.getBaseFare() == null) {
            return this.fare;
        }
        return String.valueOf(this.detailedFare.getBaseFare());
    }

    public void setFare(String str) {
        this.fare = str;
    }

    public Boolean getLadiesSeat() {
        return this.isLadiesSeat;
    }

    public void setLadiesSeat(Boolean bool) {
        this.isLadiesSeat = bool;
    }

    public String getSeatName() {
        return this.seatName;
    }

    public void setSeatName(String str) {
        this.seatName = str;
    }

    public Boolean getLowerBerth() {
        return this.isLowerBerth;
    }

    public void setLowerBerth(Boolean bool) {
        this.isLowerBerth = bool;
    }

    public long getRow() {
        return this.row;
    }

    public void setRow(long j) {
        this.row = j;
    }

    public long getColumn() {
        return this.column;
    }

    public void setColumn(long j) {
        this.column = j;
    }

    public long getLength() {
        return this.length;
    }

    public long getWidth() {
        return this.width;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setMenSeat(Boolean bool) {
        this.isMenSeat = bool;
    }

    public boolean isBlockedForSocialDistancing() {
        return this.isBlockedForSocialDistancing;
    }
}
