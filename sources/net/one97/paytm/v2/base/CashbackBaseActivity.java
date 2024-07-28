package net.one97.paytm.v2.base;

import android.content.Context;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.vipcashback.c.a;

public class CashbackBaseActivity extends PaytmActivity {
    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(a.b().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }
}
