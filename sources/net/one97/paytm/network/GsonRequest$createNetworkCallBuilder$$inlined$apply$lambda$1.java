package net.one97.paytm.network;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.p;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.wallet.R;

public final class GsonRequest$createNetworkCallBuilder$$inlined$apply$lambda$1 extends IJRPaytmDataModel {
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ Map $headers$inlined;
    final /* synthetic */ IJRPaytmDataModel $model$inlined;
    final /* synthetic */ String $url$inlined;
    final /* synthetic */ d this$0;

    GsonRequest$createNetworkCallBuilder$$inlined$apply$lambda$1(d dVar, Context context, String str, Map map, IJRPaytmDataModel iJRPaytmDataModel) {
        this.this$0 = dVar;
        this.$context$inlined = context;
        this.$url$inlined = str;
        this.$headers$inlined = map;
        this.$model$inlined = iJRPaytmDataModel;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        k.c(str, "s");
        k.c(fVar, "gson");
        e eVar = this.this$0.f55777b;
        if (eVar == null) {
            k.a();
        }
        eVar.c(str);
        e eVar2 = this.this$0.f55777b;
        if (eVar2 == null) {
            k.a();
        }
        eVar2.a(Long.valueOf((long) str.length()));
        try {
            if (this.$model$inlined instanceof c) {
                IJRPaytmDataModel parseResponse = this.$model$inlined.parseResponse(str, fVar);
                k.a((Object) parseResponse, "model.parseResponse(s, gson)");
                return parseResponse;
            }
            Object a2 = fVar.a(str, this.$model$inlined.getClass());
            k.a((Object) a2, "gson.fromJson(s, model::class.java)");
            return (IJRPaytmDataModel) a2;
        } catch (p unused) {
            IJRPaytmDataModel parseResponse2 = this.$model$inlined.parseResponse(this.$context$inlined.getString(R.string.err_invalid_api_response), fVar);
            k.a((Object) parseResponse2, "model.parseResponse(msg, gson)");
            return parseResponse2;
        }
    }
}
