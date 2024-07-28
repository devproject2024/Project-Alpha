package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.c.b;
import com.google.android.gms.common.c.c;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final int f8987a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f8988b = a();

    /* renamed from: c  reason: collision with root package name */
    private static final Method f8989c = b();

    /* renamed from: d  reason: collision with root package name */
    private static final Method f8990d = c();

    /* renamed from: e  reason: collision with root package name */
    private static final Method f8991e = d();

    /* renamed from: f  reason: collision with root package name */
    private static final Method f8992f = e();

    /* renamed from: g  reason: collision with root package name */
    private static final Method f8993g = f();

    /* renamed from: h  reason: collision with root package name */
    private static final Method f8994h = g();

    private static WorkSource a(int i2, String str) {
        WorkSource workSource = new WorkSource();
        if (f8989c != null) {
            if (str == null) {
                str = "";
            }
            try {
                f8989c.invoke(workSource, new Object[]{Integer.valueOf(i2), str});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method = f8988b;
            if (method != null) {
                try {
                    method.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
        return workSource;
    }

    public static WorkSource a(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo a2 = c.a(context).a(str, 0);
                if (a2 != null) {
                    return a(a2.uid, str);
                }
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Could not get applicationInfo from package: ".concat(valueOf);
                } else {
                    new String("Could not get applicationInfo from package: ");
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                String valueOf2 = String.valueOf(str);
                if (valueOf2.length() != 0) {
                    "Could not find package: ".concat(valueOf2);
                } else {
                    new String("Could not find package: ");
                }
            }
        }
        return null;
    }

    private static int b(WorkSource workSource) {
        Method method = f8990d;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    private static String a(WorkSource workSource, int i2) {
        Method method = f8992f;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i2)});
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    public static List<String> a(WorkSource workSource) {
        int b2 = workSource == null ? 0 : b(workSource);
        if (b2 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < b2; i2++) {
            String a2 = a(workSource, i2);
            if (!p.a(a2)) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public static boolean a(Context context) {
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        b a2 = c.a(context);
        if (a2.f8654a.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    private static Method a() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method b() {
        if (n.a()) {
            try {
                return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method c() {
        try {
            return WorkSource.class.getMethod(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method d() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method e() {
        if (n.a()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method f() {
        if (n.g()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method g() {
        if (n.g()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[]{Integer.TYPE, String.class});
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
