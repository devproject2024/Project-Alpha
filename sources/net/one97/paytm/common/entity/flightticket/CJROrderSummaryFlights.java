package net.one97.paytm.common.entity.flightticket;

import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryFlights implements IJRDataModel {
    private String airline;
    private String airline_code;
    private String airline_color_code;
    private String arrival_terminal;
    private String arrival_time;
    private String arrival_time_local;
    @c(a = "class")
    private String classType;
    private String departure_terminal;
    private String departure_time;
    private String departure_time_local;
    private CJROrderSummaryDestination destination;
    private String duration;
    private String flight_no;
    private String layover;
    private CJROrderSummaryOrigin origin;
    private HashMap<String, HopWiseAncillaryItems> passengerAncillaryMap = new HashMap<>();

    public String getArrival_terminal() {
        return this.arrival_terminal;
    }

    public void setArrival_terminal(String str) {
        this.arrival_terminal = str;
    }

    public String getArrival_time_local() {
        return this.arrival_time_local;
    }

    public void setArrival_time_local(String str) {
        this.arrival_time_local = str;
    }

    public String getDeparture_time() {
        return this.departure_time;
    }

    public void setDeparture_time(String str) {
        this.departure_time = str;
    }

    public CJROrderSummaryOrigin getOrigin() {
        return this.origin;
    }

    public void setOrigin(CJROrderSummaryOrigin cJROrderSummaryOrigin) {
        this.origin = cJROrderSummaryOrigin;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClass(String str) {
        this.classType = str;
    }

    public String getFlight_no() {
        return this.flight_no;
    }

    public void setFlight_no(String str) {
        this.flight_no = str;
    }

    public CJROrderSummaryDestination getDestination() {
        return this.destination;
    }

    public void setDestination(CJROrderSummaryDestination cJROrderSummaryDestination) {
        this.destination = cJROrderSummaryDestination;
    }

    public String getLayover() {
        return this.layover;
    }

    public void setLayover(String str) {
        this.layover = str;
    }

    public String getArrival_time() {
        return this.arrival_time;
    }

    public void setArrival_time(String str) {
        this.arrival_time = str;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public String getAirline_code() {
        return this.airline_code;
    }

    public void setAirline_code(String str) {
        this.airline_code = str;
    }

    public String getAirline_color_code() {
        return this.airline_color_code;
    }

    public void setAirline_color_code(String str) {
        this.airline_color_code = str;
    }

    public String getDeparture_terminal() {
        return this.departure_terminal;
    }

    public void setDeparture_terminal(String str) {
        this.departure_terminal = str;
    }

    public String getAirline() {
        return this.airline;
    }

    public void setAirline(String str) {
        this.airline = str;
    }

    public String getDeparture_time_local() {
        return this.departure_time_local;
    }

    public void setDeparture_time_local(String str) {
        this.departure_time_local = str;
    }

    public boolean isPassengerAncillaryMapEmpty() {
        return this.passengerAncillaryMap.keySet().size() <= 0;
    }

    public HashMap<String, HopWiseAncillaryItems> getHpWiseAncillariesMap() {
        return this.passengerAncillaryMap;
    }

    public HopWiseAncillaryItems getPassengerWiseAncillary(String str) {
        return this.passengerAncillaryMap.get(str);
    }

    public void setPassengerWiseAncillary(String str, CJROrderSummaryItems cJROrderSummaryItems) {
        if (this.passengerAncillaryMap.get(str) != null) {
            CJROrderSummaryItems cJROrderSummaryItems2 = null;
            if (cJROrderSummaryItems.getAncillary_category().equalsIgnoreCase("food")) {
                Iterator<CJROrderSummaryItems> it2 = this.passengerAncillaryMap.get(str).getMealsAncillary().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJROrderSummaryItems next = it2.next();
                    if (next.getAncillary_code().equalsIgnoreCase(cJROrderSummaryItems.getAncillary_code())) {
                        cJROrderSummaryItems2 = next;
                        break;
                    }
                }
                if (cJROrderSummaryItems2 != null) {
                    cJROrderSummaryItems2.sameTypeAncillaryCount++;
                } else {
                    this.passengerAncillaryMap.get(str).setMealsAncillary(cJROrderSummaryItems);
                }
            } else {
                Iterator<CJROrderSummaryItems> it3 = this.passengerAncillaryMap.get(str).getBaggageAncillary().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    CJROrderSummaryItems next2 = it3.next();
                    if (next2.getAncillary_code().equalsIgnoreCase(cJROrderSummaryItems.getAncillary_code())) {
                        cJROrderSummaryItems2 = next2;
                        break;
                    }
                }
                if (cJROrderSummaryItems2 != null) {
                    cJROrderSummaryItems2.sameTypeAncillaryCount++;
                } else {
                    this.passengerAncillaryMap.get(str).setBaggageAncillary(cJROrderSummaryItems);
                }
            }
        } else {
            HopWiseAncillaryItems hopWiseAncillaryItems = new HopWiseAncillaryItems();
            if (cJROrderSummaryItems.getAncillary_category().equalsIgnoreCase("food")) {
                hopWiseAncillaryItems.setMealsAncillary(cJROrderSummaryItems);
                this.passengerAncillaryMap.put(str, hopWiseAncillaryItems);
                return;
            }
            hopWiseAncillaryItems.setBaggageAncillary(cJROrderSummaryItems);
            this.passengerAncillaryMap.put(str, hopWiseAncillaryItems);
        }
    }

    public static class HopWiseAncillaryItems implements IJRDataModel {
        private ArrayList<CJROrderSummaryItems> baggageAncillary = new ArrayList<>();
        private ArrayList<CJROrderSummaryItems> mealsAncillary = new ArrayList<>();

        public ArrayList<CJROrderSummaryItems> getBaggageAncillary() {
            return this.baggageAncillary;
        }

        public void setBaggageAncillary(CJROrderSummaryItems cJROrderSummaryItems) {
            this.baggageAncillary.add(cJROrderSummaryItems);
        }

        public ArrayList<CJROrderSummaryItems> getMealsAncillary() {
            return this.mealsAncillary;
        }

        public void setMealsAncillary(CJROrderSummaryItems cJROrderSummaryItems) {
            this.mealsAncillary.add(cJROrderSummaryItems);
        }
    }
}
