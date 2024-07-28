package net.one97.paytm.paymentsBank.slfd.a.a;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONArray;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18944a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f18945d;

    /* renamed from: b  reason: collision with root package name */
    private final a f18946b;

    /* renamed from: c  reason: collision with root package name */
    private final a f18947c;

    public b(a aVar, a aVar2) {
        k.c(aVar, "slfdLocalDataSource");
        k.c(aVar2, "slfdRemoteDataSource");
        this.f18946b = aVar;
        this.f18947c = aVar2;
    }

    public final void f(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.f(str, str2, bVar, aVar);
    }

    public final void e(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.e(str, str2, bVar, aVar);
    }

    public final void d(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.d(str, str2, bVar, aVar);
    }

    public final void c(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "orderId");
        k.c(str2, "accountType");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.c(str, str2, bVar, aVar);
    }

    public final void b(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, StringSet.token);
        k.c(str2, "amt");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.b(str, str2, bVar, aVar);
    }

    public final void b(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "amt");
        k.c(str2, "accountType");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.b(str, str2, str3, bVar, aVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void b(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "fdId");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.b(str, bVar, aVar);
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.a(bVar, aVar);
    }

    public final void b(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.b(bVar, aVar);
    }

    public final void g(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.g(bVar, aVar);
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, int i2) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "status");
        this.f18947c.a(bVar, aVar, str, i2);
    }

    public final void c(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.c(bVar, aVar);
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, String str3) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "productType");
        k.c(str2, "amount");
        k.c(str3, SDKConstants.TXN_TYPE);
        this.f18947c.a(bVar, aVar, str, str2, str3);
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, boolean z, String str3) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "amount");
        k.c(str2, "nomineeId");
        k.c(str3, "txnToken");
        this.f18947c.a(bVar, aVar, str, str2, z, str3);
    }

    public final void a(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "productType");
        k.c(str2, "amount");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.a(str, str2, str3, bVar, aVar);
    }

    public final void a(JSONArray jSONArray, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "amount");
        k.c(str2, "txnToken");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.a(jSONArray, str, str2, bVar, aVar);
    }

    public final void a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "amount");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.a(str, bVar, aVar);
    }

    public final void a(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "orderId");
        k.c(str2, "custId");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.a(str, str2, bVar, aVar);
    }

    public final void a(String str, Double d2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.a(str, d2, bVar, aVar);
    }

    public final void c(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "accNo");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.c(str, bVar, aVar);
    }

    public final void d(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.d(bVar, aVar);
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, ArrayList<PBTncData> arrayList) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(arrayList, "tncDataList");
        this.f18947c.a(bVar, aVar, arrayList);
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "type");
        this.f18947c.a(bVar, aVar, str, str2);
    }

    public final void e(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.e(bVar, aVar);
    }

    public final void f(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        this.f18947c.f(bVar, aVar);
    }

    public final void a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str) {
        k.c(context, "mContext");
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.c(str, "accType");
        this.f18947c.a(context, bVar, aVar, str);
    }
}
