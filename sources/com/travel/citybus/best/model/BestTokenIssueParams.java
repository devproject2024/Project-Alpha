package com.travel.citybus.best.model;

public class BestTokenIssueParams {
    private String destination;
    private int passenger_count;
    private String route_id;
    private String route_name;
    private String source;
    private String user_id;

    public String getUserId() {
        return this.user_id;
    }

    public void setUserId(String str) {
        this.user_id = str;
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

    public String getRouteId() {
        return this.route_id;
    }

    public void setRouteId(String str) {
        this.route_id = str;
    }

    public Integer getPassengerCount() {
        return Integer.valueOf(this.passenger_count);
    }

    public void setPassengerCount(Integer num) {
        this.passenger_count = num.intValue();
    }

    public String getRouteName() {
        return this.route_name;
    }

    public void setRouteName(String str) {
        this.route_name = str;
    }
}
