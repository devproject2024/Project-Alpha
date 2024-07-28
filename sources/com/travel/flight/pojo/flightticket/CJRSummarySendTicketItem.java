package com.travel.flight.pojo.flightticket;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRSummarySendTicketItem implements IJRDataModel {
    /* access modifiers changed from: private */
    public String durationBeforeShowTime;
    /* access modifiers changed from: private */
    public int isInsurancePresent;
    /* access modifiers changed from: private */
    public int movieInsuranceState;
    /* access modifiers changed from: private */
    public int noOfTickets;
    /* access modifiers changed from: private */
    public String orderId;

    public String getOrderId() {
        return this.orderId;
    }

    public int getNoOfTickets() {
        return this.noOfTickets;
    }

    public int getIsInsurancePresent() {
        return this.isInsurancePresent;
    }

    public int getMovieInsuranceState() {
        return this.movieInsuranceState;
    }

    public String getDurationBeforeShowTime() {
        return this.durationBeforeShowTime;
    }
}
