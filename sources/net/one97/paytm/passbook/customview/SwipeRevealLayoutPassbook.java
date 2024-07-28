package net.one97.paytm.passbook.customview;

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
import net.one97.paytm.passbook.R;

public class SwipeRevealLayoutPassbook extends ViewGroup {
    private final c.a A = new c.a() {
        public final boolean b(View view, int i2) {
            boolean unused = SwipeRevealLayoutPassbook.this.f57187a = false;
            if (SwipeRevealLayoutPassbook.this.m) {
                return false;
            }
            SwipeRevealLayoutPassbook.this.f57188b.a(SwipeRevealLayoutPassbook.this.f57190d, i2);
            return false;
        }

        public final int d(View view, int i2) {
            int g2 = SwipeRevealLayoutPassbook.this.s;
            if (g2 == 4) {
                return Math.max(Math.min(i2, SwipeRevealLayoutPassbook.this.f57192f.top + SwipeRevealLayoutPassbook.this.f57191e.getHeight()), SwipeRevealLayoutPassbook.this.f57192f.top);
            }
            if (g2 != 8) {
                return view.getTop();
            }
            return Math.max(Math.min(i2, SwipeRevealLayoutPassbook.this.f57192f.top), SwipeRevealLayoutPassbook.this.f57192f.top - SwipeRevealLayoutPassbook.this.f57191e.getHeight());
        }

        public final int c(View view, int i2) {
            int g2 = SwipeRevealLayoutPassbook.this.s;
            if (g2 == 1) {
                return Math.max(Math.min(i2, SwipeRevealLayoutPassbook.this.f57192f.left + SwipeRevealLayoutPassbook.this.f57191e.getWidth()), SwipeRevealLayoutPassbook.this.f57192f.left);
            }
            if (g2 != 2) {
                return view.getLeft();
            }
            return Math.max(Math.min(i2, SwipeRevealLayoutPassbook.this.f57192f.left), SwipeRevealLayoutPassbook.this.f57192f.left - SwipeRevealLayoutPassbook.this.f57191e.getWidth());
        }

        public final void a(View view, float f2, float f3) {
            int i2 = (int) f2;
            boolean z = false;
            boolean z2 = SwipeRevealLayoutPassbook.a(SwipeRevealLayoutPassbook.this, i2) >= SwipeRevealLayoutPassbook.this.n;
            boolean z3 = SwipeRevealLayoutPassbook.a(SwipeRevealLayoutPassbook.this, i2) <= (-SwipeRevealLayoutPassbook.this.n);
            int i3 = (int) f3;
            boolean z4 = SwipeRevealLayoutPassbook.a(SwipeRevealLayoutPassbook.this, i3) <= (-SwipeRevealLayoutPassbook.this.n);
            if (SwipeRevealLayoutPassbook.a(SwipeRevealLayoutPassbook.this, i3) >= SwipeRevealLayoutPassbook.this.n) {
                z = true;
            }
            int k = SwipeRevealLayoutPassbook.this.getHalfwayPivotHorizontal();
            int l = SwipeRevealLayoutPassbook.this.getHalfwayPivotVertical();
            int g2 = SwipeRevealLayoutPassbook.this.s;
            if (g2 != 1) {
                if (g2 != 2) {
                    if (g2 != 4) {
                        if (g2 == 8) {
                            if (z4) {
                                SwipeRevealLayoutPassbook.this.a(true);
                                return;
                            } else if (!z && SwipeRevealLayoutPassbook.this.f57190d.getBottom() < l) {
                                SwipeRevealLayoutPassbook.this.a(true);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!z4) {
                        if (z) {
                            SwipeRevealLayoutPassbook.this.a(true);
                            return;
                        } else if (SwipeRevealLayoutPassbook.this.f57190d.getTop() >= l) {
                            SwipeRevealLayoutPassbook.this.a(true);
                            return;
                        }
                    }
                } else if (!z2) {
                    if (z3) {
                        SwipeRevealLayoutPassbook.this.a(true);
                        return;
                    } else if (SwipeRevealLayoutPassbook.this.f57190d.getRight() < k) {
                        SwipeRevealLayoutPassbook.this.a(true);
                        return;
                    } else {
                        SwipeRevealLayoutPassbook.this.b(true);
                        return;
                    }
                }
            } else if (z2) {
                SwipeRevealLayoutPassbook.this.a(true);
                return;
            } else if (!z3 && SwipeRevealLayoutPassbook.this.f57190d.getLeft() >= k) {
                SwipeRevealLayoutPassbook.this.a(true);
                return;
            }
            SwipeRevealLayoutPassbook.this.b(true);
        }

        public final void a(int i2, int i3) {
            super.a(i2, i3);
            if (!SwipeRevealLayoutPassbook.this.m) {
                boolean z = false;
                boolean z2 = SwipeRevealLayoutPassbook.this.s == 2 && i2 == 1;
                boolean z3 = SwipeRevealLayoutPassbook.this.s == 1 && i2 == 2;
                boolean z4 = SwipeRevealLayoutPassbook.this.s == 8 && i2 == 4;
                if (SwipeRevealLayoutPassbook.this.s == 4 && i2 == 8) {
                    z = true;
                }
                if (z2 || z3 || z4 || z) {
                    SwipeRevealLayoutPassbook.this.f57188b.a(SwipeRevealLayoutPassbook.this.f57190d, i3);
                }
            }
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            super.a(view, i2, i3, i4, i5);
            if (SwipeRevealLayoutPassbook.this.p == 1) {
                if (SwipeRevealLayoutPassbook.this.s == 1 || SwipeRevealLayoutPassbook.this.s == 2) {
                    SwipeRevealLayoutPassbook.this.f57191e.offsetLeftAndRight(i4);
                } else {
                    SwipeRevealLayoutPassbook.this.f57191e.offsetTopAndBottom(i5);
                }
            }
            boolean z = (SwipeRevealLayoutPassbook.this.f57190d.getLeft() == SwipeRevealLayoutPassbook.this.q && SwipeRevealLayoutPassbook.this.f57190d.getTop() == SwipeRevealLayoutPassbook.this.r) ? false : true;
            if (SwipeRevealLayoutPassbook.this.z != null && z) {
                if (SwipeRevealLayoutPassbook.this.f57190d.getLeft() == SwipeRevealLayoutPassbook.this.f57192f.left && SwipeRevealLayoutPassbook.this.f57190d.getTop() == SwipeRevealLayoutPassbook.this.f57192f.top) {
                    b unused = SwipeRevealLayoutPassbook.this.z;
                } else if (SwipeRevealLayoutPassbook.this.f57190d.getLeft() == SwipeRevealLayoutPassbook.this.f57193g.left && SwipeRevealLayoutPassbook.this.f57190d.getTop() == SwipeRevealLayoutPassbook.this.f57193g.top) {
                    b unused2 = SwipeRevealLayoutPassbook.this.z;
                } else {
                    b unused3 = SwipeRevealLayoutPassbook.this.z;
                    int g2 = SwipeRevealLayoutPassbook.this.s;
                    if (g2 == 1) {
                        SwipeRevealLayoutPassbook.this.f57190d.getLeft();
                        int i6 = SwipeRevealLayoutPassbook.this.f57192f.left;
                        SwipeRevealLayoutPassbook.this.f57191e.getWidth();
                    } else if (g2 == 2) {
                        int i7 = SwipeRevealLayoutPassbook.this.f57192f.left;
                        SwipeRevealLayoutPassbook.this.f57190d.getLeft();
                        SwipeRevealLayoutPassbook.this.f57191e.getWidth();
                    } else if (g2 == 4) {
                        SwipeRevealLayoutPassbook.this.f57190d.getTop();
                        int i8 = SwipeRevealLayoutPassbook.this.f57192f.top;
                        SwipeRevealLayoutPassbook.this.f57191e.getHeight();
                    } else if (g2 == 8) {
                        int i9 = SwipeRevealLayoutPassbook.this.f57192f.top;
                        SwipeRevealLayoutPassbook.this.f57190d.getTop();
                        SwipeRevealLayoutPassbook.this.f57191e.getHeight();
                    }
                }
            }
            SwipeRevealLayoutPassbook swipeRevealLayoutPassbook = SwipeRevealLayoutPassbook.this;
            int unused4 = swipeRevealLayoutPassbook.q = swipeRevealLayoutPassbook.f57190d.getLeft();
            SwipeRevealLayoutPassbook swipeRevealLayoutPassbook2 = SwipeRevealLayoutPassbook.this;
            int unused5 = swipeRevealLayoutPassbook2.r = swipeRevealLayoutPassbook2.f57190d.getTop();
            u.g(SwipeRevealLayoutPassbook.this);
        }

        public final void a(int i2) {
            super.a(i2);
            int r = SwipeRevealLayoutPassbook.this.o;
            if (i2 != 0) {
                if (i2 == 1) {
                    int unused = SwipeRevealLayoutPassbook.this.o = 4;
                }
            } else if (SwipeRevealLayoutPassbook.this.s == 1 || SwipeRevealLayoutPassbook.this.s == 2) {
                if (SwipeRevealLayoutPassbook.this.f57190d.getLeft() == SwipeRevealLayoutPassbook.this.f57192f.left) {
                    int unused2 = SwipeRevealLayoutPassbook.this.o = 0;
                } else {
                    int unused3 = SwipeRevealLayoutPassbook.this.o = 2;
                }
            } else if (SwipeRevealLayoutPassbook.this.f57190d.getTop() == SwipeRevealLayoutPassbook.this.f57192f.top) {
                int unused4 = SwipeRevealLayoutPassbook.this.o = 0;
            } else {
                int unused5 = SwipeRevealLayoutPassbook.this.o = 2;
            }
            if (SwipeRevealLayoutPassbook.this.y != null && !SwipeRevealLayoutPassbook.this.f57187a && r != SwipeRevealLayoutPassbook.this.o) {
                SwipeRevealLayoutPassbook.this.y.a(SwipeRevealLayoutPassbook.this.o);
            }
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f57187a = false;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public c f57188b;

    /* renamed from: c  reason: collision with root package name */
    int f57189c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f57190d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f57191e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Rect f57192f = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Rect f57193g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private Rect f57194h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private Rect f57195i = new Rect();
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
    private final GestureDetector.OnGestureListener t = new GestureDetector.SimpleOnGestureListener() {

        /* renamed from: a  reason: collision with root package name */
        boolean f57196a = false;

        public final boolean onDown(MotionEvent motionEvent) {
            boolean unused = SwipeRevealLayoutPassbook.this.l = false;
            this.f57196a = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean unused = SwipeRevealLayoutPassbook.this.l = true;
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean z;
            boolean unused = SwipeRevealLayoutPassbook.this.l = true;
            if (SwipeRevealLayoutPassbook.this.getParent() != null) {
                if (!this.f57196a) {
                    z = SwipeRevealLayoutPassbook.this.getDistToClosestEdge() >= SwipeRevealLayoutPassbook.this.j;
                    if (z) {
                        this.f57196a = true;
                    }
                } else {
                    z = true;
                }
                SwipeRevealLayoutPassbook.this.getParent().requestDisallowInterceptTouchEvent(z);
            }
            return false;
        }
    };
    private float u = 0.0f;
    private float v = -1.0f;
    private float w = -1.0f;
    private d x;
    /* access modifiers changed from: private */
    public a y;
    /* access modifiers changed from: private */
    public b z;

    interface a {
        void a(int i2);
    }

    public interface b {
    }

    public SwipeRevealLayoutPassbook(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public SwipeRevealLayoutPassbook(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SwipeRevealLayoutPassbook(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x.a(motionEvent);
        this.f57188b.b(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 2) {
            this.f57191e = getChildAt(0);
            this.f57190d = getChildAt(1);
        } else if (getChildCount() == 1) {
            this.f57190d = getChildAt(0);
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
        this.f57187a = false;
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
                View view = this.f57191e;
                view.offsetLeftAndRight(-view.getWidth());
            } else if (i13 == 2) {
                View view2 = this.f57191e;
                view2.offsetLeftAndRight(view2.getWidth());
            } else if (i13 == 4) {
                View view3 = this.f57191e;
                view3.offsetTopAndBottom(-view3.getHeight());
            } else if (i13 == 8) {
                View view4 = this.f57191e;
                view4.offsetTopAndBottom(view4.getHeight());
            }
        }
        this.f57192f.set(this.f57190d.getLeft(), this.f57190d.getTop(), this.f57190d.getRight(), this.f57190d.getBottom());
        this.f57194h.set(this.f57191e.getLeft(), this.f57191e.getTop(), this.f57191e.getRight(), this.f57191e.getBottom());
        this.f57193g.set(getMainOpenLeft(), getMainOpenTop(), getMainOpenLeft() + this.f57190d.getWidth(), getMainOpenTop() + this.f57190d.getHeight());
        this.f57195i.set(getSecOpenLeft(), getSecOpenTop(), getSecOpenLeft() + this.f57191e.getWidth(), getSecOpenTop() + this.f57191e.getHeight());
        if (this.k) {
            a(false);
        } else {
            b(false);
        }
        this.q = this.f57190d.getLeft();
        this.r = this.f57190d.getTop();
        this.f57189c++;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
        if (r14 > r3) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        if (r15 > r7) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            r1 = 2
            if (r0 < r1) goto L_0x00bd
            android.view.ViewGroup$LayoutParams r0 = r13.getLayoutParams()
            int r1 = android.view.View.MeasureSpec.getMode(r14)
            int r2 = android.view.View.MeasureSpec.getMode(r15)
            r3 = 0
            r4 = 1
            r3 = 1
            r5 = 0
            r6 = 0
        L_0x0018:
            int r7 = r13.getChildCount()
            if (r3 >= r7) goto L_0x0038
            android.view.View r7 = r13.getChildAt(r3)
            r13.measureChild(r7, r14, r15)
            int r8 = r7.getMeasuredWidth()
            int r5 = java.lang.Math.max(r8, r5)
            int r7 = r7.getMeasuredHeight()
            int r6 = java.lang.Math.max(r7, r6)
            int r3 = r3 + 1
            goto L_0x0018
        L_0x0038:
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r2)
            int r3 = android.view.View.MeasureSpec.getSize(r14)
            int r7 = android.view.View.MeasureSpec.getSize(r15)
            int r8 = r13.getChildCount()
            int r8 = r8 - r4
        L_0x004d:
            r4 = 1073741824(0x40000000, float:2.0)
            r9 = -1
            if (r8 < 0) goto L_0x0089
            android.view.View r10 = r13.getChildAt(r8)
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            if (r11 == 0) goto L_0x0070
            if (r8 != 0) goto L_0x0062
            r10.setMinimumHeight(r6)
            goto L_0x0069
        L_0x0062:
            int r12 = r11.height
            if (r12 != r9) goto L_0x0069
            r10.setMinimumHeight(r7)
        L_0x0069:
            int r11 = r11.width
            if (r11 != r9) goto L_0x0070
            r10.setMinimumWidth(r3)
        L_0x0070:
            if (r8 == 0) goto L_0x007f
            r13.measureChild(r10, r14, r15)
            int r4 = r10.getMeasuredWidth()
            int r4 = java.lang.Math.max(r4, r5)
            r5 = r4
            goto L_0x0086
        L_0x007f:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r13.measureChild(r10, r14, r4)
        L_0x0086:
            int r8 = r8 + -1
            goto L_0x004d
        L_0x0089:
            int r14 = r13.getPaddingLeft()
            int r15 = r13.getPaddingRight()
            int r14 = r14 + r15
            int r14 = r14 + r5
            int r15 = r13.getPaddingTop()
            int r5 = r13.getPaddingBottom()
            int r15 = r15 + r5
            int r15 = r15 + r6
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r4) goto L_0x00a2
            goto L_0x00ab
        L_0x00a2:
            int r6 = r0.width
            if (r6 != r9) goto L_0x00a7
            r14 = r3
        L_0x00a7:
            if (r1 != r5) goto L_0x00ac
            if (r14 <= r3) goto L_0x00ac
        L_0x00ab:
            r14 = r3
        L_0x00ac:
            if (r2 != r4) goto L_0x00af
            goto L_0x00b8
        L_0x00af:
            int r0 = r0.height
            if (r0 != r9) goto L_0x00b4
            r15 = r7
        L_0x00b4:
            if (r2 != r5) goto L_0x00b9
            if (r15 <= r7) goto L_0x00b9
        L_0x00b8:
            r15 = r7
        L_0x00b9:
            r13.setMeasuredDimension(r14, r15)
            return
        L_0x00bd:
            java.lang.RuntimeException r14 = new java.lang.RuntimeException
            java.lang.String r15 = "Layout must have two children"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook.onMeasure(int, int):void");
    }

    public void computeScroll() {
        if (this.f57188b.f()) {
            u.g(this);
        }
    }

    public final void a(boolean z2) {
        this.k = true;
        this.f57187a = false;
        if (z2) {
            this.o = 3;
            this.f57188b.a(this.f57190d, this.f57193g.left, this.f57193g.top);
            a aVar = this.y;
            if (aVar != null) {
                aVar.a(this.o);
            }
        } else {
            this.o = 2;
            this.f57188b.e();
            this.f57190d.layout(this.f57193g.left, this.f57193g.top, this.f57193g.right, this.f57193g.bottom);
            this.f57191e.layout(this.f57195i.left, this.f57195i.top, this.f57195i.right, this.f57195i.bottom);
        }
        u.g(this);
    }

    public final void b(boolean z2) {
        this.k = false;
        this.f57187a = false;
        if (z2) {
            this.o = 1;
            this.f57188b.a(this.f57190d, this.f57192f.left, this.f57192f.top);
            a aVar = this.y;
            if (aVar != null) {
                aVar.a(this.o);
            }
        } else {
            this.o = 0;
            this.f57188b.e();
            this.f57190d.layout(this.f57192f.left, this.f57192f.top, this.f57192f.right, this.f57192f.bottom);
            this.f57191e.layout(this.f57194h.left, this.f57194h.top, this.f57194h.right, this.f57194h.bottom);
        }
        u.g(this);
    }

    public int getMinFlingVelocity() {
        return this.n;
    }

    public void setMinFlingVelocity(int i2) {
        this.n = i2;
    }

    public int getDragEdge() {
        return this.s;
    }

    public void setDragEdge(int i2) {
        this.s = i2;
    }

    public void setSwipeListener(b bVar) {
        this.z = bVar;
    }

    public void setLockDrag(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: package-private */
    public void setDragStateChangeListener(a aVar) {
        this.y = aVar;
    }

    private int getMainOpenLeft() {
        int i2 = this.s;
        if (i2 == 1) {
            return this.f57192f.left + this.f57191e.getWidth();
        }
        if (i2 == 2) {
            return this.f57192f.left - this.f57191e.getWidth();
        }
        if (i2 == 4) {
            return this.f57192f.left;
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f57192f.left;
    }

    private int getMainOpenTop() {
        int i2 = this.s;
        if (i2 == 1) {
            return this.f57192f.top;
        }
        if (i2 == 2) {
            return this.f57192f.top;
        }
        if (i2 == 4) {
            return this.f57192f.top + this.f57191e.getHeight();
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f57192f.top - this.f57191e.getHeight();
    }

    private int getSecOpenLeft() {
        int i2;
        if (this.p == 0 || (i2 = this.s) == 8 || i2 == 4) {
            return this.f57194h.left;
        }
        if (i2 == 1) {
            return this.f57194h.left + this.f57191e.getWidth();
        }
        return this.f57194h.left - this.f57191e.getWidth();
    }

    private int getSecOpenTop() {
        int i2;
        if (this.p == 0 || (i2 = this.s) == 1 || i2 == 2) {
            return this.f57194h.top;
        }
        if (i2 == 4) {
            return this.f57194h.top + this.f57191e.getHeight();
        }
        return this.f57194h.top - this.f57191e.getHeight();
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (!(attributeSet == null || context == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeRevealLayoutPassbook, 0, 0);
            this.s = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayoutPassbook_dragEdgeSRLP, 1);
            this.n = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayoutPassbook_flingVelocitySRLP, 300);
            this.p = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayoutPassbook_modeSRLP, 0);
            this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwipeRevealLayoutPassbook_minDistRequestDisallowParentSRLP, a());
        }
        this.f57188b = c.a((ViewGroup) this, 1.0f, this.A);
        this.f57188b.f3238e = 15;
        this.x = new d(context, this.t);
    }

    /* access modifiers changed from: private */
    public int getDistToClosestEdge() {
        int i2 = this.s;
        if (i2 == 1) {
            return Math.min(this.f57190d.getLeft() - this.f57192f.left, (this.f57192f.left + this.f57191e.getWidth()) - this.f57190d.getLeft());
        } else if (i2 == 2) {
            return Math.min(this.f57190d.getRight() - (this.f57192f.right - this.f57191e.getWidth()), this.f57192f.right - this.f57190d.getRight());
        } else if (i2 == 4) {
            int height = this.f57192f.top + this.f57191e.getHeight();
            return Math.min(this.f57190d.getBottom() - height, height - this.f57190d.getTop());
        } else if (i2 != 8) {
            return 0;
        } else {
            return Math.min(this.f57192f.bottom - this.f57190d.getBottom(), this.f57190d.getBottom() - (this.f57192f.bottom - this.f57191e.getHeight()));
        }
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotHorizontal() {
        if (this.s == 1) {
            return this.f57192f.left + (this.f57191e.getWidth() / 2);
        }
        return this.f57192f.right - (this.f57191e.getWidth() / 2);
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotVertical() {
        if (this.s == 4) {
            return this.f57192f.top + (this.f57191e.getHeight() / 2);
        }
        return this.f57192f.bottom - (this.f57191e.getHeight() / 2);
    }

    private int a() {
        return (int) ((((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f) * 1.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.m
            if (r0 == 0) goto L_0x0009
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        L_0x0009:
            androidx.customview.a.c r0 = r6.f57188b
            r0.b((android.view.MotionEvent) r7)
            androidx.core.h.d r0 = r6.x
            r0.a(r7)
            int r0 = r7.getAction()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0020
            r0 = 0
            r6.u = r0
            goto L_0x004e
        L_0x0020:
            int r0 = r6.getDragEdge()
            if (r0 == r3) goto L_0x002f
            int r0 = r6.getDragEdge()
            if (r0 != r1) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r0 = 0
            goto L_0x0030
        L_0x002f:
            r0 = 1
        L_0x0030:
            if (r0 == 0) goto L_0x003e
            float r0 = r7.getX()
            float r4 = r6.v
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L_0x0049
        L_0x003e:
            float r0 = r7.getY()
            float r4 = r6.w
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
        L_0x0049:
            float r4 = r6.u
            float r4 = r4 + r0
            r6.u = r4
        L_0x004e:
            float r0 = r7.getX()
            float r4 = r7.getY()
            android.view.View r5 = r6.f57190d
            int r5 = r5.getTop()
            float r5 = (float) r5
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x006e
            android.view.View r5 = r6.f57190d
            int r5 = r5.getBottom()
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x006e
            r4 = 1
            goto L_0x006f
        L_0x006e:
            r4 = 0
        L_0x006f:
            android.view.View r5 = r6.f57190d
            int r5 = r5.getLeft()
            float r5 = (float) r5
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x0087
            android.view.View r5 = r6.f57190d
            int r5 = r5.getRight()
            float r5 = (float) r5
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0087
            r0 = 1
            goto L_0x0088
        L_0x0087:
            r0 = 0
        L_0x0088:
            if (r4 == 0) goto L_0x008e
            if (r0 == 0) goto L_0x008e
            r0 = 1
            goto L_0x008f
        L_0x008e:
            r0 = 0
        L_0x008f:
            if (r0 == 0) goto L_0x00a3
            androidx.customview.a.c r0 = r6.f57188b
            int r0 = r0.f3235b
            float r0 = (float) r0
            float r4 = r6.u
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x009e
            r0 = 1
            goto L_0x009f
        L_0x009e:
            r0 = 0
        L_0x009f:
            if (r0 != 0) goto L_0x00a3
            r0 = 1
            goto L_0x00a4
        L_0x00a3:
            r0 = 0
        L_0x00a4:
            androidx.customview.a.c r4 = r6.f57188b
            int r4 = r4.f3234a
            if (r4 != r1) goto L_0x00ac
            r1 = 1
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            androidx.customview.a.c r4 = r6.f57188b
            int r4 = r4.f3234a
            if (r4 != 0) goto L_0x00b9
            boolean r4 = r6.l
            if (r4 == 0) goto L_0x00b9
            r4 = 1
            goto L_0x00ba
        L_0x00b9:
            r4 = 0
        L_0x00ba:
            float r5 = r7.getX()
            r6.v = r5
            float r7 = r7.getY()
            r6.w = r7
            if (r0 != 0) goto L_0x00cd
            if (r1 != 0) goto L_0x00cc
            if (r4 == 0) goto L_0x00cd
        L_0x00cc:
            return r3
        L_0x00cd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.customview.SwipeRevealLayoutPassbook.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    static /* synthetic */ int a(SwipeRevealLayoutPassbook swipeRevealLayoutPassbook, int i2) {
        return (int) (((float) i2) / (((float) swipeRevealLayoutPassbook.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
