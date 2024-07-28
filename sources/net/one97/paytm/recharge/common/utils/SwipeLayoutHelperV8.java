package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.d;
import androidx.core.h.u;
import androidx.customview.a.c;
import net.one97.paytm.recharge.R;

public class SwipeLayoutHelperV8 extends ViewGroup {
    private final c.a A = new c.a() {
        public final boolean b(View view, int i2) {
            boolean unused = SwipeLayoutHelperV8.this.f61481a = false;
            if (SwipeLayoutHelperV8.this.m) {
                return false;
            }
            SwipeLayoutHelperV8.this.f61482b.a(SwipeLayoutHelperV8.this.f61484d, i2);
            return false;
        }

        public final int d(View view, int i2) {
            int g2 = SwipeLayoutHelperV8.this.s;
            if (g2 == 4) {
                return Math.max(Math.min(i2, SwipeLayoutHelperV8.this.f61486f.top + SwipeLayoutHelperV8.this.f61485e.getHeight()), SwipeLayoutHelperV8.this.f61486f.top);
            }
            if (g2 != 8) {
                return view.getTop();
            }
            return Math.max(Math.min(i2, SwipeLayoutHelperV8.this.f61486f.top), SwipeLayoutHelperV8.this.f61486f.top - SwipeLayoutHelperV8.this.f61485e.getHeight());
        }

        public final int c(View view, int i2) {
            int g2 = SwipeLayoutHelperV8.this.s;
            if (g2 == 1) {
                return Math.max(Math.min(i2, SwipeLayoutHelperV8.this.f61486f.left + SwipeLayoutHelperV8.this.f61485e.getWidth()), SwipeLayoutHelperV8.this.f61486f.left);
            }
            if (g2 != 2) {
                return view.getLeft();
            }
            return Math.max(Math.min(i2, SwipeLayoutHelperV8.this.f61486f.left), SwipeLayoutHelperV8.this.f61486f.left - SwipeLayoutHelperV8.this.f61485e.getWidth());
        }

        public final void a(View view, float f2, float f3) {
            int i2 = (int) f2;
            boolean z = false;
            boolean z2 = SwipeLayoutHelperV8.a(SwipeLayoutHelperV8.this, i2) >= SwipeLayoutHelperV8.this.n;
            boolean z3 = SwipeLayoutHelperV8.a(SwipeLayoutHelperV8.this, i2) <= (-SwipeLayoutHelperV8.this.n);
            int i3 = (int) f3;
            boolean z4 = SwipeLayoutHelperV8.a(SwipeLayoutHelperV8.this, i3) <= (-SwipeLayoutHelperV8.this.n);
            if (SwipeLayoutHelperV8.a(SwipeLayoutHelperV8.this, i3) >= SwipeLayoutHelperV8.this.n) {
                z = true;
            }
            int k = SwipeLayoutHelperV8.this.getHalfwayPivotHorizontal();
            int l = SwipeLayoutHelperV8.this.getHalfwayPivotVertical();
            int g2 = SwipeLayoutHelperV8.this.s;
            if (g2 != 1) {
                if (g2 != 2) {
                    if (g2 != 4) {
                        if (g2 == 8) {
                            if (z4) {
                                SwipeLayoutHelperV8.this.a(true);
                                return;
                            } else if (!z && SwipeLayoutHelperV8.this.f61484d.getBottom() < l) {
                                SwipeLayoutHelperV8.this.a(true);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!z4) {
                        if (z) {
                            SwipeLayoutHelperV8.this.a(true);
                            return;
                        } else if (SwipeLayoutHelperV8.this.f61484d.getTop() >= l) {
                            SwipeLayoutHelperV8.this.a(true);
                            return;
                        }
                    }
                } else if (!z2) {
                    if (z3) {
                        SwipeLayoutHelperV8.this.a(true);
                        return;
                    } else if (SwipeLayoutHelperV8.this.f61484d.getRight() < k) {
                        SwipeLayoutHelperV8.this.a(true);
                        return;
                    } else {
                        SwipeLayoutHelperV8.this.b(true);
                        return;
                    }
                }
            } else if (z2) {
                SwipeLayoutHelperV8.this.a(true);
                return;
            } else if (!z3 && SwipeLayoutHelperV8.this.f61484d.getLeft() >= k) {
                SwipeLayoutHelperV8.this.a(true);
                return;
            }
            SwipeLayoutHelperV8.this.b(true);
        }

        public final void a(int i2, int i3) {
            super.a(i2, i3);
            if (!SwipeLayoutHelperV8.this.m) {
                boolean z = false;
                boolean z2 = SwipeLayoutHelperV8.this.s == 2 && i2 == 1;
                boolean z3 = SwipeLayoutHelperV8.this.s == 1 && i2 == 2;
                boolean z4 = SwipeLayoutHelperV8.this.s == 8 && i2 == 4;
                if (SwipeLayoutHelperV8.this.s == 4 && i2 == 8) {
                    z = true;
                }
                if (z2 || z3 || z4 || z) {
                    SwipeLayoutHelperV8.this.f61482b.a(SwipeLayoutHelperV8.this.f61484d, i3);
                }
            }
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            super.a(view, i2, i3, i4, i5);
            if (SwipeLayoutHelperV8.this.p == 1) {
                if (SwipeLayoutHelperV8.this.s == 1 || SwipeLayoutHelperV8.this.s == 2) {
                    SwipeLayoutHelperV8.this.f61485e.offsetLeftAndRight(i4);
                } else {
                    SwipeLayoutHelperV8.this.f61485e.offsetTopAndBottom(i5);
                }
            }
            boolean z = (SwipeLayoutHelperV8.this.f61484d.getLeft() == SwipeLayoutHelperV8.this.q && SwipeLayoutHelperV8.this.f61484d.getTop() == SwipeLayoutHelperV8.this.r) ? false : true;
            if (SwipeLayoutHelperV8.this.y != null && z) {
                if (SwipeLayoutHelperV8.this.f61484d.getLeft() == SwipeLayoutHelperV8.this.f61486f.left && SwipeLayoutHelperV8.this.f61484d.getTop() == SwipeLayoutHelperV8.this.f61486f.top) {
                    SwipeLayoutHelperV8.this.y.b();
                } else if (SwipeLayoutHelperV8.this.f61484d.getLeft() == SwipeLayoutHelperV8.this.f61487g.left && SwipeLayoutHelperV8.this.f61484d.getTop() == SwipeLayoutHelperV8.this.f61487g.top) {
                    SwipeLayoutHelperV8.this.y.c();
                } else {
                    c p = SwipeLayoutHelperV8.this.y;
                    int g2 = SwipeLayoutHelperV8.this.s;
                    if (g2 == 1) {
                        SwipeLayoutHelperV8.this.f61484d.getLeft();
                        int i6 = SwipeLayoutHelperV8.this.f61486f.left;
                        SwipeLayoutHelperV8.this.f61485e.getWidth();
                    } else if (g2 == 2) {
                        int i7 = SwipeLayoutHelperV8.this.f61486f.left;
                        SwipeLayoutHelperV8.this.f61484d.getLeft();
                        SwipeLayoutHelperV8.this.f61485e.getWidth();
                    } else if (g2 == 4) {
                        SwipeLayoutHelperV8.this.f61484d.getTop();
                        int i8 = SwipeLayoutHelperV8.this.f61486f.top;
                        SwipeLayoutHelperV8.this.f61485e.getHeight();
                    } else if (g2 == 8) {
                        int i9 = SwipeLayoutHelperV8.this.f61486f.top;
                        SwipeLayoutHelperV8.this.f61484d.getTop();
                        SwipeLayoutHelperV8.this.f61485e.getHeight();
                    }
                    p.a();
                }
            }
            SwipeLayoutHelperV8 swipeLayoutHelperV8 = SwipeLayoutHelperV8.this;
            int unused = swipeLayoutHelperV8.q = swipeLayoutHelperV8.f61484d.getLeft();
            SwipeLayoutHelperV8 swipeLayoutHelperV82 = SwipeLayoutHelperV8.this;
            int unused2 = swipeLayoutHelperV82.r = swipeLayoutHelperV82.f61484d.getTop();
            u.g(SwipeLayoutHelperV8.this);
        }

        public final void a(int i2) {
            super.a(i2);
            int r = SwipeLayoutHelperV8.this.o;
            if (i2 != 0) {
                if (i2 == 1) {
                    int unused = SwipeLayoutHelperV8.this.o = 4;
                }
            } else if (SwipeLayoutHelperV8.this.s == 1 || SwipeLayoutHelperV8.this.s == 2) {
                if (SwipeLayoutHelperV8.this.f61484d.getLeft() == SwipeLayoutHelperV8.this.f61486f.left) {
                    int unused2 = SwipeLayoutHelperV8.this.o = 0;
                } else {
                    int unused3 = SwipeLayoutHelperV8.this.o = 2;
                }
            } else if (SwipeLayoutHelperV8.this.f61484d.getTop() == SwipeLayoutHelperV8.this.f61486f.top) {
                int unused4 = SwipeLayoutHelperV8.this.o = 0;
            } else {
                int unused5 = SwipeLayoutHelperV8.this.o = 2;
            }
            if (SwipeLayoutHelperV8.this.x != null && !SwipeLayoutHelperV8.this.f61481a && r != SwipeLayoutHelperV8.this.o) {
                SwipeLayoutHelperV8.this.x.a(SwipeLayoutHelperV8.this.o);
            }
        }
    };
    private boolean B = false;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f61481a = false;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public androidx.customview.a.c f61482b;

    /* renamed from: c  reason: collision with root package name */
    int f61483c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f61484d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f61485e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Rect f61486f = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Rect f61487g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private Rect f61488h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private Rect f61489i = new Rect();
    /* access modifiers changed from: private */
    public int j = 0;
    private boolean k = false;
    /* access modifiers changed from: private */
    public volatile boolean l = false;
    /* access modifiers changed from: private */
    public volatile boolean m = false;
    /* access modifiers changed from: private */
    public int n = 300;
    /* access modifiers changed from: private */
    public int o = 0;
    /* access modifiers changed from: private */
    public int p = 0;
    /* access modifiers changed from: private */
    public int q = 0;
    /* access modifiers changed from: private */
    public int r = 0;
    /* access modifiers changed from: private */
    public int s = 1;
    private float t = 0.0f;
    private float u = -1.0f;
    private float v = -1.0f;
    private d w;
    /* access modifiers changed from: private */
    public a x;
    /* access modifiers changed from: private */
    public c y;
    private final GestureDetector.OnGestureListener z = new GestureDetector.SimpleOnGestureListener() {

        /* renamed from: a  reason: collision with root package name */
        boolean f61490a = false;

        public final boolean onDown(MotionEvent motionEvent) {
            boolean unused = SwipeLayoutHelperV8.this.l = false;
            this.f61490a = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean unused = SwipeLayoutHelperV8.this.l = true;
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean z;
            boolean unused = SwipeLayoutHelperV8.this.l = true;
            if (SwipeLayoutHelperV8.this.getParent() != null) {
                if (!this.f61490a) {
                    z = SwipeLayoutHelperV8.this.getDistToClosestEdge() >= SwipeLayoutHelperV8.this.j;
                    if (z) {
                        this.f61490a = true;
                    }
                } else {
                    z = true;
                }
                SwipeLayoutHelperV8.this.getParent().requestDisallowInterceptTouchEvent(z);
            }
            return false;
        }
    };

    interface a {
        void a(int i2);
    }

    public static class b implements c {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public interface c {
        void a();

        void b();

        void c();
    }

    public SwipeLayoutHelperV8(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public SwipeLayoutHelperV8(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SwipeLayoutHelperV8(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.w.a(motionEvent);
        this.f61482b.b(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 2) {
            this.f61485e = getChildAt(0);
            this.f61484d = getChildAt(1);
        } else if (getChildCount() == 1) {
            this.f61484d = getChildAt(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        boolean z4;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        this.f61481a = false;
        int i11 = 0;
        while (i11 < getChildCount()) {
            View childAt = getChildAt(i11);
            int paddingLeft = getPaddingLeft();
            int max = Math.max((i4 - getPaddingRight()) - i2, i10);
            int paddingTop = getPaddingTop();
            int max2 = Math.max((i5 - getPaddingBottom()) - i3, i10);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams != null) {
                z3 = layoutParams.height == -1 || layoutParams.height == -1;
                z4 = layoutParams.width == -1 || layoutParams.width == -1;
            } else {
                z4 = false;
                z3 = false;
            }
            if (z3) {
                measuredHeight = max2 - paddingTop;
                layoutParams.height = measuredHeight;
            }
            if (z4) {
                measuredWidth = max - paddingLeft;
                layoutParams.width = measuredWidth;
            }
            int i12 = this.s;
            if (i12 == 1) {
                i9 = Math.min(getPaddingLeft(), max);
                i8 = Math.min(getPaddingTop(), max2);
                i7 = Math.min(measuredWidth + getPaddingLeft(), max);
                i6 = Math.min(measuredHeight + getPaddingTop(), max2);
            } else if (i12 == 2) {
                i9 = Math.max(((i4 - measuredWidth) - getPaddingRight()) - i2, paddingLeft);
                i8 = Math.min(getPaddingTop(), max2);
                i7 = Math.max((i4 - getPaddingRight()) - i2, paddingLeft);
                i6 = Math.min(measuredHeight + getPaddingTop(), max2);
            } else if (i12 == 4) {
                i9 = Math.min(getPaddingLeft(), max);
                i8 = Math.min(getPaddingTop(), max2);
                i7 = Math.min(measuredWidth + getPaddingLeft(), max);
                i6 = Math.min(measuredHeight + getPaddingTop(), max2);
            } else if (i12 != 8) {
                i9 = 0;
                i8 = 0;
                i7 = 0;
                i6 = 0;
            } else {
                i9 = Math.min(getPaddingLeft(), max);
                i8 = Math.max(((i5 - measuredHeight) - getPaddingBottom()) - i3, paddingTop);
                i7 = Math.min(measuredWidth + getPaddingLeft(), max);
                i6 = Math.max((i5 - getPaddingBottom()) - i3, paddingTop);
            }
            childAt.layout(i9, i8, i7, i6);
            i11++;
            i10 = 0;
        }
        if (this.p == 1) {
            int i13 = this.s;
            if (i13 == 1) {
                View view = this.f61485e;
                view.offsetLeftAndRight(-view.getWidth());
            } else if (i13 == 2) {
                View view2 = this.f61485e;
                view2.offsetLeftAndRight(view2.getWidth());
            } else if (i13 == 4) {
                View view3 = this.f61485e;
                view3.offsetTopAndBottom(-view3.getHeight());
            } else if (i13 == 8) {
                View view4 = this.f61485e;
                view4.offsetTopAndBottom(view4.getHeight());
            }
        }
        this.f61486f.set(this.f61484d.getLeft(), this.f61484d.getTop(), this.f61484d.getRight(), this.f61484d.getBottom());
        this.f61488h.set(this.f61485e.getLeft(), this.f61485e.getTop(), this.f61485e.getRight(), this.f61485e.getBottom());
        this.f61487g.set(getMainOpenLeft(), getMainOpenTop(), getMainOpenLeft() + this.f61484d.getWidth(), getMainOpenTop() + this.f61484d.getHeight());
        this.f61489i.set(getSecOpenLeft(), getSecOpenTop(), getSecOpenLeft() + this.f61485e.getWidth(), getSecOpenTop() + this.f61485e.getHeight());
        if (this.k) {
            a(false);
        } else {
            b(false);
        }
        this.q = this.f61484d.getLeft();
        this.r = this.f61484d.getTop();
        this.f61483c++;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
        if (r13 > r4) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (r14 > r7) goto L_0x00b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 2
            if (r0 < r1) goto L_0x00bb
            android.view.ViewGroup$LayoutParams r0 = r12.getLayoutParams()
            int r1 = android.view.View.MeasureSpec.getMode(r13)
            int r2 = android.view.View.MeasureSpec.getMode(r14)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0017:
            int r7 = r12.getChildCount()
            if (r4 >= r7) goto L_0x0037
            android.view.View r7 = r12.getChildAt(r4)
            r12.measureChild(r7, r13, r14)
            int r8 = r7.getMeasuredWidth()
            int r5 = java.lang.Math.max(r8, r5)
            int r7 = r7.getMeasuredHeight()
            int r6 = java.lang.Math.max(r7, r6)
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0037:
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r2)
            int r4 = android.view.View.MeasureSpec.getSize(r13)
            int r7 = android.view.View.MeasureSpec.getSize(r14)
        L_0x0047:
            int r8 = r12.getChildCount()
            r9 = -1
            if (r3 >= r8) goto L_0x0085
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r10 = r8.getLayoutParams()
            if (r10 == 0) goto L_0x0066
            int r11 = r10.height
            if (r11 != r9) goto L_0x005f
            r8.setMinimumHeight(r7)
        L_0x005f:
            int r10 = r10.width
            if (r10 != r9) goto L_0x0066
            r8.setMinimumWidth(r4)
        L_0x0066:
            r12.measureChild(r8, r13, r14)
            int r9 = r8.getMeasuredWidth()
            int r5 = java.lang.Math.max(r9, r5)
            boolean r9 = r12.B
            if (r9 == 0) goto L_0x007a
            int r6 = r8.getMeasuredHeight()
            goto L_0x0082
        L_0x007a:
            int r8 = r8.getMeasuredHeight()
            int r6 = java.lang.Math.max(r8, r6)
        L_0x0082:
            int r3 = r3 + 1
            goto L_0x0047
        L_0x0085:
            int r13 = r12.getPaddingLeft()
            int r14 = r12.getPaddingRight()
            int r13 = r13 + r14
            int r13 = r13 + r5
            int r14 = r12.getPaddingTop()
            int r3 = r12.getPaddingBottom()
            int r14 = r14 + r3
            int r14 = r14 + r6
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r1 != r5) goto L_0x00a0
            goto L_0x00a9
        L_0x00a0:
            int r6 = r0.width
            if (r6 != r9) goto L_0x00a5
            r13 = r4
        L_0x00a5:
            if (r1 != r3) goto L_0x00aa
            if (r13 <= r4) goto L_0x00aa
        L_0x00a9:
            r13 = r4
        L_0x00aa:
            if (r2 != r5) goto L_0x00ad
            goto L_0x00b6
        L_0x00ad:
            int r0 = r0.height
            if (r0 != r9) goto L_0x00b2
            r14 = r7
        L_0x00b2:
            if (r2 != r3) goto L_0x00b7
            if (r14 <= r7) goto L_0x00b7
        L_0x00b6:
            r14 = r7
        L_0x00b7:
            r12.setMeasuredDimension(r13, r14)
            return
        L_0x00bb:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Layout must have two children"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.SwipeLayoutHelperV8.onMeasure(int, int):void");
    }

    public void computeScroll() {
        if (this.f61482b.f()) {
            u.g(this);
        }
    }

    public final void a(boolean z2) {
        this.k = true;
        this.f61481a = false;
        if (z2) {
            this.o = 3;
            this.f61482b.a(this.f61484d, this.f61487g.left, this.f61487g.top);
            a aVar = this.x;
            if (aVar != null) {
                aVar.a(this.o);
            }
        } else {
            this.o = 2;
            this.f61482b.e();
            this.f61484d.layout(this.f61487g.left, this.f61487g.top, this.f61487g.right, this.f61487g.bottom);
            this.f61485e.layout(this.f61489i.left, this.f61489i.top, this.f61489i.right, this.f61489i.bottom);
        }
        u.g(this);
    }

    public final void b(boolean z2) {
        this.k = false;
        this.f61481a = false;
        if (z2) {
            this.o = 1;
            this.f61482b.a(this.f61484d, this.f61486f.left, this.f61486f.top);
            a aVar = this.x;
            if (aVar != null) {
                aVar.a(this.o);
            }
        } else {
            this.o = 0;
            this.f61482b.e();
            this.f61484d.layout(this.f61486f.left, this.f61486f.top, this.f61486f.right, this.f61486f.bottom);
            this.f61485e.layout(this.f61488h.left, this.f61488h.top, this.f61488h.right, this.f61488h.bottom);
        }
        u.g(this);
    }

    public void setMinFlingVelocity(int i2) {
        this.n = i2;
    }

    public int getMinFlingVelocity() {
        return this.n;
    }

    public void setDragEdge(int i2) {
        this.s = i2;
    }

    public int getDragEdge() {
        return this.s;
    }

    public void setSwipeListener(c cVar) {
        this.y = cVar;
    }

    public void setLockDrag(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: package-private */
    public void setDragStateChangeListener(a aVar) {
        this.x = aVar;
    }

    private int getMainOpenLeft() {
        int i2 = this.s;
        if (i2 == 1) {
            return this.f61486f.left + this.f61485e.getWidth();
        }
        if (i2 == 2) {
            return this.f61486f.left - this.f61485e.getWidth();
        }
        if (i2 == 4) {
            return this.f61486f.left;
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f61486f.left;
    }

    private int getMainOpenTop() {
        int i2 = this.s;
        if (i2 == 1) {
            return this.f61486f.top;
        }
        if (i2 == 2) {
            return this.f61486f.top;
        }
        if (i2 == 4) {
            return this.f61486f.top + this.f61485e.getHeight();
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f61486f.top - this.f61485e.getHeight();
    }

    private int getSecOpenLeft() {
        int i2;
        if (this.p == 0 || (i2 = this.s) == 8 || i2 == 4) {
            return this.f61488h.left;
        }
        if (i2 == 1) {
            return this.f61488h.left + this.f61485e.getWidth();
        }
        return this.f61488h.left - this.f61485e.getWidth();
    }

    private int getSecOpenTop() {
        int i2;
        if (this.p == 0 || (i2 = this.s) == 1 || i2 == 2) {
            return this.f61488h.top;
        }
        if (i2 == 4) {
            return this.f61488h.top + this.f61485e.getHeight();
        }
        return this.f61488h.top - this.f61485e.getHeight();
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (!(attributeSet == null || context == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeLayoutHelperV8, 0, 0);
            this.s = obtainStyledAttributes.getInteger(R.styleable.SwipeLayoutHelperV8_re_dragEdge, 1);
            this.n = obtainStyledAttributes.getInteger(R.styleable.SwipeLayoutHelperV8_re_flingVelocity, 300);
            this.p = obtainStyledAttributes.getInteger(R.styleable.SwipeLayoutHelperV8_re_mode, 0);
            this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwipeLayoutHelperV8_re_minDistRequestDisallowParent, b());
        }
        this.f61482b = androidx.customview.a.c.a((ViewGroup) this, 1.0f, this.A);
        this.f61482b.f3238e = 15;
        this.w = new d(context, this.z);
    }

    /* access modifiers changed from: private */
    public int getDistToClosestEdge() {
        int i2 = this.s;
        if (i2 == 1) {
            return Math.min(this.f61484d.getLeft() - this.f61486f.left, (this.f61486f.left + this.f61485e.getWidth()) - this.f61484d.getLeft());
        } else if (i2 == 2) {
            return Math.min(this.f61484d.getRight() - (this.f61486f.right - this.f61485e.getWidth()), this.f61486f.right - this.f61484d.getRight());
        } else if (i2 == 4) {
            int height = this.f61486f.top + this.f61485e.getHeight();
            return Math.min(this.f61484d.getBottom() - height, height - this.f61484d.getTop());
        } else if (i2 != 8) {
            return 0;
        } else {
            return Math.min(this.f61486f.bottom - this.f61484d.getBottom(), this.f61484d.getBottom() - (this.f61486f.bottom - this.f61485e.getHeight()));
        }
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotHorizontal() {
        if (this.s == 1) {
            return this.f61486f.left + (this.f61485e.getWidth() / 2);
        }
        return this.f61486f.right - (this.f61485e.getWidth() / 2);
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotVertical() {
        if (this.s == 4) {
            return this.f61486f.top + (this.f61485e.getHeight() / 2);
        }
        return this.f61486f.bottom - (this.f61485e.getHeight() / 2);
    }

    private int b() {
        return (int) ((((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f) * 1.0f);
    }

    private boolean a(MotionEvent motionEvent) {
        if (getDragEdge() == 1 || getDragEdge() == 2) {
            if (Math.abs(motionEvent.getRawX() - this.u) < ((float) this.f61482b.f3235b)) {
                return true;
            }
        } else if (Math.abs(motionEvent.getRawY() - this.v) < ((float) this.f61482b.f3235b)) {
            return true;
        }
        return false;
    }

    public final void a() {
        this.B = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.m) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.w.a(motionEvent);
        this.f61482b.b(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.u = motionEvent.getRawX();
            this.v = motionEvent.getRawY();
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (!(x2 >= ((float) this.f61484d.getLeft()) && x2 <= ((float) this.f61484d.getRight()) && y2 >= ((float) this.f61484d.getTop()) && y2 <= ((float) this.f61484d.getBottom()))) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if ((x3 >= ((float) this.f61485e.getLeft()) && x3 <= ((float) this.f61485e.getRight()) && y3 >= ((float) this.f61485e.getTop()) && y3 <= ((float) this.f61485e.getBottom())) && a(motionEvent)) {
                return false;
            }
        } else if (a(motionEvent)) {
            return false;
        }
        return (this.f61482b.f3234a == 2) || (this.f61482b.f3234a == 0 && this.l);
    }

    static /* synthetic */ int a(SwipeLayoutHelperV8 swipeLayoutHelperV8, int i2) {
        return (int) (((float) i2) / (((float) swipeLayoutHelperV8.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
