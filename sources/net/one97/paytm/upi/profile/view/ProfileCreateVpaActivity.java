package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.presenter.c;
import net.one97.paytm.upi.util.UpiUtils;

public class ProfileCreateVpaActivity extends PaytmActivity {
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

    public static void a(Activity activity) {
        activity.startActivityForResult(new Intent(activity, ProfileCreateVpaActivity.class), 33);
    }

    public static void a(Fragment fragment) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), ProfileCreateVpaActivity.class), 100);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_registration);
        findViewById(R.id.i_bottom_strip).setVisibility(8);
        ((LinearLayout) findViewById(R.id.ll_upi_toolbar)).setBackgroundColor(b.c(this, R.color.white));
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ProfileCreateVpaActivity.this.finish();
            }
        });
        g gVar = (g) getSupportFragmentManager().c(g.class.getSimpleName());
        if (gVar == null) {
            gVar = g.d();
            UpiUtils.addFragmentToActivity(getSupportFragmentManager(), gVar, R.id.fl_container);
        }
        new c(g.a(), gVar);
    }
}
