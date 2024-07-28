package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class BestToken implements Serializable {
    @b(a = "amount")
    private Float amount;
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
    private Long tokenExpirationDateTime;
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

    public String getSourceName() {
        return this.sourceName;
    }

    public String getDestinationName() {
        return this.destinationName;
    }

    public Integer getPassengerCount() {
        return this.passengerCount;
    }

    public Float getAmount() {
        return this.amount;
    }

    public Long getTokenIssuanceDatetime() {
        return this.tokenIssuanceDatetime;
    }

    public Long getTokenExpirationDateTime() {
        return this.tokenExpirationDateTime;
    }

    public String getStatus() {
        return this.status;
    }

    public String getOtp() {
        return this.otp;
    }

    public String getConductorId() {
        return this.conductorId;
    }

    public String getConductorName() {
        return this.conductorName;
    }

    public String getRouteName() {
        return this.routeName;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public String getValidationCode() {
        return this.validationCode;
    }
}
