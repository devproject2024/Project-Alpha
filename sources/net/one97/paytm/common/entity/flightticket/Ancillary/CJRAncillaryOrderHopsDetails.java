package net.one97.paytm.common.entity.flightticket.Ancillary;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAncillaryOrderHopsDetails implements IJRDataModel {
    @b(a = "destination")
    private String destination;
    @b(a = "items")
    private ArrayList<CJRAncillaryOrderItem> itemList;
    private String name;
    @b(a = "origin")
    private String origin;

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public ArrayList<CJRAncillaryOrderItem> getItemList() {
        return this.itemList;
    }

    public void setItemList(ArrayList<CJRAncillaryOrderItem> arrayList) {
        this.itemList = arrayList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
