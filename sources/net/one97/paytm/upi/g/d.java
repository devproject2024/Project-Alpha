package net.one97.paytm.upi.g;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.google.gson.f;
import java.io.File;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static RequestQueue f66965a;

    /* renamed from: b  reason: collision with root package name */
    private static String f66966b = d.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static Context f66967c;

    /* renamed from: d  reason: collision with root package name */
    private static f f66968d;

    private d() {
    }

    public static void a(Context context) {
        f66968d = new f();
        f66967c = context;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void a(com.android.volley.Request<T> r6) {
        /*
            java.lang.String r0 = "\""
            java.lang.String r1 = f66966b
            r6.setTag(r1)
            r1 = 1
            r6.setShouldCache(r1)
            android.content.Context r2 = f66967c
            com.android.volley.RequestQueue r2 = b(r2)
            r2.add(r6)
            net.one97.paytm.upi.i r2 = net.one97.paytm.upi.i.a()     // Catch:{  }
            java.lang.String r2 = r2.f66988i     // Catch:{  }
            java.lang.String r3 = "staging"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{  }
            if (r2 != 0) goto L_0x0030
            net.one97.paytm.upi.i r2 = net.one97.paytm.upi.i.a()     // Catch:{  }
            java.lang.String r2 = r2.f66988i     // Catch:{  }
            java.lang.String r3 = "debug"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{  }
            if (r2 == 0) goto L_0x00d2
        L_0x0030:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{  }
            r2.<init>()     // Catch:{  }
            java.lang.String r3 = "curl request: curl "
            r2.append(r3)     // Catch:{  }
            java.lang.String r3 = "-X \""
            r2.append(r3)     // Catch:{  }
            int r3 = r6.getMethod()     // Catch:{  }
            if (r3 == 0) goto L_0x0060
            if (r3 == r1) goto L_0x005a
            r1 = 2
            if (r3 == r1) goto L_0x0054
            r1 = 3
            if (r3 == r1) goto L_0x004e
            goto L_0x0065
        L_0x004e:
            java.lang.String r1 = "DELETE"
            r2.append(r1)     // Catch:{  }
            goto L_0x0065
        L_0x0054:
            java.lang.String r1 = "PUT"
            r2.append(r1)     // Catch:{  }
            goto L_0x0065
        L_0x005a:
            java.lang.String r1 = "POST"
            r2.append(r1)     // Catch:{  }
            goto L_0x0065
        L_0x0060:
            java.lang.String r1 = "GET"
            r2.append(r1)     // Catch:{  }
        L_0x0065:
            r2.append(r0)     // Catch:{  }
            byte[] r1 = r6.getBody()     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r3 = "'"
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = " --data-raw "
            r2.append(r1)     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r1 = new java.lang.String     // Catch:{ IllegalStateException -> 0x00d2 }
            byte[] r4 = r6.getBody()     // Catch:{ IllegalStateException -> 0x00d2 }
            r1.<init>(r4)     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r4 = "\\\""
            java.lang.String r1 = r1.replaceAll(r0, r4)     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r1)     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x00d2 }
        L_0x008d:
            java.util.Map r1 = r6.getHeaders()     // Catch:{ IllegalStateException -> 0x00d2 }
            java.util.Set r1 = r1.keySet()     // Catch:{ IllegalStateException -> 0x00d2 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IllegalStateException -> 0x00d2 }
        L_0x0099:
            boolean r4 = r1.hasNext()     // Catch:{ IllegalStateException -> 0x00d2 }
            if (r4 == 0) goto L_0x00c3
            java.lang.Object r4 = r1.next()     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r5 = " -H '"
            r2.append(r5)     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r4)     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r5 = ": "
            r2.append(r5)     // Catch:{ IllegalStateException -> 0x00d2 }
            java.util.Map r5 = r6.getHeaders()     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.Object r4 = r5.get(r4)     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r4)     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r3)     // Catch:{ IllegalStateException -> 0x00d2 }
            goto L_0x0099
        L_0x00c3:
            java.lang.String r1 = " \""
            r2.append(r1)     // Catch:{ IllegalStateException -> 0x00d2 }
            java.lang.String r6 = r6.getUrl()     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r6)     // Catch:{ IllegalStateException -> 0x00d2 }
            r2.append(r0)     // Catch:{ IllegalStateException -> 0x00d2 }
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.g.d.a(com.android.volley.Request):void");
    }

    public static RequestQueue b(Context context) {
        if (f66965a == null) {
            File file = new File(context.getCacheDir().getPath() + File.separator + "paytm-volley-cache");
            RequestQueue requestQueue = new RequestQueue(new DiskBasedCache(file, (int) e.a(file)), new BasicNetwork((BaseHttpStack) a()));
            f66965a = requestQueue;
            requestQueue.start();
        }
        return f66965a;
    }

    private static HurlStack a() {
        HurlStack hurlStack = null;
        try {
            hurlStack = new HurlStack((HurlStack.UrlRewriter) null, new h());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hurlStack == null ? new HurlStack() : hurlStack;
    }
}
