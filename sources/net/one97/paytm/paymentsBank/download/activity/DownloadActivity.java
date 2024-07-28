package net.one97.paytm.paymentsBank.download.activity;

import android.content.Context;
import android.os.Bundle;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.download.b.a.a;
import net.one97.paytm.paymentsBank.utils.o;

public class DownloadActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_rl_blank);
        new a(this, getIntent()).a();
    }

    public void attachBaseContext(Context context) {
        if (o.b()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
