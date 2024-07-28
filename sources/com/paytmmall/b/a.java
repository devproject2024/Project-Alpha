package com.paytmmall.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.orflow.Utility;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16033a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f16034b = f16034b;

    private a() {
    }

    public static String a() {
        return f16034b;
    }

    /* renamed from: com.paytmmall.b.a$a  reason: collision with other inner class name */
    public enum C0216a {
        GET(a.C0715a.GET),
        POST(a.C0715a.POST),
        PUT(a.C0715a.PUT);
        
        private final a.C0715a value;

        private C0216a(a.C0715a aVar) {
            this.value = aVar;
        }

        public final a.C0715a getValue() {
            return this.value;
        }
    }

    static final class b extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ String $body;
        final /* synthetic */ b $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ Map $header;
        final /* synthetic */ IJRPaytmDataModel $model;
        final /* synthetic */ C0216a $type;
        final /* synthetic */ String $url;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, b bVar, Context context, C0216a aVar, String str2, Map map, IJRPaytmDataModel iJRPaytmDataModel) {
            super(0);
            this.$url = str;
            this.$callback = bVar;
            this.$context = context;
            this.$type = aVar;
            this.$body = str2;
            this.$header = map;
            this.$model = iJRPaytmDataModel;
        }

        public final void invoke() {
            a aVar = a.f16033a;
            new StringBuilder("MallNetworkManager::performNetworkCall Enter ").append(this.$url);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                com.paytm.network.b c2 = new com.paytm.network.b().a(this.$context).a(this.$type.getValue()).a(this.$url).b(this.$body).a((Map<String, String>) this.$header).a((com.paytm.network.listener.b) new C0217a(this, countDownLatch)).a(this.$model).a(a.b.SILENT).a(a.c.MALL).c(Utility.VERTICAL_NAME_MALL);
                if (!TextUtils.isEmpty(Uri.parse(this.$url).getQueryParameter("client"))) {
                    k.a((Object) c2, "builder");
                    c2.a(false);
                }
                c2.l().a();
                countDownLatch.await();
            } catch (Exception e2) {
                a aVar2 = a.f16033a;
                a.a();
                q.c(e2.getMessage());
                if (((int) countDownLatch.getCount()) == 1) {
                    countDownLatch.countDown();
                }
            }
            a aVar3 = a.f16033a;
            new StringBuilder("MallNetworkManager::performNetworkCall exit ").append(this.$url);
        }

        /* renamed from: com.paytmmall.b.a$b$a  reason: collision with other inner class name */
        public static final class C0217a implements com.paytm.network.listener.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f16035a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CountDownLatch f16036b;

            C0217a(b bVar, CountDownLatch countDownLatch) {
                this.f16035a = bVar;
                this.f16036b = countDownLatch;
            }

            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                a aVar = a.f16033a;
                new StringBuilder("MallNetworkManager::performNetworkCall success ").append(this.f16035a.$url);
                this.f16035a.$callback.onApiSuccess(iJRPaytmDataModel);
                this.f16036b.countDown();
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                a aVar = a.f16033a;
                new StringBuilder("MallNetworkManager::performNetworkCall error ").append(this.f16035a.$url);
                this.f16035a.$callback.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
                this.f16036b.countDown();
            }
        }
    }

    public static final void a(Context context, C0216a aVar, String str, String str2, Map<String, String> map, IJRPaytmDataModel iJRPaytmDataModel, b bVar) {
        k.c(context, "context");
        k.c(aVar, "type");
        k.c(str, "url");
        k.c(iJRPaytmDataModel, "model");
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        com.paytm.utility.d.a.a(new b(str, bVar, context, aVar, str2, map, iJRPaytmDataModel));
    }
}
