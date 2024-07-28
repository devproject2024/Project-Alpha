package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class BestRecentTickets implements Serializable {
    @b(a = "amount")
    private Double amount;
    @b(a = "conductor_id")
    private String conductorId;
    @b(a = "conductor_name")
    private String conductorName;
    @b(a = "destination")
    private String destination;
    @b(a = "destination_name")
    private String destinationName;
    @b(a = "otp")
    private String otp;
    @b(a = "pass_id")
    private String passId;
    @b(a = "passenger_count")
    private Integer passengerCount;
    @b(a = "route_id")
    private String routeId;
    @b(a = "route_name")
    private String routeName;
    @b(a = "source")
    private String source;
    @b(a = "source_name")
    private String sourceName;
    @b(a = "status")
    private String status;
    @b(a = "ticket_id")
    private String ticketId;
    @b(a = "token_expiration_datetime")
    private Long tokenExpirationDatetime;
    @b(a = "token_id")
    private String tokenId;
    @b(a = "token_issuance_datetime")
    private Long tokenIssuanceDatetime;
    @b(a = "token_validation_datetime")
    private Long tokenValidationDatetime;
    @b(a = "validation_code")
    private String validationCode;

    public String getTokenId() {
        return this.tokenId;
    }

    public void setTokenId(String str) {
        this.tokenId = str;
    }

    public String getPassId() {
        return this.passId;
    }

    public void setPassId(String str) {
        this.passId = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceName(String str) {
        this.sourceName = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public void setDestinationName(String str) {
        this.destinationName = str;
    }

    public String getRouteId() {
        return this.routeId;
    }

    public void setRouteId(String str) {
        this.routeId = str;
    }

    public String getRouteName() {
        return this.routeName;
    }

    public void setRouteName(String str) {
        this.routeName = str;
    }

    public Integer getPassengerCount() {
        return this.passengerCount;
    }

    public void setPassengerCount(Integer num) {
        this.passengerCount = num;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double d2) {
        this.amount = d2;
    }

    public Long getTokenIssuanceDatetime() {
        return this.tokenIssuanceDatetime;
    }

    public void setTokenIssuanceDatetime(Long l) {
        this.tokenIssuanceDatetime = l;
    }

    public Long getTokenValidationDatetime() {
        return this.tokenValidationDatetime;
    }

    public void setTokenValidationDatetime(Long l) {
        this.tokenValidationDatetime = l;
    }

    public Long getTokenExpirationDatetime() {
        return this.tokenExpirationDatetime;
    }

    public void setTokenExpirationDatetime(Long l) {
        this.tokenExpirationDatetime = l;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getOtp() {
        return this.otp;
    }

    public void setOtp(String str) {
        this.otp = str;
    }

    public String getConductorId() {
        return this.conductorId;
    }

    public void setConductorId(String str) {
        this.conductorId = str;
    }

    public String getConductorName() {
        return this.conductorName;
    }

    public void setConductorName(String str) {
        this.conductorName = str;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(String str) {
        this.ticketId = str;
    }

    public String getValidationCode() {
        return this.validationCode;
    }

    public void setValidationCode(String str) {
        this.validationCode = str;
    }
}
