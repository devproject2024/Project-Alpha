package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

final class g {
    static boolean a(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                return false;
            default:
                return true;
        }
    }

    static void a(FragmentActivity fragmentActivity, Bundle bundle, Runnable runnable) {
        KeyguardManager keyguardManager;
        CharSequence charSequence;
        if (fragmentActivity instanceof DeviceCredentialHandlerActivity) {
            DeviceCredentialHandlerActivity deviceCredentialHandlerActivity = (DeviceCredentialHandlerActivity) fragmentActivity;
            if (Build.VERSION.SDK_INT >= 23) {
                keyguardManager = (KeyguardManager) deviceCredentialHandlerActivity.getSystemService(KeyguardManager.class);
            } else {
                Object systemService = deviceCredentialHandlerActivity.getSystemService("keyguard");
                if (!(systemService instanceof KeyguardManager)) {
                    deviceCredentialHandlerActivity.a(0);
                    return;
                }
                keyguardManager = (KeyguardManager) systemService;
            }
            if (keyguardManager == null) {
                deviceCredentialHandlerActivity.a(0);
                return;
            }
            CharSequence charSequence2 = null;
            if (bundle != null) {
                charSequence2 = bundle.getCharSequence("title");
                charSequence = bundle.getCharSequence("subtitle");
            } else {
                charSequence = null;
            }
            Intent createConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(charSequence2, charSequence);
            if (createConfirmDeviceCredentialIntent == null) {
                deviceCredentialHandlerActivity.a(0);
                return;
            }
            d a2 = d.a();
            a2.f14504f = true;
            a2.f14506h = 2;
            if (runnable != null) {
                runnable.run();
            }
            createConfirmDeviceCredentialIntent.setFlags(134742016);
            deviceCredentialHandlerActivity.startActivityForResult(createConfirmDeviceCredentialIntent, 0);
        }
    }

    static void a(FragmentActivity fragmentActivity) {
        if ((fragmentActivity instanceof DeviceCredentialHandlerActivity) && !fragmentActivity.isFinishing()) {
            fragmentActivity.finish();
        }
    }

    static boolean a(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        if (a(context, str, R.array.crypto_fingerprint_fallback_vendors) || b(context, str2, R.array.crypto_fingerprint_fallback_prefixes)) {
            return true;
        }
        return false;
    }

    static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return b(context, str, R.array.hide_fingerprint_instantly_prefixes);
    }

    private static boolean a(Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String equalsIgnoreCase : context.getResources().getStringArray(i2)) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Context context, String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String startsWith : context.getResources().getStringArray(i2)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    static boolean a() {
        d dVar = d.f14499a;
        return dVar != null && dVar.f14504f;
    }
}
