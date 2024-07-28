package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.u;
import com.google.android.flexbox.c;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.r.b, a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f7979a = (!FlexboxLayoutManager.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static final Rect f7980b = new Rect();
    private int A;
    private c.a B;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f7981c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f7982d;

    /* renamed from: e  reason: collision with root package name */
    private int f7983e;

    /* renamed from: f  reason: collision with root package name */
    private int f7984f;

    /* renamed from: g  reason: collision with root package name */
    private int f7985g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f7986h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7987i;
    /* access modifiers changed from: private */
    public List<b> j;
    /* access modifiers changed from: private */
    public final c k;
    private RecyclerView.n l;
    private RecyclerView.s m;
    private b n;
    private a o;
    /* access modifiers changed from: private */
    public u p;
    private u q;
    private SavedState r;
    private int s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private SparseArray<View> x;
    private final Context y;
    private View z;

    public final void a(b bVar) {
    }

    public int getAlignContent() {
        return 5;
    }

    public FlexboxLayoutManager(Context context) {
        this(context, (byte) 0);
    }

    private FlexboxLayoutManager(Context context, byte b2) {
        this.f7985g = -1;
        this.j = new ArrayList();
        this.k = new c(this);
        this.o = new a(this, (byte) 0);
        this.s = -1;
        this.t = Integer.MIN_VALUE;
        this.u = Integer.MIN_VALUE;
        this.v = Integer.MIN_VALUE;
        this.x = new SparseArray<>();
        this.A = -1;
        this.B = new c.a();
        c(0);
        b();
        d(4);
        setAutoMeasureEnabled(true);
        this.y = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f7985g = -1;
        this.j = new ArrayList();
        this.k = new c(this);
        this.o = new a(this, (byte) 0);
        this.s = -1;
        this.t = Integer.MIN_VALUE;
        this.u = Integer.MIN_VALUE;
        this.v = Integer.MIN_VALUE;
        this.x = new SparseArray<>();
        this.A = -1;
        this.B = new c.a();
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i2, i3);
        int i4 = properties.f4050a;
        if (i4 != 0) {
            if (i4 == 1) {
                if (properties.f4052c) {
                    c(3);
                } else {
                    c(2);
                }
            }
        } else if (properties.f4052c) {
            c(1);
        } else {
            c(0);
        }
        b();
        d(4);
        setAutoMeasureEnabled(true);
        this.y = context;
    }

    public int getFlexDirection() {
        return this.f7981c;
    }

    public final void c(int i2) {
        if (this.f7981c != i2) {
            removeAllViews();
            this.f7981c = i2;
            this.p = null;
            this.q = null;
            g();
            requestLayout();
        }
    }

    public int getFlexWrap() {
        return this.f7982d;
    }

    public final void b() {
        int i2 = this.f7982d;
        if (i2 != 1) {
            if (i2 == 0) {
                removeAllViews();
                g();
            }
            this.f7982d = 1;
            this.p = null;
            this.q = null;
            requestLayout();
        }
    }

    public final void c() {
        if (this.f7983e != 0) {
            this.f7983e = 0;
            requestLayout();
        }
    }

    public int getAlignItems() {
        return this.f7984f;
    }

    public final void d(int i2) {
        int i3 = this.f7984f;
        if (i3 != i2) {
            if (i3 == 4 || i2 == 4) {
                removeAllViews();
                g();
            }
            this.f7984f = i2;
            requestLayout();
        }
    }

    public int getMaxLine() {
        return this.f7985g;
    }

    public final int a(View view, int i2, int i3) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (a()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    public final int a(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (a()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    public final void a(View view, int i2, int i3, b bVar) {
        calculateItemDecorationsForChild(view, f7980b);
        if (a()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.f8017e += leftDecorationWidth;
            bVar.f8018f += leftDecorationWidth;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.f8017e += topDecorationHeight;
        bVar.f8018f += topDecorationHeight;
    }

    public int getFlexItemCount() {
        return this.m.a();
    }

    public final View a(int i2) {
        View view = this.x.get(i2);
        if (view != null) {
            return view;
        }
        return this.l.b(i2);
    }

    public final View b(int i2) {
        return a(i2);
    }

    public final int a(int i2, int i3, int i4) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), i3, i4, canScrollHorizontally());
    }

    public final int b(int i2, int i3, int i4) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), i3, i4, canScrollVertically());
    }

    public int getLargestMainSize() {
        if (this.j.size() == 0) {
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, this.j.get(i3).f8017e);
        }
        return i2;
    }

    public int getSumOfCrossSize() {
        int size = this.j.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.j.get(i3).f8019g;
        }
        return i2;
    }

    public void setFlexLines(List<b> list) {
        this.j = list;
    }

    public List<b> getFlexLinesInternal() {
        return this.j;
    }

    public final void a(int i2, View view) {
        this.x.put(i2, view);
    }

    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = i2 < getPosition(getChildAt(0)) ? -1 : 1;
        if (a()) {
            return new PointF(0.0f, (float) i3);
        }
        return new PointF((float) i3, 0.0f);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onAdapterChanged(RecyclerView.a aVar, RecyclerView.a aVar2) {
        removeAllViews();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.r;
        if (savedState != null) {
            return new SavedState(savedState, (byte) 0);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int unused = savedState2.f7993a = getPosition(childAt);
            int unused2 = savedState2.f7994b = this.p.a(childAt) - this.p.b();
        } else {
            savedState2.f7993a = -1;
        }
        return savedState2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.r = (SavedState) parcelable;
            requestLayout();
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        super.onItemsAdded(recyclerView, i2, i3);
        e(i2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.onItemsUpdated(recyclerView, i2, i3, obj);
        e(i2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        super.onItemsUpdated(recyclerView, i2, i3);
        e(i2);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        super.onItemsRemoved(recyclerView, i2, i3);
        e(i2);
    }

    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        super.onItemsMoved(recyclerView, i2, i3, i4);
        e(Math.min(i2, i3));
    }

    private void e(int i2) {
        int h2 = h();
        int i3 = i();
        if (i2 < i3) {
            int childCount = getChildCount();
            this.k.c(childCount);
            this.k.b(childCount);
            this.k.d(childCount);
            if (!f7979a && this.k.f8023a == null) {
                throw new AssertionError();
            } else if (i2 < this.k.f8023a.length) {
                this.A = i2;
                View childAt = getChildAt(0);
                if (childAt != null) {
                    if (h2 > i2 || i2 > i3) {
                        this.s = getPosition(childAt);
                        if (a() || !this.f7986h) {
                            this.t = this.p.a(childAt) - this.p.b();
                        } else {
                            this.t = this.p.b(childAt) + this.p.f();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x023c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.n r19, androidx.recyclerview.widget.RecyclerView.s r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r0.l = r1
            r0.m = r2
            int r3 = r20.a()
            if (r3 != 0) goto L_0x0015
            boolean r4 = r2.f4096g
            if (r4 == 0) goto L_0x0015
            return
        L_0x0015:
            int r4 = r18.getLayoutDirection()
            int r5 = r0.f7981c
            r6 = 2
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x0063
            if (r5 == r8) goto L_0x0052
            if (r5 == r6) goto L_0x003f
            r9 = 3
            if (r5 == r9) goto L_0x002c
            r0.f7986h = r7
            r0.f7987i = r7
            goto L_0x0073
        L_0x002c:
            if (r4 != r8) goto L_0x0030
            r4 = 1
            goto L_0x0031
        L_0x0030:
            r4 = 0
        L_0x0031:
            r0.f7986h = r4
            int r4 = r0.f7982d
            if (r4 != r6) goto L_0x003c
            boolean r4 = r0.f7986h
            r4 = r4 ^ r8
            r0.f7986h = r4
        L_0x003c:
            r0.f7987i = r8
            goto L_0x0073
        L_0x003f:
            if (r4 != r8) goto L_0x0043
            r4 = 1
            goto L_0x0044
        L_0x0043:
            r4 = 0
        L_0x0044:
            r0.f7986h = r4
            int r4 = r0.f7982d
            if (r4 != r6) goto L_0x004f
            boolean r4 = r0.f7986h
            r4 = r4 ^ r8
            r0.f7986h = r4
        L_0x004f:
            r0.f7987i = r7
            goto L_0x0073
        L_0x0052:
            if (r4 == r8) goto L_0x0056
            r4 = 1
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            r0.f7986h = r4
            int r4 = r0.f7982d
            if (r4 != r6) goto L_0x005f
            r4 = 1
            goto L_0x0060
        L_0x005f:
            r4 = 0
        L_0x0060:
            r0.f7987i = r4
            goto L_0x0073
        L_0x0063:
            if (r4 != r8) goto L_0x0067
            r4 = 1
            goto L_0x0068
        L_0x0067:
            r4 = 0
        L_0x0068:
            r0.f7986h = r4
            int r4 = r0.f7982d
            if (r4 != r6) goto L_0x0070
            r4 = 1
            goto L_0x0071
        L_0x0070:
            r4 = 0
        L_0x0071:
            r0.f7987i = r4
        L_0x0073:
            r18.e()
            r18.f()
            com.google.android.flexbox.c r4 = r0.k
            r4.c((int) r3)
            com.google.android.flexbox.c r4 = r0.k
            r4.b((int) r3)
            com.google.android.flexbox.c r4 = r0.k
            r4.d((int) r3)
            com.google.android.flexbox.FlexboxLayoutManager$b r4 = r0.n
            r4.j = r7
            com.google.android.flexbox.FlexboxLayoutManager$SavedState r4 = r0.r
            if (r4 == 0) goto L_0x009e
            boolean r4 = com.google.android.flexbox.FlexboxLayoutManager.SavedState.c(r4, r3)
            if (r4 == 0) goto L_0x009e
            com.google.android.flexbox.FlexboxLayoutManager$SavedState r4 = r0.r
            int r4 = r4.f7993a
            r0.s = r4
        L_0x009e:
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            boolean r4 = r4.f8002h
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = -1
            if (r4 == 0) goto L_0x00b1
            int r4 = r0.s
            if (r4 != r6) goto L_0x00b1
            com.google.android.flexbox.FlexboxLayoutManager$SavedState r4 = r0.r
            if (r4 == 0) goto L_0x024a
        L_0x00b1:
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            com.google.android.flexbox.FlexboxLayoutManager.a.b(r4)
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            com.google.android.flexbox.FlexboxLayoutManager$SavedState r9 = r0.r
            boolean r10 = f7979a
            if (r10 != 0) goto L_0x00cb
            com.google.android.flexbox.c r10 = r0.k
            int[] r10 = r10.f8023a
            if (r10 == 0) goto L_0x00c5
            goto L_0x00cb
        L_0x00c5:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x00cb:
            boolean r10 = r2.f4096g
            if (r10 != 0) goto L_0x01d0
            int r10 = r0.s
            if (r10 != r6) goto L_0x00d5
            goto L_0x01d0
        L_0x00d5:
            if (r10 < 0) goto L_0x01cc
            int r11 = r20.a()
            if (r10 < r11) goto L_0x00df
            goto L_0x01cc
        L_0x00df:
            int r10 = r0.s
            int unused = r4.f7997c = r10
            com.google.android.flexbox.c r10 = r0.k
            int[] r10 = r10.f8023a
            int r11 = r4.f7997c
            r10 = r10[r11]
            int unused = r4.f7998d = r10
            com.google.android.flexbox.FlexboxLayoutManager$SavedState r10 = r0.r
            if (r10 == 0) goto L_0x0115
            int r11 = r20.a()
            boolean r10 = com.google.android.flexbox.FlexboxLayoutManager.SavedState.c(r10, r11)
            if (r10 == 0) goto L_0x0115
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.b()
            int r9 = r9.f7994b
            int r10 = r10 + r9
            int unused = r4.f7999e = r10
            boolean unused = r4.f8003i = true
            int unused = r4.f7998d = r6
            goto L_0x01ca
        L_0x0115:
            int r9 = r0.t
            if (r9 != r5) goto L_0x01a7
            int r9 = r0.s
            android.view.View r9 = r0.findViewByPosition(r9)
            if (r9 == 0) goto L_0x018b
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.e(r9)
            androidx.recyclerview.widget.u r11 = r0.p
            int r11 = r11.e()
            if (r10 <= r11) goto L_0x0134
            com.google.android.flexbox.FlexboxLayoutManager.a.g(r4)
            goto L_0x01ca
        L_0x0134:
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.a((android.view.View) r9)
            androidx.recyclerview.widget.u r11 = r0.p
            int r11 = r11.b()
            int r10 = r10 - r11
            if (r10 >= 0) goto L_0x0151
            androidx.recyclerview.widget.u r9 = r0.p
            int r9 = r9.b()
            int unused = r4.f7999e = r9
            boolean unused = r4.f8001g = r7
            goto L_0x01ca
        L_0x0151:
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.c()
            androidx.recyclerview.widget.u r11 = r0.p
            int r11 = r11.b((android.view.View) r9)
            int r10 = r10 - r11
            if (r10 >= 0) goto L_0x016d
            androidx.recyclerview.widget.u r9 = r0.p
            int r9 = r9.c()
            int unused = r4.f7999e = r9
            boolean unused = r4.f8001g = r8
            goto L_0x01ca
        L_0x016d:
            boolean r10 = r4.f8001g
            if (r10 == 0) goto L_0x0181
            androidx.recyclerview.widget.u r10 = r0.p
            int r9 = r10.b((android.view.View) r9)
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.a()
            int r9 = r9 + r10
            goto L_0x0187
        L_0x0181:
            androidx.recyclerview.widget.u r10 = r0.p
            int r9 = r10.a((android.view.View) r9)
        L_0x0187:
            int unused = r4.f7999e = r9
            goto L_0x01ca
        L_0x018b:
            int r9 = r18.getChildCount()
            if (r9 <= 0) goto L_0x01a3
            android.view.View r9 = r0.getChildAt(r7)
            int r9 = r0.getPosition(r9)
            int r10 = r0.s
            if (r10 >= r9) goto L_0x019f
            r9 = 1
            goto L_0x01a0
        L_0x019f:
            r9 = 0
        L_0x01a0:
            boolean unused = r4.f8001g = r9
        L_0x01a3:
            com.google.android.flexbox.FlexboxLayoutManager.a.g(r4)
            goto L_0x01ca
        L_0x01a7:
            boolean r9 = r18.a()
            if (r9 != 0) goto L_0x01be
            boolean r9 = r0.f7986h
            if (r9 == 0) goto L_0x01be
            int r9 = r0.t
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.f()
            int r9 = r9 - r10
            int unused = r4.f7999e = r9
            goto L_0x01ca
        L_0x01be:
            androidx.recyclerview.widget.u r9 = r0.p
            int r9 = r9.b()
            int r10 = r0.t
            int r9 = r9 + r10
            int unused = r4.f7999e = r9
        L_0x01ca:
            r9 = 1
            goto L_0x01d1
        L_0x01cc:
            r0.s = r6
            r0.t = r5
        L_0x01d0:
            r9 = 0
        L_0x01d1:
            if (r9 != 0) goto L_0x0245
            int r9 = r18.getChildCount()
            if (r9 == 0) goto L_0x0239
            boolean r9 = r4.f8001g
            if (r9 == 0) goto L_0x01e8
            int r9 = r20.a()
            android.view.View r9 = r0.g(r9)
            goto L_0x01f0
        L_0x01e8:
            int r9 = r20.a()
            android.view.View r9 = r0.f((int) r9)
        L_0x01f0:
            if (r9 == 0) goto L_0x0239
            com.google.android.flexbox.FlexboxLayoutManager.a.a((com.google.android.flexbox.FlexboxLayoutManager.a) r4, (android.view.View) r9)
            boolean r10 = r2.f4096g
            if (r10 != 0) goto L_0x0237
            boolean r10 = r18.supportsPredictiveItemAnimations()
            if (r10 == 0) goto L_0x0237
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.a((android.view.View) r9)
            androidx.recyclerview.widget.u r11 = r0.p
            int r11 = r11.c()
            if (r10 >= r11) goto L_0x021e
            androidx.recyclerview.widget.u r10 = r0.p
            int r9 = r10.b((android.view.View) r9)
            androidx.recyclerview.widget.u r10 = r0.p
            int r10 = r10.b()
            if (r9 >= r10) goto L_0x021c
            goto L_0x021e
        L_0x021c:
            r9 = 0
            goto L_0x021f
        L_0x021e:
            r9 = 1
        L_0x021f:
            if (r9 == 0) goto L_0x0237
            boolean r9 = r4.f8001g
            if (r9 == 0) goto L_0x022e
            androidx.recyclerview.widget.u r9 = r0.p
            int r9 = r9.c()
            goto L_0x0234
        L_0x022e:
            androidx.recyclerview.widget.u r9 = r0.p
            int r9 = r9.b()
        L_0x0234:
            int unused = r4.f7999e = r9
        L_0x0237:
            r9 = 1
            goto L_0x023a
        L_0x0239:
            r9 = 0
        L_0x023a:
            if (r9 != 0) goto L_0x0245
            com.google.android.flexbox.FlexboxLayoutManager.a.g(r4)
            int unused = r4.f7997c = r7
            int unused = r4.f7998d = r7
        L_0x0245:
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            boolean unused = r4.f8002h = true
        L_0x024a:
            r18.detachAndScrapAttachedViews(r19)
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            boolean r4 = r4.f8001g
            if (r4 == 0) goto L_0x025b
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            r0.b((com.google.android.flexbox.FlexboxLayoutManager.a) r4, (boolean) r7, (boolean) r8)
            goto L_0x0260
        L_0x025b:
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            r0.a((com.google.android.flexbox.FlexboxLayoutManager.a) r4, (boolean) r7, (boolean) r8)
        L_0x0260:
            int r4 = r18.getWidth()
            int r9 = r18.getWidthMode()
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r9)
            int r9 = r18.getHeight()
            int r10 = r18.getHeightMode()
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r10 = r18.getWidth()
            int r11 = r18.getHeight()
            boolean r12 = r18.a()
            if (r12 == 0) goto L_0x02a7
            int r12 = r0.u
            if (r12 == r5) goto L_0x028e
            if (r12 == r10) goto L_0x028e
            r5 = 1
            goto L_0x028f
        L_0x028e:
            r5 = 0
        L_0x028f:
            com.google.android.flexbox.FlexboxLayoutManager$b r12 = r0.n
            boolean r12 = r12.f8005b
            if (r12 == 0) goto L_0x02a2
            android.content.Context r12 = r0.y
            android.content.res.Resources r12 = r12.getResources()
            android.util.DisplayMetrics r12 = r12.getDisplayMetrics()
            int r12 = r12.heightPixels
            goto L_0x02c7
        L_0x02a2:
            com.google.android.flexbox.FlexboxLayoutManager$b r12 = r0.n
            int r12 = r12.f8004a
            goto L_0x02c7
        L_0x02a7:
            int r12 = r0.v
            if (r12 == r5) goto L_0x02af
            if (r12 == r11) goto L_0x02af
            r5 = 1
            goto L_0x02b0
        L_0x02af:
            r5 = 0
        L_0x02b0:
            com.google.android.flexbox.FlexboxLayoutManager$b r12 = r0.n
            boolean r12 = r12.f8005b
            if (r12 == 0) goto L_0x02c3
            android.content.Context r12 = r0.y
            android.content.res.Resources r12 = r12.getResources()
            android.util.DisplayMetrics r12 = r12.getDisplayMetrics()
            int r12 = r12.widthPixels
            goto L_0x02c7
        L_0x02c3:
            com.google.android.flexbox.FlexboxLayoutManager$b r12 = r0.n
            int r12 = r12.f8004a
        L_0x02c7:
            r14 = r12
            r0.u = r10
            r0.v = r11
            int r10 = r0.A
            if (r10 != r6) goto L_0x0353
            int r10 = r0.s
            if (r10 != r6) goto L_0x02d6
            if (r5 == 0) goto L_0x0353
        L_0x02d6:
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            boolean r3 = r3.f8001g
            if (r3 != 0) goto L_0x03f2
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r3.clear()
            boolean r3 = f7979a
            if (r3 != 0) goto L_0x02f4
            com.google.android.flexbox.c r3 = r0.k
            int[] r3 = r3.f8023a
            if (r3 == 0) goto L_0x02ee
            goto L_0x02f4
        L_0x02ee:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x02f4:
            com.google.android.flexbox.c$a r3 = r0.B
            r3.a()
            boolean r3 = r18.a()
            if (r3 == 0) goto L_0x0313
            com.google.android.flexbox.c r10 = r0.k
            com.google.android.flexbox.c$a r11 = r0.B
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            int r15 = r3.f7997c
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r12 = r4
            r13 = r9
            r16 = r3
            r10.b((com.google.android.flexbox.c.a) r11, (int) r12, (int) r13, (int) r14, (int) r15, (java.util.List<com.google.android.flexbox.b>) r16)
            goto L_0x0326
        L_0x0313:
            com.google.android.flexbox.c r10 = r0.k
            com.google.android.flexbox.c$a r11 = r0.B
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            int r15 = r3.f7997c
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r12 = r4
            r13 = r9
            r16 = r3
            r10.d(r11, r12, r13, r14, r15, r16)
        L_0x0326:
            com.google.android.flexbox.c$a r3 = r0.B
            java.util.List<com.google.android.flexbox.b> r3 = r3.f8028a
            r0.j = r3
            com.google.android.flexbox.c r3 = r0.k
            r3.a((int) r4, (int) r9)
            com.google.android.flexbox.c r3 = r0.k
            r3.a()
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            com.google.android.flexbox.c r4 = r0.k
            int[] r4 = r4.f8023a
            com.google.android.flexbox.FlexboxLayoutManager$a r5 = r0.o
            int r5 = r5.f7997c
            r4 = r4[r5]
            int unused = r3.f7998d = r4
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            int r4 = r4.f7998d
            r3.f8006c = r4
            goto L_0x03f2
        L_0x0353:
            int r5 = r0.A
            if (r5 == r6) goto L_0x0362
            com.google.android.flexbox.FlexboxLayoutManager$a r6 = r0.o
            int r6 = r6.f7997c
            int r5 = java.lang.Math.min(r5, r6)
            goto L_0x0368
        L_0x0362:
            com.google.android.flexbox.FlexboxLayoutManager$a r5 = r0.o
            int r5 = r5.f7997c
        L_0x0368:
            com.google.android.flexbox.c$a r6 = r0.B
            r6.a()
            boolean r6 = r18.a()
            if (r6 == 0) goto L_0x03ab
            java.util.List<com.google.android.flexbox.b> r6 = r0.j
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0397
            com.google.android.flexbox.c r3 = r0.k
            java.util.List<com.google.android.flexbox.b> r6 = r0.j
            r3.a((java.util.List<com.google.android.flexbox.b>) r6, (int) r5)
            com.google.android.flexbox.c r10 = r0.k
            com.google.android.flexbox.c$a r11 = r0.B
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            int r16 = r3.f7997c
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r12 = r4
            r13 = r9
            r15 = r5
            r17 = r3
            r10.a((com.google.android.flexbox.c.a) r11, (int) r12, (int) r13, (int) r14, (int) r15, (int) r16, (java.util.List<com.google.android.flexbox.b>) r17)
            goto L_0x03e2
        L_0x0397:
            com.google.android.flexbox.c r6 = r0.k
            r6.d((int) r3)
            com.google.android.flexbox.c r10 = r0.k
            com.google.android.flexbox.c$a r11 = r0.B
            r15 = 0
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r12 = r4
            r13 = r9
            r16 = r3
            r10.a((com.google.android.flexbox.c.a) r11, (int) r12, (int) r13, (int) r14, (int) r15, (java.util.List<com.google.android.flexbox.b>) r16)
            goto L_0x03e2
        L_0x03ab:
            java.util.List<com.google.android.flexbox.b> r6 = r0.j
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x03cf
            com.google.android.flexbox.c r3 = r0.k
            java.util.List<com.google.android.flexbox.b> r6 = r0.j
            r3.a((java.util.List<com.google.android.flexbox.b>) r6, (int) r5)
            com.google.android.flexbox.c r10 = r0.k
            com.google.android.flexbox.c$a r11 = r0.B
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            int r16 = r3.f7997c
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r12 = r9
            r13 = r4
            r15 = r5
            r17 = r3
            r10.a((com.google.android.flexbox.c.a) r11, (int) r12, (int) r13, (int) r14, (int) r15, (int) r16, (java.util.List<com.google.android.flexbox.b>) r17)
            goto L_0x03e2
        L_0x03cf:
            com.google.android.flexbox.c r6 = r0.k
            r6.d((int) r3)
            com.google.android.flexbox.c r10 = r0.k
            com.google.android.flexbox.c$a r11 = r0.B
            r15 = 0
            java.util.List<com.google.android.flexbox.b> r3 = r0.j
            r12 = r4
            r13 = r9
            r16 = r3
            r10.c(r11, r12, r13, r14, r15, r16)
        L_0x03e2:
            com.google.android.flexbox.c$a r3 = r0.B
            java.util.List<com.google.android.flexbox.b> r3 = r3.f8028a
            r0.j = r3
            com.google.android.flexbox.c r3 = r0.k
            r3.a((int) r4, (int) r9, (int) r5)
            com.google.android.flexbox.c r3 = r0.k
            r3.a((int) r5)
        L_0x03f2:
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            boolean r3 = r3.f8001g
            if (r3 == 0) goto L_0x0412
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (com.google.android.flexbox.FlexboxLayoutManager.b) r3)
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            int r3 = r3.f8008e
            com.google.android.flexbox.FlexboxLayoutManager$a r4 = r0.o
            r0.a((com.google.android.flexbox.FlexboxLayoutManager.a) r4, (boolean) r8, (boolean) r7)
            com.google.android.flexbox.FlexboxLayoutManager$b r4 = r0.n
            r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (com.google.android.flexbox.FlexboxLayoutManager.b) r4)
            com.google.android.flexbox.FlexboxLayoutManager$b r4 = r0.n
            int r4 = r4.f8008e
            goto L_0x0429
        L_0x0412:
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (com.google.android.flexbox.FlexboxLayoutManager.b) r3)
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            int r4 = r3.f8008e
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            r0.b((com.google.android.flexbox.FlexboxLayoutManager.a) r3, (boolean) r8, (boolean) r7)
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (com.google.android.flexbox.FlexboxLayoutManager.b) r3)
            com.google.android.flexbox.FlexboxLayoutManager$b r3 = r0.n
            int r3 = r3.f8008e
        L_0x0429:
            int r5 = r18.getChildCount()
            if (r5 <= 0) goto L_0x0448
            com.google.android.flexbox.FlexboxLayoutManager$a r5 = r0.o
            boolean r5 = r5.f8001g
            if (r5 == 0) goto L_0x0440
            int r4 = r0.b(r4, r1, r2, r8)
            int r3 = r3 + r4
            r0.a((int) r3, (androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (boolean) r7)
            return
        L_0x0440:
            int r3 = r0.a((int) r3, (androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (boolean) r8)
            int r4 = r4 + r3
            r0.b(r4, r1, r2, r7)
        L_0x0448:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s):void");
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z2) {
        int i3;
        int b2;
        if (a() || !this.f7986h) {
            int b3 = i2 - this.p.b();
            if (b3 <= 0) {
                return 0;
            }
            i3 = -a(b3, nVar, sVar);
        } else {
            int c2 = this.p.c() - i2;
            if (c2 <= 0) {
                return 0;
            }
            i3 = a(-c2, nVar, sVar);
        }
        int i4 = i2 + i3;
        if (!z2 || (b2 = i4 - this.p.b()) <= 0) {
            return i3;
        }
        this.p.a(-b2);
        return i3 - b2;
    }

    private int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z2) {
        int i3;
        int c2;
        if (!a() && this.f7986h) {
            int b2 = i2 - this.p.b();
            if (b2 <= 0) {
                return 0;
            }
            i3 = a(b2, nVar, sVar);
        } else {
            int c3 = this.p.c() - i2;
            if (c3 <= 0) {
                return 0;
            }
            i3 = -a(-c3, nVar, sVar);
        }
        int i4 = i2 + i3;
        if (!z2 || (c2 = this.p.c() - i4) <= 0) {
            return i3;
        }
        this.p.a(c2);
        return c2 + i3;
    }

    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.r = null;
        this.s = -1;
        this.t = Integer.MIN_VALUE;
        this.A = -1;
        a.b(this.o);
        this.x.clear();
    }

    private View f(int i2) {
        int i3;
        if (f7979a || this.k.f8023a != null) {
            View c2 = c(0, getChildCount(), i2);
            if (c2 == null || (i3 = this.k.f8023a[getPosition(c2)]) == -1) {
                return null;
            }
            return a(c2, this.j.get(i3));
        }
        throw new AssertionError();
    }

    private View g(int i2) {
        if (f7979a || this.k.f8023a != null) {
            View c2 = c(getChildCount() - 1, -1, i2);
            if (c2 == null) {
                return null;
            }
            return b(c2, this.j.get(this.k.f8023a[getPosition(c2)]));
        }
        throw new AssertionError();
    }

    private View c(int i2, int i3, int i4) {
        e();
        f();
        int b2 = this.p.b();
        int c2 = this.p.c();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).f4054c.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.p.a(childAt) >= b2 && this.p.b(childAt) <= c2) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private boolean a(View view, int i2) {
        return (a() || !this.f7986h) ? this.p.b(view) <= i2 : this.p.d() - this.p.a(view) <= i2;
    }

    private boolean b(View view, int i2) {
        return (a() || !this.f7986h) ? this.p.a(view) >= this.p.d() - i2 : this.p.b(view) <= i2;
    }

    private void a(RecyclerView.n nVar, int i2, int i3) {
        while (i3 >= i2) {
            removeAndRecycleViewAt(i3, nVar);
            i3--;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(com.google.android.flexbox.b r28, com.google.android.flexbox.FlexboxLayoutManager.b r29) {
        /*
            r27 = this;
            r0 = r27
            r9 = r28
            r10 = r29
            boolean r1 = f7979a
            if (r1 != 0) goto L_0x0017
            com.google.android.flexbox.c r1 = r0.k
            long[] r1 = r1.f8024b
            if (r1 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0017:
            int r1 = r27.getPaddingTop()
            int r2 = r27.getPaddingBottom()
            int r3 = r27.getHeight()
            int r4 = r10.f8008e
            int r5 = r10.f8008e
            int r6 = r10.f8012i
            r7 = -1
            if (r6 != r7) goto L_0x0032
            int r6 = r9.f8019g
            int r4 = r4 - r6
            int r6 = r9.f8019g
            int r5 = r5 + r6
        L_0x0032:
            r11 = r4
            r12 = r5
            int r13 = r10.f8007d
            int r4 = r0.f7983e
            r5 = 0
            r14 = 1
            if (r4 == 0) goto L_0x00c7
            if (r4 == r14) goto L_0x00b7
            r6 = 2
            r7 = 1073741824(0x40000000, float:2.0)
            if (r4 == r6) goto L_0x00a5
            r6 = 3
            if (r4 == r6) goto L_0x008f
            r6 = 4
            if (r4 == r6) goto L_0x0078
            r6 = 5
            if (r4 != r6) goto L_0x0062
            int r4 = r9.f8020h
            if (r4 == 0) goto L_0x005b
            int r4 = r9.f8017e
            int r4 = r3 - r4
            float r4 = (float) r4
            int r6 = r9.f8020h
            int r6 = r6 + r14
            float r6 = (float) r6
            float r4 = r4 / r6
            goto L_0x005c
        L_0x005b:
            r4 = 0
        L_0x005c:
            float r1 = (float) r1
            float r1 = r1 + r4
            int r3 = r3 - r2
            float r2 = (float) r3
            float r2 = r2 - r4
            goto L_0x00cb
        L_0x0062:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.<init>(r3)
            int r3 = r0.f7983e
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0078:
            int r4 = r9.f8020h
            if (r4 == 0) goto L_0x0086
            int r4 = r9.f8017e
            int r4 = r3 - r4
            float r4 = (float) r4
            int r6 = r9.f8020h
            float r6 = (float) r6
            float r4 = r4 / r6
            goto L_0x0087
        L_0x0086:
            r4 = 0
        L_0x0087:
            float r1 = (float) r1
            float r6 = r4 / r7
            float r1 = r1 + r6
            int r3 = r3 - r2
            float r2 = (float) r3
            float r2 = r2 - r6
            goto L_0x00cb
        L_0x008f:
            float r1 = (float) r1
            int r4 = r9.f8020h
            if (r4 == r14) goto L_0x0099
            int r4 = r9.f8020h
            int r4 = r4 - r14
            float r4 = (float) r4
            goto L_0x009b
        L_0x0099:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x009b:
            int r6 = r9.f8017e
            int r6 = r3 - r6
            float r6 = (float) r6
            float r4 = r6 / r4
            int r3 = r3 - r2
            float r2 = (float) r3
            goto L_0x00cb
        L_0x00a5:
            float r1 = (float) r1
            int r4 = r9.f8017e
            int r4 = r3 - r4
            float r4 = (float) r4
            float r4 = r4 / r7
            float r1 = r1 + r4
            int r2 = r3 - r2
            float r2 = (float) r2
            int r4 = r9.f8017e
            int r3 = r3 - r4
            float r3 = (float) r3
            float r3 = r3 / r7
            float r2 = r2 - r3
            goto L_0x00ca
        L_0x00b7:
            int r4 = r9.f8017e
            int r3 = r3 - r4
            int r3 = r3 + r2
            float r2 = (float) r3
            int r3 = r9.f8017e
            int r3 = r3 - r1
            float r1 = (float) r3
            r4 = 0
            r26 = r2
            r2 = r1
            r1 = r26
            goto L_0x00cb
        L_0x00c7:
            float r1 = (float) r1
            int r3 = r3 - r2
            float r2 = (float) r3
        L_0x00ca:
            r4 = 0
        L_0x00cb:
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            int r3 = r3.f8000f
            float r3 = (float) r3
            float r1 = r1 - r3
            com.google.android.flexbox.FlexboxLayoutManager$a r3 = r0.o
            int r3 = r3.f8000f
            float r3 = (float) r3
            float r2 = r2 - r3
            float r15 = java.lang.Math.max(r4, r5)
            r3 = 0
            int r8 = r9.f8020h
            r7 = r13
        L_0x00e3:
            int r4 = r13 + r8
            if (r7 >= r4) goto L_0x0225
            android.view.View r6 = r0.a((int) r7)
            if (r6 == 0) goto L_0x0218
            com.google.android.flexbox.c r4 = r0.k
            long[] r4 = r4.f8024b
            r16 = r4[r7]
            int r4 = com.google.android.flexbox.c.a((long) r16)
            int r5 = com.google.android.flexbox.c.b((long) r16)
            android.view.ViewGroup$LayoutParams r16 = r6.getLayoutParams()
            r14 = r16
            com.google.android.flexbox.FlexboxLayoutManager$LayoutParams r14 = (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) r14
            boolean r16 = r0.a((android.view.View) r6, (int) r4, (int) r5, (androidx.recyclerview.widget.RecyclerView.LayoutParams) r14)
            if (r16 == 0) goto L_0x010c
            r6.measure(r4, r5)
        L_0x010c:
            int r4 = r14.topMargin
            int r5 = r0.getTopDecorationHeight(r6)
            int r4 = r4 + r5
            float r4 = (float) r4
            float r16 = r1 + r4
            int r1 = r14.rightMargin
            int r4 = r0.getBottomDecorationHeight(r6)
            int r1 = r1 + r4
            float r1 = (float) r1
            float r18 = r2 - r1
            int r1 = r10.f8012i
            r5 = 1
            if (r1 != r5) goto L_0x012e
            android.graphics.Rect r1 = f7980b
            r0.calculateItemDecorationsForChild(r6, r1)
            r0.addView(r6)
            goto L_0x0138
        L_0x012e:
            android.graphics.Rect r1 = f7980b
            r0.calculateItemDecorationsForChild(r6, r1)
            r0.addView(r6, r3)
            int r3 = r3 + 1
        L_0x0138:
            r17 = r3
            int r1 = r0.getLeftDecorationWidth(r6)
            int r19 = r11 + r1
            int r1 = r0.getRightDecorationWidth(r6)
            int r20 = r12 - r1
            boolean r4 = r0.f7986h
            if (r4 == 0) goto L_0x01a4
            boolean r1 = r0.f7987i
            if (r1 == 0) goto L_0x017c
            com.google.android.flexbox.c r1 = r0.k
            int r2 = r6.getMeasuredWidth()
            int r19 = r20 - r2
            int r2 = java.lang.Math.round(r18)
            int r3 = r6.getMeasuredHeight()
            int r21 = r2 - r3
            int r22 = java.lang.Math.round(r18)
            r2 = r6
            r3 = r28
            r23 = 1
            r5 = r19
            r24 = r6
            r6 = r21
            r21 = r7
            r7 = r20
            r25 = r8
            r8 = r22
            r1.a((android.view.View) r2, (com.google.android.flexbox.b) r3, (boolean) r4, (int) r5, (int) r6, (int) r7, (int) r8)
            goto L_0x01ef
        L_0x017c:
            r24 = r6
            r21 = r7
            r25 = r8
            r23 = 1
            com.google.android.flexbox.c r1 = r0.k
            int r2 = r24.getMeasuredWidth()
            int r5 = r20 - r2
            int r6 = java.lang.Math.round(r16)
            int r2 = java.lang.Math.round(r16)
            int r3 = r24.getMeasuredHeight()
            int r8 = r2 + r3
            r2 = r24
            r3 = r28
            r7 = r20
            r1.a((android.view.View) r2, (com.google.android.flexbox.b) r3, (boolean) r4, (int) r5, (int) r6, (int) r7, (int) r8)
            goto L_0x01ef
        L_0x01a4:
            r24 = r6
            r21 = r7
            r25 = r8
            r23 = 1
            boolean r1 = r0.f7987i
            if (r1 == 0) goto L_0x01d0
            com.google.android.flexbox.c r1 = r0.k
            int r2 = java.lang.Math.round(r18)
            int r3 = r24.getMeasuredHeight()
            int r6 = r2 - r3
            int r2 = r24.getMeasuredWidth()
            int r7 = r19 + r2
            int r8 = java.lang.Math.round(r18)
            r2 = r24
            r3 = r28
            r5 = r19
            r1.a((android.view.View) r2, (com.google.android.flexbox.b) r3, (boolean) r4, (int) r5, (int) r6, (int) r7, (int) r8)
            goto L_0x01ef
        L_0x01d0:
            com.google.android.flexbox.c r1 = r0.k
            int r6 = java.lang.Math.round(r16)
            int r2 = r24.getMeasuredWidth()
            int r7 = r19 + r2
            int r2 = java.lang.Math.round(r16)
            int r3 = r24.getMeasuredHeight()
            int r8 = r2 + r3
            r2 = r24
            r3 = r28
            r5 = r19
            r1.a((android.view.View) r2, (com.google.android.flexbox.b) r3, (boolean) r4, (int) r5, (int) r6, (int) r7, (int) r8)
        L_0x01ef:
            int r1 = r24.getMeasuredHeight()
            int r2 = r14.topMargin
            int r1 = r1 + r2
            r2 = r24
            int r3 = r0.getBottomDecorationHeight(r2)
            int r1 = r1 + r3
            float r1 = (float) r1
            float r1 = r1 + r15
            float r16 = r16 + r1
            int r1 = r2.getMeasuredHeight()
            int r3 = r14.bottomMargin
            int r1 = r1 + r3
            int r2 = r0.getTopDecorationHeight(r2)
            int r1 = r1 + r2
            float r1 = (float) r1
            float r1 = r1 + r15
            float r18 = r18 - r1
            r1 = r16
            r3 = r17
            r2 = r18
            goto L_0x021e
        L_0x0218:
            r21 = r7
            r25 = r8
            r23 = 1
        L_0x021e:
            int r7 = r21 + 1
            r8 = r25
            r14 = 1
            goto L_0x00e3
        L_0x0225:
            int r1 = r10.f8006c
            com.google.android.flexbox.FlexboxLayoutManager$b r2 = r0.n
            int r2 = r2.f8012i
            int r1 = r1 + r2
            r10.f8006c = r1
            int r1 = r9.f8019g
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.a(com.google.android.flexbox.b, com.google.android.flexbox.FlexboxLayoutManager$b):int");
    }

    public final boolean a() {
        int i2 = this.f7981c;
        return i2 == 0 || i2 == 1;
    }

    private void a(a aVar, boolean z2, boolean z3) {
        if (z3) {
            d();
        } else {
            this.n.f8005b = false;
        }
        if (a() || !this.f7986h) {
            this.n.f8004a = this.p.c() - aVar.f7999e;
        } else {
            this.n.f8004a = aVar.f7999e - getPaddingRight();
        }
        this.n.f8007d = aVar.f7997c;
        b bVar = this.n;
        bVar.f8011h = 1;
        bVar.f8012i = 1;
        bVar.f8008e = aVar.f7999e;
        b bVar2 = this.n;
        bVar2.f8009f = Integer.MIN_VALUE;
        bVar2.f8006c = aVar.f7998d;
        if (z2 && this.j.size() > 1 && aVar.f7998d >= 0 && aVar.f7998d < this.j.size() - 1) {
            b.a(this.n);
            this.n.f8007d += this.j.get(aVar.f7998d).f8020h;
        }
    }

    private void b(a aVar, boolean z2, boolean z3) {
        if (z3) {
            d();
        } else {
            this.n.f8005b = false;
        }
        if (a() || !this.f7986h) {
            this.n.f8004a = aVar.f7999e - this.p.b();
        } else {
            this.n.f8004a = (this.z.getWidth() - aVar.f7999e) - this.p.b();
        }
        this.n.f8007d = aVar.f7997c;
        b bVar = this.n;
        bVar.f8011h = 1;
        bVar.f8012i = -1;
        bVar.f8008e = aVar.f7999e;
        b bVar2 = this.n;
        bVar2.f8009f = Integer.MIN_VALUE;
        bVar2.f8006c = aVar.f7998d;
        if (z2 && aVar.f7998d > 0 && this.j.size() > aVar.f7998d) {
            b.b(this.n);
            this.n.f8007d -= this.j.get(aVar.f7998d).f8020h;
        }
    }

    private void d() {
        int i2;
        if (a()) {
            i2 = getHeightMode();
        } else {
            i2 = getWidthMode();
        }
        this.n.f8005b = i2 == 0 || i2 == Integer.MIN_VALUE;
    }

    private void e() {
        if (this.p == null) {
            if (a()) {
                if (this.f7982d != 0) {
                    this.p = u.b((RecyclerView.LayoutManager) this);
                    this.q = u.a((RecyclerView.LayoutManager) this);
                    return;
                }
            } else if (this.f7982d == 0) {
                this.p = u.b((RecyclerView.LayoutManager) this);
                this.q = u.a((RecyclerView.LayoutManager) this);
                return;
            }
            this.p = u.a((RecyclerView.LayoutManager) this);
            this.q = u.b((RecyclerView.LayoutManager) this);
        }
    }

    private void f() {
        if (this.n == null) {
            this.n = new b((byte) 0);
        }
    }

    public void scrollToPosition(int i2) {
        this.s = i2;
        this.t = Integer.MIN_VALUE;
        SavedState savedState = this.r;
        if (savedState != null) {
            savedState.f7993a = -1;
        }
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        p pVar = new p(recyclerView.getContext());
        pVar.setTargetPosition(i2);
        startSmoothScroll(pVar);
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.z = (View) recyclerView.getParent();
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.onDetachedFromWindow(recyclerView, nVar);
        if (this.w) {
            removeAndRecycleAllViews(nVar);
            nVar.a();
        }
    }

    public boolean canScrollHorizontally() {
        return !a() || getWidth() > this.z.getWidth();
    }

    public boolean canScrollVertically() {
        return a() || getHeight() > this.z.getHeight();
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (!a()) {
            int a2 = a(i2, nVar, sVar);
            this.x.clear();
            return a2;
        }
        int h2 = h(i2);
        a aVar = this.o;
        int unused = aVar.f8000f = aVar.f8000f + h2;
        this.q.a(-h2);
        return h2;
    }

    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (a()) {
            int a2 = a(i2, nVar, sVar);
            this.x.clear();
            return a2;
        }
        int h2 = h(i2);
        a aVar = this.o;
        int unused = aVar.f8000f = aVar.f8000f + h2;
        this.q.a(-h2);
        return h2;
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        e();
        int i3 = 1;
        this.n.j = true;
        boolean z2 = !a() && this.f7986h;
        if (!z2 ? i2 <= 0 : i2 >= 0) {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        a(i3, abs);
        int a2 = this.n.f8009f + a(nVar, sVar, this.n);
        if (a2 < 0) {
            return 0;
        }
        if (z2) {
            if (abs > a2) {
                i2 = (-i3) * a2;
            }
        } else if (abs > a2) {
            i2 = i3 * a2;
        }
        this.p.a(-i2);
        this.n.f8010g = i2;
        return i2;
    }

    private int h(int i2) {
        int i3;
        boolean z2 = false;
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        e();
        boolean a2 = a();
        View view = this.z;
        int width = a2 ? view.getWidth() : view.getHeight();
        int width2 = a2 ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            z2 = true;
        }
        if (z2) {
            int abs = Math.abs(i2);
            if (i2 < 0) {
                i3 = Math.min((width2 + this.o.f8000f) - width, abs);
            } else if (this.o.f8000f + i2 <= 0) {
                return i2;
            } else {
                i3 = this.o.f8000f;
            }
        } else if (i2 > 0) {
            return Math.min((width2 - this.o.f8000f) - width, i2);
        } else {
            if (this.o.f8000f + i2 >= 0) {
                return i2;
            }
            i3 = this.o.f8000f;
        }
        return -i3;
    }

    private void a(int i2, int i3) {
        if (f7979a || this.k.f8023a != null) {
            this.n.f8012i = i2;
            boolean a2 = a();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
            int i4 = 0;
            boolean z2 = !a2 && this.f7986h;
            if (i2 == 1) {
                View childAt = getChildAt(getChildCount() - 1);
                this.n.f8008e = this.p.b(childAt);
                int position = getPosition(childAt);
                View b2 = b(childAt, this.j.get(this.k.f8023a[position]));
                b bVar = this.n;
                bVar.f8011h = 1;
                bVar.f8007d = position + bVar.f8011h;
                if (this.k.f8023a.length <= this.n.f8007d) {
                    this.n.f8006c = -1;
                } else {
                    this.n.f8006c = this.k.f8023a[this.n.f8007d];
                }
                if (z2) {
                    this.n.f8008e = this.p.a(b2);
                    this.n.f8009f = (-this.p.a(b2)) + this.p.b();
                    b bVar2 = this.n;
                    if (bVar2.f8009f >= 0) {
                        i4 = this.n.f8009f;
                    }
                    bVar2.f8009f = i4;
                } else {
                    this.n.f8008e = this.p.b(b2);
                    this.n.f8009f = this.p.b(b2) - this.p.c();
                }
                if ((this.n.f8006c == -1 || this.n.f8006c > this.j.size() - 1) && this.n.f8007d <= getFlexItemCount()) {
                    int i5 = i3 - this.n.f8009f;
                    this.B.a();
                    if (i5 > 0) {
                        if (a2) {
                            this.k.a(this.B, makeMeasureSpec, makeMeasureSpec2, i5, this.n.f8007d, this.j);
                        } else {
                            this.k.c(this.B, makeMeasureSpec, makeMeasureSpec2, i5, this.n.f8007d, this.j);
                        }
                        this.k.a(makeMeasureSpec, makeMeasureSpec2, this.n.f8007d);
                        this.k.a(this.n.f8007d);
                    }
                }
            } else {
                View childAt2 = getChildAt(0);
                this.n.f8008e = this.p.a(childAt2);
                int position2 = getPosition(childAt2);
                View a3 = a(childAt2, this.j.get(this.k.f8023a[position2]));
                this.n.f8011h = 1;
                int i6 = this.k.f8023a[position2];
                if (i6 == -1) {
                    i6 = 0;
                }
                if (i6 > 0) {
                    this.n.f8007d = position2 - this.j.get(i6 - 1).f8020h;
                } else {
                    this.n.f8007d = -1;
                }
                this.n.f8006c = i6 > 0 ? i6 - 1 : 0;
                if (z2) {
                    this.n.f8008e = this.p.b(a3);
                    this.n.f8009f = this.p.b(a3) - this.p.c();
                    b bVar3 = this.n;
                    if (bVar3.f8009f >= 0) {
                        i4 = this.n.f8009f;
                    }
                    bVar3.f8009f = i4;
                } else {
                    this.n.f8008e = this.p.a(a3);
                    this.n.f8009f = (-this.p.a(a3)) + this.p.b();
                }
            }
            b bVar4 = this.n;
            bVar4.f8004a = i3 - bVar4.f8009f;
            return;
        }
        throw new AssertionError();
    }

    private View a(View view, b bVar) {
        boolean a2 = a();
        int i2 = bVar.f8020h;
        for (int i3 = 1; i3 < i2; i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.f7986h || a2) {
                    if (this.p.a(view) <= this.p.a(childAt)) {
                    }
                } else if (this.p.b(view) >= this.p.b(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    private View b(View view, b bVar) {
        boolean a2 = a();
        int childCount = (getChildCount() - bVar.f8020h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.f7986h || a2) {
                    if (this.p.b(view) >= this.p.b(childAt)) {
                    }
                } else if (this.p.a(view) <= this.p.a(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        return a(sVar);
    }

    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        return a(sVar);
    }

    private int a(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int a2 = sVar.a();
        e();
        View f2 = f(a2);
        View g2 = g(a2);
        if (sVar.a() == 0 || f2 == null || g2 == null) {
            return 0;
        }
        return Math.min(this.p.e(), this.p.b(g2) - this.p.a(f2));
    }

    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        b(sVar);
        return b(sVar);
    }

    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        return b(sVar);
    }

    private int b(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int a2 = sVar.a();
        View f2 = f(a2);
        View g2 = g(a2);
        if (!(sVar.a() == 0 || f2 == null || g2 == null)) {
            if (f7979a || this.k.f8023a != null) {
                int position = getPosition(f2);
                int position2 = getPosition(g2);
                int abs = Math.abs(this.p.b(g2) - this.p.a(f2));
                int i2 = this.k.f8023a[position];
                if (!(i2 == 0 || i2 == -1)) {
                    return Math.round((((float) i2) * (((float) abs) / ((float) ((this.k.f8023a[position2] - i2) + 1)))) + ((float) (this.p.b() - this.p.a(f2))));
                }
            } else {
                throw new AssertionError();
            }
        }
        return 0;
    }

    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        return c(sVar);
    }

    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        return c(sVar);
    }

    private int c(RecyclerView.s sVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        int a2 = sVar.a();
        View f2 = f(a2);
        View g2 = g(a2);
        if (sVar.a() == 0 || f2 == null || g2 == null) {
            return 0;
        }
        if (f7979a || this.k.f8023a != null) {
            int h2 = h();
            return (int) ((((float) Math.abs(this.p.b(g2) - this.p.a(f2))) / ((float) ((i() - h2) + 1))) * ((float) sVar.a()));
        }
        throw new AssertionError();
    }

    private boolean a(View view, int i2, int i3, RecyclerView.LayoutParams layoutParams) {
        return view.isLayoutRequested() || !isMeasurementCacheEnabled() || !d(view.getWidth(), i2, layoutParams.width) || !d(view.getHeight(), i3, layoutParams.height);
    }

    private static boolean d(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i2;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i2;
        }
        return true;
    }

    private void g() {
        this.j.clear();
        a.b(this.o);
        int unused = this.o.f8000f = 0;
    }

    private boolean b(View view) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int decoratedLeft = getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
        int decoratedTop = getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        return (decoratedLeft >= width || getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin >= paddingLeft) && (decoratedTop >= height || getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin >= paddingTop);
    }

    private int h() {
        View b2 = b(0, getChildCount());
        if (b2 == null) {
            return -1;
        }
        return getPosition(b2);
    }

    private int i() {
        View b2 = b(getChildCount() - 1, -1);
        if (b2 == null) {
            return -1;
        }
        return getPosition(b2);
    }

    private View b(int i2, int i3) {
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (b(childAt)) {
                return childAt;
            }
            i2 += i4;
        }
        return null;
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new LayoutParams[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private float f7988a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        private float f7989b = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        private int f7990g = -1;

        /* renamed from: h  reason: collision with root package name */
        private float f7991h = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        private int f7992i;
        private int j;
        private int k = 16777215;
        private int l = 16777215;
        private boolean m;

        public final int c() {
            return 1;
        }

        public int describeContents() {
            return 0;
        }

        public final int k_() {
            return this.width;
        }

        public final int b() {
            return this.height;
        }

        public final float d() {
            return this.f7988a;
        }

        public final float e() {
            return this.f7989b;
        }

        public final int f() {
            return this.f7990g;
        }

        public final int g() {
            return this.f7992i;
        }

        public final int h() {
            return this.j;
        }

        public final int i() {
            return this.k;
        }

        public final int j() {
            return this.l;
        }

        public final boolean k() {
            return this.m;
        }

        public final float l() {
            return this.f7991h;
        }

        public final int m() {
            return this.leftMargin;
        }

        public final int n() {
            return this.topMargin;
        }

        public final int o() {
            return this.rightMargin;
        }

        public final int p() {
            return this.bottomMargin;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.f7988a);
            parcel.writeFloat(this.f7989b);
            parcel.writeInt(this.f7990g);
            parcel.writeFloat(this.f7991h);
            parcel.writeInt(this.f7992i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeByte(this.m ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f7988a = parcel.readFloat();
            this.f7989b = parcel.readFloat();
            this.f7990g = parcel.readInt();
            this.f7991h = parcel.readFloat();
            this.f7992i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f7995a = (!FlexboxLayoutManager.class.desiredAssertionStatus());
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f7997c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f7998d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f7999e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f8000f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public boolean f8001g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f8002h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f8003i;

        private a() {
            this.f8000f = 0;
        }

        /* synthetic */ a(FlexboxLayoutManager flexboxLayoutManager, byte b2) {
            this();
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f7997c + ", mFlexLinePosition=" + this.f7998d + ", mCoordinate=" + this.f7999e + ", mPerpendicularCoordinate=" + this.f8000f + ", mLayoutFromEnd=" + this.f8001g + ", mValid=" + this.f8002h + ", mAssignedFromSavedState=" + this.f8003i + '}';
        }

        static /* synthetic */ void b(a aVar) {
            aVar.f7997c = -1;
            aVar.f7998d = -1;
            aVar.f7999e = Integer.MIN_VALUE;
            boolean z = false;
            aVar.f8002h = false;
            aVar.f8003i = false;
            if (FlexboxLayoutManager.this.a()) {
                if (FlexboxLayoutManager.this.f7982d == 0) {
                    if (FlexboxLayoutManager.this.f7981c == 1) {
                        z = true;
                    }
                    aVar.f8001g = z;
                    return;
                }
                if (FlexboxLayoutManager.this.f7982d == 2) {
                    z = true;
                }
                aVar.f8001g = z;
            } else if (FlexboxLayoutManager.this.f7982d == 0) {
                if (FlexboxLayoutManager.this.f7981c == 3) {
                    z = true;
                }
                aVar.f8001g = z;
            } else {
                if (FlexboxLayoutManager.this.f7982d == 2) {
                    z = true;
                }
                aVar.f8001g = z;
            }
        }

        static /* synthetic */ void g(a aVar) {
            int i2;
            int i3;
            if (FlexboxLayoutManager.this.a() || !FlexboxLayoutManager.this.f7986h) {
                if (aVar.f8001g) {
                    i2 = FlexboxLayoutManager.this.p.c();
                } else {
                    i2 = FlexboxLayoutManager.this.p.b();
                }
                aVar.f7999e = i2;
                return;
            }
            if (aVar.f8001g) {
                i3 = FlexboxLayoutManager.this.p.c();
            } else {
                i3 = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.p.b();
            }
            aVar.f7999e = i3;
        }

        static /* synthetic */ void a(a aVar, View view) {
            if (FlexboxLayoutManager.this.a() || !FlexboxLayoutManager.this.f7986h) {
                if (aVar.f8001g) {
                    aVar.f7999e = FlexboxLayoutManager.this.p.b(view) + FlexboxLayoutManager.this.p.a();
                } else {
                    aVar.f7999e = FlexboxLayoutManager.this.p.a(view);
                }
            } else if (aVar.f8001g) {
                aVar.f7999e = FlexboxLayoutManager.this.p.a(view) + FlexboxLayoutManager.this.p.a();
            } else {
                aVar.f7999e = FlexboxLayoutManager.this.p.b(view);
            }
            aVar.f7997c = FlexboxLayoutManager.this.getPosition(view);
            int i2 = 0;
            aVar.f8003i = false;
            if (f7995a || FlexboxLayoutManager.this.k.f8023a != null) {
                int[] iArr = FlexboxLayoutManager.this.k.f8023a;
                int i3 = aVar.f7997c;
                if (i3 == -1) {
                    i3 = 0;
                }
                int i4 = iArr[i3];
                if (i4 != -1) {
                    i2 = i4;
                }
                aVar.f7998d = i2;
                if (FlexboxLayoutManager.this.j.size() > aVar.f7998d) {
                    aVar.f7997c = ((b) FlexboxLayoutManager.this.j.get(aVar.f7998d)).o;
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f8004a;

        /* renamed from: b  reason: collision with root package name */
        boolean f8005b;

        /* renamed from: c  reason: collision with root package name */
        int f8006c;

        /* renamed from: d  reason: collision with root package name */
        int f8007d;

        /* renamed from: e  reason: collision with root package name */
        int f8008e;

        /* renamed from: f  reason: collision with root package name */
        int f8009f;

        /* renamed from: g  reason: collision with root package name */
        int f8010g;

        /* renamed from: h  reason: collision with root package name */
        int f8011h;

        /* renamed from: i  reason: collision with root package name */
        int f8012i;
        boolean j;

        private b() {
            this.f8011h = 1;
            this.f8012i = 1;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        static /* synthetic */ int a(b bVar) {
            int i2 = bVar.f8006c;
            bVar.f8006c = i2 + 1;
            return i2;
        }

        static /* synthetic */ int b(b bVar) {
            int i2 = bVar.f8006c;
            bVar.f8006c = i2 - 1;
            return i2;
        }

        public final String toString() {
            return "LayoutState{mAvailable=" + this.f8004a + ", mFlexLinePosition=" + this.f8006c + ", mPosition=" + this.f8007d + ", mOffset=" + this.f8008e + ", mScrollingOffset=" + this.f8009f + ", mLastScrollDelta=" + this.f8010g + ", mItemDirection=" + this.f8011h + ", mLayoutDirection=" + this.f8012i + '}';
        }
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f7993a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f7994b;

        public int describeContents() {
            return 0;
        }

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        /* synthetic */ SavedState(SavedState savedState, byte b2) {
            this(savedState);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f7993a);
            parcel.writeInt(this.f7994b);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.f7993a = parcel.readInt();
            this.f7994b = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.f7993a = savedState.f7993a;
            this.f7994b = savedState.f7994b;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f7993a + ", mAnchorOffset=" + this.f7994b + '}';
        }

        static /* synthetic */ boolean c(SavedState savedState, int i2) {
            int i3 = savedState.f7993a;
            return i3 >= 0 && i3 < i2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(androidx.recyclerview.widget.RecyclerView.n r29, androidx.recyclerview.widget.RecyclerView.s r30, com.google.android.flexbox.FlexboxLayoutManager.b r31) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r31
            int r3 = r2.f8009f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x001a
            int r3 = r2.f8004a
            if (r3 >= 0) goto L_0x0017
            int r3 = r2.f8009f
            int r5 = r2.f8004a
            int r3 = r3 + r5
            r2.f8009f = r3
        L_0x0017:
            r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (com.google.android.flexbox.FlexboxLayoutManager.b) r2)
        L_0x001a:
            int r3 = r2.f8004a
            int r5 = r2.f8004a
            boolean r6 = r28.a()
            r8 = 0
        L_0x0023:
            if (r5 > 0) goto L_0x0030
            com.google.android.flexbox.FlexboxLayoutManager$b r9 = r0.n
            boolean r9 = r9.f8005b
            if (r9 == 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            r20 = r3
            goto L_0x0257
        L_0x0030:
            java.util.List<com.google.android.flexbox.b> r9 = r0.j
            int r10 = r2.f8007d
            r11 = 1
            if (r10 < 0) goto L_0x004d
            int r10 = r2.f8007d
            int r12 = r30.a()
            if (r10 >= r12) goto L_0x004d
            int r10 = r2.f8006c
            if (r10 < 0) goto L_0x004d
            int r10 = r2.f8006c
            int r9 = r9.size()
            if (r10 >= r9) goto L_0x004d
            r9 = 1
            goto L_0x004e
        L_0x004d:
            r9 = 0
        L_0x004e:
            if (r9 == 0) goto L_0x002c
            java.util.List<com.google.android.flexbox.b> r9 = r0.j
            int r10 = r2.f8006c
            java.lang.Object r9 = r9.get(r10)
            com.google.android.flexbox.b r9 = (com.google.android.flexbox.b) r9
            int r10 = r9.o
            r2.f8007d = r10
            boolean r10 = r28.a()
            if (r10 == 0) goto L_0x022a
            boolean r10 = f7979a
            if (r10 != 0) goto L_0x0075
            com.google.android.flexbox.c r10 = r0.k
            long[] r10 = r10.f8024b
            if (r10 == 0) goto L_0x006f
            goto L_0x0075
        L_0x006f:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0075:
            int r10 = r28.getPaddingLeft()
            int r12 = r28.getPaddingRight()
            int r13 = r28.getWidth()
            int r14 = r2.f8008e
            int r15 = r2.f8012i
            r7 = -1
            if (r15 != r7) goto L_0x008b
            int r7 = r9.f8019g
            int r14 = r14 - r7
        L_0x008b:
            r7 = r14
            int r15 = r2.f8007d
            int r14 = r0.f7983e
            if (r14 == 0) goto L_0x011b
            if (r14 == r11) goto L_0x0110
            r4 = 2
            r17 = 1073741824(0x40000000, float:2.0)
            if (r14 == r4) goto L_0x00fb
            r4 = 3
            if (r14 == r4) goto L_0x00e5
            r4 = 4
            if (r14 == r4) goto L_0x00ce
            r4 = 5
            if (r14 != r4) goto L_0x00b8
            int r4 = r9.f8020h
            if (r4 == 0) goto L_0x00b1
            int r4 = r9.f8017e
            int r4 = r13 - r4
            float r4 = (float) r4
            int r14 = r9.f8020h
            int r14 = r14 + r11
            float r14 = (float) r14
            float r4 = r4 / r14
            goto L_0x00b2
        L_0x00b1:
            r4 = 0
        L_0x00b2:
            float r10 = (float) r10
            float r10 = r10 + r4
            int r13 = r13 - r12
            float r12 = (float) r13
            float r12 = r12 - r4
            goto L_0x011f
        L_0x00b8:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.<init>(r3)
            int r3 = r0.f7983e
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00ce:
            int r4 = r9.f8020h
            if (r4 == 0) goto L_0x00dc
            int r4 = r9.f8017e
            int r4 = r13 - r4
            float r4 = (float) r4
            int r14 = r9.f8020h
            float r14 = (float) r14
            float r4 = r4 / r14
            goto L_0x00dd
        L_0x00dc:
            r4 = 0
        L_0x00dd:
            float r10 = (float) r10
            float r14 = r4 / r17
            float r10 = r10 + r14
            int r13 = r13 - r12
            float r12 = (float) r13
            float r12 = r12 - r14
            goto L_0x011f
        L_0x00e5:
            float r10 = (float) r10
            int r4 = r9.f8020h
            if (r4 == r11) goto L_0x00ef
            int r4 = r9.f8020h
            int r4 = r4 - r11
            float r4 = (float) r4
            goto L_0x00f1
        L_0x00ef:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x00f1:
            int r14 = r9.f8017e
            int r14 = r13 - r14
            float r14 = (float) r14
            float r4 = r14 / r4
            int r13 = r13 - r12
            float r12 = (float) r13
            goto L_0x011f
        L_0x00fb:
            float r4 = (float) r10
            int r10 = r9.f8017e
            int r10 = r13 - r10
            float r10 = (float) r10
            float r10 = r10 / r17
            float r10 = r10 + r4
            int r4 = r13 - r12
            float r4 = (float) r4
            int r12 = r9.f8017e
            int r13 = r13 - r12
            float r12 = (float) r13
            float r12 = r12 / r17
            float r12 = r4 - r12
            goto L_0x011e
        L_0x0110:
            int r4 = r9.f8017e
            int r13 = r13 - r4
            int r13 = r13 + r12
            float r4 = (float) r13
            int r12 = r9.f8017e
            int r12 = r12 - r10
            float r12 = (float) r12
            r10 = r4
            goto L_0x011e
        L_0x011b:
            float r10 = (float) r10
            int r13 = r13 - r12
            float r12 = (float) r13
        L_0x011e:
            r4 = 0
        L_0x011f:
            com.google.android.flexbox.FlexboxLayoutManager$a r13 = r0.o
            int r13 = r13.f8000f
            float r13 = (float) r13
            float r10 = r10 - r13
            com.google.android.flexbox.FlexboxLayoutManager$a r13 = r0.o
            int r13 = r13.f8000f
            float r13 = (float) r13
            float r12 = r12 - r13
            r13 = 0
            float r4 = java.lang.Math.max(r4, r13)
            int r14 = r9.f8020h
            r13 = r10
            r16 = r12
            r10 = r15
            r12 = 0
        L_0x013b:
            int r11 = r15 + r14
            if (r10 >= r11) goto L_0x021c
            android.view.View r11 = r0.a((int) r10)
            if (r11 == 0) goto L_0x020c
            r17 = r14
            int r14 = r2.f8012i
            r20 = r3
            r3 = 1
            if (r14 != r3) goto L_0x0157
            android.graphics.Rect r14 = f7980b
            r0.calculateItemDecorationsForChild(r11, r14)
            r0.addView(r11)
            goto L_0x0161
        L_0x0157:
            android.graphics.Rect r14 = f7980b
            r0.calculateItemDecorationsForChild(r11, r14)
            r0.addView(r11, r12)
            int r12 = r12 + 1
        L_0x0161:
            r19 = r12
            com.google.android.flexbox.c r12 = r0.k
            long[] r12 = r12.f8024b
            r21 = r12[r10]
            int r12 = com.google.android.flexbox.c.a((long) r21)
            int r14 = com.google.android.flexbox.c.b((long) r21)
            android.view.ViewGroup$LayoutParams r18 = r11.getLayoutParams()
            r3 = r18
            com.google.android.flexbox.FlexboxLayoutManager$LayoutParams r3 = (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) r3
            boolean r18 = r0.a((android.view.View) r11, (int) r12, (int) r14, (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3)
            if (r18 == 0) goto L_0x0182
            r11.measure(r12, r14)
        L_0x0182:
            int r12 = r3.leftMargin
            int r14 = r0.getLeftDecorationWidth(r11)
            int r12 = r12 + r14
            float r12 = (float) r12
            float r22 = r13 + r12
            int r12 = r3.rightMargin
            int r13 = r0.getRightDecorationWidth(r11)
            int r12 = r12 + r13
            float r12 = (float) r12
            float r23 = r16 - r12
            int r12 = r0.getTopDecorationHeight(r11)
            int r16 = r7 + r12
            boolean r12 = r0.f7986h
            if (r12 == 0) goto L_0x01c6
            com.google.android.flexbox.c r12 = r0.k
            int r13 = java.lang.Math.round(r23)
            int r14 = r11.getMeasuredWidth()
            int r18 = r13 - r14
            int r24 = java.lang.Math.round(r23)
            int r13 = r11.getMeasuredHeight()
            int r25 = r16 + r13
            r13 = r11
            r26 = r17
            r14 = r9
            r27 = r15
            r15 = r18
            r17 = r24
            r18 = r25
            r12.a((android.view.View) r13, (com.google.android.flexbox.b) r14, (int) r15, (int) r16, (int) r17, (int) r18)
            goto L_0x01e5
        L_0x01c6:
            r27 = r15
            r26 = r17
            com.google.android.flexbox.c r12 = r0.k
            int r15 = java.lang.Math.round(r22)
            int r13 = java.lang.Math.round(r22)
            int r14 = r11.getMeasuredWidth()
            int r17 = r13 + r14
            int r13 = r11.getMeasuredHeight()
            int r18 = r16 + r13
            r13 = r11
            r14 = r9
            r12.a((android.view.View) r13, (com.google.android.flexbox.b) r14, (int) r15, (int) r16, (int) r17, (int) r18)
        L_0x01e5:
            int r12 = r11.getMeasuredWidth()
            int r13 = r3.rightMargin
            int r12 = r12 + r13
            int r13 = r0.getRightDecorationWidth(r11)
            int r12 = r12 + r13
            float r12 = (float) r12
            float r12 = r12 + r4
            float r22 = r22 + r12
            int r12 = r11.getMeasuredWidth()
            int r3 = r3.leftMargin
            int r12 = r12 + r3
            int r3 = r0.getLeftDecorationWidth(r11)
            int r12 = r12 + r3
            float r3 = (float) r12
            float r3 = r3 + r4
            float r23 = r23 - r3
            r12 = r19
            r13 = r22
            r16 = r23
            goto L_0x0212
        L_0x020c:
            r20 = r3
            r26 = r14
            r27 = r15
        L_0x0212:
            int r10 = r10 + 1
            r3 = r20
            r14 = r26
            r15 = r27
            goto L_0x013b
        L_0x021c:
            r20 = r3
            int r3 = r2.f8006c
            com.google.android.flexbox.FlexboxLayoutManager$b r4 = r0.n
            int r4 = r4.f8012i
            int r3 = r3 + r4
            r2.f8006c = r3
            int r3 = r9.f8019g
            goto L_0x0230
        L_0x022a:
            r20 = r3
            int r3 = r0.a((com.google.android.flexbox.b) r9, (com.google.android.flexbox.FlexboxLayoutManager.b) r2)
        L_0x0230:
            int r8 = r8 + r3
            if (r6 != 0) goto L_0x0243
            boolean r3 = r0.f7986h
            if (r3 == 0) goto L_0x0243
            int r3 = r2.f8008e
            int r4 = r9.f8019g
            int r7 = r2.f8012i
            int r4 = r4 * r7
            int r3 = r3 - r4
            r2.f8008e = r3
            goto L_0x024e
        L_0x0243:
            int r3 = r2.f8008e
            int r4 = r9.f8019g
            int r7 = r2.f8012i
            int r4 = r4 * r7
            int r3 = r3 + r4
            r2.f8008e = r3
        L_0x024e:
            int r3 = r9.f8019g
            int r5 = r5 - r3
            r3 = r20
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0023
        L_0x0257:
            int r3 = r2.f8004a
            int r3 = r3 - r8
            r2.f8004a = r3
            int r3 = r2.f8009f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x0275
            int r3 = r2.f8009f
            int r3 = r3 + r8
            r2.f8009f = r3
            int r3 = r2.f8004a
            if (r3 >= 0) goto L_0x0272
            int r3 = r2.f8009f
            int r4 = r2.f8004a
            int r3 = r3 + r4
            r2.f8009f = r3
        L_0x0272:
            r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (com.google.android.flexbox.FlexboxLayoutManager.b) r2)
        L_0x0275:
            int r1 = r2.f8004a
            int r3 = r20 - r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.a(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s, com.google.android.flexbox.FlexboxLayoutManager$b):int");
    }

    private void a(RecyclerView.n nVar, b bVar) {
        if (bVar.j) {
            if (bVar.f8012i == -1) {
                c(nVar, bVar);
            } else {
                b(nVar, bVar);
            }
        }
    }

    private void b(RecyclerView.n nVar, b bVar) {
        if (bVar.f8009f >= 0) {
            if (f7979a || this.k.f8023a != null) {
                int childCount = getChildCount();
                if (childCount != 0) {
                    int i2 = this.k.f8023a[getPosition(getChildAt(0))];
                    if (i2 != -1) {
                        b bVar2 = this.j.get(i2);
                        int i3 = i2;
                        int i4 = 0;
                        int i5 = -1;
                        while (true) {
                            if (i4 >= childCount) {
                                break;
                            }
                            View childAt = getChildAt(i4);
                            if (!a(childAt, bVar.f8009f)) {
                                break;
                            }
                            if (bVar2.p == getPosition(childAt)) {
                                if (i3 >= this.j.size() - 1) {
                                    break;
                                }
                                i3 += bVar.f8012i;
                                bVar2 = this.j.get(i3);
                                i5 = i4;
                            }
                            i4++;
                        }
                        i4 = i5;
                        a(nVar, 0, i4);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }

    private void c(RecyclerView.n nVar, b bVar) {
        if (bVar.f8009f >= 0) {
            if (f7979a || this.k.f8023a != null) {
                this.p.d();
                int childCount = getChildCount();
                if (childCount != 0) {
                    int i2 = childCount - 1;
                    int i3 = this.k.f8023a[getPosition(getChildAt(i2))];
                    if (i3 != -1) {
                        b bVar2 = this.j.get(i3);
                        int i4 = childCount;
                        int i5 = i2;
                        while (true) {
                            if (i5 < 0) {
                                break;
                            }
                            View childAt = getChildAt(i5);
                            if (!b(childAt, bVar.f8009f)) {
                                break;
                            }
                            if (bVar2.o == getPosition(childAt)) {
                                if (i3 <= 0) {
                                    break;
                                }
                                i3 += bVar.f8012i;
                                bVar2 = this.j.get(i3);
                                i4 = i5;
                            }
                            i5--;
                        }
                        i5 = i4;
                        a(nVar, i5, i2);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }
}
