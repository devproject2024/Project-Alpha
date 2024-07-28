package net.one97.paytm.bankOpen.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.f.e;
import net.one97.paytm.bankCommon.location.a;
import net.one97.paytm.bankCommon.location.b;
import net.one97.paytm.bankCommon.utils.b;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.b.d;
import net.one97.paytm.bankOpen.b.f;
import net.one97.paytm.bankOpen.b.g;
import net.one97.paytm.bankOpen.ica.b.h;

public class PaymentsBankBaseActivity extends PBBaseActivity implements e, b {

    /* renamed from: b  reason: collision with root package name */
    public boolean f16348b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f16349c = -1;

    /* renamed from: d  reason: collision with root package name */
    private Fragment f16350d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16351e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16352f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f16353g = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.s_payments_bank_home);
        this.f16351e = getIntent().getBooleanExtra("DO_CREATE_ACCOUNT", true);
        findViewById(R.id.payments_bank_frame_container);
        this.f16352f = getIntent().getBooleanExtra("add_nominee_for_slfd", false);
        b(getIntent().getIntExtra("extraDefaultFrame", 0));
    }

    private void b(int i2) {
        if (i2 != this.f16349c) {
            if (i2 == 1 || i2 == 2) {
                String s = com.paytm.utility.b.s((Context) this);
                String t = com.paytm.utility.b.t((Context) this);
                if (TextUtils.isEmpty(s) && TextUtils.isEmpty(t)) {
                    this.f16353g = i2;
                    i2 = 15;
                }
            }
            if (i2 == 0) {
                this.f16350d = new g();
            } else if (i2 == 1) {
                this.f16350d = new f();
            } else if (i2 == 2) {
                this.f16350d = new d();
                Bundle bundle = new Bundle();
                bundle.putBoolean("DO_CREATE_ACCOUNT", this.f16351e);
                bundle.putBoolean("add_nominee_for_slfd", this.f16352f);
                bundle.putString("ACCOUNT_NUMBER", getIntent().getStringExtra("ACCOUNT_NUMBER"));
                this.f16350d.setArguments(bundle);
            } else if (i2 == 3) {
                this.f16350d = new net.one97.paytm.bankOpen.b.e();
            } else if (i2 == 5) {
                this.f16350d = new net.one97.paytm.bankOpen.b.e();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("SHOW_ONLY_KNOW_MORE", true);
                this.f16350d.setArguments(bundle2);
            } else if (i2 == 6) {
                this.f16350d = new net.one97.paytm.bankOpen.b.e();
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("check_account_status", true);
                this.f16350d.setArguments(bundle3);
            } else if (i2 == 7) {
                this.f16350d = new h();
            } else if (i2 == 8) {
                this.f16350d = new net.one97.paytm.bankOpen.b.e();
                Bundle bundle4 = new Bundle();
                bundle4.putInt("acc_opening_type", 1);
                this.f16350d.setArguments(bundle4);
            } else if (i2 == 15) {
                this.f16350d = new a();
            }
            if (this.f16350d != null) {
                this.f16349c = i2;
                q a2 = getSupportFragmentManager().a();
                int i3 = R.id.payments_bank_frame_container;
                Fragment fragment = this.f16350d;
                b.a aVar = net.one97.paytm.bankCommon.utils.b.f16313b;
                a2.b(i3, fragment, net.one97.paytm.bankCommon.utils.b.j).c();
            }
        }
    }

    public final void a(int i2) {
        b(i2);
    }

    public void onBackPressed() {
        Fragment fragment;
        if (!this.f16351e || this.f16349c != 2 || (fragment = this.f16350d) == null || !(fragment instanceof d) || ((d) fragment).f16376c) {
            super.onBackPressed();
        } else {
            b(1);
        }
    }

    public final void V_() {
        int i2 = this.f16353g;
        if (i2 != -1) {
            b(i2);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment fragment;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && (fragment = this.f16350d) != null && (fragment instanceof a) && ((a) fragment).f16283a != null) {
            ((a) this.f16350d).f16283a.a(i3);
        }
    }
}
