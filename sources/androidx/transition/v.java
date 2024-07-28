package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.h.u;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<ViewGroup> f4837a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static Transition f4838b = new AutoTransition();

    /* renamed from: c  reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.a.a<ViewGroup, ArrayList<Transition>>>> f4839c = new ThreadLocal<>();

    static androidx.a.a<ViewGroup, ArrayList<Transition>> a() {
        androidx.a.a<ViewGroup, ArrayList<Transition>> aVar;
        WeakReference weakReference = f4839c.get();
        if (weakReference != null && (aVar = (androidx.a.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.a.a<ViewGroup, ArrayList<Transition>> aVar2 = new androidx.a.a<>();
        f4839c.set(new WeakReference(aVar2));
        return aVar2;
    }

    private static void b(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f4840a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f4841b;

        public final void onViewAttachedToWindow(View view) {
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.f4840a = transition;
            this.f4841b = viewGroup;
        }

        private void a() {
            this.f4841b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4841b.removeOnAttachStateChangeListener(this);
        }

        public final void onViewDetachedFromWindow(View view) {
            a();
            v.f4837a.remove(this.f4841b);
            ArrayList arrayList = v.a().get(this.f4841b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).f(this.f4841b);
                }
            }
            this.f4840a.a(true);
        }

        public final boolean onPreDraw() {
            a();
            if (!v.f4837a.remove(this.f4841b)) {
                return true;
            }
            final androidx.a.a<ViewGroup, ArrayList<Transition>> a2 = v.a();
            ArrayList arrayList = a2.get(this.f4841b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f4841b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4840a);
            this.f4840a.a((Transition.d) new u() {
                public final void a(Transition transition) {
                    ((ArrayList) a2.get(a.this.f4841b)).remove(transition);
                    transition.b((Transition.d) this);
                }
            });
            this.f4840a.a(this.f4841b, false);
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).f(this.f4841b);
                }
            }
            this.f4840a.a(this.f4841b);
            return true;
        }
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).e(viewGroup);
            }
        }
        if (transition != null) {
            transition.a(viewGroup, true);
        }
        p a2 = p.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(p pVar) {
        b(pVar, f4838b);
    }

    public static void a(p pVar, Transition transition) {
        b(pVar, transition);
    }

    public static void a(ViewGroup viewGroup) {
        a(viewGroup, (Transition) null);
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f4837a.contains(viewGroup) && u.J(viewGroup)) {
            f4837a.add(viewGroup);
            if (transition == null) {
                transition = f4838b;
            }
            Transition g2 = transition.clone();
            c(viewGroup, g2);
            p.a(viewGroup, (p) null);
            b(viewGroup, g2);
        }
    }

    private static void b(p pVar, Transition transition) {
        ViewGroup viewGroup = pVar.f4818b;
        if (!f4837a.contains(viewGroup)) {
            p a2 = p.a(viewGroup);
            if (transition == null) {
                if (a2 != null) {
                    a2.a();
                }
                pVar.b();
                return;
            }
            f4837a.add(viewGroup);
            Transition g2 = transition.clone();
            g2.b(viewGroup);
            if (a2 != null) {
                if (a2.f4817a > 0) {
                    g2.b(true);
                }
            }
            c(viewGroup, g2);
            pVar.b();
            b(viewGroup, g2);
        }
    }
}
