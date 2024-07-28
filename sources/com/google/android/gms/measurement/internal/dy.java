package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public final class dy extends fw {

    /* renamed from: a  reason: collision with root package name */
    char f11826a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f11827b = -1;

    /* renamed from: c  reason: collision with root package name */
    public final ea f11828c = new ea(this, 6, false, false);

    /* renamed from: d  reason: collision with root package name */
    final ea f11829d = new ea(this, 6, true, false);

    /* renamed from: e  reason: collision with root package name */
    final ea f11830e = new ea(this, 6, false, true);

    /* renamed from: f  reason: collision with root package name */
    public final ea f11831f = new ea(this, 5, false, false);

    /* renamed from: g  reason: collision with root package name */
    final ea f11832g = new ea(this, 5, true, false);

    /* renamed from: h  reason: collision with root package name */
    final ea f11833h = new ea(this, 5, false, true);

    /* renamed from: i  reason: collision with root package name */
    final ea f11834i = new ea(this, 4, false, false);
    final ea j = new ea(this, 3, false, false);
    public final ea k = new ea(this, 2, false, false);
    private String l;

    dy(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    protected static Object a(String str) {
        if (str == null) {
            return null;
        }
        return new dz(str);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i2)) {
            a(i2, a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i2 >= 5) {
            s.a(str);
            eu euVar = this.y.f11947g;
            if (euVar == null) {
                a(6, "Scheduler not set. Not logging error/warn");
            } else if (!euVar.v()) {
                a(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i2 < 0) {
                    i2 = 0;
                }
                euVar.a((Runnable) new dx(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2) {
        return Log.isLoggable(c(), i2);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, String str) {
        Log.println(i2, c(), str);
    }

    private final String c() {
        String str;
        String str2;
        synchronized (this) {
            if (this.l == null) {
                if (this.y.f11943c != null) {
                    str2 = this.y.f11943c;
                } else {
                    str2 = "FA";
                }
                this.l = str2;
            }
            str = this.l;
        }
        return str;
    }

    static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String a2 = a(z, obj);
        String a3 = a(z, obj2);
        String a4 = a(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a4)) {
            sb.append(str2);
            sb.append(a4);
        }
        return sb.toString();
    }

    private static String a(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + 43 + str.length());
            sb.append(str);
            sb.append(round);
            sb.append(AppConstants.DOTS);
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String b2 = b(fc.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && b(className).equals(b2)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i2++;
                }
                return sb2.toString();
            } else if (obj instanceof dz) {
                return ((dz) obj).f11835a;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final String O_() {
        Pair<String, Long> a2 = I_().f11860c.a();
        if (a2 == null || a2 == eh.f11858a) {
            return null;
        }
        String valueOf = String.valueOf(a2.second);
        String str = (String) a2.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(AppConstants.COLON);
        sb.append(str);
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
