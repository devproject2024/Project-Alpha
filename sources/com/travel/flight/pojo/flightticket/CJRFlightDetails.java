package com.travel.flight.pojo.flightticket;

import com.travel.flight.pojo.PaymentDetail;
import com.travel.flight.pojo.flightticket.insurance.CJRInsuranceModel;
import com.travel.flight.pojo.flightticket.paxinfo.CJRDynamicPassenger;
import com.travel.flight.pojo.model.CJRTravellerSeatTransition;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightDetails implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private List<FlightSellingBundleResponseData> bundleList = new ArrayList();
    private CJRFlightReviewGst gst;
    private List<String> importantInfoNotes = new ArrayList();
    private CJRFlightMBImportant importantNotes;
    private CJRInsuranceModel insuranceData;
    private boolean isInsuranceApplied = false;
    private boolean isInsuranceCancelProtectApplied = false;
    private boolean isPaytmStiched;
    private JourneyDetails journeyDetails = null;
    private CJRConvenienceFee mConvenienceFee;
    private String mDestination;
    private CJRFlightPrice mFareDetails;
    private Boolean mIsInternational = Boolean.FALSE;
    private CJRMetadetails mMetaDetails;
    private CJRFlightDetailsItem mOnwardJourney;
    private boolean mOnwardMealsAvailable = true;
    private String mOnwardServiceProvider;
    private CJRFlightMBPassengerDetails mPassengerInfo;
    private String mPromoCode;
    private CJRRepriceFlightFare mRepriceFareDetails;
    private CJRFlightDetailsItem mReturnJourney;
    private boolean mReturnMealsAvailable = true;
    private String mReturnServiceProvider;
    private String mReviewInfoBoxHtml;
    private String mReviewInfoBoxHtmlBottom;
    private String mSource;
    private CJRStatus mStatus;
    private String mTravelerDetailsInfoBoxHtml;
    private String mUmraVisaMessage;
    private boolean mbIsApplied;
    private CJRMeta meta;
    private List<String> notes = new ArrayList();
    private List<PaymentDetail> paymentDetails;
    private String paymentIntent;
    CJRFlightPromoResponse promoResponse;
    private CJRFlightSearchInput searchInput;
    private CJRFJRFlightSessionInfo sessionInfo;

    public CJRFlightMBImportant getImportantNotes() {
        return this.importantNotes;
    }

    public void setImportantNotes(CJRFlightMBImportant cJRFlightMBImportant) {
        this.importantNotes = cJRFlightMBImportant;
    }

    public List<PaymentDetail> getPaymentDetails() {
        return this.paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetail> list) {
        this.paymentDetails = list;
    }

    public CJRFlightMBPassengerDetails getmPassengerInfo() {
        return this.mPassengerInfo;
    }

    public void setmPassengerInfo(CJRFlightMBPassengerDetails cJRFlightMBPassengerDetails) {
        this.mPassengerInfo = cJRFlightMBPassengerDetails;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public String getDestination() {
        return this.mDestination;
    }

    public void setDestination(String str) {
        this.mDestination = str;
    }

    public String getmUmraVisaMessage() {
        return this.mUmraVisaMessage;
    }

    public void setmUmraVisaMessage(String str) {
        this.mUmraVisaMessage = str;
    }

    public CJRConvenienceFee getmConvenienceFee() {
        return this.mConvenienceFee;
    }

    public void setmConvenienceFee(CJRConvenienceFee cJRConvenienceFee) {
        this.mConvenienceFee = cJRConvenienceFee;
    }

    public CJRFlightDetailsItem getmOnwardJourney() {
        return this.mOnwardJourney;
    }

    public void setmOnwardJourney(CJRFlightDetailsItem cJRFlightDetailsItem) {
        this.mOnwardJourney = cJRFlightDetailsItem;
    }

    public CJRFlightDetailsItem getmReturnJourney() {
        return this.mReturnJourney;
    }

    public void setmReturnJourney(CJRFlightDetailsItem cJRFlightDetailsItem) {
        this.mReturnJourney = cJRFlightDetailsItem;
    }

    public boolean isMbIsApplied() {
        return this.mbIsApplied;
    }

    public void setMbIsApplied(boolean z) {
        this.mbIsApplied = z;
    }

    public String getmPromoCode() {
        return this.mPromoCode;
    }

    public void setmPromoCode(String str) {
        this.mPromoCode = str;
    }

    public CJRMetadetails getmMetaDetails() {
        return this.mMetaDetails;
    }

    public void setmMetaDetails(CJRMetadetails cJRMetadetails) {
        this.mMetaDetails = cJRMetadetails;
    }

    public String getmOnwardServiceProvider() {
        return this.mOnwardServiceProvider;
    }

    public void setmOnwardServiceProvider(String str) {
        this.mOnwardServiceProvider = str;
    }

    public String getmReturnServiceProvider() {
        return this.mReturnServiceProvider;
    }

    public void setmReturnServiceProvider(String str) {
        this.mReturnServiceProvider = str;
    }

    public CJRRepriceFlightFare getmRepriceFareDetails() {
        return this.mRepriceFareDetails;
    }

    public void setmRepriceFareDetails(CJRRepriceFlightFare cJRRepriceFlightFare) {
        this.mRepriceFareDetails = cJRRepriceFlightFare;
    }

    public CJRFlightPrice getmFareDetails() {
        return this.mFareDetails;
    }

    public void setmFareDetails(CJRFlightPrice cJRFlightPrice) {
        this.mFareDetails = cJRFlightPrice;
    }

    public CJRStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(CJRStatus cJRStatus) {
        this.mStatus = cJRStatus;
    }

    public Boolean getmIsInternational() {
        return this.mIsInternational;
    }

    public void setmIsInternational(Boolean bool) {
        this.mIsInternational = bool;
    }

    public List<String> getNotes() {
        return this.notes;
    }

    public void setNotes(List<String> list) {
        this.notes = list;
    }

    public CJRMeta getMeta() {
        return this.meta;
    }

    public void setMeta(CJRMeta cJRMeta) {
        this.meta = cJRMeta;
    }

    public List<String> getImportantInfoNotes() {
        return this.importantInfoNotes;
    }

    public void setImportantNotes(List<String> list) {
        this.importantInfoNotes = list;
    }

    public CJRInsuranceModel getInsuranceData() {
        return this.insuranceData;
    }

    public void setInsuranceData(CJRInsuranceModel cJRInsuranceModel) {
        this.insuranceData = cJRInsuranceModel;
    }

    public boolean isInsuranceApplied() {
        return this.isInsuranceApplied;
    }

    public void setInsuranceApplied(boolean z) {
        this.isInsuranceApplied = z;
    }

    public CJRFlightPromoResponse getPromoResponse() {
        return this.promoResponse;
    }

    public void setPromoResponse(CJRFlightPromoResponse cJRFlightPromoResponse) {
        this.promoResponse = cJRFlightPromoResponse;
    }

    public CJRFlightReviewGst getGst() {
        return this.gst;
    }

    public void setGst(CJRFlightReviewGst cJRFlightReviewGst) {
        this.gst = cJRFlightReviewGst;
    }

    public boolean isInsuranceCancelProtectApplied() {
        return this.isInsuranceCancelProtectApplied;
    }

    public void setInsuranceCancelProtectApplied(boolean z) {
        this.isInsuranceCancelProtectApplied = z;
    }

    public void setOnwardMealsAvailable(boolean z) {
        this.mOnwardMealsAvailable = z;
    }

    public boolean getOnwardMealsAvailable() {
        return this.mOnwardMealsAvailable;
    }

    public void setReturnMealsAvailable(boolean z) {
        this.mReturnMealsAvailable = z;
    }

    public boolean getReturnMealsAvailable() {
        return this.mReturnMealsAvailable;
    }

    public boolean isPaytmStiched() {
        return this.isPaytmStiched;
    }

    public void setPaytmStiched(boolean z) {
        this.isPaytmStiched = z;
    }

    public List<FlightSellingBundleResponseData> getBundleList() {
        return this.bundleList;
    }

    public void setBundleList(List<FlightSellingBundleResponseData> list) {
        this.bundleList = list;
    }

    public synchronized JourneyDetails getJourneyDetails() {
        if (this.journeyDetails == null) {
            JourneyDetails journeyDetails2 = new JourneyDetails();
            this.journeyDetails = journeyDetails2;
            return journeyDetails2;
        }
        return this.journeyDetails;
    }

    public CJRFlightSearchInput getSearchInput() {
        return this.searchInput;
    }

    public void setSearchInput(CJRFlightSearchInput cJRFlightSearchInput) {
        this.searchInput = cJRFlightSearchInput;
    }

    public String getPaymentIntent() {
        return this.paymentIntent;
    }

    public void setPaymentIntent(String str) {
        this.paymentIntent = str;
    }

    public String getmReviewInfoBoxHtml() {
        return this.mReviewInfoBoxHtml;
    }

    public void setmReviewInfoBoxHtml(String str) {
        this.mReviewInfoBoxHtml = str;
    }

    public String getmReviewInfoBoxHtmlBottom() {
        return this.mReviewInfoBoxHtmlBottom;
    }

    public void setmReviewInfoBoxHtmlBottom(String str) {
        this.mReviewInfoBoxHtmlBottom = str;
    }

    public String getmTravelerDetailsInfoBoxHtml() {
        return this.mTravelerDetailsInfoBoxHtml;
    }

    public void setmTravelerDetailsInfoBoxHtml(String str) {
        this.mTravelerDetailsInfoBoxHtml = str;
    }

    public CJRFJRFlightSessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public void setSessionInfo(CJRFJRFlightSessionInfo cJRFJRFlightSessionInfo) {
        this.sessionInfo = cJRFJRFlightSessionInfo;
    }

    public class JourneyDetails implements IJRDataModel {
        private String emailId;
        private CJRDynamicPassenger gstObject;
        private boolean isGstSelected;
        private boolean islastnameValidationRequiered;
        private String mPaymentIntent;
        private CJRTravellerSeatTransition mTravellerSeatTransitionObj;
        private ArrayList<CJRTravellerDetails> mTravellersList;
        private String mobileNumber;
        private String requestId;
        private double totalfare;
        private CJRTravellerSeatTransition travellerSeatTransitionObj;
        private String tripType;

        public JourneyDetails() {
        }

        public String getRequestId() {
            return this.requestId;
        }

        public void setRequestId(String str) {
            this.requestId = str;
        }

        public ArrayList<CJRTravellerDetails> getTravellersList() {
            return this.mTravellersList;
        }

        public void setmTravellersList(ArrayList<CJRTravellerDetails> arrayList) {
            this.mTravellersList = arrayList;
        }

        public String getEmailId() {
            return this.emailId;
        }

        public void setEmailId(String str) {
            this.emailId = str;
        }

        public String getMobileNumber() {
            return this.mobileNumber;
        }

        public void setMobileNumber(String str) {
            this.mobileNumber = str;
        }

        public CJRDynamicPassenger getGstObject() {
            return this.gstObject;
        }

        public void setGstObject(CJRDynamicPassenger cJRDynamicPassenger) {
            this.gstObject = cJRDynamicPassenger;
        }

        public CJRTravellerSeatTransition getTravellerSeatTransitionObj() {
            return this.travellerSeatTransitionObj;
        }

        public void setTravellerSeatTransitionObj(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
            this.travellerSeatTransitionObj = cJRTravellerSeatTransition;
        }

        public boolean isGstSelected() {
            return this.isGstSelected;
        }

        public void setGstSelected(boolean z) {
            this.isGstSelected = z;
        }

        public double getTotalfare() {
            return this.totalfare;
        }

        public void setTotalfare(double d2) {
            this.totalfare = d2;
        }

        public String getTripType() {
            return this.tripType;
        }

        public void setTripType(String str) {
            this.tripType = str;
        }

        public boolean isIslastnameValidationRequiered() {
            return this.islastnameValidationRequiered;
        }

        public void setIslastnameValidationRequiered(boolean z) {
            this.islastnameValidationRequiered = z;
        }

        public String getmPaymentIntent() {
            return this.mPaymentIntent;
        }

        public void setmPaymentIntent(String str) {
            this.mPaymentIntent = str;
        }

        public CJRTravellerSeatTransition getmTravellerSeatTransitionObj() {
            return this.mTravellerSeatTransitionObj;
        }

        public void setmTravellerSeatTransitionObj(CJRTravellerSeatTransition cJRTravellerSeatTransition) {
            this.mTravellerSeatTransitionObj = cJRTravellerSeatTransition;
        }
    }
}
