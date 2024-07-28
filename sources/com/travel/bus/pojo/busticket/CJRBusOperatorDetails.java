package com.travel.bus.pojo.busticket;

import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;

public class CJRBusOperatorDetails extends IJRPaytmDataModel {
    @com.google.gsonhtcfix.a.b(a = "boarding_coordinates")
    private a boardingCoordinates;
    @com.google.gsonhtcfix.a.b(a = "driver_details")
    private c busDriverDetails;

    public static class d {
        @com.google.gsonhtcfix.a.b(a = "lat")
        @com.google.gson.a.a

        /* renamed from: a  reason: collision with root package name */
        public Object f22784a;
        @com.google.gsonhtcfix.a.b(a = "lng")
        @com.google.gson.a.a

        /* renamed from: b  reason: collision with root package name */
        public Object f22785b;
    }

    public c getBusDriverDetails() {
        return this.busDriverDetails;
    }

    public void setBusDriverDetails(c cVar) {
        this.busDriverDetails = cVar;
    }

    public a getBoardingCoordinates() {
        return this.boardingCoordinates;
    }

    public void setBoardingCoordinates(a aVar) {
        this.boardingCoordinates = aVar;
    }

    public static class a implements Serializable {
        @com.google.gsonhtcfix.a.b(a = "Return")
        @com.google.gson.a.a
        private d _return;
        @com.google.gsonhtcfix.a.b(a = "Onward")
        @com.google.gson.a.a
        private d onward;

        public d getOnward() {
            return this.onward;
        }

        public void setOnward(d dVar) {
            this.onward = dVar;
        }

        public d getReturn() {
            return this._return;
        }

        public void setReturn(d dVar) {
            this._return = dVar;
        }
    }

    public static class c implements Serializable {
        @com.google.gsonhtcfix.a.b(a = "Onward")
        private b onwardJourney;
        @com.google.gsonhtcfix.a.b(a = "Return")
        private b returnJourney;

        public final b getOnwardJourney() {
            return this.onwardJourney;
        }

        public final void setOnwardJourney(b bVar) {
            this.onwardJourney = bVar;
        }

        public final b getReturnJourney() {
            return this.returnJourney;
        }

        public final void setReturnJourney(b bVar) {
            this.returnJourney = bVar;
        }
    }

    public static class b implements Serializable {
        @com.google.gsonhtcfix.a.b(a = "bus_number")
        private String busNumber;
        @com.google.gsonhtcfix.a.b(a = "driver_names")
        private String driverNames;
        @com.google.gsonhtcfix.a.b(a = "driver_phones")
        private String driverPhones;
        @com.google.gsonhtcfix.a.b(a = "provider_id")
        private Integer providerId;
        @com.google.gsonhtcfix.a.b(a = "provider_trip_id")
        private String providerTripId;

        public Integer getProviderId() {
            return this.providerId;
        }

        public void setProviderId(Integer num) {
            this.providerId = num;
        }

        public String getProviderTripId() {
            return this.providerTripId;
        }

        public void setProviderTripId(String str) {
            this.providerTripId = str;
        }

        public String getBusNumber() {
            return this.busNumber;
        }

        public void setBusNumber(String str) {
            this.busNumber = str;
        }

        public String getDriverNames() {
            return this.driverNames;
        }

        public void setDriverNames(String str) {
            this.driverNames = str;
        }

        public String getDriverPhones() {
            return this.driverPhones;
        }

        public void setDriverPhones(String str) {
            this.driverPhones = str;
        }
    }
}
