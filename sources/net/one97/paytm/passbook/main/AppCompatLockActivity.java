package net.one97.paytm.passbook.main;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.google.firebase.crashlytics.c;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.b.a;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.utility.HomeKeyWatcher;
import net.one97.paytm.passbook.utility.r;

public abstract class AppCompatLockActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f57817a = AppCompatLockActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private int f57818b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f57819c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f57820d = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.a()) {
            finish();
            return;
        }
        if (d.b().a("passbookShowLockScreen", false)) {
            r.INSTANCE.setIsSecLockShowing(false);
            this.f57818b = 101;
            if (Build.VERSION.SDK_INT >= 21) {
                if (r.INSTANCE.isPatternLockEnabled(this)) {
                    Intent intent = null;
                    Intent createConfirmDeviceCredentialIntent = Build.VERSION.SDK_INT >= 21 ? ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(getString(R.string.unlock_passbook), "") : null;
                    if (createConfirmDeviceCredentialIntent == null) {
                        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
                        if (Build.VERSION.SDK_INT >= 21) {
                            intent = keyguardManager.createConfirmDeviceCredentialIntent(getString(R.string.unlock_passbook), "");
                        }
                        if (!r.INSTANCE.isOopsDialogShownViaSecError(this) || intent != null) {
                            r.INSTANCE.setIsOopsDialogShownViaSecError(true);
                            a aVar = new a();
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("paysend", 208);
                            aVar.setArguments(bundle2);
                            aVar.show(getSupportFragmentManager(), "Dialog");
                        }
                    } else if (!r.INSTANCE.isLockPatternSessionSet(this)) {
                        r.INSTANCE.setIsSecLockShowing(true);
                        startActivityForResult(createConfirmDeviceCredentialIntent, 208);
                    }
                } else if (!r.INSTANCE.getSecFeatureModelPref(this)) {
                    try {
                        Intent createConfirmDeviceCredentialIntent2 = ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(getString(R.string.unlock_passbook), "");
                        if (!r.INSTANCE.isOopsDialogShownViaModel(this) || createConfirmDeviceCredentialIntent2 != null) {
                            boolean a2 = d.b().a("passbookShowLockScreen", false);
                            if (!r.INSTANCE.isSecPromptShownInSession(this) && a2) {
                                r.INSTANCE.setSecPromptShownInSession(true);
                                net.one97.paytm.passbook.b.d dVar = new net.one97.paytm.passbook.b.d();
                                Bundle bundle3 = new Bundle();
                                bundle3.putInt("paysend", 208);
                                dVar.setArguments(bundle3);
                                dVar.show(getSupportFragmentManager(), "Dialog");
                            }
                        }
                    } catch (Exception e2) {
                        c.a().a((Throwable) e2);
                    }
                }
            }
        }
        r.INSTANCE.setIsAppFromBackground(false);
    }

    public void onResume() {
        Intent createConfirmDeviceCredentialIntent;
        if (!this.f57820d && r.INSTANCE.isAppFromBackGround(this)) {
            r.INSTANCE.setIsAppFromBackground(false);
            if (d.b().a("passbookShowLockScreen", false) && Build.VERSION.SDK_INT >= 21 && r.INSTANCE.isPatternLockEnabled(getApplicationContext()) && (createConfirmDeviceCredentialIntent = ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(getString(R.string.unlock_passbook), "")) != null) {
                r.INSTANCE.setIsSecLockShowing(true);
                startActivityForResult(createConfirmDeviceCredentialIntent, 210);
            }
        }
        HomeKeyWatcher a2 = HomeKeyWatcher.a();
        try {
            if (!(a2.f59219a == null || a2.f59221c == null)) {
                a2.f59219a.unregisterReceiver(a2.f59221c);
            }
            a2.f59219a = null;
            a2.f59221c = null;
        } catch (Exception unused) {
        }
        a2.f59219a = this;
        a2.f59220b = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        a2.f59221c = new HomeKeyWatcher.InnerReceiver();
        if (a2.f59221c != null) {
            a2.f59219a.registerReceiver(a2.f59221c, a2.f59220b);
        }
        super.onResume();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!isFinishing()) {
            super.onActivityResult(i2, i3, intent);
            r.INSTANCE.setIsSecLockShowing(false);
            if (i2 == 210 && i3 == -1) {
                r.INSTANCE.setIsAppFromBackground(false);
            } else if (i2 == 210) {
                r.INSTANCE.setIsAppFromBackground(false);
                finish();
            } else if (i2 == 208 && i3 == -1) {
                if (b.r((Context) this)) {
                    r.INSTANCE.setPatternLock(true);
                    if (!r.INSTANCE.isLockPatternSessionSet(this)) {
                        r.INSTANCE.setLockPatternSession(true);
                    }
                    this.f57819c = true;
                    return;
                }
                startActivity(new Intent(this, PassbookInfoActivity.class));
                finish();
            } else if (i2 == 208) {
                r.INSTANCE.setIsAppFromBackground(false);
                finish();
            }
        }
    }

    public void onResumeFragments() {
        super.onResumeFragments();
        if (this.f57819c) {
            this.f57819c = false;
            if (!r.INSTANCE.isSecFeatureSuccesShown(this)) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        net.one97.paytm.passbook.b.c cVar = new net.one97.paytm.passbook.b.c();
                        Bundle bundle = new Bundle();
                        bundle.putInt("paysend", 208);
                        cVar.setArguments(bundle);
                        cVar.show(AppCompatLockActivity.this.getSupportFragmentManager(), "Dialog");
                    }
                }, 400);
            }
        }
    }

    public void onStop() {
        super.onStop();
        HomeKeyWatcher.a().f59219a = null;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
