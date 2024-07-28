package net.one97.paytm.common.entity.offline_pg.paymethodresponse;

import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class BalanceInfo implements IJRDataModel {
    private AccountBalance accountBalance;
    private Map<String, Object> additionalProperties = new HashMap();
    private ExtendInfo extendInfo;
    private boolean isPayerAccountExists;
    private String payerAccountNo;

    public boolean isPayerAccountExists() {
        return this.isPayerAccountExists;
    }

    public void setPayerAccountExists(boolean z) {
        this.isPayerAccountExists = z;
    }

    public String getPayerAccountNo() {
        return this.payerAccountNo;
    }

    public void setPayerAccountNo(String str) {
        this.payerAccountNo = str;
    }

    public AccountBalance getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(AccountBalance accountBalance2) {
        this.accountBalance = accountBalance2;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }
}
