package net.one97.paytm.addmoney.common.model;

import net.one97.paytm.common.entity.IJRDataModel;

public class SourceCardDataModel {
    private IJRDataModel dataModel;
    private boolean isOpenInInnerContainer;
    private SourceCardType type;

    public SourceCardDataModel(IJRDataModel iJRDataModel, SourceCardType sourceCardType) {
        this.dataModel = iJRDataModel;
        this.type = sourceCardType;
    }

    public IJRDataModel getDataModel() {
        return this.dataModel;
    }

    public void setDataModel(IJRDataModel iJRDataModel) {
        this.dataModel = iJRDataModel;
    }

    public SourceCardType getType() {
        return this.type;
    }

    public void setType(SourceCardType sourceCardType) {
        this.type = sourceCardType;
    }

    public boolean isOpenInInnerContainer() {
        return this.isOpenInInnerContainer;
    }

    public void setOpenInInnerContainer(boolean z) {
        this.isOpenInInnerContainer = z;
    }
}
