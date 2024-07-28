package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import androidx.core.a.a.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f14480a;

    /* renamed from: b  reason: collision with root package name */
    private final BiometricManager f14481b;

    public static b a(Context context) {
        return new b(context);
    }

    private b(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f14481b = (BiometricManager) context.getSystemService(BiometricManager.class);
            this.f14480a = null;
            return;
        }
        this.f14481b = null;
        this.f14480a = a.a(context);
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f14481b.canAuthenticate();
        }
        if (!this.f14480a.b()) {
            return 12;
        }
        return !this.f14480a.a() ? 11 : 0;
    }
}
