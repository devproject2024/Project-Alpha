package com.travel.flight.pojo.flightticket;

import androidx.databinding.i;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.travel.flight.flightSRPV2.a.d;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightDetailsItem implements Cloneable, IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "additional_info")
    private CJRFlightsAdditionalInfo additionalInfo;
    @a(a = false, b = false)
    private transient List<CJRFlightDetailsItem> childItems;
    @b(a = "eligible_ancillary")
    private List<String> eligibleAncillary;
    @a(a = false, b = false)
    private transient List<d> filterAirlinePriceList;
    @a(a = false, b = false)
    private transient List<d> filterPrevSelectedAirlinePriceList;
    @a(a = false, b = false)
    private transient i filterPrevSelectedMaxValue;
    @a(a = false, b = false)
    private transient i filterPrevSelectedMinValue;
    @a(a = false, b = false)
    private transient i filterSelectedMaxValue;
    @a(a = false, b = false)
    private transient i filterSelectedMinValue;
    @a(a = false, b = false)
    private transient String formattedFirstHopInfo;
    @a(a = false, b = false)
    private transient String formattedSecondHopInfo;
    @a(a = false, b = false)
    private transient String headerText;
    private String headerType;
    @b(a = "is_ancillary_eligible")
    private boolean isAncillaryEligible;
    @a(a = false, b = false)
    private transient i<Boolean> isExpanded;
    @a(a = false, b = false)
    private transient Boolean isFilterListStrip;
    @a(a = false, b = false)
    private transient i<Boolean> isFilterRangeChanged;
    @b(a = "is_ff_numeric")
    private boolean isNumerickeypad;
    @b(a = "is_provider_stitch")
    private boolean isProviderStitch;
    @b(a = "is_seat_eligible")
    private boolean isSeatAncillaryEligible;
    private boolean isSelected;
    @b(a = "is_flight_stitch")
    private boolean isStitched;
    @a(a = false, b = false)
    private transient boolean isStitchedAndMoreThanOneHop = false;
    private boolean isUnSelectable;
    @b(a = "airline")
    private String mAirLine;
    @b(a = "airlineCode")
    private String mAirLineCode;
    @b(a = "arrivalTimeLocal")
    private String mArrivalTime;
    @b(a = "bookingClass")
    private String mBookingClass;
    @a(a = false, b = false)
    private transient int mCheapestFlightValue = 0;
    @b(a = "departureTimeLocal")
    private String mDepartureTime;
    @b(a = "destination")
    private String mDestination;
    @b(a = "duration")
    private String mDuration;
    @b(a = "flightid")
    private String mFlightId;
    @b(a = "hops")
    private ArrayList<CJRFlightStops> mFlights;
    @b(a = "hop_display_name")
    private String mHopDisplayName;
    @b(a = "insurance")
    private String mInsurance;
    @b(a = "isFreeMealAvailable")
    private boolean mIsFreeMealAvailable = true;
    @b(a = "is_parent")
    private boolean mIsParent = true;
    @b(a = "refundable")
    private boolean mIsRefundable;
    private CJRFilterAndBannerInfoItem mListItemData;
    private String mListItemType = "flight_list_type";
    @b(a = "mealsAvailable")
    private boolean mMealsAvailable = true;
    @b(a = "origin")
    private String mOrigin;
    @b(a = "otherinfo")
    private List<String> mOtherinfo;
    @b(a = "parent_id")
    private String mParentId;
    @b(a = "price")
    private ArrayList<CJRFlightPrice> mPrice;
    @b(a = "refundable_text")
    private String mRefundable;
    @b(a = "seats_available")
    private String mSeatAvailable;
    private CJRFlightPrice mServiceProviderSelected;
    @a(a = false, b = false)
    private transient int posState;
    @a(a = false, b = false)
    private transient Boolean showIsFarePerAdult;
    private String timezone;
    @a(a = false, b = false)
    private transient int viewType;

    public boolean isNumerickeypad() {
        return this.isNumerickeypad;
    }

    public void setNumerickeypad(boolean z) {
        this.isNumerickeypad = z;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public Boolean getShowIsFarePerAdult() {
        return this.showIsFarePerAdult;
    }

    public void setShowIsFarePerAdult(Boolean bool) {
        this.showIsFarePerAdult = bool;
    }

    public String getHeaderText() {
        return this.headerText;
    }

    public void setHeaderText(String str) {
        this.headerText = str;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int i2) {
        this.viewType = i2;
    }

    public i<Boolean> getIsExpanded() {
        return this.isExpanded;
    }

    public void setIsExpanded(i<Boolean> iVar) {
        this.isExpanded = iVar;
    }

    public void setmListItemData(CJRFilterAndBannerInfoItem cJRFilterAndBannerInfoItem) {
        this.mListItemData = cJRFilterAndBannerInfoItem;
    }

    public CJRFilterAndBannerInfoItem getmListItemData() {
        return this.mListItemData;
    }

    public void setmListItemType(String str) {
        this.mListItemType = str;
    }

    public String getmListItemType() {
        return this.mListItemType;
    }

    public void setmCheapestFlightValue(int i2) {
        this.mCheapestFlightValue = i2;
    }

    public int getmCheapestFlightValue() {
        return this.mCheapestFlightValue;
    }

    public void setmIsFreeMealAvailable(boolean z) {
        this.mIsFreeMealAvailable = z;
    }

    public boolean getIsFreeMealAvailable() {
        return this.mIsFreeMealAvailable;
    }

    public void setHopDisplayName(String str) {
        this.mHopDisplayName = str;
    }

    public String getHopDisplayName() {
        return this.mHopDisplayName;
    }

    public void setmSeatAvailable(String str) {
        this.mSeatAvailable = str;
    }

    public String getmSeatAvailable() {
        return this.mSeatAvailable;
    }

    public CJRFlightsAdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(CJRFlightsAdditionalInfo cJRFlightsAdditionalInfo) {
        this.additionalInfo = cJRFlightsAdditionalInfo;
    }

    public String getmOrigin() {
        return this.mOrigin;
    }

    public void setmOrigin(String str) {
        this.mOrigin = str;
    }

    public String getmDestination() {
        return this.mDestination;
    }

    public void setmDestination(String str) {
        this.mDestination = str;
    }

    public String getmDepartureTime() {
        return this.mDepartureTime;
    }

    public void setmDepartureTime(String str) {
        this.mDepartureTime = str;
    }

    public boolean ismIsRefundable() {
        return this.mIsRefundable;
    }

    public void setmIsRefundable(boolean z) {
        this.mIsRefundable = z;
    }

    public String getmArrivalTime() {
        return this.mArrivalTime;
    }

    public void setmArrivalTime(String str) {
        this.mArrivalTime = str;
    }

    public String getmBookingClass() {
        return this.mBookingClass;
    }

    public void setmBookingClass(String str) {
        this.mBookingClass = str;
    }

    public String getmAirLineCode() {
        return this.mAirLineCode;
    }

    public void setmAirLineCode(String str) {
        this.mAirLineCode = str;
    }

    public String getmAirLine() {
        return this.mAirLine;
    }

    public void setmAirLine(String str) {
        this.mAirLine = str;
    }

    public String getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(String str) {
        this.mDuration = str;
    }

    public String getmFlightId() {
        return this.mFlightId;
    }

    public void setmFlightId(String str) {
        this.mFlightId = str;
    }

    public ArrayList<CJRFlightStops> getmFlights() {
        return this.mFlights;
    }

    public void setmFlights(ArrayList<CJRFlightStops> arrayList) {
        this.mFlights = arrayList;
    }

    public ArrayList<CJRFlightPrice> getmPrice() {
        return this.mPrice;
    }

    public void setmPrice(ArrayList<CJRFlightPrice> arrayList) {
        this.mPrice = arrayList;
    }

    public CJRFlightPrice getmServiceProviderSelected() {
        return this.mServiceProviderSelected;
    }

    public void setmServiceProviderSelected(CJRFlightPrice cJRFlightPrice) {
        this.mServiceProviderSelected = cJRFlightPrice;
    }

    public CJRFlightDetailsItem clone() throws CloneNotSupportedException {
        return (CJRFlightDetailsItem) super.clone();
    }

    public String getmOtherinfo() {
        String str = "";
        if (this.mOtherinfo != null) {
            for (int i2 = 0; i2 < this.mOtherinfo.size(); i2++) {
                str = str + this.mOtherinfo.get(i2) + ". ";
            }
        }
        return str;
    }

    public void setmOtherinfo(List<String> list) {
        this.mOtherinfo = list;
    }

    public String getmInsurance() {
        return this.mInsurance;
    }

    public void setmInsurance(String str) {
        this.mInsurance = str;
    }

    public boolean isAncillaryEligible() {
        return this.isAncillaryEligible;
    }

    public void setAncillaryEligible(boolean z) {
        this.isAncillaryEligible = z;
    }

    public List<String> getEligibleAncillary() {
        return this.eligibleAncillary;
    }

    public void setEligibleAncillary(List<String> list) {
        this.eligibleAncillary = list;
    }

    public void setMealsAvailable(boolean z) {
        this.mMealsAvailable = z;
    }

    public boolean getMealsAvaialable() {
        return this.mMealsAvailable;
    }

    public void setRefundbaleName(String str) {
        this.mRefundable = str;
    }

    public String getRefundbaleName() {
        return this.mRefundable;
    }

    public String getHeaderType() {
        return this.headerType;
    }

    public void setHeaderType(String str) {
        this.headerType = str;
    }

    public boolean isSeatAncillaryEligible() {
        return this.isSeatAncillaryEligible;
    }

    public void setSeatAncillaryEligible(boolean z) {
        this.isSeatAncillaryEligible = z;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj != null) {
            CJRFlightDetailsItem cJRFlightDetailsItem = (CJRFlightDetailsItem) obj;
            if (!(cJRFlightDetailsItem.getmFlightId() == null || (str = this.mFlightId) == null)) {
                return str.equals(cJRFlightDetailsItem.getmFlightId());
            }
        }
        return super.equals(obj);
    }

    public boolean isUnSelectable() {
        return this.isUnSelectable;
    }

    public void setUnSelectable(boolean z) {
        this.isUnSelectable = z;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public boolean isStitched() {
        return this.isStitched;
    }

    public String getFormattedSecondHopInfo() {
        return this.formattedSecondHopInfo;
    }

    public void setFormattedSecondHopInfo(String str) {
        this.formattedSecondHopInfo = str;
    }

    public boolean isProviderStitch() {
        return this.isProviderStitch;
    }

    public void setProviderStitch(boolean z) {
        this.isProviderStitch = z;
    }

    public boolean ismIsParent() {
        return this.mIsParent;
    }

    public void setmIsParent(boolean z) {
        this.mIsParent = z;
    }

    public String getmParentId() {
        return this.mParentId;
    }

    public void setmParentId(String str) {
        this.mParentId = str;
    }

    public List<CJRFlightDetailsItem> getChildItems() {
        return this.childItems;
    }

    public void setChildItems(List<CJRFlightDetailsItem> list) {
        this.childItems = list;
    }

    public boolean isStitchedAndMoreThanOneHop() {
        return this.isStitchedAndMoreThanOneHop;
    }

    public void setStitchedAndMoreThanOneHop(boolean z) {
        this.isStitchedAndMoreThanOneHop = z;
    }

    public int getPosState() {
        return this.posState;
    }

    public void setPosState(int i2) {
        this.posState = i2;
    }

    public i getFilterSelectedMinValue() {
        return this.filterSelectedMinValue;
    }

    public void setFilterSelectedMinValue(i iVar) {
        this.filterSelectedMinValue = iVar;
    }

    public i getFilterSelectedMaxValue() {
        return this.filterSelectedMaxValue;
    }

    public void setFilterSelectedMaxValue(i iVar) {
        this.filterSelectedMaxValue = iVar;
    }

    public i<Boolean> getIsFilterRangeChanged() {
        return this.isFilterRangeChanged;
    }

    public void setIsFilterRangeChanged(i<Boolean> iVar) {
        this.isFilterRangeChanged = iVar;
    }

    public List<d> getFilterAirlinePriceList() {
        return this.filterAirlinePriceList;
    }

    public void setFilterAirlinePriceList(List<d> list) {
        this.filterAirlinePriceList = list;
    }

    public i getFilterPrevSelectedMinValue() {
        return this.filterPrevSelectedMinValue;
    }

    public void setFilterPrevSelectedMinValue(i iVar) {
        this.filterPrevSelectedMinValue = iVar;
    }

    public i getFilterPrevSelectedMaxValue() {
        return this.filterPrevSelectedMaxValue;
    }

    public void setFilterPrevSelectedMaxValue(i iVar) {
        this.filterPrevSelectedMaxValue = iVar;
    }

    public List<d> getFilterPrevSelectedAirlinePriceList() {
        return this.filterPrevSelectedAirlinePriceList;
    }

    public void setFilterPrevSelectedAirlinePriceList(List<d> list) {
        this.filterPrevSelectedAirlinePriceList = list;
    }

    public Boolean getFilterStripItem() {
        return this.isFilterListStrip;
    }

    public void setFilterStripItem(Boolean bool) {
        this.isFilterListStrip = bool;
    }

    public String getFormattedFirstHopInfo() {
        return this.formattedFirstHopInfo;
    }

    public void setFormattedFirstHopInfo(String str) {
        this.formattedFirstHopInfo = str;
    }
}
