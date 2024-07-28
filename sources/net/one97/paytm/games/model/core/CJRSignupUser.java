package net.one97.paytm.games.model.core;

import com.google.gson.a.c;
import net.one97.paytm.games.model.GpCommonBaseResponse;

public class CJRSignupUser extends GpCommonBaseResponse {
    @c(a = "access_token")
    public String access_token;
    @c(a = "customer_id")
    public String customer_id;
    @c(a = "masked_msisdn")
    public String masked_msisdn;
    @c(a = "user_id")
    public String user_id;
}
