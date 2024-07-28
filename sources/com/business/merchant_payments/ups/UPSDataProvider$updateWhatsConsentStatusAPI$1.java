package com.business.merchant_payments.ups;

import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.R;
import kotlin.g.a.q;
import kotlin.g.b.k;
import kotlin.k.e;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class UPSDataProvider$updateWhatsConsentStatusAPI$1 implements Callback<UPSResponse> {
    public final /* synthetic */ e $statusRecieved;
    public final /* synthetic */ UPSDataProvider this$0;

    public UPSDataProvider$updateWhatsConsentStatusAPI$1(UPSDataProvider uPSDataProvider, e eVar) {
        this.this$0 = uPSDataProvider;
        this.$statusRecieved = eVar;
    }

    public final void onResponse(Call<UPSResponse> call, Response<UPSResponse> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        this.this$0.handleWhatappSetPrefResponse(response.body(), this.$statusRecieved);
    }

    public final void onFailure(Call<UPSResponse> call, Throwable th) {
        e eVar = this.$statusRecieved;
        if (eVar != null) {
            String string = this.this$0.getApplicationContext().getString(R.string.mp_whatapp_consent_fail_msg);
            k.b(string, "applicationContext.getSt…whatapp_consent_fail_msg)");
            ((q) eVar).invoke(string, Boolean.FALSE, this.this$0.getApplicationContext());
        }
    }
}
