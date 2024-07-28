package net.one97.paytm.paymentsBank.biometricAuthWall;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Base64;
import androidx.biometric.c;
import androidx.fragment.app.FragmentActivity;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.utils.m;

public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final b f17453d = new b((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public Cipher f17454a;

    /* renamed from: b  reason: collision with root package name */
    public androidx.biometric.c f17455b;

    /* renamed from: c  reason: collision with root package name */
    public c.d f17456c;

    /* renamed from: e  reason: collision with root package name */
    private androidx.biometric.c f17457e;

    /* renamed from: f  reason: collision with root package name */
    private KeyStore f17458f;

    /* renamed from: g  reason: collision with root package name */
    private KeyGenerator f17459g;

    /* renamed from: h  reason: collision with root package name */
    private Cipher f17460h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f17461i;

    public interface a {
        void a();

        void a(int i2, String str, String str2);

        void a(String str);

        void a(String str, String str2);

        void b(String str);

        void c(String str);
    }

    public e(a aVar, c.d dVar) {
        k.c(aVar, "mHost");
        k.c(dVar, "promptInfo");
        this.f17461i = aVar;
        this.f17456c = dVar;
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            k.a((Object) instance, "KeyStore.getInstance(ANDROID_KEY_STORE)");
            this.f17458f = instance;
        } catch (KeyStoreException unused) {
        }
        try {
            KeyGenerator instance2 = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            k.a((Object) instance2, "KeyGenerator.getInstance…M_AES, ANDROID_KEY_STORE)");
            this.f17459g = instance2;
        } catch (Exception unused2) {
        }
        try {
            Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS7Padding");
            k.a((Object) instance3, "Cipher.getInstance(cipherString)");
            this.f17460h = instance3;
            Cipher instance4 = Cipher.getInstance("AES/CBC/PKCS7Padding");
            k.a((Object) instance4, "Cipher.getInstance(cipherString)");
            this.f17454a = instance4;
        } catch (Exception unused3) {
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static c.d a(String str, String str2, String str3, String str4) {
            k.c(str, "title");
            k.c(str2, "subTitle");
            k.c(str3, "desc");
            k.c(str4, "negativeBtnText");
            c.d b2 = new c.d.a().a(str).b(str3).a().c(str4).b();
            k.a((Object) b2, "BiometricPrompt.PromptIn…\n                .build()");
            return b2;
        }
    }

    public final void a(FragmentActivity fragmentActivity, String str) {
        k.c(fragmentActivity, "fragment");
        k.c(str, "xCode");
        try {
            a("bank_biometric_key");
            this.f17457e = b(fragmentActivity, str);
            Cipher cipher = this.f17460h;
            if (cipher == null) {
                k.a("cipher");
            }
            if (a(cipher, "bank_biometric_key")) {
                androidx.biometric.c cVar = this.f17457e;
                if (cVar == null) {
                    k.a();
                }
                c.d dVar = this.f17456c;
                Cipher cipher2 = this.f17460h;
                if (cipher2 == null) {
                    k.a("cipher");
                }
                cVar.a(dVar, new c.C0197c(cipher2));
                return;
            }
            this.f17461i.a();
        } catch (Exception unused) {
        }
    }

    private final void a(String str) {
        try {
            KeyStore keyStore = this.f17458f;
            if (keyStore == null) {
                k.a("keyStore");
            }
            keyStore.load((KeyStore.LoadStoreParameter) null);
            KeyGenParameterSpec.Builder encryptionPaddings = new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{"CBC"}).setUserAuthenticationRequired(true).setEncryptionPaddings(new String[]{"PKCS7Padding"});
            if (Build.VERSION.SDK_INT >= 24) {
                encryptionPaddings.setInvalidatedByBiometricEnrollment(true);
            }
            KeyGenerator keyGenerator = this.f17459g;
            if (keyGenerator == null) {
                k.a("keyGenerator");
            }
            keyGenerator.init(encryptionPaddings.build());
            keyGenerator.generateKey();
        } catch (Exception unused) {
        }
    }

    private final androidx.biometric.c b(FragmentActivity fragmentActivity, String str) {
        return new androidx.biometric.c(fragmentActivity, androidx.core.content.b.f(fragmentActivity.getApplicationContext()), (c.a) new d(this, fragmentActivity, str));
    }

    public static final class d extends c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f17464a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f17465b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f17466c;

        d(e eVar, FragmentActivity fragmentActivity, String str) {
            this.f17464a = eVar;
            this.f17465b = fragmentActivity;
            this.f17466c = str;
        }

        public final void a(int i2, CharSequence charSequence) {
            k.c(charSequence, "errString");
            super.a(i2, charSequence);
            m.a(this.f17465b, "biometric_enabled_fail", "biometric passcode", SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL, "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            this.f17464a.f17461i.a(i2, (String) charSequence, "encryption_flow");
        }

        public final void a() {
            super.a();
            m.a(this.f17465b, "biometric_enabled_fail", "biometric passcode", SDKConstants.CUI_VALUE_PAYMENT_STATUS_FAIL, "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            this.f17464a.f17461i.b("encryption_flow");
        }

        public final void a(c.b bVar) {
            k.c(bVar, "result");
            super.a(bVar);
            m.a(this.f17465b, "biometric_enabled_success", "biometric passcode", "success", "", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            e.a(this.f17464a, bVar, this.f17466c);
        }
    }

    public static final class c extends c.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f17462a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17463b;

        public c(e eVar, String str) {
            this.f17462a = eVar;
            this.f17463b = str;
        }

        public final void a(int i2, CharSequence charSequence) {
            k.c(charSequence, "errString");
            super.a(i2, charSequence);
            this.f17462a.f17461i.a(i2, (String) charSequence, "decryption_flow");
        }

        public final void a() {
            super.a();
            this.f17462a.f17461i.b("decryption_flow");
        }

        public final void a(c.b bVar) {
            k.c(bVar, "result");
            super.a(bVar);
            e.b(this.f17462a, bVar, this.f17463b);
        }
    }

    public final boolean a(Cipher cipher, String str, String str2) {
        try {
            KeyStore keyStore = this.f17458f;
            if (keyStore == null) {
                k.a("keyStore");
            }
            keyStore.load((KeyStore.LoadStoreParameter) null);
            KeyStore keyStore2 = this.f17458f;
            if (keyStore2 == null) {
                k.a("keyStore");
            }
            Key key = keyStore2.getKey(str, (char[]) null);
            if (key != null) {
                cipher.init(2, (SecretKey) key, new IvParameterSpec(Base64.decode(str2, 0)));
                return true;
            }
            throw new u("null cannot be cast to non-null type javax.crypto.SecretKey");
        } catch (Exception e2) {
            if (e2 instanceof KeyPermanentlyInvalidatedException) {
                this.f17461i.c("decryption_flow");
            }
            return false;
        }
    }

    private final boolean a(Cipher cipher, String str) {
        try {
            KeyStore keyStore = this.f17458f;
            if (keyStore == null) {
                k.a("keyStore");
            }
            keyStore.load((KeyStore.LoadStoreParameter) null);
            KeyStore keyStore2 = this.f17458f;
            if (keyStore2 == null) {
                k.a("keyStore");
            }
            Key key = keyStore2.getKey(str, (char[]) null);
            if (key != null) {
                cipher.init(1, (SecretKey) key);
                return true;
            }
            throw new u("null cannot be cast to non-null type javax.crypto.SecretKey");
        } catch (Exception e2) {
            if (!(e2 instanceof KeyPermanentlyInvalidatedException)) {
                return false;
            }
            this.f17461i.c("encryption_flow");
            return false;
        }
    }

    public static final /* synthetic */ void a(e eVar, c.b bVar, String str) {
        Cipher a2;
        try {
            c.C0197c a3 = bVar.a();
            if (a3 != null && (a2 = a3.a()) != null) {
                a aVar = eVar.f17461i;
                k.a((Object) a2, "it");
                String encodeToString = Base64.encodeToString(a2.getIV(), 0);
                k.a((Object) encodeToString, "Base64.encodeToString(it.iv, Base64.DEFAULT)");
                Charset charset = kotlin.m.d.f47971a;
                if (str != null) {
                    byte[] bytes = str.getBytes(charset);
                    k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    String encodeToString2 = Base64.encodeToString(a2.doFinal(bytes), 0);
                    k.a((Object) encodeToString2, "Base64.encodeToString(it…Array()), Base64.DEFAULT)");
                    aVar.a(encodeToString, encodeToString2);
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void b(e eVar, c.b bVar, String str) {
        Cipher a2;
        try {
            c.C0197c a3 = bVar.a();
            if (a3 != null && (a2 = a3.a()) != null) {
                byte[] doFinal = a2.doFinal(Base64.decode(str, 0));
                k.a((Object) doFinal, "it.doFinal(Base64.decode…edXCode, Base64.DEFAULT))");
                eVar.f17461i.a(new String(doFinal, kotlin.m.d.f47971a));
            }
        } catch (Exception unused) {
        }
    }
}
