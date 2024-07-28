package com.travel.bus.busticket.activity;

import android.content.Context;
import android.os.Bundle;
import com.google.android.play.core.splitcompat.a;
import com.travel.utils.q;
import net.one97.paytm.activity.PaytmActivity;

public class AJRBusBaseActivity extends PaytmActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void attachBaseContext(Context context) {
        q.a(context);
        super.attachBaseContext(context);
        a.b((Context) this);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) this);
    }
}
