package net.one97.paytm.paymentsBank.slfd.a.a.a;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.n;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import org.json.JSONArray;

public final class a implements net.one97.paytm.paymentsBank.slfd.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0326a f18941a = new C0326a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static a f18942c;

    /* renamed from: b  reason: collision with root package name */
    private final Context f18943b;

    public final void a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str) {
        k.c(context, "mContext");
        k.c(bVar, "listener");
        k.c(aVar, "errorListener");
        k.c(str, "accType");
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, int i2) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "status");
    }

    public final void b(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "amt");
        k.c(str2, "accountType");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void b(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, StringSet.token);
        k.c(str2, "amt");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void b(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void c(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "orderId");
        k.c(str2, "accountType");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void c(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void d(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void e(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void f(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public a(Context context) {
        k.c(context, "context");
        this.f18943b = context;
    }

    public final void g(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
    }

    public final void f(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.a.a.a.a$a  reason: collision with other inner class name */
    public static final class C0326a {
        private C0326a() {
        }

        public /* synthetic */ C0326a(byte b2) {
            this();
        }
    }

    public final void a(String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "productType");
        k.c(str2, "amount");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(JSONArray jSONArray, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "amount");
        k.c(str2, "txnToken");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "amount");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void b(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "fdId");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, String str3) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "productType");
        k.c(str2, "amount");
        k.c(str3, SDKConstants.TXN_TYPE);
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, boolean z, String str3) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "amount");
        k.c(str2, "nomineeId");
        k.c(str3, "txnToken");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "orderId");
        k.c(str2, "custId");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void c(String str, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(str, "accNo");
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, Double d2, g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void d(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, ArrayList<PBTncData> arrayList) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(arrayList, "tncDataList");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        k.c(str, "type");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void e(g.b<IJRPaytmDataModel> bVar, g.a aVar) {
        k.c(bVar, "onSuccess");
        k.c(aVar, "onFailure");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }
}
