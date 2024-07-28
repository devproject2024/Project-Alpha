package net.one97.paytm.paymentsBank.customer_initiated_cash_withdraw.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;

public class PayTMPartnerListModal extends IJRPaytmDataModel {
    @b(a = "orderId")
    public String orderId;
    @b(a = "response")
    private ArrayList<Response> response = null;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public ArrayList<Response> getResponse() {
        return this.response;
    }

    public void setResponse(ArrayList<Response> arrayList) {
        this.response = arrayList;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public static class CashPointsDetail extends IJRPaytmDataModel {
        @b(a = "address")
        private ArrayList<String> address = null;
        @b(a = "address1")
        private String address1;
        @b(a = "address2")
        private String address2;
        @b(a = "address3")
        private String address3;
        @b(a = "businessName")
        private String businessName;
        @b(a = "category")
        private String category;
        @b(a = "contactNo")
        private List<String> contactNo = null;
        @b(a = "contactPerson")
        private List<String> contactPerson = null;
        @b(a = "displayName")
        private String displayName;
        @b(a = "emailId")
        private List<Object> emailId = null;
        @b(a = "location")
        private Location location;
        @b(a = "logoUrl")
        private String logoUrl;
        @b(a = "pinCode")
        private String pinCode;
        @b(a = "servicesOffered")
        private List<String> servicesOffered = null;
        @b(a = "state")
        private String state;
        @b(a = "subCategory")
        private String subCategory;

        public String getBusinessName() {
            return this.businessName;
        }

        public void setBusinessName(String str) {
            this.businessName = str;
        }

        public List<String> getContactPerson() {
            return this.contactPerson;
        }

        public void setContactPerson(List<String> list) {
            this.contactPerson = list;
        }

        public List<String> getContactNo() {
            return this.contactNo;
        }

        public void setContactNo(List<String> list) {
            this.contactNo = list;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public void setDisplayName(String str) {
            this.displayName = str;
        }

        public List<String> getServicesOffered() {
            return this.servicesOffered;
        }

        public void setServicesOffered(List<String> list) {
            this.servicesOffered = list;
        }

        public List<Object> getEmailId() {
            return this.emailId;
        }

        public void setEmailId(List<Object> list) {
            this.emailId = list;
        }

        public String getLogoUrl() {
            return this.logoUrl;
        }

        public void setLogoUrl(String str) {
            this.logoUrl = str;
        }

        public String getCategory() {
            return this.category;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public String getSubCategory() {
            return this.subCategory;
        }

        public void setSubCategory(String str) {
            this.subCategory = str;
        }

        public ArrayList<String> getAddress() {
            return this.address;
        }

        public void setAddress(ArrayList<String> arrayList) {
            this.address = arrayList;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String str) {
            this.state = str;
        }

        public String getAddress1() {
            return this.address1;
        }

        public void setAddress1(String str) {
            this.address1 = str;
        }

        public String getAddress2() {
            return this.address2;
        }

        public void setAddress2(String str) {
            this.address2 = str;
        }

        public String getAddress3() {
            return this.address3;
        }

        public void setAddress3(String str) {
            this.address3 = str;
        }

        public String getPinCode() {
            return this.pinCode;
        }

        public void setPinCode(String str) {
            this.pinCode = str;
        }

        public Location getLocation() {
            return this.location;
        }

        public void setLocation(Location location2) {
            this.location = location2;
        }
    }

    public static class Location extends IJRPaytmDataModel {
        @b(a = "lat")
        private Double lat;
        @b(a = "lon")
        private Double lon;

        public Double getLat() {
            return this.lat;
        }

        public void setLat(Double d2) {
            this.lat = d2;
        }

        public Double getLon() {
            return this.lon;
        }

        public void setLon(Double d2) {
            this.lon = d2;
        }
    }

    public static class Response extends IJRPaytmDataModel {
        @b(a = "cashPointsDetail")
        private CashPointsDetail cashPointsDetail;
        @b(a = "currentCashPointStatus")
        private String currentCashPointStatus;
        @b(a = "distanceFromLocation")
        private Double distanceFromLocation;
        @b(a = "isFavorite")
        private Boolean isFavorite;

        public CashPointsDetail getCashPointsDetail() {
            return this.cashPointsDetail;
        }

        public void setCashPointsDetail(CashPointsDetail cashPointsDetail2) {
            this.cashPointsDetail = cashPointsDetail2;
        }

        public String getCurrentCashPointStatus() {
            return this.currentCashPointStatus;
        }

        public void setCurrentCashPointStatus(String str) {
            this.currentCashPointStatus = str;
        }

        public Boolean getIsFavorite() {
            return this.isFavorite;
        }

        public void setIsFavorite(Boolean bool) {
            this.isFavorite = bool;
        }

        public Double getDistanceFromLocation() {
            return this.distanceFromLocation;
        }

        public void setDistanceFromLocation(Double d2) {
            this.distanceFromLocation = d2;
        }
    }

    public String toString() {
        return "PayTMPartnerListModal{, orderId='" + this.orderId + '\'' + ", status='" + this.status + '\'' + ", statusCode='" + this.statusCode + '\'' + ", statusMessage='" + this.statusMessage + '\'' + ", response=" + this.response + '}';
    }
}
