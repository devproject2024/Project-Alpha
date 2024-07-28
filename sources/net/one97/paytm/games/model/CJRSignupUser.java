package net.one97.paytm.games.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSignupUser extends IJRPaytmDataModel {
    @c(a = "access_token")
    public String access_token;
    @c(a = "code")
    public String code;
    @c(a = "customer_id")
    public String customer_id;
    @c(a = "masked_msisdn")
    public String masked_msisdn;
    @c(a = "message")
    public String message;
    @c(a = "status")
    public String status;
    @c(a = "user_id")
    public String user_id;
}
