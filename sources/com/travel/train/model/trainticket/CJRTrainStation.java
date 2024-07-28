package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainStation extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "data")
    private CJRTrainOriginCityItem data;
    @b(a = "expand_list")
    private ArrayList<CJRTrainOriginCityItem> expandStationList;
    @b(a = "expand_title")
    private String expandStationListTitle;
    @b(a = "expandable")
    private boolean expandable;
    private boolean isNearByStation = false;
    private boolean showNoStationView = false;
    @b(a = "type")
    private String type;

    public CJRTrainOriginCityItem getCityItem() {
        return this.data;
    }

    public void setCityItem(CJRTrainOriginCityItem cJRTrainOriginCityItem) {
        this.data = cJRTrainOriginCityItem;
    }

    public boolean isExpandable() {
        return this.expandable;
    }

    public void setExpandable(boolean z) {
        this.expandable = z;
    }

    public String getType() {
        return this.type;
    }

    public ArrayList<CJRTrainOriginCityItem> getExpandStationList() {
        return this.expandStationList;
    }

    public String getExpandStationListTitle() {
        return this.expandStationListTitle;
    }

    public boolean isShowNoStationView() {
        return this.showNoStationView;
    }

    public boolean isNearByStation() {
        return this.isNearByStation;
    }

    public void setNearByStation(boolean z) {
        this.isNearByStation = z;
    }
}
