package net.one97.paytm.paymentsBank.chequebook.demoMVP.contract.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.demoMVP.contract.a;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookBaseActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.d;

public final class UploadSignActivity extends ChequeBookBaseActivity implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public a.C0266a f17494a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f17495b;

    public final View a(int i2) {
        if (this.f17495b == null) {
            this.f17495b = new HashMap();
        }
        View view = (View) this.f17495b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17495b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(boolean z) {
    }

    public final int a() {
        return R.layout.pb_activity_cheque_signature;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d dVar = d.f17950a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        Context baseContext = getBaseContext();
        k.a((Object) baseContext, "baseContext");
        a.C0266a aVar = new net.one97.paytm.paymentsBank.chequebook.demoMVP.contract.a.a(d.a(applicationContext), this, baseContext);
        k.c(aVar, "<set-?>");
        this.f17494a = aVar;
        a.C0266a aVar2 = this.f17494a;
        if (aVar2 == null) {
            k.a("presenter");
        }
        aVar2.a();
    }
}
