package net.one97.paytm.common.entity.offline_pg.paymethodresponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class AddMoneyPayMethod implements IJRDataModel {
    private Map<String, Object> additionalProperties = new HashMap();
    private BalanceInfo balanceInfo;
    private String displayName;
    private IsDisabled isDisabled;
    private List<PayChannelOption> payChannelOptions = null;
    private String payMethod;

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public List<PayChannelOption> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public void setPayChannelOptions(List<PayChannelOption> list) {
        this.payChannelOptions = list;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public BalanceInfo getBalanceInfo() {
        return this.balanceInfo;
    }

    public void setBalanceInfo(BalanceInfo balanceInfo2) {
        this.balanceInfo = balanceInfo2;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
