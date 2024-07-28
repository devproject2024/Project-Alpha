package net.one97.paytm.oauth.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.a.k;
import kotlin.m.d;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.oauth.OauthModule;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final o f56791a = new o();

    /* renamed from: b  reason: collision with root package name */
    private static String f56792b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f56793c;

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f56794d = k.a(k.d("Authorization", "x-public-key", "x-epoch", "x-latitude", "x-longitude", SDKConstants.X_DEVICE_IDENTIFIER, "x-device-manufacturer", "x-device-name", "autoReadHash", "session_token", "data", "verification_type"), new a());

    /* renamed from: e  reason: collision with root package name */
    private static String f56795e = "OAuthCryptoHelper";

    private o() {
    }

    public static boolean a() {
        kotlin.g.b.k.a((Object) net.one97.paytm.oauth.a.a(), "OAuthGTMHelper.getInstance()");
        return net.one97.paytm.oauth.a.d();
    }

    public static boolean a(String str) {
        kotlin.g.b.k.c(str, "mobileNo");
        f56792b = str;
        if (b() != null) {
            f56793c = true;
            return true;
        }
        f56793c = false;
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            kotlin.g.b.k.a((Object) instance, "KeyPairGenerator.getInst…M_RSA, ANDROID_KEY_STORE)");
            if (Build.VERSION.SDK_INT >= 23) {
                KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(d(), 4);
                builder.setCertificateSubject(new X500Principal("CN=Paytm, O=One97 Communications Ltd."));
                builder.setKeySize(EmiUtil.EMI_PLAN_REQUEST_CODE);
                builder.setDigests(new String[]{"SHA-256"});
                builder.setSignaturePaddings(new String[]{"PKCS1"});
                instance.initialize(builder.build());
            } else {
                net.one97.paytm.oauth.b b2 = OauthModule.b();
                kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
                KeyPairGeneratorSpec.Builder builder2 = new KeyPairGeneratorSpec.Builder(b2.getApplicationContext());
                builder2.setAlias(d());
                builder2.setSubject(new X500Principal("CN=Paytm, O=One97 Communications Ltd."));
                builder2.setSerialNumber(BigInteger.ONE);
                Calendar instance2 = Calendar.getInstance();
                kotlin.g.b.k.a((Object) instance2, "Calendar.getInstance()");
                builder2.setStartDate(instance2.getTime());
                Calendar instance3 = Calendar.getInstance();
                instance3.add(1, 30);
                kotlin.g.b.k.a((Object) instance3, "endDate");
                builder2.setEndDate(instance3.getTime());
                if (Build.VERSION.SDK_INT >= 19) {
                    builder2.setKeySize(EmiUtil.EMI_PLAN_REQUEST_CODE);
                }
                instance.initialize(builder2.build());
            }
            kotlin.g.b.k.a((Object) instance.generateKeyPair(), "keyPairGenerator.generateKeyPair()");
            return true;
        } catch (GeneralSecurityException e2) {
            e2.printStackTrace();
            return false;
        } catch (ProviderException e3) {
            e3.printStackTrace();
            return false;
        } catch (NullPointerException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static final class a<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a((String) t, (String) t2);
        }
    }

    public static final class b<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return kotlin.b.a.a(((String) t).toString(), ((String) t2).toString());
        }
    }

    private static String c(String str) {
        PrivateKey c2 = c();
        if (c2 != null) {
            try {
                Signature instance = Signature.getInstance("SHA256withRSA");
                instance.initSign(c2);
                Charset charset = d.f47971a;
                if (str != null) {
                    byte[] bytes = str.getBytes(charset);
                    kotlin.g.b.k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    instance.update(bytes);
                    String encodeToString = Base64.encodeToString(instance.sign(), 2);
                    kotlin.g.b.k.a((Object) encodeToString, "Base64.encodeToString(signature, Base64.NO_WRAP)");
                    return encodeToString;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
            } catch (SignatureException e4) {
                e4.printStackTrace();
            }
        }
        return "";
    }

    public static void a(String str, String str2, HashMap<String, String> hashMap, String str3) {
        String str4;
        String str5;
        kotlin.g.b.k.c(str, "urlWithParams");
        kotlin.g.b.k.c(str2, "httpMethod");
        kotlin.g.b.k.c(hashMap, "headers");
        if (a()) {
            Uri parse = Uri.parse(p.b(str).toString());
            kotlin.g.b.k.a((Object) parse, "uri");
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            kotlin.g.b.k.a((Object) queryParameterNames, "uri.queryParameterNames");
            List a2 = k.a(queryParameterNames, new b());
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            for (Object next : a2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    k.a();
                }
                String str6 = (String) next;
                if (i3 > 0) {
                    sb.append(AppConstants.AND_SIGN);
                }
                StringBuilder sb2 = new StringBuilder();
                kotlin.g.b.k.a((Object) str6, "key");
                if (str6 != null) {
                    sb2.append(p.b(str6).toString());
                    sb2.append('=');
                    String queryParameter = parse.getQueryParameter(str6);
                    if (queryParameter != null) {
                        if (queryParameter != null) {
                            str5 = p.b(queryParameter).toString();
                            if (str5 != null) {
                                sb2.append(str5);
                                sb.append(sb2.toString());
                                i3 = i4;
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                    str5 = "";
                    sb2.append(str5);
                    sb.append(sb2.toString());
                    i3 = i4;
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            StringBuilder sb3 = new StringBuilder();
            for (Object next2 : f56794d) {
                int i5 = i2 + 1;
                if (i2 < 0) {
                    k.a();
                }
                String str7 = (String) next2;
                if (!TextUtils.isEmpty(hashMap.get(str7))) {
                    if (i2 > 0) {
                        sb3.append(AppConstants.AND_SIGN);
                    }
                    StringBuilder sb4 = new StringBuilder();
                    if (str7 != null) {
                        sb4.append(p.b(str7).toString());
                        sb4.append('=');
                        String str8 = hashMap.get(str7);
                        if (str8 == null) {
                            str4 = null;
                        } else if (str8 != null) {
                            str4 = p.b(str8).toString();
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        sb4.append(str4);
                        sb3.append(sb4.toString());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
                i2 = i5;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(parse.getPath());
            sb5.append('|');
            sb5.append(str2);
            sb5.append('|');
            sb5.append(sb);
            sb5.append('|');
            sb5.append(sb3);
            sb5.append('|');
            if (str3 == null) {
                str3 = "";
            }
            sb5.append(str3);
            String sb6 = sb5.toString();
            Locale locale = Locale.getDefault();
            kotlin.g.b.k.a((Object) locale, "Locale.getDefault()");
            if (sb6 != null) {
                String lowerCase = sb6.toLowerCase(locale);
                kotlin.g.b.k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String c2 = c(new l("[^\\x00-\\x7F]|[\\p{Cntrl}&&[^\n\t]]|\\p{C}|\\s+").replace((CharSequence) lowerCase, ""));
                Map map = hashMap;
                if (c2 == null) {
                    c2 = "";
                }
                map.put("x-client-signature", c2);
                return;
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static void a(HashMap<String, String> hashMap) throws NullPointerException {
        kotlin.g.b.k.c(hashMap, "headers");
        if (a()) {
            Map map = hashMap;
            PublicKey b2 = b();
            String encodeToString = Base64.encodeToString(b2 != null ? b2.getEncoded() : null, 2);
            kotlin.g.b.k.a((Object) encodeToString, "Base64.encodeToString(ge….encoded, Base64.NO_WRAP)");
            map.put("x-public-key", encodeToString);
        }
    }

    private static PrivateKey c() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            kotlin.g.b.k.a((Object) instance, "KeyStore.getInstance(AND… load(null)\n            }");
            Key key = instance.getKey(d(), (char[]) null);
            if (!(key instanceof PrivateKey)) {
                key = null;
            }
            return (PrivateKey) key;
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
            return null;
        } catch (UnrecoverableKeyException e3) {
            q.b(e3.getMessage());
            return null;
        } catch (RuntimeException e4) {
            q.b(e4.getMessage());
            return null;
        }
    }

    public static PublicKey b() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            kotlin.g.b.k.a((Object) instance, "KeyStore.getInstance(AND… load(null)\n            }");
            Certificate certificate = instance.getCertificate(d());
            if (certificate != null) {
                return certificate.getPublicKey();
            }
            return null;
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String d() {
        String str = f56792b;
        net.one97.paytm.oauth.b b2 = OauthModule.b();
        kotlin.g.b.k.a((Object) b2, "OauthModule.getOathDataProvider()");
        if (com.paytm.utility.b.r(b2.getApplicationContext())) {
            net.one97.paytm.oauth.b b3 = OauthModule.b();
            kotlin.g.b.k.a((Object) b3, "OauthModule.getOathDataProvider()");
            str = com.paytm.utility.b.ab(b3.getApplicationContext());
        }
        StringBuilder sb = new StringBuilder("secure.");
        net.one97.paytm.oauth.b b4 = OauthModule.b();
        kotlin.g.b.k.a((Object) b4, "OauthModule.getOathDataProvider()");
        Context applicationContext = b4.getApplicationContext();
        kotlin.g.b.k.a((Object) applicationContext, "OauthModule.getOathDataP…ider().applicationContext");
        sb.append(applicationContext.getPackageName());
        sb.append('.');
        sb.append(str);
        return sb.toString();
    }

    public static void b(String str) {
        f56792b = str;
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        kotlin.g.b.k.a((Object) instance, "KeyStore.getInstance(AND…     load(null)\n        }");
        try {
            instance.deleteEntry(d());
        } catch (KeyStoreException e2) {
            e2.printStackTrace();
        }
    }
}
