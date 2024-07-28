package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryBody;
import net.one97.paytmflight.common.entity.flightticket.CJROrderSummaryStatus;

public class CJRFlightOrderSummaryResponse extends IJRPaytmDataModel implements IJRDataModel {
    private CJROrderSummaryBody body;
    private String code;
    private String error;
    private Meta meta;
    private CJROrderSummaryStatus status;

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public static class Meta implements IJRDataModel {
        @b(a = "hotel_summary")
        private HotelSummary hotel_summary;
        private String requestid;

        public String getRequestid() {
            return this.requestid;
        }

        public void setRequestid(String str) {
            this.requestid = str;
        }

        public HotelSummary getHotel_summary() {
            return this.hotel_summary;
        }
    }

    public static class HotelSummary implements IJRDataModel {
        @b(a = "request_details")
        private RequestDetails request_details;

        public RequestDetails getRequest_details() {
            return this.request_details;
        }
    }

    public static class RequestDetails implements IJRDataModel {
        @b(a = "startDate")
        private String startDate;

        public String getStartDate() {
            return this.startDate;
        }
    }

    public CJROrderSummaryStatus getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public CJROrderSummaryBody getBody() {
        return this.body;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}
