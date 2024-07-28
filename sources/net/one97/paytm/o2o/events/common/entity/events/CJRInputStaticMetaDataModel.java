package net.one97.paytm.o2o.events.common.entity.events;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.events.CJREventPickupAddressInfo;
import net.one97.paytm.common.entity.events.CJREventTicketDeliveryAddress;
import net.one97.paytm.common.entity.events.CJRInputSeatInfo;
import net.one97.paytm.common.entity.events.CJRPrevalidateCartItemModel;
import net.one97.paytm.common.entity.events.CJRSelectedInsiderSeats;
import net.one97.paytm.common.entity.movies.booking.CJRTaxInfo;

public class CJRInputStaticMetaDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String address;
    @b(a = "addressName")
    private String addressName;
    private int age;
    @b(a = "base_price")
    private String base_price;
    @b(a = "bookingId")
    private String bookingId;
    @b(a = "boxOffice")
    private CJREventPickupAddressInfo boxOffice;
    private int cashback_amount;
    @b(a = "category")
    private String category;
    @b(a = "cgst")
    private String cgst;
    @b(a = "citySearched")
    private String citySearched;
    private int city_id;
    private int client_id;
    @b(a = "contact")
    private String contact;
    @b(a = "convFee")
    private String convFee;
    @b(a = "courier")
    private int courier;
    private String customer_id;
    @b(a = "delivery")
    private Integer delivery;
    @b(a = "deliveryAddress")
    private CJREventTicketDeliveryAddress deliveryAddress;
    @b(a = "delivery_charge")
    private double delivery_charge;
    @b(a = "email")
    private String email;
    private String email_id;
    @b(a = "endTime")
    private String endTime;
    private String end_date_time;
    @b(a = "entityCity")
    private String entityCity;
    @b(a = "entityId")
    private String entityId;
    @b(a = "entityName")
    private String entityName;
    @b(a = "entityType")
    private String entityType;
    @b(a = "dateString")
    private String eventDateString;
    @b(a = "eventsCommission")
    private String eventsCommission;
    private String first_name;
    private String gender;
    @b(a = "igst")
    private String igst;
    @b(a = "imageUrl")
    private String imageUrl;
    private List<CJRSelectedInsiderSeats> insiderSeats;
    private int insurance;
    private ArrayList<CJRPrevalidateCartItemModel> insuranceItem;
    private ArrayList<CJRTaxInfo> insuranceTax;
    private int insurance_id;
    private int insured_item_price;
    @b(a = "is_rsvp")
    private String isRsvp;
    private boolean is_ticket;
    @b(a = "krishiKalyanCess")
    private String krishiKalyanCess;
    @b(a = "latitude")
    private String latitude;
    @b(a = "longitude")
    private String longitude;
    @b(a = "mPin")
    private String mPin;
    private int max_claim_amount;
    @b(a = "merchantId")
    private Integer merchantId;
    private long mobile_num;
    private String name;
    private String netInsuranceCgst;
    private String netInsurancePremium;
    private String netInsuranceSgst;
    @b(a = "otherTax")
    private String otherTax;
    @b(a = "passenger")
    private CJRSataticPassengerModel passenger;
    @b(a = "pgCharges")
    private String pgCharges;
    @b(a = "pincode")
    private String pincode;
    private String premium;
    @b(a = "productId")
    private String productId;
    private String promo_code;
    private String promo_description;
    @b(a = "providerId")
    private String providerId;
    @b(a = "providerName")
    private String providerName;
    private String providerSeatId;
    private String request_id;
    @b(a = "sac")
    private String sac;
    @b(a = "seatInfo")
    private ArrayList<CJRInputSeatInfo> seatInfo = new ArrayList<>();
    @b(a = "seatMap")
    private Integer seatMap;
    @b(a = "serviceTax")
    private String serviceTax;
    @b(a = "sgst")
    private String sgst;
    @b(a = "startTime")
    private String startTime;
    private String start_date_time;
    @b(a = "swachBharatCess")
    private String swachBharatCess;
    @b(a = "tcs")
    private Object tcs;
    @b(a = "ticketCount")
    private int ticketCount;
    private String ticket_id;
    @b(a = "totalCGST")
    private String totalCGST;
    @b(a = "totalCommision")
    private String totalCommision;
    @b(a = "totalConvFee")
    private String totalConvFee;
    @b(a = "totalIGST")
    private String totalIGST;
    @b(a = "totalInsurancePremium")
    private String totalInsurancePremium;
    @b(a = "totalKrishiKalyanCess")
    private String totalKrishiKalyanCess;
    @b(a = "totalPgCharges")
    private String totalPgCharges;
    @b(a = "totalSGST")
    private String totalSGST;
    @b(a = "totalServiceTax")
    private String totalServiceTax;
    @b(a = "totalSwachBharatCess")
    private String totalSwachBharatCess;
    @b(a = "totalTicketPrice")
    private String totalTicketPrice;
    private String totalTicketTax;
    private String totalconvFeeCGST;
    private String totalconvFeeSGST;
    private String type;
    private String user_email;
    @b(a = "vertical")
    private String vertical;
    @b(a = "wid")
    private String wid;

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String str) {
        this.entityType = str;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public void setEntityId(String str) {
        this.entityId = str;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String str) {
        this.entityName = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getEventDateString() {
        return this.eventDateString;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public String getAddressName() {
        return this.addressName;
    }

    public void setAddressName(String str) {
        this.addressName = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String str) {
        this.pincode = str;
    }

    public String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(String str) {
        this.providerId = str;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public void setTicketCount(int i2) {
        this.ticketCount = i2;
    }

    public String getTotalTicketPrice() {
        return this.totalTicketPrice;
    }

    public void setTotalTicketPrice(String str) {
        this.totalTicketPrice = str;
    }

    public ArrayList<CJRInputSeatInfo> getseatInfo() {
        return this.seatInfo;
    }

    public void setseatInfo(ArrayList<CJRInputSeatInfo> arrayList) {
        this.seatInfo = arrayList;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public CJRSataticPassengerModel getPassenger() {
        return this.passenger;
    }

    public void setPassenger(CJRSataticPassengerModel cJRSataticPassengerModel) {
        this.passenger = cJRSataticPassengerModel;
    }

    public String getConvFee() {
        return this.convFee;
    }

    public void setConvFee(String str) {
        this.convFee = str;
    }

    public String getCitySearched() {
        return this.citySearched;
    }

    public void setCitySearched(String str) {
        this.citySearched = str;
    }

    public String getEntityCity() {
        return this.entityCity;
    }

    public void setEntityCity(String str) {
        this.entityCity = str;
    }

    public String getVertical() {
        return this.vertical;
    }

    public void setVertical(String str) {
        this.vertical = str;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String str) {
        this.bookingId = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getTotalCommision() {
        return this.totalCommision;
    }

    public void setTotalCommision(String str) {
        this.totalCommision = str;
    }

    public String getTotalConvFee() {
        return this.totalConvFee;
    }

    public void setTotalConvFee(String str) {
        this.totalConvFee = str;
    }

    public String getTotalPgCharges() {
        return this.totalPgCharges;
    }

    public void setTotalPgCharges(String str) {
        this.totalPgCharges = str;
    }

    public String getTotalServiceTax() {
        return this.totalServiceTax;
    }

    public void setTotalServiceTax(String str) {
        this.totalServiceTax = str;
    }

    public String getTotalSwachBharatCess() {
        return this.totalSwachBharatCess;
    }

    public void setTotalSwachBharatCess(String str) {
        this.totalSwachBharatCess = str;
    }

    public String getTotalKrishiKalyanCess() {
        return this.totalKrishiKalyanCess;
    }

    public void setTotalKrishiKalyanCess(String str) {
        this.totalKrishiKalyanCess = str;
    }

    public String getOtherTax() {
        return this.otherTax;
    }

    public void setOtherTax(String str) {
        this.otherTax = str;
    }

    public String getPgCharges() {
        return this.pgCharges;
    }

    public void setPgCharges(String str) {
        this.pgCharges = str;
    }

    public String getServiceTax() {
        return this.serviceTax;
    }

    public void setServiceTax(String str) {
        this.serviceTax = str;
    }

    public String getSwachBharatCess() {
        return this.swachBharatCess;
    }

    public void setSwachBharatCess(String str) {
        this.swachBharatCess = str;
    }

    public String getKrishiKalyanCess() {
        return this.krishiKalyanCess;
    }

    public void setKrishiKalyanCess(String str) {
        this.krishiKalyanCess = str;
    }

    public String getSgst() {
        return this.sgst;
    }

    public void setSgst(String str) {
        this.sgst = str;
    }

    public String getCgst() {
        return this.cgst;
    }

    public void setCgst(String str) {
        this.cgst = str;
    }

    public String getIgst() {
        return this.igst;
    }

    public void setIgst(String str) {
        this.igst = str;
    }

    public String getTotalSGST() {
        return this.totalSGST;
    }

    public void setTotalSGST(String str) {
        this.totalSGST = str;
    }

    public String getTotalCGST() {
        return this.totalCGST;
    }

    public void setTotalCGST(String str) {
        this.totalCGST = str;
    }

    public String getTotalIGST() {
        return this.totalIGST;
    }

    public void setTotalIGST(String str) {
        this.totalIGST = str;
    }

    public String getBase_price() {
        return this.base_price;
    }

    public void setBase_price(String str) {
        this.base_price = str;
    }

    public String getWid() {
        return this.wid;
    }

    public void setWid(String str) {
        this.wid = str;
    }

    public String getSac() {
        return this.sac;
    }

    public void setSac(String str) {
        this.sac = str;
    }

    public String getmPin() {
        return this.mPin;
    }

    public void setmPin(String str) {
        this.mPin = str;
    }

    public Integer getSeatMap() {
        return this.seatMap;
    }

    public void setSeatMap(Integer num) {
        this.seatMap = num;
    }

    public Integer getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(Integer num) {
        this.merchantId = num;
    }

    public void setSelectedInsiderSeat(List<CJRSelectedInsiderSeats> list) {
        this.insiderSeats = list;
    }

    public Integer getDelivery() {
        return this.delivery;
    }

    public void setDelivery(Integer num) {
        this.delivery = num;
    }

    public CJREventTicketDeliveryAddress getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(CJREventTicketDeliveryAddress cJREventTicketDeliveryAddress) {
        this.deliveryAddress = cJREventTicketDeliveryAddress;
    }

    public CJREventPickupAddressInfo getBoxOffice() {
        return this.boxOffice;
    }

    public void setBoxOffice(CJREventPickupAddressInfo cJREventPickupAddressInfo) {
        this.boxOffice = cJREventPickupAddressInfo;
    }

    public double getDeliveryCharge() {
        return this.delivery_charge;
    }

    public void setDeliveryCharge(double d2) {
        this.delivery_charge = d2;
    }

    public int getCourier() {
        return this.courier;
    }

    public void setCourier(int i2) {
        this.courier = i2;
    }

    public String getEventsCommission() {
        return this.eventsCommission;
    }

    public void setEventsCommission(String str) {
        this.eventsCommission = str;
    }

    public int getCity_id() {
        return this.city_id;
    }

    public void setCity_id(int i2) {
        this.city_id = i2;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public void setFirstName(String str) {
        this.first_name = str;
    }

    public long getMobileNum() {
        return this.mobile_num;
    }

    public void setMobileNum(long j) {
        this.mobile_num = j;
    }

    public String getUserEmail() {
        return this.user_email;
    }

    public void setUserEmail(String str) {
        this.user_email = str;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(String str) {
        this.customer_id = str;
    }

    public boolean isIs_ticket() {
        return this.is_ticket;
    }

    public void setIs_ticket(boolean z) {
        this.is_ticket = z;
    }

    public int getInsurance() {
        return this.insurance;
    }

    public void setInsurance(int i2) {
        this.insurance = i2;
    }

    public String getRequestId() {
        return this.request_id;
    }

    public void setRequestId(String str) {
        this.request_id = str;
    }

    public String getPromoCode() {
        return this.promo_code;
    }

    public void setPromoCode(String str) {
        this.promo_code = str;
    }

    public String getPromoDescription() {
        return this.promo_description;
    }

    public void setPromoDescription(String str) {
        this.promo_description = str;
    }

    public int getCashbackAmount() {
        return this.cashback_amount;
    }

    public void setCashbackAmount(int i2) {
        this.cashback_amount = i2;
    }

    public ArrayList<CJRPrevalidateCartItemModel> getInsuranceItem() {
        return this.insuranceItem;
    }

    public void setInsuranceItem(ArrayList<CJRPrevalidateCartItemModel> arrayList) {
        this.insuranceItem = arrayList;
    }

    public String getNetInsuranceCgst() {
        return this.netInsuranceCgst;
    }

    public void setNetInsuranceCgst(String str) {
        this.netInsuranceCgst = str;
    }

    public String getNetInsuranceSgst() {
        return this.netInsuranceSgst;
    }

    public void setNetInsuranceSgst(String str) {
        this.netInsuranceSgst = str;
    }

    public String getNetInsurancePremium() {
        return this.netInsurancePremium;
    }

    public void setNetInsurancePremium(String str) {
        this.netInsurancePremium = str;
    }

    public String getTotalInsurancePremium() {
        return this.totalInsurancePremium;
    }

    public void setTotalInsurancePremium(String str) {
        this.totalInsurancePremium = str;
    }

    public List<CJRSelectedInsiderSeats> getInsiderSeats() {
        return this.insiderSeats;
    }

    public void setInsiderSeats(List<CJRSelectedInsiderSeats> list) {
        this.insiderSeats = list;
    }

    public ArrayList<CJRTaxInfo> getInsuranceTax() {
        return this.insuranceTax;
    }

    public void setInsuranceTax(ArrayList<CJRTaxInfo> arrayList) {
        this.insuranceTax = arrayList;
    }

    public int getClient_id() {
        return this.client_id;
    }

    public void setClient_id(int i2) {
        this.client_id = i2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int i2) {
        this.age = i2;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getEmail_id() {
        return this.email_id;
    }

    public void setEmail_id(String str) {
        this.email_id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getInsurance_id() {
        return this.insurance_id;
    }

    public void setInsurance_id(int i2) {
        this.insurance_id = i2;
    }

    public String getPremium() {
        return this.premium;
    }

    public void setPremium(String str) {
        this.premium = str;
    }

    public int getInsured_item_price() {
        return this.insured_item_price;
    }

    public void setInsured_item_price(int i2) {
        this.insured_item_price = i2;
    }

    public int getMax_claim_amount() {
        return this.max_claim_amount;
    }

    public void setMax_claim_amount(int i2) {
        this.max_claim_amount = i2;
    }

    public String getStart_date_time() {
        return this.start_date_time;
    }

    public void setStart_date_time(String str) {
        this.start_date_time = str;
    }

    public String getEnd_date_time() {
        return this.end_date_time;
    }

    public void setEnd_date_time(String str) {
        this.end_date_time = str;
    }

    public String getTicket_id() {
        return this.ticket_id;
    }

    public void setTicket_id(String str) {
        this.ticket_id = str;
    }

    public String getTotalconvFeeCGST() {
        return this.totalconvFeeCGST;
    }

    public void setTotalconvFeeCGST(String str) {
        this.totalconvFeeCGST = str;
    }

    public String getTotalconvFeeSGST() {
        return this.totalconvFeeSGST;
    }

    public void setTotalconvFeeSGST(String str) {
        this.totalconvFeeSGST = str;
    }

    public String getTotalTicketTax() {
        return this.totalTicketTax;
    }

    public void setTotalTicketTax(String str) {
        this.totalTicketTax = str;
    }

    public void setproviderSeatId(String str) {
        this.providerSeatId = str;
    }

    public String getProviderSeatId() {
        return this.providerSeatId;
    }

    public void setProviderSeatId(String str) {
        this.providerSeatId = str;
    }
}
