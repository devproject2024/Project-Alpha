package net.one97.paytm;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.base.BaseActivity;
import net.one97.paytm.l.c;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.f.d;
import net.one97.paytm.wallet.newdesign.utils.DelegateUtil;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;

public abstract class AppCompatLockActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public int f51786a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f51787b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f51788c;

    /* renamed from: e  reason: collision with root package name */
    private String f51789e = AppCompatLockActivity.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private boolean f51790f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f51791g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51792h;

    public interface a {
        void a();
    }

    public abstract void a();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WalletSharedPrefs.INSTANCE.setIsAppFromBackground(getApplicationContext(), false);
        WalletSharedPrefs.INSTANCE.setIsSecLockShowing(getApplicationContext(), false);
        a();
        if (b.a().getBooleanFromGTM(this, "walletShouldShowAppLock", false) && Build.VERSION.SDK_INT >= 21) {
            DelegateUtil.INSTANCE.handleSecurityCheck(this, new a() {
                public final void a() {
                    new Handler().postDelayed(new Runnable() {
                        public final void run() {
                            AppCompatLockActivity.AnonymousClass1.this.b();
                        }
                    }, 500);
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void b() {
                    AppCompatLockActivity.this.b();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Intent intent = null;
        Intent createConfirmDeviceCredentialIntent = Build.VERSION.SDK_INT >= 21 ? ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(d(), "") : null;
        if (createConfirmDeviceCredentialIntent == null) {
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
            if (Build.VERSION.SDK_INT >= 21) {
                intent = keyguardManager.createConfirmDeviceCredentialIntent(d(), "");
            }
            if (!WalletSharedPrefs.INSTANCE.isOopsDialogShownViaSecError(this) || intent != null) {
                WalletSharedPrefs.INSTANCE.setIsOopsDialogShownViaSecError(getApplicationContext(), true);
                net.one97.paytm.l.a aVar = new net.one97.paytm.l.a();
                Bundle bundle = new Bundle();
                bundle.putInt("paysend", c());
                aVar.setArguments(bundle);
                aVar.show(getSupportFragmentManager(), "Dialog");
            }
        } else if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(this)) {
            WalletSharedPrefs.INSTANCE.setIsSecLockShowing(getApplicationContext(), true);
            this.f51787b = true;
            startActivityForResult(createConfirmDeviceCredentialIntent, c());
        }
    }

    private int c() {
        int i2 = this.f51786a;
        if (i2 == 101) {
            return 208;
        }
        return i2 == 104 ? 400 : 207;
    }

    public void onResume() {
        Intent createConfirmDeviceCredentialIntent;
        if (!this.f51791g && WalletSharedPrefs.INSTANCE.isAppFromBackGround(this)) {
            WalletSharedPrefs.INSTANCE.setIsAppFromBackground(getApplicationContext(), false);
            if (b.a().getBooleanFromGTM(this, "walletShouldShowAppLock", false) && Build.VERSION.SDK_INT >= 21 && WalletSharedPrefs.INSTANCE.isPatternLockEnabled(getApplicationContext()) && (createConfirmDeviceCredentialIntent = ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(d(), "")) != null) {
                WalletSharedPrefs.INSTANCE.setIsSecLockShowing(getApplicationContext(), true);
                startActivityForResult(createConfirmDeviceCredentialIntent, 210);
            }
        }
        d.a().a(this);
        super.onResume();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        WalletSharedPrefs.INSTANCE.setIsSecLockShowing(getApplicationContext(), false);
        if (i2 == 210 && i3 == -1) {
            WalletSharedPrefs.INSTANCE.setIsAppFromBackground(getApplicationContext(), false);
        } else if (i2 == 210) {
            WalletSharedPrefs.INSTANCE.setIsAppFromBackground(getApplicationContext(), false);
            Intent intent2 = new Intent();
            intent2.putExtra("extra_close_passbook", true);
            setResult(0, intent2);
            finish();
        } else if (i2 == 207 && i3 == -1) {
            WalletSharedPrefs.INSTANCE.setPatternLock(getApplicationContext(), true);
            if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(this)) {
                WalletSharedPrefs.INSTANCE.setLockPatternSession(getApplicationContext(), true);
            }
            this.f51790f = true;
        } else if (i2 == 208 && i3 == -1) {
            if (com.paytm.utility.b.r((Context) this)) {
                WalletSharedPrefs.INSTANCE.setPatternLock(getApplicationContext(), true);
                if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(this)) {
                    WalletSharedPrefs.INSTANCE.setLockPatternSession(getApplicationContext(), true);
                }
                this.f51790f = true;
                return;
            }
            b.a().handleDeepLink(this, "paytmmp://cash_wallet?featuretype=cash_ledger", (Bundle) null);
            finish();
        } else if (i2 == 208 || i2 == 207) {
            WalletSharedPrefs.INSTANCE.setIsAppFromBackground(getApplicationContext(), false);
            finish();
        } else if (i2 == 400 && i3 == -1) {
            WalletSharedPrefs.INSTANCE.setPatternLock(getApplicationContext(), true);
            if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(this)) {
                WalletSharedPrefs.INSTANCE.setLockPatternSession(getApplicationContext(), true);
            }
            this.f51790f = true;
        }
    }

    public void onResumeFragments() {
        super.onResumeFragments();
        if (this.f51790f) {
            this.f51790f = false;
            if (!this.f51792h && !WalletSharedPrefs.INSTANCE.isSecFeatureSuccesShown(this)) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        c cVar = new c();
                        Bundle bundle = new Bundle();
                        bundle.putInt("paysend", 208);
                        cVar.setArguments(bundle);
                        cVar.show(AppCompatLockActivity.this.getSupportFragmentManager(), "Dialog");
                    }
                }, 400);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        d.a().f70361a = null;
    }

    private String d() {
        int i2 = this.f51786a;
        if (i2 == 101) {
            return getString(R.string.unlock_passbook);
        }
        if (i2 == 102) {
            return getString(R.string.unlock_wallet);
        }
        return i2 == 103 ? getString(R.string.unlock_wallet) : "Paytm";
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }
}
