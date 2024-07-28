package net.one97.paytm.orders.datamodel;

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

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public CJRSummarySendTicketItem f56865a;

        public a() {
            this.f56865a = null;
            this.f56865a = new CJRSummarySendTicketItem();
        }
    }
}
