package net.one97.paytm.acceptPayment.storefront;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.j;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.f.b;
import net.one97.paytm.acceptPayment.model.RequestData;
import net.one97.paytm.acceptPayment.utils.d;

public final class c extends b {

    static final /* synthetic */ class a extends j implements m<com.paytm.network.listener.b, RequestData, com.paytm.network.a> {
        a(d dVar) {
            super(2, dVar, d.class, "getStoreFrontRequest", "getStoreFrontRequest(Lcom/paytm/network/listener/PaytmCommonApiListener;Lnet/one97/paytm/acceptPayment/model/RequestData;)Lcom/paytm/network/CJRCommonNetworkCall;", 0);
        }

        public final com.paytm.network.a invoke(com.paytm.network.listener.b bVar, RequestData requestData) {
            k.d(bVar, "p1");
            k.d(requestData, "p2");
            k.d(bVar, "listener");
            k.d(requestData, H5RpcPlugin.RpcRequest.RpcParam.REQUEST_DATA);
            String url = requestData.getUrl();
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", requestData.getScreenName());
            hashMap.put(AppConstants.TAG_DEVICE, "android");
            net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
            k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
            hashMap.put(AppConstants.TAG_RESOLUTION, String.valueOf(com.paytm.utility.b.U(b2.a())));
            return net.one97.paytm.acceptPayment.utils.a.a(a.C0715a.POST, url, new SFData(), bVar, d.a(), a.b.SILENT, hashMap);
        }
    }
}
