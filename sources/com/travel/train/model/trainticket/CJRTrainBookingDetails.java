package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainBookingDetails extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "class")
    private String _class;
    @b(a = "arrival_date")
    private String arrivalDate;
    @b(a = "arrival_time")
    private String arrivalTime;
    @b(a = "background_image")
    private String backgroundImage;
    @b(a = "boarding_station_changed")
    private CJRBoardingStationChanged boardingStationChanged;
    @b(a = "boarding_station_code")
    private String boardingStationCode;
    @b(a = "boarding_station_name")
    private String boardingStationName;
    @b(a = "boarding_time")
    private String boardingTime;
    @b(a = "booking_actions")
    private ArrayList<CJRTrainOrderSummaryAction> bookingActions = null;
    @b(a = "departure_date")
    private String departureDate;
    @b(a = "departure_date_full")
    private String departureDateFull;
    @b(a = "destination_station_code")
    private String destinationStationCode;
    @b(a = "destination_station_name")
    private String destinationStationName;
    @b(a = "is_favourite")
    private CJRTrainIsFavourite isFavourite;
    @b(a = "no_of_stops")
    private String noOfStops;
    @b(a = "origin_departure_date")
    private String originDepartureDate;
    @b(a = "origin_departure_time")
    private String originDepartureTime;
    @b(a = "origin_station_code")
    private String originStationCode;
    @b(a = "origin_station_name")
    private String originStationName;
    @b(a = "pnr")
    private String pnr;
    @b(a = "quota")
    private String quota;
    @b(a = "source")
    private String source;
    @b(a = "source_departure_date")
    private String sourceDepartureDate;
    @b(a = "source_departure_time")
    private String sourceDepartureTime;
    @b(a = "source_station_name")
    private String sourceStationName;
    @b(a = "text_holder")
    private CJRTrainOrderTextHolder textHolder;
    @b(a = "train_name")
    private String trainName;
    @b(a = "train_number")
    private String trainNumber;
    @b(a = "train_type")
    private String trainType;
    @b(a = "travel_time")
    private String travelTime;
    @b(a = "trip_text")
    private String tripText;

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    public String getTripText() {
        return this.tripText;
    }

    public String getPnr() {
        return this.pnr;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public String getOriginStationCode() {
        return this.originStationCode;
    }

    public String getOriginStationName() {
        return this.originStationName;
    }

    public String getOriginDepartureDate() {
        return this.originDepartureDate;
    }

    public String getOriginDepartureTime() {
        return this.originDepartureTime;
    }

    public String getBoardingStationCode() {
        return this.boardingStationCode;
    }

    public String getBoardingStationName() {
        return this.boardingStationName;
    }

    public String getBoardingTime() {
        return this.boardingTime;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public String getSource() {
        return this.source;
    }

    public String getSourceStationName() {
        return this.sourceStationName;
    }

    public String getSourceDepartureDate() {
        return this.sourceDepartureDate;
    }

    public String getSourceDepartureTime() {
        return this.sourceDepartureTime;
    }

    public String getDestinationStationCode() {
        return this.destinationStationCode;
    }

    public String getDestinationStationName() {
        return this.destinationStationName;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public String getClass_() {
        return this._class;
    }

    public String getQuota() {
        return this.quota;
    }

    public String getTrainType() {
        return this.trainType;
    }

    public String getTravelTime() {
        return this.travelTime;
    }

    public String getNoOfStops() {
        return this.noOfStops;
    }

    public CJRTrainOrderTextHolder getTextHolder() {
        return this.textHolder;
    }

    public CJRTrainIsFavourite getIsFavourite() {
        return this.isFavourite;
    }

    public ArrayList<CJRTrainOrderSummaryAction> getBookingActions() {
        return this.bookingActions;
    }

    public CJRBoardingStationChanged getBoardingStationChanged() {
        return this.boardingStationChanged;
    }

    public String getDepartureDateFull() {
        return this.departureDateFull;
    }
}
