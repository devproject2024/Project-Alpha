package net.one97.paytm.bankCommon.model;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class SetPasscodeModel extends IJRPaytmDataModel implements IJRDataModel {
    public String message;
    public String responseCode;
    public String status = "";
}
