package net.one97.paytm.paymentsBank.activity;

import android.content.Intent;
import android.os.Bundle;
import net.one97.paytm.bankCommon.f.c;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.payments.activity.AJRWalletSetPasscode;
import net.one97.paytm.payments.b.b.a;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public class PBWalletPassBookBridgeActivity extends PBEnteringFlowPasscodeActivity implements c, e {

    /* renamed from: b  reason: collision with root package name */
    private boolean f17399b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17400c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f17401d = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().hasExtra("show_feature_specific_view")) {
            this.f17401d = getIntent().getStringExtra("show_feature_specific_view");
        }
    }

    public final void f() {
        Intent intent = new Intent(this, AJRWalletSetPasscode.class);
        intent.putExtras(getIntent());
        startActivityForResult(intent, 102);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, int i3, Intent intent) {
        if (i2 != 102) {
            return;
        }
        if (i3 == -1) {
            this.f17399b = true;
            if (intent.getBooleanExtra("set_nominee", false)) {
                c cVar = new c();
                if (getIntent() != null) {
                    cVar.setArguments(getIntent().getExtras());
                }
                getSupportFragmentManager().a().b(R.id.container, cVar, (String) null).c();
                return;
            }
            h();
        } else if (i3 == 0) {
            h();
        }
    }

    public final void a(int i2) {
        Bundle bundle;
        if (i2 == 2) {
            b bVar = new b();
            if (getIntent().getExtras() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("isAadhaarConsent", true);
            bundle.putBoolean("DO_CREATE_ACCOUNT", true);
            bundle.putBoolean("add_nominee_for_slfd", false);
            bundle.putString("ACCOUNT_NUMBER", getIntent().getStringExtra("ACCOUNT_NUMBER"));
            bVar.setArguments(bundle);
            getSupportFragmentManager().a().b(R.id.container, bVar, (String) null).c();
        } else if (i2 == 9 || i2 == 10) {
            a aVar = new a();
            if (getIntent() != null) {
                aVar.setArguments(getIntent().getExtras());
            }
            getSupportFragmentManager().a().b(R.id.container, aVar, (String) null).c();
        } else if (i2 == 11) {
            h();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f17399b && b.a(this)) {
            g();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.f17399b) {
            h();
        }
    }

    private void h() {
        String str;
        int i2;
        if (b.a(this)) {
            i2 = -1;
            g();
            if (this.f17399b) {
                str = a.C0259a.PASSCODE_SET_SUCCESS.getValue();
            } else {
                str = a.C0259a.PASSCODE_ALREADY_EXIST.getValue();
            }
        } else {
            str = a.C0259a.PASSCODE_SET_FAILURE.getValue();
            i2 = 0;
        }
        a(str, i2);
    }

    public final void a() {
        h();
    }

    public final void g() {
        try {
            if (o.a() != null && !this.f17400c) {
                this.f17400c = true;
                o.a().setPassCodeConsentSuccess();
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, int i2) {
        Intent intent;
        if (getIntent() != null) {
            intent = getIntent();
        } else {
            intent = new Intent();
        }
        intent.putExtra("passcode_consent_key", str);
        setResult(i2, intent);
        finish();
    }
}
