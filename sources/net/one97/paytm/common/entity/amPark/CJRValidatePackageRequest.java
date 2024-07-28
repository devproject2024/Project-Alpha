package net.one97.paytm.common.entity.amPark;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;

public class CJRValidatePackageRequest {
    @c(a = "channel")
    @a
    private String channel;
    @c(a = "entId")
    @a
    private Integer entId;
    @c(a = "page")
    @a
    private Integer page;
    @c(a = "passenger")
    @a
    List<AmParkInputForm> passenger;
    @c(a = "providerId")
    @a
    private Integer providerId;
    @c(a = "seatInfo")
    @a
    List<CJRInputSeatInfo> seatInfo;
    @c(a = "startTime")
    @a
    private String startTime;
    @c(a = "ticketCount")
    @a
    private Integer ticketCount;
    @c(a = "version")
    @a
    private Integer version;

    public Integer getProviderId() {
        return this.providerId;
    }

    public void setProviderId(Integer num) {
        this.providerId = num;
    }

    public Integer getEntId() {
        return this.entId;
    }

    public void setEntId(Integer num) {
        this.entId = num;
    }

    public Integer getTicketCount() {
        return this.ticketCount;
    }

    public void setTicketCount(Integer num) {
        this.ticketCount = num;
    }

    public List<CJRInputSeatInfo> getSeatInfo() {
        return this.seatInfo;
    }

    public void setSeatInfo(List<CJRInputSeatInfo> list) {
        this.seatInfo = list;
    }

    public List<AmParkInputForm> getPassenger() {
        return this.passenger;
    }

    public void setPassenger(List<AmParkInputForm> list) {
        this.passenger = list;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer num) {
        this.version = num;
    }
}
