package net.one97.paytm.paymentsBank.chequebook.orderFlow.orderstatus.contract.a;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.b;
import net.one97.paytm.paymentsBank.chequebook.utils.g;

public final class b implements com.paytm.network.listener.b, b.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f17677a;

    /* renamed from: b  reason: collision with root package name */
    private final g f17678b;

    /* renamed from: c  reason: collision with root package name */
    private final b.C0279b f17679c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f17680d;

    public final void a() {
    }

    public final void b() {
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public b(g gVar, b.C0279b bVar, Context context) {
        k.c(bVar, "requestCbView");
        k.c(context, "mContext");
        this.f17678b = gVar;
        this.f17679c = bVar;
        this.f17680d = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17677a = simpleName;
    }
}
