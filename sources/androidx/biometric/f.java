package androidx.biometric;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.biometric.c;
import androidx.core.a.a.a;
import androidx.core.d.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;

public class f extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    Executor f14523a;

    /* renamed from: b  reason: collision with root package name */
    c.a f14524b;

    /* renamed from: c  reason: collision with root package name */
    c.C0197c f14525c;

    /* renamed from: d  reason: collision with root package name */
    final a.C0037a f14526d = new a.C0037a() {
        /* access modifiers changed from: package-private */
        public final void a(final int i2, final CharSequence charSequence) {
            f.this.f14527e.a(3);
            if (!g.a()) {
                f.this.f14523a.execute(new Runnable() {
                    public final void run() {
                        f.this.f14524b.a(i2, charSequence);
                    }
                });
            }
        }

        public final void b(final int i2, final CharSequence charSequence) {
            if (i2 == 5) {
                if (f.this.f14531i == 0) {
                    a(i2, charSequence);
                }
                f.this.b();
            } else if (i2 == 7 || i2 == 9) {
                a(i2, charSequence);
                f.this.b();
            } else {
                if (charSequence == null) {
                    charSequence = f.this.f14530h.getResources().getString(R.string.default_error_msg);
                }
                if (g.a(i2)) {
                    i2 = 8;
                }
                f.this.f14527e.f14542a.obtainMessage(2, i2, 0, charSequence).sendToTarget();
                f.this.f14528f.postDelayed(new Runnable() {
                    public final void run() {
                        AnonymousClass1.this.a(i2, charSequence);
                        f.this.b();
                    }
                }, (long) e.a(f.this.getContext()));
            }
        }

        public final void a(CharSequence charSequence) {
            f.this.f14527e.a((Object) charSequence);
        }

        public final void a(a.b bVar) {
            f.this.f14527e.a(5);
            final c.b bVar2 = new c.b(f.a(bVar.f2621a));
            f.this.f14523a.execute(new Runnable() {
                public final void run() {
                    f.this.f14524b.a(bVar2);
                }
            });
            f.this.b();
        }

        public final void a() {
            f.this.f14527e.a((Object) f.this.f14530h.getResources().getString(R.string.fingerprint_not_recognized));
            f.this.f14523a.execute(new Runnable() {
                public final void run() {
                    f.this.f14524b.a();
                }
            });
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f14527e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Handler f14528f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14529g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f14530h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f14531i;
    private b j;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Handler f14542a;

        a(Handler handler) {
            this.f14542a = handler;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            this.f14542a.obtainMessage(i2).sendToTarget();
        }

        /* access modifiers changed from: package-private */
        public final void a(Object obj) {
            this.f14542a.obtainMessage(1, obj).sendToTarget();
        }
    }

    static f a() {
        return new f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f14530h = getContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r13, android.view.ViewGroup r14, android.os.Bundle r15) {
        /*
            r12 = this;
            boolean r0 = r12.f14529g
            if (r0 != 0) goto L_0x00b4
            androidx.core.d.b r0 = new androidx.core.d.b
            r0.<init>()
            r12.j = r0
            r0 = 0
            r12.f14531i = r0
            android.content.Context r1 = r12.f14530h
            androidx.core.a.a.a r1 = androidx.core.a.a.a.a(r1)
            boolean r2 = r1.b()
            r3 = 1
            if (r2 != 0) goto L_0x0022
            r0 = 12
            r12.b((int) r0)
        L_0x0020:
            r0 = 1
            goto L_0x002e
        L_0x0022:
            boolean r2 = r1.a()
            if (r2 != 0) goto L_0x002e
            r0 = 11
            r12.b((int) r0)
            goto L_0x0020
        L_0x002e:
            if (r0 == 0) goto L_0x003b
            androidx.biometric.f$a r0 = r12.f14527e
            r1 = 3
            r0.a((int) r1)
            r12.b()
            goto L_0x00b4
        L_0x003b:
            androidx.biometric.c$c r0 = r12.f14525c
            r2 = 0
            if (r0 == 0) goto L_0x0064
            javax.crypto.Cipher r4 = r0.f14495b
            if (r4 == 0) goto L_0x004c
            androidx.core.a.a.a$c r4 = new androidx.core.a.a.a$c
            javax.crypto.Cipher r0 = r0.f14495b
            r4.<init>((javax.crypto.Cipher) r0)
            goto L_0x0065
        L_0x004c:
            java.security.Signature r4 = r0.f14494a
            if (r4 == 0) goto L_0x0058
            androidx.core.a.a.a$c r4 = new androidx.core.a.a.a$c
            java.security.Signature r0 = r0.f14494a
            r4.<init>((java.security.Signature) r0)
            goto L_0x0065
        L_0x0058:
            javax.crypto.Mac r4 = r0.f14496c
            if (r4 == 0) goto L_0x0064
            androidx.core.a.a.a$c r4 = new androidx.core.a.a.a$c
            javax.crypto.Mac r0 = r0.f14496c
            r4.<init>((javax.crypto.Mac) r0)
            goto L_0x0065
        L_0x0064:
            r4 = r2
        L_0x0065:
            androidx.core.d.b r0 = r12.j
            androidx.core.a.a.a$a r5 = r12.f14526d
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 23
            if (r6 < r7) goto L_0x00b2
            android.content.Context r1 = r1.f2619a
            android.hardware.fingerprint.FingerprintManager r6 = androidx.core.a.a.a.b(r1)
            if (r6 == 0) goto L_0x00b2
            if (r0 == 0) goto L_0x0081
            java.lang.Object r0 = r0.c()
            android.os.CancellationSignal r0 = (android.os.CancellationSignal) r0
            r8 = r0
            goto L_0x0082
        L_0x0081:
            r8 = r2
        L_0x0082:
            if (r4 == 0) goto L_0x00a7
            javax.crypto.Cipher r0 = r4.f2623b
            if (r0 == 0) goto L_0x0090
            android.hardware.fingerprint.FingerprintManager$CryptoObject r2 = new android.hardware.fingerprint.FingerprintManager$CryptoObject
            javax.crypto.Cipher r0 = r4.f2623b
            r2.<init>(r0)
            goto L_0x00a7
        L_0x0090:
            java.security.Signature r0 = r4.f2622a
            if (r0 == 0) goto L_0x009c
            android.hardware.fingerprint.FingerprintManager$CryptoObject r2 = new android.hardware.fingerprint.FingerprintManager$CryptoObject
            java.security.Signature r0 = r4.f2622a
            r2.<init>(r0)
            goto L_0x00a7
        L_0x009c:
            javax.crypto.Mac r0 = r4.f2624c
            if (r0 == 0) goto L_0x00a7
            android.hardware.fingerprint.FingerprintManager$CryptoObject r2 = new android.hardware.fingerprint.FingerprintManager$CryptoObject
            javax.crypto.Mac r0 = r4.f2624c
            r2.<init>(r0)
        L_0x00a7:
            r7 = r2
            r9 = 0
            androidx.core.a.a.a$1 r10 = new androidx.core.a.a.a$1
            r10.<init>()
            r11 = 0
            r6.authenticate(r7, r8, r9, r10, r11)
        L_0x00b2:
            r12.f14529g = r3
        L_0x00b4:
            android.view.View r13 = super.onCreateView(r13, r14, r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.biometric.f.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public final void a(Executor executor, c.a aVar) {
        this.f14523a = executor;
        this.f14524b = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(Handler handler) {
        this.f14528f = handler;
        this.f14527e = new a(this.f14528f);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f14531i = i2;
        if (i2 == 1) {
            b(10);
        }
        b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
        b();
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f14529g = false;
        FragmentActivity activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().a().d(this).c();
        }
        if (!g.a()) {
            g.a(activity);
        }
    }

    private void b(int i2) {
        if (!g.a()) {
            this.f14524b.a(i2, a(this.f14530h, i2));
        }
    }

    private static String a(Context context, int i2) {
        if (i2 == 1) {
            return context.getString(R.string.fingerprint_error_hw_not_available);
        }
        switch (i2) {
            case 10:
                return context.getString(R.string.fingerprint_error_user_canceled);
            case 11:
                return context.getString(R.string.fingerprint_error_no_fingerprints);
            case 12:
                return context.getString(R.string.fingerprint_error_hw_not_present);
            default:
                return context.getString(R.string.default_error_msg);
        }
    }

    static /* synthetic */ c.C0197c a(a.c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.f2623b != null) {
            return new c.C0197c(cVar.f2623b);
        }
        if (cVar.f2622a != null) {
            return new c.C0197c(cVar.f2622a);
        }
        if (cVar.f2624c != null) {
            return new c.C0197c(cVar.f2624c);
        }
        return null;
    }
}
