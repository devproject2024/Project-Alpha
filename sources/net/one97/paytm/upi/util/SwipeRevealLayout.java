package net.one97.paytm.upi.util;

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
import net.one97.paytm.upi.R;

public class SwipeRevealLayout extends ViewGroup {
    private static final int DEFAULT_MIN_DIST_REQUEST_DISALLOW_PARENT = 1;
    private static final int DEFAULT_MIN_FLING_VELOCITY = 300;
    public static final int DRAG_EDGE_BOTTOM = 8;
    public static final int DRAG_EDGE_LEFT = 1;
    public static final int DRAG_EDGE_RIGHT = 2;
    public static final int DRAG_EDGE_TOP = 4;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_SAME_LEVEL = 1;
    public static final int STATE_CLOSE = 0;
    public static final int STATE_CLOSING = 1;
    public static final int STATE_DRAGGING = 4;
    public static final int STATE_OPEN = 2;
    public static final int STATE_OPENING = 3;
    /* access modifiers changed from: private */
    public volatile boolean mAborted = false;
    private float mDragDist = 0.0f;
    /* access modifiers changed from: private */
    public int mDragEdge = 1;
    /* access modifiers changed from: private */
    public c mDragHelper;
    private final c.a mDragHelperCallback = new c.a() {
        public final boolean b(View view, int i2) {
            boolean unused = SwipeRevealLayout.this.mAborted = false;
            if (SwipeRevealLayout.this.mLockDrag) {
                return false;
            }
            SwipeRevealLayout.this.mDragHelper.a(SwipeRevealLayout.this.mMainView, i2);
            return false;
        }

        public final int d(View view, int i2) {
            int access$700 = SwipeRevealLayout.this.mDragEdge;
            if (access$700 == 4) {
                return Math.max(Math.min(i2, SwipeRevealLayout.this.mRectMainClose.top + SwipeRevealLayout.this.mSecondaryView.getHeight()), SwipeRevealLayout.this.mRectMainClose.top);
            }
            if (access$700 != 8) {
                return view.getTop();
            }
            return Math.max(Math.min(i2, SwipeRevealLayout.this.mRectMainClose.top), SwipeRevealLayout.this.mRectMainClose.top - SwipeRevealLayout.this.mSecondaryView.getHeight());
        }

        public final int c(View view, int i2) {
            int access$700 = SwipeRevealLayout.this.mDragEdge;
            if (access$700 == 1) {
                return Math.max(Math.min(i2, SwipeRevealLayout.this.mRectMainClose.left + SwipeRevealLayout.this.mSecondaryView.getWidth()), SwipeRevealLayout.this.mRectMainClose.left);
            }
            if (access$700 != 2) {
                return view.getLeft();
            }
            return Math.max(Math.min(i2, SwipeRevealLayout.this.mRectMainClose.left), SwipeRevealLayout.this.mRectMainClose.left - SwipeRevealLayout.this.mSecondaryView.getWidth());
        }

        public final void a(View view, float f2, float f3) {
            int i2 = (int) f2;
            boolean z = false;
            boolean z2 = SwipeRevealLayout.this.pxToDp(i2) >= SwipeRevealLayout.this.mMinFlingVelocity;
            boolean z3 = SwipeRevealLayout.this.pxToDp(i2) <= (-SwipeRevealLayout.this.mMinFlingVelocity);
            int i3 = (int) f3;
            boolean z4 = SwipeRevealLayout.this.pxToDp(i3) <= (-SwipeRevealLayout.this.mMinFlingVelocity);
            if (SwipeRevealLayout.this.pxToDp(i3) >= SwipeRevealLayout.this.mMinFlingVelocity) {
                z = true;
            }
            int access$1200 = SwipeRevealLayout.this.getHalfwayPivotHorizontal();
            int access$1300 = SwipeRevealLayout.this.getHalfwayPivotVertical();
            int access$700 = SwipeRevealLayout.this.mDragEdge;
            if (access$700 != 1) {
                if (access$700 != 2) {
                    if (access$700 != 4) {
                        if (access$700 == 8) {
                            if (z4) {
                                SwipeRevealLayout.this.open(true);
                                return;
                            } else if (!z && SwipeRevealLayout.this.mMainView.getBottom() < access$1300) {
                                SwipeRevealLayout.this.open(true);
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (!z4) {
                        if (z) {
                            SwipeRevealLayout.this.open(true);
                            return;
                        } else if (SwipeRevealLayout.this.mMainView.getTop() >= access$1300) {
                            SwipeRevealLayout.this.open(true);
                            return;
                        }
                    }
                } else if (!z2) {
                    if (z3) {
                        SwipeRevealLayout.this.open(true);
                        return;
                    } else if (SwipeRevealLayout.this.mMainView.getRight() < access$1200) {
                        SwipeRevealLayout.this.open(true);
                        return;
                    } else {
                        SwipeRevealLayout.this.close(true);
                        return;
                    }
                }
            } else if (z2) {
                SwipeRevealLayout.this.open(true);
                return;
            } else if (!z3 && SwipeRevealLayout.this.mMainView.getLeft() >= access$1200) {
                SwipeRevealLayout.this.open(true);
                return;
            }
            SwipeRevealLayout.this.close(true);
        }

        public final void a(int i2, int i3) {
            super.a(i2, i3);
            if (!SwipeRevealLayout.this.mLockDrag) {
                boolean z = false;
                boolean z2 = SwipeRevealLayout.this.mDragEdge == 2 && i2 == 1;
                boolean z3 = SwipeRevealLayout.this.mDragEdge == 1 && i2 == 2;
                boolean z4 = SwipeRevealLayout.this.mDragEdge == 8 && i2 == 4;
                if (SwipeRevealLayout.this.mDragEdge == 4 && i2 == 8) {
                    z = true;
                }
                if (z2 || z3 || z4 || z) {
                    SwipeRevealLayout.this.mDragHelper.a(SwipeRevealLayout.this.mMainView, i3);
                }
            }
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            float f2;
            int i6;
            float f3;
            super.a(view, i2, i3, i4, i5);
            if (SwipeRevealLayout.this.mMode == 1) {
                if (SwipeRevealLayout.this.mDragEdge == 1 || SwipeRevealLayout.this.mDragEdge == 2) {
                    SwipeRevealLayout.this.mSecondaryView.offsetLeftAndRight(i4);
                } else {
                    SwipeRevealLayout.this.mSecondaryView.offsetTopAndBottom(i5);
                }
            }
            boolean z = (SwipeRevealLayout.this.mMainView.getLeft() == SwipeRevealLayout.this.mLastMainLeft && SwipeRevealLayout.this.mMainView.getTop() == SwipeRevealLayout.this.mLastMainTop) ? false : true;
            if (SwipeRevealLayout.this.mSwipeListener != null && z) {
                if (SwipeRevealLayout.this.mMainView.getLeft() == SwipeRevealLayout.this.mRectMainClose.left && SwipeRevealLayout.this.mMainView.getTop() == SwipeRevealLayout.this.mRectMainClose.top) {
                    SwipeRevealLayout.this.mSwipeListener.onClosed(SwipeRevealLayout.this);
                } else if (SwipeRevealLayout.this.mMainView.getLeft() == SwipeRevealLayout.this.mRectMainOpen.left && SwipeRevealLayout.this.mMainView.getTop() == SwipeRevealLayout.this.mRectMainOpen.top) {
                    SwipeRevealLayout.this.mSwipeListener.onOpened(SwipeRevealLayout.this);
                } else {
                    SwipeListener access$1700 = SwipeRevealLayout.this.mSwipeListener;
                    SwipeRevealLayout swipeRevealLayout = SwipeRevealLayout.this;
                    int access$700 = swipeRevealLayout.mDragEdge;
                    if (access$700 == 1) {
                        f3 = (float) (SwipeRevealLayout.this.mMainView.getLeft() - SwipeRevealLayout.this.mRectMainClose.left);
                        i6 = SwipeRevealLayout.this.mSecondaryView.getWidth();
                    } else if (access$700 == 2) {
                        f3 = (float) (SwipeRevealLayout.this.mRectMainClose.left - SwipeRevealLayout.this.mMainView.getLeft());
                        i6 = SwipeRevealLayout.this.mSecondaryView.getWidth();
                    } else if (access$700 == 4) {
                        f3 = (float) (SwipeRevealLayout.this.mMainView.getTop() - SwipeRevealLayout.this.mRectMainClose.top);
                        i6 = SwipeRevealLayout.this.mSecondaryView.getHeight();
                    } else if (access$700 != 8) {
                        f2 = 0.0f;
                        access$1700.onSlide(swipeRevealLayout, f2);
                    } else {
                        f3 = (float) (SwipeRevealLayout.this.mRectMainClose.top - SwipeRevealLayout.this.mMainView.getTop());
                        i6 = SwipeRevealLayout.this.mSecondaryView.getHeight();
                    }
                    f2 = f3 / ((float) i6);
                    access$1700.onSlide(swipeRevealLayout, f2);
                }
            }
            SwipeRevealLayout swipeRevealLayout2 = SwipeRevealLayout.this;
            int unused = swipeRevealLayout2.mLastMainLeft = swipeRevealLayout2.mMainView.getLeft();
            SwipeRevealLayout swipeRevealLayout3 = SwipeRevealLayout.this;
            int unused2 = swipeRevealLayout3.mLastMainTop = swipeRevealLayout3.mMainView.getTop();
            u.g(SwipeRevealLayout.this);
        }

        public final void a(int i2) {
            super.a(i2);
            int access$1900 = SwipeRevealLayout.this.mState;
            if (i2 != 0) {
                if (i2 == 1) {
                    int unused = SwipeRevealLayout.this.mState = 4;
                }
            } else if (SwipeRevealLayout.this.mDragEdge == 1 || SwipeRevealLayout.this.mDragEdge == 2) {
                if (SwipeRevealLayout.this.mMainView.getLeft() == SwipeRevealLayout.this.mRectMainClose.left) {
                    int unused2 = SwipeRevealLayout.this.mState = 0;
                } else {
                    int unused3 = SwipeRevealLayout.this.mState = 2;
                }
            } else if (SwipeRevealLayout.this.mMainView.getTop() == SwipeRevealLayout.this.mRectMainClose.top) {
                int unused4 = SwipeRevealLayout.this.mState = 0;
            } else {
                int unused5 = SwipeRevealLayout.this.mState = 2;
            }
            if (SwipeRevealLayout.this.mDragStateChangeListener != null && !SwipeRevealLayout.this.mAborted && access$1900 != SwipeRevealLayout.this.mState) {
                SwipeRevealLayout.this.mDragStateChangeListener.onDragStateChanged(SwipeRevealLayout.this.mState);
            }
        }
    };
    /* access modifiers changed from: private */
    public DragStateChangeListener mDragStateChangeListener;
    private d mGestureDetector;
    private final GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {

        /* renamed from: a  reason: collision with root package name */
        boolean f69536a = false;

        public final boolean onDown(MotionEvent motionEvent) {
            boolean unused = SwipeRevealLayout.this.mIsScrolling = false;
            this.f69536a = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean unused = SwipeRevealLayout.this.mIsScrolling = true;
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean z;
            boolean unused = SwipeRevealLayout.this.mIsScrolling = true;
            if (SwipeRevealLayout.this.getParent() != null) {
                if (!this.f69536a) {
                    z = SwipeRevealLayout.this.getDistToClosestEdge() >= SwipeRevealLayout.this.mMinDistRequestDisallowParent;
                    if (z) {
                        this.f69536a = true;
                    }
                } else {
                    z = true;
                }
                SwipeRevealLayout.this.getParent().requestDisallowInterceptTouchEvent(z);
            }
            return false;
        }
    };
    private boolean mIsOpenBeforeInit = false;
    /* access modifiers changed from: private */
    public volatile boolean mIsScrolling = false;
    /* access modifiers changed from: private */
    public int mLastMainLeft = 0;
    /* access modifiers changed from: private */
    public int mLastMainTop = 0;
    /* access modifiers changed from: private */
    public volatile boolean mLockDrag = false;
    /* access modifiers changed from: private */
    public View mMainView;
    /* access modifiers changed from: private */
    public int mMinDistRequestDisallowParent = 0;
    /* access modifiers changed from: private */
    public int mMinFlingVelocity = 300;
    /* access modifiers changed from: private */
    public int mMode = 0;
    private int mOnLayoutCount = 0;
    private float mPrevX = -1.0f;
    private float mPrevY = -1.0f;
    /* access modifiers changed from: private */
    public Rect mRectMainClose = new Rect();
    /* access modifiers changed from: private */
    public Rect mRectMainOpen = new Rect();
    private Rect mRectSecClose = new Rect();
    private Rect mRectSecOpen = new Rect();
    /* access modifiers changed from: private */
    public View mSecondaryView;
    /* access modifiers changed from: private */
    public int mState = 0;
    /* access modifiers changed from: private */
    public SwipeListener mSwipeListener;

    public interface DragStateChangeListener {
        void onDragStateChanged(int i2);
    }

    public static class SimpleSwipeListener implements SwipeListener {
        public void onClosed(SwipeRevealLayout swipeRevealLayout) {
        }

        public void onOpened(SwipeRevealLayout swipeRevealLayout) {
        }

        public void onSlide(SwipeRevealLayout swipeRevealLayout, float f2) {
        }
    }

    public interface SwipeListener {
        void onClosed(SwipeRevealLayout swipeRevealLayout);

        void onOpened(SwipeRevealLayout swipeRevealLayout);

        void onSlide(SwipeRevealLayout swipeRevealLayout, float f2);
    }

    public static String getStateString(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "undefined" : "state_dragging" : "state_opening" : "state_open" : "state_closing" : "state_close";
    }

    public SwipeRevealLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SwipeRevealLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mGestureDetector.a(motionEvent);
        this.mDragHelper.b(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isDragLocked()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.mDragHelper.b(motionEvent);
        this.mGestureDetector.a(motionEvent);
        accumulateDragDist(motionEvent);
        boolean couldBecomeClick = couldBecomeClick(motionEvent);
        boolean z = this.mDragHelper.f3234a == 2;
        boolean z2 = this.mDragHelper.f3234a == 0 && this.mIsScrolling;
        this.mPrevX = motionEvent.getX();
        this.mPrevY = motionEvent.getY();
        return !couldBecomeClick && (z || z2);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() >= 2) {
            this.mSecondaryView = getChildAt(0);
            this.mMainView = getChildAt(1);
        } else if (getChildCount() == 1) {
            this.mMainView = getChildAt(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        this.mAborted = false;
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
                z2 = layoutParams.height == -1 || layoutParams.height == -1;
                z3 = layoutParams.width == -1 || layoutParams.width == -1;
            } else {
                z3 = false;
                z2 = false;
            }
            if (z2) {
                measuredHeight = max2 - paddingTop;
                layoutParams.height = measuredHeight;
            }
            if (z3) {
                measuredWidth = max - paddingLeft;
                layoutParams.width = measuredWidth;
            }
            int i12 = this.mDragEdge;
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
        if (this.mMode == 1) {
            int i13 = this.mDragEdge;
            if (i13 == 1) {
                View view = this.mSecondaryView;
                view.offsetLeftAndRight(-view.getWidth());
            } else if (i13 == 2) {
                View view2 = this.mSecondaryView;
                view2.offsetLeftAndRight(view2.getWidth());
            } else if (i13 == 4) {
                View view3 = this.mSecondaryView;
                view3.offsetTopAndBottom(-view3.getHeight());
            } else if (i13 == 8) {
                View view4 = this.mSecondaryView;
                view4.offsetTopAndBottom(view4.getHeight());
            }
        }
        initRects();
        if (this.mIsOpenBeforeInit) {
            open(false);
        } else {
            close(false);
        }
        this.mLastMainLeft = this.mMainView.getLeft();
        this.mLastMainTop = this.mMainView.getTop();
        this.mOnLayoutCount++;
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
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.util.SwipeRevealLayout.onMeasure(int, int):void");
    }

    public void computeScroll() {
        if (this.mDragHelper.f()) {
            u.g(this);
        }
    }

    public void open(boolean z) {
        this.mIsOpenBeforeInit = true;
        this.mAborted = false;
        if (z) {
            this.mState = 3;
            this.mDragHelper.a(this.mMainView, this.mRectMainOpen.left, this.mRectMainOpen.top);
            DragStateChangeListener dragStateChangeListener = this.mDragStateChangeListener;
            if (dragStateChangeListener != null) {
                dragStateChangeListener.onDragStateChanged(this.mState);
            }
        } else {
            this.mState = 2;
            this.mDragHelper.e();
            this.mMainView.layout(this.mRectMainOpen.left, this.mRectMainOpen.top, this.mRectMainOpen.right, this.mRectMainOpen.bottom);
            this.mSecondaryView.layout(this.mRectSecOpen.left, this.mRectSecOpen.top, this.mRectSecOpen.right, this.mRectSecOpen.bottom);
        }
        u.g(this);
    }

    public void close(boolean z) {
        this.mIsOpenBeforeInit = false;
        this.mAborted = false;
        if (z) {
            this.mState = 1;
            this.mDragHelper.a(this.mMainView, this.mRectMainClose.left, this.mRectMainClose.top);
            DragStateChangeListener dragStateChangeListener = this.mDragStateChangeListener;
            if (dragStateChangeListener != null) {
                dragStateChangeListener.onDragStateChanged(this.mState);
            }
        } else {
            this.mState = 0;
            this.mDragHelper.e();
            this.mMainView.layout(this.mRectMainClose.left, this.mRectMainClose.top, this.mRectMainClose.right, this.mRectMainClose.bottom);
            this.mSecondaryView.layout(this.mRectSecClose.left, this.mRectSecClose.top, this.mRectSecClose.right, this.mRectSecClose.bottom);
        }
        u.g(this);
    }

    public void setMinFlingVelocity(int i2) {
        this.mMinFlingVelocity = i2;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public void setDragEdge(int i2) {
        this.mDragEdge = i2;
    }

    public int getDragEdge() {
        return this.mDragEdge;
    }

    public void setSwipeListener(SwipeListener swipeListener) {
        this.mSwipeListener = swipeListener;
    }

    public void setLockDrag(boolean z) {
        this.mLockDrag = z;
    }

    public boolean isDragLocked() {
        return this.mLockDrag;
    }

    public boolean isOpened() {
        return this.mState == 2;
    }

    public boolean isClosed() {
        return this.mState == 0;
    }

    public void setDragStateChangeListener(DragStateChangeListener dragStateChangeListener) {
        this.mDragStateChangeListener = dragStateChangeListener;
    }

    public void abort() {
        this.mAborted = true;
        this.mDragHelper.e();
    }

    public boolean shouldRequestLayout() {
        return this.mOnLayoutCount < 2;
    }

    private int getMainOpenLeft() {
        int i2 = this.mDragEdge;
        if (i2 == 1) {
            return this.mRectMainClose.left + this.mSecondaryView.getWidth();
        }
        if (i2 == 2) {
            return this.mRectMainClose.left - this.mSecondaryView.getWidth();
        }
        if (i2 == 4) {
            return this.mRectMainClose.left;
        }
        if (i2 != 8) {
            return 0;
        }
        return this.mRectMainClose.left;
    }

    private int getMainOpenTop() {
        int i2 = this.mDragEdge;
        if (i2 == 1) {
            return this.mRectMainClose.top;
        }
        if (i2 == 2) {
            return this.mRectMainClose.top;
        }
        if (i2 == 4) {
            return this.mRectMainClose.top + this.mSecondaryView.getHeight();
        }
        if (i2 != 8) {
            return 0;
        }
        return this.mRectMainClose.top - this.mSecondaryView.getHeight();
    }

    private int getSecOpenLeft() {
        int i2;
        if (this.mMode == 0 || (i2 = this.mDragEdge) == 8 || i2 == 4) {
            return this.mRectSecClose.left;
        }
        if (i2 == 1) {
            return this.mRectSecClose.left + this.mSecondaryView.getWidth();
        }
        return this.mRectSecClose.left - this.mSecondaryView.getWidth();
    }

    private int getSecOpenTop() {
        int i2;
        if (this.mMode == 0 || (i2 = this.mDragEdge) == 1 || i2 == 2) {
            return this.mRectSecClose.top;
        }
        if (i2 == 4) {
            return this.mRectSecClose.top + this.mSecondaryView.getHeight();
        }
        return this.mRectSecClose.top - this.mSecondaryView.getHeight();
    }

    private void initRects() {
        this.mRectMainClose.set(this.mMainView.getLeft(), this.mMainView.getTop(), this.mMainView.getRight(), this.mMainView.getBottom());
        this.mRectSecClose.set(this.mSecondaryView.getLeft(), this.mSecondaryView.getTop(), this.mSecondaryView.getRight(), this.mSecondaryView.getBottom());
        this.mRectMainOpen.set(getMainOpenLeft(), getMainOpenTop(), getMainOpenLeft() + this.mMainView.getWidth(), getMainOpenTop() + this.mMainView.getHeight());
        this.mRectSecOpen.set(getSecOpenLeft(), getSecOpenTop(), getSecOpenLeft() + this.mSecondaryView.getWidth(), getSecOpenTop() + this.mSecondaryView.getHeight());
    }

    private boolean couldBecomeClick(MotionEvent motionEvent) {
        return isInMainView(motionEvent) && !shouldInitiateADrag();
    }

    private boolean isInMainView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return ((((float) this.mMainView.getTop()) > y ? 1 : (((float) this.mMainView.getTop()) == y ? 0 : -1)) <= 0 && (y > ((float) this.mMainView.getBottom()) ? 1 : (y == ((float) this.mMainView.getBottom()) ? 0 : -1)) <= 0) && ((((float) this.mMainView.getLeft()) > x ? 1 : (((float) this.mMainView.getLeft()) == x ? 0 : -1)) <= 0 && (x > ((float) this.mMainView.getRight()) ? 1 : (x == ((float) this.mMainView.getRight()) ? 0 : -1)) <= 0);
    }

    private boolean shouldInitiateADrag() {
        return this.mDragDist >= ((float) this.mDragHelper.f3235b);
    }

    private void accumulateDragDist(MotionEvent motionEvent) {
        float f2;
        if (motionEvent.getAction() == 0) {
            this.mDragDist = 0.0f;
            return;
        }
        boolean z = true;
        if (!(getDragEdge() == 1 || getDragEdge() == 2)) {
            z = false;
        }
        if (z) {
            f2 = Math.abs(motionEvent.getX() - this.mPrevX);
        } else {
            f2 = Math.abs(motionEvent.getY() - this.mPrevY);
        }
        this.mDragDist += f2;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (!(attributeSet == null || context == null)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeRevealLayout, 0, 0);
            this.mDragEdge = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayout_dragEdge, 1);
            this.mMinFlingVelocity = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayout_flingVelocity, 300);
            this.mMode = obtainStyledAttributes.getInteger(R.styleable.SwipeRevealLayout_mode, 0);
            this.mMinDistRequestDisallowParent = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwipeRevealLayout_minDistRequestDisallowParent, dpToPx(1));
        }
        this.mDragHelper = c.a((ViewGroup) this, 1.0f, this.mDragHelperCallback);
        this.mDragHelper.f3238e = 15;
        this.mGestureDetector = new d(context, this.mGestureListener);
    }

    /* access modifiers changed from: private */
    public int getDistToClosestEdge() {
        int i2 = this.mDragEdge;
        if (i2 == 1) {
            return Math.min(this.mMainView.getLeft() - this.mRectMainClose.left, (this.mRectMainClose.left + this.mSecondaryView.getWidth()) - this.mMainView.getLeft());
        } else if (i2 == 2) {
            return Math.min(this.mMainView.getRight() - (this.mRectMainClose.right - this.mSecondaryView.getWidth()), this.mRectMainClose.right - this.mMainView.getRight());
        } else if (i2 == 4) {
            int height = this.mRectMainClose.top + this.mSecondaryView.getHeight();
            return Math.min(this.mMainView.getBottom() - height, height - this.mMainView.getTop());
        } else if (i2 != 8) {
            return 0;
        } else {
            return Math.min(this.mRectMainClose.bottom - this.mMainView.getBottom(), this.mMainView.getBottom() - (this.mRectMainClose.bottom - this.mSecondaryView.getHeight()));
        }
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotHorizontal() {
        if (this.mDragEdge == 1) {
            return this.mRectMainClose.left + (this.mSecondaryView.getWidth() / 2);
        }
        return this.mRectMainClose.right - (this.mSecondaryView.getWidth() / 2);
    }

    /* access modifiers changed from: private */
    public int getHalfwayPivotVertical() {
        if (this.mDragEdge == 4) {
            return this.mRectMainClose.top + (this.mSecondaryView.getHeight() / 2);
        }
        return this.mRectMainClose.bottom - (this.mSecondaryView.getHeight() / 2);
    }

    /* access modifiers changed from: private */
    public int pxToDp(int i2) {
        return (int) (((float) i2) / (((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }

    private int dpToPx(int i2) {
        return (int) (((float) i2) * (((float) getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f));
    }
}
