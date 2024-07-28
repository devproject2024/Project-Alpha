package net.one97.paytm.addmoney.common.model;

import net.one97.paytm.addmoney.common.b;

public class SectionWrapper {
    private b childSections;
    private boolean isSectionHeader;
    private String parentSection;

    public SectionWrapper(boolean z, b bVar, String str) {
        this.isSectionHeader = z;
        this.childSections = bVar;
        this.parentSection = str;
    }

    public boolean isSectionHeader() {
        return this.isSectionHeader;
    }

    public b getChildSections() {
        return this.childSections;
    }

    public String getParentSection() {
        return this.parentSection;
    }

    public void setSectionHeader(boolean z) {
        this.isSectionHeader = z;
    }

    public void setChildSections(b bVar) {
        this.childSections = bVar;
    }

    public void setParentSection(String str) {
        this.parentSection = str;
    }
}
