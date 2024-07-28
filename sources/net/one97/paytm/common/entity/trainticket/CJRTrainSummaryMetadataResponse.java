package net.one97.paytm.common.entity.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainSummaryMetadataResponse implements IJRDataModel {
    @b(a = "arrival_date")
    private String arrivalDate;
    @b(a = "arrival_time")
    private String arrivalTime;
    @b(a = "boarding_station")
    private String boardingStation;
    @b(a = "boarding_station_name")
    private String boardingStationName;
    @b(a = "boarding_time")
    private String boardingTime;
    @b(a = "class")
    private String classVAlue;
    @b(a = "cp_breakup")
    private CJRTrainCancellationProtectFare cpBreakUp;
    @b(a = "departure_date")
    private String departureDate;
    @b(a = "source_departure_time")
    private String departureTime;
    @b(a = "destination")
    private String destination;
    @b(a = "destination_name")
    private String destinationStationName;
    @b(a = "fare")
    private CJRFareDetails fareDetails;
    @b(a = "source_departure_date")
    private String mSourceDepartureDate;
    @b(a = "quota")
    private String quota;
    @b(a = "source")
    private String source;
    @b(a = "source_station_name")
    private String sourceStationName;
    @b(a = "train_name")
    private String trainName;
    @b(a = "train_number")
    private String trainNumber;
    @b(a = "travellers")
    private String travellersCount;

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public CJRTrainCancellationProtectFare getCpBreakUp() {
        return this.cpBreakUp;
    }

    public void setCpBreakUp(CJRTrainCancellationProtectFare cJRTrainCancellationProtectFare) {
        this.cpBreakUp = cJRTrainCancellationProtectFare;
    }

    public String getSourceDepartureDate() {
        return this.mSourceDepartureDate;
    }

    public void setSourceDepartureDate(String str) {
        this.mSourceDepartureDate = str;
    }

    public CJRFareDetails getFareDetails() {
        return this.fareDetails;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getSourceStationName() {
        return this.sourceStationName;
    }

    public String getDestinationStationName() {
        return this.destinationStationName;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public String getClassVAlue() {
        return this.classVAlue;
    }

    public String getQuota() {
        return this.quota;
    }

    public String getTravellersCount() {
        return this.travellersCount;
    }

    public String getSource() {
        return this.source;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getBoardingTime() {
        return this.boardingTime;
    }

    public String getBoardingStation() {
        return this.boardingStation;
    }

    public String getBoardingStationName() {
        return this.boardingStationName;
    }
}
