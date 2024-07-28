package com.zhihu.matisse;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.Set;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f45713a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Fragment> f45714b;

    private a(Activity activity) {
        this(activity, (byte) 0);
    }

    private a(Activity activity, byte b2) {
        this.f45713a = new WeakReference<>(activity);
        this.f45714b = new WeakReference<>((Object) null);
    }

    public static a a(Activity activity) {
        return new a(activity);
    }

    public final c a(Set<b> set, boolean z) {
        return new c(this, set, z);
    }

    /* access modifiers changed from: package-private */
    public final Activity a() {
        return (Activity) this.f45713a.get();
    }

    /* access modifiers changed from: package-private */
    public final Fragment b() {
        WeakReference<Fragment> weakReference = this.f45714b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }
}
