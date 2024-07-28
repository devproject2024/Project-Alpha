package net.one97.paytm.common.entity;

import net.one97.paytm.common.entity.lifafa.ReceivedLifafaResponse;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;

public class CJRPostcardFetchRecipientList implements IJRDataModel {
    private ReceivedLifafaResponse.RecievedLifafaDetails recievedLifafaDetails;
    private ThemesMetaDataModel themesMetaDataModel;

    public ThemesMetaDataModel getThemesMetaDataModel() {
        return this.themesMetaDataModel;
    }

    public void setThemesMetaDataModel(ThemesMetaDataModel themesMetaDataModel2) {
        this.themesMetaDataModel = themesMetaDataModel2;
    }

    public ReceivedLifafaResponse.RecievedLifafaDetails getRecievedLifafaDetails() {
        return this.recievedLifafaDetails;
    }

    public void setRecievedLifafaDetails(ReceivedLifafaResponse.RecievedLifafaDetails recievedLifafaDetails2) {
        this.recievedLifafaDetails = recievedLifafaDetails2;
    }
}
