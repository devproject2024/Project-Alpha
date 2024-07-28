package net.one97.paytm.network;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.k;
import net.one97.paytm.network.f;
import net.one97.paytm.wallet.communicator.c;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected b f55776a;

    /* renamed from: b  reason: collision with root package name */
    e f55777b;

    /* renamed from: c  reason: collision with root package name */
    final y<f> f55778c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    private com.paytm.network.a f55779d;

    /* renamed from: e  reason: collision with root package name */
    private long f55780e;

    /* access modifiers changed from: protected */
    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map) {
        k.c(iJRPaytmDataModel, "model");
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        Context context = a2.getContext();
        b bVar = new b();
        bVar.a(context);
        bVar.i();
        bVar.a(str);
        bVar.a(map);
        bVar.a(a.c.PAYMENTSBANK);
        bVar.a(a.b.USER_FACING);
        Context context2 = context;
        String str2 = str;
        Map<String, String> map2 = map;
        IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
        bVar.a((IJRPaytmDataModel) new GsonRequest$createNetworkCallBuilder$$inlined$apply$lambda$1(this, context2, str2, map2, iJRPaytmDataModel2));
        bVar.a((com.paytm.network.listener.b) new a(this, context2, str2, map2, iJRPaytmDataModel2));
        this.f55776a = bVar;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55781a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f55782b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f55783c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map f55784d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ IJRPaytmDataModel f55785e;

        a(d dVar, Context context, String str, Map map, IJRPaytmDataModel iJRPaytmDataModel) {
            this.f55781a = dVar;
            this.f55782b = context;
            this.f55783c = str;
            this.f55784d = map;
            this.f55785e = iJRPaytmDataModel;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            d.a(this.f55781a, 200, (NetworkCustomError) null);
            y<f> yVar = this.f55781a.f55778c;
            f.a aVar = f.f55795d;
            yVar.postValue(f.a.a(iJRPaytmDataModel));
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if ((networkResponse != null ? networkResponse.data : null) != null) {
                try {
                    com.google.gsonhtcfix.f fVar = new com.google.gsonhtcfix.f();
                    byte[] bArr = networkCustomError.networkResponse.data;
                    k.a((Object) bArr, "networkCustomError.networkResponse.data");
                    Object a2 = fVar.a(new String(bArr, kotlin.m.d.f47971a), this.f55785e.getClass());
                    k.a((Object) a2, "Gson().fromJson(String(n…data), model::class.java)");
                    iJRPaytmDataModel = (IJRPaytmDataModel) a2;
                } catch (Exception unused) {
                }
            }
            d.a(this.f55781a, i2, networkCustomError);
            if (iJRPaytmDataModel instanceof IJRPaytmDataModel) {
                y<f> yVar = this.f55781a.f55778c;
                f.a aVar = f.f55795d;
                yVar.postValue(f.a.a(i2, iJRPaytmDataModel, networkCustomError));
            }
        }
    }

    public final y<f> c() {
        e eVar;
        if (this.f55779d == null) {
            b bVar = this.f55776a;
            this.f55777b = new e();
            if (!(bVar == null || (eVar = this.f55777b) == null)) {
                eVar.a(new Date());
                eVar.d(bVar.c());
                eVar.a(bVar.b());
                eVar.a(bVar.e());
                eVar.a(bVar.d());
                eVar.b(bVar.k());
            }
            b bVar2 = this.f55776a;
            if (bVar2 == null) {
                k.a();
            }
            this.f55779d = bVar2.l();
        }
        this.f55780e = System.nanoTime();
        com.paytm.network.a aVar = this.f55779d;
        if (aVar == null) {
            k.a();
        }
        aVar.a();
        y<f> yVar = this.f55778c;
        f.a aVar2 = f.f55795d;
        yVar.postValue(f.a.a());
        return this.f55778c;
    }

    /* access modifiers changed from: protected */
    public final void d() {
        com.paytm.network.a aVar = this.f55779d;
        if (aVar != null) {
            if (aVar == null) {
                k.a();
            }
            aVar.b();
        }
    }

    public final void e() {
        b bVar = this.f55776a;
        if (bVar != null) {
            bVar.a(0);
        }
    }

    public final void a(int i2) {
        b bVar = this.f55776a;
        if (bVar != null) {
            bVar.b(i2);
        }
    }

    public static final /* synthetic */ void a(d dVar, int i2, NetworkCustomError networkCustomError) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - dVar.f55780e);
        e eVar = dVar.f55777b;
        if (eVar != null) {
            eVar.b(new Date());
            eVar.b(Long.valueOf(millis));
            if (i2 == 200) {
                eVar.a(Integer.valueOf(i2));
            } else if (networkCustomError != null) {
                eVar.a(Integer.valueOf(networkCustomError.getStatusCode()));
            }
        }
        net.one97.paytm.wallet.communicator.b.a().interceptHttpRequestResponse(dVar.f55777b);
    }
}
