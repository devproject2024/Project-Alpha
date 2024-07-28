package com.paytmmall.clpartifact.repositories;

import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.utils.HomeUtils;
import java.util.Map;
import kotlin.g.b.k;

final class HomeRepository$getHomeResponse$1 implements Runnable {
    final /* synthetic */ y $liveData;
    final /* synthetic */ HomeRepository this$0;

    HomeRepository$getHomeResponse$1(HomeRepository homeRepository, y yVar) {
        this.this$0 = homeRepository;
        this.$liveData = yVar;
    }

    public final void run() {
        String url = HomeUtils.getUrl(this.this$0.getContext());
        HomeUtils.d$default("url to be hit ".concat(String.valueOf(url)), false, 2, (Object) null);
        b a2 = new b().a(this.this$0.getContext()).a(a.c.HOME).a(a.C0715a.POST).a(a.b.SILENT).c(this.this$0.getContext().getClass().getSimpleName()).a(url).a((IJRPaytmDataModel) new StringResponseModel()).a((com.paytm.network.listener.b) new HomeRepository$getHomeResponse$1$networkCallBuilder$1(this));
        k.a((Object) a2, "networkCallBuilder");
        a2.a((Map<String, String>) this.this$0.getRequestHeaders());
        a2.b(this.this$0.getRequestBody());
        a l = a2.l();
        l.b(false);
        l.a();
        HomeUtils.d("API hit request put in request Queue", true);
    }
}
