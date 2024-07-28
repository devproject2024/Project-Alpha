package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiProfileActivity extends PaytmActivity {
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
        setContentView(R.layout.activity_toolbar_frame_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText(R.string.saved_payment_method);
        toolbar.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiProfileActivity.this.finish();
            }
        });
        setSupportActionBar(toolbar);
        k kVar = (k) getSupportFragmentManager().c(k.class.getSimpleName());
        if (kVar == null) {
            kVar = k.f();
        }
        UpiUtils.replaceFragmentToActivity(getSupportFragmentManager(), kVar, R.id.fragment_container);
    }
}
