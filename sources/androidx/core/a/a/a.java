package androidx.core.a.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2619a;

    /* renamed from: androidx.core.a.a.a$a  reason: collision with other inner class name */
    public static abstract class C0037a {
        public void a() {
        }

        public void a(b bVar) {
        }

        public void a(CharSequence charSequence) {
        }

        public void b(int i2, CharSequence charSequence) {
        }
    }

    public static a a(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.f2619a = context;
    }

    public final boolean a() {
        FingerprintManager b2;
        if (Build.VERSION.SDK_INT < 23 || (b2 = b(this.f2619a)) == null || !b2.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        FingerprintManager b2;
        if (Build.VERSION.SDK_INT < 23 || (b2 = b(this.f2619a)) == null || !b2.isHardwareDetected()) {
            return false;
        }
        return true;
    }

    public static FingerprintManager b(Context context) {
        if (Build.VERSION.SDK_INT == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (Build.VERSION.SDK_INT <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Signature f2622a;

        /* renamed from: b  reason: collision with root package name */
        public final Cipher f2623b;

        /* renamed from: c  reason: collision with root package name */
        public final Mac f2624c;

        public c(Signature signature) {
            this.f2622a = signature;
            this.f2623b = null;
            this.f2624c = null;
        }

        public c(Cipher cipher) {
            this.f2623b = cipher;
            this.f2622a = null;
            this.f2624c = null;
        }

        public c(Mac mac) {
            this.f2624c = mac;
            this.f2623b = null;
            this.f2622a = null;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f2621a;

        public b(c cVar) {
            this.f2621a = cVar;
        }
    }
}
