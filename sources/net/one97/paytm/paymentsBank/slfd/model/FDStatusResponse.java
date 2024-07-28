package net.one97.paytm.paymentsBank.slfd.model;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public final class FDStatusResponse extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "balanceErrorMessage")
    @a
    private Object balanceErrorMessage;
    @c(a = "balanceStatusCode")
    @a
    private Integer balanceStatusCode;
    @c(a = "cifErrorMessage")
    @a
    private Object cifErrorMessage;
    @c(a = "cifStatusCode")
    @a
    private Integer cifStatusCode;
    @c(a = "maxThreshold")
    @a
    private Long maxThreshold;
    @c(a = "minThreshold")
    @a
    private Long minThreshold;
    @c(a = "onBoardedOn")
    @a
    private String onBoardedOn;
    @c(a = "onBoardingStatus")
    @a
    private String onBoardingStatus;
    @c(a = "preferenceAmount")
    @a
    private Double preferenceAmount;
    @c(a = "preferenceSiId")
    @a
    private Integer preferenceSiId = -1;
    @c(a = "preferenceStatus")
    @a
    private String preferenceStatus;
    @c(a = "transactionErrorMessage")
    @a
    private Object transactionErrorMessage;
    @c(a = "transactionStatusCode")
    @a
    private Integer transactionStatusCode;
    @c(a = "userType")
    @a
    private String userType;

    public final String getOnBoardingStatus() {
        return this.onBoardingStatus;
    }

    public final void setOnBoardingStatus(String str) {
        this.onBoardingStatus = str;
    }

    public final String getOnBoardedOn() {
        return this.onBoardedOn;
    }

    public final void setOnBoardedOn(String str) {
        this.onBoardedOn = str;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final void setUserType(String str) {
        this.userType = str;
    }

    public final Integer getCifStatusCode() {
        return this.cifStatusCode;
    }

    public final void setCifStatusCode(Integer num) {
        this.cifStatusCode = num;
    }

    public final Object getCifErrorMessage() {
        return this.cifErrorMessage;
    }

    public final void setCifErrorMessage(Object obj) {
        this.cifErrorMessage = obj;
    }

    public final Integer getBalanceStatusCode() {
        return this.balanceStatusCode;
    }

    public final void setBalanceStatusCode(Integer num) {
        this.balanceStatusCode = num;
    }

    public final Object getBalanceErrorMessage() {
        return this.balanceErrorMessage;
    }

    public final void setBalanceErrorMessage(Object obj) {
        this.balanceErrorMessage = obj;
    }

    public final Integer getTransactionStatusCode() {
        return this.transactionStatusCode;
    }

    public final void setTransactionStatusCode(Integer num) {
        this.transactionStatusCode = num;
    }

    public final Object getTransactionErrorMessage() {
        return this.transactionErrorMessage;
    }

    public final void setTransactionErrorMessage(Object obj) {
        this.transactionErrorMessage = obj;
    }

    public final Long getMaxThreshold() {
        return this.maxThreshold;
    }

    public final void setMaxThreshold(Long l) {
        this.maxThreshold = l;
    }

    public final Long getMinThreshold() {
        return this.minThreshold;
    }

    public final void setMinThreshold(Long l) {
        this.minThreshold = l;
    }

    public final Double getPreferenceAmount() {
        return this.preferenceAmount;
    }

    public final void setPreferenceAmount(Double d2) {
        this.preferenceAmount = d2;
    }

    public final Integer getPreferenceSiId() {
        return this.preferenceSiId;
    }

    public final void setPreferenceSiId(Integer num) {
        this.preferenceSiId = num;
    }

    public final String getPreferenceStatus() {
        return this.preferenceStatus;
    }

    public final void setPreferenceStatus(String str) {
        this.preferenceStatus = str;
    }
}
