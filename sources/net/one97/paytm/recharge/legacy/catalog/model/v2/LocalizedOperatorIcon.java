package net.one97.paytm.recharge.legacy.catalog.model.v2;

import net.one97.paytm.common.entity.IJRDataModel;

public class LocalizedOperatorIcon implements IJRDataModel {
    private String operatorDisplayName;
    private String operatorIconUrl;
    private boolean schedulable;

    public String getOperatorDisplayName() {
        return this.operatorDisplayName;
    }

    public void setOperatorDisplayName(String str) {
        this.operatorDisplayName = str;
    }

    public String getOperatorIconUrl() {
        return this.operatorIconUrl;
    }

    public void setOperatorIconUrl(String str) {
        this.operatorIconUrl = str;
    }

    public boolean isSchedulable() {
        return this.schedulable;
    }

    public void setSchedulable(boolean z) {
        this.schedulable = z;
    }
}
