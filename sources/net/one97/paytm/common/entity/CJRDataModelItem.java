package net.one97.paytm.common.entity;

import com.paytm.network.model.IJRPaytmDataModel;

public abstract class CJRDataModelItem extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;

    public abstract String getName();
}
