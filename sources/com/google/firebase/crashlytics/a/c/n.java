package com.google.firebase.crashlytics.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.firebase.crashlytics.a.e.v;
import com.google.firebase.crashlytics.a.e.w;
import com.google.firebase.crashlytics.a.l.d;
import com.google.firebase.crashlytics.a.l.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final String f38295a = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{"17.1.0"});

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Integer> f38296e;

    /* renamed from: b  reason: collision with root package name */
    final Context f38297b;

    /* renamed from: c  reason: collision with root package name */
    final v f38298c;

    /* renamed from: d  reason: collision with root package name */
    final b f38299d;

    /* renamed from: f  reason: collision with root package name */
    private final d f38300f;

    static {
        HashMap hashMap = new HashMap();
        f38296e = hashMap;
        hashMap.put("armeabi", 5);
        f38296e.put("armeabi-v7a", 6);
        f38296e.put("arm64-v8a", 9);
        f38296e.put("x86", 0);
        f38296e.put("x86_64", 1);
    }

    public n(Context context, v vVar, b bVar, d dVar) {
        this.f38297b = context;
        this.f38298c = vVar;
        this.f38299d = bVar;
        this.f38300f = dVar;
    }

    public final v.d.C0634d a(Throwable th, Thread thread, String str, long j, boolean z) {
        Boolean bool;
        int i2 = this.f38297b.getResources().getConfiguration().orientation;
        e eVar = new e(th, this.f38300f);
        v.d.C0634d.b a2 = v.d.C0634d.g().a(str).a(j);
        ActivityManager.RunningAppProcessInfo a3 = g.a(this.f38299d.f38173d, this.f38297b);
        Double d2 = null;
        if (a3 != null) {
            bool = Boolean.valueOf(a3.importance != 100);
        } else {
            bool = null;
        }
        v.d.C0634d.a.C0635a a4 = v.d.C0634d.a.f().a(bool).a(i2);
        v.d.C0634d.a.b.C0638b e2 = v.d.C0634d.a.b.e();
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(thread, eVar.f38708c, 4));
        if (z) {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(a(thread2, this.f38300f.a((StackTraceElement[]) next.getValue()), 0));
                }
            }
        }
        v.d.C0634d.b a5 = a2.a(a4.a(e2.a((w<v.d.C0634d.a.b.e>) w.a(arrayList)).a(a(eVar, 4, 8, 0)).a(v.d.C0634d.a.b.C0640d.d().a("0").b("0").a(0).a()).b(w.a((E[]) new v.d.C0634d.a.b.C0636a[]{v.d.C0634d.a.b.C0636a.e().a(0).b(0).a(this.f38299d.f38173d).b(this.f38299d.f38171b).a()})).a()).a());
        e a6 = e.a(this.f38297b);
        Float f2 = a6.f38178a;
        if (f2 != null) {
            d2 = Double.valueOf(f2.doubleValue());
        }
        int a7 = a6.a();
        return a5.a(v.d.C0634d.c.g().a(d2).a(a7).a(g.d(this.f38297b)).b(i2).a(g.b() - g.c(this.f38297b)).b(g.b(Environment.getDataDirectory().getPath())).a()).a();
    }

    private static v.d.C0634d.a.b.e a(Thread thread, StackTraceElement[] stackTraceElementArr, int i2) {
        return v.d.C0634d.a.b.e.d().a(thread.getName()).a(i2).a(w.a(a(stackTraceElementArr, i2))).a();
    }

    private static w<v.d.C0634d.a.b.e.C0643b> a(StackTraceElement[] stackTraceElementArr, int i2) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement a2 : stackTraceElementArr) {
            arrayList.add(a(a2, v.d.C0634d.a.b.e.C0643b.f().a(i2)));
        }
        return w.a(arrayList);
    }

    private v.d.C0634d.a.b.c a(e eVar, int i2, int i3, int i4) {
        String str = eVar.f38707b;
        String str2 = eVar.f38706a;
        int i5 = 0;
        StackTraceElement[] stackTraceElementArr = eVar.f38708c != null ? eVar.f38708c : new StackTraceElement[0];
        e eVar2 = eVar.f38709d;
        if (i4 >= i3) {
            e eVar3 = eVar2;
            int i6 = 0;
            while (eVar3 != null) {
                eVar3 = eVar3.f38709d;
                i6++;
            }
            i5 = i6;
        }
        v.d.C0634d.a.b.c.C0639a a2 = v.d.C0634d.a.b.c.f().a(str).b(str2).a(w.a(a(stackTraceElementArr, i2))).a(i5);
        if (eVar2 != null && i5 == 0) {
            a2.a(a(eVar2, i2, i3, i4 + 1));
        }
        return a2.a();
    }

    private static v.d.C0634d.a.b.e.C0643b a(StackTraceElement stackTraceElement, v.d.C0634d.a.b.e.C0643b.C0644a aVar) {
        long j = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max((long) stackTraceElement.getLineNumber(), 0) : 0;
        String str = stackTraceElement.getClassName() + AppUtility.CENTER_DOT + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j = (long) stackTraceElement.getLineNumber();
        }
        return aVar.a(max).a(str).b(fileName).b(j).a();
    }

    static int a() {
        Integer num;
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str) && (num = f38296e.get(str.toLowerCase(Locale.US))) != null) {
            return num.intValue();
        }
        return 7;
    }
}
