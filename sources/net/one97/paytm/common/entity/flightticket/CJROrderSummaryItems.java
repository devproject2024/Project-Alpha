package net.one97.paytm.common.entity.flightticket;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROrderSummaryItems implements IJRDataModel {
    private String action;
    private ArrayList<CJROrderSummaryAction> actions;
    private String addon_tnc;
    private String addon_type;
    private String adults;
    private String ancillary_baggage_unit;
    private long ancillary_baggage_weight;
    private String ancillary_category;
    private String ancillary_code;
    private int ancillary_id;
    private String ancillary_name;
    private String ancillary_sub_category;
    private String baggage_policy;
    private String base_fare;
    private String booking_class;
    private String booking_type;
    private String cancellation_policy;
    private String cancellation_protect_bought;
    private String cancellation_protect_eligibility;
    private String cart_checkout_time;
    private CJROrderSummaryCashback[] cashback;
    private String cashback_credited;
    private String cashback_credited_text;
    private String cashback_text;
    private String children;
    private CJROrderSummaryContactInfo contact_info;
    private String convenience_fee;
    private String destination;
    private String destination_airport;
    private String destination_city;
    private String destination_country;
    private String destination_iata;
    private String direction;
    private String f_Dir;
    private String fare_class;
    private CJROrderSummaryFareDetails fare_details;
    private String fare_type;
    private CJROrderSummaryFulfillment fulfillment;
    private String hand_baggage_fare;
    private String id;
    private String infants;
    private CJROrderSummaryInfoObj infoObj;
    private String insurance_id;
    private String insurance_provider;
    private String insurance_type;
    private String ios_pass;
    private boolean isAllSelected;
    private String is_combination;
    private String is_international;
    private String is_multi_provider;
    private String is_refundable;
    private String is_roundtrip;
    private String item_type;
    private CJROrderSummaryJourneyDetails journey_details;
    private String max_extend_sla;
    private String merchant_id;
    private String name;
    private String number_of_hops;
    private String number_of_passengers;
    private String number_of_segments;
    private String onward_airline_type;
    private String onward_product_id;
    private String onward_provider;
    private String onward_service_operator;
    private String order_id;
    private String origin_airport;
    private String origin_city;
    private String origin_country;
    private String origin_iata;
    private String parent_vertical;
    private String parent_vertical_label;
    private CJROrderSummaryPaxInfo pax_info;
    private String paytm_cashback;
    private String price;
    private CJROrderSummaryProductDetail product;
    private String promo_code;
    private String promo_text;
    private int quantity;
    private String requestid;
    private String return_flow;
    private String route;
    public int sameTypeAncillaryCount = 1;
    private String source;
    private int status;
    private String status_text;
    private CJROrderSummaryAction tap_action;
    private String taxes;
    private String title;
    private String total_cashback;
    private String total_price;
    private String travel_date;
    private String travel_insurance_bought;
    private String travel_insurance_eligibility;
    private String trip_type;
    private String type;

    public CJROrderSummaryFulfillment getFulfillment() {
        return this.fulfillment;
    }

    public void setFulfillment(CJROrderSummaryFulfillment cJROrderSummaryFulfillment) {
        this.fulfillment = cJROrderSummaryFulfillment;
    }

    public String getConvenience_fee() {
        return this.convenience_fee;
    }

    public void setConvenience_fee(String str) {
        this.convenience_fee = str;
    }

    public String getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(String str) {
        this.total_price = str;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getIos_pass() {
        return this.ios_pass;
    }

    public void setIos_pass(String str) {
        this.ios_pass = str;
    }

    public String getIs_combination() {
        return this.is_combination;
    }

    public void setIs_combination(String str) {
        this.is_combination = str;
    }

    public String getTrip_type() {
        return this.trip_type;
    }

    public void setTrip_type(String str) {
        this.trip_type = str;
    }

    public String getAdults() {
        return this.adults;
    }

    public void setAdults(String str) {
        this.adults = str;
    }

    public String getTravel_date() {
        return this.travel_date;
    }

    public void setTravel_date(String str) {
        this.travel_date = str;
    }

    public String getOnward_service_operator() {
        return this.onward_service_operator;
    }

    public void setOnward_service_operator(String str) {
        this.onward_service_operator = str;
    }

    public String getDestination_airport() {
        return this.destination_airport;
    }

    public void setDestination_airport(String str) {
        this.destination_airport = str;
    }

    public String getNumber_of_hops() {
        return this.number_of_hops;
    }

    public void setNumber_of_hops(String str) {
        this.number_of_hops = str;
    }

    public String getPromo_code() {
        return this.promo_code;
    }

    public void setPromo_code(String str) {
        this.promo_code = str;
    }

    public String getF_Dir() {
        return this.f_Dir;
    }

    public void setF_Dir(String str) {
        this.f_Dir = str;
    }

    public String getOnward_airline_type() {
        return this.onward_airline_type;
    }

    public void setOnward_airline_type(String str) {
        this.onward_airline_type = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getPromo_text() {
        return this.promo_text;
    }

    public void setPromo_text(String str) {
        this.promo_text = str;
    }

    public String getOrigin_iata() {
        return this.origin_iata;
    }

    public void setOrigin_iata(String str) {
        this.origin_iata = str;
    }

    public CJROrderSummaryAction getTap_action() {
        return this.tap_action;
    }

    public ArrayList<CJROrderSummaryAction> getAction() {
        return this.actions;
    }

    public void setAction(ArrayList<CJROrderSummaryAction> arrayList) {
        this.actions = arrayList;
    }

    public void setTap_action(CJROrderSummaryAction cJROrderSummaryAction) {
        this.tap_action = cJROrderSummaryAction;
    }

    public String getIs_international() {
        return this.is_international;
    }

    public void setIs_international(String str) {
        this.is_international = str;
    }

    public String getDestination_country() {
        return this.destination_country;
    }

    public void setDestination_country(String str) {
        this.destination_country = str;
    }

    public String getOnward_provider() {
        return this.onward_provider;
    }

    public void setOnward_provider(String str) {
        this.onward_provider = str;
    }

    public String getIs_refundable() {
        return this.is_refundable;
    }

    public void setIs_refundable(String str) {
        this.is_refundable = str;
    }

    public String getTotal_cashback() {
        return this.total_cashback;
    }

    public void setTotal_cashback(String str) {
        this.total_cashback = str;
    }

    public String getCancellation_policy() {
        return this.cancellation_policy;
    }

    public void setCancellation_policy(String str) {
        this.cancellation_policy = str;
    }

    public String getItem_type() {
        return this.item_type;
    }

    public void setItem_type(String str) {
        this.item_type = str;
    }

    public String getOrigin_city() {
        return this.origin_city;
    }

    public void setOrigin_city(String str) {
        this.origin_city = str;
    }

    public CJROrderSummaryInfoObj getInfoObj() {
        return this.infoObj;
    }

    public void setInfoObj(CJROrderSummaryInfoObj cJROrderSummaryInfoObj) {
        this.infoObj = cJROrderSummaryInfoObj;
    }

    public String getCashback_credited_text() {
        return this.cashback_credited_text;
    }

    public void setCashback_credited_text(String str) {
        this.cashback_credited_text = str;
    }

    public String getNumber_of_passengers() {
        return this.number_of_passengers;
    }

    public void setNumber_of_passengers(String str) {
        this.number_of_passengers = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String getCancellation_protect_bought() {
        return this.cancellation_protect_bought;
    }

    public void setCancellation_protect_bought(String str) {
        this.cancellation_protect_bought = str;
    }

    public String getPaytm_cashback() {
        return this.paytm_cashback;
    }

    public void setPaytm_cashback(String str) {
        this.paytm_cashback = str;
    }

    public String getHand_baggage_fare() {
        return this.hand_baggage_fare;
    }

    public void setHand_baggage_fare(String str) {
        this.hand_baggage_fare = str;
    }

    public CJROrderSummaryCashback[] getCashback() {
        return this.cashback;
    }

    public void setCashback(CJROrderSummaryCashback[] cJROrderSummaryCashbackArr) {
        this.cashback = cJROrderSummaryCashbackArr;
    }

    public String getRequestid() {
        return this.requestid;
    }

    public void setRequestid(String str) {
        this.requestid = str;
    }

    public String getMax_extend_sla() {
        return this.max_extend_sla;
    }

    public void setMax_extend_sla(String str) {
        this.max_extend_sla = str;
    }

    public String getIs_multi_provider() {
        return this.is_multi_provider;
    }

    public void setIs_multi_provider(String str) {
        this.is_multi_provider = str;
    }

    public String getNumber_of_segments() {
        return this.number_of_segments;
    }

    public void setNumber_of_segments(String str) {
        this.number_of_segments = str;
    }

    public String getOrigin_airport() {
        return this.origin_airport;
    }

    public void setOrigin_airport(String str) {
        this.origin_airport = str;
    }

    public String getCart_checkout_time() {
        return this.cart_checkout_time;
    }

    public void setCart_checkout_time(String str) {
        this.cart_checkout_time = str;
    }

    public CJROrderSummaryPaxInfo getPax_info() {
        return this.pax_info;
    }

    public void setPax_info(CJROrderSummaryPaxInfo cJROrderSummaryPaxInfo) {
        this.pax_info = cJROrderSummaryPaxInfo;
    }

    public String getChildren() {
        return this.children;
    }

    public void setChildren(String str) {
        this.children = str;
    }

    public String getTravel_insurance_eligibility() {
        return this.travel_insurance_eligibility;
    }

    public void setTravel_insurance_eligibility(String str) {
        this.travel_insurance_eligibility = str;
    }

    public String getTravel_insurance_bought() {
        return this.travel_insurance_bought;
    }

    public void setTravel_insurance_bought(String str) {
        this.travel_insurance_bought = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getDestination_city() {
        return this.destination_city;
    }

    public void setDestination_city(String str) {
        this.destination_city = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getInfants() {
        return this.infants;
    }

    public void setInfants(String str) {
        this.infants = str;
    }

    public String getMerchant_id() {
        return this.merchant_id;
    }

    public void setMerchant_id(String str) {
        this.merchant_id = str;
    }

    public String getParent_vertical_label() {
        return this.parent_vertical_label;
    }

    public void setParent_vertical_label(String str) {
        this.parent_vertical_label = str;
    }

    public String getCancellation_protect_eligibility() {
        return this.cancellation_protect_eligibility;
    }

    public void setCancellation_protect_eligibility(String str) {
        this.cancellation_protect_eligibility = str;
    }

    public String getCashback_text() {
        return this.cashback_text;
    }

    public void setCashback_text(String str) {
        this.cashback_text = str;
    }

    public String getCashback_credited() {
        return this.cashback_credited;
    }

    public void setCashback_credited(String str) {
        this.cashback_credited = str;
    }

    public CJROrderSummaryContactInfo getContact_info() {
        return this.contact_info;
    }

    public void setContact_info(CJROrderSummaryContactInfo cJROrderSummaryContactInfo) {
        this.contact_info = cJROrderSummaryContactInfo;
    }

    public CJROrderSummaryFareDetails getFare_details() {
        return this.fare_details;
    }

    public void setFare_details(CJROrderSummaryFareDetails cJROrderSummaryFareDetails) {
        this.fare_details = cJROrderSummaryFareDetails;
    }

    public String getParent_vertical() {
        return this.parent_vertical;
    }

    public void setParent_vertical(String str) {
        this.parent_vertical = str;
    }

    public String getBooking_class() {
        return this.booking_class;
    }

    public void setBooking_class(String str) {
        this.booking_class = str;
    }

    public String getOrigin_country() {
        return this.origin_country;
    }

    public void setOrigin_country(String str) {
        this.origin_country = str;
    }

    public String getOnward_product_id() {
        return this.onward_product_id;
    }

    public void setOnward_product_id(String str) {
        this.onward_product_id = str;
    }

    public String getFare_type() {
        return this.fare_type;
    }

    public void setFare_type(String str) {
        this.fare_type = str;
    }

    public String getBase_fare() {
        return this.base_fare;
    }

    public void setBase_fare(String str) {
        this.base_fare = str;
    }

    public String getFare_class() {
        return this.fare_class;
    }

    public void setFare_class(String str) {
        this.fare_class = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public CJROrderSummaryJourneyDetails getJourney_details() {
        return this.journey_details;
    }

    public void setJourney_details(CJROrderSummaryJourneyDetails cJROrderSummaryJourneyDetails) {
        this.journey_details = cJROrderSummaryJourneyDetails;
    }

    public String getBaggage_policy() {
        return this.baggage_policy;
    }

    public void setBaggage_policy(String str) {
        this.baggage_policy = str;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String str) {
        this.route = str;
    }

    public String getBooking_type() {
        return this.booking_type;
    }

    public void setBooking_type(String str) {
        this.booking_type = str;
    }

    public String getIs_roundtrip() {
        return this.is_roundtrip;
    }

    public void setIs_roundtrip(String str) {
        this.is_roundtrip = str;
    }

    public String getReturn_flow() {
        return this.return_flow;
    }

    public void setReturn_flow(String str) {
        this.return_flow = str;
    }

    public String getDestination_iata() {
        return this.destination_iata;
    }

    public void setDestination_iata(String str) {
        this.destination_iata = str;
    }

    public String getTaxes() {
        return this.taxes;
    }

    public void setTaxes(String str) {
        this.taxes = str;
    }

    public String getInsurance_id() {
        return this.insurance_id;
    }

    public void setInsurance_id(String str) {
        this.insurance_id = str;
    }

    public String getInsurance_type() {
        return this.insurance_type;
    }

    public void setInsurance_type(String str) {
        this.insurance_type = str;
    }

    public String getInsurance_provider() {
        return this.insurance_provider;
    }

    public void setInsurance_provider(String str) {
        this.insurance_provider = str;
    }

    public String getAddon_type() {
        return this.addon_type;
    }

    public void setAddon_type(String str) {
        this.addon_type = str;
    }

    public String getAddon_tnc() {
        return this.addon_tnc;
    }

    public void setAddon_tnc(String str) {
        this.addon_tnc = str;
    }

    public CJROrderSummaryProductDetail getProduct() {
        return this.product;
    }

    public void setProduct(CJROrderSummaryProductDetail cJROrderSummaryProductDetail) {
        this.product = cJROrderSummaryProductDetail;
    }

    public void setOrderId(String str) {
        this.order_id = str;
    }

    public String getOrderId() {
        return this.order_id;
    }

    public void setAllItemsSelected(boolean z) {
        this.isAllSelected = z;
    }

    public boolean getAllItemsSelected() {
        return this.isAllSelected;
    }

    public String getAncillary_category() {
        return this.ancillary_category;
    }

    public void setAncillary_category(String str) {
        this.ancillary_category = str;
    }

    public int getAncillary_id() {
        return this.ancillary_id;
    }

    public void setAncillary_id(int i2) {
        this.ancillary_id = i2;
    }

    public String getAncillary_code() {
        return this.ancillary_code;
    }

    public void setAncillary_code(String str) {
        this.ancillary_code = str;
    }

    public String getAncillary_name() {
        return this.ancillary_name;
    }

    public void setAncillary_name(String str) {
        this.ancillary_name = str;
    }

    public String getAncillary_sub_category() {
        return this.ancillary_sub_category;
    }

    public void setAncillary_sub_category(String str) {
        this.ancillary_sub_category = str;
    }

    public long getAncillary_baggage_weight() {
        return this.ancillary_baggage_weight;
    }

    public void setAncillary_baggage_weight(long j) {
        this.ancillary_baggage_weight = j;
    }

    public String getAncillary_baggage_unit() {
        return this.ancillary_baggage_unit;
    }

    public void setAncillary_baggage_unit(String str) {
        this.ancillary_baggage_unit = str;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public String getStatus_text() {
        return this.status_text;
    }

    public void setStatus_text(String str) {
        this.status_text = str;
    }
}
