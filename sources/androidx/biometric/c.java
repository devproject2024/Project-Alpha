package androidx.biometric;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.biometric.e;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.p;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final Executor f14482a;

    /* renamed from: b  reason: collision with root package name */
    final a f14483b;

    /* renamed from: c  reason: collision with root package name */
    e f14484c;

    /* renamed from: d  reason: collision with root package name */
    f f14485d;

    /* renamed from: e  reason: collision with root package name */
    a f14486e;

    /* renamed from: f  reason: collision with root package name */
    boolean f14487f;

    /* renamed from: g  reason: collision with root package name */
    boolean f14488g;

    /* renamed from: h  reason: collision with root package name */
    final DialogInterface.OnClickListener f14489h = new DialogInterface.OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i2) {
            c.this.f14482a.execute(new Runnable() {
                public final void run() {
                    if (c.c() && c.this.f14486e != null) {
                        CharSequence charSequence = c.this.f14486e.f14465f;
                        a aVar = c.this.f14483b;
                        if (charSequence == null) {
                            charSequence = "";
                        }
                        aVar.a(13, charSequence);
                        c.this.f14486e.c();
                    } else if (c.this.f14484c != null && c.this.f14485d != null) {
                        CharSequence charSequence2 = c.this.f14484c.f14509b.getCharSequence("negative_text");
                        a aVar2 = c.this.f14483b;
                        if (charSequence2 == null) {
                            charSequence2 = "";
                        }
                        aVar2.a(13, charSequence2);
                        c.this.f14485d.a(2);
                    }
                }
            });
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private FragmentActivity f14490i;
    private Fragment j;
    private final p k = new BiometricPrompt$2(this);

    public static abstract class a {
        public void a() {
        }

        public void a(int i2, CharSequence charSequence) {
        }

        public void a(b bVar) {
        }
    }

    /* renamed from: androidx.biometric.c$c  reason: collision with other inner class name */
    public static class C0197c {

        /* renamed from: a  reason: collision with root package name */
        final Signature f14494a;

        /* renamed from: b  reason: collision with root package name */
        final Cipher f14495b;

        /* renamed from: c  reason: collision with root package name */
        final Mac f14496c;

        public C0197c(Signature signature) {
            this.f14494a = signature;
            this.f14495b = null;
            this.f14496c = null;
        }

        public C0197c(Cipher cipher) {
            this.f14495b = cipher;
            this.f14494a = null;
            this.f14496c = null;
        }

        public C0197c(Mac mac) {
            this.f14496c = mac;
            this.f14495b = null;
            this.f14494a = null;
        }

        public final Cipher a() {
            return this.f14495b;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final C0197c f14493a;

        b(C0197c cVar) {
            this.f14493a = cVar;
        }

        public final C0197c a() {
            return this.f14493a;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        Bundle f14497a;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private final Bundle f14498a = new Bundle();

            public final a a(CharSequence charSequence) {
                this.f14498a.putCharSequence("title", charSequence);
                return this;
            }

            public final a b(CharSequence charSequence) {
                this.f14498a.putCharSequence(RequestConfirmationDialogFragment.KEY_DESCRIPTION, charSequence);
                return this;
            }

            public final a c(CharSequence charSequence) {
                this.f14498a.putCharSequence("negative_text", charSequence);
                return this;
            }

            public final a a() {
                this.f14498a.putBoolean("require_confirmation", false);
                return this;
            }

            public final d b() {
                CharSequence charSequence = this.f14498a.getCharSequence("title");
                CharSequence charSequence2 = this.f14498a.getCharSequence("negative_text");
                boolean z = this.f14498a.getBoolean("allow_device_credential");
                boolean z2 = this.f14498a.getBoolean("handling_device_credential_result");
                if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("Title must be set and non-empty");
                } else if (TextUtils.isEmpty(charSequence2) && !z) {
                    throw new IllegalArgumentException("Negative text must be set and non-empty");
                } else if (!TextUtils.isEmpty(charSequence2) && z) {
                    throw new IllegalArgumentException("Can't have both negative button behavior and device credential enabled");
                } else if (!z2 || z) {
                    return new d(this.f14498a);
                } else {
                    throw new IllegalArgumentException("Can't be handling device credential result without device credential enabled");
                }
            }
        }

        d(Bundle bundle) {
            this.f14497a = bundle;
        }

        public final boolean a() {
            return this.f14497a.getBoolean("allow_device_credential");
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return this.f14497a.getBoolean("handling_device_credential_result");
        }
    }

    public c(FragmentActivity fragmentActivity, Executor executor, a aVar) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null");
        } else if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null");
        } else if (aVar != null) {
            this.f14490i = fragmentActivity;
            this.f14483b = aVar;
            this.f14482a = executor;
            this.f14490i.getLifecycle().a(this.k);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null");
        }
    }

    public c(Fragment fragment, Executor executor, a aVar) {
        if (executor != null) {
            this.j = fragment;
            this.f14483b = aVar;
            this.f14482a = executor;
            this.j.getLifecycle().a(this.k);
            return;
        }
        throw new IllegalArgumentException("Executor must not be null");
    }

    /* access modifiers changed from: package-private */
    public final void b(d dVar, C0197c cVar) {
        d dVar2;
        this.f14488g = dVar.b();
        FragmentActivity a2 = a();
        if (dVar.a() && Build.VERSION.SDK_INT <= 28) {
            if (!this.f14488g) {
                a(dVar);
                return;
            } else if (Build.VERSION.SDK_INT >= 21) {
                if (a2 != null && (dVar2 = d.f14499a) != null) {
                    if (!dVar2.f14504f && b.a(a2).a() != 0) {
                        g.a(a2, dVar.f14497a, (Runnable) null);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        j b2 = b();
        if (!b2.i()) {
            Bundle bundle = dVar.f14497a;
            boolean z = false;
            this.f14487f = false;
            if (!(a2 == null || cVar == null || !g.a((Context) a2, Build.MANUFACTURER, Build.MODEL))) {
                z = true;
            }
            if (z || !c()) {
                e eVar = (e) b2.c("FingerprintDialogFragment");
                if (eVar != null) {
                    this.f14484c = eVar;
                } else {
                    this.f14484c = e.a();
                }
                e eVar2 = this.f14484c;
                eVar2.f14510c = this.f14489h;
                eVar2.f14509b = bundle;
                if (a2 != null && !g.a(a2, Build.MODEL)) {
                    if (eVar == null) {
                        this.f14484c.show(b2, "FingerprintDialogFragment");
                    } else if (this.f14484c.isDetached()) {
                        b2.a().f(this.f14484c).c();
                    }
                }
                f fVar = (f) b2.c("FingerprintHelperFragment");
                if (fVar != null) {
                    this.f14485d = fVar;
                } else {
                    this.f14485d = f.a();
                }
                this.f14485d.a(this.f14482a, this.f14483b);
                e.a aVar = this.f14484c.f14508a;
                this.f14485d.a((Handler) aVar);
                this.f14485d.f14525c = cVar;
                aVar.sendMessageDelayed(aVar.obtainMessage(6), 500);
                if (fVar == null) {
                    b2.a().a((Fragment) this.f14485d, "FingerprintHelperFragment").c();
                } else if (this.f14485d.isDetached()) {
                    b2.a().f(this.f14485d).c();
                }
            } else {
                a aVar2 = (a) b2.c("BiometricFragment");
                if (aVar2 != null) {
                    this.f14486e = aVar2;
                } else {
                    this.f14486e = a.a();
                }
                this.f14486e.a(this.f14482a, this.f14489h, this.f14483b);
                a aVar3 = this.f14486e;
                aVar3.f14464e = cVar;
                aVar3.f14460a = bundle;
                if (aVar2 == null) {
                    b2.a().a((Fragment) this.f14486e, "BiometricFragment").c();
                } else if (aVar3.isDetached()) {
                    b2.a().f(this.f14486e).c();
                }
            }
            b2.b();
        }
    }

    private void a(d dVar) {
        FragmentActivity a2 = a();
        if (a2 != null && !a2.isFinishing()) {
            a(true);
            Bundle bundle = dVar.f14497a;
            bundle.putBoolean("handling_device_credential_result", true);
            Intent intent = new Intent(a2, DeviceCredentialHandlerActivity.class);
            intent.putExtra("prompt_info_bundle", bundle);
            a2.startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        f fVar;
        a aVar;
        if (Build.VERSION.SDK_INT < 29) {
            d a2 = d.a();
            if (!this.f14488g) {
                FragmentActivity a3 = a();
                if (a3 != null) {
                    try {
                        a2.f14500b = a3.getPackageManager().getActivityInfo(a3.getComponentName(), 0).getThemeResource();
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
            } else if (!c() || (aVar = this.f14486e) == null) {
                e eVar = this.f14484c;
                if (!(eVar == null || (fVar = this.f14485d) == null)) {
                    a2.a(eVar, fVar);
                }
            } else {
                a2.f14501c = aVar;
            }
            a2.a(this.f14482a, this.f14489h, this.f14483b);
            if (z) {
                a2.f14506h = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final FragmentActivity a() {
        FragmentActivity fragmentActivity = this.f14490i;
        return fragmentActivity != null ? fragmentActivity : this.j.getActivity();
    }

    /* access modifiers changed from: package-private */
    public final j b() {
        FragmentActivity fragmentActivity = this.f14490i;
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        return this.j.getChildFragmentManager();
    }

    static boolean c() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public final void a(d dVar, C0197c cVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("PromptInfo can not be null");
        } else if (!dVar.f14497a.getBoolean("allow_device_credential")) {
            b(dVar, cVar);
        } else {
            throw new IllegalArgumentException("Device credential not supported with crypto");
        }
    }
}
