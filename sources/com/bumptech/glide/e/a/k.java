package com.bumptech.glide.e.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.e.d;
import com.bumptech.glide.g.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class k<T extends View, Z> extends a<Z> {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6521b;

    /* renamed from: c  reason: collision with root package name */
    private static int f6522c = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    protected final T f6523a;

    /* renamed from: d  reason: collision with root package name */
    private final a f6524d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnAttachStateChangeListener f6525e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6526f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6527g;

    public k(T t) {
        this.f6523a = (View) j.a(t, "Argument must not be null");
        this.f6524d = new a(t);
    }

    public void b(Drawable drawable) {
        super.b(drawable);
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6525e;
        if (onAttachStateChangeListener != null && !this.f6527g) {
            this.f6523a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6527g = true;
        }
    }

    public final T f() {
        return this.f6523a;
    }

    public final void a(i iVar) {
        a aVar = this.f6524d;
        int d2 = aVar.d();
        int c2 = aVar.c();
        if (a.a(d2, c2)) {
            iVar.a(d2, c2);
            return;
        }
        if (!aVar.f6530c.contains(iVar)) {
            aVar.f6530c.add(iVar);
        }
        if (aVar.f6532e == null) {
            ViewTreeObserver viewTreeObserver = aVar.f6529b.getViewTreeObserver();
            aVar.f6532e = new a.C0088a(aVar);
            viewTreeObserver.addOnPreDrawListener(aVar.f6532e);
        }
    }

    public final void b(i iVar) {
        this.f6524d.f6530c.remove(iVar);
    }

    public void a(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.a(drawable);
        this.f6524d.b();
        if (!this.f6526f && (onAttachStateChangeListener = this.f6525e) != null && this.f6527g) {
            this.f6523a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6527g = false;
        }
    }

    public String toString() {
        return "Target for: " + this.f6523a;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static Integer f6528a;

        /* renamed from: b  reason: collision with root package name */
        final View f6529b;

        /* renamed from: c  reason: collision with root package name */
        final List<i> f6530c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        boolean f6531d;

        /* renamed from: e  reason: collision with root package name */
        C0088a f6532e;

        private static boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        a(View view) {
            this.f6529b = view;
        }

        private static int a(Context context) {
            if (f6528a == null) {
                Display defaultDisplay = ((WindowManager) j.a((WindowManager) context.getSystemService("window"), "Argument must not be null")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6528a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6528a.intValue();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (!this.f6530c.isEmpty()) {
                int d2 = d();
                int c2 = c();
                if (a(d2, c2)) {
                    Iterator it2 = new ArrayList(this.f6530c).iterator();
                    while (it2.hasNext()) {
                        ((i) it2.next()).a(d2, c2);
                    }
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            ViewTreeObserver viewTreeObserver = this.f6529b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f6532e);
            }
            this.f6532e = null;
            this.f6530c.clear();
        }

        static boolean a(int i2, int i3) {
            return a(i2) && a(i3);
        }

        /* access modifiers changed from: package-private */
        public final int c() {
            int paddingTop = this.f6529b.getPaddingTop() + this.f6529b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f6529b.getLayoutParams();
            return a(this.f6529b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        /* access modifiers changed from: package-private */
        public final int d() {
            int paddingLeft = this.f6529b.getPaddingLeft() + this.f6529b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f6529b.getLayoutParams();
            return a(this.f6529b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f6531d && this.f6529b.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f6529b.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            Log.isLoggable("ViewTarget", 4);
            return a(this.f6529b.getContext());
        }

        /* renamed from: com.bumptech.glide.e.a.k$a$a  reason: collision with other inner class name */
        static final class C0088a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f6533a;

            C0088a(a aVar) {
                this.f6533a = new WeakReference<>(aVar);
            }

            public final boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    new StringBuilder("OnGlobalLayoutListener called attachStateListener=").append(this);
                }
                a aVar = (a) this.f6533a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }
    }

    public final void a(d dVar) {
        f6521b = true;
        this.f6523a.setTag(f6522c, dVar);
    }

    public final d d() {
        Object tag = this.f6523a.getTag(f6522c);
        if (tag == null) {
            return null;
        }
        if (tag instanceof d) {
            return (d) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
}
