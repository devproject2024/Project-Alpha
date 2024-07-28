package net.one97.paytm.paymentsBank.form15g.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class Form15ghResponceModel extends IJRPaytmDataModel implements Serializable, IJRDataModel {
    @b(a = "ageLimit")
    String ageLimit;
    @b(a = "documentation")
    String documentation;
    @b(a = "errorCode")
    int errorCode;
    @b(a = "errorMessage")
    String errorMessage;
    @b(a = "exemptLimit")
    double exemptLimit;
    @b(a = "formType")
    String formType;
    @b(a = "fullName")
    String fullName;
    @b(a = "interestProjection")
    Double interestProjection;
    @b(a = "maskedPan")
    String maskedPan;
    @b(a = "panVerified")
    Boolean panVerified;

    public String getFormType() {
        return this.formType;
    }

    public void setFormType(String str) {
        this.formType = str;
    }

    public double getExemptLimit() {
        return this.exemptLimit;
    }

    public void setExemptLimit(double d2) {
        this.exemptLimit = d2;
    }

    public double getInterestProjection() {
        return this.interestProjection.doubleValue();
    }

    public void setInterestProjection(double d2) {
        this.interestProjection = Double.valueOf(d2);
    }

    public String getMaskedPan() {
        return this.maskedPan;
    }

    public void setMaskedPan(String str) {
        this.maskedPan = str;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public Boolean getPanVerified() {
        return this.panVerified;
    }

    public void setPanVerified(Boolean bool) {
        this.panVerified = bool;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public void setDocumentation(String str) {
        this.documentation = str;
    }

    public void setInterestProjection(Double d2) {
        this.interestProjection = d2;
    }

    public String getAgeLimit() {
        return this.ageLimit;
    }

    public void setAgeLimit(String str) {
        this.ageLimit = str;
    }
}
