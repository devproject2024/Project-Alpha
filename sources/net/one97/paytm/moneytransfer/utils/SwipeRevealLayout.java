package net.one97.paytm.moneytransfer.utils;

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
import net.one97.paytm.moneytransfer.R;

public class SwipeRevealLayout extends ViewGroup {
    private final c.a A = new c.a() {
        public final boolean b(View view, int i2) {
            boolean unused = SwipeRevealLayout.this.f54144a = false;
            if (SwipeRevealLayout.this.m) {
                return false;
            }
            SwipeRevealLayout.this.f54145b.a(SwipeRevealLayout.this.f54147d, i2);
            return false;
        }

        public final int d(View view, int i2) {
            int g2 = SwipeRevealLayout.this.s;
            if (g2 == 4) {
                return Math.max(Math.min(i2, SwipeRevealLayout.this.f54149f.top + SwipeRevealLayout.this.f54148e.getHeight()), SwipeRevealLayout.this.f54149f.top);
            }
            if (g2 != 8) {
                return view.getTop();
            }
            return Math.max(Math.min(i2, SwipeRevealLayout.this.f54149f.top), SwipeRevealLayout.this.f54149f.top - SwipeRevealLayout.this.f54148e.getHeight());
        }

        public final int c(View view, int i2) {
            int g2 = SwipeRevealLayout.this.s;
            if (g2 == 1) {
                return Math.max(Math.min(i2, SwipeRevealLayout.this.f54149f.left + SwipeRevealLayout.this.f54148e.getWidth()), SwipeRevealLayout.this.f54149f.left);
            }
            if (g2 != 2) {
                return view.getLeft();
            }
            return Math.max(Math.min(i2, SwipeRevealLayout.this.f54149f.left), SwipeRevealLayout.this.f54149f.left - SwipeRevealLayout.this.f54148e.getWidth());
        }

        public final void a(View view, float f2, float f3) {
            int i2 = (int) f2;
            boolean z = false;
            boolean z2 = SwipeRevealLayout.a(SwipeRevealLayout.this, i2) >= SwipeRevealLayout.this.n;
            boolean z3 = SwipeRevealLayout.a(SwipeRevealLayout.this, i2) <= (-SwipeRevealLayout.this.n);
            int i3 = (int) f3;
            boolean z4 = SwipeRevealLayout.a(SwipeRevealLayout.this, i3) <= (-SwipeRevealLayout.this.n);
            if (SwipeRevealLayout.a(SwipeRevealLayout.this, i3) >= SwipeRevealLayout.this.n) {
                z = true;
            }
            int k = SwipeRevealLayout.this.getHalfwayPivotHorizontal();
            int l = SwipeRevealLayout.this.getHalfwayPivotVertical();
            int g2 = SwipeRevealLayout.this.s;
            if (g2 != 1) {
                if (g2 != 2) {
                    if (g2 != 4) {
                        if (g2 == 8) {
                            if (z4) {
                                SwipeRevealLayout.this.a(true);
                                return;
                            } else if (!z && SwipeRevealLayout.this.f54147d.getBottom() < l) {
                                SwipeRevealLayout.this.a(true);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!z4) {
                        if (z) {
                            SwipeRevealLayout.this.a(true);
                            return;
                        } else if (SwipeRevealLayout.this.f54147d.getTop() >= l) {
                            SwipeRevealLayout.this.a(true);
                            return;
                        }
                    }
                } else if (!z2) {
                    if (z3) {
                        SwipeRevealLayout.this.a(true);
                        return;
                    } else if (SwipeRevealLayout.this.f54147d.getRight() < k) {
                        SwipeRevealLayout.this.a(true);
                        return;
                    } else {
                        SwipeRevealLayout.this.b(true);
                        return;
                    }
                }
            } else if (z2) {
                SwipeRevealLayout.this.a(true);
                return;
            } else if (!z3 && SwipeRevealLayout.this.f54147d.getLeft() >= k) {
                SwipeRevealLayout.this.a(true);
                return;
            }
            SwipeRevealLayout.this.b(true);
        }

        public final void a(int i2, int i3) {
            super.a(i2, i3);
            if (!SwipeRevealLayout.this.m) {
                boolean z = false;
                boolean z2 = SwipeRevealLayout.this.s == 2 && i2 == 1;
                boolean z3 = SwipeRevealLayout.this.s == 1 && i2 == 2;
                boolean z4 = SwipeRevealLayout.this.s == 8 && i2 == 4;
                if (SwipeRevealLayout.this.s == 4 && i2 == 8) {
                    z = true;
                }
                if (z2 || z3 || z4 || z) {
                    SwipeRevealLayout.this.f54145b.a(SwipeRevealLayout.this.f54147d, i3);
                }
            }
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            super.a(view, i2, i3, i4, i5);
            if (SwipeRevealLayout.this.p == 1) {
                if (SwipeRevealLayout.this.s == 1 || SwipeRevealLayout.this.s == 2) {
                    SwipeRevealLayout.this.f54148e.offsetLeftAndRight(i4);
                } else {
                    SwipeRevealLayout.this.f54148e.offsetTopAndBottom(i5);
                }
            }
            boolean z = (SwipeRevealLayout.this.f54147d.getLeft() == SwipeRevealLayout.this.q && SwipeRevealLayout.this.f54147d.getTop() == SwipeRevealLayout.this.r) ? false : true;
            if (SwipeRevealLayout.this.y != null && z) {
                if (SwipeRevealLayout.this.f54147d.getLeft() == SwipeRevealLayout.this.f54149f.left && SwipeRevealLayout.this.f54147d.getTop() == SwipeRevealLayout.this.f54149f.top) {
                    b unused = SwipeRevealLayout.this.y;
                } else if (SwipeRevealLayout.this.f54147d.getLeft() == SwipeRevealLayout.this.f54150g.left && SwipeRevealLayout.this.f54147d.getTop() == SwipeRevealLayout.this.f54150g.top) {
                    b unused2 = SwipeRevealLayout.this.y;
                } else {
                    b unused3 = SwipeRevealLayout.this.y;
                    int g2 = SwipeRevealLayout.this.s;
                    if (g2 == 1) {
                        SwipeRevealLayout.this.f54147d.getLeft();
                        int i6 = SwipeRevealLayout.this.f54149f.left;
                        SwipeRevealLayout.this.f54148e.getWidth();
                    } else if (g2 == 2) {
                        int i7 = SwipeRevealLayout.this.f54149f.left;
                        SwipeRevealLayout.this.f54147d.getLeft();
                        SwipeRevealLayout.this.f54148e.getWidth();
                    } else if (g2 == 4) {
                        SwipeRevealLayout.this.f54147d.getTop();
                        int i8 = SwipeRevealLayout.this.f54149f.top;
                        SwipeRevealLayout.this.f54148e.getHeight();
                    } else if (g2 == 8) {
                        int i9 = SwipeRevealLayout.this.f54149f.top;
                        SwipeRevealLayout.this.f54147d.getTop();
                        SwipeRevealLayout.this.f54148e.getHeight();
                    }
                }
            }
            SwipeRevealLayout swipeRevealLayout = SwipeRevealLayout.this;
            int unused4 = swipeRevealLayout.q = swipeRevealLayout.f54147d.getLeft();
            SwipeRevealLayout swipeRevealLayout2 = SwipeRevealLayout.this;
            int unused5 = swipeRevealLayout2.r = swipeRevealLayout2.f54147d.getTop();
            u.g(SwipeRevealLayout.this);
        }

        public final void a(int i2) {
            super.a(i2);
            int r = SwipeRevealLayout.this.o;
            if (i2 != 0) {
                if (i2 == 1) {
                    int unused = SwipeRevealLayout.this.o = 4;
                }
            } else if (SwipeRevealLayout.this.s == 1 || SwipeRevealLayout.this.s == 2) {
                if (SwipeRevealLayout.this.f54147d.getLeft() == SwipeRevealLayout.this.f54149f.left) {
                    int unused2 = SwipeRevealLayout.this.o = 0;
                } else {
                    int unused3 = SwipeRevealLayout.this.o = 2;
                }
            } else if (SwipeRevealLayout.this.f54147d.getTop() == SwipeRevealLayout.this.f54149f.top) {
                int unused4 = SwipeRevealLayout.this.o = 0;
            } else {
                int unused5 = SwipeRevealLayout.this.o = 2;
            }
            if (SwipeRevealLayout.this.x != null && !SwipeRevealLayout.this.f54144a && r != SwipeRevealLayout.this.o) {
                SwipeRevealLayout.this.x.a(SwipeRevealLayout.this.o);
            }
        }
    };
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f54144a = false;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public c f54145b;

    /* renamed from: c  reason: collision with root package name */
    int f54146c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f54147d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f54148e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Rect f54149f = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Rect f54150g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private Rect f54151h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private Rect f54152i = new Rect();
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
    public b y;
    private final GestureDetector.OnGestureListener z = new GestureDetector.SimpleOnGestureListener() {

        /* renamed from: a  reason: collision with root package name */
        boolean f54153a = false;

        public final boolean onDown(MotionEvent motionEvent) {
            boolean unused = SwipeRevealLayout.this.l = false;
            this.f54153a = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean unused = SwipeRevealLayout.this.l = true;
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean z;
            boolean unused = SwipeRevealLayout.this.l = true;
            if (SwipeRevealLayout.this.getParent() != null) {
                if (!this.f54153a) {
                    z = SwipeRevealLayout.this.getDistToClosestEdge() >= SwipeRevealLayout.this.j;
                    if (z) {
                        this.f54153a = true;
                    }
                } else {
                    z = true;
                }
                SwipeRevealLayout.this.getParent().requestDisallowInterceptTouchEvent(z);
            }
            return false;
        }
    };

    interface a {
        void a(int i2);
    }

    public interface b {
    }

    public SwipeRevealLayout(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.w.a(motionEvent);
        this.f54145b.b(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 2) {
            this.f54148e = getChildAt(0);
            this.f54147d = getChildAt(1);
        } else if (getChildCount() == 1) {
            this.f54147d = getChildAt(0);
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
        this.f54144a = false;
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
                View view = this.f54148e;
                view.offsetLeftAndRight(-view.getWidth());
            } else if (i13 == 2) {
                View view2 = this.f54148e;
                view2.offsetLeftAndRight(view2.getWidth());
            } else if (i13 == 4) {
                View view3 = this.f54148e;
                view3.offsetTopAndBottom(-view3.getHeight());
            } else if (i13 == 8) {
                View view4 = this.f54148e;
                view4.offsetTopAndBottom(view4.getHeight());
            }
        }
        this.f54149f.set(this.f54147d.getLeft(), this.f54147d.getTop(), this.f54147d.getRight(), this.f54147d.getBottom());
        this.f54151h.set(this.f54148e.getLeft(), this.f54148e.getTop(), this.f54148e.getRight(), this.f54148e.getBottom());
        this.f54150g.set(getMainOpenLeft(), getMainOpenTop(), getMainOpenLeft() + this.f54147d.getWidth(), getMainOpenTop() + this.f54147d.getHeight());
        this.f54152i.set(getSecOpenLeft(), getSecOpenTop(), getSecOpenLeft() + this.f54148e.getWidth(), getSecOpenTop() + this.f54148e.getHeight());
        if (this.k) {
            a(false);
        } else {
            b(false);
        }
        this.q = this.f54147d.getLeft();
        this.r = this.f54147d.getTop();
        this.f54146c++;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009e, code lost:
        if (r13 > r4) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ab, code lost:
        if (r14 > r7) goto L_0x00ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r13, int r14) {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 2
            if (r0 < r1) goto L_0x00b2
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
            if (r3 >= r8) goto L_0x007c
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
            int r8 = r8.getMeasuredHeight()
            int r6 = java.lang.Math.max(r8, r6)
            int r3 = r3 + 1
            goto L_0x0047
        L_0x007c:
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
            if (r1 != r5) goto L_0x0097
            goto L_0x00a0
        L_0x0097:
            int r6 = r0.width
            if (r6 != r9) goto L_0x009c
            r13 = r4
        L_0x009c:
            if (r1 != r3) goto L_0x00a1
            if (r13 <= r4) goto L_0x00a1
        L_0x00a0:
            r13 = r4
        L_0x00a1:
            if (r2 != r5) goto L_0x00a4
            goto L_0x00ad
        L_0x00a4:
            int r0 = r0.height
            if (r0 != r9) goto L_0x00a9
            r14 = r7
        L_0x00a9:
            if (r2 != r3) goto L_0x00ae
            if (r14 <= r7) goto L_0x00ae
        L_0x00ad:
            r14 = r7
        L_0x00ae:
            r12.setMeasuredDimension(r13, r14)
            return
        L_0x00b2:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Layout must have two children"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.utils.SwipeRevealLayout.onMeasure(int, int):void");
    }

    public void computeScroll() {
        if (this.f54145b.f()) {
            u.g(this);
        }
    }

    public final void a(boolean z2) {
        this.k = true;
        this.f54144a = false;
        if (z2) {
            this.o = 3;
            this.f54145b.a(this.f54147d, this.f54150g.left, this.f54150g.top);
            a aVar = this.x;
            if (aVar != null) {
                aVar.a(this.o);
            }
        } else {
            this.o = 2;
            this.f54145b.e();
            this.f54147d.layout(this.f54150g.left, this.f54150g.top, this.f54150g.right, this.f54150g.bottom);
            this.f54148e.layout(this.f54152i.left, this.f54152i.top, this.f54152i.right, this.f54152i.bottom);
        }
        u.g(this);
    }

    public final void b(boolean z2) {
        this.k = false;
        this.f54144a = false;
        if (z2) {
            this.o = 1;
            this.f54145b.a(this.f54147d, this.f54149f.left, this.f54149f.top);
            a aVar = this.x;
            if (aVar != null) {
                aVar.a(this.o);
            }
        } else {
            this.o = 0;
            this.f54145b.e();
            this.f54147d.layout(this.f54149f.left, this.f54149f.top, this.f54149f.right, this.f54149f.bottom);
            this.f54148e.layout(this.f54151h.left, this.f54151h.top, this.f54151h.right, this.f54151h.bottom);
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

    public void setSwipeListener(b bVar) {
        this.y = bVar;
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
            return this.f54149f.left + this.f54148e.getWidth();
        }
        if (i2 == 2) {
            return this.f54149f.left - this.f54148e.getWidth();
        }
        if (i2 == 4) {
            return this.f54149f.left;
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f54149f.left;
    }

    private int getMainOpenTop() {
        int i2 = this.s;
        if (i2 == 1) {
            return this.f54149f.top;
        }
        if (i2 == 2) {
            return this.f54149f.top;
        }
        if (i2 == 4) {
            return this.f54149f.top + this.f54148e.getHeight();
        }
        if (i2 != 8) {
            return 0;
        }
        return this.f54149f.top - this.f54148e.getHeight();
    }

    private int getSecOpenLeft() {
        int i2;
        if (this.p == 0 || (i2 = this.s) == 8 || i2 == 4) {
            return this.f54151h.left;
        }
        if (i2 == 1) {
            return this.f54151h.left + this.f54148e.getWidth();
        }
        return this.f54151h.left - this.f54148e.getWidth();
    }

    private int getSecOpenTop() {
        int i2;
        if (this.p == 0 || (i2 = this.s) == 1 || i2 == 2) {
            return this.f54151h.top;
        }
        if (i2 == 4) {
            return this.f54151h.top + this.f54148e.getHeight();
        }
        return this.f54151h.top - this.f54148e.getHeight();
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (!(attributeSet == null || context == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeRevealLayout, 0, 0);
            this.s = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayout_dragEdge, 1);
            this.n = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayout_flingVelocity, 300);
            this.p = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayout_mode, 0);
            this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwipeRevealLayout_minDistRequestDisallowParent, a());
            obtainStyledAttributes.recycle();
        }
        this.f54145b = c.a((ViewGroup) this, 1.0f, this.A);
        this.f54145b.f3238e = 15;
        this.w = new d(context, this.z);
    }

    /* access modifiers changed from: private */
    public int getDistToClosestEdge() {
        int i2 = this.s;
        if (i2 == 1) {
            return Math.min(this.f54147d.getLeft() - this.f54149f.left, (this.f54149f.left + this.f54148e.getWidth()) - this.f54147d.getLeft());
        } else if (i2 == 2) {
            return Math.min(this.f54147d.getRight() - (this.f54149f.right - this.f54148e.getWidth()), this.f54149f.right - this.f54147d.getRight());
        } else if (i2 == 4) {
            int height = this.f54149f.top + this.f54148e.getHeight();
            return Math.min(this.f54147d.getBottom() - height, height - this.f54147d.getTop());
        } else if (i2 != 8) {
            return 0;
        } else {
            return Math.min(this.f54149f.bottom - this.f54147d.getBottom(), this.f54147d.getBottom() - (this.f54149f.bottom - this.f54148e.getHeight()));
        }
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotHorizontal() {
        if (this.s == 1) {
            return this.f54149f.left + (this.f54148e.getWidth() / 2);
        }
        return this.f54149f.right - (this.f54148e.getWidth() / 2);
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotVertical() {
        if (this.s == 4) {
            return this.f54149f.top + (this.f54148e.getHeight() / 2);
        }
        return this.f54149f.bottom - (this.f54148e.getHeight() / 2);
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
            androidx.customview.a.c r0 = r6.f54145b
            r0.b((android.view.MotionEvent) r7)
            androidx.core.h.d r0 = r6.w
            r0.a(r7)
            int r0 = r7.getAction()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0020
            r0 = 0
            r6.t = r0
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
            float r4 = r6.u
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L_0x0049
        L_0x003e:
            float r0 = r7.getY()
            float r4 = r6.v
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
        L_0x0049:
            float r4 = r6.t
            float r4 = r4 + r0
            r6.t = r4
        L_0x004e:
            float r0 = r7.getX()
            float r4 = r7.getY()
            android.view.View r5 = r6.f54147d
            int r5 = r5.getTop()
            float r5 = (float) r5
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x006e
            android.view.View r5 = r6.f54147d
            int r5 = r5.getBottom()
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x006e
            r4 = 1
            goto L_0x006f
        L_0x006e:
            r4 = 0
        L_0x006f:
            android.view.View r5 = r6.f54147d
            int r5 = r5.getLeft()
            float r5 = (float) r5
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x0087
            android.view.View r5 = r6.f54147d
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
            androidx.customview.a.c r0 = r6.f54145b
            int r0 = r0.f3235b
            float r0 = (float) r0
            float r4 = r6.t
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
            androidx.customview.a.c r4 = r6.f54145b
            int r4 = r4.f3234a
            if (r4 != r1) goto L_0x00ac
            r1 = 1
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            androidx.customview.a.c r4 = r6.f54145b
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
            r6.u = r5
            float r7 = r7.getY()
            r6.v = r7
            if (r0 != 0) goto L_0x00cd
            if (r1 != 0) goto L_0x00cc
            if (r4 == 0) goto L_0x00cd
        L_0x00cc:
            return r3
        L_0x00cd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.utils.SwipeRevealLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    static /* synthetic */ int a(SwipeRevealLayout swipeRevealLayout, int i2) {
        return (int) (((float) i2) / (((float) swipeRevealLayout.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
