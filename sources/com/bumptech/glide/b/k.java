package com.bumptech.glide.b;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public final class k extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    final a f6441a;

    /* renamed from: b  reason: collision with root package name */
    final m f6442b;

    /* renamed from: c  reason: collision with root package name */
    i f6443c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<k> f6444d;

    /* renamed from: e  reason: collision with root package name */
    private k f6445e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f6446f;

    public k() {
        this(new a());
    }

    private k(a aVar) {
        this.f6442b = new a();
        this.f6444d = new HashSet();
        this.f6441a = aVar;
    }

    private void a(k kVar) {
        this.f6444d.add(kVar);
    }

    private void b(k kVar) {
        this.f6444d.remove(kVar);
    }

    /* access modifiers changed from: package-private */
    public final Set<k> a() {
        if (equals(this.f6445e)) {
            return Collections.unmodifiableSet(this.f6444d);
        }
        if (this.f6445e == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (k next : this.f6445e.a()) {
            if (b(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment) {
        this.f6446f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            a(fragment.getActivity());
        }
    }

    private boolean b(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void a(Activity activity) {
        b();
        this.f6445e = b.a((Context) activity).f6429e.b(activity);
        if (!equals(this.f6445e)) {
            this.f6445e.a(this);
        }
    }

    private void b() {
        k kVar = this.f6445e;
        if (kVar != null) {
            kVar.b(this);
            this.f6445e = null;
        }
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    public final void onDetach() {
        super.onDetach();
        b();
    }

    public final void onStart() {
        super.onStart();
        this.f6441a.a();
    }

    public final void onStop() {
        super.onStop();
        this.f6441a.b();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f6441a.c();
        b();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        if (parentFragment == null) {
            parentFragment = this.f6446f;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    class a implements m {
        a() {
        }

        public final Set<i> a() {
            Set<k> a2 = k.this.a();
            HashSet hashSet = new HashSet(a2.size());
            for (k next : a2) {
                if (next.f6443c != null) {
                    hashSet.add(next.f6443c);
                }
            }
            return hashSet;
        }

        public final String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }
}
