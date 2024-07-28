package net.one97.paytm.bankCommon.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public abstract class PBCJRDataModelItem extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;

    public abstract String getName();
}
