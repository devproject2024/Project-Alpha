package com.travel.flight.pojo.model;

import android.os.Parcel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTravellerSeatTransition implements IJRDataModel {
    private ArrayList<CJRSeatSelection> mOnwardSeatSelections;
    private ArrayList<CJRSeatSelection> mReturnSeatSelections;

    public CJRTravellerSeatTransition(Parcel parcel) {
        this.mOnwardSeatSelections = new ArrayList<>();
        this.mOnwardSeatSelections = parcel.readArrayList(CJRSeatSelection.class.getClassLoader());
        this.mReturnSeatSelections = new ArrayList<>();
        this.mReturnSeatSelections = parcel.readArrayList(CJRSeatSelection.class.getClassLoader());
    }

    public CJRTravellerSeatTransition() {
    }

    public ArrayList<CJRSeatSelection> getOnwardSeatSelections() {
        return this.mOnwardSeatSelections;
    }

    public void setOnwardSeatSelections(ArrayList<CJRSeatSelection> arrayList) {
        this.mOnwardSeatSelections = arrayList;
    }

    public ArrayList<CJRSeatSelection> getmReturnSeatSelections() {
        return this.mReturnSeatSelections;
    }

    public void setmReturnSeatSelections(ArrayList<CJRSeatSelection> arrayList) {
        this.mReturnSeatSelections = arrayList;
    }
}
