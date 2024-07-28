package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJREventAutosuggestModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "restevents")
    private ArrayList<CJREventAutosuggestEventItem> restEvents = new ArrayList<>();
    @b(a = "today")
    private ArrayList<CJREventAutosuggestEventItem> todayEvents = new ArrayList<>();
    @b(a = "tomorrow")
    private ArrayList<CJREventAutosuggestEventItem> tomorrowEvents = new ArrayList<>();
    @b(a = "weekend")
    private ArrayList<CJREventAutosuggestEventItem> weekendEvents = new ArrayList<>();

    public ArrayList<CJREventAutosuggestEventItem> getRestEvents() {
        return this.restEvents;
    }

    public void setRestEvents(ArrayList<CJREventAutosuggestEventItem> arrayList) {
        this.restEvents = arrayList;
    }

    public ArrayList<CJREventAutosuggestEventItem> getTodayEvents() {
        return this.todayEvents;
    }

    public void setTodayEvents(ArrayList<CJREventAutosuggestEventItem> arrayList) {
        this.todayEvents = arrayList;
    }

    public ArrayList<CJREventAutosuggestEventItem> getTomorrowEvents() {
        return this.tomorrowEvents;
    }

    public void setTomorrowEvents(ArrayList<CJREventAutosuggestEventItem> arrayList) {
        this.tomorrowEvents = arrayList;
    }

    public ArrayList<CJREventAutosuggestEventItem> getWeekendEvents() {
        return this.weekendEvents;
    }

    public void setWeekendEvents(ArrayList<CJREventAutosuggestEventItem> arrayList) {
        this.weekendEvents = arrayList;
    }
}
