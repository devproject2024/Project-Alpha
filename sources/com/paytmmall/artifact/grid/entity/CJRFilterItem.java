package com.paytmmall.artifact.grid.entity;

import com.google.gsonhtcfix.a.b;
import com.paytmmall.artifact.common.entity.CJRDataModelItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CJRFilterItem extends CJRDataModelItem {
    private static final long serialVersionUID = 1;
    private boolean isFilterChart;
    private boolean isToggleChecked;
    @b(a = "display_value")
    private String mDisplayValue;
    @b(a = "applied")
    private ArrayList<CJRFilterValue> mFilterApplied = new ArrayList<>();
    @b(a = "applied_range")
    private CJRFilterValue mFilterAppliedRange = new CJRFilterValue();
    private String mFilterChartlabel;
    @b(a = "filter_param")
    private String mFilterParam;
    private String mFilterUrl;
    @b(a = "values")
    private ArrayList<CJRFilterValue> mFilterValues = new ArrayList<>();
    @b(a = "selected")
    private String mSelected;
    private ArrayList<String> mSelectedCounts = new ArrayList<>();
    private ArrayList<String> mSelectedValues = new ArrayList<>();
    @b(a = "title")
    private String mTitle;
    @b(a = "type")
    private String mType;
    private HashMap<CJRFilterValue, Boolean> mValuesMap = new HashMap<>();

    public String getName() {
        return null;
    }

    public String getSelected() {
        return this.mSelected;
    }

    public void setFilterValues(ArrayList<CJRFilterValue> arrayList) {
        this.mFilterValues = arrayList;
    }

    public void setFilterApplied(ArrayList<CJRFilterValue> arrayList) {
        this.mFilterApplied = arrayList;
    }

    public void setFilterAppliedRange(CJRFilterValue cJRFilterValue) {
        this.mFilterAppliedRange = cJRFilterValue;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public ArrayList<String> getSelectedValues() {
        return this.mSelectedValues;
    }

    public void setValues(ArrayList<String> arrayList) {
        this.mSelectedValues = arrayList;
    }

    public ArrayList<String> getSelectedCounts() {
        return this.mSelectedCounts;
    }

    public void setCounts(ArrayList<String> arrayList) {
        this.mSelectedCounts = arrayList;
    }

    public ArrayList<CJRFilterValue> getFilterValues() {
        return this.mFilterValues;
    }

    public ArrayList<CJRFilterValue> getFilterApplied() {
        return this.mFilterApplied;
    }

    public CJRFilterValue getFilterAppliedRange() {
        return this.mFilterAppliedRange;
    }

    public String getFilterParam() {
        return this.mFilterParam;
    }

    public void setFilterParam(String str) {
        this.mFilterParam = str;
    }

    public boolean equals(Object obj) {
        try {
            if (!this.mTitle.equalsIgnoreCase(((CJRFilterItem) obj).mTitle) || !this.mType.equalsIgnoreCase(((CJRFilterItem) obj).mType)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public HashMap<CJRFilterValue, Boolean> getValuesMap() {
        return this.mValuesMap;
    }

    public void setValuesMap(HashMap<CJRFilterValue, Boolean> hashMap) {
        this.mValuesMap = hashMap;
    }

    public void updateValuesMap(CJRFilterValue cJRFilterValue, boolean z) {
        this.mValuesMap.put(cJRFilterValue, Boolean.valueOf(z));
    }

    public void createValueMap() {
        ArrayList<CJRFilterValue> arrayList = this.mFilterValues;
        if (arrayList != null) {
            Iterator<CJRFilterValue> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.mValuesMap.put(it2.next(), Boolean.FALSE);
            }
        }
    }

    public ArrayList<String> getKeyForValue(boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (CJRFilterValue next : this.mValuesMap.keySet()) {
            if (this.mValuesMap.get(next).booleanValue()) {
                arrayList.add(next.getName());
            }
        }
        return arrayList;
    }

    public ArrayList<String> getKeyForCount(boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (CJRFilterValue next : this.mValuesMap.keySet()) {
            if (this.mValuesMap.get(next).booleanValue()) {
                arrayList.add(next.getCount());
            }
        }
        return arrayList;
    }

    public void setToggleChecked(boolean z) {
        this.isToggleChecked = z;
    }

    public boolean isToggleChecked() {
        return this.isToggleChecked;
    }

    public CJRFilterValue getFilterValueForName(String str) {
        ArrayList<CJRFilterValue> arrayList = this.mFilterValues;
        if (arrayList != null) {
            Iterator<CJRFilterValue> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CJRFilterValue next = it2.next();
                if (next.getName() != null && next.getName().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public CJRFilterValue getFilterValueForID(int i2) {
        ArrayList<CJRFilterValue> arrayList = this.mFilterValues;
        if (arrayList != null) {
            return arrayList.get(i2);
        }
        return null;
    }

    public boolean isFilterChart() {
        return this.isFilterChart;
    }

    public void setFilterChart(boolean z) {
        this.isFilterChart = z;
    }

    public String getFilterUrl() {
        return this.mFilterUrl;
    }

    public void setmFilterUrl(String str) {
        this.mFilterUrl = str;
    }

    public String getmFilterChartlabel() {
        return this.mFilterChartlabel;
    }

    public void setmFilterChartlabel(String str) {
        this.mFilterChartlabel = str;
    }

    public String getDisplayValue() {
        String str = this.mDisplayValue;
        return str == null ? "" : str;
    }

    public void setDisplayValue(String str) {
        this.mDisplayValue = str;
    }
}
