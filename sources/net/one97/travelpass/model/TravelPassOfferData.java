package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class TravelPassOfferData extends IJRPaytmDataModel {
    @b(a = "message")
    private String message;
    @b(a = "meta")
    private OffersExtra meta;
    @b(a = "data")
    private OffersData offersData;
    @b(a = "Status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public OffersData getOffersData() {
        return this.offersData;
    }

    public OffersExtra getMeta() {
        return this.meta;
    }

    public class OffersExtra extends IJRPaytmDataModel {
        @b(a = "tnc")
        private List<OffersTnc> offersTnc;
        @b(a = "partnerOfferHeading")
        private String partnerOfferHeading;

        public OffersExtra() {
        }

        public List<OffersTnc> getOffersTnc() {
            return this.offersTnc;
        }

        public String getPartnerOfferHeading() {
            return this.partnerOfferHeading;
        }
    }

    public class OffersTnc extends IJRPaytmDataModel {
        @b(a = "_id")
        private String id;
        @b(a = "tncContent")
        private List<String> tncContent;
        @b(a = "tncId")
        private String tncId;

        public OffersTnc() {
        }

        public String getId() {
            return this.id;
        }

        public String getTncId() {
            return this.tncId;
        }

        public List<String> getTncContent() {
            return this.tncContent;
        }
    }
}
