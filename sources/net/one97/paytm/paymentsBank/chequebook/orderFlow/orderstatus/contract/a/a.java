package net.one97.paytm.paymentsBank.chequebook.orderFlow.orderstatus.contract.a;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.a;
import net.one97.paytm.paymentsBank.chequebook.utils.g;

public final class a implements Response.ErrorListener, Response.Listener<IJRPaytmDataModel>, b, a.C0278a {

    /* renamed from: a  reason: collision with root package name */
    private final String f17673a;

    /* renamed from: b  reason: collision with root package name */
    private final g f17674b;

    /* renamed from: c  reason: collision with root package name */
    private final a.b f17675c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17676d;

    public final void a() {
    }

    public final void b() {
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public final void onErrorResponse(VolleyError volleyError) {
    }

    public final /* bridge */ /* synthetic */ void onResponse(Object obj) {
    }

    public a(g gVar, a.b bVar, Context context) {
        k.c(bVar, "requestCbView");
        k.c(context, "mContext");
        this.f17674b = gVar;
        this.f17675c = bVar;
        this.f17676d = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17673a = simpleName;
    }
}
