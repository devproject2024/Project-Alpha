package com.paytmmall.artifact.grid.entity;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRDataModelItem;
import java.util.ArrayList;

public class CJRFrontEndFilter extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    @b(a = "applied")
    private ArrayList<CJRFilterValue> mAppliedFrontEndFiltersList = new ArrayList<>();
    @b(a = "filter_param")
    private String mFilterParam;
    @b(a = "values")
    private CJRFrontEndFilterItem mFrontEndFilterRootItem;
    private ArrayList<CJRFrontEndFilterItem> mSelectedFilterOptionList = new ArrayList<>();
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String mType;

    public String getName() {
        return null;
    }

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
