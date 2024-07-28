package net.one97.paytm.paymentsBank.chequebook.orderFlow.orderstatus.contract.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.b;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.d;

public final class OrderStatusActivity extends ChequeBookBaseActivity implements b.C0279b {

    /* renamed from: a  reason: collision with root package name */
    public b.a f17683a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f17684b;

    public final View a(int i2) {
        if (this.f17684b == null) {
            this.f17684b = new HashMap();
        }
        View view = (View) this.f17684b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17684b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(boolean z) {
    }

    public final int a() {
        return R.layout.pb_activity_request_cb;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d dVar = d.f17950a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        Context baseContext = getBaseContext();
        k.a((Object) baseContext, "baseContext");
        b.a bVar = new net.one97.paytm.paymentsBank.chequebook.orderFlow.orderstatus.contract.a.b(d.a(applicationContext), this, baseContext);
        k.c(bVar, "<set-?>");
        this.f17683a = bVar;
        b.a aVar = this.f17683a;
        if (aVar == null) {
            k.a("presenter");
        }
        aVar.a();
    }
}
