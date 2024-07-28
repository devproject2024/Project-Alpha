package com.paytm.network.retrofit;

import com.google.gsonhtcfix.o;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public final class RetrofitCall {
    static final /* synthetic */ i[] $$delegatedProperties = {y.a((v) new w(y.b(RetrofitCall.class), "errorApi", "getErrorApi()Lcom/paytm/network/retrofit/ErrorAPI;"))};
    /* access modifiers changed from: private */
    public final String TAG = "RetrofitCall";
    private final g errorApi$delegate = h.a(RetrofitCall$errorApi$2.INSTANCE);

    public final ErrorAPI getErrorApi() {
        return (ErrorAPI) this.errorApi$delegate.getValue();
    }

    public final void errorApiCall(String str, o oVar) {
        k.c(str, "url");
        k.c(oVar, "errorLoggingModel");
        if (validate(oVar)) {
            getErrorApi().errorApiCall(str, oVar).enqueue(new RetrofitCall$errorApiCall$1(this));
        }
    }

    public final boolean validate(o oVar) {
        k.c(oVar, "errorLoggingModel");
        return oVar.a("apiUrl") && oVar.a("vertical") && oVar.a(CLConstants.FIELD_ERROR_CODE);
    }
}
