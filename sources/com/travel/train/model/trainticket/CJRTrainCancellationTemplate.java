package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainCancellationTemplate extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "items")
    private List<CJRTrainCancellationItem> items = null;
    @b(a = "title")
    private String title;

    public String getTitle() {
        return this.title;
    }

    public ArrayList<CJRTrainCancellationItem> getItems() {
        return (ArrayList) this.items;
    }
}
