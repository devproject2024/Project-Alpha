package com.travel.flight.pojo.flightticket;

import com.travel.flight.flightticket.d.b;
import com.travel.flight.pojo.CJRBusHolidayList;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightSearchInput implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    private b bookingSegment;
    private String destIataCode;
    private boolean isNearByAirportSelected = false;
    private boolean isNonStopSelected = false;
    private boolean isRoundTrip = false;
    private String journeyDetailType = "";
    private String journeyType = "";
    private int mAutoSuggestDestinationPos;
    private String mAutoSuggestDestinationSearchKey;
    private int mAutoSuggestOriginPos;
    private String mAutoSuggestOriginSearchKey;
    private String mClassType = null;
    private int mCount_adults = 0;
    private int mCount_childerns = 0;
    private int mCount_infants = 0;
    private String mDate = null;
    private String mDeeplinkFilterAirlineCodes;
    private String mDestCityCode = null;
    private b mDestination = null;
    private CJRBusHolidayList mFlightHolidayList;
    private boolean mIsCombinedDiscountFlight;
    private String mOpenFrom;
    private int mOrderBy = -1;
    private String mOrderByFlight = null;
    private String mReferral;
    private String mReturnDate = null;
    private String mReturnOrderByFlight = null;
    private String mReturnSortByFlight = null;
    private String mSelcetedOnwardPriceId;
    private String mSelcetedReturnPriceId;
    private ArrayList<String> mSelectedAirline;
    private String mServiceProviserSelectedOnTop = null;
    private String mSortBy = null;
    private String mSortByFlight = null;
    private b mSource = null;
    private String mSourceCityCode = null;
    private String modifyBookingOrderId;
    private String modifyBookingRequestId;
    private String modifyEndDateRange;
    private String modifyStartDateRange;
    private String onwardFlightId;
    private String returnFlightId;
    private String sourceIataCode;
    private String srpLoaderBanner;

    public CJRFlightSearchInput(CJRFlightSearchInput cJRFlightSearchInput) {
        if (cJRFlightSearchInput != null) {
            this.mSource = cJRFlightSearchInput.getSource();
            this.mDestination = cJRFlightSearchInput.getDestination();
            this.mDate = cJRFlightSearchInput.getDate();
            this.mReturnDate = cJRFlightSearchInput.getReturnDate();
            this.mCount_adults = cJRFlightSearchInput.getmCount_adults();
            this.mCount_childerns = cJRFlightSearchInput.getmCount_childerns();
            this.mCount_infants = cJRFlightSearchInput.getmCount_infants();
            this.mSortBy = cJRFlightSearchInput.getSortBy();
            this.mOrderBy = cJRFlightSearchInput.getOrderBy();
            this.mClassType = cJRFlightSearchInput.getClassType();
            this.mDestCityCode = cJRFlightSearchInput.getDestCityCode();
            this.mSourceCityCode = cJRFlightSearchInput.getSourceCityCode();
            this.mServiceProviserSelectedOnTop = cJRFlightSearchInput.getmServiceProviserSelectedOnTop();
            this.mAutoSuggestOriginPos = cJRFlightSearchInput.getmAutoSuggestOriginPos();
            this.mAutoSuggestOriginSearchKey = cJRFlightSearchInput.getmAutoSuggestOriginSearchKey();
            this.mAutoSuggestDestinationPos = cJRFlightSearchInput.getmAutoSuggestDestinationPos();
            this.mAutoSuggestDestinationSearchKey = cJRFlightSearchInput.getmAutoSuggestDestinationSearchKey();
            this.mOpenFrom = cJRFlightSearchInput.getmOpenFrom();
            this.mReferral = cJRFlightSearchInput.getmReferral();
            this.isNonStopSelected = cJRFlightSearchInput.getNonStopSelected();
            this.mFlightHolidayList = cJRFlightSearchInput.getmFlightHolidayList();
            this.srpLoaderBanner = cJRFlightSearchInput.getSrpLoaderBanner();
            this.destIataCode = cJRFlightSearchInput.getDestIataCode();
            this.sourceIataCode = cJRFlightSearchInput.getSourceIataCode();
            this.returnFlightId = cJRFlightSearchInput.getReturnFlightId();
            this.onwardFlightId = cJRFlightSearchInput.getReturnFlightId();
            this.mSelcetedOnwardPriceId = cJRFlightSearchInput.getmSelcetedOnwardPriceId();
            this.mSelcetedReturnPriceId = cJRFlightSearchInput.getmSelcetedReturnPriceId();
            this.mIsCombinedDiscountFlight = cJRFlightSearchInput.ismIsCombinedDiscountFlight();
            this.isRoundTrip = cJRFlightSearchInput.isRoundTrip();
            this.bookingSegment = cJRFlightSearchInput.bookingSegment;
            this.modifyBookingRequestId = cJRFlightSearchInput.modifyBookingRequestId;
            this.modifyBookingOrderId = cJRFlightSearchInput.modifyBookingOrderId;
        }
    }

    public boolean isRoundTrip() {
        return this.isRoundTrip;
    }

    public void setRoundTrip(boolean z) {
        this.isRoundTrip = z;
    }

    public boolean isNearByAirportSelected() {
        return this.isNearByAirportSelected;
    }

    public void setNearByAirportSelected(boolean z) {
        this.isNearByAirportSelected = z;
    }

    public boolean getNonStopSelected() {
        return this.isNonStopSelected;
    }

    public void setNonStopSelected(boolean z) {
        this.isNonStopSelected = z;
    }

    public String getSourceIataCode() {
        return this.sourceIataCode;
    }

    public void setSourceIataCode(String str) {
        this.sourceIataCode = str;
    }

    public String getDestIataCode() {
        return this.destIataCode;
    }

    public void setDestIataCode(String str) {
        this.destIataCode = str;
    }

    public String getOnwardFlightId() {
        return this.onwardFlightId;
    }

    public void setOnwardFlightId(String str) {
        this.onwardFlightId = str;
    }

    public String getReturnFlightId() {
        return this.returnFlightId;
    }

    public void setReturnFlightId(String str) {
        this.returnFlightId = str;
    }

    public String getmServiceProviserSelectedOnTop() {
        return this.mServiceProviserSelectedOnTop;
    }

    public void setmServiceProviserSelectedOnTop(String str) {
        this.mServiceProviserSelectedOnTop = str;
    }

    public String getSourceCityCode() {
        return this.mSourceCityCode;
    }

    public void setSourceCityCode(String str) {
        this.mSourceCityCode = str;
    }

    public String getDestCityCode() {
        return this.mDestCityCode;
    }

    public void setDestCityCode(String str) {
        this.mDestCityCode = str;
    }

    public String getClassType() {
        return this.mClassType;
    }

    public void setClassType(String str) {
        this.mClassType = str;
    }

    public String getReturnDate() {
        return this.mReturnDate;
    }

    public void setReturnDate(String str) {
        this.mReturnDate = str;
    }

    public void setmSelectedAirLine(ArrayList<String> arrayList) {
        this.mSelectedAirline = arrayList;
    }

    public ArrayList<String> getSelectedAirline() {
        return this.mSelectedAirline;
    }

    public String getOrderByFlight() {
        return this.mOrderByFlight;
    }

    public void setOrderByFlight(String str) {
        this.mOrderByFlight = str;
    }

    public String getSortByFlight() {
        return this.mSortByFlight;
    }

    public void setSortByFlight(String str) {
        this.mSortByFlight = str;
    }

    public String getReturnOrderByFlight() {
        return this.mReturnOrderByFlight;
    }

    public void setReturnOrderByFlight(String str) {
        this.mReturnOrderByFlight = str;
    }

    public String getReturnSortByFlight() {
        return this.mReturnSortByFlight;
    }

    public void setReturnSortByFlight(String str) {
        this.mReturnSortByFlight = str;
    }

    public CJRFlightSearchInput() {
    }

    public b getSource() {
        return this.mSource;
    }

    public b getDestination() {
        return this.mDestination;
    }

    public String getDate() {
        return this.mDate;
    }

    public String getSortBy() {
        return this.mSortBy;
    }

    public int getOrderBy() {
        return this.mOrderBy;
    }

    public void setSource(b bVar) {
        this.mSource = bVar;
    }

    public void setDestination(b bVar) {
        this.mDestination = bVar;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public void setSortBy(String str) {
        this.mSortBy = str;
    }

    public void setOrderBy(int i2) {
        this.mOrderBy = i2;
    }

    public int getmCount_adults() {
        return this.mCount_adults;
    }

    public void setmCount_adults(int i2) {
        this.mCount_adults = i2;
    }

    public int getmCount_childerns() {
        return this.mCount_childerns;
    }

    public void setmCount_childerns(int i2) {
        this.mCount_childerns = i2;
    }

    public int getmCount_infants() {
        return this.mCount_infants;
    }

    public void setmCount_infants(int i2) {
        this.mCount_infants = i2;
    }

    public CJRFlightSearchInput clone() throws CloneNotSupportedException {
        return (CJRFlightSearchInput) super.clone();
    }

    public String getmAutoSuggestOriginSearchKey() {
        return this.mAutoSuggestOriginSearchKey;
    }

    public void setmAutoSuggestOriginSearchKey(String str) {
        this.mAutoSuggestOriginSearchKey = str;
    }

    public String getmAutoSuggestDestinationSearchKey() {
        return this.mAutoSuggestDestinationSearchKey;
    }

    public void setmAutoSuggestDestinationSearchKey(String str) {
        this.mAutoSuggestDestinationSearchKey = str;
    }

    public int getmAutoSuggestOriginPos() {
        return this.mAutoSuggestOriginPos;
    }

    public void setmAutoSuggestOriginPos(int i2) {
        this.mAutoSuggestOriginPos = i2;
    }

    public int getmAutoSuggestDestinationPos() {
        return this.mAutoSuggestDestinationPos;
    }

    public void setmAutoSuggestDestinationPos(int i2) {
        this.mAutoSuggestDestinationPos = i2;
    }

    public String getmSelcetedOnwardPriceId() {
        return this.mSelcetedOnwardPriceId;
    }

    public void setmSelcetedOnwardPriceId(String str) {
        this.mSelcetedOnwardPriceId = str;
    }

    public String getmSelcetedReturnPriceId() {
        return this.mSelcetedReturnPriceId;
    }

    public void setmSelcetedReturnPriceId(String str) {
        this.mSelcetedReturnPriceId = str;
    }

    public boolean ismIsCombinedDiscountFlight() {
        return this.mIsCombinedDiscountFlight;
    }

    public void setmIsCombinedDiscountFlight(boolean z) {
        this.mIsCombinedDiscountFlight = z;
    }

    public String getmReferral() {
        return this.mReferral;
    }

    public void setmReferral(String str) {
        this.mReferral = str;
    }

    public String getmOpenFrom() {
        return this.mOpenFrom;
    }

    public void setmOpenFrom(String str) {
        this.mOpenFrom = str;
    }

    public String getSrpLoaderBanner() {
        return this.srpLoaderBanner;
    }

    public void setSrpLoaderBanner(String str) {
        this.srpLoaderBanner = str;
    }

    public void setmFlightHolidayList(CJRBusHolidayList cJRBusHolidayList) {
        this.mFlightHolidayList = cJRBusHolidayList;
    }

    public CJRBusHolidayList getmFlightHolidayList() {
        return this.mFlightHolidayList;
    }

    public String getmDeeplinkFilterAirlineCodes() {
        return this.mDeeplinkFilterAirlineCodes;
    }

    public void setmDeeplinkFilterAirlineCodes(String str) {
        this.mDeeplinkFilterAirlineCodes = str;
    }

    public String getJourneyDetailType() {
        return this.journeyDetailType;
    }

    public void setJourneyDetailType(String str) {
        this.journeyDetailType = str;
    }

    public String getJourneyType() {
        return this.journeyType;
    }

    public void setJourneyType(String str) {
        this.journeyType = str;
    }

    public b getBookingSegment() {
        return this.bookingSegment;
    }

    public void setBookingSegment(b bVar) {
        this.bookingSegment = bVar;
    }

    public String getModifyBookingRequestId() {
        return this.modifyBookingRequestId;
    }

    public void setModifyBookingRequestId(String str) {
        this.modifyBookingRequestId = str;
    }

    public String getModifyBookingOrderId() {
        return this.modifyBookingOrderId;
    }

    public void setModifyBookingOrderId(String str) {
        this.modifyBookingOrderId = str;
    }

    public String getModifyStartDateRange() {
        return this.modifyStartDateRange;
    }

    public void setModifyStartDateRange(String str) {
        this.modifyStartDateRange = str;
    }

    public String getModifyEndDateRange() {
        return this.modifyEndDateRange;
    }

    public void setModifyEndDateRange(String str) {
        this.modifyEndDateRange = str;
    }
}
