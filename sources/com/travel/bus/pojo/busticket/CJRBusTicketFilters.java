package com.travel.bus.pojo.busticket;

import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBusTicketFilters implements IJRDataModel {
    private static final String LOG_TAG = "CJRBusTicketFilters";
    private static final long serialVersionUID = 1;
    private ArrayList<CJRBusTicketFilterItem> mBusTicketFilterItems;
    private ArrayList<CJRBusSearchAmenitiesInfo> mCurrentSelectedAmenityList = new ArrayList<>();
    private boolean mDealsBusesFlag = false;
    private boolean mIsConstrainPresnt = false;
    private boolean mNightBusesFlag = false;
    private int orderBy;
    private String sortBy;

    public CJRBusTicketFilters(ArrayList<CJRBusTicketFilterItem> arrayList) {
        this.mBusTicketFilterItems = arrayList;
    }

    public CJRBusTicketFilters() {
    }

    public boolean ismIsConstrainPresnt() {
        return this.mIsConstrainPresnt;
    }

    public void setmIsConstrainPresnt(boolean z) {
        this.mIsConstrainPresnt = z;
    }

    public ArrayList<CJRBusTicketFilterItem> getBusTicketFilterItems() {
        return this.mBusTicketFilterItems;
    }

    public void setBusTicketFilterItems(ArrayList<CJRBusTicketFilterItem> arrayList) {
        this.mBusTicketFilterItems = arrayList;
    }

    public CJRBusTicketFilterItem getBusFilterItemByDisplayName(String str) {
        try {
            if (this.mBusTicketFilterItems == null || this.mBusTicketFilterItems.size() <= 0) {
                return null;
            }
            Iterator<CJRBusTicketFilterItem> it2 = this.mBusTicketFilterItems.iterator();
            while (it2.hasNext()) {
                CJRBusTicketFilterItem next = it2.next();
                if (next != null && next.getDisplayValue() != null && next.getDisplayValue().equalsIgnoreCase(str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public CJRBusTicketFilterItem getBusFilterItemByTitle(String str) {
        try {
            if (this.mBusTicketFilterItems == null || this.mBusTicketFilterItems.size() <= 0) {
                return null;
            }
            Iterator<CJRBusTicketFilterItem> it2 = this.mBusTicketFilterItems.iterator();
            while (it2.hasNext()) {
                CJRBusTicketFilterItem next = it2.next();
                if (next != null && next.getTitle() != null && next.getTitle().equalsIgnoreCase(str)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return null;
        }
    }

    public boolean containsValue(String str, String str2) {
        try {
            if (this.mBusTicketFilterItems == null || str == null || str2 == null) {
                return false;
            }
            Iterator<CJRBusTicketFilterItem> it2 = this.mBusTicketFilterItems.iterator();
            while (it2.hasNext()) {
                CJRBusTicketFilterItem next = it2.next();
                if (next != null && next.getTitle() != null && next.getFilterValue() != null && next.getTitle().trim().equalsIgnoreCase(str.trim()) && next.getFilterValue().trim().equalsIgnoreCase(str2.trim())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return false;
        }
    }

    public boolean containsValueBPDP(String str, String str2) {
        try {
            if (this.mBusTicketFilterItems == null || str == null || str2 == null) {
                return false;
            }
            Iterator<CJRBusTicketFilterItem> it2 = this.mBusTicketFilterItems.iterator();
            while (it2.hasNext()) {
                CJRBusTicketFilterItem next = it2.next();
                if (next != null && next.getTitle() != null && next.getFilterValue() != null && next.isBPDP() && next.getTitle().trim().equalsIgnoreCase(str.trim()) && str2.toLowerCase().trim().contains(next.getFilterValue().toLowerCase().trim())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            q.c(e2.getMessage());
            return false;
        }
    }

    public ArrayList<CJRBusSearchAmenitiesInfo> getmCurrentSelectedAmenityList() {
        return this.mCurrentSelectedAmenityList;
    }

    public void setmCurrentSelectedAmenityList(ArrayList<CJRBusSearchAmenitiesInfo> arrayList) {
        this.mCurrentSelectedAmenityList = arrayList;
    }

    public boolean ismNightBusesFlag() {
        return this.mNightBusesFlag;
    }

    public void setmNightBusesFlag(boolean z) {
        this.mNightBusesFlag = z;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String str) {
        this.sortBy = str;
    }

    public int getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(int i2) {
        this.orderBy = i2;
    }
}
