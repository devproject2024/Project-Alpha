package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.travelpass.model.TravelPassMetaData;

public final class TPAboutResponse extends IJRPaytmDataModel {
    private final int code;
    private final String message;
    @b(a = "body")
    private final TPResponseBody tpAboutData;

    public final String getMessage() {
        return this.message;
    }

    public final int getCode() {
        return this.code;
    }

    public final TPResponseBody getTpAboutData() {
        return this.tpAboutData;
    }

    public static final class TPResponseBody extends IJRPaytmDataModel {
        private final String cardLevelPartnerOfferHeading;
        private final String error;
        @b(a = "howToS")
        private final TravelPassMetaData.HowToData howtos;
        private final List<InternalOfferData> internalOffers;
        private final TravelPassMetaData.PassAboutInfo knowMore;
        private final String message;
        private final List<PartnersOfferData> partnerOffers;
        private final String selectedPassesHeading;
        private final String status;
        private final ArrayList<TravelPassMetaData.TncData> tnc;

        public final String getStatus() {
            return this.status;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getError() {
            return this.error;
        }

        public final List<PartnersOfferData> getPartnerOffers() {
            return this.partnerOffers;
        }

        public final List<InternalOfferData> getInternalOffers() {
            return this.internalOffers;
        }

        public final TravelPassMetaData.PassAboutInfo getKnowMore() {
            return this.knowMore;
        }

        public final String getCardLevelPartnerOfferHeading() {
            return this.cardLevelPartnerOfferHeading;
        }

        public final String getSelectedPassesHeading() {
            return this.selectedPassesHeading;
        }

        public final TravelPassMetaData.HowToData getHowtos() {
            return this.howtos;
        }

        public final ArrayList<TravelPassMetaData.TncData> getTnc() {
            return this.tnc;
        }
    }
}
