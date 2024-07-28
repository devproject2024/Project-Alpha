package net.one97.paytm.paymentsBank.biometricAuthWall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.utility.g;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.biometricAuthWall.a;
import net.one97.paytm.paymentsBank.biometricAuthWall.e;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.CJRGTMConstants;

public final class BiometricSettingsActivity extends PBBaseActivity implements e.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17432b = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private static int f17433d = 1234;

    /* renamed from: c  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f17434c = new b(this);

    /* renamed from: e  reason: collision with root package name */
    private HashMap f17435e;

    public final View a(int i2) {
        if (this.f17435e == null) {
            this.f17435e = new HashMap();
        }
        View view = (View) this.f17435e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f17435e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
    }

    public final void a(String str) {
        k.c(str, "xCode");
    }

    public final void c(String str) {
        k.c(str, "flowType");
    }

    static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BiometricSettingsActivity f17436a;

        b(BiometricSettingsActivity biometricSettingsActivity) {
            this.f17436a = biometricSettingsActivity;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                BiometricSettingsActivity.a(this.f17436a);
            } else {
                BiometricSettingsActivity.b(this.f17436a);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_biometric_settings);
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        String j = net.one97.paytm.bankCommon.h.b.j(a2.getApplicationContext(), "notsetupedyet");
        Switch switchR = (Switch) a(R.id.switchTouchId);
        k.a((Object) switchR, "switchTouchId");
        switchR.setChecked(k.a((Object) j, (Object) "turnedon") && j.c());
        ((AppCompatImageView) a(R.id.ivBack)).setOnClickListener(new f(this));
        ((Switch) a(R.id.switchTouchId)).setOnCheckedChangeListener(this.f17434c);
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BiometricSettingsActivity f17440a;

        f(BiometricSettingsActivity biometricSettingsActivity) {
            this.f17440a = biometricSettingsActivity;
        }

        public final void onClick(View view) {
            this.f17440a.onBackPressed();
        }
    }

    static final class e implements g.c {

        /* renamed from: a  reason: collision with root package name */
        public static final e f17439a = new e();

        e() {
        }

        public final void onDialogDismissed() {
            g.a();
        }
    }

    public final void onBackPressed() {
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        String j = net.one97.paytm.bankCommon.h.b.j(a2.getApplicationContext(), "notsetupedyet");
        Intent intent = new Intent();
        intent.putExtra("biometric_setting", k.a((Object) j, (Object) "turnedon"));
        setResult(-1, intent);
        super.onBackPressed();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == f17433d && i3 == -1) {
            CharSequence stringExtra = intent != null ? intent.getStringExtra("xCode") : null;
            if (!(stringExtra == null || stringExtra.length() == 0)) {
                if (intent == null) {
                    k.a();
                }
                String stringExtra2 = intent.getStringExtra("xCode");
                e.b bVar = e.f17453d;
                String string = getString(R.string.pb_finger_print_signup_header);
                k.a((Object) string, "getString(R.string.pb_finger_print_signup_header)");
                String string2 = getString(R.string.pb_finger_print_signup_desc);
                k.a((Object) string2, "getString(R.string.pb_finger_print_signup_desc)");
                String string3 = getString(R.string.pb_cancel);
                k.a((Object) string3, "getString(R.string.pb_cancel)");
                e eVar = new e(this, e.b.a(string, "", string2, string3));
                FragmentActivity fragmentActivity = this;
                if (stringExtra2 == null) {
                    k.a();
                }
                eVar.a(fragmentActivity, stringExtra2);
            }
        }
        b(false);
    }

    public final void a(int i2, String str, String str2) {
        k.c(str, "errString");
        k.c(str2, "flowType");
        Context context = this;
        net.one97.paytm.bankCommon.mapping.c.a(context, "biometric_settings_setup", "biometric_validate_failure", i2 + ": " + str, "", "/bank/biometric_settings_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        if (i2 == 7 || i2 == 9) {
            g.b(context, getString(R.string.pb_auth_error), str, d.f17438a);
            return;
        }
        Switch switchR = (Switch) a(R.id.switchTouchId);
        k.a((Object) switchR, "switchTouchId");
        switchR.setChecked(false);
    }

    static final class d implements g.c {

        /* renamed from: a  reason: collision with root package name */
        public static final d f17438a = new d();

        d() {
        }

        public final void onDialogDismissed() {
            g.a();
        }
    }

    public final void b(String str) {
        k.c(str, "flowType");
        net.one97.paytm.bankCommon.mapping.c.a(this, "biometric_settings_setup", "biometric_validate_failure", "-1: onAuthenticationFailed", "", "/bank/biometric_settings_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
    }

    public final void a(String str, String str2) {
        k.c(str, "ivString");
        k.c(str2, "encyptedData");
        net.one97.paytm.bankCommon.mapping.c.a(this, "biometric_settings_setup", "biometric_validate_success", "", "", "/bank/biometric_settings_setup/validate_biometric", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        net.one97.paytm.bankCommon.h.b.a(a2.getApplicationContext(), str, str2, "turnedon");
        b(true);
        a(true);
    }

    private final void a(boolean z) {
        CharSequence charSequence;
        TextView textView = (TextView) a(R.id.tv_notify_user);
        k.a((Object) textView, "tv_notify_user");
        if (z) {
            charSequence = getString(R.string.pb_fingerprint_login);
        } else {
            charSequence = getString(R.string.pb_finger_print_disabled);
        }
        textView.setText(charSequence);
        TextView textView2 = (TextView) a(R.id.tv_notify_user);
        k.a((Object) textView2, "tv_notify_user");
        textView2.setVisibility(0);
        ((TextView) a(R.id.tv_notify_user)).postDelayed(new c(this), 2000);
        net.one97.paytm.bankCommon.mapping.c.a(this, "biometric_settings_setup", z ? "biometric_login_enable_success" : "biometric_login_disable_success", "", "", "/bank/biometric_settings_setup", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BiometricSettingsActivity f17437a;

        c(BiometricSettingsActivity biometricSettingsActivity) {
            this.f17437a = biometricSettingsActivity;
        }

        public final void run() {
            TextView textView = (TextView) this.f17437a.a(R.id.tv_notify_user);
            k.a((Object) textView, "tv_notify_user");
            textView.setVisibility(8);
        }
    }

    private final void b(boolean z) {
        ((Switch) a(R.id.switchTouchId)).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        Switch switchR = (Switch) a(R.id.switchTouchId);
        k.a((Object) switchR, "switchTouchId");
        switchR.setChecked(z);
        ((Switch) a(R.id.switchTouchId)).setOnCheckedChangeListener(this.f17434c);
    }

    public static final /* synthetic */ void a(BiometricSettingsActivity biometricSettingsActivity) {
        Context context = biometricSettingsActivity;
        net.one97.paytm.bankCommon.mapping.c.a(context, "biometric_settings_setup", "toggle_on", "", "", "/bank/biometric_settings_setup", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        if (j.c()) {
            BankPasscodeActivity.a aVar = BankPasscodeActivity.r;
            Activity activity = biometricSettingsActivity;
            String string = biometricSettingsActivity.getString(R.string.pb_verify_passcode);
            k.a((Object) string, "getString(R.string.pb_verify_passcode)");
            int i2 = f17433d;
            k.c(activity, "ctx");
            k.c(string, "title");
            k.c("flow_biometric", "flow");
            Intent intent = new Intent(activity, BankPasscodeActivity.class);
            intent.putExtra("l_code", BankPasscodeActivity.A);
            intent.putExtra("title", string);
            intent.putExtra("flow", "flow_biometric");
            intent.putExtra("ppb_header_position", net.one97.paytm.paymentsBank.passcode.a.a.CENTER.toString());
            activity.startActivityForResult(intent, i2);
            return;
        }
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        if (androidx.biometric.b.a(a2.getApplicationContext()).a() == 11) {
            biometricSettingsActivity.b(false);
            a.C0265a aVar2 = a.f17441a;
            new a().show(biometricSettingsActivity.getSupportFragmentManager(), a.class.getName());
            return;
        }
        g.b(context, biometricSettingsActivity.getString(R.string.pb_paytm_bank_authentication), biometricSettingsActivity.getString(R.string.cb_generic_error), e.f17439a);
    }

    public static final /* synthetic */ void b(BiometricSettingsActivity biometricSettingsActivity) {
        net.one97.paytm.bankCommon.mapping.c.a(biometricSettingsActivity, "biometric_settings_setup", "toggle_off", "", "", "/bank/biometric_settings_setup", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        net.one97.paytm.bankCommon.h.b.i(biometricSettingsActivity.getApplicationContext(), "willdoitlater");
        biometricSettingsActivity.a(false);
    }
}
