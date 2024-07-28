package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightsAdditionalInfo implements Cloneable, IJRDataModel {
    @b(a = "change_airport")
    private String changeAirport;
    @b(a = "change_flight")
    private String changeFlight;
    @b(a = "nearby_airports")
    private String nearbyAirports;
    @b(a = "nextday_arrival")
    private String nextdayArrival;
    @b(a = "ok_to_board")
    private String okToBoard;
    @b(a = "operating_airline")
    private String operatingAirline;
    @b(a = "origin_visa_options")
    private List<String> originVisaOptions;
    @b(a = "umrah_visa")
    private String umrahVisa;

    public List<String> getOriginVisaOptions() {
        return this.originVisaOptions;
    }

    public void setOriginVisaOptions(List<String> list) {
        this.originVisaOptions = list;
    }

    public String getNearbyAirports() {
        return this.nearbyAirports;
    }

    public void setNearbyAirports(String str) {
        this.nearbyAirports = str;
    }

    public String getOkToBoard() {
        return this.okToBoard;
    }

    public void setOkToBoard(String str) {
        this.okToBoard = str;
    }

    public String getUmrahVisa() {
        return this.umrahVisa;
    }

    public void setUmrahVisa(String str) {
        this.umrahVisa = str;
    }

    public String getOperatingAirline() {
        return this.operatingAirline;
    }

    public void setOperatingAirline(String str) {
        this.operatingAirline = str;
    }

    public String getChangeFlight() {
        return this.changeFlight;
    }

    public void setChangeFlight(String str) {
        this.changeFlight = str;
    }

    public String getChangeAirport() {
        return this.changeAirport;
    }

    public void setChangeAirport(String str) {
        this.changeAirport = str;
    }

    public String getNextdayArrival() {
        return this.nextdayArrival;
    }

    public void setNextdayArrival(String str) {
        this.nextdayArrival = str;
    }
}
