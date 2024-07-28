package net.one97.paytm.paymentsBank.si.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.d.k;
import androidx.core.d.l;
import androidx.core.h.i;
import androidx.core.h.u;
import androidx.customview.a.c;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import java.lang.ref.WeakReference;

public class DynamicHeightBehaviour<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    int f18923a;

    /* renamed from: b  reason: collision with root package name */
    int f18924b;

    /* renamed from: c  reason: collision with root package name */
    boolean f18925c;

    /* renamed from: d  reason: collision with root package name */
    int f18926d = 4;

    /* renamed from: e  reason: collision with root package name */
    c f18927e;

    /* renamed from: f  reason: collision with root package name */
    int f18928f;

    /* renamed from: g  reason: collision with root package name */
    WeakReference<V> f18929g;

    /* renamed from: h  reason: collision with root package name */
    WeakReference<View> f18930h;

    /* renamed from: i  reason: collision with root package name */
    int f18931i;
    boolean j;
    private boolean k = true;
    private float l;
    private int m;
    private boolean n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private VelocityTracker t;
    private int u;
    private final c.a v = new c.a() {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
            r6 = (android.view.View) r4.f18932a.f18930h.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(android.view.View r5, int r6) {
            /*
                r4 = this;
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r0 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                int r0 = r0.f18926d
                r1 = 1
                r2 = 0
                if (r0 != r1) goto L_0x0009
                return r2
            L_0x0009:
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r0 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                boolean r0 = r0.j
                if (r0 == 0) goto L_0x0010
                return r2
            L_0x0010:
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r0 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                int r0 = r0.f18926d
                r3 = 3
                if (r0 != r3) goto L_0x0031
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r0 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                int r0 = r0.f18931i
                if (r0 != r6) goto L_0x0031
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r6 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                java.lang.ref.WeakReference<android.view.View> r6 = r6.f18930h
                java.lang.Object r6 = r6.get()
                android.view.View r6 = (android.view.View) r6
                if (r6 == 0) goto L_0x0031
                r0 = -1
                boolean r6 = androidx.core.h.u.b((android.view.View) r6, (int) r0)
                if (r6 == 0) goto L_0x0031
                return r2
            L_0x0031:
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r6 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                java.lang.ref.WeakReference<V> r6 = r6.f18929g
                if (r6 == 0) goto L_0x0042
                net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour r6 = net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.this
                java.lang.ref.WeakReference<V> r6 = r6.f18929g
                java.lang.Object r6 = r6.get()
                if (r6 != r5) goto L_0x0042
                return r1
            L_0x0042:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.AnonymousClass1.b(android.view.View, int):boolean");
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            DynamicHeightBehaviour.this.a();
        }

        public final void a(int i2) {
            if (i2 == 1) {
                DynamicHeightBehaviour.this.a(1);
            }
        }

        public final void a(View view, float f2, float f3) {
            int i2;
            int i3;
            int i4 = 3;
            if (f3 < 0.0f) {
                i2 = DynamicHeightBehaviour.this.f18923a;
            } else if (!DynamicHeightBehaviour.this.f18925c || !DynamicHeightBehaviour.this.a(view, f3)) {
                if (f3 == 0.0f) {
                    int top = view.getTop();
                    if (Math.abs(top - DynamicHeightBehaviour.this.f18923a) < Math.abs(top - DynamicHeightBehaviour.this.f18924b)) {
                        i2 = DynamicHeightBehaviour.this.f18923a;
                    } else {
                        i3 = DynamicHeightBehaviour.this.f18924b;
                    }
                } else {
                    i3 = DynamicHeightBehaviour.this.f18924b;
                }
                i2 = i3;
                i4 = 4;
            } else {
                i2 = DynamicHeightBehaviour.this.f18928f;
                i4 = 5;
            }
            if (DynamicHeightBehaviour.this.f18927e.a(view.getLeft(), i2)) {
                DynamicHeightBehaviour.this.a(2);
                u.a(view, (Runnable) new b(view, i4));
                return;
            }
            DynamicHeightBehaviour.this.a(i4);
        }

        public final int d(View view, int i2) {
            new a();
            int i3 = DynamicHeightBehaviour.this.f18923a;
            int i4 = DynamicHeightBehaviour.this.f18925c ? DynamicHeightBehaviour.this.f18928f : DynamicHeightBehaviour.this.f18924b;
            if (i2 < i3) {
                return i3;
            }
            return i2 > i4 ? i4 : i2;
        }

        public final int c(View view, int i2) {
            return view.getLeft();
        }

        public final int b() {
            int i2;
            int i3;
            if (DynamicHeightBehaviour.this.f18925c) {
                i2 = DynamicHeightBehaviour.this.f18928f;
                i3 = DynamicHeightBehaviour.this.f18923a;
            } else {
                i2 = DynamicHeightBehaviour.this.f18924b;
                i3 = DynamicHeightBehaviour.this.f18923a;
            }
            return i2 - i3;
        }
    };

    public DynamicHeightBehaviour() {
    }

    public DynamicHeightBehaviour(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            b(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            b(peekValue.data);
        }
        this.f18925c = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false);
        this.p = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        obtainStyledAttributes.recycle();
        this.l = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v2), this.f18926d);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v2, savedState.f3245d);
        if (savedState.f18933a == 1 || savedState.f18933a == 2) {
            this.f18926d = 4;
        } else {
            this.f18926d = savedState.f18933a;
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        int i3;
        if (u.A(coordinatorLayout) && !u.A(v2)) {
            u.b((View) v2, true);
        }
        int top = v2.getTop();
        coordinatorLayout.b(v2, i2);
        this.f18928f = coordinatorLayout.getHeight();
        if (this.n) {
            if (this.o == 0) {
                this.o = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            i3 = Math.max(this.o, this.f18928f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i3 = this.m;
        }
        this.f18923a = Math.max(0, this.f18928f - v2.getHeight());
        this.f18924b = Math.max(this.f18928f - i3, this.f18923a);
        int i4 = this.f18926d;
        if (i4 == 3) {
            u.f((View) v2, this.f18923a);
        } else if (!this.f18925c || i4 != 5) {
            int i5 = this.f18926d;
            if (i5 == 4) {
                u.f((View) v2, this.f18924b);
            } else if (i5 == 1 || i5 == 2) {
                u.f((View) v2, top - v2.getTop());
            }
        } else {
            u.f((View) v2, this.f18928f);
        }
        if (this.f18927e == null) {
            this.f18927e = c.a((ViewGroup) coordinatorLayout, this.v);
        }
        this.f18929g = new WeakReference<>(v2);
        if (this.f18930h == null) {
            this.f18930h = new WeakReference<>(a((View) v2));
        }
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!this.k && motionEvent.getAction() == 2) {
            return false;
        }
        if (!v2.isShown()) {
            this.q = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            b();
        }
        if (this.t == null) {
            this.t = VelocityTracker.obtain();
        }
        this.t.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.u = (int) motionEvent.getY();
            View view = (View) this.f18930h.get();
            if (view != null && coordinatorLayout.a(view, x, this.u)) {
                this.f18931i = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.j = true;
            }
            this.q = this.f18931i == -1 && !coordinatorLayout.a((View) v2, x, this.u);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.j = false;
            this.f18931i = -1;
            if (this.q) {
                this.q = false;
                return false;
            }
        }
        if (!this.q && this.f18927e.a(motionEvent)) {
            return true;
        }
        View view2 = (View) this.f18930h.get();
        if (actionMasked != 2 || view2 == null || this.q || this.f18926d == 1 || coordinatorLayout.a(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.u) - motionEvent.getY()) <= ((float) this.f18927e.f3235b)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (this.f18927e == null) {
            this.f18927e = c.a((ViewGroup) coordinatorLayout, this.v);
        }
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f18926d == 1 && actionMasked == 0) {
            return true;
        }
        this.f18927e.b(motionEvent);
        if (actionMasked == 0) {
            b();
        }
        if (this.t == null) {
            this.t = VelocityTracker.obtain();
        }
        this.t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.q && Math.abs(((float) this.u) - motionEvent.getY()) > ((float) this.f18927e.f3235b)) {
            this.f18927e.a((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (!this.q) {
            return true;
        }
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
        this.r = 0;
        this.s = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr) {
        if (view == ((View) this.f18930h.get())) {
            int top = v2.getTop();
            int i4 = top - i3;
            if (i3 > 0) {
                int i5 = this.f18923a;
                if (i4 < i5) {
                    iArr[1] = top - i5;
                    u.f((View) v2, -iArr[1]);
                    a(3);
                } else {
                    iArr[1] = i3;
                    u.f((View) v2, -i3);
                    a(1);
                }
            } else if (i3 < 0 && !u.b(view, -1)) {
                int i6 = this.f18924b;
                if (i4 <= i6 || this.f18925c) {
                    iArr[1] = i3;
                    u.f((View) v2, -i3);
                    a(1);
                } else {
                    iArr[1] = top - i6;
                    u.f((View) v2, -iArr[1]);
                    a(4);
                }
            }
            v2.getTop();
            a();
            this.r = i3;
            this.s = true;
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view) {
        int i2;
        int i3 = 3;
        if (v2.getTop() == this.f18923a) {
            a(3);
        } else if (view == this.f18930h.get() && this.s) {
            if (this.r > 0) {
                i2 = this.f18923a;
            } else {
                if (this.f18925c) {
                    this.t.computeCurrentVelocity(1000, this.l);
                    if (a(v2, this.t.getYVelocity(this.f18931i))) {
                        i2 = this.f18928f;
                        i3 = 5;
                    }
                }
                if (this.r == 0) {
                    int top = v2.getTop();
                    if (Math.abs(top - this.f18923a) < Math.abs(top - this.f18924b)) {
                        i2 = this.f18923a;
                    } else {
                        i2 = this.f18924b;
                    }
                } else {
                    i2 = this.f18924b;
                }
                i3 = 4;
            }
            if (this.f18927e.a((View) v2, v2.getLeft(), i2)) {
                a(2);
                u.a((View) v2, (Runnable) new b(v2, i3));
            } else {
                a(i3);
            }
            this.s = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        if (view == this.f18930h.get()) {
            return this.f18926d != 3 || super.onNestedPreFling(coordinatorLayout, v2, view, f2, f3);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.n
            if (r4 != 0) goto L_0x0015
            r3.n = r0
            goto L_0x0024
        L_0x000c:
            boolean r2 = r3.n
            if (r2 != 0) goto L_0x0017
            int r2 = r3.m
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0024
        L_0x0017:
            r3.n = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.m = r1
            int r1 = r3.f18928f
            int r1 = r1 - r4
            r3.f18924b = r1
        L_0x0024:
            if (r0 == 0) goto L_0x003a
            int r4 = r3.f18926d
            r0 = 4
            if (r4 != r0) goto L_0x003a
            java.lang.ref.WeakReference<V> r4 = r3.f18929g
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x003a
            r4.requestLayout()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.si.view.DynamicHeightBehaviour.b(int):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        if (this.f18926d != i2) {
            this.f18926d = i2;
            this.f18929g.get();
        }
    }

    private void b() {
        this.f18931i = -1;
        VelocityTracker velocityTracker = this.t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.t = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(View view, float f2) {
        if (this.p) {
            return true;
        }
        if (view.getTop() >= this.f18924b && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f18924b)) / ((float) this.m) > 0.5f) {
            return true;
        }
        return false;
    }

    private View a(View view) {
        if (view instanceof i) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View a2 = a(viewGroup.getChildAt(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f18929g.get();
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f18936b;

        /* renamed from: c  reason: collision with root package name */
        private final int f18937c;

        b(View view, int i2) {
            this.f18936b = view;
            this.f18937c = i2;
        }

        public final void run() {
            if (DynamicHeightBehaviour.this.f18927e == null || !DynamicHeightBehaviour.this.f18927e.f()) {
                DynamicHeightBehaviour.this.a(this.f18937c);
            } else {
                u.a(this.f18936b, (Runnable) this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = k.a(new l<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] a(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object a(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final int f18933a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f18933a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f18933a = i2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f18933a);
        }
    }

    class a {
        a() {
        }
    }
}
