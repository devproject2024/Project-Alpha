package net.one97.paytm.common.entity.busticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusOrderSummaryMetaDataResponse implements IJRDataModel {
    @b(a = "arrival_date")
    private String arrivalDate;
    @b(a = "arrival_time")
    private String arrivalTime;
    @b(a = "boarding_date")
    private String boardingDate;
    @b(a = "boarding_point_address")
    private String boardingPointAddress;
    @b(a = "boarding_point_id")
    private String boardingPointID;
    @b(a = "boarding_point_name")
    private String boardingPointName;
    @b(a = "boarding_time")
    private String boardingTime;
    @b(a = "bus_type")
    private String busType;
    @b(a = "passenger_cat_card_number")
    private String cat_card_number;
    @b(a = "contact_email")
    private String contactEmail;
    @b(a = "contact_phone")
    private String contactPhone;
    @b(a = "dest_display_name")
    private String destDisplayName;
    @b(a = "destination")
    private String destination;
    @b(a = "dropping_point_address")
    private String droppingPointAddress;
    @b(a = "dropping_point_id")
    private String droppingPointID;
    @b(a = "dropping_point_name")
    private String droppingPointName;
    @b(a = "duration")
    private String duration;
    @b(a = "is_ac")
    private String isAc;
    @b(a = "is_insured")
    private String isInsured;
    @b(a = "is_round_trip")
    private String isRoundTrip;
    @b(a = "passenger_age")
    private String passengerAge;
    @b(a = "passenger_count")
    private String passengerCount;
    @b(a = "passenger_gender")
    private String passengerGender;
    @b(a = "passenger_name")
    private String passengerName;
    @b(a = "paytm_trip_id")
    private String paytmTripID;
    @b(a = "product_id")
    private String productId;
    @b(a = "providerAddress")
    private String providerAddress;
    @b(a = "providerContact")
    private String providerContact;
    @b(a = "providerEmail")
    private String providerEmail;
    @b(a = "providerName")
    private String providerName;
    @b(a = "provider_trip_id")
    private String providerTripID;
    @b(a = "operator_average_rating")
    private String rating;
    @b(a = "seat_number")
    private String seatNumber;
    @b(a = "source")
    private String source;
    @b(a = "src_display_name")
    private String srcDisplayName;
    @b(a = "staging_environment")
    private String stagingEnvironment;
    @b(a = "total_order_fare")
    private String totalOrderFare;
    @b(a = "travel_date")
    private String travelDate;
    @b(a = "travelName")
    private String travelName;
    @b(a = "travel_time")
    private String travelTime;

    public String getIsRoundTrip() {
        return this.isRoundTrip;
    }

    public void setIsRoundTrip(String str) {
        this.isRoundTrip = str;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public String getBoardingDate() {
        return this.boardingDate;
    }

    public void setBoardingDate(String str) {
        this.boardingDate = str;
    }

    public String getBoardingPointAddress() {
        return this.boardingPointAddress;
    }

    public void setBoardingPointAddress(String str) {
        this.boardingPointAddress = str;
    }

    public String getBoardingPointID() {
        return this.boardingPointID;
    }

    public void setBoardingPointID(String str) {
        this.boardingPointID = str;
    }

    public String getBoardingPointName() {
        return this.boardingPointName;
    }

    public void setBoardingPointName(String str) {
        this.boardingPointName = str;
    }

    public String getBoardingTime() {
        return this.boardingTime;
    }

    public void setBoardingTime(String str) {
        this.boardingTime = str;
    }

    public String getDroppingPointID() {
        return this.droppingPointID;
    }

    public void setDroppingPointID(String str) {
        this.droppingPointID = str;
    }

    public String getDroppingPointAddress() {
        return this.droppingPointAddress;
    }

    public void setDroppingPointAddress(String str) {
        this.droppingPointAddress = str;
    }

    public String getDroppingPointName() {
        return this.droppingPointName;
    }

    public void setDroppingPointName(String str) {
        this.droppingPointName = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getBusType() {
        return this.busType;
    }

    public void setBusType(String str) {
        this.busType = str;
    }

    public String getIsInsured() {
        return this.isInsured;
    }

    public void setIsInsured(String str) {
        this.isInsured = str;
    }

    public String getPassengerAge() {
        return this.passengerAge;
    }

    public void setPassengerAge(String str) {
        this.passengerAge = str;
    }

    public String getPassengerGender() {
        return this.passengerGender;
    }

    public void setPassengerGender(String str) {
        this.passengerGender = str;
    }

    public String getProviderTripID() {
        return this.providerTripID;
    }

    public void setProviderTripID(String str) {
        this.providerTripID = str;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public void setPassengerName(String str) {
        this.passengerName = str;
    }

    public String getPaytmTripID() {
        return this.paytmTripID;
    }

    public void setPaytmTripID(String str) {
        this.paytmTripID = str;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(String str) {
        this.seatNumber = str;
    }

    public String getStagingEnvironment() {
        return this.stagingEnvironment;
    }

    public void setStagingEnvironment(String str) {
        this.stagingEnvironment = str;
    }

    public String getTotalOrderFare() {
        return this.totalOrderFare;
    }

    public void setTotalOrderFare(String str) {
        this.totalOrderFare = str;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(String str) {
        this.arrivalDate = str;
    }

    public String getPassengerCount() {
        return this.passengerCount;
    }

    public void setPassengerCount(String str) {
        this.passengerCount = str;
    }

    public String getSrcDisplayName() {
        return this.srcDisplayName;
    }

    public void setSrcDisplayName(String str) {
        this.srcDisplayName = str;
    }

    public String getDestDisplayName() {
        return this.destDisplayName;
    }

    public void setDestDisplayName(String str) {
        this.destDisplayName = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String str) {
        this.contactEmail = str;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String str) {
        this.contactPhone = str;
    }

    public String getIsAc() {
        return this.isAc;
    }

    public void setIsAc(String str) {
        this.isAc = str;
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String str) {
        this.travelDate = str;
    }

    public String getTravelTime() {
        return this.travelTime;
    }

    public void setTravelTime(String str) {
        this.travelTime = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public String getProviderAddress() {
        return this.providerAddress;
    }

    public void setProviderAddress(String str) {
        this.providerAddress = str;
    }

    public String getProviderEmail() {
        return this.providerEmail;
    }

    public void setProviderEmail(String str) {
        this.providerEmail = str;
    }

    public String getProviderContact() {
        return this.providerContact;
    }

    public void setProviderContact(String str) {
        this.providerContact = str;
    }

    public String getTravelName() {
        return this.travelName;
    }

    public void setTravelName(String str) {
        this.travelName = str;
    }

    public String getCat_card_number() {
        return this.cat_card_number;
    }

    public void setCat_card_number(String str) {
        this.cat_card_number = str;
    }
}
