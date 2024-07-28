package com.google.firebase.installations.a;

import android.content.SharedPreferences;
import android.util.Base64;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sendbird.android.constant.StringSet;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f38933a = {"*", "FCM", "GCM", ""};

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f38934b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38935c;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (r4.isEmpty() != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(com.google.firebase.c r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.a()
            java.lang.String r1 = "com.google.android.gms.appid"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            r3.f38934b = r0
            com.google.firebase.g r0 = r4.c()
            java.lang.String r0 = r0.f38756c
            r1 = 0
            if (r0 == 0) goto L_0x001a
            goto L_0x0049
        L_0x001a:
            com.google.firebase.g r4 = r4.c()
            java.lang.String r4 = r4.f38755b
            java.lang.String r0 = "1:"
            boolean r0 = r4.startsWith(r0)
            if (r0 != 0) goto L_0x0033
            java.lang.String r0 = "2:"
            boolean r0 = r4.startsWith(r0)
            if (r0 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r0 = r4
            goto L_0x0049
        L_0x0033:
            java.lang.String r0 = ":"
            java.lang.String[] r4 = r4.split(r0)
            int r0 = r4.length
            r2 = 4
            if (r0 == r2) goto L_0x003f
        L_0x003d:
            r0 = r1
            goto L_0x0049
        L_0x003f:
            r0 = 1
            r4 = r4[r0]
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0031
            goto L_0x003d
        L_0x0049:
            r3.f38935c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.a.b.<init>(com.google.firebase.c):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r9 = this;
            android.content.SharedPreferences r0 = r9.f38934b
            monitor-enter(r0)
            java.lang.String[] r1 = f38933a     // Catch:{ all -> 0x0048 }
            int r2 = r1.length     // Catch:{ all -> 0x0048 }
            r3 = 0
        L_0x0007:
            r4 = 0
            if (r3 >= r2) goto L_0x0046
            r5 = r1[r3]     // Catch:{ all -> 0x0048 }
            java.lang.String r6 = r9.f38935c     // Catch:{ all -> 0x0048 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0048 }
            java.lang.String r8 = "|T|"
            r7.<init>(r8)     // Catch:{ all -> 0x0048 }
            r7.append(r6)     // Catch:{ all -> 0x0048 }
            java.lang.String r6 = "|"
            r7.append(r6)     // Catch:{ all -> 0x0048 }
            r7.append(r5)     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0048 }
            android.content.SharedPreferences r6 = r9.f38934b     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = r6.getString(r5, r4)     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0043
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x0048 }
            if (r5 != 0) goto L_0x0043
            java.lang.String r1 = "{"
            boolean r1 = r4.startsWith(r1)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0041
            java.lang.String r4 = a((java.lang.String) r4)     // Catch:{ all -> 0x0048 }
        L_0x0041:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return r4
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return r4
        L_0x0048:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.a.b.a():java.lang.String");
    }

    private static String a(String str) {
        try {
            return new JSONObject(str).getString(StringSet.token);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String b() {
        synchronized (this.f38934b) {
            String c2 = c();
            if (c2 != null) {
                return c2;
            }
            String d2 = d();
            return d2;
        }
    }

    private String c() {
        String string;
        synchronized (this.f38934b) {
            string = this.f38934b.getString("|S|id", (String) null);
        }
        return string;
    }

    private String d() {
        synchronized (this.f38934b) {
            String string = this.f38934b.getString("|S||P|", (String) null);
            if (string == null) {
                return null;
            }
            PublicKey b2 = b(string);
            if (b2 == null) {
                return null;
            }
            String a2 = a(b2);
            return a2;
        }
    }

    private static String a(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & PriceRangeSeekBar.INVALID_POINTER_ID);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static PublicKey b(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            new StringBuilder("Invalid key stored ").append(e2);
            return null;
        }
    }
}
