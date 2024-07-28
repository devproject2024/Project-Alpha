package com.business.merchant_payments.payment;

import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.customcards.DynamicCustomCardDataModel;
import java.util.List;
import kotlin.g.b.k;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class CustomCardViewModel$callCustomCardsAPI$1 implements Callback<List<? extends DynamicCustomCardDataModel>> {
    public final /* synthetic */ CustomCardViewModel this$0;

    public CustomCardViewModel$callCustomCardsAPI$1(CustomCardViewModel customCardViewModel) {
        this.this$0 = customCardViewModel;
    }

    public final void onFailure(Call<List<DynamicCustomCardDataModel>> call, Throwable th) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(th, "t");
        this.this$0.getCustomCardAPIData().setValue(b.a(th));
    }

    public final void onResponse(Call<List<DynamicCustomCardDataModel>> call, Response<List<DynamicCustomCardDataModel>> response) {
        k.d(call, H5Event.TYPE_CALL);
        k.d(response, Payload.RESPONSE);
        if (response.isSuccessful()) {
            if (response.body() != null) {
                CustomCardViewModel customCardViewModel = this.this$0;
                List<DynamicCustomCardDataModel> body = response.body();
                k.a((Object) body);
                k.b(body, "response.body()!!");
                customCardViewModel.handleCustomCardResponse(body);
            }
            this.this$0.getCustomCardAPIData().setValue(b.a(response, response.body()));
            return;
        }
        this.this$0.getCustomCardAPIData().setValue(b.b(response, response.body()));
    }
}
