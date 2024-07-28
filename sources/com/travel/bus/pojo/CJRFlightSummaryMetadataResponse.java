package com.travel.bus.pojo;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRFlightSummaryMetadataResponse implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    @b(a = "addon_type")
    private String addonType;
    @b(a = "adults")
    private String adults;
    @b(a = "selected_ancillary")
    private boolean ancillarySelected;
    @b(a = "booking_class")
    private String bookingClass;
    @b(a = "booking_type")
    private String bookingType;
    @b(a = "children")
    private String children;
    @b(a = "commissionable_value")
    private String commissionableValue;
    @b(a = "contact_email")
    private String contactEmail;
    @b(a = "contact_phone")
    private String contactPhone;
    @b(a = "convenience_fee_of_all_items")
    private String convenienceFeeOfAllItems;
    @b(a = "dDF")
    private String dDF;
    @b(a = "departureDate")
    private String departureDate;
    @b(a = "destination")
    private String destination;
    @b(a = "destination_airport")
    private String destinationAirport;
    @b(a = "destination_city")
    private String destinationCity;
    @b(a = "destination_iata")
    private String destinationIata;
    @b(a = "f_Dir")
    private String fDir;
    @b(a = "fare_type")
    private String fareType;
    @b(a = "frequent_flyer")
    private String frequentFlyer;
    @b(a = "infants")
    private String infants;
    @b(a = "insurance_provider")
    private String insuranceProvider;
    @b(a = "tnc")
    private String insuranceTnc;
    @b(a = "insurance_type")
    private String insuranceType;
    @b(a = "item_type")
    private String itemType;
    @b(a = "journey_departure_date")
    private String journey_departure_date;
    @b(a = "journey_return_date")
    private String journey_return_date;
    @b(a = "name")
    private String name;
    @b(a = "number_of_passengers")
    private int numberOfPassengers;
    @b(a = "onward_airline_type")
    private String onwardAirlineType;
    @b(a = "onward_product_id_1")
    private long onwardProductId;
    @b(a = "origin_airport")
    private String originAirport;
    @b(a = "origin_city")
    private String originCity;
    @b(a = "origin_iata")
    private String originIata;
    @b(a = "passenger_age")
    private String passengerAge;
    @b(a = "passenger_dob")
    private String passengerDob;
    @b(a = "passenger_firstname")
    private String passengerFirstname;
    @b(a = "passenger_lastname")
    private String passengerLastname;
    @b(a = "passenger_name")
    private String passengerName;
    @b(a = "passenger_title")
    private String passengerTitle;
    @b(a = "passenger_type")
    private String passengerType;
    @b(a = "paytm_cashback")
    private String paytmCashback;
    @b(a = "provider")
    private String provider;
    @b(a = "return_airline_type")
    private String returnAirlineType;
    @b(a = "return_product_id")
    private String returnProductId;
    @b(a = "return_provider")
    private String returnProvider;
    @b(a = "return_service_operator")
    private String returnServiceOperator;
    @b(a = "route")
    private String route;
    @b(a = "service_operator")
    private String serviceOperator;
    @b(a = "source")
    private String source;
    @b(a = "total_base_of_all_items")
    private String totalBaseOfAllItems;
    @b(a = "total_price_of_all_items")
    private String totalPriceOfAllItems;
    @b(a = "total_tax_of_all_items")
    private String totalTaxOfAllItems;
    @b(a = "travel_date")
    private String travelDate;
    @b(a = "trip_type")
    private String tripType;

    public String getJourney_return_date() {
        return this.journey_return_date;
    }

    public void setJourney_return_date(String str) {
        this.journey_return_date = str;
    }

    public String getJourney_departure_date() {
        return this.journey_departure_date;
    }

    public void setJourney_departure_date(String str) {
        this.journey_departure_date = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public void setPassengerName(String str) {
        this.passengerName = str;
    }

    public String getPassengerType() {
        return this.passengerType;
    }

    public void setPassengerType(String str) {
        this.passengerType = str;
    }

    public String getPassengerFirstname() {
        return this.passengerFirstname;
    }

    public void setPassengerFirstname(String str) {
        this.passengerFirstname = str;
    }

    public String getPassengerLastname() {
        return this.passengerLastname;
    }

    public void setPassengerLastname(String str) {
        this.passengerLastname = str;
    }

    public String getPassengerTitle() {
        return this.passengerTitle;
    }

    public void setPassengerTitle(String str) {
        this.passengerTitle = str;
    }

    public String getPassengerDob() {
        return this.passengerDob;
    }

    public void setPassengerDob(String str) {
        this.passengerDob = str;
    }

    public String getPassengerAge() {
        return this.passengerAge;
    }

    public void setPassengerAge(String str) {
        this.passengerAge = str;
    }

    public String getFrequentFlyer() {
        return this.frequentFlyer;
    }

    public void setFrequentFlyer(String str) {
        this.frequentFlyer = str;
    }

    public String getFareType() {
        return this.fareType;
    }

    public void setFareType(String str) {
        this.fareType = str;
    }

    public String getCommissionableValue() {
        return this.commissionableValue;
    }

    public void setCommissionableValue(String str) {
        this.commissionableValue = str;
    }

    public String getReturnProductId() {
        return this.returnProductId;
    }

    public void setReturnProductId(String str) {
        this.returnProductId = str;
    }

    public long getOnwardProductId() {
        return this.onwardProductId;
    }

    public void setOnwardProductId(long j) {
        this.onwardProductId = j;
    }

    public String getConvenienceFeeOfAllItems() {
        return this.convenienceFeeOfAllItems;
    }

    public void setConvenienceFeeOfAllItems(String str) {
        this.convenienceFeeOfAllItems = str;
    }

    public String getTotalTaxOfAllItems() {
        return this.totalTaxOfAllItems;
    }

    public void setTotalTaxOfAllItems(String str) {
        this.totalTaxOfAllItems = str;
    }

    public String getTotalBaseOfAllItems() {
        return this.totalBaseOfAllItems;
    }

    public void setTotalBaseOfAllItems(String str) {
        this.totalBaseOfAllItems = str;
    }

    public String getTotalPriceOfAllItems() {
        return this.totalPriceOfAllItems;
    }

    public void setTotalPriceOfAllItems(String str) {
        this.totalPriceOfAllItems = str;
    }

    public int getNumberOfPassengers() {
        return this.numberOfPassengers;
    }

    public void setNumberOfPassengers(int i2) {
        this.numberOfPassengers = i2;
    }

    public String getInfants() {
        return this.infants;
    }

    public void setInfants(String str) {
        this.infants = str;
    }

    public String getChildren() {
        return this.children;
    }

    public void setChildren(String str) {
        this.children = str;
    }

    public String getAdults() {
        return this.adults;
    }

    public void setAdults(String str) {
        this.adults = str;
    }

    public String getReturnProvider() {
        return this.returnProvider;
    }

    public void setReturnProvider(String str) {
        this.returnProvider = str;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public String getReturnServiceOperator() {
        return this.returnServiceOperator;
    }

    public void setReturnServiceOperator(String str) {
        this.returnServiceOperator = str;
    }

    public String getServiceOperator() {
        return this.serviceOperator;
    }

    public void setServiceOperator(String str) {
        this.serviceOperator = str;
    }

    public String getReturnAirlineType() {
        return this.returnAirlineType;
    }

    public void setReturnAirlineType(String str) {
        this.returnAirlineType = str;
    }

    public String getOnwardAirlineType() {
        return this.onwardAirlineType;
    }

    public void setOnwardAirlineType(String str) {
        this.onwardAirlineType = str;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String str) {
        this.itemType = str;
    }

    public String getBookingType() {
        return this.bookingType;
    }

    public void setBookingType(String str) {
        this.bookingType = str;
    }

    public String getTripType() {
        return this.tripType;
    }

    public void setTripType(String str) {
        this.tripType = str;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String str) {
        this.route = str;
    }

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String str) {
        this.travelDate = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getfDir() {
        return this.fDir;
    }

    public void setfDir(String str) {
        this.fDir = str;
    }

    public String getdDF() {
        return this.dDF;
    }

    public void setdDF(String str) {
        this.dDF = str;
    }

    public String getDestinationAirport() {
        return this.destinationAirport;
    }

    public void setDestinationAirport(String str) {
        this.destinationAirport = str;
    }

    public String getDestinationCity() {
        return this.destinationCity;
    }

    public void setDestinationCity(String str) {
        this.destinationCity = str;
    }

    public String getDestinationIata() {
        return this.destinationIata;
    }

    public void setDestinationIata(String str) {
        this.destinationIata = str;
    }

    public String getOriginAirport() {
        return this.originAirport;
    }

    public void setOriginAirport(String str) {
        this.originAirport = str;
    }

    public String getOriginCity() {
        return this.originCity;
    }

    public void setOriginCity(String str) {
        this.originCity = str;
    }

    public String getOriginIata() {
        return this.originIata;
    }

    public void setOriginIata(String str) {
        this.originIata = str;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String str) {
        this.contactPhone = str;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String str) {
        this.contactEmail = str;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(String str) {
        this.departureDate = str;
    }

    public String getBookingClass() {
        return this.bookingClass;
    }

    public void setBookingClass(String str) {
        this.bookingClass = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> map) {
        this.additionalProperties = map;
    }

    public String getPaytmCashback() {
        return this.paytmCashback;
    }

    public void setPaytmCashback(String str) {
        this.paytmCashback = str;
    }

    public String getAddonType() {
        return this.addonType;
    }

    public void setAddonType(String str) {
        this.addonType = str;
    }

    public String getInsuranceTnc() {
        return this.insuranceTnc;
    }

    public void setInsuranceTnc(String str) {
        this.insuranceTnc = str;
    }

    public String getInsuranceProvider() {
        return this.insuranceProvider;
    }

    public void setInsuranceProvider(String str) {
        this.insuranceProvider = str;
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    public void setInsuranceType(String str) {
        this.insuranceType = str;
    }

    public boolean isAncillarySelected() {
        return this.ancillarySelected;
    }

    public void setAncillarySelected(boolean z) {
        this.ancillarySelected = z;
    }
}
