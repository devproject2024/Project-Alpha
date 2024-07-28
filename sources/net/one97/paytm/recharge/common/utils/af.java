package net.one97.paytm.recharge.common.utils;

import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.g.b.k;
import kotlin.m.d;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static final af f61498a = new af();

    /* renamed from: b  reason: collision with root package name */
    private static SecretKeySpec f61499b;

    static {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            k.a((Object) instance, "MessageDigest.getInstance(\"SHA-1\")");
            byte[] bytes = "paytmrechargegrouping".getBytes(d.f47971a);
            k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] digest = instance.digest(bytes);
            k.a((Object) digest, "sha.digest(bytes)");
            byte[] copyOf = Arrays.copyOf(digest, 16);
            k.a((Object) copyOf, "Arrays.copyOf(bytes, 16)");
            f61499b = new SecretKeySpec(copyOf, "AES");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
        }
    }

    private af() {
    }

    public static String a(String str) {
        k.c(str, "textToEncrypt");
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, f61499b);
            if (Build.VERSION.SDK_INT >= 26) {
                byte[] bytes = str.getBytes(d.f47971a);
                k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                String encodeToString = Base64.encodeToString(instance.doFinal(bytes), 2);
                k.a((Object) encodeToString, "Base64.encodeToString(ci…s.UTF_8)),Base64.NO_WRAP)");
                return encodeToString;
            }
            byte[] bytes2 = str.getBytes(d.f47971a);
            k.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
            byte[] encode = Base64.encode(instance.doFinal(bytes2), 2);
            k.a((Object) encode, "byteArray");
            return new String(encode, 0, encode.length, d.f47971a);
        } catch (Exception unused) {
            return "";
        }
    }
}
