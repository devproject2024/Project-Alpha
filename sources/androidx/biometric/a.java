package androidx.biometric;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.biometric.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.concurrent.Executor;

public class a extends Fragment {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Bundle f14460a;

    /* renamed from: b  reason: collision with root package name */
    Executor f14461b;

    /* renamed from: c  reason: collision with root package name */
    DialogInterface.OnClickListener f14462c;

    /* renamed from: d  reason: collision with root package name */
    c.a f14463d;

    /* renamed from: e  reason: collision with root package name */
    c.C0197c f14464e;

    /* renamed from: f  reason: collision with root package name */
    CharSequence f14465f;

    /* renamed from: g  reason: collision with root package name */
    final BiometricPrompt.AuthenticationCallback f14466g = new BiometricPrompt.AuthenticationCallback() {
        public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        public final void onAuthenticationError(final int i2, final CharSequence charSequence) {
            if (!g.a()) {
                a.this.f14461b.execute(new Runnable() {
                    public final void run() {
                        CharSequence charSequence = charSequence;
                        if (charSequence == null) {
                            charSequence = a.this.f14467h.getString(R.string.default_error_msg) + " " + i2;
                        }
                        a.this.f14463d.a(g.a(i2) ? 8 : i2, charSequence);
                    }
                });
                a.this.c();
            }
        }

        public final void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            final c.b bVar = authenticationResult != null ? new c.b(a.a(authenticationResult.getCryptoObject())) : new c.b((c.C0197c) null);
            a.this.f14461b.execute(new Runnable() {
                public final void run() {
                    a.this.f14463d.a(bVar);
                }
            });
            a.this.c();
        }

        public final void onAuthenticationFailed() {
            a.this.f14461b.execute(new Runnable() {
                public final void run() {
                    a.this.f14463d.a();
                }
            });
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f14467h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14468i;
    private BiometricPrompt j;
    private CancellationSignal k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public final Handler m = new Handler(Looper.getMainLooper());
    private final Executor n = new Executor() {
        public final void execute(Runnable runnable) {
            a.this.m.post(runnable);
        }
    };
    private final DialogInterface.OnClickListener o = new DialogInterface.OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i2) {
            a.this.f14462c.onClick(dialogInterface, i2);
        }
    };
    private final DialogInterface.OnClickListener p = new DialogInterface.OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                g.a(a.this.getActivity(), a.this.f14460a, (Runnable) null);
            }
        }
    };

    static a a() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public final void a(Executor executor, DialogInterface.OnClickListener onClickListener, c.a aVar) {
        this.f14461b = executor;
        this.f14462c = onClickListener;
        this.f14463d = aVar;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (Build.VERSION.SDK_INT < 29 || !d() || this.l) {
            CancellationSignal cancellationSignal = this.k;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f14468i = false;
        FragmentActivity activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().a().d(this).c();
        }
        g.a(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        Bundle bundle = this.f14460a;
        if (bundle == null || !bundle.getBoolean("allow_device_credential", false)) {
            return false;
        }
        return true;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f14467h = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        BiometricPrompt.CryptoObject cryptoObject;
        if (!this.f14468i && (bundle2 = this.f14460a) != null) {
            this.f14465f = bundle2.getCharSequence("negative_text");
            BiometricPrompt.Builder builder = new BiometricPrompt.Builder(getContext());
            builder.setTitle(this.f14460a.getCharSequence("title")).setSubtitle(this.f14460a.getCharSequence("subtitle")).setDescription(this.f14460a.getCharSequence(RequestConfirmationDialogFragment.KEY_DESCRIPTION));
            boolean z = this.f14460a.getBoolean("allow_device_credential");
            if (z && Build.VERSION.SDK_INT <= 28) {
                this.f14465f = getString(R.string.confirm_device_credential_password);
                builder.setNegativeButton(this.f14465f, this.f14461b, this.p);
            } else if (!TextUtils.isEmpty(this.f14465f)) {
                builder.setNegativeButton(this.f14465f, this.f14461b, this.o);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setConfirmationRequired(this.f14460a.getBoolean("require_confirmation", true));
                builder.setDeviceCredentialAllowed(z);
            }
            if (z) {
                this.l = false;
                this.m.postDelayed(new Runnable() {
                    public final void run() {
                        boolean unused = a.this.l = true;
                    }
                }, 250);
            }
            this.j = builder.build();
            this.k = new CancellationSignal();
            c.C0197c cVar = this.f14464e;
            if (cVar == null) {
                this.j.authenticate(this.k, this.n, this.f14466g);
            } else {
                BiometricPrompt biometricPrompt = this.j;
                if (cVar != null) {
                    if (cVar.f14495b != null) {
                        cryptoObject = new BiometricPrompt.CryptoObject(cVar.f14495b);
                    } else if (cVar.f14494a != null) {
                        cryptoObject = new BiometricPrompt.CryptoObject(cVar.f14494a);
                    } else if (cVar.f14496c != null) {
                        cryptoObject = new BiometricPrompt.CryptoObject(cVar.f14496c);
                    }
                    biometricPrompt.authenticate(cryptoObject, this.k, this.n, this.f14466g);
                }
                cryptoObject = null;
                biometricPrompt.authenticate(cryptoObject, this.k, this.n, this.f14466g);
            }
        }
        this.f14468i = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    static /* synthetic */ c.C0197c a(BiometricPrompt.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new c.C0197c(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new c.C0197c(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new c.C0197c(cryptoObject.getMac());
        }
        return null;
    }
}
