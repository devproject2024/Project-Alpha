package net.one97.paytm.common.entity.hotels;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRHotelsUtmParams implements IJRDataModel {
    private String mPushUtmSource;
    private String mUtmCampaign;
    private String mUtmContent;
    private String mUtmMedium;
    private String mUtmTerm;

    public CJRHotelsUtmParams() {
    }

    public CJRHotelsUtmParams(CJRHotelsUtmParams cJRHotelsUtmParams) {
        if (cJRHotelsUtmParams != null) {
            this.mPushUtmSource = cJRHotelsUtmParams.getUtmSource();
            this.mUtmCampaign = cJRHotelsUtmParams.getUtmCampaign();
            this.mUtmContent = cJRHotelsUtmParams.getUtmContent();
            this.mUtmMedium = cJRHotelsUtmParams.getUtmMedium();
            this.mUtmTerm = cJRHotelsUtmParams.getUtmTerm();
        }
    }

    public String getUtmMedium() {
        return this.mUtmMedium;
    }

    public void setUtmMedium(String str) {
        this.mUtmMedium = str;
    }

    public String getUtmContent() {
        return this.mUtmContent;
    }

    public void setUtmContent(String str) {
        this.mUtmContent = str;
    }

    public String getUtmTerm() {
        return this.mUtmTerm;
    }

    public void setUtmTerm(String str) {
        this.mUtmTerm = str;
    }

    public String getUtmCampaign() {
        return this.mUtmCampaign;
    }

    public void setUtmCampaign(String str) {
        this.mUtmCampaign = str;
    }

    public String getUtmSource() {
        return this.mPushUtmSource;
    }

    public void setPushUtmSource(String str) {
        this.mPushUtmSource = str;
    }
}
