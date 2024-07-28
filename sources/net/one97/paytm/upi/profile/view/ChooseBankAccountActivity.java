package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.presenter.b;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class ChooseBankAccountActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    String f68128a;

    /* renamed from: b  reason: collision with root package name */
    private UserUpiDetails f68129b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f68130c;

    public static void a(Activity activity, UserUpiDetails userUpiDetails, boolean z, String str, int i2) {
        Intent intent = new Intent(activity, ChooseBankAccountActivity.class);
        intent.setFlags(33554432);
        intent.putExtra("user_upi_details", userUpiDetails);
        intent.putExtra(UpiConstants.EXTRA_ADD_BANK_DEFAULT, z);
        intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, str);
        intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, i2);
        activity.startActivity(intent);
    }

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
        setSupportActionBar(toolbar);
        ((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText(R.string.upi_link_bank_account);
        toolbar.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChooseBankAccountActivity.this.finish();
            }
        });
        if (bundle != null) {
            this.f68129b = (UserUpiDetails) bundle.getSerializable("user_upi_details");
        } else if (getIntent() != null) {
            this.f68129b = (UserUpiDetails) getIntent().getSerializableExtra("user_upi_details");
            this.f68130c = getIntent().getBooleanExtra(UpiConstants.EXTRA_ADD_BANK_DEFAULT, false);
            this.f68128a = getIntent().getStringExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL);
        }
        c cVar = (c) getSupportFragmentManager().c(c.class.getSimpleName());
        if (cVar == null) {
            cVar = c.b();
            UpiUtils.addFragmentToActivity(getSupportFragmentManager(), cVar, R.id.fragment_container);
        }
        new b(g.a(), g.a(a.a(g.d(), (a.C1347a) null)), cVar, this.f68129b, this.f68130c);
    }

    public final int a() {
        return getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user_upi_details", this.f68129b);
    }
}
