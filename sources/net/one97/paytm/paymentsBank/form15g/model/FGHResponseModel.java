package net.one97.paytm.paymentsBank.form15g.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Serializable;
import net.one97.paytm.common.entity.IJRDataModel;

public class FGHResponseModel extends IJRPaytmDataModel implements Serializable, IJRDataModel {
    @b(a = "aggregateIncome")
    String aggregateIncome;
    @b(a = "currentEstmtIncome")
    String currentEstmtIncome;
    @b(a = "documentation")
    String documentation;
    @b(a = "errorCode")
    int errorCode;
    @b(a = "errorMessage")
    String errorMessage;
    @b(a = "exemptLimit")
    long exemptLimit;
    @b(a = "financialYr")
    String financialYr;
    @b(a = "financialYrEndDate")
    String financialYrEndDate;
    @b(a = "formType")
    String formType;
    @b(a = "fullName")
    String fullName;
    @b(a = "latestAssmntYr")
    String latestAssmntYr;
    @b(a = "maskedPan")
    String maskedPan;
    @b(a = "submittedDate")
    String submittedDate;
    @b(a = "totNumofForm")
    String totNumofForm;
    @b(a = "totalEstmtIncome")
    String totalEstmtIncome;
    @b(a = "updatedDate")
    String updatedDate;
    @b(a = "whthrAccsTotax")
    boolean whthrAccsTotax;

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

    public String getFormtype() {
        return this.formType;
    }

    public void setFormtype(String str) {
        this.formType = str;
    }

    public long getExemptLimit() {
        return this.exemptLimit;
    }

    public void setExemptLimit(long j) {
        this.exemptLimit = j;
    }

    public String getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(String str) {
        this.updatedDate = str;
    }

    public String getSubmittedDate() {
        return this.submittedDate;
    }

    public void setSubmittedDate(String str) {
        this.submittedDate = str;
    }

    public String getFinancialYr() {
        return this.financialYr;
    }

    public void setFinancialYr(String str) {
        this.financialYr = str;
    }

    public String getMaskedPan() {
        return this.maskedPan;
    }

    public void setMaskedPan(String str) {
        this.maskedPan = str;
    }

    public String getCurrentEstmtIncome() {
        return this.currentEstmtIncome;
    }

    public void setCurrentEstmtIncome(String str) {
        this.currentEstmtIncome = str;
    }

    public String getTotalEstmtIncome() {
        return this.totalEstmtIncome;
    }

    public void setTotalEstmtIncome(String str) {
        this.totalEstmtIncome = str;
    }

    public String getLatestAssmntYr() {
        return this.latestAssmntYr;
    }

    public void setLatestAssmntYr(String str) {
        this.latestAssmntYr = str;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public String getTotNumofForm() {
        return this.totNumofForm;
    }

    public void setTotNumofForm(String str) {
        this.totNumofForm = str;
    }

    public String getFormType() {
        return this.formType;
    }

    public void setFormType(String str) {
        this.formType = str;
    }

    public boolean getWhthrAccsTotax() {
        return this.whthrAccsTotax;
    }

    public void setWhthrAccsTotax(boolean z) {
        this.whthrAccsTotax = z;
    }

    public String getAggregateIncome() {
        return this.aggregateIncome;
    }

    public void setAggregateIncome(String str) {
        this.aggregateIncome = str;
    }

    public String getFinancialYrEndDate() {
        return this.financialYrEndDate;
    }

    public void setFinancialYrEndDate(String str) {
        this.financialYrEndDate = str;
    }
}
