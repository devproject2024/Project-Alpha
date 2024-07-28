package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class BankVpaCreationActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private AccountProviderBody.AccountProvider f68125a;

    /* renamed from: b  reason: collision with root package name */
    private String f68126b;

    public static void a(Activity activity, AccountProviderBody.AccountProvider accountProvider, String str, int i2) {
        Intent intent = new Intent(activity, BankVpaCreationActivity.class);
        intent.putExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER, accountProvider);
        intent.putExtra("vpa", str);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Fragment fragment, AccountProviderBody.AccountProvider accountProvider, String str, int i2) {
        Intent intent = new Intent(fragment.getContext(), BankVpaCreationActivity.class);
        intent.putExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER, accountProvider);
        intent.putExtra("vpa", str);
        fragment.startActivityForResult(intent, i2);
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
        toolbar.findViewById(R.id.iv_ppb_logo).setVisibility(0);
        ((TextView) toolbar.findViewById(R.id.tv_toolbar_title)).setText("");
        toolbar.findViewById(R.id.iv_back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BankVpaCreationActivity.this.finish();
            }
        });
        if (getIntent() != null) {
            this.f68125a = (AccountProviderBody.AccountProvider) getIntent().getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
            this.f68126b = getIntent().getStringExtra("vpa");
        }
        if (((b) getSupportFragmentManager().c(b.class.getSimpleName())) == null) {
            UpiUtils.addFragmentToActivity(getSupportFragmentManager(), b.a(this.f68125a, this.f68126b, UpiConstants.PROFILE_STATE.ADD_BANK), R.id.fragment_container);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2 && intent != null) {
            AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
            b bVar = (b) getSupportFragmentManager().c(b.class.getSimpleName());
            if (bVar != null) {
                bVar.a(accountProvider);
            }
        }
    }
}
