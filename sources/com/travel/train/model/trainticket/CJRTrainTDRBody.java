package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTDRBody extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "boarding_date")
    private String boardingDate;
    @b(a = "boarding_station")
    private String boardingStation;
    @b(a = "boarding_station_name")
    private String boardingStationName;
    @b(a = "bottom_sheet_footer_html")
    private String bottomSheeFooter;
    @b(a = "bottom_sheet_header_text")
    private String bottomSheetHeader;
    @b(a = "cancelled_travellers")
    private ArrayList<CJRTrainTDRTravellerInfo> cancelledTravellers;
    @b(a = "cancelled_travellers_label")
    private String cancelledTravellersLabel;
    @b(a = "destination_station")
    private String destinationStation;
    @b(a = "destination_station_name")
    private String destinationStationName;
    @b(a = "reasons")
    private CJRTrainTDRReasons reasons;
    @b(a = "rules_link")
    private String rulesLink;
    @b(a = "rules_text")
    private String rulesText;
    @b(a = "tdr_filed_travellers")
    private ArrayList<CJRTrainTDRTravellerInfo> tdrFiledTravellers;
    @b(a = "tdr_filed_travellers_label")
    private String tdrFiledTravellersLabel;
    @b(a = "tdr_submit_url")
    private String tdrSubmitUrl;
    @b(a = "train_name")
    private String trainName;
    @b(a = "train_number")
    private String trainNumber;
    @b(a = "travellers")
    private ArrayList<CJRTrainTDRTravellerInfo> travellers;
    @b(a = "travellers_header_text")
    private String travellersHeaderText;

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getBoardingDate() {
        return this.boardingDate;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public String getDestinationStationName() {
        return this.destinationStationName;
    }

    public String getBoardingStation() {
        return this.boardingStation;
    }

    public String getBoardingStationName() {
        return this.boardingStationName;
    }

    public String getTravellersHeaderText() {
        return this.travellersHeaderText;
    }

    public ArrayList<CJRTrainTDRTravellerInfo> getTravellers() {
        return this.travellers;
    }

    public ArrayList<CJRTrainTDRTravellerInfo> getCancelledTravellers() {
        return this.cancelledTravellers;
    }

    public String getCancelledTravellersLabel() {
        return this.cancelledTravellersLabel;
    }

    public ArrayList<CJRTrainTDRTravellerInfo> getTdrFiledTravellers() {
        return this.tdrFiledTravellers;
    }

    public String getTdrFiledTravellersLabel() {
        return this.tdrFiledTravellersLabel;
    }

    public CJRTrainTDRReasons getReasons() {
        return this.reasons;
    }

    public String getBottomSheetHeader() {
        return this.bottomSheetHeader;
    }

    public String getBottomSheeFooter() {
        return this.bottomSheeFooter;
    }

    public String getRulesText() {
        return this.rulesText;
    }

    public String getRulesLink() {
        return this.rulesLink;
    }

    public String getTdrSubmitUrl() {
        return this.tdrSubmitUrl;
    }
}
