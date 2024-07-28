package net.one97.paytm.payments.visascp.network;

import android.content.Context;
import com.android.volley.Response;
import java.util.concurrent.ExecutorService;
import net.one97.paytm.payments.visascp.customAsync.CustomThreadPoolExecutorManager;
import net.one97.paytm.payments.visascp.network.model.BaseModel;

public class GetAuthCode {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f582 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f583 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ String m687(String str) {
        int i2 = f583;
        int i3 = (i2 & 14) + (i2 | 14);
        int i4 = (i3 & -1) + (i3 | -1);
        f582 = i4 % 128;
        int i5 = i4 % 2;
        String r2 = m686(str);
        int i6 = f583;
        int i7 = (i6 & 40) + (i6 | 40);
        int i8 = (i7 & -1) + (i7 | -1);
        f582 = i8 % 128;
        int i9 = i8 % 2;
        return r2;
    }

    public static void callAuthCodeAPI(Context context, String str, String str2, Response.Listener<BaseModel> listener, Response.ErrorListener errorListener, String str3) {
        CustomThreadPoolExecutorManager customThreadPoolExecutorManager = CustomThreadPoolExecutorManager.getsInstance();
        ExecutorService executorService = CustomThreadPoolExecutorManager.getsInstance().getExecutorService();
        try {
            Object[] objArr = new Object[7];
            objArr[6] = listener;
            objArr[5] = errorListener;
            objArr[4] = customThreadPoolExecutorManager;
            objArr[3] = str3;
            objArr[2] = str;
            objArr[1] = str2;
            objArr[0] = context;
            executorService.submit((Runnable) ((Class) If.m692(49596, 54, 0)).getDeclaredConstructor(new Class[]{Context.class, String.class, String.class, String.class, CustomThreadPoolExecutorManager.class, Response.ErrorListener.class, Response.Listener.class}).newInstance(objArr));
            int i2 = f583;
            int i3 = (i2 | 115) << 1;
            int i4 = -(((~i2) & 115) | (i2 & -116));
            int i5 = (i3 & i4) + (i4 | i3);
            f582 = i5 % 128;
            int i6 = i5 % 2;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
        if (r3 != true) goto L_0x003e;
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m686(java.lang.String r6) {
        /*
            int r0 = f582
            r1 = r0 & 80
            r0 = r0 | 80
            int r1 = r1 + r0
            r0 = 1
            int r1 = r1 - r0
            int r2 = r1 % 128
            f583 = r2
            r2 = 2
            int r1 = r1 % r2
            r3 = 0
            if (r1 == 0) goto L_0x0014
            r1 = 0
            goto L_0x0015
        L_0x0014:
            r1 = 1
        L_0x0015:
            r4 = 0
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ANDROID_KEY_STORE     // Catch:{ Exception -> 0x0078 }
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ Exception -> 0x0078 }
            r1.load(r4)     // Catch:{ Exception -> 0x0078 }
            java.security.cert.Certificate r5 = r1.getCertificate(r6)     // Catch:{ Exception -> 0x0078 }
            if (r5 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r3 = 1
        L_0x0029:
            if (r3 == r0) goto L_0x003e
            goto L_0x0059
        L_0x002c:
            java.lang.String r1 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.ANDROID_KEY_STORE     // Catch:{ Exception -> 0x0078 }
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ Exception -> 0x0078 }
            r1.load(r4)     // Catch:{ Exception -> 0x0078 }
            java.security.cert.Certificate r5 = r1.getCertificate(r6)     // Catch:{ Exception -> 0x0078 }
            if (r5 == 0) goto L_0x003c
            r3 = 1
        L_0x003c:
            if (r3 == r0) goto L_0x0059
        L_0x003e:
            int r6 = f582
            int r6 = r6 + 8
            int r6 = r6 - r0
            int r1 = r6 % 128
            f583 = r1
            int r6 = r6 % r2
            int r6 = f582
            r1 = r6 ^ 9
            r6 = r6 & 9
            int r6 = r6 << r0
            r0 = r1 & r6
            r6 = r6 | r1
            int r0 = r0 + r6
            int r6 = r0 % 128
            f583 = r6
            int r0 = r0 % r2
            return r4
        L_0x0059:
            java.security.cert.Certificate r6 = r1.getCertificate(r6)     // Catch:{ Exception -> 0x0078 }
            java.security.PublicKey r6 = r6.getPublicKey()     // Catch:{ Exception -> 0x0078 }
            byte[] r6 = r6.getEncoded()     // Catch:{ Exception -> 0x0078 }
            java.lang.String r6 = android.util.Base64.encodeToString(r6, r2)     // Catch:{ Exception -> 0x0078 }
            int r1 = f583
            r3 = r1 | 24
            int r3 = r3 << r0
            r1 = r1 ^ 24
            int r3 = r3 - r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f582 = r0
            int r3 = r3 % r2
            return r6
        L_0x0078:
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.LOG_TAG
            java.lang.String r6 = net.one97.paytm.payments.visascp.util.VisaSCPConstants.EXCEPTION_MESSAGE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.payments.visascp.network.GetAuthCode.m686(java.lang.String):java.lang.String");
    }
}
