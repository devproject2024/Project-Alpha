package com.travel.flight.pojo.flightticket.flighthomepage;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightHomepageRequestFilterResponse extends IJRPaytmDataModel {
    private CJRBody body;

    public CJRBody getBody() {
        return this.body;
    }

    public void setBody(CJRBody cJRBody) {
        this.body = cJRBody;
    }

    public static class CJRBody implements IJRDataModel {
        private String banner_url;
        private boolean is_non_stop_checked;
        private List<IJROnward> onward;
        @b(a = "return")
        private List<IJROnward> returnJourny;

        public boolean isNonStopChecked() {
            return this.is_non_stop_checked;
        }

        public List<IJROnward> getOnward() {
            return this.onward;
        }

        public List<IJROnward> getReturnJourny() {
            return this.returnJourny;
        }

        public String getBannerurl() {
            return this.banner_url;
        }
    }

    public static class IJROnward implements IJRDataModel {
        private String header;
        private String message;

        public String getHeader() {
            return this.header;
        }

        public void setHeader(String str) {
            this.header = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }
}
