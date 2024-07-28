package net.one97.paytm.recharge.legacy.catalog.model.v2;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRechargeOperatorIconModel implements Comparable<CJRRechargeOperatorIconModel>, IJRDataModel {
    private String iconUrl;
    private String operator;
    private String operatorDisplayName;
    private boolean schedulable;

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setOperatorDisplayName(String str) {
        this.operatorDisplayName = str;
    }

    public String getOperatorDisplayName() {
        return this.operatorDisplayName;
    }

    public boolean isSchedulable() {
        return this.schedulable;
    }

    public void setSchedulable(boolean z) {
        this.schedulable = z;
    }

    public int compareTo(CJRRechargeOperatorIconModel cJRRechargeOperatorIconModel) {
        return this.operator.compareTo(cJRRechargeOperatorIconModel.operator);
    }
}
