package net.one97.paytm.verifier.a;

import android.content.Context;
import android.util.Base64;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class a {
    public static String a(String str, String str2, String str3) {
        try {
            String str4 = str + str2;
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return new String(Base64.encode(instance.doFinal(str4.getBytes()), 0));
        } catch (GeneralSecurityException e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, String str) {
        String str2;
        String str3 = "";
        try {
            if (c.a()) {
                str2 = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDPQM2KUHpns+q3MOrJK2p8943UWG7mjUV8iuFf1teN5V4v/QeOhnuZl+2pr0DR8tAEoSQ07N6DYBeysgocJWOaQxEAvkoyYwerf95D09wuwhKK2GssCq1OHxjdyQDyXiAdEVqEYocvee0ar3d2icJO1hINqI8VSC6J1LLD1o52wPKLxSUHgKa5kdMrAlQM2g3OZ9AmnUNyCfqeU/GgUuaHle78OSFji99eylHxbgnq87T/iB2v2yuFunlNaFX/+bAU0h45ovp9VlP+hX/PPP8ZWgVtlYzSwob+Cnba3dbEM+pxKIfVzl9NFVy51xXlKc9faPkkZmV1gR+HGPbyr435AgMBAAECggEADd7GYrVUG9CcqrnpXKE9NTPUGBv7AA8AUX9x6doU/vgUv51tfgpeBz91tl92NRbM+SJXq/sWQTCTJXBo4M1XxyEp6CTUDl82SjH6jAuHttFiMEyfj4j/ZDUMkvs6xv2ppIheyHFXnsPILHsFwbcie+gzuRpIySHVi3/intyjGCtekQxAv6b9iNtX60Mif120ifQAVJa9lCSeclVk0iirkWE/ix3JBmaKgPpqQER2jBCAQtHb1rV4L1hVZMIz1BVWKQUiWq6AtC4i1DM0WfSGp26YSVEh96e1ZgGYHjt+rBd0nX3x0LP0S7dPSzvrmnQh1k9RFAJqXQ28oS98SBMnIQKBgQD/dUwvO1HkP4trfR2K7cPWoII9ClOCXLCwD//gG/Gdw4BtnxpT2pIL/JwBTkQzY3vopKsp2s9ruCeRxSkHSQqsod9dcTaGTlxL38PsYBy3f/oStY7+P/UAbLG+PK2N0b/0kN3kwQBjhnFe+M5TDmpx7dsWu/nUh24sjLzQvMSnFQKBgQDPsVUEgwFHzAncnMnzWa0K9OYGaQmKSHeboZlXd6+DP08Ad4qoZwgDvWoC9/z21YCmsGxDwznOspPpc/V/JJi7ZxUcFJoEMdiWKscloqv52yP2daMj8scpFGHRueCea9mYbsraQlhBmk3mBmu0G8Ddl8anQzcUZ5bg1If0vZjEVQKBgQC0mTxu98UBVFtAdod4PHeDOJ5agP5g3x6amfUPfzHlkt0sopp+RbuSddfkpGxa2C41XpUTVfnl8Z8n0vcai2zcduPur6cYdDWT/nIInjovEG6+41RgMt8GmdFe6I7aADtwrynwGvInalikB8n1te9S9BE7lVEeC1C8dhLWj12HsQKBgQCxYV6e79QUIar6g93mvFwR037xUpwXQjUE8ksobMu1aEhsuavuj7BEoWz9BBdEKKwrsNmGNiIU6mdxJtwwrmzTAQMCbIXttzSna/mRpxEB36sjPu0KMrrt1r6EhB/WrX21tkoBhlAiF0sYfbtWo61gk9PR3pIYFzDA7EMBPzxN0QKBgQDvvs6pJJFTC7M5zOLUndUkggQdbNgzbEJ6AzbN9x+bg+GHfmhpoG7llM9Dc2t9fa0ievdGqzlkRTa08DgZxoyUw133r9BkkNdrAC6Obx/5qIIG08rTWj7T5Yb3hegH6tg2uH6ucVskHZbp1vDf5h1LtEEx9kmDQ/LQiWJREnmZEw==";
            } else {
                str2 = a(context);
            }
            byte[] bytes = str.getBytes(AppConstants.UTF_8);
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2, 0)));
            Signature instance = Signature.getInstance("SHA256withRSA");
            instance.initSign(generatePrivate);
            instance.update(bytes);
            String str4 = new String(Base64.encode(instance.sign(), 0));
            try {
                return str4.replace(StringUtility.NEW_LINE, str3);
            } catch (Exception e2) {
                e = e2;
                str3 = str4;
                q.b(e.getMessage());
                return str3;
            }
        } catch (Exception e3) {
            e = e3;
            q.b(e.getMessage());
            return str3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070 A[SYNTHETIC, Splitter:B:35:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007e A[SYNTHETIC, Splitter:B:40:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e A[SYNTHETIC, Splitter:B:47:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A[SYNTHETIC, Splitter:B:52:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac A[SYNTHETIC, Splitter:B:59:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ba A[SYNTHETIC, Splitter:B:64:0x00ba] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x0085=Splitter:B:44:0x0085, B:32:0x0067=Splitter:B:32:0x0067} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r6) throws java.io.IOException, java.security.GeneralSecurityException {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0082, Exception -> 0x0064, all -> 0x0060 }
            r2.<init>()     // Catch:{ IOException -> 0x0082, Exception -> 0x0064, all -> 0x0060 }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ IOException -> 0x0082, Exception -> 0x0064, all -> 0x0060 }
            java.lang.String r3 = "test_ap.cer"
            java.io.InputStream r6 = r6.open(r3)     // Catch:{ IOException -> 0x0082, Exception -> 0x0064, all -> 0x0060 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x005d, Exception -> 0x005a, all -> 0x0057 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x005d, Exception -> 0x005a, all -> 0x0057 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r6, r5)     // Catch:{ IOException -> 0x005d, Exception -> 0x005a, all -> 0x0057 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x005d, Exception -> 0x005a, all -> 0x0057 }
        L_0x001e:
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x0055, Exception -> 0x0053 }
            if (r4 == 0) goto L_0x0028
            r2.append(r4)     // Catch:{ IOException -> 0x0055, Exception -> 0x0053 }
            goto L_0x001e
        L_0x0028:
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0055, Exception -> 0x0053 }
            java.lang.String r4 = "-----BEGIN PRIVATE KEY-----"
            java.lang.String r2 = r2.replace(r4, r0)     // Catch:{ IOException -> 0x0055, Exception -> 0x0053 }
            java.lang.String r4 = "-----END PRIVATE KEY-----"
            java.lang.String r0 = r2.replace(r4, r0)     // Catch:{ IOException -> 0x0055, Exception -> 0x0053 }
            if (r6 == 0) goto L_0x0046
            r6.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x0046:
            r3.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x0052
        L_0x004a:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x0052:
            return r0
        L_0x0053:
            r0 = move-exception
            goto L_0x0067
        L_0x0055:
            r0 = move-exception
            goto L_0x0085
        L_0x0057:
            r0 = move-exception
            r3 = r1
            goto L_0x00aa
        L_0x005a:
            r0 = move-exception
            r3 = r1
            goto L_0x0067
        L_0x005d:
            r0 = move-exception
            r3 = r1
            goto L_0x0085
        L_0x0060:
            r0 = move-exception
            r6 = r1
            r3 = r6
            goto L_0x00aa
        L_0x0064:
            r0 = move-exception
            r6 = r1
            r3 = r6
        L_0x0067:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a9 }
            com.paytm.utility.q.b(r0)     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x007c
            r6.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x007c
        L_0x0074:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x007c:
            if (r3 == 0) goto L_0x00a8
            r3.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a8
        L_0x0082:
            r0 = move-exception
            r6 = r1
            r3 = r6
        L_0x0085:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a9 }
            com.paytm.utility.q.b(r0)     // Catch:{ all -> 0x00a9 }
            if (r6 == 0) goto L_0x009a
            r6.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x009a
        L_0x0092:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x009a:
            if (r3 == 0) goto L_0x00a8
            r3.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a8
        L_0x00a0:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x00a8:
            return r1
        L_0x00a9:
            r0 = move-exception
        L_0x00aa:
            if (r6 == 0) goto L_0x00b8
            r6.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b8
        L_0x00b0:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x00b8:
            if (r3 == 0) goto L_0x00c6
            r3.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c6
        L_0x00be:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            com.paytm.utility.q.b(r6)
        L_0x00c6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.verifier.a.a.a(android.content.Context):java.lang.String");
    }
}
