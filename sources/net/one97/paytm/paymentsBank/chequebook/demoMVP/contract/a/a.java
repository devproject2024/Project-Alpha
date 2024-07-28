package net.one97.paytm.paymentsBank.chequebook.demoMVP.contract.a;

import android.content.Context;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.chequebook.demoMVP.contract.a;
import net.one97.paytm.paymentsBank.chequebook.utils.g;

public final class a implements Response.ErrorListener, Response.Listener<IJRPaytmDataModel>, b, a.C0266a {

    /* renamed from: a  reason: collision with root package name */
    private final String f17490a;

    /* renamed from: b  reason: collision with root package name */
    private final g f17491b;

    /* renamed from: c  reason: collision with root package name */
    private final a.b f17492c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17493d;

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
        this.f17491b = gVar;
        this.f17492c = bVar;
        this.f17493d = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17490a = simpleName;
    }
}
