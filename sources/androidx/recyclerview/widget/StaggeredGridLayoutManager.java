package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.h.a.c;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.r.b {

    /* renamed from: a  reason: collision with root package name */
    public int f4106a;

    /* renamed from: b  reason: collision with root package name */
    public b[] f4107b;

    /* renamed from: c  reason: collision with root package name */
    u f4108c;

    /* renamed from: d  reason: collision with root package name */
    u f4109d;

    /* renamed from: e  reason: collision with root package name */
    public int f4110e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4111f;

    /* renamed from: g  reason: collision with root package name */
    boolean f4112g;

    /* renamed from: h  reason: collision with root package name */
    int f4113h;

    /* renamed from: i  reason: collision with root package name */
    int f4114i;
    LazySpanLookup j;
    private int k;
    private final o l;
    private BitSet m;
    private int n;
    private boolean o;
    private boolean p;
    private SavedState q;
    private int r;
    private final Rect s;
    private final a t;
    private boolean u;
    private boolean v;
    private int[] w;
    private final Runnable x;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f4106a = -1;
        this.f4111f = false;
        this.f4112g = false;
        this.f4113h = -1;
        this.f4114i = Integer.MIN_VALUE;
        this.j = new LazySpanLookup();
        this.n = 2;
        this.s = new Rect();
        this.t = new a();
        this.u = false;
        this.v = true;
        this.x = new Runnable() {
            public final void run() {
                StaggeredGridLayoutManager.this.a();
            }
        };
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i2, i3);
        int i4 = properties.f4050a;
        if (i4 == 0 || i4 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i4 != this.f4110e) {
                this.f4110e = i4;
                u uVar = this.f4108c;
                this.f4108c = this.f4109d;
                this.f4109d = uVar;
                requestLayout();
            }
            a(properties.f4051b);
            a(properties.f4052c);
            this.l = new o();
            c();
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public StaggeredGridLayoutManager() {
        this.f4106a = -1;
        this.f4111f = false;
        this.f4112g = false;
        this.f4113h = -1;
        this.f4114i = Integer.MIN_VALUE;
        this.j = new LazySpanLookup();
        this.n = 2;
        this.s = new Rect();
        this.t = new a();
        this.u = false;
        this.v = true;
        this.x = new Runnable() {
            public final void run() {
                StaggeredGridLayoutManager.this.a();
            }
        };
        this.f4110e = 1;
        a(3);
        this.l = new o();
        c();
    }

    public boolean isAutoMeasureEnabled() {
        return this.n != 0;
    }

    private void c() {
        this.f4108c = u.a(this, this.f4110e);
        this.f4109d = u.a(this, 1 - this.f4110e);
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        int i2;
        int i3;
        if (getChildCount() == 0 || this.n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f4112g) {
            i3 = i();
            i2 = j();
        } else {
            i3 = j();
            i2 = i();
        }
        if (i3 == 0 && d() != null) {
            this.j.a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.u) {
            return false;
        } else {
            int i4 = this.f4112g ? -1 : 1;
            int i5 = i2 + 1;
            LazySpanLookup.FullSpanItem a2 = this.j.a(i3, i5, i4);
            if (a2 == null) {
                this.u = false;
                this.j.a(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem a3 = this.j.a(i3, a2.f4120a, i4 * -1);
            if (a3 == null) {
                this.j.a(a2.f4120a);
            } else {
                this.j.a(a3.f4120a + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            a();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.onDetachedFromWindow(recyclerView, nVar);
        removeCallbacks(this.x);
        for (int i2 = 0; i2 < this.f4106a; i2++) {
            this.f4107b[i2].c();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r10 == r11) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        if (r10 == r11) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View d() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f4106a
            r2.<init>(r3)
            int r3 = r12.f4106a
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f4110e
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.f()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f4112g
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00aa
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4116a
            int r9 = r9.f4144e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4116a
            boolean r9 = r12.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4116a
            int r9 = r9.f4144e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f4117b
            if (r9 != 0) goto L_0x00a8
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a8
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f4112g
            if (r10 == 0) goto L_0x0076
            androidx.recyclerview.widget.u r10 = r12.f4108c
            int r10 = r10.b((android.view.View) r7)
            androidx.recyclerview.widget.u r11 = r12.f4108c
            int r11 = r11.b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0073
            return r7
        L_0x0073:
            if (r10 != r11) goto L_0x0089
            goto L_0x0087
        L_0x0076:
            androidx.recyclerview.widget.u r10 = r12.f4108c
            int r10 = r10.a((android.view.View) r7)
            androidx.recyclerview.widget.u r11 = r12.f4108c
            int r11 = r11.a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0085
            return r7
        L_0x0085:
            if (r10 != r11) goto L_0x0089
        L_0x0087:
            r10 = 1
            goto L_0x008a
        L_0x0089:
            r10 = 0
        L_0x008a:
            if (r10 == 0) goto L_0x00a8
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.f4116a
            int r8 = r8.f4144e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r9.f4116a
            int r9 = r9.f4144e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x009f
            r8 = 1
            goto L_0x00a0
        L_0x009f:
            r8 = 0
        L_0x00a0:
            if (r3 >= 0) goto L_0x00a4
            r9 = 1
            goto L_0x00a5
        L_0x00a4:
            r9 = 0
        L_0x00a5:
            if (r8 == r9) goto L_0x00a8
            return r7
        L_0x00a8:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00aa:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.d():android.view.View");
    }

    private boolean a(b bVar) {
        return this.f4112g ? bVar.b() < this.f4108c.c() && !((LayoutParams) bVar.f4140a.get(bVar.f4140a.size() - 1).getLayoutParams()).f4117b : bVar.a() > this.f4108c.b() && !((LayoutParams) bVar.f4140a.get(0).getLayoutParams()).f4117b;
    }

    private void a(int i2) {
        assertNotInLayoutOrScroll((String) null);
        if (i2 != this.f4106a) {
            this.j.a();
            requestLayout();
            this.f4106a = i2;
            this.m = new BitSet(this.f4106a);
            this.f4107b = new b[this.f4106a];
            for (int i3 = 0; i3 < this.f4106a; i3++) {
                this.f4107b[i3] = new b(i3);
            }
            requestLayout();
        }
    }

    private void a(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.q;
        if (!(savedState == null || savedState.f4131h == z)) {
            this.q.f4131h = z;
        }
        this.f4111f = z;
        requestLayout();
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void e() {
        boolean z = true;
        if (this.f4110e == 1 || !f()) {
            z = this.f4111f;
        } else if (this.f4111f) {
            z = false;
        }
        this.f4112g = z;
    }

    private boolean f() {
        return getLayoutDirection() == 1;
    }

    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f4110e == 1) {
            i5 = chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            i4 = chooseSize(i2, (this.k * this.f4106a) + paddingLeft, getMinimumWidth());
        } else {
            i4 = chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            i5 = chooseSize(i3, (this.k * this.f4106a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i4, i5);
    }

    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.f4113h = -1;
        this.f4114i = Integer.MIN_VALUE;
        this.q = null;
        this.t.a();
    }

    private void b(int i2) {
        this.k = i2 / this.f4106a;
        this.r = View.MeasureSpec.makeMeasureSpec(i2, this.f4109d.g());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.q == null;
    }

    public final int[] b() {
        int i2;
        int[] iArr = new int[this.f4106a];
        for (int i3 = 0; i3 < this.f4106a; i3++) {
            b bVar = this.f4107b[i3];
            if (StaggeredGridLayoutManager.this.f4111f) {
                i2 = bVar.a(0, bVar.f4140a.size(), false);
            } else {
                i2 = bVar.a(bVar.f4140a.size() - 1, -1, false);
            }
            iArr[i3] = i2;
        }
        return iArr;
    }

    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        return a(sVar);
    }

    private int a(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return x.a(sVar, this.f4108c, b(!this.v), c(!this.v), this, this.v, this.f4112g);
    }

    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        return a(sVar);
    }

    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        return b(sVar);
    }

    private int b(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return x.a(sVar, this.f4108c, b(!this.v), c(!this.v), this, this.v);
    }

    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        return b(sVar);
    }

    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        return c(sVar);
    }

    private int c(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return x.b(sVar, this.f4108c, b(!this.v), c(!this.v), this, this.v);
    }

    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        return c(sVar);
    }

    private void a(View view, LayoutParams layoutParams) {
        if (layoutParams.f4117b) {
            if (this.f4110e == 1) {
                a(view, this.r, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.r);
            }
        } else if (this.f4110e == 1) {
            a(view, getChildMeasureSpec(this.k, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), getChildMeasureSpec(this.k, getHeightMode(), 0, layoutParams.height, false));
        }
    }

    private void a(View view, int i2, int i3) {
        calculateItemDecorationsForChild(view, this.s);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int a2 = a(i2, layoutParams.leftMargin + this.s.left, layoutParams.rightMargin + this.s.right);
        int a3 = a(i3, layoutParams.topMargin + this.s.top, layoutParams.bottomMargin + this.s.bottom);
        if (shouldMeasureChild(view, a2, a3, layoutParams)) {
            view.measure(a2, a3);
        }
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.q = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i2;
        View view;
        int i3;
        int i4;
        SavedState savedState = this.q;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.f4131h = this.f4111f;
        savedState2.f4132i = this.o;
        savedState2.j = this.p;
        LazySpanLookup lazySpanLookup = this.j;
        if (lazySpanLookup == null || lazySpanLookup.f4118a == null) {
            savedState2.f4128e = 0;
        } else {
            savedState2.f4129f = this.j.f4118a;
            savedState2.f4128e = savedState2.f4129f.length;
            savedState2.f4130g = this.j.f4119b;
        }
        int i5 = -1;
        if (getChildCount() > 0) {
            if (this.o) {
                i2 = i();
            } else {
                i2 = j();
            }
            savedState2.f4124a = i2;
            if (this.f4112g) {
                view = c(true);
            } else {
                view = b(true);
            }
            if (view != null) {
                i5 = getPosition(view);
            }
            savedState2.f4125b = i5;
            int i6 = this.f4106a;
            savedState2.f4126c = i6;
            savedState2.f4127d = new int[i6];
            for (int i7 = 0; i7 < this.f4106a; i7++) {
                if (this.o) {
                    i3 = this.f4107b[i7].b(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f4108c.c();
                    } else {
                        savedState2.f4127d[i7] = i3;
                    }
                } else {
                    i3 = this.f4107b[i7].a(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.f4108c.b();
                    } else {
                        savedState2.f4127d[i7] = i3;
                    }
                }
                i3 -= i4;
                savedState2.f4127d[i7] = i3;
            }
        } else {
            savedState2.f4124a = -1;
            savedState2.f4125b = -1;
            savedState2.f4126c = 0;
        }
        return savedState2;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n nVar, RecyclerView.s sVar, View view, c cVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i6 = 1;
        if (this.f4110e == 0) {
            int b2 = layoutParams2.b();
            if (layoutParams2.f4117b) {
                i6 = this.f4106a;
            }
            i5 = b2;
            i4 = i6;
            i3 = -1;
            i2 = -1;
        } else {
            int b3 = layoutParams2.b();
            if (layoutParams2.f4117b) {
                i3 = b3;
                i2 = this.f4106a;
                i5 = -1;
                i4 = -1;
            } else {
                i3 = b3;
                i5 = -1;
                i4 = -1;
                i2 = 1;
            }
        }
        cVar.b((Object) c.C0046c.a(i5, i4, i3, i2, false, false));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View b2 = b(false);
            View c2 = c(false);
            if (b2 != null && c2 != null) {
                int position = getPosition(b2);
                int position2 = getPosition(c2);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public int getRowCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.f4110e == 0) {
            return this.f4106a;
        }
        return super.getRowCountForAccessibility(nVar, sVar);
    }

    public int getColumnCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.f4110e == 1) {
            return this.f4106a;
        }
        return super.getColumnCountForAccessibility(nVar, sVar);
    }

    private View b(boolean z) {
        int b2 = this.f4108c.b();
        int c2 = this.f4108c.c();
        int childCount = getChildCount();
        View view = null;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int a2 = this.f4108c.a(childAt);
            if (this.f4108c.b(childAt) > b2 && a2 < c2) {
                if (a2 >= b2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View c(boolean z) {
        int b2 = this.f4108c.b();
        int c2 = this.f4108c.c();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int a2 = this.f4108c.a(childAt);
            int b3 = this.f4108c.b(childAt);
            if (b3 > b2 && a2 < c2) {
                if (b3 <= c2 || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void a(RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int c2;
        int h2 = h(Integer.MIN_VALUE);
        if (h2 != Integer.MIN_VALUE && (c2 = this.f4108c.c() - h2) > 0) {
            int i2 = c2 - (-a(-c2, nVar, sVar));
            if (z && i2 > 0) {
                this.f4108c.a(i2);
            }
        }
    }

    private void b(RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int b2;
        int g2 = g(Integer.MAX_VALUE);
        if (g2 != Integer.MAX_VALUE && (b2 = g2 - this.f4108c.b()) > 0) {
            int a2 = b2 - a(b2, nVar, sVar);
            if (z && a2 > 0) {
                this.f4108c.a(-a2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r5, androidx.recyclerview.widget.RecyclerView.s r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.o r0 = r4.l
            r1 = 0
            r0.f4340b = r1
            r0.f4341c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L_0x002c
            int r6 = r6.f4090a
            r0 = -1
            if (r6 == r0) goto L_0x002c
            boolean r0 = r4.f4112g
            if (r6 >= r5) goto L_0x0019
            r5 = 1
            goto L_0x001a
        L_0x0019:
            r5 = 0
        L_0x001a:
            if (r0 != r5) goto L_0x0023
            androidx.recyclerview.widget.u r5 = r4.f4108c
            int r5 = r5.e()
            goto L_0x002d
        L_0x0023:
            androidx.recyclerview.widget.u r5 = r4.f4108c
            int r5 = r5.e()
            r6 = r5
            r5 = 0
            goto L_0x002e
        L_0x002c:
            r5 = 0
        L_0x002d:
            r6 = 0
        L_0x002e:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L_0x004b
            androidx.recyclerview.widget.o r0 = r4.l
            androidx.recyclerview.widget.u r3 = r4.f4108c
            int r3 = r3.b()
            int r3 = r3 - r6
            r0.f4344f = r3
            androidx.recyclerview.widget.o r6 = r4.l
            androidx.recyclerview.widget.u r0 = r4.f4108c
            int r0 = r0.c()
            int r0 = r0 + r5
            r6.f4345g = r0
            goto L_0x005b
        L_0x004b:
            androidx.recyclerview.widget.o r0 = r4.l
            androidx.recyclerview.widget.u r3 = r4.f4108c
            int r3 = r3.d()
            int r3 = r3 + r5
            r0.f4345g = r3
            androidx.recyclerview.widget.o r5 = r4.l
            int r6 = -r6
            r5.f4344f = r6
        L_0x005b:
            androidx.recyclerview.widget.o r5 = r4.l
            r5.f4346h = r1
            r5.f4339a = r2
            androidx.recyclerview.widget.u r6 = r4.f4108c
            int r6 = r6.g()
            if (r6 != 0) goto L_0x0072
            androidx.recyclerview.widget.u r6 = r4.f4108c
            int r6 = r6.d()
            if (r6 != 0) goto L_0x0072
            r1 = 1
        L_0x0072:
            r5.f4347i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int, androidx.recyclerview.widget.RecyclerView$s):void");
    }

    private void c(int i2) {
        o oVar = this.l;
        oVar.f4343e = i2;
        int i3 = 1;
        if (this.f4112g != (i2 == -1)) {
            i3 = -1;
        }
        oVar.f4342d = i3;
    }

    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.f4106a; i3++) {
            this.f4107b[i3].d(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.f4106a; i3++) {
            this.f4107b[i3].d(i2);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        b(i2, i3, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        b(i2, i3, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.j.a();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        b(i2, i3, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        b(i2, i3, 4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4112g
            if (r0 == 0) goto L_0x0009
            int r0 = r6.i()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.j()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L_0x001f
        L_0x001b:
            int r2 = r7 + r8
        L_0x001d:
            r3 = r2
            r2 = r7
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.j
            r4.b(r2)
            r4 = 1
            if (r9 == r4) goto L_0x003e
            r5 = 2
            if (r9 == r5) goto L_0x0038
            if (r9 == r1) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.j
            r9.a((int) r7, (int) r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.j
            r7.b(r8, r4)
            goto L_0x0043
        L_0x0038:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.j
            r9.a((int) r7, (int) r8)
            goto L_0x0043
        L_0x003e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.j
            r9.b(r7, r8)
        L_0x0043:
            if (r3 > r0) goto L_0x0046
            return
        L_0x0046:
            boolean r7 = r6.f4112g
            if (r7 == 0) goto L_0x004f
            int r7 = r6.j()
            goto L_0x0053
        L_0x004f:
            int r7 = r6.i()
        L_0x0053:
            if (r2 > r7) goto L_0x0058
            r6.requestLayout()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, int, int):void");
    }

    private int a(RecyclerView.n nVar, o oVar, RecyclerView.s sVar) {
        int i2;
        int i3;
        int i4;
        b bVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        int i12;
        int i13;
        RecyclerView.n nVar2 = nVar;
        o oVar2 = oVar;
        int i14 = 0;
        this.m.set(0, this.f4106a, true);
        if (this.l.f4347i) {
            i2 = oVar2.f4343e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (oVar2.f4343e == 1) {
                i13 = oVar2.f4345g + oVar2.f4340b;
            } else {
                i13 = oVar2.f4344f - oVar2.f4340b;
            }
            i2 = i13;
        }
        a(oVar2.f4343e, i2);
        if (this.f4112g) {
            i3 = this.f4108c.c();
        } else {
            i3 = this.f4108c.b();
        }
        int i15 = i3;
        boolean z2 = false;
        while (oVar.a(sVar) && (this.l.f4347i || !this.m.isEmpty())) {
            View a2 = oVar2.a(nVar2);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int layoutPosition = layoutParams.f4054c.getLayoutPosition();
            int c2 = this.j.c(layoutPosition);
            boolean z3 = c2 == -1;
            if (z3) {
                bVar = layoutParams.f4117b ? this.f4107b[i14] : a(oVar2);
                this.j.a(layoutPosition, bVar);
            } else {
                bVar = this.f4107b[c2];
            }
            b bVar2 = bVar;
            layoutParams.f4116a = bVar2;
            if (oVar2.f4343e == 1) {
                addView(a2);
            } else {
                addView(a2, i14);
            }
            a(a2, layoutParams);
            if (oVar2.f4343e == 1) {
                if (layoutParams.f4117b) {
                    i12 = h(i15);
                } else {
                    i12 = bVar2.b(i15);
                }
                int e2 = this.f4108c.e(a2) + i12;
                if (z3 && layoutParams.f4117b) {
                    LazySpanLookup.FullSpanItem d2 = d(i12);
                    d2.f4121b = -1;
                    d2.f4120a = layoutPosition;
                    this.j.a(d2);
                }
                i5 = e2;
                i6 = i12;
            } else {
                if (layoutParams.f4117b) {
                    i11 = g(i15);
                } else {
                    i11 = bVar2.a(i15);
                }
                i6 = i11 - this.f4108c.e(a2);
                if (z3 && layoutParams.f4117b) {
                    LazySpanLookup.FullSpanItem e3 = e(i11);
                    e3.f4121b = 1;
                    e3.f4120a = layoutPosition;
                    this.j.a(e3);
                }
                i5 = i11;
            }
            if (layoutParams.f4117b && oVar2.f4342d == -1) {
                if (!z3) {
                    if (oVar2.f4343e == 1) {
                        z = g();
                    } else {
                        z = h();
                    }
                    if (!z) {
                        LazySpanLookup.FullSpanItem d3 = this.j.d(layoutPosition);
                        if (d3 != null) {
                            d3.f4123d = true;
                        }
                    }
                }
                this.u = true;
            }
            a(a2, layoutParams, oVar2);
            if (!f() || this.f4110e != 1) {
                if (layoutParams.f4117b) {
                    i9 = this.f4109d.b();
                } else {
                    i9 = (bVar2.f4144e * this.k) + this.f4109d.b();
                }
                i8 = i9;
                i7 = this.f4109d.e(a2) + i9;
            } else {
                if (layoutParams.f4117b) {
                    i10 = this.f4109d.c();
                } else {
                    i10 = this.f4109d.c() - (((this.f4106a - 1) - bVar2.f4144e) * this.k);
                }
                i7 = i10;
                i8 = i10 - this.f4109d.e(a2);
            }
            if (this.f4110e == 1) {
                layoutDecoratedWithMargins(a2, i8, i6, i7, i5);
            } else {
                layoutDecoratedWithMargins(a2, i6, i8, i5, i7);
            }
            if (layoutParams.f4117b) {
                a(this.l.f4343e, i2);
            } else {
                a(bVar2, this.l.f4343e, i2);
            }
            a(nVar2, this.l);
            if (this.l.f4346h && a2.hasFocusable()) {
                if (layoutParams.f4117b) {
                    this.m.clear();
                } else {
                    this.m.set(bVar2.f4144e, false);
                }
            }
            z2 = true;
            i14 = 0;
        }
        if (!z2) {
            a(nVar2, this.l);
        }
        if (this.l.f4343e == -1) {
            i4 = this.f4108c.b() - g(this.f4108c.b());
        } else {
            i4 = h(this.f4108c.c()) - this.f4108c.c();
        }
        if (i4 > 0) {
            return Math.min(oVar2.f4340b, i4);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem d(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4122c = new int[this.f4106a];
        for (int i3 = 0; i3 < this.f4106a; i3++) {
            fullSpanItem.f4122c[i3] = i2 - this.f4107b[i3].b(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem e(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4122c = new int[this.f4106a];
        for (int i3 = 0; i3 < this.f4106a; i3++) {
            fullSpanItem.f4122c[i3] = this.f4107b[i3].a(i2) - i2;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, o oVar) {
        if (oVar.f4343e == 1) {
            if (layoutParams.f4117b) {
                a(view);
            } else {
                layoutParams.f4116a.b(view);
            }
        } else if (layoutParams.f4117b) {
            b(view);
        } else {
            layoutParams.f4116a.a(view);
        }
    }

    private void a(RecyclerView.n nVar, o oVar) {
        int i2;
        int i3;
        if (oVar.f4339a && !oVar.f4347i) {
            if (oVar.f4340b == 0) {
                if (oVar.f4343e == -1) {
                    b(nVar, oVar.f4345g);
                } else {
                    a(nVar, oVar.f4344f);
                }
            } else if (oVar.f4343e == -1) {
                int f2 = oVar.f4344f - f(oVar.f4344f);
                if (f2 < 0) {
                    i3 = oVar.f4345g;
                } else {
                    i3 = oVar.f4345g - Math.min(f2, oVar.f4340b);
                }
                b(nVar, i3);
            } else {
                int i4 = i(oVar.f4345g) - oVar.f4345g;
                if (i4 < 0) {
                    i2 = oVar.f4344f;
                } else {
                    i2 = Math.min(i4, oVar.f4340b) + oVar.f4344f;
                }
                a(nVar, i2);
            }
        }
    }

    private void a(View view) {
        for (int i2 = this.f4106a - 1; i2 >= 0; i2--) {
            this.f4107b[i2].b(view);
        }
    }

    private void b(View view) {
        for (int i2 = this.f4106a - 1; i2 >= 0; i2--) {
            this.f4107b[i2].a(view);
        }
    }

    private void a(int i2, int i3) {
        for (int i4 = 0; i4 < this.f4106a; i4++) {
            if (!this.f4107b[i4].f4140a.isEmpty()) {
                a(this.f4107b[i4], i2, i3);
            }
        }
    }

    private int f(int i2) {
        int a2 = this.f4107b[0].a(i2);
        for (int i3 = 1; i3 < this.f4106a; i3++) {
            int a3 = this.f4107b[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int g(int i2) {
        int a2 = this.f4107b[0].a(i2);
        for (int i3 = 1; i3 < this.f4106a; i3++) {
            int a3 = this.f4107b[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private boolean g() {
        int b2 = this.f4107b[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f4106a; i2++) {
            if (this.f4107b[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    private boolean h() {
        int a2 = this.f4107b[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f4106a; i2++) {
            if (this.f4107b[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    private int h(int i2) {
        int b2 = this.f4107b[0].b(i2);
        for (int i3 = 1; i3 < this.f4106a; i3++) {
            int b3 = this.f4107b[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int i(int i2) {
        int b2 = this.f4107b[0].b(i2);
        for (int i3 = 1; i3 < this.f4106a; i3++) {
            int b3 = this.f4107b[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void a(RecyclerView.n nVar, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f4108c.b(childAt) <= i2 && this.f4108c.c(childAt) <= i2) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4117b) {
                    int i3 = 0;
                    while (i3 < this.f4106a) {
                        if (this.f4107b[i3].f4140a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f4106a; i4++) {
                        this.f4107b[i4].e();
                    }
                } else if (layoutParams.f4116a.f4140a.size() != 1) {
                    layoutParams.f4116a.e();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, nVar);
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.n nVar, int i2) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f4108c.a(childAt) >= i2 && this.f4108c.d(childAt) >= i2) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f4117b) {
                    int i3 = 0;
                    while (i3 < this.f4106a) {
                        if (this.f4107b[i3].f4140a.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.f4106a; i4++) {
                        this.f4107b[i4].d();
                    }
                } else if (layoutParams.f4116a.f4140a.size() != 1) {
                    layoutParams.f4116a.d();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, nVar);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean j(int i2) {
        if (this.f4110e == 0) {
            return (i2 == -1) != this.f4112g;
        }
        return ((i2 == -1) == this.f4112g) == f();
    }

    private b a(o oVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (j(oVar.f4343e)) {
            i3 = this.f4106a - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.f4106a;
            i2 = 1;
        }
        b bVar = null;
        if (oVar.f4343e == 1) {
            int i5 = Integer.MAX_VALUE;
            int b2 = this.f4108c.b();
            while (i3 != i4) {
                b bVar2 = this.f4107b[i3];
                int b3 = bVar2.b(b2);
                if (b3 < i5) {
                    bVar = bVar2;
                    i5 = b3;
                }
                i3 += i2;
            }
            return bVar;
        }
        int i6 = Integer.MIN_VALUE;
        int c2 = this.f4108c.c();
        while (i3 != i4) {
            b bVar3 = this.f4107b[i3];
            int a2 = bVar3.a(c2);
            if (a2 > i6) {
                bVar = bVar3;
                i6 = a2;
            }
            i3 += i2;
        }
        return bVar;
    }

    public boolean canScrollVertically() {
        return this.f4110e == 1;
    }

    public boolean canScrollHorizontally() {
        return this.f4110e == 0;
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return a(i2, nVar, sVar);
    }

    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return a(i2, nVar, sVar);
    }

    private int k(int i2) {
        if (getChildCount() == 0) {
            return this.f4112g ? 1 : -1;
        }
        return (i2 < j()) != this.f4112g ? -1 : 1;
    }

    public PointF computeScrollVectorForPosition(int i2) {
        int k2 = k(i2);
        PointF pointF = new PointF();
        if (k2 == 0) {
            return null;
        }
        if (this.f4110e == 0) {
            pointF.x = (float) k2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) k2;
        }
        return pointF;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        p pVar = new p(recyclerView.getContext());
        pVar.setTargetPosition(i2);
        startSmoothScroll(pVar);
    }

    public void scrollToPosition(int i2) {
        SavedState savedState = this.q;
        if (!(savedState == null || savedState.f4124a == i2)) {
            SavedState savedState2 = this.q;
            savedState2.f4127d = null;
            savedState2.f4126c = 0;
            savedState2.f4124a = -1;
            savedState2.f4125b = -1;
        }
        this.f4113h = i2;
        this.f4114i = Integer.MIN_VALUE;
        requestLayout();
    }

    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.s sVar, RecyclerView.LayoutManager.a aVar) {
        int i4;
        int i5;
        if (this.f4110e != 0) {
            i2 = i3;
        }
        if (getChildCount() != 0 && i2 != 0) {
            b(i2, sVar);
            int[] iArr = this.w;
            if (iArr == null || iArr.length < this.f4106a) {
                this.w = new int[this.f4106a];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.f4106a; i7++) {
                if (this.l.f4342d == -1) {
                    i5 = this.l.f4344f;
                    i4 = this.f4107b[i7].a(this.l.f4344f);
                } else {
                    i5 = this.f4107b[i7].b(this.l.f4345g);
                    i4 = this.l.f4345g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.w[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.w, 0, i6);
            for (int i9 = 0; i9 < i6 && this.l.a(sVar); i9++) {
                aVar.a(this.l.f4341c, this.w[i9]);
                this.l.f4341c += this.l.f4342d;
            }
        }
    }

    private void b(int i2, RecyclerView.s sVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = i();
            i3 = 1;
        } else {
            i4 = j();
            i3 = -1;
        }
        this.l.f4339a = true;
        a(i4, sVar);
        c(i3);
        o oVar = this.l;
        oVar.f4341c = i4 + oVar.f4342d;
        this.l.f4340b = Math.abs(i2);
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        b(i2, sVar);
        int a2 = a(nVar, this.l, sVar);
        if (this.l.f4340b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.f4108c.a(-i2);
        this.o = this.f4112g;
        o oVar = this.l;
        oVar.f4340b = 0;
        a(nVar, oVar);
        return i2;
    }

    private int i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int j() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f4110e == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        if (r9.f4110e == 1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003f, code lost:
        if (r9.f4110e == 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        if (f() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        if (f() == false) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r10, int r11, androidx.recyclerview.widget.RecyclerView.n r12, androidx.recyclerview.widget.RecyclerView.s r13) {
        /*
            r9 = this;
            int r0 = r9.getChildCount()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.view.View r10 = r9.findContainingItemView(r10)
            if (r10 != 0) goto L_0x000f
            return r1
        L_0x000f:
            r9.e()
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            if (r11 == r3) goto L_0x004f
            r4 = 2
            if (r11 == r4) goto L_0x0042
            r4 = 17
            if (r11 == r4) goto L_0x003d
            r4 = 33
            if (r11 == r4) goto L_0x0038
            r4 = 66
            if (r11 == r4) goto L_0x0033
            r4 = 130(0x82, float:1.82E-43)
            if (r11 == r4) goto L_0x002e
        L_0x002b:
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x005c
        L_0x002e:
            int r11 = r9.f4110e
            if (r11 != r3) goto L_0x002b
            goto L_0x0046
        L_0x0033:
            int r11 = r9.f4110e
            if (r11 != 0) goto L_0x002b
            goto L_0x0046
        L_0x0038:
            int r11 = r9.f4110e
            if (r11 != r3) goto L_0x002b
            goto L_0x0053
        L_0x003d:
            int r11 = r9.f4110e
            if (r11 != 0) goto L_0x002b
            goto L_0x0053
        L_0x0042:
            int r11 = r9.f4110e
            if (r11 != r3) goto L_0x0048
        L_0x0046:
            r11 = 1
            goto L_0x005c
        L_0x0048:
            boolean r11 = r9.f()
            if (r11 == 0) goto L_0x0046
            goto L_0x0053
        L_0x004f:
            int r11 = r9.f4110e
            if (r11 != r3) goto L_0x0055
        L_0x0053:
            r11 = -1
            goto L_0x005c
        L_0x0055:
            boolean r11 = r9.f()
            if (r11 == 0) goto L_0x0053
            goto L_0x0046
        L_0x005c:
            if (r11 != r0) goto L_0x005f
            return r1
        L_0x005f:
            android.view.ViewGroup$LayoutParams r0 = r10.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r0
            boolean r4 = r0.f4117b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r0.f4116a
            if (r11 != r3) goto L_0x0070
            int r5 = r9.i()
            goto L_0x0074
        L_0x0070:
            int r5 = r9.j()
        L_0x0074:
            r9.a((int) r5, (androidx.recyclerview.widget.RecyclerView.s) r13)
            r9.c((int) r11)
            androidx.recyclerview.widget.o r6 = r9.l
            int r7 = r6.f4342d
            int r7 = r7 + r5
            r6.f4341c = r7
            androidx.recyclerview.widget.o r6 = r9.l
            r7 = 1051372203(0x3eaaaaab, float:0.33333334)
            androidx.recyclerview.widget.u r8 = r9.f4108c
            int r8 = r8.e()
            float r8 = (float) r8
            float r8 = r8 * r7
            int r7 = (int) r8
            r6.f4340b = r7
            androidx.recyclerview.widget.o r6 = r9.l
            r6.f4346h = r3
            r7 = 0
            r6.f4339a = r7
            r9.a((androidx.recyclerview.widget.RecyclerView.n) r12, (androidx.recyclerview.widget.o) r6, (androidx.recyclerview.widget.RecyclerView.s) r13)
            boolean r12 = r9.f4112g
            r9.o = r12
            if (r4 != 0) goto L_0x00ab
            android.view.View r12 = r0.a(r5, r11)
            if (r12 == 0) goto L_0x00ab
            if (r12 == r10) goto L_0x00ab
            return r12
        L_0x00ab:
            boolean r12 = r9.j(r11)
            if (r12 == 0) goto L_0x00c6
            int r12 = r9.f4106a
            int r12 = r12 - r3
        L_0x00b4:
            if (r12 < 0) goto L_0x00db
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r13 = r9.f4107b
            r13 = r13[r12]
            android.view.View r13 = r13.a(r5, r11)
            if (r13 == 0) goto L_0x00c3
            if (r13 == r10) goto L_0x00c3
            return r13
        L_0x00c3:
            int r12 = r12 + -1
            goto L_0x00b4
        L_0x00c6:
            r12 = 0
        L_0x00c7:
            int r13 = r9.f4106a
            if (r12 >= r13) goto L_0x00db
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r13 = r9.f4107b
            r13 = r13[r12]
            android.view.View r13 = r13.a(r5, r11)
            if (r13 == 0) goto L_0x00d8
            if (r13 == r10) goto L_0x00d8
            return r13
        L_0x00d8:
            int r12 = r12 + 1
            goto L_0x00c7
        L_0x00db:
            boolean r12 = r9.f4111f
            r12 = r12 ^ r3
            if (r11 != r2) goto L_0x00e2
            r13 = 1
            goto L_0x00e3
        L_0x00e2:
            r13 = 0
        L_0x00e3:
            if (r12 != r13) goto L_0x00e7
            r12 = 1
            goto L_0x00e8
        L_0x00e7:
            r12 = 0
        L_0x00e8:
            if (r4 != 0) goto L_0x00fe
            if (r12 == 0) goto L_0x00f1
            int r13 = r0.f()
            goto L_0x00f5
        L_0x00f1:
            int r13 = r0.g()
        L_0x00f5:
            android.view.View r13 = r9.findViewByPosition(r13)
            if (r13 == 0) goto L_0x00fe
            if (r13 == r10) goto L_0x00fe
            return r13
        L_0x00fe:
            boolean r11 = r9.j(r11)
            if (r11 == 0) goto L_0x012c
            int r11 = r9.f4106a
            int r11 = r11 - r3
        L_0x0107:
            if (r11 < 0) goto L_0x014f
            int r13 = r0.f4144e
            if (r11 == r13) goto L_0x0129
            if (r12 == 0) goto L_0x0118
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r13 = r9.f4107b
            r13 = r13[r11]
            int r13 = r13.f()
            goto L_0x0120
        L_0x0118:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r13 = r9.f4107b
            r13 = r13[r11]
            int r13 = r13.g()
        L_0x0120:
            android.view.View r13 = r9.findViewByPosition(r13)
            if (r13 == 0) goto L_0x0129
            if (r13 == r10) goto L_0x0129
            return r13
        L_0x0129:
            int r11 = r11 + -1
            goto L_0x0107
        L_0x012c:
            int r11 = r9.f4106a
            if (r7 >= r11) goto L_0x014f
            if (r12 == 0) goto L_0x013b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r11 = r9.f4107b
            r11 = r11[r7]
            int r11 = r11.f()
            goto L_0x0143
        L_0x013b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r11 = r9.f4107b
            r11 = r11[r7]
            int r11 = r11.g()
        L_0x0143:
            android.view.View r11 = r9.findViewByPosition(r11)
            if (r11 == 0) goto L_0x014c
            if (r11 == r10) goto L_0x014c
            return r11
        L_0x014c:
            int r7 = r7 + 1
            goto L_0x012c
        L_0x014f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s):android.view.View");
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        b f4116a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4117b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final int b() {
            b bVar = this.f4116a;
            if (bVar == null) {
                return -1;
            }
            return bVar.f4144e;
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f4140a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f4141b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f4142c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f4143d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f4144e;

        b(int i2) {
            this.f4144e = i2;
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2) {
            int i3 = this.f4141b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f4140a.size() == 0) {
                return i2;
            }
            h();
            return this.f4141b;
        }

        private void h() {
            LazySpanLookup.FullSpanItem d2;
            View view = this.f4140a.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f4141b = StaggeredGridLayoutManager.this.f4108c.a(view);
            if (layoutParams.f4117b && (d2 = StaggeredGridLayoutManager.this.j.d(layoutParams.f4054c.getLayoutPosition())) != null && d2.f4121b == -1) {
                this.f4141b -= d2.a(this.f4144e);
            }
        }

        /* access modifiers changed from: package-private */
        public final int a() {
            int i2 = this.f4141b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            h();
            return this.f4141b;
        }

        /* access modifiers changed from: package-private */
        public final int b(int i2) {
            int i3 = this.f4142c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f4140a.size() == 0) {
                return i2;
            }
            i();
            return this.f4142c;
        }

        private void i() {
            LazySpanLookup.FullSpanItem d2;
            ArrayList<View> arrayList = this.f4140a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.f4142c = StaggeredGridLayoutManager.this.f4108c.b(view);
            if (layoutParams.f4117b && (d2 = StaggeredGridLayoutManager.this.j.d(layoutParams.f4054c.getLayoutPosition())) != null && d2.f4121b == 1) {
                this.f4142c += d2.a(this.f4144e);
            }
        }

        /* access modifiers changed from: package-private */
        public final int b() {
            int i2 = this.f4142c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            i();
            return this.f4142c;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.f4140a.clear();
            j();
            this.f4143d = 0;
        }

        private void j() {
            this.f4141b = Integer.MIN_VALUE;
            this.f4142c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void c(int i2) {
            this.f4141b = i2;
            this.f4142c = i2;
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            int size = this.f4140a.size();
            View remove = this.f4140a.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.f4116a = null;
            if (layoutParams.f4054c.isRemoved() || layoutParams.f4054c.isUpdated()) {
                this.f4143d -= StaggeredGridLayoutManager.this.f4108c.e(remove);
            }
            if (size == 1) {
                this.f4141b = Integer.MIN_VALUE;
            }
            this.f4142c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void e() {
            View remove = this.f4140a.remove(0);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.f4116a = null;
            if (this.f4140a.size() == 0) {
                this.f4142c = Integer.MIN_VALUE;
            }
            if (layoutParams.f4054c.isRemoved() || layoutParams.f4054c.isUpdated()) {
                this.f4143d -= StaggeredGridLayoutManager.this.f4108c.e(remove);
            }
            this.f4141b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void d(int i2) {
            int i3 = this.f4141b;
            if (i3 != Integer.MIN_VALUE) {
                this.f4141b = i3 + i2;
            }
            int i4 = this.f4142c;
            if (i4 != Integer.MIN_VALUE) {
                this.f4142c = i4 + i2;
            }
        }

        public final int f() {
            if (StaggeredGridLayoutManager.this.f4111f) {
                return b(this.f4140a.size() - 1, -1);
            }
            return b(0, this.f4140a.size());
        }

        public final int g() {
            if (StaggeredGridLayoutManager.this.f4111f) {
                return b(0, this.f4140a.size());
            }
            return b(this.f4140a.size() - 1, -1);
        }

        private int a(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int b2 = StaggeredGridLayoutManager.this.f4108c.b();
            int c2 = StaggeredGridLayoutManager.this.f4108c.c();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f4140a.get(i2);
                int a2 = StaggeredGridLayoutManager.this.f4108c.a(view);
                int b3 = StaggeredGridLayoutManager.this.f4108c.b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? a2 < c2 : a2 <= c2;
                if (!z3 ? b3 > b2 : b3 >= b2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (a2 < b2 || b3 > c2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (a2 >= b2 && b3 <= c2) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        public final int a(int i2, int i3, boolean z) {
            return a(i2, i3, z, true, false);
        }

        private int b(int i2, int i3) {
            return a(i2, i3, false, false, true);
        }

        public final View a(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f4140a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f4140a.get(size);
                    if ((StaggeredGridLayoutManager.this.f4111f && StaggeredGridLayoutManager.this.getPosition(view2) >= i2) || ((!StaggeredGridLayoutManager.this.f4111f && StaggeredGridLayoutManager.this.getPosition(view2) <= i2) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4140a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.f4140a.get(i4);
                    if ((StaggeredGridLayoutManager.this.f4111f && StaggeredGridLayoutManager.this.getPosition(view3) <= i2) || ((!StaggeredGridLayoutManager.this.f4111f && StaggeredGridLayoutManager.this.getPosition(view3) >= i2) || !view3.hasFocusable())) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public final void a(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f4116a = this;
            this.f4140a.add(0, view);
            this.f4141b = Integer.MIN_VALUE;
            if (this.f4140a.size() == 1) {
                this.f4142c = Integer.MIN_VALUE;
            }
            if (layoutParams.f4054c.isRemoved() || layoutParams.f4054c.isUpdated()) {
                this.f4143d += StaggeredGridLayoutManager.this.f4108c.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f4116a = this;
            this.f4140a.add(view);
            this.f4142c = Integer.MIN_VALUE;
            if (this.f4140a.size() == 1) {
                this.f4141b = Integer.MIN_VALUE;
            }
            if (layoutParams.f4054c.isRemoved() || layoutParams.f4054c.isUpdated()) {
                this.f4143d += StaggeredGridLayoutManager.this.f4108c.e(view);
            }
        }
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f4118a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f4119b;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2) {
            List<FullSpanItem> list = this.f4119b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f4119b.get(size).f4120a >= i2) {
                        this.f4119b.remove(size);
                    }
                }
            }
            return b(i2);
        }

        /* access modifiers changed from: package-private */
        public final int b(int i2) {
            int[] iArr = this.f4118a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int g2 = g(i2);
            if (g2 == -1) {
                int[] iArr2 = this.f4118a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f4118a.length;
            }
            int i3 = g2 + 1;
            Arrays.fill(this.f4118a, i2, i3, -1);
            return i3;
        }

        /* access modifiers changed from: package-private */
        public final int c(int i2) {
            int[] iArr = this.f4118a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, b bVar) {
            f(i2);
            this.f4118a[i2] = bVar.f4144e;
        }

        private int e(int i2) {
            int length = this.f4118a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        private void f(int i2) {
            int[] iArr = this.f4118a;
            if (iArr == null) {
                this.f4118a = new int[(Math.max(i2, 10) + 1)];
                Arrays.fill(this.f4118a, -1);
            } else if (i2 >= iArr.length) {
                this.f4118a = new int[e(i2)];
                System.arraycopy(iArr, 0, this.f4118a, 0, iArr.length);
                int[] iArr2 = this.f4118a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            int[] iArr = this.f4118a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4119b = null;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3) {
            int[] iArr = this.f4118a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                f(i4);
                int[] iArr2 = this.f4118a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.f4118a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                c(i2, i3);
            }
        }

        private void c(int i2, int i3) {
            List<FullSpanItem> list = this.f4119b;
            if (list != null) {
                int i4 = i2 + i3;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4119b.get(size);
                    if (fullSpanItem.f4120a >= i2) {
                        if (fullSpanItem.f4120a < i4) {
                            this.f4119b.remove(size);
                        } else {
                            fullSpanItem.f4120a -= i3;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2, int i3) {
            int[] iArr = this.f4118a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                f(i4);
                int[] iArr2 = this.f4118a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.f4118a, i2, i4, -1);
                d(i2, i3);
            }
        }

        private void d(int i2, int i3) {
            List<FullSpanItem> list = this.f4119b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4119b.get(size);
                    if (fullSpanItem.f4120a >= i2) {
                        fullSpanItem.f4120a += i3;
                    }
                }
            }
        }

        private int g(int i2) {
            if (this.f4119b == null) {
                return -1;
            }
            FullSpanItem d2 = d(i2);
            if (d2 != null) {
                this.f4119b.remove(d2);
            }
            int size = this.f4119b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f4119b.get(i3).f4120a >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            this.f4119b.remove(i3);
            return this.f4119b.get(i3).f4120a;
        }

        public final void a(FullSpanItem fullSpanItem) {
            if (this.f4119b == null) {
                this.f4119b = new ArrayList();
            }
            int size = this.f4119b.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f4119b.get(i2);
                if (fullSpanItem2.f4120a == fullSpanItem.f4120a) {
                    this.f4119b.remove(i2);
                }
                if (fullSpanItem2.f4120a >= fullSpanItem.f4120a) {
                    this.f4119b.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f4119b.add(fullSpanItem);
        }

        public final FullSpanItem d(int i2) {
            List<FullSpanItem> list = this.f4119b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4119b.get(size);
                if (fullSpanItem.f4120a == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem a(int i2, int i3, int i4) {
            List<FullSpanItem> list = this.f4119b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f4119b.get(i5);
                if (fullSpanItem.f4120a >= i3) {
                    return null;
                }
                if (fullSpanItem.f4120a >= i2 && (i4 == 0 || fullSpanItem.f4121b == i4 || fullSpanItem.f4123d)) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f4120a;

            /* renamed from: b  reason: collision with root package name */
            int f4121b;

            /* renamed from: c  reason: collision with root package name */
            int[] f4122c;

            /* renamed from: d  reason: collision with root package name */
            boolean f4123d;

            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.f4120a = parcel.readInt();
                this.f4121b = parcel.readInt();
                this.f4123d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f4122c = new int[readInt];
                    parcel.readIntArray(this.f4122c);
                }
            }

            FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public final int a(int i2) {
                int[] iArr = this.f4122c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f4120a);
                parcel.writeInt(this.f4121b);
                parcel.writeInt(this.f4123d ? 1 : 0);
                int[] iArr = this.f4122c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f4122c);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4120a + ", mGapDir=" + this.f4121b + ", mHasUnwantedGapAfter=" + this.f4123d + ", mGapPerSpan=" + Arrays.toString(this.f4122c) + '}';
            }
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f4124a;

        /* renamed from: b  reason: collision with root package name */
        int f4125b;

        /* renamed from: c  reason: collision with root package name */
        int f4126c;

        /* renamed from: d  reason: collision with root package name */
        int[] f4127d;

        /* renamed from: e  reason: collision with root package name */
        int f4128e;

        /* renamed from: f  reason: collision with root package name */
        int[] f4129f;

        /* renamed from: g  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f4130g;

        /* renamed from: h  reason: collision with root package name */
        boolean f4131h;

        /* renamed from: i  reason: collision with root package name */
        boolean f4132i;
        boolean j;

        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f4124a = parcel.readInt();
            this.f4125b = parcel.readInt();
            this.f4126c = parcel.readInt();
            int i2 = this.f4126c;
            if (i2 > 0) {
                this.f4127d = new int[i2];
                parcel.readIntArray(this.f4127d);
            }
            this.f4128e = parcel.readInt();
            int i3 = this.f4128e;
            if (i3 > 0) {
                this.f4129f = new int[i3];
                parcel.readIntArray(this.f4129f);
            }
            boolean z = false;
            this.f4131h = parcel.readInt() == 1;
            this.f4132i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
            this.f4130g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f4126c = savedState.f4126c;
            this.f4124a = savedState.f4124a;
            this.f4125b = savedState.f4125b;
            this.f4127d = savedState.f4127d;
            this.f4128e = savedState.f4128e;
            this.f4129f = savedState.f4129f;
            this.f4131h = savedState.f4131h;
            this.f4132i = savedState.f4132i;
            this.j = savedState.j;
            this.f4130g = savedState.f4130g;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4124a);
            parcel.writeInt(this.f4125b);
            parcel.writeInt(this.f4126c);
            if (this.f4126c > 0) {
                parcel.writeIntArray(this.f4127d);
            }
            parcel.writeInt(this.f4128e);
            if (this.f4128e > 0) {
                parcel.writeIntArray(this.f4129f);
            }
            parcel.writeInt(this.f4131h ? 1 : 0);
            parcel.writeInt(this.f4132i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.f4130g);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f4133a;

        /* renamed from: b  reason: collision with root package name */
        int f4134b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4135c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4136d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4137e;

        /* renamed from: f  reason: collision with root package name */
        int[] f4138f;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f4133a = -1;
            this.f4134b = Integer.MIN_VALUE;
            this.f4135c = false;
            this.f4136d = false;
            this.f4137e = false;
            int[] iArr = this.f4138f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x044f A[LOOP:0: B:1:0x0003->B:244:0x044f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0457 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.n r13, androidx.recyclerview.widget.RecyclerView.s r14) {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            r2 = 1
        L_0x0003:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r3 = r12.t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r4 = r12.q
            r5 = -1
            if (r4 != 0) goto L_0x000e
            int r4 = r12.f4113h
            if (r4 == r5) goto L_0x001b
        L_0x000e:
            int r4 = r14.a()
            if (r4 != 0) goto L_0x001b
            r12.removeAndRecycleAllViews(r13)
            r3.a()
            return
        L_0x001b:
            boolean r4 = r3.f4137e
            if (r4 == 0) goto L_0x002a
            int r4 = r12.f4113h
            if (r4 != r5) goto L_0x002a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r4 = r12.q
            if (r4 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r4 = 0
            goto L_0x002b
        L_0x002a:
            r4 = 1
        L_0x002b:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == 0) goto L_0x021c
            r3.a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            if (r7 == 0) goto L_0x00c3
            int r7 = r7.f4126c
            if (r7 <= 0) goto L_0x0085
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            int r7 = r7.f4126c
            int r8 = r12.f4106a
            if (r7 != r8) goto L_0x0074
            r7 = 0
        L_0x0043:
            int r8 = r12.f4106a
            if (r7 >= r8) goto L_0x0085
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r8 = r12.f4107b
            r8 = r8[r7]
            r8.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r8 = r12.q
            int[] r8 = r8.f4127d
            r8 = r8[r7]
            if (r8 == r6) goto L_0x006a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r9 = r12.q
            boolean r9 = r9.f4132i
            if (r9 == 0) goto L_0x0063
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r9 = r9.c()
            goto L_0x0069
        L_0x0063:
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r9 = r9.b()
        L_0x0069:
            int r8 = r8 + r9
        L_0x006a:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r9 = r12.f4107b
            r9 = r9[r7]
            r9.c(r8)
            int r7 = r7 + 1
            goto L_0x0043
        L_0x0074:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            r8 = 0
            r7.f4127d = r8
            r7.f4126c = r0
            r7.f4128e = r0
            r7.f4129f = r8
            r7.f4130g = r8
            int r8 = r7.f4125b
            r7.f4124a = r8
        L_0x0085:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            boolean r7 = r7.j
            r12.p = r7
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            boolean r7 = r7.f4131h
            r12.a((boolean) r7)
            r12.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            int r7 = r7.f4124a
            if (r7 == r5) goto L_0x00a8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            int r7 = r7.f4124a
            r12.f4113h = r7
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            boolean r7 = r7.f4132i
            r3.f4135c = r7
            goto L_0x00ac
        L_0x00a8:
            boolean r7 = r12.f4112g
            r3.f4135c = r7
        L_0x00ac:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            int r7 = r7.f4128e
            if (r7 <= r1) goto L_0x00ca
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r12.j
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r8 = r12.q
            int[] r8 = r8.f4129f
            r7.f4118a = r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r12.j
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r8 = r12.q
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r8 = r8.f4130g
            r7.f4119b = r8
            goto L_0x00ca
        L_0x00c3:
            r12.e()
            boolean r7 = r12.f4112g
            r3.f4135c = r7
        L_0x00ca:
            boolean r7 = r14.f4096g
            if (r7 != 0) goto L_0x01d7
            int r7 = r12.f4113h
            if (r7 != r5) goto L_0x00d4
            goto L_0x01d7
        L_0x00d4:
            if (r7 < 0) goto L_0x01d3
            int r8 = r14.a()
            if (r7 < r8) goto L_0x00de
            goto L_0x01d3
        L_0x00de:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            if (r7 == 0) goto L_0x00f5
            int r7 = r7.f4124a
            if (r7 == r5) goto L_0x00f5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            int r7 = r7.f4126c
            if (r7 > 0) goto L_0x00ed
            goto L_0x00f5
        L_0x00ed:
            r3.f4134b = r6
            int r7 = r12.f4113h
            r3.f4133a = r7
            goto L_0x01d1
        L_0x00f5:
            int r7 = r12.f4113h
            android.view.View r7 = r12.findViewByPosition(r7)
            if (r7 == 0) goto L_0x0187
            boolean r8 = r12.f4112g
            if (r8 == 0) goto L_0x0106
            int r8 = r12.i()
            goto L_0x010a
        L_0x0106:
            int r8 = r12.j()
        L_0x010a:
            r3.f4133a = r8
            int r8 = r12.f4114i
            if (r8 == r6) goto L_0x013c
            boolean r8 = r3.f4135c
            if (r8 == 0) goto L_0x0128
            androidx.recyclerview.widget.u r8 = r12.f4108c
            int r8 = r8.c()
            int r9 = r12.f4114i
            int r8 = r8 - r9
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r7 = r9.b((android.view.View) r7)
            int r8 = r8 - r7
            r3.f4134b = r8
            goto L_0x01d1
        L_0x0128:
            androidx.recyclerview.widget.u r8 = r12.f4108c
            int r8 = r8.b()
            int r9 = r12.f4114i
            int r8 = r8 + r9
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r7 = r9.a((android.view.View) r7)
            int r8 = r8 - r7
            r3.f4134b = r8
            goto L_0x01d1
        L_0x013c:
            androidx.recyclerview.widget.u r8 = r12.f4108c
            int r8 = r8.e(r7)
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r9 = r9.e()
            if (r8 <= r9) goto L_0x015f
            boolean r7 = r3.f4135c
            if (r7 == 0) goto L_0x0155
            androidx.recyclerview.widget.u r7 = r12.f4108c
            int r7 = r7.c()
            goto L_0x015b
        L_0x0155:
            androidx.recyclerview.widget.u r7 = r12.f4108c
            int r7 = r7.b()
        L_0x015b:
            r3.f4134b = r7
            goto L_0x01d1
        L_0x015f:
            androidx.recyclerview.widget.u r8 = r12.f4108c
            int r8 = r8.a((android.view.View) r7)
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r9 = r9.b()
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x0172
            int r7 = -r8
            r3.f4134b = r7
            goto L_0x01d1
        L_0x0172:
            androidx.recyclerview.widget.u r8 = r12.f4108c
            int r8 = r8.c()
            androidx.recyclerview.widget.u r9 = r12.f4108c
            int r7 = r9.b((android.view.View) r7)
            int r8 = r8 - r7
            if (r8 >= 0) goto L_0x0184
            r3.f4134b = r8
            goto L_0x01d1
        L_0x0184:
            r3.f4134b = r6
            goto L_0x01d1
        L_0x0187:
            int r7 = r12.f4113h
            r3.f4133a = r7
            int r7 = r12.f4114i
            if (r7 != r6) goto L_0x01b4
            int r7 = r3.f4133a
            int r7 = r12.k(r7)
            if (r7 != r1) goto L_0x0199
            r7 = 1
            goto L_0x019a
        L_0x0199:
            r7 = 0
        L_0x019a:
            r3.f4135c = r7
            boolean r7 = r3.f4135c
            if (r7 == 0) goto L_0x01a9
            androidx.recyclerview.widget.StaggeredGridLayoutManager r7 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.u r7 = r7.f4108c
            int r7 = r7.c()
            goto L_0x01b1
        L_0x01a9:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r7 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.u r7 = r7.f4108c
            int r7 = r7.b()
        L_0x01b1:
            r3.f4134b = r7
            goto L_0x01cf
        L_0x01b4:
            boolean r8 = r3.f4135c
            if (r8 == 0) goto L_0x01c4
            androidx.recyclerview.widget.StaggeredGridLayoutManager r8 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.u r8 = r8.f4108c
            int r8 = r8.c()
            int r8 = r8 - r7
            r3.f4134b = r8
            goto L_0x01cf
        L_0x01c4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r8 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.u r8 = r8.f4108c
            int r8 = r8.b()
            int r8 = r8 + r7
            r3.f4134b = r8
        L_0x01cf:
            r3.f4136d = r1
        L_0x01d1:
            r7 = 1
            goto L_0x01d8
        L_0x01d3:
            r12.f4113h = r5
            r12.f4114i = r6
        L_0x01d7:
            r7 = 0
        L_0x01d8:
            if (r7 != 0) goto L_0x021a
            boolean r7 = r12.o
            if (r7 == 0) goto L_0x01f9
            int r7 = r14.a()
            int r8 = r12.getChildCount()
            int r8 = r8 - r1
        L_0x01e7:
            if (r8 < 0) goto L_0x0215
            android.view.View r9 = r12.getChildAt(r8)
            int r9 = r12.getPosition(r9)
            if (r9 < 0) goto L_0x01f6
            if (r9 >= r7) goto L_0x01f6
            goto L_0x0216
        L_0x01f6:
            int r8 = r8 + -1
            goto L_0x01e7
        L_0x01f9:
            int r7 = r14.a()
            int r8 = r12.getChildCount()
            r9 = 0
        L_0x0202:
            if (r9 >= r8) goto L_0x0215
            android.view.View r10 = r12.getChildAt(r9)
            int r10 = r12.getPosition(r10)
            if (r10 < 0) goto L_0x0212
            if (r10 >= r7) goto L_0x0212
            r9 = r10
            goto L_0x0216
        L_0x0212:
            int r9 = r9 + 1
            goto L_0x0202
        L_0x0215:
            r9 = 0
        L_0x0216:
            r3.f4133a = r9
            r3.f4134b = r6
        L_0x021a:
            r3.f4137e = r1
        L_0x021c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            if (r7 != 0) goto L_0x0239
            int r7 = r12.f4113h
            if (r7 != r5) goto L_0x0239
            boolean r7 = r3.f4135c
            boolean r8 = r12.o
            if (r7 != r8) goto L_0x0232
            boolean r7 = r12.f()
            boolean r8 = r12.p
            if (r7 == r8) goto L_0x0239
        L_0x0232:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r12.j
            r7.a()
            r3.f4136d = r1
        L_0x0239:
            int r7 = r12.getChildCount()
            if (r7 <= 0) goto L_0x02ef
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r7 = r12.q
            if (r7 == 0) goto L_0x0247
            int r7 = r7.f4126c
            if (r7 > 0) goto L_0x02ef
        L_0x0247:
            boolean r7 = r3.f4136d
            if (r7 == 0) goto L_0x0267
            r4 = 0
        L_0x024c:
            int r7 = r12.f4106a
            if (r4 >= r7) goto L_0x02ef
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r7 = r12.f4107b
            r7 = r7[r4]
            r7.c()
            int r7 = r3.f4134b
            if (r7 == r6) goto L_0x0264
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r7 = r12.f4107b
            r7 = r7[r4]
            int r8 = r3.f4134b
            r7.c(r8)
        L_0x0264:
            int r4 = r4 + 1
            goto L_0x024c
        L_0x0267:
            if (r4 != 0) goto L_0x0288
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r4 = r12.t
            int[] r4 = r4.f4138f
            if (r4 != 0) goto L_0x0270
            goto L_0x0288
        L_0x0270:
            r4 = 0
        L_0x0271:
            int r7 = r12.f4106a
            if (r4 >= r7) goto L_0x02ef
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r7 = r12.f4107b
            r7 = r7[r4]
            r7.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r8 = r12.t
            int[] r8 = r8.f4138f
            r8 = r8[r4]
            r7.c(r8)
            int r4 = r4 + 1
            goto L_0x0271
        L_0x0288:
            r4 = 0
        L_0x0289:
            int r7 = r12.f4106a
            if (r4 >= r7) goto L_0x02c8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r7 = r12.f4107b
            r7 = r7[r4]
            boolean r8 = r12.f4112g
            int r9 = r3.f4134b
            if (r8 == 0) goto L_0x029c
            int r10 = r7.b((int) r6)
            goto L_0x02a0
        L_0x029c:
            int r10 = r7.a((int) r6)
        L_0x02a0:
            r7.c()
            if (r10 == r6) goto L_0x02c5
            if (r8 == 0) goto L_0x02b1
            androidx.recyclerview.widget.StaggeredGridLayoutManager r11 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.u r11 = r11.f4108c
            int r11 = r11.c()
            if (r10 < r11) goto L_0x02c5
        L_0x02b1:
            if (r8 != 0) goto L_0x02be
            androidx.recyclerview.widget.StaggeredGridLayoutManager r8 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.u r8 = r8.f4108c
            int r8 = r8.b()
            if (r10 <= r8) goto L_0x02be
            goto L_0x02c5
        L_0x02be:
            if (r9 == r6) goto L_0x02c1
            int r10 = r10 + r9
        L_0x02c1:
            r7.f4142c = r10
            r7.f4141b = r10
        L_0x02c5:
            int r4 = r4 + 1
            goto L_0x0289
        L_0x02c8:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r4 = r12.t
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r7 = r12.f4107b
            int r8 = r7.length
            int[] r9 = r4.f4138f
            if (r9 == 0) goto L_0x02d6
            int[] r9 = r4.f4138f
            int r9 = r9.length
            if (r9 >= r8) goto L_0x02df
        L_0x02d6:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r9 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r9 = r9.f4107b
            int r9 = r9.length
            int[] r9 = new int[r9]
            r4.f4138f = r9
        L_0x02df:
            r9 = 0
        L_0x02e0:
            if (r9 >= r8) goto L_0x02ef
            int[] r10 = r4.f4138f
            r11 = r7[r9]
            int r11 = r11.a((int) r6)
            r10[r9] = r11
            int r9 = r9 + 1
            goto L_0x02e0
        L_0x02ef:
            r12.detachAndScrapAttachedViews(r13)
            androidx.recyclerview.widget.o r4 = r12.l
            r4.f4339a = r0
            r12.u = r0
            androidx.recyclerview.widget.u r4 = r12.f4109d
            int r4 = r4.e()
            r12.b((int) r4)
            int r4 = r3.f4133a
            r12.a((int) r4, (androidx.recyclerview.widget.RecyclerView.s) r14)
            boolean r4 = r3.f4135c
            if (r4 == 0) goto L_0x0326
            r12.c((int) r5)
            androidx.recyclerview.widget.o r4 = r12.l
            r12.a((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.o) r4, (androidx.recyclerview.widget.RecyclerView.s) r14)
            r12.c((int) r1)
            androidx.recyclerview.widget.o r4 = r12.l
            int r5 = r3.f4133a
            androidx.recyclerview.widget.o r7 = r12.l
            int r7 = r7.f4342d
            int r5 = r5 + r7
            r4.f4341c = r5
            androidx.recyclerview.widget.o r4 = r12.l
            r12.a((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.o) r4, (androidx.recyclerview.widget.RecyclerView.s) r14)
            goto L_0x0341
        L_0x0326:
            r12.c((int) r1)
            androidx.recyclerview.widget.o r4 = r12.l
            r12.a((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.o) r4, (androidx.recyclerview.widget.RecyclerView.s) r14)
            r12.c((int) r5)
            androidx.recyclerview.widget.o r4 = r12.l
            int r5 = r3.f4133a
            androidx.recyclerview.widget.o r7 = r12.l
            int r7 = r7.f4342d
            int r5 = r5 + r7
            r4.f4341c = r5
            androidx.recyclerview.widget.o r4 = r12.l
            r12.a((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.o) r4, (androidx.recyclerview.widget.RecyclerView.s) r14)
        L_0x0341:
            androidx.recyclerview.widget.u r4 = r12.f4109d
            int r4 = r4.g()
            r5 = 1073741824(0x40000000, float:2.0)
            if (r4 == r5) goto L_0x03f6
            r4 = 0
            int r5 = r12.getChildCount()
            r4 = 0
            r7 = 0
        L_0x0352:
            if (r4 >= r5) goto L_0x037c
            android.view.View r8 = r12.getChildAt(r4)
            androidx.recyclerview.widget.u r9 = r12.f4109d
            int r9 = r9.e(r8)
            float r9 = (float) r9
            int r10 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r10 < 0) goto L_0x0379
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            boolean r8 = r8.f4117b
            if (r8 == 0) goto L_0x0375
            r8 = 1065353216(0x3f800000, float:1.0)
            float r9 = r9 * r8
            int r8 = r12.f4106a
            float r8 = (float) r8
            float r9 = r9 / r8
        L_0x0375:
            float r7 = java.lang.Math.max(r7, r9)
        L_0x0379:
            int r4 = r4 + 1
            goto L_0x0352
        L_0x037c:
            int r4 = r12.k
            int r8 = r12.f4106a
            float r8 = (float) r8
            float r7 = r7 * r8
            int r7 = java.lang.Math.round(r7)
            androidx.recyclerview.widget.u r8 = r12.f4109d
            int r8 = r8.g()
            if (r8 != r6) goto L_0x0399
            androidx.recyclerview.widget.u r6 = r12.f4109d
            int r6 = r6.e()
            int r7 = java.lang.Math.min(r7, r6)
        L_0x0399:
            r12.b((int) r7)
            int r6 = r12.k
            if (r6 == r4) goto L_0x03f6
            r6 = 0
        L_0x03a1:
            if (r6 >= r5) goto L_0x03f6
            android.view.View r7 = r12.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            boolean r9 = r8.f4117b
            if (r9 != 0) goto L_0x03f3
            boolean r9 = r12.f()
            if (r9 == 0) goto L_0x03d8
            int r9 = r12.f4110e
            if (r9 != r1) goto L_0x03d8
            int r9 = r12.f4106a
            int r9 = r9 - r1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r10 = r8.f4116a
            int r10 = r10.f4144e
            int r9 = r9 - r10
            int r9 = -r9
            int r10 = r12.k
            int r9 = r9 * r10
            int r10 = r12.f4106a
            int r10 = r10 - r1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.f4116a
            int r8 = r8.f4144e
            int r10 = r10 - r8
            int r8 = -r10
            int r8 = r8 * r4
            int r9 = r9 - r8
            r7.offsetLeftAndRight(r9)
            goto L_0x03f3
        L_0x03d8:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4116a
            int r9 = r9.f4144e
            int r10 = r12.k
            int r9 = r9 * r10
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.f4116a
            int r8 = r8.f4144e
            int r8 = r8 * r4
            int r10 = r12.f4110e
            if (r10 != r1) goto L_0x03ef
            int r9 = r9 - r8
            r7.offsetLeftAndRight(r9)
            goto L_0x03f3
        L_0x03ef:
            int r9 = r9 - r8
            r7.offsetTopAndBottom(r9)
        L_0x03f3:
            int r6 = r6 + 1
            goto L_0x03a1
        L_0x03f6:
            int r4 = r12.getChildCount()
            if (r4 <= 0) goto L_0x040d
            boolean r4 = r12.f4112g
            if (r4 == 0) goto L_0x0407
            r12.a((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.RecyclerView.s) r14, (boolean) r1)
            r12.b((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.RecyclerView.s) r14, (boolean) r0)
            goto L_0x040d
        L_0x0407:
            r12.b((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.RecyclerView.s) r14, (boolean) r1)
            r12.a((androidx.recyclerview.widget.RecyclerView.n) r13, (androidx.recyclerview.widget.RecyclerView.s) r14, (boolean) r0)
        L_0x040d:
            if (r2 == 0) goto L_0x0439
            boolean r2 = r14.f4096g
            if (r2 != 0) goto L_0x0439
            int r2 = r12.n
            if (r2 == 0) goto L_0x0429
            int r2 = r12.getChildCount()
            if (r2 <= 0) goto L_0x0429
            boolean r2 = r12.u
            if (r2 != 0) goto L_0x0427
            android.view.View r2 = r12.d()
            if (r2 == 0) goto L_0x0429
        L_0x0427:
            r2 = 1
            goto L_0x042a
        L_0x0429:
            r2 = 0
        L_0x042a:
            if (r2 == 0) goto L_0x0439
            java.lang.Runnable r2 = r12.x
            r12.removeCallbacks(r2)
            boolean r2 = r12.a()
            if (r2 == 0) goto L_0x0439
            r2 = 1
            goto L_0x043a
        L_0x0439:
            r2 = 0
        L_0x043a:
            boolean r4 = r14.f4096g
            if (r4 == 0) goto L_0x0443
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r4 = r12.t
            r4.a()
        L_0x0443:
            boolean r3 = r3.f4135c
            r12.o = r3
            boolean r3 = r12.f()
            r12.p = r3
            if (r2 == 0) goto L_0x0457
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r2 = r12.t
            r2.a()
            r2 = 0
            goto L_0x0003
        L_0x0457:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s):void");
    }

    private void a(b bVar, int i2, int i3) {
        int i4 = bVar.f4143d;
        if (i2 == -1) {
            if (bVar.a() + i4 <= i3) {
                this.m.set(bVar.f4144e, false);
            }
        } else if (bVar.b() - i4 >= i3) {
            this.m.set(bVar.f4144e, false);
        }
    }
}
