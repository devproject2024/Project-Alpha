package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.core.g.f;
import com.google.android.material.a.h;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.List;

abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36315a;

    /* renamed from: b  reason: collision with root package name */
    private final ExtendedFloatingActionButton f36316b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f36317c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final a f36318d;

    /* renamed from: e  reason: collision with root package name */
    private h f36319e;

    /* renamed from: f  reason: collision with root package name */
    private h f36320f;

    b(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f36316b = extendedFloatingActionButton;
        this.f36315a = extendedFloatingActionButton.getContext();
        this.f36318d = aVar;
    }

    public final void a(h hVar) {
        this.f36320f = hVar;
    }

    public final h a() {
        h hVar = this.f36320f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f36319e == null) {
            this.f36319e = h.a(this.f36315a, h());
        }
        return (h) f.a(this.f36319e);
    }

    public final List<Animator.AnimatorListener> b() {
        return this.f36317c;
    }

    public final h c() {
        return this.f36320f;
    }

    public void a(Animator animator) {
        a aVar = this.f36318d;
        if (aVar.f36314a != null) {
            aVar.f36314a.cancel();
        }
        aVar.f36314a = animator;
    }

    public void d() {
        this.f36318d.f36314a = null;
    }

    public void e() {
        this.f36318d.f36314a = null;
    }

    public AnimatorSet f() {
        return b(a());
    }

    /* access modifiers changed from: package-private */
    public final AnimatorSet b(h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.b("opacity")) {
            arrayList.add(hVar.a("opacity", this.f36316b, View.ALPHA));
        }
        if (hVar.b("scale")) {
            arrayList.add(hVar.a("scale", this.f36316b, View.SCALE_Y));
            arrayList.add(hVar.a("scale", this.f36316b, View.SCALE_X));
        }
        if (hVar.b(StringSet.width)) {
            arrayList.add(hVar.a(StringSet.width, this.f36316b, ExtendedFloatingActionButton.f36273b));
        }
        if (hVar.b(StringSet.height)) {
            arrayList.add(hVar.a(StringSet.height, this.f36316b, ExtendedFloatingActionButton.f36274c));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }
}
