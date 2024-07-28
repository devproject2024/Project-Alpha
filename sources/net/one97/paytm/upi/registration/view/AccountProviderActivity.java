package net.one97.paytm.upi.registration.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.presenter.a;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class AccountProviderActivity extends PaytmActivity {
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
        UpiUtils.setStatusBarColor(getResources().getColor(R.color.white), this);
        b bVar = (b) getSupportFragmentManager().c(b.class.getSimpleName());
        if (bVar == null) {
            bVar = b.d();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(UpiConstants.EXTRA_UPI_SHOW_DO_IT_LATER, getIntent().getBooleanExtra(UpiConstants.EXTRA_UPI_SHOW_DO_IT_LATER, false));
        bVar.setArguments(bundle2);
        getApplicationContext();
        getApplicationContext();
        new a(g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), bVar);
        getSupportFragmentManager().a().b(16908290, bVar, b.class.getSimpleName()).b();
    }

    public static void a(Activity activity, int i2) {
        Class<AccountProviderActivity> cls = AccountProviderActivity.class;
        Intent intent = new Intent(activity, cls);
        intent.setClass(activity, cls);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Fragment fragment, int i2) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), AccountProviderActivity.class), i2);
    }
}
