package com.travel.flight.pojo.seatancillaryentity;

import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatTax;
import java.io.Serializable;
import java.util.List;

public final class b implements Serializable {
    private static final long serialVersionUID = 1;
    private List<CJRSeatTax> CJRSeatTaxes;
    private String Destination;
    private String deck;
    private String flightNumber;
    private Boolean isEmergencyExit;
    private boolean isSeatAvailable;
    private boolean isSeatSelected = false;
    private String origin;
    private String seatCode;
    private String seatColor;
    private String seatNumber;
    private Double seatPrice;
    private String selectMsg;

    public final String getSeatCode() {
        return this.seatCode;
    }

    public final void setSeatCode(String str) {
        this.seatCode = str;
    }

    public final double getSeatPrice() {
        return this.seatPrice.doubleValue();
    }

    public final void setSeatPrice(double d2) {
        this.seatPrice = Double.valueOf(d2);
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final void setOrigin(String str) {
        this.origin = str;
    }

    public final String getDestination() {
        return this.Destination;
    }

    public final void setDestination(String str) {
        this.Destination = str;
    }

    public final String getSeatNumber() {
        return this.seatNumber;
    }

    public final void setSeatNumber(String str) {
        this.seatNumber = str;
    }

    public final String getSeatColor() {
        return this.seatColor;
    }

    public final void setSeatColor(String str) {
        this.seatColor = str;
    }

    public final boolean isSeatAvailable() {
        return this.isSeatAvailable;
    }

    public final void setSeatAvailable(boolean z) {
        this.isSeatAvailable = z;
    }

    public final boolean isSeatSelected() {
        return this.isSeatSelected;
    }

    public final void setSeatSelected(boolean z) {
        this.isSeatSelected = z;
    }

    public final List<CJRSeatTax> getCJRSeatTaxes() {
        return this.CJRSeatTaxes;
    }

    public final void setCJRSeatTaxes(List<CJRSeatTax> list) {
        this.CJRSeatTaxes = list;
    }

    public final String getFlightNumber() {
        return this.flightNumber;
    }

    public final void setFlightNumber(String str) {
        this.flightNumber = str;
    }

    public final String getDeck() {
        return this.deck;
    }

    public final void setDeck(String str) {
        this.deck = str;
    }

    public final Boolean getEmergencyExit() {
        return this.isEmergencyExit;
    }

    public final void setEmergencyExit(Boolean bool) {
        this.isEmergencyExit = bool;
    }

    public final String getSelectMsg() {
        return this.selectMsg;
    }

    public final void setSelectMsg(String str) {
        this.selectMsg = str;
    }
}
