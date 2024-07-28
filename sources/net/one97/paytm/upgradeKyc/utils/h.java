package net.one97.paytm.upgradeKyc.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.u;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f66333a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final String f66334b = f66334b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f66335c = ".";

    private h() {
    }

    public static byte[] a(String str, String str2) throws SignatureException, UnsupportedEncodingException, NoSuchProviderException {
        try {
            Charset charset = d.f47971a;
            if (str2 != null) {
                byte[] bytes = str2.getBytes(charset);
                k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                Mac instance = Mac.getInstance(f66334b);
                k.a((Object) instance, "Mac.getInstance(\"HmacSHA256\")");
                instance.init(new SecretKeySpec(bytes, f66334b));
                Charset forName = Charset.forName("US-ASCII");
                k.a((Object) forName, "Charset.forName(\"US-ASCII\")");
                if (str != null) {
                    byte[] bytes2 = str.getBytes(forName);
                    k.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
                    return instance.doFinal(bytes2);
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
            throw new u("null cannot be cast to non-null type java.lang.String");
        } catch (NoSuchAlgorithmException unused) {
            throw new SignatureException("error building signature, no such algorithm in device HmacSHA256");
        } catch (InvalidKeyException unused2) {
            throw new SignatureException("error building signature, invalid key HmacSHA256");
        }
    }
}
