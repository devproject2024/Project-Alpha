package com.paytm.recyclerview;

import android.view.View;
import androidx.core.h.u;
import androidx.core.h.x;
import androidx.core.h.y;
import com.paytm.recyclerview.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.q>> f15308a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ArrayList<b>> f15309b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<ArrayList<a>> f15310c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<RecyclerView.q> f15311d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<RecyclerView.q> f15312e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<RecyclerView.q> f15313f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<RecyclerView.q> f15314g = new ArrayList<>();
    private ArrayList<RecyclerView.q> n = new ArrayList<>();
    private ArrayList<RecyclerView.q> o = new ArrayList<>();
    private ArrayList<b> p = new ArrayList<>();
    private ArrayList<a> q = new ArrayList<>();

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.q f15345a;

        /* renamed from: b  reason: collision with root package name */
        public int f15346b;

        /* renamed from: c  reason: collision with root package name */
        public int f15347c;

        /* renamed from: d  reason: collision with root package name */
        public int f15348d;

        /* renamed from: e  reason: collision with root package name */
        public int f15349e;

        /* synthetic */ b(RecyclerView.q qVar, int i2, int i3, int i4, int i5, byte b2) {
            this(qVar, i2, i3, i4, i5);
        }

        private b(RecyclerView.q qVar, int i2, int i3, int i4, int i5) {
            this.f15345a = qVar;
            this.f15346b = i2;
            this.f15347c = i3;
            this.f15348d = i4;
            this.f15349e = i5;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.q f15339a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.q f15340b;

        /* renamed from: c  reason: collision with root package name */
        public int f15341c;

        /* renamed from: d  reason: collision with root package name */
        public int f15342d;

        /* renamed from: e  reason: collision with root package name */
        public int f15343e;

        /* renamed from: f  reason: collision with root package name */
        public int f15344f;

        /* synthetic */ a(RecyclerView.q qVar, RecyclerView.q qVar2, int i2, int i3, int i4, int i5, byte b2) {
            this(qVar, qVar2, i2, i3, i4, i5);
        }

        private a(RecyclerView.q qVar, RecyclerView.q qVar2) {
            this.f15339a = qVar;
            this.f15340b = qVar2;
        }

        private a(RecyclerView.q qVar, RecyclerView.q qVar2, int i2, int i3, int i4, int i5) {
            this(qVar, qVar2);
            this.f15341c = i2;
            this.f15342d = i3;
            this.f15343e = i4;
            this.f15344f = i5;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.f15339a + ", newHolder=" + this.f15340b + ", fromX=" + this.f15341c + ", fromY=" + this.f15342d + ", toX=" + this.f15343e + ", toY=" + this.f15344f + '}';
        }
    }

    public final void a() {
        long j;
        long j2;
        boolean z = !this.n.isEmpty();
        boolean z2 = !this.p.isEmpty();
        boolean z3 = !this.q.isEmpty();
        boolean z4 = !this.o.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.q> it2 = this.n.iterator();
            while (it2.hasNext()) {
                final RecyclerView.q next = it2.next();
                final x s = u.s(next.f15282a);
                this.f15313f.add(next);
                s.a(this.j).a(0.0f).a((y) new C0207c() {
                    public final void onAnimationStart(View view) {
                    }

                    public final void onAnimationEnd(View view) {
                        s.a((y) null);
                        u.c(view, 1.0f);
                        c.this.f(next);
                        c.this.f15313f.remove(next);
                        c.this.c();
                    }
                }).c();
            }
            this.n.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.p);
                this.f15309b.add(arrayList);
                this.p.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public final void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            c cVar = c.this;
                            RecyclerView.q qVar = bVar.f15345a;
                            int i2 = bVar.f15346b;
                            int i3 = bVar.f15347c;
                            int i4 = bVar.f15348d;
                            int i5 = bVar.f15349e;
                            View view = qVar.f15282a;
                            int i6 = i4 - i2;
                            int i7 = i5 - i3;
                            if (i6 != 0) {
                                u.s(view).b(0.0f);
                            }
                            if (i7 != 0) {
                                u.s(view).c(0.0f);
                            }
                            x s = u.s(view);
                            cVar.f15312e.add(qVar);
                            s.a(cVar.k).a((y) new C0207c(qVar, i6, i7, s) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ RecyclerView.q f15327a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ int f15328b;

                                /* renamed from: c  reason: collision with root package name */
                                final /* synthetic */ int f15329c;

                                /* renamed from: d  reason: collision with root package name */
                                final /* synthetic */ x f15330d;

                                public final void onAnimationStart(View view) {
                                }

                                {
                                    this.f15327a = r2;
                                    this.f15328b = r3;
                                    this.f15329c = r4;
                                    this.f15330d = r5;
                                }

                                public final void onAnimationCancel(View view) {
                                    if (this.f15328b != 0) {
                                        u.a(view, 0.0f);
                                    }
                                    if (this.f15329c != 0) {
                                        u.b(view, 0.0f);
                                    }
                                }

                                public final void onAnimationEnd(View view) {
                                    this.f15330d.a((y) null);
                                    c.this.f(this.f15327a);
                                    c.this.f15312e.remove(this.f15327a);
                                    c.this.c();
                                }
                            }).c();
                        }
                        arrayList.clear();
                        c.this.f15309b.remove(arrayList);
                    }
                };
                if (z) {
                    u.a(((b) arrayList.get(0)).f15345a.f15282a, (Runnable) r6, this.j);
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.q);
                this.f15310c.add(arrayList2);
                this.q.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public final void run() {
                        View view;
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            a aVar = (a) it2.next();
                            c cVar = c.this;
                            RecyclerView.q qVar = aVar.f15339a;
                            View view2 = null;
                            if (qVar == null) {
                                view = null;
                            } else {
                                view = qVar.f15282a;
                            }
                            RecyclerView.q qVar2 = aVar.f15340b;
                            if (qVar2 != null) {
                                view2 = qVar2.f15282a;
                            }
                            if (view != null) {
                                x a2 = u.s(view).a(cVar.l);
                                cVar.f15314g.add(aVar.f15339a);
                                a2.b((float) (aVar.f15343e - aVar.f15341c));
                                a2.c((float) (aVar.f15344f - aVar.f15342d));
                                a2.a(0.0f).a((y) new C0207c(aVar, a2) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ a f15332a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ x f15333b;

                                    public final void onAnimationStart(View view) {
                                    }

                                    {
                                        this.f15332a = r2;
                                        this.f15333b = r3;
                                    }

                                    public final void onAnimationEnd(View view) {
                                        this.f15333b.a((y) null);
                                        u.c(view, 1.0f);
                                        u.a(view, 0.0f);
                                        u.b(view, 0.0f);
                                        c.this.f(this.f15332a.f15339a);
                                        c.this.f15314g.remove(this.f15332a.f15339a);
                                        c.this.c();
                                    }
                                }).c();
                            }
                            if (view2 != null) {
                                x s = u.s(view2);
                                cVar.f15314g.add(aVar.f15340b);
                                s.b(0.0f).c(0.0f).a(cVar.l).a(1.0f).a((y) new C0207c(aVar, s, view2) {

                                    /* renamed from: a  reason: collision with root package name */
                                    final /* synthetic */ a f15335a;

                                    /* renamed from: b  reason: collision with root package name */
                                    final /* synthetic */ x f15336b;

                                    /* renamed from: c  reason: collision with root package name */
                                    final /* synthetic */ View f15337c;

                                    public final void onAnimationStart(View view) {
                                    }

                                    {
                                        this.f15335a = r2;
                                        this.f15336b = r3;
                                        this.f15337c = r4;
                                    }

                                    public final void onAnimationEnd(View view) {
                                        this.f15336b.a((y) null);
                                        u.c(this.f15337c, 1.0f);
                                        u.a(this.f15337c, 0.0f);
                                        u.b(this.f15337c, 0.0f);
                                        c.this.f(this.f15335a.f15340b);
                                        c.this.f15314g.remove(this.f15335a.f15340b);
                                        c.this.c();
                                    }
                                }).c();
                            }
                        }
                        arrayList2.clear();
                        c.this.f15310c.remove(arrayList2);
                    }
                };
                if (z) {
                    u.a(((a) arrayList2.get(0)).f15339a.f15282a, (Runnable) r62, this.j);
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.o);
                this.f15308a.add(arrayList3);
                this.o.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public final void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            RecyclerView.q qVar = (RecyclerView.q) it2.next();
                            c cVar = c.this;
                            x s = u.s(qVar.f15282a);
                            cVar.f15311d.add(qVar);
                            s.a(1.0f).a(cVar.f15234i).a((y) new C0207c(qVar, s) {

                                /* renamed from: a  reason: collision with root package name */
                                final /* synthetic */ RecyclerView.q f15324a;

                                /* renamed from: b  reason: collision with root package name */
                                final /* synthetic */ x f15325b;

                                public final void onAnimationStart(View view) {
                                }

                                {
                                    this.f15324a = r2;
                                    this.f15325b = r3;
                                }

                                public final void onAnimationCancel(View view) {
                                    u.c(view, 1.0f);
                                }

                                public final void onAnimationEnd(View view) {
                                    this.f15325b.a((y) null);
                                    c.this.f(this.f15324a);
                                    c.this.f15311d.remove(this.f15324a);
                                    c.this.c();
                                }
                            }).c();
                        }
                        arrayList3.clear();
                        c.this.f15308a.remove(arrayList3);
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
                    u.a(((RecyclerView.q) arrayList3.get(0)).f15282a, (Runnable) r5, j + Math.max(j2, j3));
                    return;
                }
                r5.run();
            }
        }
    }

    public final boolean a(RecyclerView.q qVar) {
        this.n.add(qVar);
        return true;
    }

    public final boolean b(RecyclerView.q qVar) {
        u.c(qVar.f15282a, 0.0f);
        this.o.add(qVar);
        return true;
    }

    public final boolean a(RecyclerView.q qVar, int i2, int i3, int i4, int i5) {
        View view = qVar.f15282a;
        int o2 = (int) (((float) i2) + u.o(qVar.f15282a));
        int p2 = (int) (((float) i3) + u.p(qVar.f15282a));
        int i6 = i4 - o2;
        int i7 = i5 - p2;
        if (i6 == 0 && i7 == 0) {
            f(qVar);
            return false;
        }
        if (i6 != 0) {
            u.a(view, (float) (-i6));
        }
        if (i7 != 0) {
            u.b(view, (float) (-i7));
        }
        this.p.add(new b(qVar, o2, p2, i4, i5, (byte) 0));
        return true;
    }

    public final boolean a(RecyclerView.q qVar, RecyclerView.q qVar2, int i2, int i3, int i4, int i5) {
        RecyclerView.q qVar3 = qVar;
        RecyclerView.q qVar4 = qVar2;
        if (qVar3 == qVar4) {
            return a(qVar, i2, i3, i4, i5);
        }
        float o2 = u.o(qVar3.f15282a);
        float p2 = u.p(qVar3.f15282a);
        float i6 = u.i(qVar3.f15282a);
        int i7 = (int) (((float) (i4 - i2)) - o2);
        int i8 = (int) (((float) (i5 - i3)) - p2);
        u.a(qVar3.f15282a, o2);
        u.b(qVar3.f15282a, p2);
        u.c(qVar3.f15282a, i6);
        if (qVar4 != null) {
            u.a(qVar4.f15282a, (float) (-i7));
            u.b(qVar4.f15282a, (float) (-i8));
            u.c(qVar4.f15282a, 0.0f);
        }
        this.q.add(new a(qVar, qVar2, i2, i3, i4, i5, (byte) 0));
        return true;
    }

    private void a(List<a> list, RecyclerView.q qVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, qVar) && aVar.f15339a == null && aVar.f15340b == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.f15339a != null) {
            a(aVar, aVar.f15339a);
        }
        if (aVar.f15340b != null) {
            a(aVar, aVar.f15340b);
        }
    }

    private boolean a(a aVar, RecyclerView.q qVar) {
        if (aVar.f15340b == qVar) {
            aVar.f15340b = null;
        } else if (aVar.f15339a != qVar) {
            return false;
        } else {
            aVar.f15339a = null;
        }
        u.c(qVar.f15282a, 1.0f);
        u.a(qVar.f15282a, 0.0f);
        u.b(qVar.f15282a, 0.0f);
        f(qVar);
        return true;
    }

    public final void c(RecyclerView.q qVar) {
        View view = qVar.f15282a;
        u.s(view).b();
        int size = this.p.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.p.get(size).f15345a == qVar) {
                u.b(view, 0.0f);
                u.a(view, 0.0f);
                f(qVar);
                this.p.remove(size);
            }
        }
        a((List<a>) this.q, qVar);
        if (this.n.remove(qVar)) {
            u.c(view, 1.0f);
            f(qVar);
        }
        if (this.o.remove(qVar)) {
            u.c(view, 1.0f);
            f(qVar);
        }
        for (int size2 = this.f15310c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f15310c.get(size2);
            a((List<a>) arrayList, qVar);
            if (arrayList.isEmpty()) {
                this.f15310c.remove(size2);
            }
        }
        for (int size3 = this.f15309b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f15309b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f15345a == qVar) {
                    u.b(view, 0.0f);
                    u.a(view, 0.0f);
                    f(qVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f15309b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f15308a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f15308a.get(size5);
            if (arrayList3.remove(qVar)) {
                u.c(view, 1.0f);
                f(qVar);
                if (arrayList3.isEmpty()) {
                    this.f15308a.remove(size5);
                }
            }
        }
        this.f15313f.remove(qVar);
        this.f15311d.remove(qVar);
        this.f15314g.remove(qVar);
        this.f15312e.remove(qVar);
        c();
    }

    public final boolean b() {
        return !this.o.isEmpty() || !this.q.isEmpty() || !this.p.isEmpty() || !this.n.isEmpty() || !this.f15312e.isEmpty() || !this.f15313f.isEmpty() || !this.f15311d.isEmpty() || !this.f15314g.isEmpty() || !this.f15309b.isEmpty() || !this.f15308a.isEmpty() || !this.f15310c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (!b()) {
            e();
        }
    }

    public final void d() {
        int size = this.p.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.p.get(size);
            View view = bVar.f15345a.f15282a;
            u.b(view, 0.0f);
            u.a(view, 0.0f);
            f(bVar.f15345a);
            this.p.remove(size);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            f(this.n.get(size2));
            this.n.remove(size2);
        }
        int size3 = this.o.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.q qVar = this.o.get(size3);
            u.c(qVar.f15282a, 1.0f);
            f(qVar);
            this.o.remove(size3);
        }
        for (int size4 = this.q.size() - 1; size4 >= 0; size4--) {
            a(this.q.get(size4));
        }
        this.q.clear();
        if (b()) {
            for (int size5 = this.f15309b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f15309b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f15345a.f15282a;
                    u.b(view2, 0.0f);
                    u.a(view2, 0.0f);
                    f(bVar2.f15345a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f15309b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f15308a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f15308a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.q qVar2 = (RecyclerView.q) arrayList2.get(size8);
                    u.c(qVar2.f15282a, 1.0f);
                    f(qVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f15308a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f15310c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f15310c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    a((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f15310c.remove(arrayList3);
                    }
                }
            }
            a((List<RecyclerView.q>) this.f15313f);
            a((List<RecyclerView.q>) this.f15312e);
            a((List<RecyclerView.q>) this.f15311d);
            a((List<RecyclerView.q>) this.f15314g);
            e();
        }
    }

    private static void a(List<RecyclerView.q> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            u.s(list.get(size).f15282a).b();
        }
    }

    public final boolean a(RecyclerView.q qVar, List<Object> list) {
        return !list.isEmpty() || super.a(qVar, list);
    }

    /* renamed from: com.paytm.recyclerview.c$c  reason: collision with other inner class name */
    static class C0207c implements y {
        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }

        private C0207c() {
        }

        /* synthetic */ C0207c(byte b2) {
            this();
        }
    }
}
