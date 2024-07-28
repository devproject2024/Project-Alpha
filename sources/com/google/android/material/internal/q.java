package com.google.android.material.internal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.h.ab;
import androidx.core.h.u;
import com.google.android.material.internal.n;

public final class q {

    public interface a {
        ab a(View view, ab abVar, b bVar);
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static boolean a(View view) {
        return u.j(view) == 1;
    }

    public static float a(Context context, int i2) {
        return TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static void b(final View view) {
        view.requestFocus();
        view.post(new Runnable() {
            public final void run() {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 1);
            }
        });
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f36506a;

        /* renamed from: b  reason: collision with root package name */
        public int f36507b;

        /* renamed from: c  reason: collision with root package name */
        public int f36508c;

        /* renamed from: d  reason: collision with root package name */
        public int f36509d;

        public b(int i2, int i3, int i4, int i5) {
            this.f36506a = i2;
            this.f36507b = i3;
            this.f36508c = i4;
            this.f36509d = i5;
        }

        public b(b bVar) {
            this.f36506a = bVar.f36506a;
            this.f36507b = bVar.f36507b;
            this.f36508c = bVar.f36508c;
            this.f36509d = bVar.f36509d;
        }

        public final void a(View view) {
            u.b(view, this.f36506a, this.f36507b, this.f36508c, this.f36509d);
        }
    }

    public static void a(View view, final a aVar) {
        final b bVar = new b(u.m(view), view.getPaddingTop(), u.n(view), view.getPaddingBottom());
        u.a(view, (androidx.core.h.q) new androidx.core.h.q() {
            public final ab a(View view, ab abVar) {
                return aVar.a(view, abVar, new b(bVar));
            }
        });
        f(view);
    }

    private static void f(View view) {
        if (u.M(view)) {
            u.z(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public final void onViewDetachedFromWindow(View view) {
                }

                public final void onViewAttachedToWindow(View view) {
                    view.removeOnAttachStateChangeListener(this);
                    u.z(view);
                }
            });
        }
    }

    public static float c(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += u.v((View) parent);
        }
        return f2;
    }

    public static ViewGroup d(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static p e(View view) {
        ViewGroup d2 = d(view);
        if (d2 == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new o(d2);
        }
        ViewGroup d3 = d(d2);
        if (d3 == null) {
            return null;
        }
        int childCount = d3.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = d3.getChildAt(i2);
            if (childAt instanceof n.a) {
                return ((n.a) childAt).f36496e;
            }
        }
        return new l(d3.getContext(), d3, d2);
    }
}
