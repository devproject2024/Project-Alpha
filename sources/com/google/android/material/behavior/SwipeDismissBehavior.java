package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.a.c;
import androidx.core.h.a.f;
import androidx.core.h.u;
import androidx.customview.a.c;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    c f35905a;

    /* renamed from: b  reason: collision with root package name */
    public a f35906b;

    /* renamed from: c  reason: collision with root package name */
    public int f35907c = 2;

    /* renamed from: d  reason: collision with root package name */
    float f35908d = 0.5f;

    /* renamed from: e  reason: collision with root package name */
    public float f35909e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f35910f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f35911g;

    /* renamed from: h  reason: collision with root package name */
    private float f35912h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private boolean f35913i;
    private final c.a j = new c.a() {

        /* renamed from: b  reason: collision with root package name */
        private int f35915b;

        /* renamed from: c  reason: collision with root package name */
        private int f35916c = -1;

        public final boolean b(View view, int i2) {
            int i3 = this.f35916c;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }

        public final void a(View view, int i2) {
            this.f35916c = i2;
            this.f35915b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public final void a(int i2) {
            if (SwipeDismissBehavior.this.f35906b != null) {
                SwipeDismissBehavior.this.f35906b.a(i2);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.f35915b) >= java.lang.Math.round(((float) r8.getWidth()) * r7.f35914a.f35908d)) goto L_0x005b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r10 = -1
                r7.f35916c = r10
                int r10 = r8.getWidth()
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x003f
                int r4 = androidx.core.h.u.j(r8)
                if (r4 != r2) goto L_0x0016
                r4 = 1
                goto L_0x0017
            L_0x0016:
                r4 = 0
            L_0x0017:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.f35907c
                r6 = 2
                if (r5 != r6) goto L_0x001f
                goto L_0x005b
            L_0x001f:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.f35907c
                if (r5 != 0) goto L_0x002f
                if (r4 == 0) goto L_0x002c
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x005d
                goto L_0x005b
            L_0x002c:
                if (r3 <= 0) goto L_0x005d
                goto L_0x005b
            L_0x002f:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r5 = r5.f35907c
                if (r5 != r2) goto L_0x005d
                if (r4 == 0) goto L_0x003a
                if (r3 <= 0) goto L_0x005d
                goto L_0x005b
            L_0x003a:
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x005d
                goto L_0x005b
            L_0x003f:
                int r9 = r8.getLeft()
                int r0 = r7.f35915b
                int r9 = r9 - r0
                int r0 = r8.getWidth()
                float r0 = (float) r0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.f35908d
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                int r9 = java.lang.Math.abs(r9)
                if (r9 < r0) goto L_0x005d
            L_0x005b:
                r9 = 1
                goto L_0x005e
            L_0x005d:
                r9 = 0
            L_0x005e:
                if (r9 == 0) goto L_0x006d
                int r9 = r8.getLeft()
                int r0 = r7.f35915b
                if (r9 >= r0) goto L_0x006a
                int r0 = r0 - r10
                goto L_0x006b
            L_0x006a:
                int r0 = r0 + r10
            L_0x006b:
                r1 = 1
                goto L_0x006f
            L_0x006d:
                int r0 = r7.f35915b
            L_0x006f:
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.a.c r9 = r9.f35905a
                int r10 = r8.getTop()
                boolean r9 = r9.a((int) r0, (int) r10)
                if (r9 == 0) goto L_0x0088
                com.google.android.material.behavior.SwipeDismissBehavior$b r9 = new com.google.android.material.behavior.SwipeDismissBehavior$b
                com.google.android.material.behavior.SwipeDismissBehavior r10 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r9.<init>(r8, r1)
                androidx.core.h.u.a((android.view.View) r8, (java.lang.Runnable) r9)
                return
            L_0x0088:
                if (r1 == 0) goto L_0x0097
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$a r9 = r9.f35906b
                if (r9 == 0) goto L_0x0097
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$a r9 = r9.f35906b
                r9.a((android.view.View) r8)
            L_0x0097:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.a(android.view.View, float, float):void");
        }

        public final int a(View view) {
            return view.getWidth();
        }

        public final int c(View view, int i2) {
            int i3;
            int i4;
            int width;
            boolean z = u.j(view) == 1;
            if (SwipeDismissBehavior.this.f35907c != 0) {
                if (SwipeDismissBehavior.this.f35907c != 1) {
                    i4 = this.f35915b - view.getWidth();
                    i3 = view.getWidth() + this.f35915b;
                } else if (z) {
                    i4 = this.f35915b;
                    width = view.getWidth();
                } else {
                    i4 = this.f35915b - view.getWidth();
                    i3 = this.f35915b;
                }
                return SwipeDismissBehavior.a(i4, i2, i3);
            } else if (z) {
                i4 = this.f35915b - view.getWidth();
                i3 = this.f35915b;
                return SwipeDismissBehavior.a(i4, i2, i3);
            } else {
                i4 = this.f35915b;
                width = view.getWidth();
            }
            i3 = width + i4;
            return SwipeDismissBehavior.a(i4, i2, i3);
        }

        public final int d(View view, int i2) {
            return view.getTop();
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            float width = ((float) this.f35915b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f35909e);
            float width2 = ((float) this.f35915b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f35910f);
            float f2 = (float) i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(1.0f - SwipeDismissBehavior.a(width, width2, f2)));
            }
        }
    };

    public interface a {
        void a(int i2);

        void a(View view);
    }

    static float a(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public boolean a(View view) {
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i2) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i2);
        if (u.h(v) == 0) {
            u.c((View) v, 1);
            u.d((View) v, 1048576);
            if (a((View) v)) {
                u.a((View) v, c.a.u, (f) new f() {
                    public final boolean a(View view) {
                        boolean z = false;
                        if (!SwipeDismissBehavior.this.a(view)) {
                            return false;
                        }
                        boolean z2 = u.j(view) == 1;
                        if ((SwipeDismissBehavior.this.f35907c == 0 && z2) || (SwipeDismissBehavior.this.f35907c == 1 && !z2)) {
                            z = true;
                        }
                        int width = view.getWidth();
                        if (z) {
                            width = -width;
                        }
                        u.g(view, width);
                        view.setAlpha(0.0f);
                        if (SwipeDismissBehavior.this.f35906b != null) {
                            SwipeDismissBehavior.this.f35906b.a(view);
                        }
                        return true;
                    }
                });
            }
        }
        return onLayoutChild;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        androidx.customview.a.c cVar;
        boolean z = this.f35911g;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f35911g = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f35911g;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f35911g = false;
        }
        if (!z) {
            return false;
        }
        if (this.f35905a == null) {
            if (this.f35913i) {
                cVar = androidx.customview.a.c.a((ViewGroup) coordinatorLayout, this.f35912h, this.j);
            } else {
                cVar = androidx.customview.a.c.a((ViewGroup) coordinatorLayout, this.j);
            }
            this.f35905a = cVar;
        }
        return this.f35905a.a(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        androidx.customview.a.c cVar = this.f35905a;
        if (cVar == null) {
            return false;
        }
        cVar.b(motionEvent);
        return true;
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f35919b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f35920c;

        b(View view, boolean z) {
            this.f35919b = view;
            this.f35920c = z;
        }

        public final void run() {
            if (SwipeDismissBehavior.this.f35905a != null && SwipeDismissBehavior.this.f35905a.f()) {
                u.a(this.f35919b, (Runnable) this);
            } else if (this.f35920c && SwipeDismissBehavior.this.f35906b != null) {
                SwipeDismissBehavior.this.f35906b.a(this.f35919b);
            }
        }
    }

    public static float a(float f2) {
        return Math.min(Math.max(0.0f, f2), 1.0f);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
