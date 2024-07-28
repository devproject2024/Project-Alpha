package net.one97.paytm.bankCommon.model.auth;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public abstract class CJRDataModelItem extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;

    public abstract String getName();
}
