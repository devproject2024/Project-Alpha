package io.branch.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import io.branch.referral.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static i f46494a = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f46495d = 750;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Object f46496b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f46497c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46498e = true;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f46499f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f46500g;

    /* renamed from: h  reason: collision with root package name */
    private Class<?> f46501h;

    /* renamed from: i  reason: collision with root package name */
    private Class<?> f46502i;
    /* access modifiers changed from: private */
    public Class<?> j;

    interface b {
        void a();
    }

    private i() {
        try {
            this.f46500g = Class.forName("androidx.browser.customtabs.c");
            this.f46501h = Class.forName("androidx.browser.customtabs.b");
            this.f46502i = Class.forName("androidx.browser.customtabs.f");
            this.j = Class.forName("android.support.a.b");
        } catch (Throwable unused) {
            this.f46498e = false;
        }
        this.f46497c = new Handler();
    }

    public static i a() {
        if (f46494a == null) {
            f46494a = new i();
        }
        return f46494a;
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, String str, n nVar, q qVar, final b bVar) {
        this.f46499f = false;
        if (System.currentTimeMillis() - q.c("bnc_branch_strong_match_time") < 2592000000L) {
            a(bVar, this.f46499f);
        } else if (!this.f46498e) {
            a(bVar, this.f46499f);
        } else {
            try {
                if (nVar.b() != null) {
                    final Uri a2 = a(str, nVar, context);
                    if (a2 != null) {
                        this.f46497c.postDelayed(new Runnable() {
                            public final void run() {
                                i iVar = i.this;
                                iVar.a(bVar, iVar.f46499f);
                            }
                        }, 500);
                        final Method method = this.f46500g.getMethod("warmup", new Class[]{Long.TYPE});
                        final Method method2 = this.f46500g.getMethod("newSession", new Class[]{this.f46501h});
                        final Method method3 = this.f46502i.getMethod("mayLaunchUrl", new Class[]{Uri.class, Bundle.class, List.class});
                        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                        intent.setPackage("com.android.chrome");
                        final q qVar2 = qVar;
                        final b bVar2 = bVar;
                        context.bindService(intent, new a() {
                            public final void a(Object obj) {
                                i iVar = i.this;
                                Object unused = iVar.f46496b = iVar.f46500g.cast(obj);
                                if (i.this.f46496b != null) {
                                    try {
                                        method.invoke(i.this.f46496b, new Object[]{0});
                                        Object invoke = method2.invoke(i.this.f46496b, new Object[]{null});
                                        if (invoke != null) {
                                            q.h("Strong match request " + a2);
                                            method3.invoke(invoke, new Object[]{a2, null, null});
                                            q.a("bnc_branch_strong_match_time", System.currentTimeMillis());
                                            boolean unused2 = i.this.f46499f = true;
                                        }
                                    } catch (Throwable unused3) {
                                        Object unused4 = i.this.f46496b = null;
                                        i iVar2 = i.this;
                                        iVar2.a(bVar2, iVar2.f46499f);
                                    }
                                }
                            }

                            public final void onServiceDisconnected(ComponentName componentName) {
                                Object unused = i.this.f46496b = null;
                                i iVar = i.this;
                                iVar.a(bVar2, iVar.f46499f);
                            }
                        }, 33);
                        return;
                    }
                    a(bVar, this.f46499f);
                    return;
                }
                a(bVar, this.f46499f);
                q.h("Cannot use cookie-based matching since device id is not available");
            } catch (Throwable unused) {
                a(bVar, this.f46499f);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        if (z) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    bVar.a();
                }
            }, (long) f46495d);
        } else {
            bVar.a();
        }
    }

    private static Uri a(String str, n nVar, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = ("https://" + str + "/_strong_match?os=" + ah.e(nVar.f46549b)) + AppConstants.AND_SIGN + m.a.HardwareID.getKey() + "=" + nVar.b();
        String str3 = str2 + AppConstants.AND_SIGN + m.a.HardwareIDType.getKey() + "=" + (nVar.b().f46438b ? m.a.HardwareIDTypeVendor : m.a.HardwareIDTypeRandom).getKey();
        String str4 = nVar.f46548a.f46434b;
        if (str4 != null && !j.a(context)) {
            str3 = str3 + AppConstants.AND_SIGN + m.a.GoogleAdvertisingID.getKey() + "=" + str4;
        }
        if (!q.d("bnc_device_fingerprint_id").equals("bnc_no_value")) {
            str3 = str3 + AppConstants.AND_SIGN + m.a.DeviceFingerprintID.getKey() + "=" + q.d("bnc_device_fingerprint_id");
        }
        if (!ah.a(nVar.f46549b).equals("bnc_no_value")) {
            str3 = str3 + AppConstants.AND_SIGN + m.a.AppVersion.getKey() + "=" + ah.a(nVar.f46549b);
        }
        if (q.k(q.e())) {
            str3 = str3 + AppConstants.AND_SIGN + m.a.BranchKey.getKey() + "=" + q.e();
        }
        return Uri.parse(str3 + "&sdk=android4.3.2");
    }

    abstract class a implements ServiceConnection {
        public abstract void a(Object obj);

        a() {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Constructor declaredConstructor = i.this.f46500g.getDeclaredConstructor(new Class[]{i.this.j, ComponentName.class});
                declaredConstructor.setAccessible(true);
                a(declaredConstructor.newInstance(new Object[]{Class.forName("android.support.a.b$a").getMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder}), componentName}));
            } catch (Throwable unused) {
                a((Object) null);
            }
        }
    }
}
