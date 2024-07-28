package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAddress extends IJRPaytmDataModel {
    public static final String RESPONSE_STATUS_FAILURE = "Failure";
    private static final long serialVersionUID = 1;
    @b(a = "ERROR")
    private String ERROR;
    @b(a = "address1")
    private String address1;
    @b(a = "address2")
    private String address2;
    @b(a = "areaName")
    private String areaName;
    @b(a = "areaType")
    private String areaType;
    @b(a = "city")
    private String city;
    @b(a = "country")
    private String country;
    @b(a = "countryCode")
    private String countryCode;
    @b(a = "createTimestamp")
    private String createTimestamp;
    @b(a = "fulladdress")
    private String fulladdress;
    @b(a = "id")
    private String id;
    @b(a = "id_str")
    private String id_str;
    private boolean isChecked;
    @b(a = "isDeleted")
    private boolean isDeleted;
    @b(a = "location")
    private CJRLocation location;
    @b(a = "message")
    private String message;
    @b(a = "mobile")
    private String mobile;
    @b(a = "name")
    private String name;
    @b(a = "pin")
    private String pin;
    @b(a = "priority")
    private int priority;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "state")
    private String state;
    @b(a = "status")
    private String status;
    @b(a = "title")
    private String title;
    @b(a = "type")
    private String type;
    @b(a = "updateTimestamp")
    private String updateTimestamp;
    @b(a = "verificationStatus")
    private String verificationStatus;

    public static String getResponseStatusFailure() {
        return "Failure";
    }

    public static long getSerialVersionUID() {
        return 1;
    }

    public boolean equals(Object obj) {
        try {
            return this.id.equals(((CJRAddress) obj).id);
        } catch (Exception unused) {
            return false;
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getFulladdress() {
        return this.fulladdress;
    }

    public void setFulladdress(String str) {
        this.fulladdress = str;
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

    public String getERROR() {
        return this.ERROR;
    }

    public void setERROR(String str) {
        this.ERROR = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String str) {
        this.pin = str;
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

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean z) {
        this.isDeleted = z;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i2) {
        this.priority = i2;
    }

    public String getId_str() {
        return this.id_str;
    }

    public void setId_str(String str) {
        this.id_str = str;
    }

    public String getVerificationStatus() {
        return this.verificationStatus;
    }

    public void setVerificationStatus(String str) {
        this.verificationStatus = str;
    }

    public String getCreateTimestamp() {
        return this.createTimestamp;
    }

    public void setCreateTimestamp(String str) {
        this.createTimestamp = str;
    }

    public String getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public void setUpdateTimestamp(String str) {
        this.updateTimestamp = str;
    }

    public String getAreaType() {
        return this.areaType;
    }

    public void setAreaType(String str) {
        this.areaType = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CJRLocation getLocation() {
        return this.location;
    }

    public void setLocation(CJRLocation cJRLocation) {
        this.location = cJRLocation;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
