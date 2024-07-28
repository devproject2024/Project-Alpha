package com.travel.flight.pojo.flightticket;

import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import java.util.List;

public class CJRViewFareAlerts extends IJRPaytmDataModel {
    private List<a> body;
    private String code;

    public List<a> getBody() {
        return this.body;
    }

    public void setBody(List<a> list) {
        this.body = list;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public class a implements Serializable {
        private String destination;
        private String destination_iata;
        private String doj;
        private String source;
        private String source_iata;
        private String travel_class;
        private b trend;

        public a() {
        }

        public final String getTravel_class() {
            return this.travel_class;
        }

        public final void setTravel_class(String str) {
            this.travel_class = str;
        }

        public final b getTrend() {
            return this.trend;
        }

        public final void setTrend(b bVar) {
            this.trend = bVar;
        }

        public final String getSource() {
            return this.source;
        }

        public final void setSource(String str) {
            this.source = str;
        }

        public final String getSource_iata() {
            return this.source_iata;
        }

        public final void setSource_iata(String str) {
            this.source_iata = str;
        }

        public final String getDestination_iata() {
            return this.destination_iata;
        }

        public final void setDestination_iata(String str) {
            this.destination_iata = str;
        }

        public final String getDoj() {
            return this.doj;
        }

        public final void setDoj(String str) {
            this.doj = str;
        }

        public final String getDestination() {
            return this.destination;
        }

        public final void setDestination(String str) {
            this.destination = str;
        }
    }

    public class b implements Serializable {
        private String current_fare;
        private String days;
        private String delta;
        private String trend;

        public b() {
        }

        public final String getTrend() {
            return this.trend;
        }

        public final void setTrend(String str) {
            this.trend = str;
        }

        public final String getDays() {
            return this.days;
        }

        public final void setDays(String str) {
            this.days = str;
        }

        public final String getDelta() {
            return this.delta;
        }

        public final void setDelta(String str) {
            this.delta = str;
        }

        public final String getCurrent_fare() {
            return this.current_fare;
        }

        public final void setCurrent_fare(String str) {
            this.current_fare = str;
        }
    }
}
