package com.business.merchant_payments.biometrics;

import android.app.KeyguardManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.business.common_module.utilities.c;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.BaseActivity;
import java.util.HashMap;
import kotlin.g.b.k;

public final class PaymentsP4BLockActivity extends BaseActivity {
    public final int LOCK_REQUEST_CODE = 1991;
    public HashMap _$_findViewCache;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getLOCK_REQUEST_CODE() {
        return this.LOCK_REQUEST_CODE;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setWindowTransparent();
        callNativeLockScreen();
    }

    private final void setWindowTransparent() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public static /* synthetic */ void finishActivityWithData$default(PaymentsP4BLockActivity paymentsP4BLockActivity, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        paymentsP4BLockActivity.finishActivityWithData(i2, str);
    }

    private final void finishActivityWithData(int i2, String str) {
        Intent intent = new Intent();
        if (!(str == null || str.length() == 0)) {
            intent.putExtra(PaymentsLockConstants.Companion.getLOCK_MESSAGE_TYPE(), str);
            showToast(str);
        }
        setResult(i2, intent);
        finish();
    }

    private final void callNativeLockScreen() {
        if (Build.VERSION.SDK_INT >= 21) {
            c.a aVar = c.f7365a;
            if (c.a.c(this)) {
                Object systemService = getSystemService("keyguard");
                if (systemService != null) {
                    PaymentsConfig instance = PaymentsConfig.getInstance();
                    k.b(instance, "PaymentsConfig.getInstance()");
                    try {
                        startActivityForResult(((KeyguardManager) systemService).createConfirmDeviceCredentialIntent("Unlock", instance.getAppContext().getString(R.string.mp_confirm_address_or_pin)), this.LOCK_REQUEST_CODE);
                        return;
                    } catch (Exception unused) {
                        finishActivityWithData(0, "Authantication failed");
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
                }
            }
        }
        finishActivityWithData$default(this, -1, (String) null, 2, (Object) null);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            finishActivityWithData$default(this, -1, (String) null, 2, (Object) null);
        } else {
            finishActivityWithData(0, "Authantication failed");
        }
    }

    private final void showToast(String str) {
        Toast.makeText(this, str, 1).show();
    }
}
