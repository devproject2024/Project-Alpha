package net.one97.paytm.recharge.domain.entities;

import androidx.databinding.ObservableBoolean;

public class SectionWrapper {
    private CJRPayChannelOptions childSections;
    public ObservableBoolean greenTickVisible = new ObservableBoolean(false);
    private boolean isSectionHeader;
    private String parentSection;

    public SectionWrapper(boolean z, CJRPayChannelOptions cJRPayChannelOptions, String str) {
        this.isSectionHeader = z;
        this.childSections = cJRPayChannelOptions;
        this.parentSection = str;
    }

    public boolean isSectionHeader() {
        return this.isSectionHeader;
    }

    public CJRPayChannelOptions getChildSections() {
        return this.childSections;
    }

    public String getParentSection() {
        return this.parentSection;
    }

    public void setSectionHeader(boolean z) {
        this.isSectionHeader = z;
    }

    public void setChildSections(CJRPayChannelOptions cJRPayChannelOptions) {
        this.childSections = cJRPayChannelOptions;
    }

    public void setParentSection(String str) {
        this.parentSection = str;
    }
}
