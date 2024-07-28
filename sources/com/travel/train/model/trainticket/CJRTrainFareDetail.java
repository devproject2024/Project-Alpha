package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class CJRTrainFareDetail extends IJRPaytmDataModel implements Comparable<CJRTrainFareDetail> {
    @b(a = "child")
    private List<CJRTrainFareDetail> childList;
    @b(a = "displayName")
    private List<CJRTrainDisplayName> displayName;
    @b(a = "key")
    private int key;
    @b(a = "type")
    private String type;
    @b(a = "value")
    private List<CJRTrainValue> value;
    @b(a = "visibility")
    private boolean visibility;

    public int getKey() {
        return this.key;
    }

    public void setKey(int i2) {
        this.key = i2;
    }

    public void setDisplayName(List<CJRTrainDisplayName> list) {
        this.displayName = list;
    }

    public void setValue(List<CJRTrainValue> list) {
        this.value = list;
    }

    public List<CJRTrainDisplayName> getDisplayName() {
        return this.displayName;
    }

    public List<CJRTrainValue> getValue() {
        return this.value;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public boolean getVisibility() {
        return this.visibility;
    }

    public void setVisibility(boolean z) {
        this.visibility = z;
    }

    public void setChildList(List<CJRTrainFareDetail> list) {
        this.childList = list;
    }

    public ArrayList<CJRTrainFareDetail> getChildList() {
        return (ArrayList) this.childList;
    }

    public int compareTo(CJRTrainFareDetail cJRTrainFareDetail) {
        return this.key - cJRTrainFareDetail.getKey();
    }
}
