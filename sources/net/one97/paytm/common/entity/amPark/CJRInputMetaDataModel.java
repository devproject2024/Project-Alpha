package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRInputMetaDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "address")
    private String address;
    @b(a = "addressName")
    private String addressName;
    @b(a = "base_price")
    private String base_price;
    @b(a = "bookingId")
    private String bookingId;
    @b(a = "category")
    private String category;
    @b(a = "cgst")
    private String cgst;
    @b(a = "citySearched")
    private String citySearched;
    @b(a = "contact")
    private String contact;
    @b(a = "convFee")
    private String convFee;
    @b(a = "email")
    private String email;
    @b(a = "endTime")
    private String endTime;
    @b(a = "entityCity")
    private String entityCity;
    @b(a = "entityId")
    private String entityId;
    @b(a = "entityName")
    private String entityName;
    @b(a = "entityType")
    private String entityType;
    @b(a = "igst")
    private String igst;
    @b(a = "imageUrl")
    private String imageUrl;
    @b(a = "is_rsvp")
    private String isRsvp;
    @b(a = "krishiKalyanCess")
    private String krishiKalyanCess;
    @b(a = "latitude")
    private String latitude;
    @b(a = "longitude")
    private String longitude;
    @b(a = "mPin")
    private String mPin;
    @b(a = "merchantId")
    private Integer merchantId;
    @b(a = "otherTax")
    private String otherTax;
    @b(a = "passenger")
    private ArrayList<ArrayList<AmParkInputForm>> passenger = new ArrayList<>();
    @b(a = "pgCharges")
    private String pgCharges;
    @b(a = "pincode")
    private String pincode;
    @b(a = "productId")
    private String productId;
    @b(a = "providerId")
    private String providerId;
    @b(a = "providerName")
    private String providerName;
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
    @b(a = "swachBharatCess")
    private String swachBharatCess;
    @b(a = "tcs")
    private Object tcs;
    @b(a = "ticketCount")
    private int ticketCount;
    @b(a = "totalCGST")
    private String totalCGST;
    @b(a = "totalCommision")
    private String totalCommision;
    @b(a = "totalConvFee")
    private String totalConvFee;
    @b(a = "totalIGST")
    private String totalIGST;
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

    public ArrayList<ArrayList<AmParkInputForm>> getPassenger() {
        return this.passenger;
    }

    public void setPassenger(ArrayList<ArrayList<AmParkInputForm>> arrayList) {
        this.passenger = arrayList;
    }

    public void setPassengerItem(ArrayList<AmParkInputForm> arrayList) {
        this.passenger.add(arrayList);
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
}
