package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainLSSearchResult extends IJRPaytmDataModel implements IJRDataModel {
    @a
    @b(a = "body")
    private List<Body> body;
    @a
    @b(a = "code")
    private Integer code;
    @a
    @b(a = "error")
    private String error;
    @a
    @b(a = "meta")
    private Meta meta;
    @a
    @b(a = "status")
    private CJRTrainStatus status;

    public String getError() {
        return this.error;
    }

    public CJRTrainStatus getStatus() {
        return this.status;
    }

    public List<Body> getBody() {
        return this.body;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public Integer getCode() {
        return this.code;
    }

    public class Body extends IJRPaytmDataModel {
        @a
        @b(a = "message")
        private String message;
        @a
        @b(a = "trains")
        private ArrayList<Train> trains = new ArrayList<>();

        public Body() {
        }

        public ArrayList<Train> getTrains() {
            return this.trains;
        }

        public void setTrains(ArrayList<Train> arrayList) {
            this.trains = arrayList;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }

    public class Meta extends IJRPaytmDataModel {
        @a
        @b(a = "server_timestamp_ist")
        private String server_timestamp_ist;

        public Meta() {
        }

        public String getServer_timestamp_ist() {
            return this.server_timestamp_ist;
        }
    }

    public class Train extends IJRPaytmDataModel implements Cloneable {
        @a
        @b(a = "journeyClasses")
        private List<String> journeyClasses;
        @a
        @b(a = "runningOn")
        private String runningOn;
        @a
        @b(a = "schedule")
        private List<Schedule> schedule;
        @a
        @b(a = "trainName")
        private String trainName;
        @a
        @b(a = "trainNumber")
        private String trainNumber;

        public Train() {
        }

        public String getTrainName() {
            return this.trainName;
        }

        public String getRunningOn() {
            return this.runningOn;
        }

        public String getTrainNumber() {
            return this.trainNumber;
        }

        public List<String> getJourneyClasses() {
            return this.journeyClasses;
        }

        public List<Schedule> getSchedule() {
            return this.schedule;
        }
    }

    public class Schedule extends IJRPaytmDataModel {
        @a
        @b(a = "arrivalTime")
        private String arrivalTime;
        @a
        @b(a = "dayCount")
        private String dayCount;
        private int defaultStationPosition;
        @a
        @b(a = "departureTime")
        private String departureTime;
        private int destSelectedPosition = 0;
        @a
        @b(a = "distance")
        private String distance;
        @a
        @b(a = "haltTime")
        private String haltTime;
        @a
        @b(a = "routeNumber")
        private String routeNumber;
        private String runningOnForSource = null;
        private String selectedDeparturedate;
        private int sourceSelectedPosition = 0;
        @a
        @b(a = "stationCode")
        private String stationCode;
        @a
        @b(a = "stationName")
        private String stationName;
        @a
        @b(a = "stnSerialNumber")
        private String stnSerialNumber;

        public Schedule() {
        }

        public String getDistance() {
            return this.distance;
        }

        public String getDepartureTime() {
            return this.departureTime;
        }

        public String getRouteNumber() {
            return this.routeNumber;
        }

        public String getStationName() {
            return this.stationName;
        }

        public String getDayCount() {
            return this.dayCount;
        }

        public String getStnSerialNumber() {
            return this.stnSerialNumber;
        }

        public String getHaltTime() {
            return this.haltTime;
        }

        public String getArrivalTime() {
            return this.arrivalTime;
        }

        public String getStationCode() {
            return this.stationCode;
        }

        public void setStationCode(String str) {
            this.stationCode = str;
        }

        public int getSourceSelectedPosition() {
            return this.sourceSelectedPosition;
        }

        public void setSourceSelectedPosition(int i2) {
            this.sourceSelectedPosition = i2;
        }

        public int getDestSelectedPosition() {
            return this.destSelectedPosition;
        }

        public void setDestSelectedPosition(int i2) {
            this.destSelectedPosition = i2;
        }

        public String getSelectedDeparturedate() {
            return this.selectedDeparturedate;
        }

        public void setSelectedDeparturedate(String str) {
            this.selectedDeparturedate = str;
        }

        public int getDefaultStationPosition() {
            return this.defaultStationPosition;
        }

        public void setDefaultStationPosition(int i2) {
            this.defaultStationPosition = i2;
        }

        public String getRunningOnForSource() {
            return this.runningOnForSource;
        }

        public void setRunningOnForSource(String str) {
            this.runningOnForSource = str;
        }
    }
}
