package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainQuickBookPassengerInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "childBerthFlag")
    private Boolean childBerthFlag;
    @b(a = "concessionOpted")
    private Boolean concessionOpted;
    @b(a = "passengerAge")
    private int passengerAge;
    @b(a = "passengerBedRollChoice")
    private Boolean passengerBedRollChoice;
    @b(a = "passengerBerthChoice")
    private String passengerBerthChoice;
    @b(a = "passengerCardNumber")
    private String passengerCardNumber;
    @b(a = "passengerCardType")
    private String passengerCardType;
    @b(a = "passengerCategory")
    private String passengerCategory;
    @b(a = "passengerFoodChoice")
    private String passengerFoodChoice;
    @b(a = "passengerGender")
    private String passengerGender;
    @b(a = "passengerName")
    private String passengerName;
    @b(a = "passengerNationality")
    private String passengerNationality;
    @b(a = "passengerSerialNumber")
    private int passengerSerialNumber;
    @b(a = "travelInsuranceOpted")
    private Boolean travelInsuranceOpted;

    public Boolean getChildBerthFlag() {
        return this.childBerthFlag;
    }

    public Boolean getPassengerBedRollChoice() {
        return this.passengerBedRollChoice;
    }

    public String getPassengerFoodChoice() {
        return this.passengerFoodChoice;
    }

    public Boolean getConcessionOpted() {
        return this.concessionOpted;
    }

    public String getPassengerCategory() {
        return this.passengerCategory;
    }

    public String getPassengerBerthChoice() {
        return this.passengerBerthChoice;
    }

    public Boolean getTravelInsuranceOpted() {
        return this.travelInsuranceOpted;
    }

    public String getPassengerNationality() {
        return this.passengerNationality;
    }

    public int getPassengerAge() {
        return this.passengerAge;
    }

    public String getPassengerGender() {
        return this.passengerGender;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public int getPassengerSerialNumber() {
        return this.passengerSerialNumber;
    }

    public String getPassengerCardType() {
        return this.passengerCardType;
    }

    public String getPassengerCardNumber() {
        return this.passengerCardNumber;
    }
}
