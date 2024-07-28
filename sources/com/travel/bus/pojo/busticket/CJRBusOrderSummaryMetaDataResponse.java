package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusOrderSummaryMetaDataResponse implements IJRDataModel {
    @b(a = "arrival_date")
    private String arrivalDate;
    @b(a = "arrival_time")
    private String arrivalTime;
    @b(a = "boarding_point_address")
    private String boardingPointAddress;
    @b(a = "boarding_point_name")
    private String boardingPointName;
    @b(a = "boarding_time")
    private String boardingTime;
    @b(a = "bus_type")
    private String busType;
    @b(a = "passenger_cat_card_number")
    private String cat_card_number;
    @b(a = "order_fare")
    public CJROrdeFare cjrOrderFare;
    @b(a = "destination")
    private String destination;
    @b(a = "onward_discount_text")
    public String discountText;
    @b(a = "dropping_point_address")
    private String droppingPointAddress;
    @b(a = "dropping_point_name")
    private String droppingPointName;
    @b(a = "duration")
    private String duration;
    @b(a = "is_insured")
    private String isInsured;
    @b(a = "is_round_trip")
    private String isRoundTrip;
    @b(a = "passenger_count")
    private String passengerCount;
    @b(a = "passengers")
    private ArrayList<CJRBusPassengerData> passengerData;
    @b(a = "passenger_gender")
    private String passengerGender;
    @b(a = "passenger_name")
    private String passengerName;
    @b(a = "paytm_trip_id")
    private String paytmTripID;
    @b(a = "operator_average_rating")
    private String rating;
    @b(a = "seat_number")
    private String seatNumber;
    @b(a = "source")
    private String source;
    @b(a = "travel_date")
    private String travelDate;
    @b(a = "travelName")
    private String travelName;

    public String getIsRoundTrip() {
        return this.isRoundTrip;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public CJROrdeFare getCjrOrderData() {
        return this.cjrOrderFare;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public String getBoardingPointAddress() {
        return this.boardingPointAddress;
    }

    public String getBoardingPointName() {
        return this.boardingPointName;
    }

    public String getBoardingTime() {
        return this.boardingTime;
    }

    public void setBoardingTime(String str) {
        this.boardingTime = str;
    }

    public String getDroppingPointAddress() {
        return this.droppingPointAddress;
    }

    public String getDroppingPointName() {
        return this.droppingPointName;
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

    public String getPassengerGender() {
        return this.passengerGender;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public String getPaytmTripID() {
        return this.paytmTripID;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public ArrayList<CJRBusPassengerData> getPassengerData() {
        return this.passengerData;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public String getPassengerCount() {
        return this.passengerCount;
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String str) {
        this.travelDate = str;
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

    public String getTravelName() {
        return this.travelName;
    }

    public String getCat_card_number() {
        return this.cat_card_number;
    }
}
