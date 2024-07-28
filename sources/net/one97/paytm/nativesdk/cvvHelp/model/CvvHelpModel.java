package net.one97.paytm.nativesdk.cvvHelp.model;

import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public class CvvHelpModel implements BaseDataModel {
    private Boolean amexCard;
    private String description;
    private String title;

    public CvvHelpModel(String str, String str2, Boolean bool) {
        this.title = str;
        this.description = str2;
        this.amexCard = bool;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public Boolean getAmexCard() {
        return this.amexCard;
    }

    public void setAmexCard(Boolean bool) {
        this.amexCard = bool;
    }
}
