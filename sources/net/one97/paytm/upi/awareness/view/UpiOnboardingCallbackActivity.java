package net.one97.paytm.upi.awareness.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.q;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.i;

public class UpiOnboardingCallbackActivity extends PaytmActivity {
    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_onboarding_callback);
        b bVar = new b();
        q a2 = getSupportFragmentManager().a();
        a2.b(R.id.fragment_container, bVar, bVar.getClass().getSimpleName());
        a2.c();
    }
}
