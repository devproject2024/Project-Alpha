package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.a.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.d.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class dc extends Fragment implements j {

    /* renamed from: a  reason: collision with root package name */
    private static WeakHashMap<FragmentActivity, WeakReference<dc>> f8577a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, LifecycleCallback> f8578b = new a();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f8579c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bundle f8580d;

    public static dc a(FragmentActivity fragmentActivity) {
        dc dcVar;
        WeakReference weakReference = f8577a.get(fragmentActivity);
        if (weakReference != null && (dcVar = (dc) weakReference.get()) != null) {
            return dcVar;
        }
        try {
            dc dcVar2 = (dc) fragmentActivity.getSupportFragmentManager().c("SupportLifecycleFragmentImpl");
            if (dcVar2 == null || dcVar2.isRemoving()) {
                dcVar2 = new dc();
                fragmentActivity.getSupportFragmentManager().a().a((Fragment) dcVar2, "SupportLifecycleFragmentImpl").c();
            }
            f8577a.put(fragmentActivity, new WeakReference(dcVar2));
            return dcVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f8578b.get(str));
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f8578b.containsKey(str)) {
            this.f8578b.put(str, lifecycleCallback);
            if (this.f8579c > 0) {
                new h(Looper.getMainLooper()).post(new dd(this, lifecycleCallback, str));
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

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8579c = 1;
        this.f8580d = bundle;
        for (Map.Entry next : this.f8578b.entrySet()) {
            ((LifecycleCallback) next.getValue()).a(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onStart() {
        super.onStart();
        this.f8579c = 2;
        for (LifecycleCallback b2 : this.f8578b.values()) {
            b2.b();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f8579c = 3;
        for (LifecycleCallback c2 : this.f8578b.values()) {
            c2.c();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback a2 : this.f8578b.values()) {
            a2.a(i2, i3, intent);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f8578b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).b(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStop() {
        super.onStop();
        this.f8579c = 4;
        for (LifecycleCallback d2 : this.f8578b.values()) {
            d2.d();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f8579c = 5;
        Iterator<LifecycleCallback> it2 = this.f8578b.values().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f8578b.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final /* synthetic */ Activity a() {
        return getActivity();
    }
}
