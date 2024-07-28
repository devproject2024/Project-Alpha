package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f3420a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final j f3421b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j.b f3422a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f3423b = false;

        public a(j.b bVar) {
            this.f3422a = bVar;
        }
    }

    i(j jVar) {
        this.f3421b = jVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment, Context context) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.a(fragment, context);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Fragment fragment, Context context) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.b(fragment, context);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.a(fragment, bundle);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.b(fragment, bundle);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.c(fragment, bundle);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.a(fragment, view, bundle, true);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!z || next.f3423b) {
                next.f3422a.a(this.f3421b, fragment, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.a(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.b(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.c(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.d(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(Fragment fragment, Bundle bundle) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.d(fragment, bundle);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.e(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.f(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }

    /* access modifiers changed from: package-private */
    public final void g(Fragment fragment) {
        Fragment fragment2 = this.f3421b.m;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f3432i.g(fragment);
        }
        Iterator<a> it2 = this.f3420a.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
    }
}
