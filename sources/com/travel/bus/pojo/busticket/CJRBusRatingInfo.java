package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRBusRatingInfo extends IJRPaytmDataModel {
    @b(a = "channel")
    private String channel;
    @b(a = "color_code")
    private String color_code;
    @b(a = "date_of_journey")
    private String date_of_journey;
    @b(a = "destination")
    private String destination;
    @b(a = "half_card_exists")
    private boolean half_card_exists;
    @b(a = "order_id")
    private String order_id;
    @b(a = "paytm_trip_id")
    private String paytm_trip_id;
    @b(a = "questions")
    private List<CJRBusRatingQuestions> questions = null;
    @b(a = "secret")
    private String secret;
    @b(a = "source")
    private String source;
    @b(a = "travels_name")
    private String travels_name;

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
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

    public String getDate_of_journey() {
        return this.date_of_journey;
    }

    public void setDate_of_journey(String str) {
        this.date_of_journey = str;
    }

    public String getTravels_name() {
        return this.travels_name;
    }

    public void setTravels_name(String str) {
        this.travels_name = str;
    }

    public String getColor_code() {
        return this.color_code;
    }

    public void setColor_code(String str) {
        this.color_code = str;
    }

    public List<CJRBusRatingQuestions> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<CJRBusRatingQuestions> list) {
        this.questions = list;
    }

    public void setHalf_card_exists(boolean z) {
        this.half_card_exists = z;
    }

    public boolean getHalf_card_exists() {
        return this.half_card_exists;
    }

    public void setPaytm_trip_id(String str) {
        this.paytm_trip_id = str;
    }

    public String getPaytm_trip_id() {
        return this.paytm_trip_id;
    }
}
