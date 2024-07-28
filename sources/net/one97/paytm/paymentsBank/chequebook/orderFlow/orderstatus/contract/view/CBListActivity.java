package net.one97.paytm.paymentsBank.chequebook.orderFlow.orderstatus.contract.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.a;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.d;

public final class CBListActivity extends ChequeBookBaseActivity implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.C0278a f17681a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f17682b;

    public final View a(int i2) {
        if (this.f17682b == null) {
            this.f17682b = new HashMap();
        }
        View view = (View) this.f17682b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17682b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(boolean z) {
    }

    public final int a() {
        return R.layout.pb_activity_cheque_book;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d dVar = d.f17950a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        Context baseContext = getBaseContext();
        k.a((Object) baseContext, "baseContext");
        a.C0278a aVar = new net.one97.paytm.paymentsBank.chequebook.orderFlow.orderstatus.contract.a.a(d.a(applicationContext), this, baseContext);
        k.c(aVar, "<set-?>");
        this.f17681a = aVar;
        a.C0278a aVar2 = this.f17681a;
        if (aVar2 == null) {
            k.a("presenter");
        }
        aVar2.a();
    }
}
