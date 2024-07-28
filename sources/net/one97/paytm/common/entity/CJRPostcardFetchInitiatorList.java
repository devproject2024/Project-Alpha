package net.one97.paytm.common.entity;

import net.one97.paytm.common.entity.lifafa.SentLifafaResponse;
import net.one97.paytm.common.entity.wallet.postcard.data.ThemesMetaDataModel;

public class CJRPostcardFetchInitiatorList implements IJRDataModel {
    private SentLifafaResponse.SentLifafaList sentLifafaList;
    private ThemesMetaDataModel themesMetaDataModel;

    public SentLifafaResponse.SentLifafaList getSentLifafaList() {
        return this.sentLifafaList;
    }

    public void setSentLifafaList(SentLifafaResponse.SentLifafaList sentLifafaList2) {
        this.sentLifafaList = sentLifafaList2;
    }

    public ThemesMetaDataModel getThemesMetaDataModel() {
        return this.themesMetaDataModel;
    }

    public void setThemesMetaDataModel(ThemesMetaDataModel themesMetaDataModel2) {
        this.themesMetaDataModel = themesMetaDataModel2;
    }
}
