package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class SendMoneyP2PLimitStatusResponseObjectModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "addMoneyDestination")
    private String addMoneyDestination;
    @b(a = "allowedBalance")
    private String allowedBalance;
    @b(a = "currentbalance")
    private String currentbalance;
    @b(a = "isLimitApplicable")
    private boolean isLimitApplicable;
    @b(a = "limitBreachedType")
    private String limitBreachedType;
    @b(a = "limitMessage")
    private String limitMessage;
    @b(a = "maxTxnAmount")
    private String maxTxnAmount;
    @b(a = "message")
    private String message;
    @b(a = "response")
    private Object response;
    @b(a = "trustFactor")
    private String trustFactor;
    @b(a = "walletOperationType")
    private String walletOperationType;
    @b(a = "walletRbiType")
    private String walletRbiType;

    public String getCurrentbalance() {
        return this.currentbalance;
    }

    public void setCurrentbalance(String str) {
        this.currentbalance = str;
    }

    public String getWalletRbiType() {
        return this.walletRbiType;
    }

    public void setWalletRbiType(String str) {
        this.walletRbiType = str;
    }

    public String getTrustFactor() {
        return this.trustFactor;
    }

    public void setTrustFactor(String str) {
        this.trustFactor = str;
    }

    public String getWalletOperationType() {
        return this.walletOperationType;
    }

    public void setWalletOperationType(String str) {
        this.walletOperationType = str;
    }

    public boolean isLimitApplicable() {
        return this.isLimitApplicable;
    }

    public void setLimitApplicable(boolean z) {
        this.isLimitApplicable = z;
    }

    public String getLimitMessage() {
        return this.limitMessage;
    }

    public void setLimitMessage(String str) {
        this.limitMessage = str;
    }

    public String getAllowedBalance() {
        return this.allowedBalance;
    }

    public void setAllowedBalance(String str) {
        this.allowedBalance = str;
    }

    public Object getResponse() {
        return this.response;
    }

    public void setResponse(Object obj) {
        this.response = obj;
    }

    public String getAddMoneyDestination() {
        return this.addMoneyDestination;
    }

    public void setAddMoneyDestination(String str) {
        this.addMoneyDestination = str;
    }

    public String toString() {
        return new f().a((Object) this);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getLimitBreachedType() {
        return this.limitBreachedType;
    }

    public void setLimitBreachedType(String str) {
        this.limitBreachedType = str;
    }

    public String getMaxTxnAmount() {
        return this.maxTxnAmount;
    }

    public void setMaxTxnAmount(String str) {
        this.maxTxnAmount = str;
    }
}
