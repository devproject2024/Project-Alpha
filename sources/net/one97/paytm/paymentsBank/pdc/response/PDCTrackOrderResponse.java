package net.one97.paytm.paymentsBank.pdc.response;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class PDCTrackOrderResponse extends IJRPaytmDataModel implements IJRDataModel {
    private String itemStatus;
    @b(a = "payload")
    private Payload payload;
    @b(a = "requestId")
    private String requestId;
    @b(a = "responseCode")
    private Integer responseCode;
    @b(a = "responseMessage")
    private String responseMessage;

    public String getItemStatus() {
        return this.itemStatus;
    }

    public void setItemStatus(String str) {
        this.itemStatus = str;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }

    public static class Payload extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "cancellationReason")
        private String cancellationReason;
        @b(a = "courierDetail")
        private CourierDetail courierDetail;
        @b(a = "createdAt")
        private Object createdAt;
        @b(a = "currentStatus")
        private String currentStatus;
        @b(a = "currentStatusId")
        private String currentStatusId;
        @b(a = "deliveredAt")
        private String deliveredAt;
        @b(a = "documentation")
        private String documentation;
        @b(a = "errorCode")
        private String errorCode;
        @b(a = "errorMessage")
        private String errorMessage;
        @b(a = "expectedDateOfDelivery")
        private String expectedDateOfDelivery;
        @b(a = "name")
        private String name;
        @b(a = "orderId")
        private String orderId;
        @b(a = "paymentStatus")
        private String paymentStatus;
        @b(a = "price")
        private Integer price;
        @b(a = "productId")
        private String productId;
        @b(a = "quantity")
        private Integer quantity;
        @b(a = "reIssue")
        private String reIssue;
        @b(a = "statusFlow")
        private List<StatusFlow> statusFlow = null;
        @b(a = "userDetail")
        private UserDetail userDetail;

        public String getDeliveredAt() {
            return this.deliveredAt;
        }

        public void setDeliveredAt(String str) {
            this.deliveredAt = str;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public String getDocumentation() {
            return this.documentation;
        }

        public void setDocumentation(String str) {
            this.documentation = str;
        }

        public String getOrderId() {
            return this.orderId;
        }

        public void setOrderId(String str) {
            this.orderId = str;
        }

        public Integer getPrice() {
            return this.price;
        }

        public void setPrice(Integer num) {
            this.price = num;
        }

        public String getPaymentStatus() {
            return this.paymentStatus;
        }

        public void setPaymentStatus(String str) {
            this.paymentStatus = str;
        }

        public Object getCreatedAt() {
            return this.createdAt;
        }

        public void setCreatedAt(Object obj) {
            this.createdAt = obj;
        }

        public String getExpectedDateOfDelivery() {
            return this.expectedDateOfDelivery;
        }

        public void setExpectedDateOfDelivery(String str) {
            this.expectedDateOfDelivery = str;
        }

        public String getCurrentStatus() {
            return this.currentStatus;
        }

        public void setCurrentStatus(String str) {
            this.currentStatus = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public Integer getQuantity() {
            return this.quantity;
        }

        public void setQuantity(Integer num) {
            this.quantity = num;
        }

        public List<StatusFlow> getStatusFlow() {
            return this.statusFlow;
        }

        public void setStatusFlow(List<StatusFlow> list) {
            this.statusFlow = list;
        }

        public UserDetail getUserDetail() {
            return this.userDetail;
        }

        public void setUserDetail(UserDetail userDetail2) {
            this.userDetail = userDetail2;
        }

        public CourierDetail getCourierDetail() {
            return this.courierDetail;
        }

        public void setCourierDetail(CourierDetail courierDetail2) {
            this.courierDetail = courierDetail2;
        }

        public String getProductId() {
            return this.productId;
        }

        public void setProductId(String str) {
            this.productId = str;
        }

        public String getReIssue() {
            return this.reIssue;
        }

        public void setReIssue(String str) {
            this.reIssue = str;
        }

        public String getCurrentStatusId() {
            return this.currentStatusId;
        }

        public void setCurrentStatusId(String str) {
            this.currentStatusId = str;
        }

        public String getCancellationReason() {
            return this.cancellationReason;
        }

        public void setCancellationReason(String str) {
            this.cancellationReason = str;
        }
    }

    public static class StatusFlow extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "actions")
        private List<Action> actions;
        @b(a = "created_at")
        private String date;
        @b(a = "text")
        private String label;
        @b(a = "status_detail_txt")
        private String statusDetailTxt;
        @b(a = "id")
        private int statusId;

        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public String getDate() {
            return this.date;
        }

        public void setDate(String str) {
            this.date = str;
        }

        public int getStatusId() {
            return this.statusId;
        }

        public void setStatusId(int i2) {
            this.statusId = i2;
        }

        public List<Action> getActions() {
            return this.actions;
        }

        public void setActions(List<Action> list) {
            this.actions = list;
        }

        public String getStatusDetailTxt() {
            return this.statusDetailTxt;
        }

        public void setStatusDetailTxt(String str) {
            this.statusDetailTxt = str;
        }
    }

    public static class UserAddress extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "address1")
        private String address1;
        @b(a = "address2")
        private String address2;
        @b(a = "city")
        private String city;
        @b(a = "country")
        private String country;
        @b(a = "countryCode")
        private String countryCode;
        @b(a = "mobile")
        private String mobile;
        @b(a = "name")
        private String name;
        @b(a = "pin")
        private String pin;
        @b(a = "state")
        private String state;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
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

        public String getCity() {
            return this.city;
        }

        public void setCity(String str) {
            this.city = str;
        }

        public String getState() {
            return this.state;
        }

        public void setState(String str) {
            this.state = str;
        }

        public String getPin() {
            return this.pin;
        }

        public void setPin(String str) {
            this.pin = str;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getMobile() {
            return this.mobile;
        }

        public void setMobile(String str) {
            this.mobile = str;
        }
    }

    public static class UserDetail extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "phoneNumber")
        private String phoneNumber;
        @b(a = "userAddress")
        private UserAddress userAddress;

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public UserAddress getUserAddress() {
            return this.userAddress;
        }

        public void setUserAddress(UserAddress userAddress2) {
            this.userAddress = userAddress2;
        }
    }

    public static class CourierDetail extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "shipperName")
        private String shipperName;
        @b(a = "shipperd")
        private String shipperd;
        @b(a = "wayBillNo")
        private String wayBillNo;

        public String getWayBillNo() {
            return this.wayBillNo;
        }

        public void setWayBillNo(String str) {
            this.wayBillNo = str;
        }

        public String getShipperd() {
            return this.shipperd;
        }

        public void setShipperd(String str) {
            this.shipperd = str;
        }

        public String getShipperName() {
            return this.shipperName;
        }

        public void setShipperName(String str) {
            this.shipperName = str;
        }
    }

    public static class Action extends IJRPaytmDataModel implements IJRDataModel {
        @b(a = "description")
        private String errorDescription;
        @b(a = "title")
        private String errorTitle;
        @b(a = "icon_url")
        private String genericActionImage;
        private boolean isError = false;
        @b(a = "label")
        private String label;
        @b(a = "error_text")
        private String mErrorText;
        @b(a = "error_title")
        private String mErrorTitle;
        @b(a = "name")
        private String name;
        @b(a = "type")
        private String type;
        @b(a = "ui_control")
        private String ui_control;

        public String getLabel() {
            return this.label;
        }

        public String getName() {
            return this.name;
        }

        public String getUi_control() {
            return this.ui_control;
        }

        public String getType() {
            return this.type;
        }

        public String getGenericActionImage() {
            return this.genericActionImage;
        }

        public String getErrorTitle() {
            return this.errorTitle;
        }

        public void setErrorTitle(String str) {
            this.errorTitle = str;
        }

        public String getErrorDescription() {
            return this.errorDescription;
        }

        public void setErrorDescription(String str) {
            this.errorDescription = str;
        }

        public boolean isError() {
            return this.isError;
        }

        public void setError(boolean z) {
            this.isError = z;
        }

        public void setLabel(String str) {
            this.label = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getErrorTitleText() {
            return this.mErrorTitle;
        }

        public String getErrorText() {
            return this.mErrorText;
        }
    }
}
