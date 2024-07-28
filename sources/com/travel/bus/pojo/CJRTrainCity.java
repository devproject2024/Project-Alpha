package com.travel.bus.pojo;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCity extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private ArrayList<Object> mTrainSearchedCityDetails;

    public ArrayList<Object> getmTrainSearchedCityDetails() {
        return this.mTrainSearchedCityDetails;
    }
}
