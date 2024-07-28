package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickBookBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "enable_fare_det_back_end")
    private boolean enableFareDetBackEnd;
    @b(a = "fare_details")
    private List<CJRTrainFareDetail> fareDetails;
    @b(a = "ff_button_text")
    private String ffButtonText;
    @b(a = "grand_total_key")
    private int grandTotalKey;
    @b(a = "gst_enabled")
    private boolean gst_enabled;
    @b(a = "add_ons")
    private List<CJRTrainAddOn> mAddOns;
    @b(a = "berths")
    public ArrayList<CJRTravellerBerth> mBerth;
    @b(a = "boarding_details")
    private ArrayList<CJRBoardingStationDetails> mBoardingDetail;
    @b(a = "boarding_stations")
    private ArrayList<String> mBoardingStations;
    @b(a = "cancellation_insurance")
    private CJRTrainCancellationInsurance mCancellationInsurance;
    @b(a = "departure_date")
    private String mDepartureDate;
    @b(a = "destination")
    private String mDestinationCode;
    @b(a = "destination_name")
    private String mDestinationName;
    @b(a = "error_message")
    private String mErrorMsg;
    @b(a = "error_title")
    private String mErrorTitle;
    @b(a = "fast_forward")
    private CJRFastForward mFastForward;
    @b(a = "infant_info")
    private ArrayList<CJRTrainInfantInfo> mInfantInfo;
    @b(a = "is_deeplink")
    private boolean mIsDeeplink;
    @b(a = "tip_enabled")
    private boolean mIsTipEnabled;
    @b(a = "message")
    private CJRTrainTravellerMessage mMessage;
    @b(a = "page_to_load")
    private Integer mPageToLoad;
    @b(a = "review_itinerary_message")
    private String mReviewItineraryMessage;
    @b(a = "source")
    private String mSourceCode;
    @b(a = "source_name")
    private String mSourceName;
    @b(a = "tip_text")
    private String mTipText;
    @b(a = "availability")
    private ArrayList<CJRTrainAvailability> mTrainAvailability;
    @b(a = "config")
    private CJRTrainConfig mTrainConfig;
    @b(a = "train_details")
    private CJRTrainDetailsBody mTrainDetailsBody;
    @b(a = "train_info")
    private CJRTrainSearchResultsTrain mTrainInfo;
    @b(a = "trainName")
    private String mTrainName;
    @b(a = "preferences")
    private CJRTrainPreferences mTrainPreferences;
    @b(a = "schedule")
    private CJRTrainQuickSchedule mTrainQuickSchedule;
    @b(a = "transaction_id")
    private String mTransactionId;
    @b(a = "user_options")
    private CJRTrainUserOptions mUserOptions;
    @b(a = "pax_info")
    private ArrayList<CJRTrainQuickBookPassengerInfo> paxInfo;

    public ArrayList<CJRTrainQuickBookPassengerInfo> getPaxInfo() {
        return this.paxInfo;
    }

    public ArrayList<CJRTrainInfantInfo> getmInfantInfo() {
        return this.mInfantInfo;
    }

    public CJRTrainSearchResultsTrain getmTrainInfo() {
        return this.mTrainInfo;
    }

    public CJRTrainQuickSchedule getmTrainQuickSchedule() {
        return this.mTrainQuickSchedule;
    }

    public ArrayList<String> getmBoardingStations() {
        return this.mBoardingStations;
    }

    public Integer getmPageToLoad() {
        return this.mPageToLoad;
    }

    public boolean ismIsDeeplink() {
        return this.mIsDeeplink;
    }

    public CJRTrainUserOptions getmUserOptions() {
        return this.mUserOptions;
    }

    public ArrayList<CJRTrainAvailability> getmTrainAvailability() {
        return this.mTrainAvailability;
    }

    public String getmTrainName() {
        return this.mTrainName;
    }

    public CJRTrainTravellerMessage getmMessage() {
        return this.mMessage;
    }

    public CJRTrainPreferences getmTrainPreferences() {
        return this.mTrainPreferences;
    }

    public CJRTrainConfig getmTrainConfig() {
        return this.mTrainConfig;
    }

    public ArrayList<CJRTravellerBerth> getmBerth() {
        return this.mBerth;
    }

    public ArrayList<CJRBoardingStationDetails> getmBoardingDetail() {
        return this.mBoardingDetail;
    }

    public boolean isGst_enabled() {
        return this.gst_enabled;
    }

    public String getmTransactionId() {
        return this.mTransactionId;
    }

    public boolean ismIsTipEnabled() {
        return this.mIsTipEnabled;
    }

    public String getmTipText() {
        return this.mTipText;
    }

    public CJRTrainCancellationInsurance getmCancellationInsurance() {
        return this.mCancellationInsurance;
    }

    public String getmReviewItineraryMessage() {
        return this.mReviewItineraryMessage;
    }

    public List<CJRTrainAddOn> getmAddOns() {
        return this.mAddOns;
    }

    public boolean getEnableFareDetBackEnd() {
        return this.enableFareDetBackEnd;
    }

    public String getFfButtonText() {
        return this.ffButtonText;
    }

    public int getGrandTotalKey() {
        return this.grandTotalKey;
    }

    public List<CJRTrainFareDetail> getFareDetails() {
        return this.fareDetails;
    }

    public CJRTrainDetailsBody getmTrainDetailsBody() {
        return this.mTrainDetailsBody;
    }

    public String getmErrorMsg() {
        return this.mErrorMsg;
    }

    public String getmSourceCode() {
        return this.mSourceCode;
    }

    public String getmDestinationCode() {
        return this.mDestinationCode;
    }

    public String getmDepartureDate() {
        return this.mDepartureDate;
    }

    public String getmErrorTitle() {
        return this.mErrorTitle;
    }

    public CJRFastForward getmFastForward() {
        return this.mFastForward;
    }

    public String getmSourceName() {
        return this.mSourceName;
    }

    public String getmDestinationName() {
        return this.mDestinationName;
    }
}
