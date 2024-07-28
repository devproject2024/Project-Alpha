package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventAutosuggestEventItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "category")
    private ArrayList<String> category = new ArrayList<>();
    @b(a = "cities")
    private ArrayList<String> cities = new ArrayList<>();
    @b(a = "event_id")
    private String eventId;
    @b(a = "event_name")
    private String eventName;
    @b(a = "provider_id")
    private String providerId;
    private int type = 1;

    public ArrayList<String> getCities() {
        return this.cities;
    }

    public void setCities(ArrayList<String> arrayList) {
        this.cities = arrayList;
    }

    public String getEventId() {
        return this.eventId;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String str) {
        this.eventName = str;
    }

    public ArrayList<String> getCategory() {
        return this.category;
    }

    public void setCategory(ArrayList<String> arrayList) {
        this.category = arrayList;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String str) {
        this.providerId = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
