package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.a.a;
import com.google.android.gms.internal.d.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class db extends Fragment implements j {

    /* renamed from: a  reason: collision with root package name */
    private static WeakHashMap<Activity, WeakReference<db>> f8573a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, LifecycleCallback> f8574b = new a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f8575c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bundle f8576d;

    public static db a(Activity activity) {
        db dbVar;
        WeakReference weakReference = f8573a.get(activity);
        if (weakReference != null && (dbVar = (db) weakReference.get()) != null) {
            return dbVar;
        }
        try {
            db dbVar2 = (db) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (dbVar2 == null || dbVar2.isRemoving()) {
                dbVar2 = new db();
                activity.getFragmentManager().beginTransaction().add(dbVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f8573a.put(activity, new WeakReference(dbVar2));
            return dbVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
        }
    }

    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f8574b.get(str));
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f8574b.containsKey(str)) {
            this.f8574b.put(str, lifecycleCallback);
            if (this.f8575c > 0) {
                new h(Looper.getMainLooper()).post(new da(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Activity a() {
        return getActivity();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8575c = 1;
        this.f8576d = bundle;
        for (Map.Entry next : this.f8574b.entrySet()) {
            ((LifecycleCallback) next.getValue()).a(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f8575c = 2;
        for (LifecycleCallback b2 : this.f8574b.values()) {
            b2.b();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f8575c = 3;
        for (LifecycleCallback c2 : this.f8574b.values()) {
            c2.c();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback a2 : this.f8574b.values()) {
            a2.a(i2, i3, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f8574b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).b(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f8575c = 4;
        for (LifecycleCallback d2 : this.f8574b.values()) {
            d2.d();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f8575c = 5;
        Iterator<LifecycleCallback> it2 = this.f8574b.values().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f8574b.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }
}
