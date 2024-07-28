package net.one97.paytm;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.j.a;
import net.one97.paytm.oauth.utils.q;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public class AJRAppLockSettingsActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    Switch f51316a;

    /* renamed from: b  reason: collision with root package name */
    Button f51317b;

    /* renamed from: c  reason: collision with root package name */
    TextView f51318c;

    /* renamed from: d  reason: collision with root package name */
    private int f51319d = 111;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f51320e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f51321f;

    /* renamed from: g  reason: collision with root package name */
    private View f51322g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f51323h;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_settings_app_lock);
        getSupportActionBar().f();
        this.f51316a = (Switch) findViewById(R.id.security_toggle_button);
        this.f51317b = (Button) findViewById(R.id.setDeviceLockbtn);
        this.f51318c = (TextView) findViewById(R.id.toggleInfoTv);
        this.f51321f = (TextView) findViewById(R.id.accProtectedTv);
        this.f51322g = findViewById(R.id.view_protected_account);
        this.f51323h = (TextView) findViewById(R.id.description1Tv);
        this.f51316a.setChecked(WalletSharedPrefs.INSTANCE.isPatternLockEnabled(this));
        if ((Build.VERSION.SDK_INT >= 21 ? ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(getResources().getString(R.string.enter_pin_to_proceed), "") : null) == null) {
            this.f51316a.setChecked(false);
            WalletSharedPrefs.INSTANCE.setPatternLock(this, false);
        }
        this.f51316a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean z2 = z;
                if (!AJRAppLockSettingsActivity.this.f51320e) {
                    AJRAppLockSettingsActivity.a(AJRAppLockSettingsActivity.this, z2);
                    if (compoundButton.getTag() == null || !(compoundButton.getTag() instanceof Boolean) || !((Boolean) compoundButton.getTag()).booleanValue()) {
                        if (z2) {
                            a.a((Context) AJRAppLockSettingsActivity.this, "manage_security_shield", "toggle_clicked", "toggle_on", "", "", "");
                        } else {
                            a.a((Context) AJRAppLockSettingsActivity.this, "manage_security_shield", "toggle_clicked", "toggle_off", "", "", "");
                        }
                        AJRAppLockSettingsActivity.b(AJRAppLockSettingsActivity.this);
                    } else {
                        compoundButton.setTag((Object) null);
                        return;
                    }
                }
                boolean unused = AJRAppLockSettingsActivity.this.f51320e = false;
            }
        });
        this.f51317b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRAppLockSettingsActivity.this.b(view);
            }
        });
        ((ImageView) findViewById(R.id.back_image)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRAppLockSettingsActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a.a((Context) this, "manage_security_shield", "set_device_lock_clicked", "", "", "", "");
        this.f51320e = true;
        startActivityForResult(new Intent("android.app.action.SET_NEW_PASSWORD"), H5RpcPlugin.RpcRequest.H5_APP_ERROR_CODE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onResume() {
        super.onResume();
        if (d.b().j(this)) {
            this.f51323h.setText(getString(R.string.existing_phone_lock_text));
            this.f51317b.setVisibility(8);
            this.f51316a.setVisibility(0);
            this.f51318c.setVisibility(0);
            return;
        }
        this.f51323h.setText(getString(R.string.security_settings_description));
        this.f51317b.setVisibility(0);
        this.f51316a.setVisibility(8);
        this.f51316a.setChecked(false);
        this.f51318c.setVisibility(8);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f51319d = i3;
        if (i2 == 207 && i3 == -1) {
            if (com.paytm.utility.a.p(this)) {
                if (this.f51316a.isChecked()) {
                    WalletSharedPrefs.INSTANCE.setPatternLock(this, true);
                    WalletSharedPrefs.INSTANCE.setLockPatternSession(this, false);
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            AJRAppLockSettingsActivity.this.d();
                        }
                    }, 200);
                    a();
                } else if (!this.f51316a.isChecked()) {
                    WalletSharedPrefs.INSTANCE.setPatternLock(this, false);
                    WalletSharedPrefs.INSTANCE.showSecFeatureModelPref(this, true);
                }
                androidx.localbroadcastmanager.a.a.a((Context) this).a(new Intent("update_flyout_app_lock_changed_security_settings"));
            }
        } else if (i2 != 207 || i3 == -1) {
            if (i2 == 2003) {
                boolean j = d.b().j(this);
                d.a().a(j);
                this.f51316a.setChecked(j);
                int i4 = 8;
                this.f51317b.setVisibility(j ? 8 : 0);
                this.f51316a.setVisibility(j ? 0 : 8);
                TextView textView = this.f51318c;
                if (j) {
                    i4 = 0;
                }
                textView.setVisibility(i4);
                this.f51323h.setText(getString(j ? R.string.existing_phone_lock_text : R.string.security_settings_description));
                if (j) {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            AJRAppLockSettingsActivity.this.c();
                        }
                    }, 200);
                    a();
                }
            }
        } else if (com.paytm.utility.a.p(this)) {
            this.f51316a.setTag(Boolean.TRUE);
            Switch switchR = this.f51316a;
            switchR.setChecked(!switchR.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        a.a((Context) this, "manage_security_shield", "phone_lock_set_successfully", "", "", "", "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        a.a((Context) this, "manage_security_shield", "phone_lock_set_successfully", "", "", "", "");
    }

    private void a() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down_security_shield);
        this.f51321f.startAnimation(loadAnimation);
        this.f51321f.setVisibility(0);
        this.f51322g.startAnimation(loadAnimation);
        this.f51322g.setVisibility(0);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                AJRAppLockSettingsActivity.this.b();
            }
        }, 2000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_security_shield);
        this.f51321f.startAnimation(loadAnimation);
        this.f51321f.setVisibility(8);
        this.f51322g.startAnimation(loadAnimation);
        this.f51322g.setVisibility(8);
    }

    public void onResumeFragments() {
        super.onResumeFragments();
    }

    public void onBackPressed() {
        setResult(this.f51319d);
        a.a((Context) this, "manage_security_shield", "back_clicked", "", "", "", "");
        super.onBackPressed();
    }

    static /* synthetic */ void a(AJRAppLockSettingsActivity aJRAppLockSettingsActivity, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("account_app_lock_toggle_state", "toggle_set_on");
        } else {
            hashMap.put("account_app_lock_toggle_state", "toggle_set_off");
        }
        a.b("account_paytm_assist_toggle_clicked", (Map<String, Object>) hashMap, (Context) aJRAppLockSettingsActivity);
    }

    static /* synthetic */ void b(AJRAppLockSettingsActivity aJRAppLockSettingsActivity) {
        String string = aJRAppLockSettingsActivity.getString(R.string.activate_paytm_security_shield);
        q qVar = q.f56798a;
        if (q.x()) {
            string = aJRAppLockSettingsActivity.getString(R.string.deactivate_paytm_security_shield);
        }
        KeyguardManager keyguardManager = (KeyguardManager) aJRAppLockSettingsActivity.getSystemService("keyguard");
        Intent intent = null;
        if (Build.VERSION.SDK_INT >= 21) {
            intent = keyguardManager.createConfirmDeviceCredentialIntent(string, aJRAppLockSettingsActivity.getString(R.string.lbl_confirm_screen_lock));
        }
        if (intent != null) {
            aJRAppLockSettingsActivity.startActivityForResult(intent, 207);
        } else {
            aJRAppLockSettingsActivity.f51316a.setChecked(false);
        }
    }
}
