package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.t;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

public class e extends t {
    public final boolean a(Object obj) {
        return obj instanceof Transition;
    }

    public final Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public final Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    public final void a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        ArrayList<View> arrayList2 = transitionSet.f4695f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a((List<View>) arrayList2, arrayList.get(i2));
        }
        arrayList2.add(view);
        arrayList.add(view);
        a((Object) transitionSet, arrayList);
    }

    public final void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((Transition) obj).a((Transition.c) new Transition.c() {
                public final Rect a() {
                    return rect;
                }
            });
        }
    }

    public final void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int size = transitionSet.f4707a.size();
                while (i2 < size) {
                    a((Object) transitionSet.c(i2), arrayList);
                    i2++;
                }
            } else if (!a(transition) && a((List) transition.f4695f)) {
                int size2 = arrayList.size();
                while (i2 < size2) {
                    transition.c(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public final Object a(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    public final void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).a((Transition.d) new Transition.d() {
            public final void a() {
            }

            public final void b() {
            }

            public final void b(Transition transition) {
            }

            public final void c() {
            }

            public final void a(Transition transition) {
                transition.b((Transition.d) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList.get(i2)).setVisibility(0);
                }
            }
        });
    }

    public final Object b(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().a(transition).a(transition2).b(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.a(transition);
        }
        transitionSet.a(transition3);
        return transitionSet;
    }

    public final void a(ViewGroup viewGroup, Object obj) {
        v.a(viewGroup, (Transition) obj);
    }

    public final void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).a((Transition.d) new u() {
            public final void b(Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    e.this.b(obj, (ArrayList<View>) arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    e.this.b(obj2, (ArrayList<View>) arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    e.this.b(obj3, (ArrayList<View>) arrayList6, (ArrayList<View>) null);
                }
            }

            public final void a(Transition transition) {
                transition.b((Transition.d) this);
            }
        });
    }

    public final void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.f4695f.clear();
            transitionSet.f4695f.addAll(arrayList2);
            b((Object) transitionSet, arrayList, arrayList2);
        }
    }

    public final void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i2;
        Transition transition = (Transition) obj;
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.f4707a.size();
            while (i3 < size) {
                b((Object) transitionSet.c(i3), arrayList, arrayList2);
                i3++;
            }
        } else if (!a(transition)) {
            ArrayList<View> arrayList3 = transition.f4695f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i2 = 0;
                } else {
                    i2 = arrayList2.size();
                }
                while (i3 < i2) {
                    transition.c(arrayList2.get(i3));
                    i3++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.d(arrayList.get(size2));
                }
            }
        }
    }

    public final void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).c(view);
        }
    }

    public final void c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).d(view);
        }
    }

    public final void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).a((Transition.c) new Transition.c() {
                public final Rect a() {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    private static boolean a(Transition transition) {
        return !a((List) transition.f4694e) || !a((List) transition.f4696g) || !a((List) transition.f4697h);
    }
}
