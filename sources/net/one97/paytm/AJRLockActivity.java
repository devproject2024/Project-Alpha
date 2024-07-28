package net.one97.paytm;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.paytm.utility.b;
import net.one97.paytm.l.c;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.activity.PaySendInfoActivity;
import net.one97.paytm.wallet.newdesign.utils.WalletSharedPrefs;
import net.one97.paytm.wallet.p2p.P2PAppCompatActivity;

public abstract class AJRLockActivity extends P2PAppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f51370a = AJRLockActivity.class.getSimpleName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WalletSharedPrefs.INSTANCE.setIsSecLockShowing(this, false);
        WalletSharedPrefs.INSTANCE.setIsAppFromBackground(this, false);
    }

    public void onResume() {
        Intent createConfirmDeviceCredentialIntent;
        if (WalletSharedPrefs.INSTANCE.isAppFromBackGround(this)) {
            WalletSharedPrefs.INSTANCE.setIsAppFromBackground(this, false);
            if (Build.VERSION.SDK_INT >= 21 && WalletSharedPrefs.INSTANCE.isPatternLockEnabled(getApplicationContext()) && (createConfirmDeviceCredentialIntent = ((KeyguardManager) getSystemService("keyguard")).createConfirmDeviceCredentialIntent(getResources().getString(R.string.unlock_wallet), "")) != null) {
                WalletSharedPrefs.INSTANCE.setIsSecLockShowing(this, true);
                startActivityForResult(createConfirmDeviceCredentialIntent, 210);
            }
        }
        super.onResume();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        WalletSharedPrefs.INSTANCE.setIsSecLockShowing(this, false);
        if (!(i2 == 210 && i3 == -1)) {
            if (i2 == 210) {
                WalletSharedPrefs.INSTANCE.setIsAppFromBackground(this, false);
                finish();
                return;
            } else if (i2 == 207 && i3 == -1) {
                if (b.r((Context) this)) {
                    WalletSharedPrefs.INSTANCE.setPatternLock(this, true);
                    if (!WalletSharedPrefs.INSTANCE.isLockPatternSessionSet(this)) {
                        WalletSharedPrefs.INSTANCE.setLockPatternSession(this, true);
                    }
                    if (!WalletSharedPrefs.INSTANCE.isSecFeatureSuccesShown(this)) {
                        new Handler().postDelayed(new Runnable() {
                            public final void run() {
                                c cVar = new c();
                                Bundle bundle = new Bundle();
                                bundle.putInt("paysend", 207);
                                cVar.setArguments(bundle);
                                cVar.show(AJRLockActivity.this.getSupportFragmentManager(), "Dialog");
                            }
                        }, 400);
                        return;
                    }
                    return;
                }
                startActivity(new Intent(this, PaySendInfoActivity.class));
                finish();
                return;
            } else if (i2 == 208 || i2 == 207) {
                WalletSharedPrefs.INSTANCE.setIsAppFromBackground(this, false);
                finish();
                return;
            }
        }
        WalletSharedPrefs.INSTANCE.setIsAppFromBackground(this, false);
    }
}
