package io.branch.referral;

import android.content.Context;
import android.os.Process;
import io.branch.referral.ah;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class o extends e<Void, Void, Void> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f46551a;

    /* renamed from: b  reason: collision with root package name */
    private final ah.a f46552b;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Void) obj);
        ah.a aVar = this.f46552b;
        if (aVar != null) {
            aVar.e();
        }
    }

    o(Context context, ah.a aVar) {
        this.f46551a = new WeakReference<>(context);
        this.f46552b = aVar;
    }

    private Void a() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            public final void run() {
                Context context = (Context) o.this.f46551a.get();
                if (context != null) {
                    Process.setThreadPriority(-19);
                    Object a2 = o.b(context);
                    n a3 = n.a();
                    if (a3 == null) {
                        a3 = n.a(context);
                    }
                    ah ahVar = a3.f46548a;
                    if (ahVar != null) {
                        o.a(ahVar, a2);
                        if (ahVar.f46435c == 1) {
                            ahVar.f46434b = null;
                        } else {
                            o.b(ahVar, a2);
                        }
                    }
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await(1500, TimeUnit.MILLISECONDS);
            return null;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Object b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
        } catch (Throwable unused) {
            q.h("Either class com.google.android.gms.ads.identifier.AdvertisingIdClient or its method, getAdvertisingIdInfo, was not found");
            return null;
        }
    }

    static /* synthetic */ void a(ah ahVar, Object obj) {
        try {
            int i2 = 0;
            Object invoke = obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(obj, new Object[0]);
            if (invoke instanceof Boolean) {
                if (((Boolean) invoke).booleanValue()) {
                    i2 = 1;
                }
                ahVar.f46435c = i2;
            }
        } catch (Exception unused) {
            q.h("isLimitAdTrackingEnabled method not found");
        }
    }

    static /* synthetic */ void b(ah ahVar, Object obj) {
        try {
            ahVar.f46434b = (String) obj.getClass().getMethod("getId", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
        }
    }
}
