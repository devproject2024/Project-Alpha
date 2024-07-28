package net.one97.paytm.payments.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.d.c;
import net.one97.paytm.paymentsBank.R;

public final class AJRWalletSetPasscode extends AJRSetPasscode {

    /* renamed from: e  reason: collision with root package name */
    String f17177e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f17178f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f17179g;

    public final View a(int i2) {
        if (this.f17179g == null) {
            this.f17179g = new HashMap();
        }
        View view = (View) this.f17179g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17179g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().hasExtra("show_feature_specific_view")) {
            this.f17177e = getIntent().getStringExtra("show_feature_specific_view");
        }
        Button button = (Button) a(R.id.btn_set_passcode);
        if (button != null) {
            button.setOnClickListener(new a(this));
        }
        CheckBox checkBox = (CheckBox) a(R.id.cb_consent);
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new b(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRWalletSetPasscode f17180a;

        a(AJRWalletSetPasscode aJRWalletSetPasscode) {
            this.f17180a = aJRWalletSetPasscode;
        }

        public final void onClick(View view) {
            CheckBox checkBox;
            AJRWalletSetPasscode aJRWalletSetPasscode = this.f17180a;
            if (aJRWalletSetPasscode.d(aJRWalletSetPasscode.f17178f)) {
                if (!(((CheckBox) this.f17180a.a(R.id.cb_consent)) == null || (checkBox = (CheckBox) this.f17180a.a(R.id.cb_consent)) == null || checkBox.getVisibility() != 0)) {
                    CheckBox checkBox2 = (CheckBox) this.f17180a.a(R.id.cb_consent);
                    k.a((Object) checkBox2, "cb_consent");
                    if (checkBox2.isChecked()) {
                        AJRWalletSetPasscode aJRWalletSetPasscode2 = this.f17180a;
                        net.one97.paytm.paymentsBank.e.a.a(aJRWalletSetPasscode2, aJRWalletSetPasscode2.f17177e, "pc_click_set_passcode");
                    }
                }
                AJRWalletSetPasscode aJRWalletSetPasscode3 = this.f17180a;
                aJRWalletSetPasscode3.a(aJRWalletSetPasscode3.i(), this.f17180a.f17178f);
            }
        }
    }

    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRWalletSetPasscode f17181a;

        b(AJRWalletSetPasscode aJRWalletSetPasscode) {
            this.f17181a = aJRWalletSetPasscode;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            k.c(compoundButton, "compoundButton");
            AJRWalletSetPasscode aJRWalletSetPasscode = this.f17181a;
            net.one97.paytm.paymentsBank.e.a.a(aJRWalletSetPasscode, aJRWalletSetPasscode.f17177e, "pc_click_consent");
        }
    }

    /* access modifiers changed from: protected */
    public final int e() {
        return R.layout.activity_set_passcode_v2;
    }

    /* access modifiers changed from: protected */
    public final void h() {
        Window window;
        if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
            window.setStatusBarColor(androidx.core.content.b.c(this, R.color.white));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = r3
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r1 = r3.f17177e
            java.lang.String r2 = "pc_set_passcode"
            net.one97.paytm.paymentsBank.e.a.a(r0, r1, r2)
            r3.a((java.lang.String) r4)
            android.widget.TextView r4 = r3.f17167b
            int r0 = net.one97.paytm.paymentsBank.R.string.confirm_your_paytm_passcode
            r4.setText(r0)
            net.one97.paytm.bankCommon.d.c r4 = r3.f17168c
            if (r4 == 0) goto L_0x001b
            r4.a()
        L_0x001b:
            int r4 = net.one97.paytm.paymentsBank.R.id.bottominfo_tv
            android.view.View r4 = r3.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x002a
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.paymentsBank.slfd.b.a.b.b(r4)
        L_0x002a:
            int r4 = net.one97.paytm.paymentsBank.R.id.btn_set_passcode
            android.view.View r4 = r3.a((int) r4)
            android.widget.Button r4 = (android.widget.Button) r4
            if (r4 == 0) goto L_0x0039
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(r4)
        L_0x0039:
            java.lang.String r4 = r3.f17177e
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r0 = 1
            if (r4 != 0) goto L_0x006a
            java.lang.String r4 = r3.f17177e
            net.one97.paytm.payments.b.b.a$b r1 = net.one97.paytm.payments.b.b.a.b.DEVICE_BINDING_PASSBOOK
            java.lang.String r1 = r1.name()
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r0)
            if (r4 == 0) goto L_0x0057
            boolean r4 = net.one97.paytm.paymentsBank.utils.n.c()
            goto L_0x006b
        L_0x0057:
            java.lang.String r4 = r3.f17177e
            net.one97.paytm.payments.b.b.a$b r1 = net.one97.paytm.payments.b.b.a.b.DEVICE_BINDING_WALLET
            java.lang.String r1 = r1.name()
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r0)
            if (r4 == 0) goto L_0x006a
            boolean r4 = net.one97.paytm.paymentsBank.utils.n.b()
            goto L_0x006b
        L_0x006a:
            r4 = 0
        L_0x006b:
            if (r4 == 0) goto L_0x007d
            int r4 = net.one97.paytm.paymentsBank.R.id.consent_lyt
            android.view.View r4 = r3.a((int) r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x008c
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(r4)
            goto L_0x008c
        L_0x007d:
            int r4 = net.one97.paytm.paymentsBank.R.id.consent_lyt
            android.view.View r4 = r3.a((int) r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x008c
            android.view.View r4 = (android.view.View) r4
            net.one97.paytm.paymentsBank.slfd.b.a.b.b(r4)
        L_0x008c:
            androidx.viewpager.widget.ViewPager r4 = r3.j()
            if (r4 == 0) goto L_0x0095
            r4.setCurrentItem(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.activity.AJRWalletSetPasscode.b(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        this.f17178f = str;
        if (d(str)) {
            net.one97.paytm.paymentsBank.e.a.a(this, this.f17177e, "pc_confirm_passcode");
        }
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(i()) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!i().equals(str)) {
            TextView f2 = f();
            if (f2 != null) {
                f2.setVisibility(0);
            }
            c g2 = g();
            if (g2 != null) {
                g2.a(true);
            }
            return false;
        }
        c g3 = g();
        if (g3 != null) {
            g3.a(false);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void k() {
        CheckBox checkBox;
        Intent intent = getIntent();
        if (!(((CheckBox) a(R.id.cb_consent)) == null || (checkBox = (CheckBox) a(R.id.cb_consent)) == null || checkBox.getVisibility() != 0)) {
            CheckBox checkBox2 = (CheckBox) a(R.id.cb_consent);
            k.a((Object) checkBox2, "cb_consent");
            if (checkBox2.isChecked()) {
                intent.putExtra("set_nominee", true);
            }
        }
        setResult(-1, intent);
        finish();
    }

    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0, getIntent());
        finish();
    }

    public final void onDestroy() {
        super.onDestroy();
    }
}
