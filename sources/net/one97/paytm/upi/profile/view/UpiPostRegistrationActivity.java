package net.one97.paytm.upi.profile.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.a.a;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.profile.presenter.e;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiPostRegistrationActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private UserUpiDetails f68158a;

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
        findViewById(R.id.toolbar_divider).setVisibility(8);
        toolbar.findViewById(R.id.iv_ppb_logo).setVisibility(0);
        toolbar.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiPostRegistrationActivity.this.finish();
            }
        });
        ((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText("");
        toolbar.setVisibility(8);
        if (getIntent() != null) {
            this.f68158a = (UserUpiDetails) getIntent().getSerializableExtra("user_upi_details");
        } else if (bundle != null) {
            this.f68158a = (UserUpiDetails) bundle.getSerializable("user_upi_details");
        }
        i iVar = (i) getSupportFragmentManager().c(i.class.getSimpleName());
        if (iVar == null) {
            iVar = i.a();
            UpiUtils.addFragmentToActivity(getSupportFragmentManager(), iVar, R.id.fragment_container);
        }
        getApplicationContext();
        new e(g.a(), iVar, this.f68158a);
    }

    public final int a() {
        return getIntent().getIntExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, 0);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user_upi_details", this.f68158a);
    }

    public void onBackPressed() {
        if (a() == UpiConstants.SourceOfOnBoarding.MONEY_TRANSFER.getVal()) {
            Intent intent = new Intent(UpiConstants.EXTRA_ACTION_MT_REFRESH_PROFILE);
            intent.putExtra(UpiConstants.EXTRA_MT_REFRESH_DO_SHOW_UPI_FORM, true);
            a.a((Context) this).a(intent);
        }
        finish();
    }
}
