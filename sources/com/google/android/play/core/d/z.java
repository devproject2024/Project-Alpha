package com.google.android.play.core.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.b.ar;
import com.google.android.play.core.b.av;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.l;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

final class z {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public static final b f37452a = new b("SplitInstallService");

    /* renamed from: c  reason: collision with root package name */
    private static final Intent f37453c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* renamed from: b  reason: collision with root package name */
    l<ar> f37454b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f37455d;

    public z(Context context) {
        this.f37455d = context.getPackageName();
        if (av.a(context)) {
            this.f37454b = new l(as.a(context), f37452a, "SplitInstallService", f37453c, n.f37434a);
        }
    }

    static <T> e<T> a() {
        f37452a.b("onError(%d)", -14);
        return g.a((Exception) new a(-14));
    }

    static /* synthetic */ ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it2.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static /* synthetic */ Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10703);
        return bundle;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.List, java.util.Collection] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.ArrayList b(java.util.Collection r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r6.size()
            r0.<init>(r1)
            int r1 = r6.size()
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x0026
            java.lang.Object r3 = r6.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "language"
            r4.putString(r5, r3)
            r0.add(r4)
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.d.z.b(java.util.Collection):java.util.ArrayList");
    }
}
