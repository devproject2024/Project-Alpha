package net.one97.paytm.cst.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class WebViewInitialParams implements IJRDataModel {
    @c(a = "cjrOrderQueryReason")
    @a
    private String cjrOrderQueryReason;
    @c(a = "client")
    @a
    private String client;
    @c(a = "cstorderItem")
    @a
    private String cstorderItem;
    @c(a = "deeplink")
    @a
    private String deeplink;
    @c(a = "deviceId")
    @a
    private String deviceId;
    @c(a = "entryPoint")
    @a
    private String entryPoint;
    @c(a = "h5_version")
    @a
    private int h5_version;
    @c(a = "isFromBank")
    @a
    private boolean isFromBank;
    @c(a = "mobileNumber")
    @a
    private String mobileNumber;
    @c(a = "mode_testing")
    @a
    private boolean mode_testing;
    @c(a = "order_details")
    @a
    private OrderDetail orderDetails;
    @c(a = "request_parameters")
    @a
    private String requestParameters;
    @c(a = "response")
    @a
    private Object response;
    @c(a = "selectedIndex")
    @a
    private String selectedIndex;
    @c(a = "source")
    @a
    private String source;
    @c(a = "title")
    @a
    private String title;
    @c(a = "user_first_name")
    @a
    private String user_first_name;
    @c(a = "user_last_name")
    @a
    private String user_last_name;
    @c(a = "verticalParams")
    @a
    private String verticalParams;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getVerticalParams() {
        return this.verticalParams;
    }

    public void setVerticalParams(String str) {
        this.verticalParams = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public String getSelectedIndex() {
        return this.selectedIndex;
    }

    public void setSelectedIndex(String str) {
        this.selectedIndex = str;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public boolean isFromBank() {
        return this.isFromBank;
    }

    public void setFromBank(boolean z) {
        this.isFromBank = z;
    }

    public String getUser_first_name() {
        return this.user_first_name;
    }

    public void setUser_first_name(String str) {
        this.user_first_name = str;
    }

    public String getUser_last_name() {
        return this.user_last_name;
    }

    public void setUser_last_name(String str) {
        this.user_last_name = str;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public boolean isMode_testing() {
        return this.mode_testing;
    }

    public void setMode_testing(boolean z) {
        this.mode_testing = z;
    }

    public int isH5_version() {
        return this.h5_version;
    }

    public void setH5_version(int i2) {
        this.h5_version = i2;
    }

    public String getCstorderItem() {
        return this.cstorderItem;
    }

    public void setCstorderItem(String str) {
        this.cstorderItem = str;
    }

    public String getCjrOrderQueryReason() {
        return this.cjrOrderQueryReason;
    }

    public void setCjrOrderQueryReason(String str) {
        this.cjrOrderQueryReason = str;
    }

    public Object getResponse() {
        return this.response;
    }

    public void setResponse(Object obj) {
        this.response = obj;
    }

    public OrderDetail getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(OrderDetail orderDetail) {
        this.orderDetails = orderDetail;
    }

    public String getEntryPoint() {
        return this.entryPoint;
    }

    public void setEntryPoint(String str) {
        this.entryPoint = str;
    }

    public String getRequestParameters() {
        return this.requestParameters;
    }

    public void setRequestParameters(String str) {
        this.requestParameters = str;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }
}
