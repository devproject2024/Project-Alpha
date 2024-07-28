package com.travel.bus.pojo.bussearch;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSuggestionZeroSearch extends IJRPaytmDataModel {
    @b(a = "edge")
    private String edge;
    @b(a = "end")
    private String end;
    private boolean isExpanded = false;
    private com.travel.bus.busticket.h.b layoutType = com.travel.bus.busticket.h.b.NEAR_BY_ZERO_SEARCH;
    @b(a = "start")
    private String start;

    public String getStart() {
        return this.start;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public String getEnd() {
        return this.end;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public String getEdge() {
        return this.edge;
    }

    public com.travel.bus.busticket.h.b getLayoutType() {
        return this.layoutType;
    }

    public void setLayoutType(com.travel.bus.busticket.h.b bVar) {
        this.layoutType = bVar;
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void setExpanded(boolean z) {
        this.isExpanded = z;
    }
}
