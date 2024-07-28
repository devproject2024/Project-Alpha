package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBookedMovieTicket implements IJRDataModel {
    @b(a = "audi")
    private String audi;
    @b(a = "bookingId")
    private String bookingId;
    @b(a = "cinema")
    private String cinema;
    @b(a = "format")
    private String format;
    @b(a = "language")
    private String language;
    @b(a = "latitude")
    private String latitude;
    @b(a = "longitude")
    private String longitude;
    @b(a = "movie")
    private String movie;
    @b(a = "noOfSeats")
    private int noOfSeats;
    @b(a = "orderId")
    private String orderId;
    @b(a = "qrLink")
    private String qrLink;
    @b(a = "seatInfo")
    private String seatInfo;
    @b(a = "showTime")
    private String showTime;
    @b(a = "ticket_key")
    private String ticket_key;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getAudi() {
        return this.audi;
    }

    public void setAudi(String str) {
        this.audi = str;
    }

    public String getMovie() {
        return this.movie;
    }

    public void setMovie(String str) {
        this.movie = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public int getNoOfSeats() {
        return this.noOfSeats;
    }

    public void setNoOfSeats(int i2) {
        this.noOfSeats = i2;
    }

    public String getSeatInfo() {
        return this.seatInfo;
    }

    public void setSeatInfo(String str) {
        this.seatInfo = str;
    }

    public String getShowTime() {
        return this.showTime;
    }

    public void setShowTime(String str) {
        this.showTime = str;
    }

    public String getCinema() {
        return this.cinema;
    }

    public void setCinema(String str) {
        this.cinema = str;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String str) {
        this.bookingId = str;
    }

    public String getQrLink() {
        return this.qrLink;
    }

    public void setQrLink(String str) {
        this.qrLink = str;
    }

    public String getTicket_key() {
        return this.ticket_key;
    }

    public void setTicket_key(String str) {
        this.ticket_key = str;
    }

    public Double getLatitude() {
        try {
            return Double.valueOf(this.latitude);
        } catch (Exception unused) {
            return null;
        }
    }

    public Double getLongitude() {
        try {
            return Double.valueOf(this.longitude);
        } catch (Exception unused) {
            return null;
        }
    }
}
