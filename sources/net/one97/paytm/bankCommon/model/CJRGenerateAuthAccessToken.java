package net.one97.paytm.bankCommon.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRGenerateAuthAccessToken extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "access_token")
    public String access_token;
    @c(a = "code")
    public String code;
    @c(a = "message")
    public String message;
    @c(a = "status")
    public String status;
}
