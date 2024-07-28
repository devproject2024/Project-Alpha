package net.one97.paytm;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.paytm.paymentsettings.paytmassist.view.ui.PaytmAssistSettingsActivity;
import com.paytm.utility.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.deeplink.ae;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.oauth.activity.AJRChangePassword;
import net.one97.paytm.p.a;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public class AJRSecuritySettings extends CJRActionBarBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected CJRCatalog f51746a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f51747b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f51748c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f51749d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f51750e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f51751f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f51752g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f51753h;

    /* renamed from: i  reason: collision with root package name */
    private Switch f51754i;
    private TextView j;
    private TextView k;

    public final void a() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = (FrameLayout) findViewById(R.id.content_frame);
        this.s.addView(getLayoutInflater().inflate(R.layout.activity_security_settings, (ViewGroup) null));
        setTitle(getString(R.string.security_settings));
        if (getIntent().getBooleanExtra("passcode", false)) {
            c();
        }
        o();
        p();
        this.f51749d = (RelativeLayout) findViewById(R.id.lyt_security_change_password);
        this.f51750e = (RelativeLayout) findViewById(R.id.lyt_security_change_passcode);
        this.k = (TextView) findViewById(R.id.activity_security_settings_tv_passcode);
        this.f51748c = (RelativeLayout) findViewById(R.id.lyt_paytm_assist);
        this.f51754i = (Switch) findViewById(R.id.security_toggle_button);
        this.f51754i.setChecked(WalletSharedPrefs.INSTANCE.isPatternLockEnabled(this));
        this.j = (TextView) findViewById(R.id.tv_security_status);
        this.f51747b = (RelativeLayout) findViewById(R.id.lyt_security);
        this.f51751f = (RelativeLayout) findViewById(R.id.lyt_saved_cards);
        this.f51752g = (RelativeLayout) findViewById(R.id.lyt_delivery_address);
        this.f51753h = (RelativeLayout) findViewById(R.id.lyt_notification_settings);
        this.f51747b = (RelativeLayout) findViewById(R.id.lyt_security);
        View findViewById = findViewById(R.id.lyt_security_tab);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f51747b.setVisibility(0);
            findViewById.setVisibility(0);
            if (((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(getResources().getString(R.string.enter_pin_to_proceed), "") == null) {
                this.f51754i.setChecked(false);
                WalletSharedPrefs.INSTANCE.setPatternLock(this, false);
            }
        }
        if (d.a().J()) {
            this.f51749d.setVisibility(8);
        }
        this.f51752g.setOnClickListener(this);
        this.f51751f.setOnClickListener(this);
        this.f51753h.setOnClickListener(this);
        this.f51749d.setOnClickListener(this);
        this.f51748c.setOnClickListener(this);
        this.f51750e.setOnClickListener(this);
        this.f51747b.setOnClickListener(this);
        this.f51754i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (compoundButton.getTag() == null || !(compoundButton.getTag() instanceof Boolean) || !((Boolean) compoundButton.getTag()).booleanValue()) {
                    AJRSecuritySettings.a(AJRSecuritySettings.this);
                } else {
                    compoundButton.setTag((Object) null);
                }
            }
        });
        b();
    }

    private void b() {
        if (WalletSharedPrefs.INSTANCE.isPatternLockEnabled(this)) {
            this.j.setText(getString(R.string.security_status_enabled));
        } else {
            this.j.setText(getString(R.string.security_status_disabled));
        }
    }

    public void onResume() {
        super.onResume();
        if (!ag.a(getApplicationContext()).b("is_passcode_set", false, true)) {
            this.k.setText(R.string.set_passcode);
        } else {
            this.k.setText(R.string.change_passcode);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lyt_delivery_address:
                a("Delivery Address");
                Intent intent = new Intent(this, AJRProfileActivity.class);
                intent.putExtra("address_from_account", true);
                startActivity(intent);
                return;
            case R.id.lyt_notification_settings:
                a("Notification Settings");
                if (a.p(this)) {
                    startActivity(new Intent(this, AJRNotificationSettingsWebview.class));
                    return;
                }
                return;
            case R.id.lyt_paytm_assist:
                a("Paytm Assist");
                a.C0166a aVar = net.one97.paytm.p.a.f12661b;
                net.one97.paytm.p.a a2 = a.C0166a.a(this);
                if (a2 != null) {
                    Activity activity = a2.f12664a;
                    if (activity == null) {
                        k.a("mActivity");
                    }
                    startActivity(new Intent(activity, PaytmAssistSettingsActivity.class));
                    return;
                }
                return;
            case R.id.lyt_saved_cards:
                a("Saved Cards");
                Intent intent2 = new Intent(this, AJRProfileActivity.class);
                intent2.putExtra("saved_card_from_account", true);
                startActivity(intent2);
                return;
            case R.id.lyt_security:
                a("App lock password");
                startActivityForResult(new Intent(this, AJRAppLockSettingsActivity.class), 207);
                return;
            case R.id.lyt_security_change_passcode:
                a(this.k.getText().toString());
                c();
                return;
            case R.id.lyt_security_change_password:
                a("Change Password");
                startActivityForResult(new Intent(this, AJRChangePassword.class), 619);
                return;
            default:
                return;
        }
    }

    private void c() {
        if (ag.a(getApplicationContext()).b("is_passcode_set", false, true)) {
            d();
        } else {
            e();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 207) {
            b();
        } else if (i2 == 619 && i3 == -1) {
            finish();
        }
    }

    private void d() {
        Intent intent = new Intent();
        intent.putExtra("current_catalog", this.f51746a);
        intent.setAction("change_passcode");
        ae aeVar = ae.f50307a;
        ae.a((Context) this, intent);
    }

    private void e() {
        startActivity(new Intent(this, AJRMainActivity.class));
    }

    private void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("account_item_name", str);
            net.one97.paytm.j.a.b("account_item_clicked", (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception unused) {
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        i();
        k();
        j();
        return super.onPrepareOptionsMenu(menu);
    }

    static /* synthetic */ void a(AJRSecuritySettings aJRSecuritySettings) {
        Intent createConfirmDeviceCredentialIntent = ((KeyguardManager) aJRSecuritySettings.getSystemService("keyguard")).createConfirmDeviceCredentialIntent(aJRSecuritySettings.getResources().getString(R.string.enter_pin_to_proceed), "");
        if (createConfirmDeviceCredentialIntent != null) {
            aJRSecuritySettings.startActivityForResult(createConfirmDeviceCredentialIntent, 207);
            return;
        }
        new net.one97.paytm.l.a().show(aJRSecuritySettings.getSupportFragmentManager(), "Dialog");
        aJRSecuritySettings.f51754i.setChecked(false);
    }
}
