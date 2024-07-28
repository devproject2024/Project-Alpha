package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.travel.bus.pojo.CJRBusSearchOperatorInfo;
import com.travel.bus.pojo.busticket.BusEcosystemOfferInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchAmenitiesInfo;
import com.travel.bus.pojo.busticket.CJRBusSearchOperatorTagInfo;
import com.travel.bus.pojo.busticket.f;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusSearchItemDictionary implements IJRDataModel {
    @b(a = "amenities")
    private HashMap<String, CJRBusSearchAmenitiesInfo> amenitiesInfo = new HashMap<>();
    @b(a = "boarding_points")
    private HashMap<String, CJRBusSearchItemBoardDropCount> boardingPoints = new HashMap<>();
    @b(a = "dropping_points")
    private HashMap<String, CJRBusSearchItemBoardDropCount> droppingPoints = new HashMap<>();
    @b(a = "ecosystem_offers")
    private HashMap<String, ArrayList<BusEcosystemOfferInfo>> ecosystemOffers;
    @b(a = "messages")
    private CJRBusSearchItemMessages messages;
    @b(a = "operator_tags")
    private HashMap<String, CJRBusSearchOperatorTagInfo> operatorTags = new HashMap<>();
    @b(a = "operators")
    private HashMap<String, CJRBusSearchOperatorInfo> operators;
    @b(a = "photos")
    private f photos;

    public HashMap<String, CJRBusSearchOperatorInfo> getOperators() {
        return this.operators;
    }

    public void setOperators(HashMap<String, CJRBusSearchOperatorInfo> hashMap) {
        this.operators = hashMap;
    }

    public void setMessages(CJRBusSearchItemMessages cJRBusSearchItemMessages) {
        this.messages = cJRBusSearchItemMessages;
    }

    public HashMap<String, CJRBusSearchItemBoardDropCount> getBoardingPoints() {
        return this.boardingPoints;
    }

    public void setBoardingPoints(HashMap<String, CJRBusSearchItemBoardDropCount> hashMap) {
        this.boardingPoints = hashMap;
    }

    public HashMap<String, CJRBusSearchItemBoardDropCount> getDroppingPoints() {
        return this.droppingPoints;
    }

    public void setDroppingPoints(HashMap<String, CJRBusSearchItemBoardDropCount> hashMap) {
        this.droppingPoints = hashMap;
    }

    public HashMap<String, CJRBusSearchOperatorTagInfo> getOperatorTags() {
        return this.operatorTags;
    }

    public void setOperatorTags(HashMap<String, CJRBusSearchOperatorTagInfo> hashMap) {
        this.operatorTags = hashMap;
    }

    public HashMap<String, CJRBusSearchAmenitiesInfo> getAmenitiesInfo() {
        return this.amenitiesInfo;
    }

    public void setAmenitiesInfo(HashMap<String, CJRBusSearchAmenitiesInfo> hashMap) {
        this.amenitiesInfo = hashMap;
    }

    public HashMap<String, ArrayList<BusEcosystemOfferInfo>> getEcosystemOffers() {
        return this.ecosystemOffers;
    }

    public void setEcosystemOffers(HashMap<String, ArrayList<BusEcosystemOfferInfo>> hashMap) {
        this.ecosystemOffers = hashMap;
    }

    public void setPhotos(f fVar) {
        this.photos = fVar;
    }
}
