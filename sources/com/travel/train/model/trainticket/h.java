package com.travel.train.model.trainticket;

import java.io.Serializable;

public final class h implements Serializable {
    private String PNRNumber;
    private String date;
    private String from;
    private String to;

    public final String getPNRNumber() {
        return this.PNRNumber;
    }

    public final void setPNRNumber(String str) {
        this.PNRNumber = str;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final String getTo() {
        return this.to;
    }

    public final void setTo(String str) {
        this.to = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }
}
