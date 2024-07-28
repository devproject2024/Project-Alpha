package com.bumptech.glide.b;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class o extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    final a f6460a;

    /* renamed from: b  reason: collision with root package name */
    final m f6461b;

    /* renamed from: c  reason: collision with root package name */
    i f6462c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<o> f6463d;

    /* renamed from: e  reason: collision with root package name */
    private o f6464e;

    /* renamed from: f  reason: collision with root package name */
    private Fragment f6465f;

    public o() {
        this(new a());
    }

    private o(a aVar) {
        this.f6461b = new a();
        this.f6463d = new HashSet();
        this.f6460a = aVar;
    }

    private void a(o oVar) {
        this.f6463d.add(oVar);
    }

    private void b(o oVar) {
        this.f6463d.remove(oVar);
    }

    /* access modifiers changed from: package-private */
    public final Set<o> a() {
        o oVar = this.f6464e;
        if (oVar == null) {
            return Collections.emptySet();
        }
        if (equals(oVar)) {
            return Collections.unmodifiableSet(this.f6463d);
        }
        HashSet hashSet = new HashSet();
        for (o next : this.f6464e.a()) {
            if (c(next.b())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment) {
        j b2;
        this.f6465f = fragment;
        if (fragment != null && fragment.getContext() != null && (b2 = b(fragment)) != null) {
            a(fragment.getContext(), b2);
        }
    }

    private static j b(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private Fragment b() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f6465f;
    }

    private boolean c(Fragment fragment) {
        Fragment b2 = b();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(b2)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void a(Context context, j jVar) {
        c();
        this.f6464e = b.a(context).f6429e.a(context, jVar);
        if (!equals(this.f6464e)) {
            this.f6464e.a(this);
        }
    }

    private void c() {
        o oVar = this.f6464e;
        if (oVar != null) {
            oVar.b(this);
            this.f6464e = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        j b2 = b((Fragment) this);
        if (b2 == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            a(getContext(), b2);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f6465f = null;
        c();
    }

    public void onStart() {
        super.onStart();
        this.f6460a.a();
    }

    public void onStop() {
        super.onStop();
        this.f6460a.b();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f6460a.c();
        c();
    }

    public String toString() {
        return super.toString() + "{parent=" + b() + "}";
    }

    class a implements m {
        a() {
        }

        public final Set<i> a() {
            Set<o> a2 = o.this.a();
            HashSet hashSet = new HashSet(a2.size());
            for (o next : a2) {
                if (next.f6462c != null) {
                    hashSet.add(next.f6462c);
                }
            }
            return hashSet;
        }

        public final String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }
}
