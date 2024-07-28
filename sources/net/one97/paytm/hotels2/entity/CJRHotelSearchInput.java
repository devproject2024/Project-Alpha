package net.one97.paytm.hotels2.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.g;
import net.one97.paytm.hotel4.service.model.datamodel.search.Locations;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;

public class CJRHotelSearchInput extends IJRPaytmDataModel {
    private int adultCount;
    @b(a = "mCheckInDate")
    private String checkInDate;
    @b(a = "mCheckOutDate")
    private String checkOutDate;
    private int childCount;
    @b(a = "mCity")
    private String city;
    @b(a = "mFieldsEnteredDate")
    private String fieldsEnteredDate;
    @b(a = "filterFromDeepLink")
    private String filterFromDeepLink;
    @b(a = "filter_params")
    private String filterParams;
    @b(a = "mHotelId")
    private String hotelId;
    private boolean isFromDeeplink;
    @b(a = "is_locality_search")
    private boolean isLocalitySearch;
    @b(a = "isNearBySearch")
    private boolean isNearBySearch;
    private Locations locationDetails = new Locations((String) null, (String) null, (String) null, 7, (g) null);
    private int maxStayNoightCount;
    @b(a = "mName")
    private String name;
    @b(a = "numOfNights")
    private int numOfNights;
    @b(a = "placeDetail")
    private String placeDetail;
    private String poi = "";
    @b(a = "mRooms")
    private ArrayList<CJRRoom> rooms;
    private SortKeysItem sortBy;
    @b(a = "mType")
    private String type;
    @b(a = "userLocation")
    private HashMap<String, Object> userLocation;

    public final String getCheckInDate() {
        return this.checkInDate;
    }

    public final void setCheckInDate(String str) {
        this.checkInDate = str;
    }

    public final String getCheckOutDate() {
        return this.checkOutDate;
    }

    public final void setCheckOutDate(String str) {
        this.checkOutDate = str;
    }

    public final ArrayList<CJRRoom> getRooms() {
        return this.rooms;
    }

    public final void setRooms(ArrayList<CJRRoom> arrayList) {
        this.rooms = arrayList;
    }

    public final String getFieldsEnteredDate() {
        return this.fieldsEnteredDate;
    }

    public final void setFieldsEnteredDate(String str) {
        this.fieldsEnteredDate = str;
    }

    public final String getPlaceDetail() {
        return this.placeDetail;
    }

    public final void setPlaceDetail(String str) {
        this.placeDetail = str;
    }

    public final int getNumOfNights() {
        return this.numOfNights;
    }

    public final void setNumOfNights(int i2) {
        this.numOfNights = i2;
    }

    public final String getFilterFromDeepLink() {
        return this.filterFromDeepLink;
    }

    public final void setFilterFromDeepLink(String str) {
        this.filterFromDeepLink = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getHotelId() {
        return this.hotelId;
    }

    public final void setHotelId(String str) {
        this.hotelId = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final boolean isNearBySearch() {
        return this.isNearBySearch;
    }

    public final void setNearBySearch(boolean z) {
        this.isNearBySearch = z;
    }

    public final HashMap<String, Object> getUserLocation() {
        return this.userLocation;
    }

    public final void setUserLocation(HashMap<String, Object> hashMap) {
        this.userLocation = hashMap;
    }

    public final boolean isLocalitySearch() {
        return this.isLocalitySearch;
    }

    public final void setLocalitySearch(boolean z) {
        this.isLocalitySearch = z;
    }

    public final String getFilterParams() {
        return this.filterParams;
    }

    public final void setFilterParams(String str) {
        this.filterParams = str;
    }

    public final int getAdultCount() {
        return this.adultCount;
    }

    public final void setAdultCount(int i2) {
        this.adultCount = i2;
    }

    public final int getChildCount() {
        return this.childCount;
    }

    public final void setChildCount(int i2) {
        this.childCount = i2;
    }

    public final SortKeysItem getSortBy() {
        return this.sortBy;
    }

    public final void setSortBy(SortKeysItem sortKeysItem) {
        this.sortBy = sortKeysItem;
    }

    public final int getMaxStayNoightCount() {
        return this.maxStayNoightCount;
    }

    public final void setMaxStayNoightCount(int i2) {
        this.maxStayNoightCount = i2;
    }

    public final Locations getLocationDetails() {
        return this.locationDetails;
    }

    public final void setLocationDetails(Locations locations) {
        this.locationDetails = locations;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final void setPoi(String str) {
        this.poi = str;
    }

    public final boolean isFromDeeplink() {
        return this.isFromDeeplink;
    }

    public final void setFromDeeplink(boolean z) {
        this.isFromDeeplink = z;
    }

    public final void markIsFromDeeplink() {
        this.isFromDeeplink = true;
    }

    public final void markDeeplinkProcessed() {
        this.isFromDeeplink = false;
    }

    public CJRHotelSearchInput() {
    }

    public CJRHotelSearchInput(CJRHotelSearchInput cJRHotelSearchInput) {
        if (cJRHotelSearchInput != null) {
            this.checkInDate = cJRHotelSearchInput.checkInDate;
            this.checkOutDate = cJRHotelSearchInput.checkOutDate;
            this.fieldsEnteredDate = cJRHotelSearchInput.fieldsEnteredDate;
            this.rooms = cJRHotelSearchInput.rooms;
            this.filterFromDeepLink = cJRHotelSearchInput.filterFromDeepLink;
            this.numOfNights = cJRHotelSearchInput.numOfNights;
            HashMap<String, Object> hashMap = cJRHotelSearchInput.userLocation;
            if (hashMap != null) {
                this.userLocation = hashMap;
            }
        }
    }
}
