package net.one97.paytm.addmoney.common.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import net.one97.paytm.common.entity.IJRDataModel;

public class SendMoneyP2PLimitStatusResponseObjectModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "addMoneyDestination")
    private String addMoneyDestination;
    @b(a = "allowedBalance")
    private String allowedBalance;
    @b(a = "currentbalance")
    private String currentbalance;
    @b(a = "isLimitApplicable")
    private boolean isLimitApplicable;
    @b(a = "limitMessage")
    private String limitMessage;
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
}
