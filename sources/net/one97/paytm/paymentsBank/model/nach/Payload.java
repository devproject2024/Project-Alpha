package net.one97.paytm.paymentsBank.model.nach;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class Payload extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "accountHolderName")
    private String accountHolderName;
    @b(a = "accountNumber")
    private String accountNumber;
    @b(a = "accountType")
    private String accountType;
    @b(a = "amend")
    private Boolean amend;
    @b(a = "corporate")
    private String corporate;
    @b(a = "currentAmount")
    private String currentAmount;
    @b(a = "currentAmountType")
    private String currentAmountType;
    @b(a = "currentCustomerReferenceNumber")
    private String currentCustomerReferenceNumber;
    @b(a = "currentEmail")
    private String currentEmail;
    @b(a = "currentEndDate")
    private String currentEndDate;
    @b(a = "currentFrequency")
    private String currentFrequency;
    @b(a = "currentLandline")
    private String currentLandline;
    @b(a = "currentMobile")
    private String currentMobile;
    @b(a = "currentRecurringCode")
    private String currentRecurringCode;
    @b(a = "currentScheme")
    private String currentScheme;
    @b(a = "currentStartDate")
    private String currentStartDate;
    @b(a = "dataOfConsent")
    private String dataOfConsent;
    @b(a = "newAmount")
    private String newAmount;
    @b(a = "newAmountType")
    private String newAmountType;
    @b(a = "newCustomerReferenceNumber")
    private String newCustomerReferenceNumber;
    @b(a = "newEmail")
    private String newEmail;
    @b(a = "newEndDate")
    private String newEndDate;
    @b(a = "newFrequency")
    private String newFrequency;
    @b(a = "newLandline")
    private String newLandline;
    @b(a = "newMobile")
    private String newMobile;
    @b(a = "newRecurringCode")
    private String newRecurringCode;
    @b(a = "newScheme")
    private String newScheme;
    @b(a = "newStartDate")
    private String newStartDate;
    @b(a = "status")
    private String status;
    @b(a = "umrn")
    private String umrn;

    public String getUmrn() {
        return this.umrn;
    }

    public void setUmrn(String str) {
        this.umrn = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public String getCurrentAmount() {
        return this.currentAmount;
    }

    public void setCurrentAmount(String str) {
        this.currentAmount = str;
    }

    public String getCurrentFrequency() {
        return this.currentFrequency;
    }

    public void setCurrentFrequency(String str) {
        this.currentFrequency = str;
    }

    public String getCurrentAmountType() {
        return this.currentAmountType;
    }

    public void setCurrentAmountType(String str) {
        this.currentAmountType = str;
    }

    public String getCurrentStartDate() {
        return this.currentStartDate;
    }

    public void setCurrentStartDate(String str) {
        this.currentStartDate = str;
    }

    public String getCurrentEndDate() {
        return this.currentEndDate;
    }

    public void setCurrentEndDate(String str) {
        this.currentEndDate = str;
    }

    public String getCurrentRecurringCode() {
        return this.currentRecurringCode;
    }

    public void setCurrentRecurringCode(String str) {
        this.currentRecurringCode = str;
    }

    public String getCurrentLandline() {
        return this.currentLandline;
    }

    public void setCurrentLandline(String str) {
        this.currentLandline = str;
    }

    public String getCurrentMobile() {
        return this.currentMobile;
    }

    public void setCurrentMobile(String str) {
        this.currentMobile = str;
    }

    public String getCurrentScheme() {
        return this.currentScheme;
    }

    public void setCurrentScheme(String str) {
        this.currentScheme = str;
    }

    public String getCurrentCustomerReferenceNumber() {
        return this.currentCustomerReferenceNumber;
    }

    public void setCurrentCustomerReferenceNumber(String str) {
        this.currentCustomerReferenceNumber = str;
    }

    public String getCurrentEmail() {
        return this.currentEmail;
    }

    public void setCurrentEmail(String str) {
        this.currentEmail = str;
    }

    public String getNewAmount() {
        return this.newAmount;
    }

    public void setNewAmount(String str) {
        this.newAmount = str;
    }

    public String getNewFrequency() {
        return this.newFrequency;
    }

    public void setNewFrequency(String str) {
        this.newFrequency = str;
    }

    public String getNewAmountType() {
        return this.newAmountType;
    }

    public void setNewAmountType(String str) {
        this.newAmountType = str;
    }

    public String getNewStartDate() {
        return this.newStartDate;
    }

    public void setNewStartDate(String str) {
        this.newStartDate = str;
    }

    public String getNewEndDate() {
        return this.newEndDate;
    }

    public void setNewEndDate(String str) {
        this.newEndDate = str;
    }

    public String getNewRecurringCode() {
        return this.newRecurringCode;
    }

    public void setNewRecurringCode(String str) {
        this.newRecurringCode = str;
    }

    public String getNewLandline() {
        return this.newLandline;
    }

    public void setNewLandline(String str) {
        this.newLandline = str;
    }

    public String getNewMobile() {
        return this.newMobile;
    }

    public void setNewMobile(String str) {
        this.newMobile = str;
    }

    public String getNewScheme() {
        return this.newScheme;
    }

    public void setNewScheme(String str) {
        this.newScheme = str;
    }

    public String getNewCustomerReferenceNumber() {
        return this.newCustomerReferenceNumber;
    }

    public void setNewCustomerReferenceNumber(String str) {
        this.newCustomerReferenceNumber = str;
    }

    public String getNewEmail() {
        return this.newEmail;
    }

    public void setNewEmail(String str) {
        this.newEmail = str;
    }

    public String getCorporate() {
        return this.corporate;
    }

    public void setCorporate(String str) {
        this.corporate = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public String getDataOfConsent() {
        return this.dataOfConsent;
    }

    public void setDataOfConsent(String str) {
        this.dataOfConsent = str;
    }

    public Boolean getAmend() {
        return this.amend;
    }

    public void setAmend(Boolean bool) {
        this.amend = bool;
    }
}
