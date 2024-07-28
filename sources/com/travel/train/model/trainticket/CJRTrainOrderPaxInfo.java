package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOrderPaxInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "berth_key")
    private String berthKey;
    @b(a = "berth_type_key")
    private String berthTypeKey;
    @b(a = "berth_type_value")
    private String berthTypeValue;
    @b(a = "berth_value")
    private String berthValue;
    @b(a = "coach_key")
    private String coachKey;
    @b(a = "coach_value")
    private String coachValue;
    @b(a = "irctc_insurance")
    private boolean irctcInsurance;
    @b(a = "isConfirmed")
    private boolean isConfirmed;
    @b(a = "item_actions")
    private ArrayList<CJRTrainOrderSummaryAction> itemActions = null;
    @b(a = "item_status")
    private CJRTrainOrderSummaryItemStatus itemStatus;
    @b(a = "passenger_age")
    private String passengerAge;
    @b(a = "passenger_gender")
    private String passengerGender;
    @b(a = "passenger_icon")
    private String passengerIcon;
    @b(a = "passenger_name")
    private String passengerName;
    @b(a = "passenger_nationality")
    private String passengerNationality;
    @b(a = "passenger_serial")
    private int passengerSerial;
    @b(a = "prediction")
    private CJRTrainPrediction prediction;
    @b(a = "senior_citizen_text")
    private String seniorCitizenText;
    @b(a = "text_holder")
    private CJRTrainOrderTextHolder textHolder;
    @b(a = "ticket_status_key")
    private String ticketStatusKey;
    @b(a = "ticket_status_value_1")
    private String ticketStatusValue1;
    @b(a = "ticket_status_value_2")
    private String ticketStatusValue2;

    public String getPassengerName() {
        return this.passengerName;
    }

    public String getPassengerIcon() {
        return this.passengerIcon;
    }

    public String getPassengerGender() {
        return this.passengerGender;
    }

    public String getPassengerAge() {
        return this.passengerAge;
    }

    public int getPassengerSerial() {
        return this.passengerSerial;
    }

    public boolean getIrctcInsurance() {
        return this.irctcInsurance;
    }

    public String getPassengerNationality() {
        return this.passengerNationality;
    }

    public String getSeniorCitizenText() {
        return this.seniorCitizenText;
    }

    public boolean getIsConfirmed() {
        return this.isConfirmed;
    }

    public String getTicketStatusKey() {
        return this.ticketStatusKey;
    }

    public String getTicketStatusValue1() {
        return this.ticketStatusValue1;
    }

    public String getTicketStatusValue2() {
        return this.ticketStatusValue2;
    }

    public String getCoachKey() {
        return this.coachKey;
    }

    public String getBerthKey() {
        return this.berthKey;
    }

    public String getCoachValue() {
        return this.coachValue;
    }

    public String getBerthValue() {
        return this.berthValue;
    }

    public String getBerthTypeKey() {
        return this.berthTypeKey;
    }

    public String getBerthTypeValue() {
        return this.berthTypeValue;
    }

    public CJRTrainPrediction getPrediction() {
        return this.prediction;
    }

    public CJRTrainOrderSummaryItemStatus getItemStatus() {
        return this.itemStatus;
    }

    public ArrayList<CJRTrainOrderSummaryAction> getItemActions() {
        return this.itemActions;
    }

    public CJRTrainOrderTextHolder getTextHolder() {
        return this.textHolder;
    }
}
