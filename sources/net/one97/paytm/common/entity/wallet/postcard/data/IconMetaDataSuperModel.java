package net.one97.paytm.common.entity.wallet.postcard.data;

import net.one97.paytm.common.entity.IJRDataModel;

public class IconMetaDataSuperModel implements IJRDataModel {
    private IconMetaDataModel iconMetaDataModel;
    private String imageUrl;
    private int itemNumber;

    public IconMetaDataSuperModel(IconMetaDataModel iconMetaDataModel2, int i2, String str) {
        this.iconMetaDataModel = iconMetaDataModel2;
        this.itemNumber = i2;
        this.imageUrl = str;
    }

    public IconMetaDataModel getIconMetaDataModel() {
        return this.iconMetaDataModel;
    }

    public int getItemNumber() {
        return this.itemNumber;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
}
