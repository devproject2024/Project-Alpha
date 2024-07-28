package com.alibaba.wireless.security.a.a;

import android.content.Context;
import android.os.Process;
import com.appsflyer.share.Constants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f14583a;

    /* renamed from: b  reason: collision with root package name */
    private static String f14584b;

    /* renamed from: c  reason: collision with root package name */
    private static int f14585c;

    /* renamed from: d  reason: collision with root package name */
    private static int f14586d;

    /* renamed from: e  reason: collision with root package name */
    private static int f14587e;

    /* renamed from: f  reason: collision with root package name */
    private static int f14588f;

    /* renamed from: g  reason: collision with root package name */
    private static Class f14589g;

    /* renamed from: h  reason: collision with root package name */
    private static Class f14590h;

    /* renamed from: i  reason: collision with root package name */
    private static Class f14591i;
    private static Constructor j;
    private static Method k;
    private static Method l;
    private static Method m;
    private static Method n;
    private static final char[] o = "0123456789abcdef".toCharArray();

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a() {
        /*
            int r0 = f14588f
            if (r0 != 0) goto L_0x0089
            java.lang.Class<com.alibaba.wireless.security.a.a.a> r0 = com.alibaba.wireless.security.a.a.a.class
            monitor-enter(r0)
            int r1 = f14588f     // Catch:{ all -> 0x0086 }
            if (r1 != 0) goto L_0x0084
            r1 = 1
            java.lang.String r2 = "com.ut.mini.internal.UTOriginalCustomHitBuilder"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082 }
            f14589g = r2     // Catch:{ ClassNotFoundException -> 0x0082 }
            java.lang.String r2 = "com.ut.mini.UTAnalytics"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082 }
            f14590h = r2     // Catch:{ ClassNotFoundException -> 0x0082 }
            java.lang.String r2 = "com.ut.mini.UTTracker"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082 }
            f14591i = r2     // Catch:{ ClassNotFoundException -> 0x0082 }
            java.lang.Class r2 = f14589g     // Catch:{  }
            r3 = 6
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r5 = 0
            r3[r5] = r4     // Catch:{  }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{  }
            r3[r1] = r4     // Catch:{  }
            r4 = 2
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r3[r4] = r6     // Catch:{  }
            r4 = 3
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r3[r4] = r6     // Catch:{  }
            r4 = 4
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r3[r4] = r6     // Catch:{  }
            r4 = 5
            java.lang.Class<java.util.Map> r6 = java.util.Map.class
            r3[r4] = r6     // Catch:{  }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r3)     // Catch:{  }
            j = r2     // Catch:{  }
            java.lang.Class r2 = f14589g     // Catch:{  }
            java.lang.String r3 = "build"
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
            k = r2     // Catch:{  }
            java.lang.Class r2 = f14590h     // Catch:{  }
            java.lang.String r3 = "getInstance"
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
            l = r2     // Catch:{  }
            java.lang.Class r2 = f14590h     // Catch:{  }
            java.lang.String r3 = "getDefaultTracker"
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
            m = r2     // Catch:{  }
            java.lang.Class r2 = f14591i     // Catch:{  }
            java.lang.String r3 = "send"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{  }
            java.lang.Class<java.util.Map> r6 = java.util.Map.class
            r4[r5] = r6     // Catch:{  }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
            n = r2     // Catch:{  }
            f14587e = r1     // Catch:{ all -> 0x0086 }
        L_0x0082:
            f14588f = r1     // Catch:{ all -> 0x0086 }
        L_0x0084:
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            goto L_0x0089
        L_0x0086:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            throw r1
        L_0x0089:
            int r0 = f14587e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.a.a.a.a():int");
    }

    public static int a(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (!(a() == 0 || str == null || str.length() == 0)) {
            if (str2 == null) {
                str2 = "";
            }
            try {
                String valueOf = String.valueOf(i2 % 100);
                HashMap hashMap = new HashMap();
                hashMap.put("plugin", "0");
                hashMap.put(Constants.URL_MEDIA_SOURCE, String.valueOf(Process.myPid()));
                hashMap.put("tid", String.valueOf(Thread.currentThread().getId()));
                hashMap.put("time", "0");
                if (f14586d == 0) {
                    f14585c = e.c(f14583a) ? 1 : 0;
                    f14586d = 1;
                }
                hashMap.put("ui", String.valueOf(f14585c));
                hashMap.put("sid", b());
                hashMap.put("uuid", c());
                hashMap.put("msg", a(str3));
                hashMap.put("rsv1", a(str4));
                hashMap.put("rsv2", a(str5));
                hashMap.put("rsv3", a(str6));
                hashMap.put("rsv4", a(str7));
                Object newInstance = j.newInstance(new Object[]{"Page_SecurityGuardSDK", 19999, str, str2, valueOf, hashMap});
                if (newInstance != null) {
                    Map map = (Map) k.invoke(newInstance, new Object[0]);
                    if (map != null) {
                        if (map.size() != 0) {
                            Object invoke = l.invoke(f14590h, new Object[0]);
                            if (invoke != null) {
                                Object invoke2 = m.invoke(invoke, new Object[0]);
                                if (invoke2 != null) {
                                    n.invoke(invoke2, new Object[]{map});
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private static String a(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return URLEncoder.encode(str, AppConstants.UTF_8);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = o;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static void a(Context context) {
        if (context != null) {
            f14583a = context;
        }
    }

    private static synchronized String b() {
        String substring;
        synchronized (a.class) {
            if (f14584b == null || f14584b.length() == 0) {
                f14584b = c();
            }
            substring = f14584b.substring(0, f14584b.length() / 8);
        }
        return substring;
    }

    private static String c() {
        try {
            String uuid = UUID.randomUUID().toString();
            String valueOf = String.valueOf(System.nanoTime());
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            return a(instance.digest((uuid + valueOf).getBytes(AppConstants.UTF_8)));
        } catch (Exception unused) {
            return "";
        }
    }
}
