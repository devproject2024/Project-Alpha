package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.travel.flight.pojo.GSTDetailsReviewPage;
import com.travel.flight.pojo.PaymentDetail;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBImportant;
import com.travel.flight.pojo.modifyBooking.CJRFlightMBPassengerDetails;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROnwardReturnFlightInformation implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "additional_info")
    private CJRFlightsAdditionalInfo additionalInfo;
    @b(a = "discounted")
    private Object discountObject;
    @b(a = "gst")
    private CJRFlightReviewGst gst;
    @b(a = "gst_details")
    private GSTDetailsReviewPage gstDetails;
    @b(a = "important_notes")
    public CJRFlightMBImportant importantNotes;
    @b(a = "isShareEnable")
    private boolean isShareEnable;
    @b(a = "journey_type")
    private String journey_type;
    @b(a = "meta")
    private CJRMeta mCJRMeta;
    @b(a = "discounted_strip")
    private ArrayList<CJRDiscountedStrip> mDiscountedStrip;
    @b(a = "mapping")
    private List<CJRIntlFlightMapping> mMapping;
    @b(a = "onwardflights")
    private CJROnwardFlights mOnwardFlights;
    @b(a = "passenger_info")
    private CJRFlightMBPassengerDetails mPassengerInfo;
    @b(a = "fare")
    private CJRRepriceFlightFare mRepriceFare;
    @b(a = "fare_per_adult")
    private CJRRepriceFlightFare mRepriceFareForOneAdult;
    @b(a = "onward_flight")
    private CJROnwardFlights mRepriceOnwardFlight;
    @b(a = "return_flight")
    private CJROnwardFlights mRepriceReturnFlight;
    @b(a = "returnflights")
    private CJROnwardFlights mReturnFlights;
    @b(a = "review_info_box_html")
    private String mReviewInfoBoxHtml;
    @b(a = "share_details")
    private CJRFlightShareDetails mShareDetails;
    @b(a = "mapping_meta")
    private CJRMappingMeta mappingMeta;
    @b(a = "payment_details")
    public List<PaymentDetail> paymentDetails;
    @b(a = "review_info_box_html_bottom")
    private String review_info_box_html_bottom;
    @b(a = "session_info")
    private CJRFJRFlightSessionInfo sessionInfo;
    @b(a = "traveller_details_info_box_html")
    private String traveller_details_info_box_html;

    public ArrayList<CJRDiscountedStrip> getDiscountedStrip() {
        return this.mDiscountedStrip;
    }

    public void setDiscountedStrip(ArrayList<CJRDiscountedStrip> arrayList) {
        this.mDiscountedStrip = arrayList;
    }

    public CJRFlightsAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(CJRFlightsAdditionalInfo cJRFlightsAdditionalInfo) {
        this.additionalInfo = cJRFlightsAdditionalInfo;
    }

    public CJROnwardFlights getmOnwardFlights() {
        return this.mOnwardFlights;
    }

    public void setmOnwardFlights(CJROnwardFlights cJROnwardFlights) {
        this.mOnwardFlights = cJROnwardFlights;
    }

    public CJROnwardFlights getmReturnFlights() {
        return this.mReturnFlights;
    }

    public void setmReturnFlights(CJROnwardFlights cJROnwardFlights) {
        this.mReturnFlights = cJROnwardFlights;
    }

    public CJROnwardFlights getmRepriceOnwardFlight() {
        return this.mRepriceOnwardFlight;
    }

    public void setmRepriceOnwardFlight(CJROnwardFlights cJROnwardFlights) {
        this.mRepriceOnwardFlight = cJROnwardFlights;
    }

    public CJROnwardFlights getmRepriceReturnFlight() {
        return this.mRepriceReturnFlight;
    }

    public void setmRepriceReturnFlight(CJROnwardFlights cJROnwardFlights) {
        this.mRepriceReturnFlight = cJROnwardFlights;
    }

    public CJRRepriceFlightFare getmRepriceFare() {
        return this.mRepriceFare;
    }

    public void setmRepriceFare(CJRRepriceFlightFare cJRRepriceFlightFare) {
        this.mRepriceFare = cJRRepriceFlightFare;
    }

    public CJRRepriceFlightFare getmRepriceFareForOneAdult() {
        return this.mRepriceFareForOneAdult;
    }

    public void setmRepriceFareForOneAdult(CJRRepriceFlightFare cJRRepriceFlightFare) {
        this.mRepriceFareForOneAdult = cJRRepriceFlightFare;
    }

    public List<CJRIntlFlightMapping> getmMapping() {
        return this.mMapping;
    }

    public void setmMapping(List<CJRIntlFlightMapping> list) {
        this.mMapping = list;
    }

    public String getJourney_type() {
        return this.journey_type;
    }

    public void setJourney_type(String str) {
        this.journey_type = str;
    }

    public Object getDiscountObject() {
        return this.discountObject;
    }

    public void setDiscountObject(Object obj) {
        this.discountObject = obj;
    }

    public CJRMeta getmCJRMeta() {
        return this.mCJRMeta;
    }

    public void setmCJRMeta(CJRMeta cJRMeta) {
        this.mCJRMeta = cJRMeta;
    }

    public CJRFlightReviewGst getGst() {
        return this.gst;
    }

    public CJRFlightShareDetails getmShareDetails() {
        return this.mShareDetails;
    }

    public CJRFJRFlightSessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public void setSessionInfo(CJRFJRFlightSessionInfo cJRFJRFlightSessionInfo) {
        this.sessionInfo = cJRFJRFlightSessionInfo;
    }

    public CJRMappingMeta getMappingMeta() {
        return this.mappingMeta;
    }

    public boolean isShareEnable() {
        return this.isShareEnable;
    }

    public void setMappingMeta(CJRMappingMeta cJRMappingMeta) {
        this.mappingMeta = cJRMappingMeta;
    }

    public CJRFlightMBPassengerDetails getmPassengerInfo() {
        return this.mPassengerInfo;
    }

    public GSTDetailsReviewPage getGstDetails() {
        return this.gstDetails;
    }

    public String getmReviewInfoBoxHtml() {
        return this.mReviewInfoBoxHtml;
    }

    public void setmReviewInfoBoxHtml(String str) {
        this.mReviewInfoBoxHtml = str;
    }

    public String getReview_info_box_html_bottom() {
        return this.review_info_box_html_bottom;
    }

    public void setReview_info_box_html_bottom(String str) {
        this.review_info_box_html_bottom = str;
    }

    public String getTraveller_details_info_box_html() {
        return this.traveller_details_info_box_html;
    }

    public void setTraveller_details_info_box_html(String str) {
        this.traveller_details_info_box_html = str;
    }
}
