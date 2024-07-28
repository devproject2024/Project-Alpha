package net.one97.paytm.acceptPayment.f;

import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import java.util.HashMap;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.j;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.model.DownloadSettlement;
import net.one97.paytm.acceptPayment.model.ForceUpdateResponseModel;
import net.one97.paytm.acceptPayment.model.RequestData;
import net.one97.paytm.acceptPayment.model.Result;
import net.one97.paytm.acceptPayment.utils.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends b {

    public static final /* synthetic */ class c extends j implements m<com.paytm.network.listener.b, String, com.paytm.network.a> {
        public c(d dVar) {
            super(2, dVar, d.class, "getUmpMerchantRequest", "getUmpMerchantRequest(Lcom/paytm/network/listener/PaytmCommonApiListener;Ljava/lang/String;)Lcom/paytm/network/CJRCommonNetworkCall;", 0);
        }

        public final com.paytm.network.a invoke(com.paytm.network.listener.b bVar, String str) {
            k.d(bVar, "p1");
            k.d(str, "p2");
            return d.a(bVar, str);
        }
    }

    public static final /* synthetic */ class b extends j implements m<com.paytm.network.listener.b, String, com.paytm.network.a> {
        public b(d dVar) {
            super(2, dVar, d.class, "getForceUpdateAPI", "getForceUpdateAPI(Lcom/paytm/network/listener/PaytmCommonApiListener;Ljava/lang/String;)Lcom/paytm/network/CJRCommonNetworkCall;", 0);
        }

        public final com.paytm.network.a invoke(com.paytm.network.listener.b bVar, String str) {
            k.d(bVar, "p1");
            k.d(str, "p2");
            k.d(bVar, "listener");
            k.d(str, SDKConstants.EVENT_KEY_SCREEN_NAME);
            StringBuilder sb = new StringBuilder();
            k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
            sb.append(net.one97.paytm.acceptPayment.b.b.e());
            k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
            sb.append(net.one97.paytm.acceptPayment.b.b.g());
            String sb2 = sb.toString();
            HashMap<String, String> b2 = d.b();
            HashMap hashMap = new HashMap();
            hashMap.put("source", "CAPP_ANDROID");
            hashMap.put("merchantType", net.one97.paytm.acceptPayment.d.a.f52050a.t());
            return net.one97.paytm.acceptPayment.utils.a.a(a.C0715a.GET, sb2, new ForceUpdateResponseModel((String) null, (String) null, (Result) null, 7, (g) null), bVar, b2, hashMap);
        }
    }

    /* renamed from: net.one97.paytm.acceptPayment.f.a$a  reason: collision with other inner class name */
    public static final /* synthetic */ class C0929a extends j implements m<com.paytm.network.listener.b, RequestData, com.paytm.network.a> {
        public C0929a(d dVar) {
            super(2, dVar, d.class, "getDownloadStatementRequest", "getDownloadStatementRequest(Lcom/paytm/network/listener/PaytmCommonApiListener;Lnet/one97/paytm/acceptPayment/model/RequestData;)Lcom/paytm/network/CJRCommonNetworkCall;", 0);
        }

        public final com.paytm.network.a invoke(com.paytm.network.listener.b bVar, RequestData requestData) {
            k.d(bVar, "p1");
            k.d(requestData, "p2");
            k.d(bVar, "listener");
            k.d(requestData, H5RpcPlugin.RpcRequest.RpcParam.REQUEST_DATA);
            k.b(net.one97.paytm.acceptPayment.b.b.a(), "GTMHelper.getInstance()");
            String i2 = net.one97.paytm.acceptPayment.b.b.i();
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", requestData.getScreenName());
            return net.one97.paytm.acceptPayment.utils.a.a(a.C0715a.POST, i2, new DownloadSettlement(), bVar, d.b(), String.valueOf(requestData.getAdditionParams()), a.b.SILENT, hashMap);
        }
    }
}
