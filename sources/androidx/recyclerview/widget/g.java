package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.h.u;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends y {
    private static TimeInterpolator n;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.v>> f4207a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ArrayList<b>> f4208b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ArrayList<a>> f4209c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4210d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4211e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4212f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<RecyclerView.v> f4213g = new ArrayList<>();
    private ArrayList<RecyclerView.v> o = new ArrayList<>();
    private ArrayList<RecyclerView.v> p = new ArrayList<>();
    private ArrayList<b> q = new ArrayList<>();
    private ArrayList<a> r = new ArrayList<>();

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f4248a;

        /* renamed from: b  reason: collision with root package name */
        public int f4249b;

        /* renamed from: c  reason: collision with root package name */
        public int f4250c;

        /* renamed from: d  reason: collision with root package name */
        public int f4251d;

        /* renamed from: e  reason: collision with root package name */
        public int f4252e;

        b(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
            this.f4248a = vVar;
            this.f4249b = i2;
            this.f4250c = i3;
            this.f4251d = i4;
            this.f4252e = i5;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.v f4242a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.v f4243b;

        /* renamed from: c  reason: collision with root package name */
        public int f4244c;

        /* renamed from: d  reason: collision with root package name */
        public int f4245d;

        /* renamed from: e  reason: collision with root package name */
        public int f4246e;

        /* renamed from: f  reason: collision with root package name */
        public int f4247f;

        private a(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.f4242a = vVar;
            this.f4243b = vVar2;
        }

        a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
            this(vVar, vVar2);
            this.f4244c = i2;
            this.f4245d = i3;
            this.f4246e = i4;
            this.f4247f = i5;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.f4242a + ", newHolder=" + this.f4243b + ", fromX=" + this.f4244c + ", fromY=" + this.f4245d + ", toX=" + this.f4246e + ", toY=" + this.f4247f + '}';
        }
    }

    public final void a() {
        long j;
        long j2;
        boolean z = !this.o.isEmpty();
        boolean z2 = !this.q.isEmpty();
        boolean z3 = !this.r.isEmpty();
        boolean z4 = !this.p.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.v> it2 = this.o.iterator();
            while (it2.hasNext()) {
                final RecyclerView.v next = it2.next();
                final View view = next.itemView;
                final ViewPropertyAnimator animate = view.animate();
                this.f4212f.add(next);
                animate.setDuration(this.j).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        animate.setListener((Animator.AnimatorListener) null);
                        view.setAlpha(1.0f);
                        g.this.f(next);
                        g.this.f4212f.remove(next);
                        g.this.c();
                    }
                }).start();
            }
            this.o.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.q);
                this.f4208b.add(arrayList);
                this.q.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public final void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            g gVar = g.this;
                            RecyclerView.v vVar = bVar.f4248a;
                            int i2 = bVar.f4249b;
                            int i3 = bVar.f4250c;
                            int i4 = bVar.f4251d;
                            int i5 = bVar.f4252e;
                            View view = vVar.itemView;
                            int i6 = i4 - i2;
                            int i7 = i5 - i3;
                            if (i6 != 0) {
                                view.animate().translationX(0.0f);
                            }
                            if (i7 != 0) {
                                view.animate().translationY(0.0f);
                            }
                            ViewPropertyAnimator animate = view.animate();
                            gVar.f4211e.add(vVar);
                            animate.setDuration(gVar.k).setListener(new AnimatorListenerAdapter(vVar, i6, view, i7, animate) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ RecyclerView.v f4228a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ int f4229b;

                                /* renamed from: c  reason: collision with root package name */
                                final /* synthetic */ View f4230c;

                                /* renamed from: d  reason: collision with root package name */
                                final /* synthetic */ int f4231d;

                                /* renamed from: e  reason: collision with root package name */
                                final /* synthetic */ ViewPropertyAnimator f4232e;

                                public final void onAnimationStart(Animator animator) {
                                }

                                {
                                    this.f4228a = r2;
                                    this.f4229b = r3;
                                    this.f4230c = r4;
                                    this.f4231d = r5;
                                    this.f4232e = r6;
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    if (this.f4229b != 0) {
                                        this.f4230c.setTranslationX(0.0f);
                                    }
                                    if (this.f4231d != 0) {
                                        this.f4230c.setTranslationY(0.0f);
                                    }
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.f4232e.setListener((Animator.AnimatorListener) null);
                                    g.this.f(this.f4228a);
                                    g.this.f4211e.remove(this.f4228a);
                                    g.this.c();
                                }
                            }).start();
                        }
                        arrayList.clear();
                        g.this.f4208b.remove(arrayList);
                    }
                };
                if (z) {
                    u.a(((b) arrayList.get(0)).f4248a.itemView, (Runnable) r6, this.j);
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.r);
                this.f4209c.add(arrayList2);
                this.r.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public final void run() {
                        View view;
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            a aVar = (a) it2.next();
                            g gVar = g.this;
                            RecyclerView.v vVar = aVar.f4242a;
                            View view2 = null;
                            if (vVar == null) {
                                view = null;
                            } else {
                                view = vVar.itemView;
                            }
                            RecyclerView.v vVar2 = aVar.f4243b;
                            if (vVar2 != null) {
                                view2 = vVar2.itemView;
                            }
                            if (view != null) {
                                ViewPropertyAnimator duration = view.animate().setDuration(gVar.l);
                                gVar.f4213g.add(aVar.f4242a);
                                duration.translationX((float) (aVar.f4246e - aVar.f4244c));
                                duration.translationY((float) (aVar.f4247f - aVar.f4245d));
                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter(aVar, duration, view) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ a f4234a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ ViewPropertyAnimator f4235b;

                                    /* renamed from: c  reason: collision with root package name */
                                    final /* synthetic */ View f4236c;

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    {
                                        this.f4234a = r2;
                                        this.f4235b = r3;
                                        this.f4236c = r4;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        this.f4235b.setListener((Animator.AnimatorListener) null);
                                        this.f4236c.setAlpha(1.0f);
                                        this.f4236c.setTranslationX(0.0f);
                                        this.f4236c.setTranslationY(0.0f);
                                        g.this.f(this.f4234a.f4242a);
                                        g.this.f4213g.remove(this.f4234a.f4242a);
                                        g.this.c();
                                    }
                                }).start();
                            }
                            if (view2 != null) {
                                ViewPropertyAnimator animate = view2.animate();
                                gVar.f4213g.add(aVar.f4243b);
                                animate.translationX(0.0f).translationY(0.0f).setDuration(gVar.l).alpha(1.0f).setListener(new AnimatorListenerAdapter(aVar, animate, view2) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ a f4238a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ ViewPropertyAnimator f4239b;

                                    /* renamed from: c  reason: collision with root package name */
                                    final /* synthetic */ View f4240c;

                                    public final void onAnimationStart(Animator animator) {
                                    }

                                    {
                                        this.f4238a = r2;
                                        this.f4239b = r3;
                                        this.f4240c = r4;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        this.f4239b.setListener((Animator.AnimatorListener) null);
                                        this.f4240c.setAlpha(1.0f);
                                        this.f4240c.setTranslationX(0.0f);
                                        this.f4240c.setTranslationY(0.0f);
                                        g.this.f(this.f4238a.f4243b);
                                        g.this.f4213g.remove(this.f4238a.f4243b);
                                        g.this.c();
                                    }
                                }).start();
                            }
                        }
                        arrayList2.clear();
                        g.this.f4209c.remove(arrayList2);
                    }
                };
                if (z) {
                    u.a(((a) arrayList2.get(0)).f4242a.itemView, (Runnable) r62, this.j);
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.p);
                this.f4207a.add(arrayList3);
                this.p.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public final void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            RecyclerView.v vVar = (RecyclerView.v) it2.next();
                            g gVar = g.this;
                            View view = vVar.itemView;
                            ViewPropertyAnimator animate = view.animate();
                            gVar.f4210d.add(vVar);
                            animate.alpha(1.0f).setDuration(gVar.f4061i).setListener(new AnimatorListenerAdapter(vVar, view, animate) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ RecyclerView.v f4224a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ View f4225b;

                                /* renamed from: c  reason: collision with root package name */
                                final /* synthetic */ ViewPropertyAnimator f4226c;

                                public final void onAnimationStart(Animator animator) {
                                }

                                {
                                    this.f4224a = r2;
                                    this.f4225b = r3;
                                    this.f4226c = r4;
                                }

                                public final void onAnimationCancel(Animator animator) {
                                    this.f4225b.setAlpha(1.0f);
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.f4226c.setListener((Animator.AnimatorListener) null);
                                    g.this.f(this.f4224a);
                                    g.this.f4210d.remove(this.f4224a);
                                    g.this.c();
                                }
                            }).start();
                        }
                        arrayList3.clear();
                        g.this.f4207a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j3 = 0;
                    if (z) {
                        j = this.j;
                    } else {
                        j = 0;
                    }
                    if (z2) {
                        j2 = this.k;
                    } else {
                        j2 = 0;
                    }
                    if (z3) {
                        j3 = this.l;
                    }
                    u.a(((RecyclerView.v) arrayList3.get(0)).itemView, (Runnable) r5, j + Math.max(j2, j3));
                    return;
                }
                r5.run();
            }
        }
    }

    public final boolean a(RecyclerView.v vVar) {
        h(vVar);
        this.o.add(vVar);
        return true;
    }

    public final boolean b(RecyclerView.v vVar) {
        h(vVar);
        vVar.itemView.setAlpha(0.0f);
        this.p.add(vVar);
        return true;
    }

    public final boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5) {
        View view = vVar.itemView;
        int translationX = i2 + ((int) vVar.itemView.getTranslationX());
        int translationY = i3 + ((int) vVar.itemView.getTranslationY());
        h(vVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            f(vVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.q.add(new b(vVar, translationX, translationY, i4, i5));
        return true;
    }

    public final boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5) {
        if (vVar == vVar2) {
            return a(vVar, i2, i3, i4, i5);
        }
        float translationX = vVar.itemView.getTranslationX();
        float translationY = vVar.itemView.getTranslationY();
        float alpha = vVar.itemView.getAlpha();
        h(vVar);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        vVar.itemView.setTranslationX(translationX);
        vVar.itemView.setTranslationY(translationY);
        vVar.itemView.setAlpha(alpha);
        if (vVar2 != null) {
            h(vVar2);
            vVar2.itemView.setTranslationX((float) (-i6));
            vVar2.itemView.setTranslationY((float) (-i7));
            vVar2.itemView.setAlpha(0.0f);
        }
        this.r.add(new a(vVar, vVar2, i2, i3, i4, i5));
        return true;
    }

    private void a(List<a> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, vVar) && aVar.f4242a == null && aVar.f4243b == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.f4242a != null) {
            a(aVar, aVar.f4242a);
        }
        if (aVar.f4243b != null) {
            a(aVar, aVar.f4243b);
        }
    }

    private boolean a(a aVar, RecyclerView.v vVar) {
        if (aVar.f4243b == vVar) {
            aVar.f4243b = null;
        } else if (aVar.f4242a != vVar) {
            return false;
        } else {
            aVar.f4242a = null;
        }
        vVar.itemView.setAlpha(1.0f);
        vVar.itemView.setTranslationX(0.0f);
        vVar.itemView.setTranslationY(0.0f);
        f(vVar);
        return true;
    }

    public final void c(RecyclerView.v vVar) {
        View view = vVar.itemView;
        view.animate().cancel();
        int size = this.q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.q.get(size).f4248a == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                f(vVar);
                this.q.remove(size);
            }
        }
        a((List<a>) this.r, vVar);
        if (this.o.remove(vVar)) {
            view.setAlpha(1.0f);
            f(vVar);
        }
        if (this.p.remove(vVar)) {
            view.setAlpha(1.0f);
            f(vVar);
        }
        for (int size2 = this.f4209c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f4209c.get(size2);
            a((List<a>) arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.f4209c.remove(size2);
            }
        }
        for (int size3 = this.f4208b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f4208b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f4248a == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    f(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f4208b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f4207a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f4207a.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                f(vVar);
                if (arrayList3.isEmpty()) {
                    this.f4207a.remove(size5);
                }
            }
        }
        this.f4212f.remove(vVar);
        this.f4210d.remove(vVar);
        this.f4213g.remove(vVar);
        this.f4211e.remove(vVar);
        c();
    }

    private void h(RecyclerView.v vVar) {
        if (n == null) {
            n = new ValueAnimator().getInterpolator();
        }
        vVar.itemView.animate().setInterpolator(n);
        c(vVar);
    }

    public final boolean b() {
        return !this.p.isEmpty() || !this.r.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.f4211e.isEmpty() || !this.f4212f.isEmpty() || !this.f4210d.isEmpty() || !this.f4213g.isEmpty() || !this.f4208b.isEmpty() || !this.f4207a.isEmpty() || !this.f4209c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (!b()) {
            e();
        }
    }

    public final void d() {
        int size = this.q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.q.get(size);
            View view = bVar.f4248a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            f(bVar.f4248a);
            this.q.remove(size);
        }
        for (int size2 = this.o.size() - 1; size2 >= 0; size2--) {
            f(this.o.get(size2));
            this.o.remove(size2);
        }
        int size3 = this.p.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.p.get(size3);
            vVar.itemView.setAlpha(1.0f);
            f(vVar);
            this.p.remove(size3);
        }
        for (int size4 = this.r.size() - 1; size4 >= 0; size4--) {
            a(this.r.get(size4));
        }
        this.r.clear();
        if (b()) {
            for (int size5 = this.f4208b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f4208b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f4248a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    f(bVar2.f4248a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f4208b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f4207a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f4207a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = (RecyclerView.v) arrayList2.get(size8);
                    vVar2.itemView.setAlpha(1.0f);
                    f(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f4207a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f4209c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f4209c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    a((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f4209c.remove(arrayList3);
                    }
                }
            }
            a((List<RecyclerView.v>) this.f4212f);
            a((List<RecyclerView.v>) this.f4211e);
            a((List<RecyclerView.v>) this.f4210d);
            a((List<RecyclerView.v>) this.f4213g);
            e();
        }
    }

    private static void a(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public final boolean a(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.a(vVar, list);
    }
}
