package net.one97.paytm.paymentsBank.nach.landing.adapter;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.paymentsBank.model.nach.Payload;

public class SectionListItem extends IJRPaytmDataModel implements IJRDataModel {
    private boolean isSection;
    private Payload payload;
    private String sectionName;

    public SectionListItem(boolean z, String str) {
        this.isSection = z;
        this.sectionName = str;
    }

    public SectionListItem(Payload payload2) {
        this.isSection = this.isSection;
        this.payload = payload2;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    public void setSectionName(String str) {
        this.sectionName = str;
    }

    public boolean isSection() {
        return this.isSection;
    }

    public void setSection(boolean z) {
        this.isSection = z;
    }

    public Payload getPayload() {
        return this.payload;
    }

    public void setPayload(Payload payload2) {
        this.payload = payload2;
    }
}
