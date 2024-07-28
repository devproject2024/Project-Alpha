package androidx.core.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f3139a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f3140b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f3141c = null;

    /* renamed from: d  reason: collision with root package name */
    public int f3142d = -1;

    x(View view) {
        this.f3139a = new WeakReference<>(view);
    }

    public static class a implements y {

        /* renamed from: a  reason: collision with root package name */
        x f3149a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3150b;

        public a(x xVar) {
            this.f3149a = xVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.h.y} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onAnimationStart(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f3150b = r0
                androidx.core.h.x r0 = r3.f3149a
                int r0 = r0.f3142d
                r1 = 0
                if (r0 < 0) goto L_0x000e
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000e:
                androidx.core.h.x r0 = r3.f3149a
                java.lang.Runnable r0 = r0.f3140b
                if (r0 == 0) goto L_0x001f
                androidx.core.h.x r0 = r3.f3149a
                java.lang.Runnable r0 = r0.f3140b
                androidx.core.h.x r2 = r3.f3149a
                r2.f3140b = r1
                r0.run()
            L_0x001f:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.h.y
                if (r2 == 0) goto L_0x002c
                r1 = r0
                androidx.core.h.y r1 = (androidx.core.h.y) r1
            L_0x002c:
                if (r1 == 0) goto L_0x0031
                r1.onAnimationStart(r4)
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.x.a.onAnimationStart(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.h.y} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onAnimationEnd(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.h.x r0 = r3.f3149a
                int r0 = r0.f3142d
                r1 = 0
                if (r0 < 0) goto L_0x0013
                androidx.core.h.x r0 = r3.f3149a
                int r0 = r0.f3142d
                r4.setLayerType(r0, r1)
                androidx.core.h.x r0 = r3.f3149a
                r2 = -1
                r0.f3142d = r2
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 16
                if (r0 >= r2) goto L_0x001d
                boolean r0 = r3.f3150b
                if (r0 != 0) goto L_0x0043
            L_0x001d:
                androidx.core.h.x r0 = r3.f3149a
                java.lang.Runnable r0 = r0.f3141c
                if (r0 == 0) goto L_0x002e
                androidx.core.h.x r0 = r3.f3149a
                java.lang.Runnable r0 = r0.f3141c
                androidx.core.h.x r2 = r3.f3149a
                r2.f3141c = r1
                r0.run()
            L_0x002e:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.h.y
                if (r2 == 0) goto L_0x003b
                r1 = r0
                androidx.core.h.y r1 = (androidx.core.h.y) r1
            L_0x003b:
                if (r1 == 0) goto L_0x0040
                r1.onAnimationEnd(r4)
            L_0x0040:
                r4 = 1
                r3.f3150b = r4
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.x.a.onAnimationEnd(android.view.View):void");
        }

        public final void onAnimationCancel(View view) {
            Object tag = view.getTag(2113929216);
            y yVar = tag instanceof y ? (y) tag : null;
            if (yVar != null) {
                yVar.onAnimationCancel(view);
            }
        }
    }

    public final x a(long j) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public final x a(float f2) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public final x b(float f2) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().translationX(f2);
        }
        return this;
    }

    public final x c(float f2) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public final long a() {
        View view = (View) this.f3139a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public final x a(Interpolator interpolator) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public final x b(long j) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public final void b() {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c() {
        View view = (View) this.f3139a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public final x a(y yVar) {
        View view = (View) this.f3139a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, yVar);
            } else {
                view.setTag(2113929216, yVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    public final void a(final View view, final y yVar) {
        if (yVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    yVar.onAnimationCancel(view);
                }

                public final void onAnimationEnd(Animator animator) {
                    yVar.onAnimationEnd(view);
                }

                public final void onAnimationStart(Animator animator) {
                    yVar.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public final x a(final aa aaVar) {
        final View view = (View) this.f3139a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (aaVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        aaVar.a();
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }
}
