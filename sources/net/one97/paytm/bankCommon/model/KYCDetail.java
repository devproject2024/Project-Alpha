package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KYCDetail implements Serializable {
    @b(a = "aadhaarOTPRequired")
    private boolean aadhaarOTPRequired;
    @b(a = "action")
    private int action = -1;
    @b(a = "actionAdditionalDetails")
    private ActionAdditionalDetails actionAdditionalDetails;
    @b(a = "kycAddress")
    private List<KycAddDetail> add_details = new ArrayList();
    @b(a = "appointmentDateSlot")
    private String appointmentDateSlot;
    @b(a = "appointmentTimeSlot")
    private String appointmentTimeSlot;
    @b(a = "kycExpired")
    private String isExpired;
    @b(a = "isSync")
    private Boolean isSync;
    @b(a = "kycExpiryTime")
    private String kycExpiryTime;
    @b(a = "leadSource")
    private String leadSource;
    @b(a = "linkedBankAccounts")
    private ArrayList<LinkedBankAccount> linkedBankAccounts = new ArrayList<>();
    @b(a = "name")
    private String name;
    @b(a = "nameAsPerPoi")
    private String nameAsPerPoi;
    @b(a = "poiNumber")
    private String poiNumber;
    @b(a = "poiType")
    private String poiType;
    @b(a = "stage")
    private String stage;
    @b(a = "status")
    private String status;
    @b(a = "subStage")
    private String subStage;
    @b(a = "userDetails")
    private List<KycUserDetails> userDetails = new ArrayList();
    @b(a = "uuid")
    private String uuid;

    public String getExpired() {
        return this.isExpired;
    }

    public void setExpired(String str) {
        this.isExpired = str;
    }

    public List<KycUserDetails> getUserdetails() {
        return this.userDetails;
    }

    public void setUserdetails(List<KycUserDetails> list) {
        this.userDetails = list;
    }

    public String getSubstage() {
        return this.subStage;
    }

    public void setSubstage(String str) {
        this.subStage = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String str) {
        this.stage = str;
    }

    public String getAppointmentTimeSlot() {
        return this.appointmentTimeSlot;
    }

    public String getAppointmentDate() {
        return this.appointmentDateSlot;
    }

    public void setPreferredDate(String str) {
        this.appointmentDateSlot = str;
    }

    public String getPOIType() {
        return this.poiType;
    }

    public void setPOIType(String str) {
        this.poiType = str;
    }

    public String getPoINumber() {
        return this.poiNumber;
    }

    public void setPoINumber(String str) {
        this.poiNumber = str;
    }

    public String getNameAsPerPOI() {
        return this.nameAsPerPoi;
    }

    public void setNameAsPerPOI(String str) {
        this.nameAsPerPoi = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLeadsource() {
        return this.leadSource;
    }

    public void setLeadsource(String str) {
        this.leadSource = str;
    }

    public Boolean getIsSync() {
        return this.isSync;
    }

    public void setIsSync(Boolean bool) {
        this.isSync = bool;
    }

    public List<KycAddDetail> getAddDetails() {
        return this.add_details;
    }

    public void setAddDetails(List<KycAddDetail> list) {
        this.add_details = list;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i2) {
        this.action = i2;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public boolean getAadhaarOTPRequired() {
        return this.aadhaarOTPRequired;
    }

    public void setAadhaarOTPRequired(boolean z) {
        this.aadhaarOTPRequired = z;
    }

    public ActionAdditionalDetails getActionAdditionalDetails() {
        return this.actionAdditionalDetails;
    }

    public void setActionAdditionalDetails(ActionAdditionalDetails actionAdditionalDetails2) {
        this.actionAdditionalDetails = actionAdditionalDetails2;
    }

    public ArrayList<LinkedBankAccount> getLinkedBankAccounts() {
        return this.linkedBankAccounts;
    }

    public void setLinkedBankAccounts(ArrayList<LinkedBankAccount> arrayList) {
        this.linkedBankAccounts = arrayList;
    }

    public String getKycExpiryTime() {
        return this.kycExpiryTime;
    }

    public void setKycExpiryTime(String str) {
        this.kycExpiryTime = str;
    }
}
