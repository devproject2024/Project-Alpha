package com.travel.flight.pojo.seatancillaryentity.availability;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJRSeatPClass extends IJRPaytmDataModel {
    @a
    @b(a = "legend")
    private CJRSeatLegend CJRSeatLegend;
    @a
    @b(a = "tax")
    private List<CJRSeatTax> CJRSeatTaxes = null;
    @a
    @b(a = "amount")
    private Integer amount;
    @a
    @b(a = "title")
    private String title;

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer num) {
        this.amount = num;
    }

    public List<CJRSeatTax> getCJRSeatTaxes() {
        return this.CJRSeatTaxes;
    }

    public void setCJRSeatTaxes(List<CJRSeatTax> list) {
        this.CJRSeatTaxes = list;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public CJRSeatLegend getCJRSeatLegend() {
        return this.CJRSeatLegend;
    }

    public void setCJRSeatLegend(CJRSeatLegend cJRSeatLegend) {
        this.CJRSeatLegend = cJRSeatLegend;
    }
}
