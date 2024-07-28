package net.one97.paytm.p2mNewDesign.entity.singleAPIv2;

import net.one97.paytm.network.CJRWalletDataModel;

public final class VpaDetails extends CJRWalletDataModel {
    private String defaultCreditAccRefId;
    private String defaultDebitAccRefId;
    private String name;
    private Boolean primary = Boolean.FALSE;

    public final String getDefaultCreditAccRefId() {
        return this.defaultCreditAccRefId;
    }

    public final void setDefaultCreditAccRefId(String str) {
        this.defaultCreditAccRefId = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getDefaultDebitAccRefId() {
        return this.defaultDebitAccRefId;
    }

    public final void setDefaultDebitAccRefId(String str) {
        this.defaultDebitAccRefId = str;
    }

    public final Boolean getPrimary() {
        return this.primary;
    }

    public final void setPrimary(Boolean bool) {
        this.primary = bool;
    }

    public final String toString() {
        return "ClassPojo [defaultCreditAccRefId = " + this.defaultCreditAccRefId + ", name = " + this.name + ", defaultDebitAccRefId = " + this.defaultDebitAccRefId + ", primary = " + this.primary + ']';
    }
}
