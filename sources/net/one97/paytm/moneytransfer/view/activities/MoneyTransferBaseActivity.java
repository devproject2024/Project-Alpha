package net.one97.paytm.moneytransfer.view.activities;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.p;

public class MoneyTransferBaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f54293a;

    public View a(int i2) {
        if (this.f54293a == null) {
            this.f54293a = new HashMap();
        }
        View view = (View) this.f54293a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f54293a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        d.a aVar = d.f53996a;
        if (d.b(d.a.a()) == null) {
            new p();
            p.a();
            super.attachBaseContext(context);
            return;
        }
        d.a aVar2 = d.f53996a;
        super.attachBaseContext(d.b(d.a.a()).a(context));
    }
}
