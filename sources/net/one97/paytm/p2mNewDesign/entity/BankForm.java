package net.one97.paytm.p2mNewDesign.entity;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class BankForm extends CJRWalletDataModel implements IJRDataModel {
    private String acquirementId;
    private ArrayList<DirectForm> directForms;
    private DisplayField displayField;
    private boolean isForceResendOtp;
    private String pageType;
    private RedirectForm redirectForm;
    private String timeOut;
    private String txnToken;

    public void setTimeOut(String str) {
        this.timeOut = str;
    }

    public String getTimeOut() {
        return this.timeOut;
    }

    public String getAcquirementId() {
        return this.acquirementId;
    }

    public void setAcquirementId(String str) {
        this.acquirementId = str;
    }

    public String getTxnToken() {
        return this.txnToken;
    }

    public void setTxnToken(String str) {
        this.txnToken = str;
    }

    public boolean isForceResendOtp() {
        return this.isForceResendOtp;
    }

    public void setForceResendOtp(boolean z) {
        this.isForceResendOtp = z;
    }

    public ArrayList<DirectForm> getDirectForms() {
        return this.directForms;
    }

    public void setDirectForms(ArrayList<DirectForm> arrayList) {
        this.directForms = arrayList;
    }

    public DisplayField getDisplayField() {
        return this.displayField;
    }

    public void setDisplayField(DisplayField displayField2) {
        this.displayField = displayField2;
    }

    public String getPageType() {
        return this.pageType;
    }

    public void setPageType(String str) {
        this.pageType = str;
    }

    public RedirectForm getRedirectForm() {
        return this.redirectForm;
    }

    public void setRedirectForm(RedirectForm redirectForm2) {
        this.redirectForm = redirectForm2;
    }

    public String toString() {
        return "ClassPojo [pageType = " + this.pageType + ", redirectForm = " + this.redirectForm + "]";
    }
}
