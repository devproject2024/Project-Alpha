package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.b.av;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.c;
import com.google.android.play.core.b.cb;
import com.google.android.play.core.b.l;
import com.google.android.play.core.d.as;
import com.google.android.play.core.e.e;
import com.google.android.play.core.e.g;
import com.google.android.play.core.e.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class s implements dk {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final b f37237a = new b("AssetPackServiceImpl");

    /* renamed from: b  reason: collision with root package name */
    private static final Intent f37238b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f37239c;

    /* renamed from: d  reason: collision with root package name */
    private final ba f37240d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public l<cb> f37241e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public l<cb> f37242f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f37243g = new AtomicBoolean();

    s(Context context, ba baVar) {
        this.f37239c = context.getPackageName();
        this.f37240d = baVar;
        if (av.a(context)) {
            this.f37241e = new l(as.a(context), f37237a, "AssetPackService", f37238b, dl.f37197a);
            this.f37242f = new l(as.a(context), f37237a, "AssetPackService-keepAlive", f37238b, dm.f37198a);
        }
        f37237a.a("AssetPackService initiated.", new Object[0]);
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

    /* access modifiers changed from: private */
    public final void a(int i2, String str, int i3) {
        if (this.f37241e != null) {
            f37237a.d("notifyModuleCompleted", new Object[0]);
            p pVar = new p();
            this.f37241e.a((c) new j(this, pVar, i2, str, pVar, i3));
            return;
        }
        throw new ax("The Play Store app is not installed or is an unofficial version.", i2);
    }

    static /* synthetic */ Bundle b(Map map) {
        Bundle e2 = e();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        e2.putParcelableArrayList("installed_asset_module", arrayList);
        return e2;
    }

    /* access modifiers changed from: private */
    public static Bundle c(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i2);
        return bundle;
    }

    /* access modifiers changed from: private */
    public static Bundle c(int i2, String str) {
        Bundle c2 = c(i2);
        c2.putString("module_name", str);
        return c2;
    }

    static /* synthetic */ Bundle c(int i2, String str, String str2, int i3) {
        Bundle c2 = c(i2, str);
        c2.putString("slice_id", str2);
        c2.putInt("chunk_number", i3);
        return c2;
    }

    private static <T> e<T> d() {
        f37237a.b("onError(%d)", -11);
        return g.a((Exception) new a(-11));
    }

    /* access modifiers changed from: private */
    public static Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10703);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    public final synchronized void a() {
        if (this.f37242f != null) {
            f37237a.d("keepAlive", new Object[0]);
            if (!this.f37243g.compareAndSet(false, true)) {
                f37237a.d("Service is already kept alive.", new Object[0]);
                return;
            }
            p pVar = new p();
            this.f37242f.a((c) new m(this, pVar, pVar));
            return;
        }
        f37237a.e("Keep alive connection manager is not initialized.", new Object[0]);
    }

    public final void a(int i2) {
        if (this.f37241e != null) {
            f37237a.d("notifySessionFailed", new Object[0]);
            p pVar = new p();
            this.f37241e.a((c) new k(this, pVar, i2, pVar));
            return;
        }
        throw new ax("The Play Store app is not installed or is an unofficial version.", i2);
    }

    public final void a(int i2, String str) {
        a(i2, str, 10);
    }

    public final void a(int i2, String str, String str2, int i3) {
        if (this.f37241e != null) {
            f37237a.d("notifyChunkTransferred", new Object[0]);
            p pVar = new p();
            this.f37241e.a((c) new h(this, pVar, i2, str, str2, i3, pVar));
            return;
        }
        throw new ax("The Play Store app is not installed or is an unofficial version.", i2);
    }

    public final void a(List<String> list) {
        if (this.f37241e != null) {
            f37237a.d("cancelDownloads(%s)", list);
            p pVar = new p();
            this.f37241e.a((c) new f(this, pVar, list, pVar));
        }
    }

    public final e<List<String>> a(Map<String, Long> map) {
        if (this.f37241e == null) {
            return d();
        }
        f37237a.d("syncPacks", new Object[0]);
        p pVar = new p();
        this.f37241e.a((c) new g(this, pVar, map, pVar));
        return pVar.f37476a;
    }

    public final e<ParcelFileDescriptor> b(int i2, String str, String str2, int i3) {
        if (this.f37241e == null) {
            return d();
        }
        f37237a.d("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i3), Integer.valueOf(i2));
        p pVar = new p();
        this.f37241e.a((c) new l(this, pVar, i2, str, str2, i3, pVar));
        return pVar.f37476a;
    }

    static /* synthetic */ List a(s sVar, List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            c next = d.a((Bundle) list.get(i2), sVar.f37240d, new ArrayList(), ac.f36950a).b().values().iterator().next();
            if (next == null) {
                f37237a.b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            int b2 = next.b();
            boolean z = true;
            if (!(b2 == 1 || b2 == 7 || b2 == 2 || b2 == 3)) {
                z = false;
            }
            if (z) {
                arrayList.add(next.a());
            }
        }
        return arrayList;
    }
}
