package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainMessagingConfig extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "ac_classes_text")
    private String acClassesText;
    @b(a = "ac_filters")
    private boolean acFilters;
    @b(a = "ac_non_ac_text")
    private String acNonAcText;
    @b(a = "adult_traveller_message")
    private String adultTravellerMessage;
    @b(a = "alternative_dates")
    private String alternativeDates;
    @b(a = "availability_alert")
    private String availabilityAlertText;
    @b(a = "bedrollText")
    private String bedrollText;
    @b(a = "bedroll_title")
    private String bedrollTitle;
    @b(a = "berth_allotment_message")
    private String berthAllotmentMessage;
    @b(a = "new_berth_disclaimer")
    private String berthDisclaimer;
    @b(a = "new_berth_message")
    private String berthMsg;
    @b(a = "berth_preference_message")
    private String berthPreferenceMessage;
    @b(a = "berthPreferenceText")
    private String berthPreferenceText;
    @b(a = "berth_required_title")
    private String berthRequiredTitle;
    @b(a = "new_berth_title")
    private String berthTitle;
    @b(a = "cancel_download_pnr_status")
    private String cancelDownloadPnrStatus;
    @b(a = "cancellation_policy_native")
    private boolean cancellationPolicyNative;
    @b(a = "cashback_message")
    private String cashbackMessage;
    @b(a = "coach_number_message")
    private String coachNumberMessage;
    @b(a = "contact_info_text")
    private String contactInfoText;
    @b(a = "create_new_account")
    private boolean createNewAccount;
    @b(a = "date_change_alert")
    private String dateChangeAlertText;
    @b(a = "different_date_chosen")
    private String differentDateChosen;
    @b(a = "download_cancel_mytrips")
    private String downloadCancelMytrips;
    @b(a = "filter_title")
    private String filterTitle;
    @b(a = "forgot_irctc_password")
    private boolean forgotIrctcPassword;
    @b(a = "forgot_password")
    private String forgotPassword;
    @b(a = "forgot_user_ID")
    private boolean forgotUserID;
    @b(a = "forgot_user_id")
    private String forgotUserId;
    @b(a = "future_availability")
    private String futureAvailability;
    @b(a = "hidden_ac")
    private String hiddenAc;
    @b(a = "hidden_non_ac")
    private String hiddenNonAc;
    @b(a = "infant_message")
    private String infantMessage;
    @b(a = "irctcLoginInfoTxt")
    private String irctcLoginInfoTxt;
    @b(a = "booking_instructions_repeat_users")
    private boolean isBookingInstructionEnable;
    @b(a = "nearby_stations")
    private boolean isNearByStationEnable = false;
    @b(a = "enable_old_fare_det")
    private boolean isOldFareBreakupEnabled = true;
    @b(a = "transgender_enabled")
    private boolean isTransgenderEnabled = false;
    @b(a = "my_trips_tab")
    private String myTripsTab;
    @b(a = "navigation_strip")
    private ArrayList<CJRTrainStripHomeModel> navigationStrip;
    @b(a = "no_account")
    private String noAccount;
    @b(a = "no_offers")
    private String noOffers;
    @b(a = "non_ac_classes_text")
    private String nonAcClassesText;
    @b(a = "only_ac_trains")
    private String onlyAcTrains;
    @b(a = "only_non_ac_trains")
    private String onlyNonAcTrains;
    @b(a = "android_new_order_summary")
    private boolean orderSummaryV2Enable;
    @b(a = "pnr_text")
    private String pnrText;
    @b(a = "promo_code_visible")
    private boolean promoCodeVisible;
    @b(a = "recent_searches_tab")
    private String recentSearchesTab;
    @b(a = "remember_password")
    private String rememberPassword;
    @b(a = "reset_irctc_password_flow")
    private String resetIRCTCPasswordFlow;
    @b(a = "reset_password_label")
    private String resetIRCTCPasswordLabel;
    @b(a = "reset_irctc_password_url")
    private String resetIRCTCPasswordUrl;
    @b(a = "search_by_train_feature")
    private boolean searchByTrainFeature = true;
    @b(a = "senior_citizen_discount_message_female")
    private String seniorCitizenDiscountMessageFemale;
    @b(a = "senior_citizen_discount_message_male")
    private String seniorCitizenDiscountMessageMale;
    @b(a = "senior_citizen_discount_title")
    private String seniorCitizenDiscountTitle;
    @b(a = "senior_citizen_no_discount_message")
    private String seniorCitizenNoDiscountMessage;
    @b(a = "show_different_station_alert")
    private boolean showDifferentStationAlert;
    @b(a = "show_dynamic_pricing_alert")
    private boolean showDynamicPricingAlert;
    @b(a = "smart_icons")
    private ArrayList<CJRTrainSmartIcons> smartIconList;
    @b(a = "sort_title")
    private String sortTitle;
    @b(a = "test_id")
    private Object testId;
    @b(a = "trainBookingPendingState")
    private String trainBookingPendingState;
    @b(a = "trainTravellerDetailsDialogInfoText")
    private String trainTravellerDetailsDialogInfoText;
    @b(a = "new_traveller_berth")
    private String travellerBerthMsg;
    @b(a = "traveller_profile_feature")
    private boolean travellerProfileFeature;
    @b(a = "user_details")
    private String userDetails;
    @b(a = "verify_payment_train")
    private String verifyPaymentTrainMessage;
    @b(a = "viewing_ac")
    private String viewingAc;
    @b(a = "viewing_non_ac")
    private String viewingNonAc;
    @b(a = "zero_trains_filter")
    private String zeroTrainsFilter;

    public String getDateChangeAlertText() {
        return this.dateChangeAlertText;
    }

    public String getAvailabilityAlertText() {
        return this.availabilityAlertText;
    }

    public String getAcNonAcText() {
        return this.acNonAcText;
    }

    public String getOnlyAcTrains() {
        return this.onlyAcTrains;
    }

    public String getAcClassesText() {
        return this.acClassesText;
    }

    public String getOnlyNonAcTrains() {
        return this.onlyNonAcTrains;
    }

    public String getNonAcClassesText() {
        return this.nonAcClassesText;
    }

    public String getPnrText() {
        return this.pnrText;
    }

    public String getDownloadCancelMytrips() {
        return this.downloadCancelMytrips;
    }

    public String getRecentSearchesTab() {
        return this.recentSearchesTab;
    }

    public String getMyTripsTab() {
        return this.myTripsTab;
    }

    public boolean getAcFilters() {
        return this.acFilters;
    }

    public String getCancelDownloadPnrStatus() {
        return this.cancelDownloadPnrStatus;
    }

    public String getAlternativeDates() {
        return this.alternativeDates;
    }

    public String getHiddenAc() {
        return this.hiddenAc;
    }

    public String getHiddenNonAc() {
        return this.hiddenNonAc;
    }

    public String getViewingNonAc() {
        return this.viewingNonAc;
    }

    public String getViewingAc() {
        return this.viewingAc;
    }

    public String getZeroTrainsFilter() {
        return this.zeroTrainsFilter;
    }

    public String getDifferentDateChosen() {
        return this.differentDateChosen;
    }

    public String getFutureAvailability() {
        return this.futureAvailability;
    }

    public String getSortTitle() {
        return this.sortTitle;
    }

    public String getFilterTitle() {
        return this.filterTitle;
    }

    public String getIrctcLoginInfoTxt() {
        return this.irctcLoginInfoTxt;
    }

    public String getNoAccount() {
        return this.noAccount;
    }

    public String getUserDetails() {
        return this.userDetails;
    }

    public String getForgotUserId() {
        return this.forgotUserId;
    }

    public String getForgotPassword() {
        return this.forgotPassword;
    }

    public String getContactInfoText() {
        return this.contactInfoText;
    }

    public String getBedrollTitle() {
        return this.bedrollTitle;
    }

    public String getBedrollText() {
        return this.bedrollText;
    }

    public String getSeniorCitizenDiscountTitle() {
        return this.seniorCitizenDiscountTitle;
    }

    public String getSeniorCitizenDiscountMessageMale() {
        return this.seniorCitizenDiscountMessageMale;
    }

    public String getSeniorCitizenDiscountMessageFemale() {
        return this.seniorCitizenDiscountMessageFemale;
    }

    public String getBerthPreferenceMessage() {
        return this.berthPreferenceMessage;
    }

    public String getBerthRequiredTitle() {
        return this.berthRequiredTitle;
    }

    public String getBerthPreferenceText() {
        return this.berthPreferenceText;
    }

    public String getInfantMessage() {
        return this.infantMessage;
    }

    public String getCoachNumberMessage() {
        return this.coachNumberMessage;
    }

    public boolean getCancellationPolicyNative() {
        return this.cancellationPolicyNative;
    }

    public boolean getTravellerProfileFeature() {
        return this.travellerProfileFeature;
    }

    public String getTrainTravellerDetailsDialogInfoText() {
        return this.trainTravellerDetailsDialogInfoText;
    }

    public String getTrainBookingPendingState() {
        return this.trainBookingPendingState;
    }

    public String getRememberPassword() {
        return this.rememberPassword;
    }

    public String getBerthAllotmentMessage() {
        return this.berthAllotmentMessage;
    }

    public boolean getPromoCodeVisible() {
        return this.promoCodeVisible;
    }

    public String getNoOffers() {
        return this.noOffers;
    }

    public String getCashbackMessage() {
        return this.cashbackMessage;
    }

    public Object getTestId() {
        return this.testId;
    }

    public String getAdultTravellerMessage() {
        return this.adultTravellerMessage;
    }

    public String getVerifyPaymentTrainMessage() {
        return this.verifyPaymentTrainMessage;
    }

    public boolean getForgotUserID() {
        return this.forgotUserID;
    }

    public boolean getForgotIrctcPassword() {
        return this.forgotIrctcPassword;
    }

    public boolean getCreateNewAccount() {
        return this.createNewAccount;
    }

    public boolean isNearByStationEnable() {
        return this.isNearByStationEnable;
    }

    public String getResetIRCTCPasswordFlow() {
        return this.resetIRCTCPasswordFlow;
    }

    public boolean isTransgenderEnabled() {
        return this.isTransgenderEnabled;
    }

    public String getSeniorCitizenNoDiscountMessage() {
        return this.seniorCitizenNoDiscountMessage;
    }

    public String getResetIRCTCPasswordUrl() {
        return this.resetIRCTCPasswordUrl;
    }

    public boolean isOldFareBreakupEnabled() {
        return this.isOldFareBreakupEnabled;
    }

    public String getResetIRCTCPasswordLabel() {
        return this.resetIRCTCPasswordLabel;
    }

    public boolean isOrderSummaryV2Enable() {
        return this.orderSummaryV2Enable;
    }

    public ArrayList<CJRTrainStripHomeModel> getNavigationStrip() {
        return this.navigationStrip;
    }

    public String getTravellerBerthMsg() {
        return this.travellerBerthMsg;
    }

    public String getBerthTitle() {
        return this.berthTitle;
    }

    public String getBerthMsg() {
        return this.berthMsg;
    }

    public String getBerthDisclaimer() {
        return this.berthDisclaimer;
    }

    public boolean isBookingInstructionEnable() {
        return this.isBookingInstructionEnable;
    }

    public boolean getShowDynamicPricingAlert() {
        return this.showDynamicPricingAlert;
    }

    public boolean getShowDifferentStationAlert() {
        return this.showDifferentStationAlert;
    }

    public ArrayList<CJRTrainSmartIcons> getSmartIconList() {
        return this.smartIconList;
    }

    public boolean isSearchByTrainFeature() {
        return this.searchByTrainFeature;
    }
}
