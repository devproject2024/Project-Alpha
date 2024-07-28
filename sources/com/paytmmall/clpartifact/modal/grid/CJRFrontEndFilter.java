package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class CJRFrontEndFilter implements Serializable {
    private static final long serialVersionUID = 1;
    @c(a = "applied")
    private ArrayList<CJRFilterValue> mAppliedFrontEndFiltersList = new ArrayList<>();
    @c(a = "filter_param")
    private String mFilterParam;
    @c(a = "values")
    private CJRFrontEndFilterItem mFrontEndFilterRootItem;
    private ArrayList<CJRFrontEndFilterItem> mSelectedFilterOptionList = new ArrayList<>();
    @c(a = "title")
    private String mTitle;
    @c(a = "type")
    private String mType;

    public String getTitle() {
        return this.mTitle;
    }

    public ArrayList<CJRFilterValue> getAppliedFrontEndFiltersList() {
        return this.mAppliedFrontEndFiltersList;
    }

    public CJRFrontEndFilterItem getFrontEndRootFilterItem() {
        return this.mFrontEndFilterRootItem;
    }

    public String getFilterParam() {
        return this.mFilterParam;
    }

    public String getType() {
        return this.mType;
    }

    public ArrayList<CJRFrontEndFilterItem> getSelectedFilterOptionList() {
        return this.mSelectedFilterOptionList;
    }

    public void addItemSelectedFilterOptionList(CJRFrontEndFilterItem cJRFrontEndFilterItem) {
        this.mSelectedFilterOptionList.add(cJRFrontEndFilterItem);
    }
}
