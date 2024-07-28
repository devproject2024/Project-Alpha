package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFilterAndBannerOrder implements IJRDataModel {
    @b(a = "cheapest")
    private List<String> cheapest;
    @b(a = "duration")
    private List<String> duration;
    @b(a = "early_arrival")
    private List<String> early_arrival;
    @b(a = "early_departure")
    private List<String> early_departure;
    @b(a = "late_arrival")
    private List<String> late_arrival;
    @b(a = "late_departure")
    private List<String> late_departure;

    public List<String> getCheapest() {
        return this.cheapest;
    }

    public void setCheapest(List<String> list) {
        this.cheapest = list;
    }

    public List<String> getDuration() {
        return this.duration;
    }

    public void setDuration(List<String> list) {
        this.duration = list;
    }

    public List<String> getEarly_departure() {
        return this.early_departure;
    }

    public void setEarly_departure(List<String> list) {
        this.early_departure = list;
    }

    public List<String> getLate_departure() {
        return this.late_departure;
    }

    public void setLate_departure(List<String> list) {
        this.late_departure = list;
    }

    public List<String> getEarly_arrival() {
        return this.early_arrival;
    }

    public void setEarly_arrival(List<String> list) {
        this.early_arrival = list;
    }

    public List<String> getLate_arrival() {
        return this.late_arrival;
    }

    public void setLate_arrival(List<String> list) {
        this.late_arrival = list;
    }
}
