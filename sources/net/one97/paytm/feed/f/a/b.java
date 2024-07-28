package net.one97.paytm.feed.f.a;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;

public final class b implements Serializable {
    @c(a = "class")
    private String _class;
    @c(a = "boarding_station")
    private a boardingStation;
    @c(a = "chart_prepared")
    private Boolean chartPrepared;
    @c(a = "date")
    private String date;
    @c(a = "no_of_passengers")
    private Integer noOfPassengers;
    @c(a = "order_id")
    private String orderId;
    @c(a = "pax_info")
    private List<e> paxInfo;
    @c(a = "pnr_message")
    private String pnrMessage;
    @c(a = "pnr_number")
    private String pnrNumber;
    @c(a = "quota")
    private String quota;
    @c(a = "reservation_upto")
    private f reservationUpto;
    @c(a = "source_station")
    private g sourceStation;
    @c(a = "tip_enabled")
    private Boolean tipEnabled;
    @c(a = "tip_text")
    private String tipText;
    @c(a = "train_name")
    private String trainName;
    @c(a = "train_number")
    private String trainNumber;

    public final String getPnrNumber() {
        return this.pnrNumber;
    }

    public final void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public final Integer getNoOfPassengers() {
        return this.noOfPassengers;
    }

    public final void setNoOfPassengers(Integer num) {
        this.noOfPassengers = num;
    }

    public final String get_class() {
        return this._class;
    }

    public final void set_class(String str) {
        this._class = str;
    }

    public final String getTrainName() {
        return this.trainName;
    }

    public final void setTrainName(String str) {
        this.trainName = str;
    }

    public final String getTrainNumber() {
        return this.trainNumber;
    }

    public final void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public final String getQuota() {
        return this.quota;
    }

    public final void setQuota(String str) {
        this.quota = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final List<e> getPaxInfo() {
        return this.paxInfo;
    }

    public final void setPaxInfo(List<e> list) {
        this.paxInfo = list;
    }

    public final a getBoardingStation() {
        return this.boardingStation;
    }

    public final void setBoardingStation(a aVar) {
        this.boardingStation = aVar;
    }

    public final f getReservationUpto() {
        return this.reservationUpto;
    }

    public final void setReservationUpto(f fVar) {
        this.reservationUpto = fVar;
    }

    public final g getSourceStation() {
        return this.sourceStation;
    }

    public final void setSourceStation(g gVar) {
        this.sourceStation = gVar;
    }

    public final Boolean getTipEnabled() {
        return this.tipEnabled;
    }

    public final void setTipEnabled(Boolean bool) {
        this.tipEnabled = bool;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public final void setTipText(String str) {
        this.tipText = str;
    }

    public final Boolean getChartPrepared() {
        return this.chartPrepared;
    }

    public final void setChartPrepared(Boolean bool) {
        this.chartPrepared = bool;
    }

    public final String getPnrMessage() {
        return this.pnrMessage;
    }

    public final void setPnrMessage(String str) {
        this.pnrMessage = str;
    }
}
