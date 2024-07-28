package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.travel.bus.pojo.CJRBusSearchOperatorInfo;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemFare;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemFeature;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag;
import com.travel.bus.pojo.bussearch.CJRDetailedFare;
import com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags;
import com.travel.bus.pojo.photos.CJRBusPhotoWrapper;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "amenities")
    private ArrayList<Integer> amenities = null;
    @b(a = "arrival_datetime")
    private String arrivalDatetime;
    private String arrivalTimeInTwelveHours;
    @b(a = "available_seats")
    private Integer availableSeats;
    private ArrayList<CJRLocation> boardingLocations = new ArrayList<>();
    @b(a = "boarding_points")
    private ArrayList<String> boardingPoints = null;
    @b(a = "bus_id")
    private String busId;
    @b(a = "bus_type_name")
    private String busTypeName;
    @b(a = "bus_type_tags")
    private ArrayList<String> busTypeTags = null;
    private ArrayList<CJRBusCancellationPolicy> cancellationPolicy;
    private boolean concessionEnabled;
    private CJRConcessionObj concessionString;
    @b(a = "departure_datetime")
    private String departureDatetime;
    private String departureTimeInTwelveHours;
    private String destinationCity = null;
    @b(a = "detailed_fare")
    private List<CJRDetailedFare> detailedFare;
    private ArrayList<CJRLocation> droppingLocations = new ArrayList<>();
    @b(a = "dropping_points")
    private ArrayList<String> droppingPoints = null;
    @b(a = "duration")
    private String duration;
    private String durationText;
    @b(a = "ecosystem_offers")
    private ArrayList<String> ecosystemOffers = null;
    @b(a = "fare")
    private CJRBusSearchItemFare fare;
    @b(a = "feature")
    private CJRBusSearchItemFeature feature;
    @b(a = "flag")
    private CJRBusSearchItemFlag flag;
    @b(a = "flags")
    private CJRbusSearchItemFlags flags;
    private String formattedMinfare;
    private String mItemType;
    @b(a = "operator_id")
    private Integer operatorId;
    private CJRBusSearchOperatorInfo operatorObj;
    @b(a = "operator_tags")
    private ArrayList<Integer> operatorTags = null;
    @b(a = "photos")
    private ArrayList<CJRBusPhotoWrapper> photos;
    @b(a = "provider_operator_name")
    private String providerOperatorName;
    @b(a = "provider_trip_id")
    private String providerTripId;
    @b(a = "ratings_source")
    private String ratingSource;
    @b(a = "ratings")
    private BusRatingModel ratings;
    @b(a = "route_time_id")
    private String routeTimeId;
    private String seatPostfix;
    private String sourceCity = null;
    @b(a = "total_seats")
    private Integer totalSeats;
    @b(a = "trip_id")
    private String tripId;

    public List<CJRDetailedFare> getDetailedFare() {
        List<CJRDetailedFare> list = this.detailedFare;
        return list == null ? new ArrayList(0) : list;
    }

    public void setDetailedFare(List<CJRDetailedFare> list) {
        this.detailedFare = list;
    }

    public void setSeatPostfix(String str) {
        this.seatPostfix = str;
    }

    public void setDepartureTimeInTwelveHours(String str) {
        this.departureTimeInTwelveHours = str;
    }

    public void setArrivalTimeInTwelveHours(String str) {
        this.arrivalTimeInTwelveHours = str;
    }

    public void setFormattedMinfare(String str) {
        this.formattedMinfare = str;
    }

    public void setDurationText(String str) {
        this.durationText = str;
    }

    public String getSourceCity() {
        return this.sourceCity;
    }

    public String getDestinationCity() {
        return this.destinationCity;
    }

    public boolean isConcessionEnabled() {
        return this.concessionEnabled;
    }

    public void setConcessionEnabled(boolean z) {
        this.concessionEnabled = z;
    }

    public CJRConcessionObj getConcessionString() {
        return this.concessionString;
    }

    public void setConcessionString(CJRConcessionObj cJRConcessionObj) {
        this.concessionString = cJRConcessionObj;
    }

    public ArrayList<CJRLocation> getBoardingLocations() {
        return this.boardingLocations;
    }

    public void setBoardingLocations(ArrayList<CJRLocation> arrayList) {
        this.boardingLocations = arrayList;
    }

    public ArrayList<CJRLocation> getDroppingLocations() {
        return this.droppingLocations;
    }

    public void setDroppingLocations(ArrayList<CJRLocation> arrayList) {
        this.droppingLocations = arrayList;
    }

    public String getSource() {
        return this.sourceCity;
    }

    public void setSource(String str) {
        this.sourceCity = str;
    }

    public String getDestination() {
        return this.destinationCity;
    }

    public void setDestination(String str) {
        this.destinationCity = str;
    }

    public CJRBusSearchOperatorInfo getOperatorObj() {
        return this.operatorObj;
    }

    public void setOperatorObj(CJRBusSearchOperatorInfo cJRBusSearchOperatorInfo) {
        this.operatorObj = cJRBusSearchOperatorInfo;
    }

    public String getmItemType() {
        return this.mItemType;
    }

    public String getTravelsName() {
        return getProviderOperatorName();
    }

    public String getOperatorGroupName() {
        return this.operatorObj.getName();
    }

    public String getComputedTravelsName() {
        return getProviderOperatorName();
    }

    public void setmItemType(String str) {
        this.mItemType = str;
    }

    public Integer getAvalableSeats() {
        return this.availableSeats;
    }

    public void setAvailableSeats(Integer num) {
        this.availableSeats = num;
    }

    public void setTotalSeats(Integer num) {
        this.totalSeats = num;
    }

    public String getBusTypeName() {
        return this.busTypeName;
    }

    public void setBusTypeName(String str) {
        this.busTypeName = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getTripId() {
        return this.providerTripId;
    }

    public String getBusId() {
        return this.busId;
    }

    public void setBusId(String str) {
        this.busId = str;
    }

    public String getTripId2() {
        return this.tripId;
    }

    public void setTripId(String str) {
        this.tripId = str;
    }

    public void setProviderTripId(String str) {
        this.providerTripId = str;
    }

    public Integer getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(Integer num) {
        this.operatorId = num;
    }

    public ArrayList<Integer> getOperatorTags() {
        return this.operatorTags;
    }

    public void setOperatorTags(ArrayList<Integer> arrayList) {
        this.operatorTags = arrayList;
    }

    public ArrayList<String> getBusTypeTags() {
        return this.busTypeTags;
    }

    public void setBusTypeTags(ArrayList<String> arrayList) {
        this.busTypeTags = arrayList;
    }

    public BusRatingModel getBusRating() {
        return this.ratings;
    }

    public void setRatings(BusRatingModel busRatingModel) {
        this.ratings = busRatingModel;
    }

    public CJRbusSearchItemFlags getFlags() {
        return this.flags;
    }

    public void setFlags(CJRbusSearchItemFlags cJRbusSearchItemFlags) {
        this.flags = cJRbusSearchItemFlags;
    }

    public CJRBusSearchItemFeature getFeature() {
        return this.feature;
    }

    public void setFeature(CJRBusSearchItemFeature cJRBusSearchItemFeature) {
        this.feature = cJRBusSearchItemFeature;
    }

    public CJRBusSearchItemFare getFare() {
        return this.fare;
    }

    public void setFare(CJRBusSearchItemFare cJRBusSearchItemFare) {
        this.fare = cJRBusSearchItemFare;
    }

    public ArrayList<Integer> getAmenities() {
        return this.amenities;
    }

    public void setAmenities(ArrayList<Integer> arrayList) {
        this.amenities = arrayList;
    }

    public ArrayList<String> getBoardingPoints() {
        return this.boardingPoints;
    }

    public void setBoardingPoints(ArrayList<String> arrayList) {
        this.boardingPoints = arrayList;
    }

    public ArrayList<String> getDroppingPoints() {
        return this.droppingPoints;
    }

    public void setDroppingPoints(ArrayList<String> arrayList) {
        this.droppingPoints = arrayList;
    }

    public String getDepartureDatetime() {
        return this.departureDatetime;
    }

    public void setDepartureDatetime(String str) {
        this.departureDatetime = str;
    }

    public String getArrivalDatetime() {
        return this.arrivalDatetime;
    }

    public void setArrivalDatetime(String str) {
        this.arrivalDatetime = str;
    }

    public CJRBusSearchItemFlag getFlag() {
        return this.flag;
    }

    public void setFlag(CJRBusSearchItemFlag cJRBusSearchItemFlag) {
        this.flag = cJRBusSearchItemFlag;
    }

    public ArrayList<CJRBusCancellationPolicy> getCancellationPolicy() {
        return this.cancellationPolicy;
    }

    public void setCancellationPolicy(ArrayList<CJRBusCancellationPolicy> arrayList) {
        this.cancellationPolicy = arrayList;
    }

    public String getProviderOperatorName() {
        return this.operatorObj.getName();
    }

    public void setProviderOperatorName(String str) {
        this.providerOperatorName = str;
    }

    public ArrayList<String> getEcosystemOffers() {
        return this.ecosystemOffers;
    }

    public void setEcosystemOffers(ArrayList<String> arrayList) {
        this.ecosystemOffers = arrayList;
    }

    public String getRatingSource() {
        return this.ratingSource;
    }

    public void setRatingSource(String str) {
        this.ratingSource = str;
    }

    public String getRouteTimeId() {
        return this.routeTimeId;
    }

    public void setRouteTimeId(String str) {
        this.routeTimeId = str;
    }

    public ArrayList<CJRBusPhotoWrapper> getPhotos() {
        return this.photos;
    }

    public void setPhotos(ArrayList<CJRBusPhotoWrapper> arrayList) {
        this.photos = arrayList;
    }
}
