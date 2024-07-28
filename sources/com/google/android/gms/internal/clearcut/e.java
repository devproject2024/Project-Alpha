package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import androidx.core.content.c;

public abstract class e<T> {

    /* renamed from: a  reason: collision with root package name */
    static Context f9318a = null;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f9319d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static boolean f9320e = false;

    /* renamed from: f  reason: collision with root package name */
    private static volatile Boolean f9321f = null;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Boolean f9322g = null;

    /* renamed from: b  reason: collision with root package name */
    final String f9323b;

    /* renamed from: c  reason: collision with root package name */
    final String f9324c;

    /* renamed from: h  reason: collision with root package name */
    private final n f9325h;

    /* renamed from: i  reason: collision with root package name */
    private final T f9326i;
    private T j;
    private volatile c k;
    private volatile SharedPreferences l;

    /* synthetic */ e(n nVar, String str, Object obj, byte b2) {
        this(nVar, str, obj);
    }

    private static <V> V a(l<V> lVar) {
        long clearCallingIdentity;
        try {
            return lVar.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = lVar.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static void a(Context context) {
        if (f9318a == null) {
            synchronized (f9319d) {
                if (Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (f9318a != context) {
                    f9321f = null;
                }
                f9318a = context;
            }
            f9320e = false;
        }
    }

    static boolean b(String str) {
        if (d()) {
            return ((Boolean) a(new h(str))).booleanValue();
        }
        return false;
    }

    private static boolean d() {
        if (f9321f == null) {
            Context context = f9318a;
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (c.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            f9321f = Boolean.valueOf(z);
        }
        return f9321f.booleanValue();
    }

    /* access modifiers changed from: protected */
    public abstract T a(SharedPreferences sharedPreferences);

    /* access modifiers changed from: protected */
    public abstract T a(String str);

    private e(n nVar, String str, T t) {
        this.j = null;
        this.k = null;
        this.l = null;
        if (nVar.f9421a == null && nVar.f9422b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (nVar.f9421a == null || nVar.f9422b == null) {
            this.f9325h = nVar;
            String valueOf = String.valueOf(nVar.f9423c);
            String valueOf2 = String.valueOf(str);
            this.f9324c = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(nVar.f9424d);
            String valueOf4 = String.valueOf(str);
            this.f9323b = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            this.f9326i = t;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    public final T a() {
        if (f9318a != null) {
            if (this.f9325h.f9426f) {
                T c2 = c();
                if (c2 != null) {
                    return c2;
                }
                T b2 = b();
                if (b2 != null) {
                    return b2;
                }
            } else {
                T b3 = b();
                if (b3 != null) {
                    return b3;
                }
                T c3 = c();
                if (c3 != null) {
                    return c3;
                }
            }
            return this.f9326i;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    private final T b() {
        boolean z;
        if (b("gms:phenotype:phenotype_flag:debug_bypass_phenotype")) {
            String valueOf = String.valueOf(this.f9323b);
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            } else {
                new String("Bypass reading Phenotype values for flag: ");
            }
        } else if (this.f9325h.f9422b != null) {
            if (this.k == null) {
                this.k = c.a(f9318a.getContentResolver(), this.f9325h.f9422b);
            }
            String str = (String) a(new f(this, this.k));
            if (str != null) {
                return a(str);
            }
        } else if (this.f9325h.f9421a != null) {
            if (Build.VERSION.SDK_INT < 24 || f9318a.isDeviceProtectedStorage()) {
                z = true;
            } else {
                if (f9322g == null || !f9322g.booleanValue()) {
                    f9322g = Boolean.valueOf(((UserManager) f9318a.getSystemService(UserManager.class)).isUserUnlocked());
                }
                z = f9322g.booleanValue();
            }
            if (!z) {
                return null;
            }
            if (this.l == null) {
                this.l = f9318a.getSharedPreferences(this.f9325h.f9421a, 0);
            }
            SharedPreferences sharedPreferences = this.l;
            if (sharedPreferences.contains(this.f9323b)) {
                return a(sharedPreferences);
            }
        }
        return null;
    }

    private final T c() {
        String str;
        if (this.f9325h.f9425e || !d() || (str = (String) a(new g(this))) == null) {
            return null;
        }
        return a(str);
    }

    static /* synthetic */ e a(n nVar, String str) {
        return new i(nVar, str, Boolean.FALSE);
    }

    static /* synthetic */ e b(n nVar, String str) {
        return new j(nVar, str);
    }

    static /* synthetic */ e a(n nVar, String str, Object obj, m mVar) {
        return new k(nVar, str, obj, mVar);
    }
}
