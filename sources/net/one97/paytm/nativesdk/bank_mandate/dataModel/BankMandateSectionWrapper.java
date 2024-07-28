package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import net.one97.paytm.nativesdk.common.model.PayChannelOptions;

public class BankMandateSectionWrapper {
    private PayChannelOptions childSections;
    private boolean isSectionHeader;
    private String parentSection;

    public BankMandateSectionWrapper(boolean z, PayChannelOptions payChannelOptions, String str) {
        this.isSectionHeader = z;
        this.childSections = payChannelOptions;
        this.parentSection = str;
    }

    public boolean isSectionHeader() {
        return this.isSectionHeader;
    }

    public PayChannelOptions getChildSections() {
        return this.childSections;
    }

    public String getParentSection() {
        return this.parentSection;
    }

    public void setSectionHeader(boolean z) {
        this.isSectionHeader = z;
    }

    public void setChildSections(PayChannelOptions payChannelOptions) {
        this.childSections = payChannelOptions;
    }

    public void setParentSection(String str) {
        this.parentSection = str;
    }
}
