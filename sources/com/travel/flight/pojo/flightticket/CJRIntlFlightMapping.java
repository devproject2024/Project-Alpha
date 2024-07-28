package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIntlFlightMapping implements IJRDataModel {
    @b(a = "return")
    private List<Integer> _return = new ArrayList();
    @b(a = "flightid")
    private String flightId;
    private String groupKey;
    @b(a = "is_parent")
    private boolean isParent = false;
    @b(a = "is_paytm_stitched")
    private boolean isStitched = false;
    @b(a = "onward")
    private List<Integer> onward = new ArrayList();
    private CJRFlightDetailsItem onwardItem;
    @b(a = "parent_id")
    private String parentId;
    @b(a = "pricing")
    private CJRIntlFlightPricing pricing;
    private CJRFlightDetailsItem returnItem;

    public String getGroupKey() {
        return this.groupKey;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public boolean isStitched() {
        return this.isStitched;
    }

    public void setStitched(boolean z) {
        this.isStitched = z;
    }

    public List<Integer> getOnward() {
        return this.onward;
    }

    public void setOnward(List<Integer> list) {
        this.onward = list;
    }

    public List<Integer> getReturn() {
        return this._return;
    }

    public void setReturn(List<Integer> list) {
        this._return = list;
    }

    public CJRIntlFlightPricing getPricing() {
        return this.pricing;
    }

    public void setPricing(CJRIntlFlightPricing cJRIntlFlightPricing) {
        this.pricing = cJRIntlFlightPricing;
    }

    public boolean isParent() {
        return this.isParent;
    }

    public void setParent(boolean z) {
        this.isParent = z;
    }

    public String getFlightId() {
        return this.flightId;
    }

    public void setFlightId(String str) {
        this.flightId = str;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public CJRFlightDetailsItem getOnwardItem() {
        return this.onwardItem;
    }

    public void setOnwardItem(CJRFlightDetailsItem cJRFlightDetailsItem) {
        this.onwardItem = cJRFlightDetailsItem;
    }

    public CJRFlightDetailsItem getReturnItem() {
        return this.returnItem;
    }

    public void setReturnItem(CJRFlightDetailsItem cJRFlightDetailsItem) {
        this.returnItem = cJRFlightDetailsItem;
    }
}
