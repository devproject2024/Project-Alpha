package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.a.a;
import androidx.loader.b.c;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.internal.p000authapi.b;
import easypay.manager.Constants;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

public class SignInHubActivity extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8247a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8248b = false;

    /* renamed from: c  reason: collision with root package name */
    private SignInConfiguration f8249c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8250d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f8251e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Intent f8252f;

    class a implements a.C0056a<Void> {
        private a() {
        }

        public final void a(c<Void> cVar) {
        }

        public final c<Void> a(Bundle bundle) {
            return new g(SignInHubActivity.this, e.a());
        }

        public final /* synthetic */ void a(c cVar, Object obj) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f8251e, SignInHubActivity.this.f8252f);
            SignInHubActivity.this.finish();
        }

        /* synthetic */ a(SignInHubActivity signInHubActivity, byte b2) {
            this();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = (String) b.a(intent.getAction());
        if ("com.google.android.gms.auth.NO_IMPL".equals(str)) {
            a(12500);
        } else if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            SignInConfiguration signInConfiguration = (SignInConfiguration) ((Bundle) b.a(intent.getBundleExtra(Constants.EASY_PAY_CONFIG_PREF_KEY))).getParcelable(Constants.EASY_PAY_CONFIG_PREF_KEY);
            if (signInConfiguration == null) {
                setResult(0);
                finish();
                return;
            }
            this.f8249c = signInConfiguration;
            if (bundle != null) {
                this.f8250d = bundle.getBoolean("signingInGoogleApiClients");
                if (this.f8250d) {
                    this.f8251e = bundle.getInt("signInResultCode");
                    this.f8252f = (Intent) b.a((Intent) bundle.getParcelable("signInResultData"));
                    a();
                }
            } else if (f8247a) {
                setResult(0);
                a(12502);
            } else {
                f8247a = true;
                Intent intent2 = new Intent(str);
                if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra(Constants.EASY_PAY_CONFIG_PREF_KEY, this.f8249c);
                try {
                    startActivityForResult(intent2, 40962);
                } catch (ActivityNotFoundException unused) {
                    this.f8248b = true;
                    a(17);
                }
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown action: ".concat(valueOf);
            } else {
                new String("Unknown action: ");
            }
            finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f8250d);
        if (this.f8250d) {
            bundle.putInt("signInResultCode", this.f8251e);
            bundle.putParcelable("signInResultData", this.f8252f);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.f8248b) {
            setResult(0);
            if (i2 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.f8229a != null) {
                        GoogleSignInAccount googleSignInAccount = signInAccount.f8229a;
                        n.a(this).a(this.f8249c.f8245a, (GoogleSignInAccount) b.a(googleSignInAccount));
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", googleSignInAccount);
                        this.f8250d = true;
                        this.f8251e = i3;
                        this.f8252f = intent;
                        a();
                        return;
                    } else if (intent.hasExtra(CLConstants.FIELD_ERROR_CODE)) {
                        int intExtra = intent.getIntExtra(CLConstants.FIELD_ERROR_CODE, 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        a(intExtra);
                        return;
                    }
                }
                a(8);
            }
        }
    }

    private final void a() {
        getSupportLoaderManager().a(0, (Bundle) null, new a(this, (byte) 0));
        f8247a = false;
    }

    private final void a(int i2) {
        Status status = new Status(i2);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f8247a = false;
    }
}
