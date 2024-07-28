package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.core.h.u;

public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1542a;

    /* renamed from: b  reason: collision with root package name */
    private int f1543b;

    /* renamed from: c  reason: collision with root package name */
    private int f1544c;

    /* renamed from: d  reason: collision with root package name */
    private int f1545d;

    /* renamed from: e  reason: collision with root package name */
    private int f1546e;

    /* renamed from: f  reason: collision with root package name */
    private int f1547f;

    /* renamed from: g  reason: collision with root package name */
    private float f1548g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1549h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f1550i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1542a = true;
        this.f1543b = -1;
        this.f1544c = 0;
        this.f1546e = 8388659;
        ac a2 = ac.a(context, attributeSet, R.styleable.LinearLayoutCompat, i2, 0);
        u.a(this, context, R.styleable.LinearLayoutCompat, attributeSet, a2.f1669a, i2);
        int a3 = a2.a(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (a3 >= 0) {
            setOrientation(a3);
        }
        int a4 = a2.a(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (a4 >= 0) {
            setGravity(a4);
        }
        boolean a5 = a2.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.f1548g = a2.a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1543b = a2.a(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1549h = a2.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.a(R.styleable.LinearLayoutCompat_divider));
        this.n = a2.a(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.o = a2.e(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        a2.f1669a.recycle();
    }

    public void setShowDividers(int i2) {
        if (i2 != this.n) {
            requestLayout();
        }
        this.n = i2;
    }

    public int getShowDividers() {
        return this.n;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.k) {
            this.k = drawable;
            boolean z = false;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
                this.m = drawable.getIntrinsicHeight();
            } else {
                this.l = 0;
                this.m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.o = i2;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.k != null) {
            int i7 = 0;
            if (this.f1545d == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i7 < virtualChildCount) {
                    View childAt = getChildAt(i7);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !a(i7))) {
                        a(canvas, (childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin) - this.m);
                    }
                    i7++;
                }
                if (a(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        i6 = (getHeight() - getPaddingBottom()) - this.m;
                    } else {
                        i6 = childAt2.getBottom() + ((LayoutParams) childAt2.getLayoutParams()).bottomMargin;
                    }
                    a(canvas, i6);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a2 = ai.a(this);
            while (i7 < virtualChildCount2) {
                View childAt3 = getChildAt(i7);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !a(i7))) {
                    LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (a2) {
                        i5 = childAt3.getRight() + layoutParams.rightMargin;
                    } else {
                        i5 = (childAt3.getLeft() - layoutParams.leftMargin) - this.l;
                    }
                    b(canvas, i5);
                }
                i7++;
            }
            if (a(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                    if (a2) {
                        i4 = childAt4.getLeft() - layoutParams2.leftMargin;
                        i3 = this.l;
                    } else {
                        i2 = childAt4.getRight() + layoutParams2.rightMargin;
                        b(canvas, i2);
                    }
                } else if (a2) {
                    i2 = getPaddingLeft();
                    b(canvas, i2);
                } else {
                    i4 = getWidth() - getPaddingRight();
                    i3 = this.l;
                }
                i2 = i4 - i3;
                b(canvas, i2);
            }
        }
    }

    private void a(Canvas canvas, int i2) {
        this.k.setBounds(getPaddingLeft() + this.o, i2, (getWidth() - getPaddingRight()) - this.o, this.m + i2);
        this.k.draw(canvas);
    }

    private void b(Canvas canvas, int i2) {
        this.k.setBounds(i2, getPaddingTop() + this.o, this.l + i2, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f1542a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1549h = z;
    }

    public int getBaseline() {
        int i2;
        if (this.f1543b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f1543b;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i4 = this.f1544c;
                if (this.f1545d == 1 && (i2 = this.f1546e & 112) != 48) {
                    if (i2 == 16) {
                        i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1547f) / 2;
                    } else if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1547f;
                    }
                }
                return i4 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f1543b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1543b;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1543b = i2;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1548g;
    }

    public void setWeightSum(float f2) {
        this.f1548g = Math.max(0.0f, f2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0309  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r6 = r30
            r7 = r31
            r8 = r32
            int r0 = r6.f1545d
            r9 = 1
            if (r0 != r9) goto L_0x036f
            r10 = 0
            r6.f1547f = r10
            int r11 = r30.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r31)
            int r13 = android.view.View.MeasureSpec.getMode(r32)
            int r14 = r6.f1543b
            boolean r15 = r6.f1549h
            r16 = 0
            r0 = 0
            r1 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r9 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            r20 = 0
        L_0x002e:
            if (r5 >= r11) goto L_0x0187
            android.view.View r23 = r6.getChildAt(r5)
            if (r23 != 0) goto L_0x0044
            int r3 = r6.f1547f
            int r3 = r3 + r10
            r6.f1547f = r3
            r21 = r11
            r8 = r20
            r3 = 1
            r20 = r13
            goto L_0x0179
        L_0x0044:
            int r10 = r23.getVisibility()
            r3 = 8
            if (r10 == r3) goto L_0x0162
            boolean r3 = r6.a((int) r5)
            if (r3 == 0) goto L_0x0059
            int r3 = r6.f1547f
            int r10 = r6.m
            int r3 = r3 + r10
            r6.f1547f = r3
        L_0x0059:
            android.view.ViewGroup$LayoutParams r3 = r23.getLayoutParams()
            r10 = r3
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r3 = r10.f1551g
            float r22 = r0 + r3
            r3 = 1073741824(0x40000000, float:2.0)
            if (r13 != r3) goto L_0x0092
            int r0 = r10.height
            if (r0 != 0) goto L_0x0092
            float r0 = r10.f1551g
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x0092
            int r0 = r6.f1547f
            int r3 = r10.topMargin
            int r3 = r3 + r0
            r24 = r1
            int r1 = r10.bottomMargin
            int r3 = r3 + r1
            int r0 = java.lang.Math.max(r0, r3)
            r6.f1547f = r0
            r28 = r4
            r29 = r5
            r21 = r11
            r8 = r20
            r27 = r24
            r17 = 1
            r20 = r13
            goto L_0x00f3
        L_0x0092:
            r24 = r1
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a3
            float r0 = r10.f1551g
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a3
            r0 = -2
            r10.height = r0
            r3 = 0
            goto L_0x00a5
        L_0x00a3:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00a5:
            r25 = 0
            int r0 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x00b0
            int r0 = r6.f1547f
            r26 = r0
            goto L_0x00b2
        L_0x00b0:
            r26 = 0
        L_0x00b2:
            r0 = r30
            r27 = r24
            r1 = r23
            r7 = r2
            r2 = r31
            r21 = r11
            r8 = r20
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r20 = r13
            r13 = r3
            r3 = r25
            r28 = r4
            r4 = r32
            r29 = r5
            r5 = r26
            r0.a(r1, r2, r3, r4, r5)
            if (r13 == r11) goto L_0x00d5
            r10.height = r13
        L_0x00d5:
            int r0 = r23.getMeasuredHeight()
            int r1 = r6.f1547f
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            r3 = 0
            int r2 = r2 + r3
            int r1 = java.lang.Math.max(r1, r2)
            r6.f1547f = r1
            if (r15 == 0) goto L_0x00f2
            int r2 = java.lang.Math.max(r0, r7)
            goto L_0x00f3
        L_0x00f2:
            r2 = r7
        L_0x00f3:
            if (r14 < 0) goto L_0x0100
            r1 = r29
            int r5 = r1 + 1
            if (r14 != r5) goto L_0x0102
            int r0 = r6.f1547f
            r6.f1544c = r0
            goto L_0x0102
        L_0x0100:
            r1 = r29
        L_0x0102:
            if (r1 >= r14) goto L_0x0113
            float r0 = r10.f1551g
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 > 0) goto L_0x010b
            goto L_0x0113
        L_0x010b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x0113:
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x0120
            int r0 = r10.width
            r4 = -1
            if (r0 != r4) goto L_0x0121
            r0 = 1
            r19 = 1
            goto L_0x0122
        L_0x0120:
            r4 = -1
        L_0x0121:
            r0 = 0
        L_0x0122:
            int r3 = r10.leftMargin
            int r5 = r10.rightMargin
            int r3 = r3 + r5
            int r5 = r23.getMeasuredWidth()
            int r5 = r5 + r3
            r13 = r27
            int r7 = java.lang.Math.max(r13, r5)
            int r11 = r23.getMeasuredState()
            int r9 = android.view.View.combineMeasuredStates(r9, r11)
            if (r18 == 0) goto L_0x0143
            int r11 = r10.width
            if (r11 != r4) goto L_0x0143
            r18 = 1
            goto L_0x0145
        L_0x0143:
            r18 = 0
        L_0x0145:
            float r4 = r10.f1551g
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x0155
            if (r0 == 0) goto L_0x014e
            goto L_0x014f
        L_0x014e:
            r3 = r5
        L_0x014f:
            int r0 = java.lang.Math.max(r8, r3)
            r8 = r0
            goto L_0x0171
        L_0x0155:
            if (r0 == 0) goto L_0x0158
            goto L_0x0159
        L_0x0158:
            r3 = r5
        L_0x0159:
            r10 = r28
            int r4 = java.lang.Math.max(r10, r3)
            r28 = r4
            goto L_0x0171
        L_0x0162:
            r7 = r2
            r10 = r4
            r21 = r11
            r8 = r20
            r20 = r13
            r13 = r1
            r1 = r5
            r22 = r0
            r28 = r10
            r7 = r13
        L_0x0171:
            int r5 = r1 + 0
            r1 = r7
            r0 = r22
            r4 = r28
            r3 = 1
        L_0x0179:
            int r5 = r5 + r3
            r7 = r31
            r13 = r20
            r11 = r21
            r10 = 0
            r20 = r8
            r8 = r32
            goto L_0x002e
        L_0x0187:
            r7 = r2
            r10 = r4
            r21 = r11
            r8 = r20
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -1
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r20 = r13
            r13 = r1
            int r1 = r6.f1547f
            if (r1 <= 0) goto L_0x01a9
            r1 = r21
            boolean r2 = r6.a((int) r1)
            if (r2 == 0) goto L_0x01ab
            int r2 = r6.f1547f
            int r5 = r6.m
            int r2 = r2 + r5
            r6.f1547f = r2
            goto L_0x01ab
        L_0x01a9:
            r1 = r21
        L_0x01ab:
            r2 = r20
            if (r15 == 0) goto L_0x01ef
            if (r2 == r11) goto L_0x01b3
            if (r2 != 0) goto L_0x01ef
        L_0x01b3:
            r5 = 0
            r6.f1547f = r5
            r11 = 0
        L_0x01b7:
            if (r11 >= r1) goto L_0x01ef
            android.view.View r14 = r6.getChildAt(r11)
            if (r14 != 0) goto L_0x01c5
            int r14 = r6.f1547f
            int r14 = r14 + r5
            r6.f1547f = r14
            goto L_0x01e8
        L_0x01c5:
            int r5 = r14.getVisibility()
            r4 = 8
            if (r5 != r4) goto L_0x01d0
            int r11 = r11 + 0
            goto L_0x01e8
        L_0x01d0:
            android.view.ViewGroup$LayoutParams r4 = r14.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            int r5 = r6.f1547f
            int r14 = r5 + r7
            int r3 = r4.topMargin
            int r14 = r14 + r3
            int r3 = r4.bottomMargin
            int r14 = r14 + r3
            r3 = 0
            int r14 = r14 + r3
            int r3 = java.lang.Math.max(r5, r14)
            r6.f1547f = r3
        L_0x01e8:
            r3 = 1
            int r11 = r11 + r3
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -1
            r5 = 0
            goto L_0x01b7
        L_0x01ef:
            r3 = 1
            int r4 = r6.f1547f
            int r5 = r30.getPaddingTop()
            int r11 = r30.getPaddingBottom()
            int r5 = r5 + r11
            int r4 = r4 + r5
            r6.f1547f = r4
            int r4 = r6.f1547f
            int r5 = r30.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r5)
            r5 = r32
            r11 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r5, r11)
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r11 = r11 & r4
            int r14 = r6.f1547f
            int r11 = r11 - r14
            if (r17 != 0) goto L_0x025e
            if (r11 == 0) goto L_0x021f
            int r14 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x021f
            goto L_0x025e
        L_0x021f:
            int r0 = java.lang.Math.max(r10, r8)
            if (r15 == 0) goto L_0x025a
            r3 = 1073741824(0x40000000, float:2.0)
            if (r2 == r3) goto L_0x025a
            r2 = 0
        L_0x022a:
            if (r2 >= r1) goto L_0x025a
            android.view.View r3 = r6.getChildAt(r2)
            if (r3 == 0) goto L_0x0257
            int r8 = r3.getVisibility()
            r10 = 8
            if (r8 == r10) goto L_0x0257
            android.view.ViewGroup$LayoutParams r8 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r8 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r8
            float r8 = r8.f1551g
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0257
            int r8 = r3.getMeasuredWidth()
            r10 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r10)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10)
            r3.measure(r8, r11)
        L_0x0257:
            int r2 = r2 + 1
            goto L_0x022a
        L_0x025a:
            r11 = r31
            goto L_0x0349
        L_0x025e:
            float r7 = r6.f1548g
            int r8 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0265
            r0 = r7
        L_0x0265:
            r7 = 0
            r6.f1547f = r7
            r7 = r0
            r0 = 0
        L_0x026a:
            if (r0 >= r1) goto L_0x0338
            android.view.View r8 = r6.getChildAt(r0)
            int r14 = r8.getVisibility()
            r15 = 8
            if (r14 == r15) goto L_0x0329
            android.view.ViewGroup$LayoutParams r14 = r8.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r3 = r14.f1551g
            int r17 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r17 <= 0) goto L_0x02d6
            float r15 = (float) r11
            float r15 = r15 * r3
            float r15 = r15 / r7
            int r15 = (int) r15
            float r7 = r7 - r3
            int r11 = r11 - r15
            int r3 = r30.getPaddingLeft()
            int r17 = r30.getPaddingRight()
            int r3 = r3 + r17
            r17 = r7
            int r7 = r14.leftMargin
            int r3 = r3 + r7
            int r7 = r14.rightMargin
            int r3 = r3 + r7
            int r7 = r14.width
            r20 = r11
            r11 = r31
            int r3 = getChildMeasureSpec(r11, r3, r7)
            int r7 = r14.height
            if (r7 != 0) goto L_0x02b7
            r7 = 1073741824(0x40000000, float:2.0)
            if (r2 == r7) goto L_0x02b0
            goto L_0x02b7
        L_0x02b0:
            r7 = 1073741824(0x40000000, float:2.0)
            if (r15 <= 0) goto L_0x02b5
            goto L_0x02c2
        L_0x02b5:
            r15 = 0
            goto L_0x02c2
        L_0x02b7:
            int r7 = r8.getMeasuredHeight()
            int r7 = r7 + r15
            if (r7 >= 0) goto L_0x02bf
            r7 = 0
        L_0x02bf:
            r15 = r7
            r7 = 1073741824(0x40000000, float:2.0)
        L_0x02c2:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r7)
            r8.measure(r3, r15)
            int r3 = r8.getMeasuredState()
            r3 = r3 & -256(0xffffffffffffff00, float:NaN)
            int r9 = android.view.View.combineMeasuredStates(r9, r3)
            r3 = r20
            goto L_0x02db
        L_0x02d6:
            r3 = r11
            r11 = r31
            r17 = r7
        L_0x02db:
            int r7 = r14.leftMargin
            int r15 = r14.rightMargin
            int r7 = r7 + r15
            int r15 = r8.getMeasuredWidth()
            int r15 = r15 + r7
            int r13 = java.lang.Math.max(r13, r15)
            r20 = r2
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x02f8
            int r2 = r14.width
            r21 = r3
            r3 = -1
            if (r2 != r3) goto L_0x02fb
            r2 = 1
            goto L_0x02fc
        L_0x02f8:
            r21 = r3
            r3 = -1
        L_0x02fb:
            r2 = 0
        L_0x02fc:
            if (r2 == 0) goto L_0x02ff
            r15 = r7
        L_0x02ff:
            int r2 = java.lang.Math.max(r10, r15)
            if (r18 == 0) goto L_0x030b
            int r7 = r14.width
            if (r7 != r3) goto L_0x030b
            r7 = 1
            goto L_0x030c
        L_0x030b:
            r7 = 0
        L_0x030c:
            int r10 = r6.f1547f
            int r8 = r8.getMeasuredHeight()
            int r8 = r8 + r10
            int r15 = r14.topMargin
            int r8 = r8 + r15
            int r14 = r14.bottomMargin
            int r8 = r8 + r14
            r14 = 0
            int r8 = r8 + r14
            int r8 = java.lang.Math.max(r10, r8)
            r6.f1547f = r8
            r10 = r2
            r18 = r7
            r7 = r17
            r2 = r21
            goto L_0x0330
        L_0x0329:
            r20 = r2
            r2 = r11
            r3 = -1
            r14 = 0
            r11 = r31
        L_0x0330:
            int r0 = r0 + 1
            r11 = r2
            r2 = r20
            r3 = 1
            goto L_0x026a
        L_0x0338:
            r11 = r31
            int r0 = r6.f1547f
            int r2 = r30.getPaddingTop()
            int r3 = r30.getPaddingBottom()
            int r2 = r2 + r3
            int r0 = r0 + r2
            r6.f1547f = r0
            r0 = r10
        L_0x0349:
            if (r18 != 0) goto L_0x0350
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0350
            r13 = r0
        L_0x0350:
            int r0 = r30.getPaddingLeft()
            int r2 = r30.getPaddingRight()
            int r0 = r0 + r2
            int r13 = r13 + r0
            int r0 = r30.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r13, r0)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r9)
            r6.setMeasuredDimension(r0, r4)
            if (r19 == 0) goto L_0x036e
            r6.a((int) r1, (int) r5)
        L_0x036e:
            return
        L_0x036f:
            r11 = r7
            r5 = r8
            r30.b((int) r31, (int) r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i2) {
        if (i2 == 0) {
            return (this.n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    private void a(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x038c, code lost:
        if (r7 < 0) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x021d, code lost:
        if (r13[3] != -1) goto L_0x0221;
     */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0435  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r37, int r38) {
        /*
            r36 = this;
            r6 = r36
            r7 = r38
            r8 = 0
            r6.f1547f = r8
            int r9 = r36.getVirtualChildCount()
            int r10 = android.view.View.MeasureSpec.getMode(r37)
            int r11 = android.view.View.MeasureSpec.getMode(r38)
            int[] r0 = r6.f1550i
            r12 = 4
            if (r0 == 0) goto L_0x001c
            int[] r0 = r6.j
            if (r0 != 0) goto L_0x0024
        L_0x001c:
            int[] r0 = new int[r12]
            r6.f1550i = r0
            int[] r0 = new int[r12]
            r6.j = r0
        L_0x0024:
            int[] r13 = r6.f1550i
            int[] r14 = r6.j
            r15 = 3
            r5 = -1
            r13[r15] = r5
            r16 = 2
            r13[r16] = r5
            r17 = 1
            r13[r17] = r5
            r13[r8] = r5
            r14[r15] = r5
            r14[r16] = r5
            r14[r17] = r5
            r14[r8] = r5
            boolean r4 = r6.f1542a
            boolean r3 = r6.f1549h
            r2 = 1073741824(0x40000000, float:2.0)
            if (r10 != r2) goto L_0x0049
            r18 = 1
            goto L_0x004b
        L_0x0049:
            r18 = 0
        L_0x004b:
            r19 = 0
            r0 = 0
            r1 = 0
            r12 = 0
            r15 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 1
            r26 = 0
        L_0x005d:
            r5 = 8
            if (r1 >= r9) goto L_0x01ef
            android.view.View r2 = r6.getChildAt(r1)
            if (r2 != 0) goto L_0x0073
            int r2 = r6.f1547f
            int r2 = r2 + r8
            r6.f1547f = r2
            r35 = r3
            r28 = r4
            r4 = -1
            goto L_0x01e1
        L_0x0073:
            int r8 = r2.getVisibility()
            if (r8 == r5) goto L_0x01cc
            boolean r5 = r6.a((int) r1)
            if (r5 == 0) goto L_0x0086
            int r5 = r6.f1547f
            int r8 = r6.l
            int r5 = r5 + r8
            r6.f1547f = r5
        L_0x0086:
            android.view.ViewGroup$LayoutParams r5 = r2.getLayoutParams()
            r8 = r5
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r8 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r8
            float r5 = r8.f1551g
            float r31 = r0 + r5
            r5 = 1073741824(0x40000000, float:2.0)
            if (r10 != r5) goto L_0x00e0
            int r0 = r8.width
            if (r0 != 0) goto L_0x00e0
            float r0 = r8.f1551g
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e0
            if (r18 == 0) goto L_0x00ae
            int r0 = r6.f1547f
            int r5 = r8.leftMargin
            r32 = r1
            int r1 = r8.rightMargin
            int r5 = r5 + r1
            int r0 = r0 + r5
            r6.f1547f = r0
            goto L_0x00be
        L_0x00ae:
            r32 = r1
            int r0 = r6.f1547f
            int r1 = r8.leftMargin
            int r1 = r1 + r0
            int r5 = r8.rightMargin
            int r1 = r1 + r5
            int r0 = java.lang.Math.max(r0, r1)
            r6.f1547f = r0
        L_0x00be:
            if (r4 == 0) goto L_0x00d2
            r0 = 0
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r2.measure(r1, r1)
            r30 = r2
            r35 = r3
            r28 = r4
            r27 = -2
            goto L_0x014d
        L_0x00d2:
            r30 = r2
            r35 = r3
            r28 = r4
            r1 = 1073741824(0x40000000, float:2.0)
            r22 = 1
            r27 = -2
            goto L_0x014f
        L_0x00e0:
            r32 = r1
            int r0 = r8.width
            if (r0 != 0) goto L_0x00f1
            float r0 = r8.f1551g
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f1
            r5 = -2
            r8.width = r5
            r1 = 0
            goto L_0x00f4
        L_0x00f1:
            r5 = -2
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00f4:
            int r0 = (r31 > r19 ? 1 : (r31 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x00fd
            int r0 = r6.f1547f
            r28 = r0
            goto L_0x00ff
        L_0x00fd:
            r28 = 0
        L_0x00ff:
            r33 = 0
            r0 = r36
            r34 = r1
            r1 = r2
            r30 = r2
            r2 = r37
            r35 = r3
            r3 = r28
            r28 = r4
            r4 = r38
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r27 = -2
            r5 = r33
            r0.a(r1, r2, r3, r4, r5)
            r0 = r34
            if (r0 == r7) goto L_0x0121
            r8.width = r0
        L_0x0121:
            int r0 = r30.getMeasuredWidth()
            if (r18 == 0) goto L_0x0135
            int r1 = r6.f1547f
            int r2 = r8.leftMargin
            int r2 = r2 + r0
            int r3 = r8.rightMargin
            int r2 = r2 + r3
            r3 = 0
            int r2 = r2 + r3
            int r1 = r1 + r2
            r6.f1547f = r1
            goto L_0x0147
        L_0x0135:
            r3 = 0
            int r1 = r6.f1547f
            int r2 = r1 + r0
            int r4 = r8.leftMargin
            int r2 = r2 + r4
            int r4 = r8.rightMargin
            int r2 = r2 + r4
            int r2 = r2 + r3
            int r1 = java.lang.Math.max(r1, r2)
            r6.f1547f = r1
        L_0x0147:
            if (r35 == 0) goto L_0x014d
            int r12 = java.lang.Math.max(r0, r12)
        L_0x014d:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x014f:
            if (r11 == r1) goto L_0x015a
            int r0 = r8.height
            r4 = -1
            if (r0 != r4) goto L_0x015b
            r0 = 1
            r26 = 1
            goto L_0x015c
        L_0x015a:
            r4 = -1
        L_0x015b:
            r0 = 0
        L_0x015c:
            int r2 = r8.topMargin
            int r3 = r8.bottomMargin
            int r2 = r2 + r3
            int r3 = r30.getMeasuredHeight()
            int r3 = r3 + r2
            int r5 = r30.getMeasuredState()
            r7 = r24
            int r24 = android.view.View.combineMeasuredStates(r7, r5)
            if (r28 == 0) goto L_0x019d
            int r5 = r30.getBaseline()
            if (r5 == r4) goto L_0x019d
            int r7 = r8.f1552h
            if (r7 >= 0) goto L_0x017f
            int r7 = r6.f1546e
            goto L_0x0181
        L_0x017f:
            int r7 = r8.f1552h
        L_0x0181:
            r7 = r7 & 112(0x70, float:1.57E-43)
            r23 = 4
            int r7 = r7 >> 4
            r7 = r7 & -2
            int r7 = r7 >> 1
            r1 = r13[r7]
            int r1 = java.lang.Math.max(r1, r5)
            r13[r7] = r1
            r1 = r14[r7]
            int r5 = r3 - r5
            int r1 = java.lang.Math.max(r1, r5)
            r14[r7] = r1
        L_0x019d:
            int r15 = java.lang.Math.max(r15, r3)
            if (r25 == 0) goto L_0x01aa
            int r1 = r8.height
            if (r1 != r4) goto L_0x01aa
            r25 = 1
            goto L_0x01ac
        L_0x01aa:
            r25 = 0
        L_0x01ac:
            float r1 = r8.f1551g
            int r1 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r1 <= 0) goto L_0x01bf
            if (r0 == 0) goto L_0x01b5
            goto L_0x01b6
        L_0x01b5:
            r2 = r3
        L_0x01b6:
            r8 = r21
            int r21 = java.lang.Math.max(r8, r2)
            r8 = r21
            goto L_0x01db
        L_0x01bf:
            r8 = r21
            if (r0 == 0) goto L_0x01c4
            goto L_0x01c5
        L_0x01c4:
            r2 = r3
        L_0x01c5:
            r1 = r20
            int r20 = java.lang.Math.max(r1, r2)
            goto L_0x01db
        L_0x01cc:
            r32 = r1
            r35 = r3
            r28 = r4
            r1 = r20
            r8 = r21
            r7 = r24
            r4 = -1
            r31 = r0
        L_0x01db:
            int r1 = r32 + 0
            r21 = r8
            r0 = r31
        L_0x01e1:
            int r1 = r1 + 1
            r7 = r38
            r4 = r28
            r3 = r35
            r2 = 1073741824(0x40000000, float:2.0)
            r5 = -1
            r8 = 0
            goto L_0x005d
        L_0x01ef:
            r35 = r3
            r28 = r4
            r1 = r20
            r8 = r21
            r4 = -1
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r27 = -2
            int r2 = r6.f1547f
            if (r2 <= 0) goto L_0x020d
            boolean r2 = r6.a((int) r9)
            if (r2 == 0) goto L_0x020d
            int r2 = r6.f1547f
            int r3 = r6.l
            int r2 = r2 + r3
            r6.f1547f = r2
        L_0x020d:
            r2 = r13[r17]
            if (r2 != r4) goto L_0x0220
            r2 = 0
            r3 = r13[r2]
            if (r3 != r4) goto L_0x0220
            r2 = r13[r16]
            if (r2 != r4) goto L_0x0220
            r2 = 3
            r3 = r13[r2]
            if (r3 == r4) goto L_0x0250
            goto L_0x0221
        L_0x0220:
            r2 = 3
        L_0x0221:
            r3 = r13[r2]
            r20 = 0
            r4 = r13[r20]
            r5 = r13[r17]
            r7 = r13[r16]
            int r5 = java.lang.Math.max(r5, r7)
            int r4 = java.lang.Math.max(r4, r5)
            int r3 = java.lang.Math.max(r3, r4)
            r4 = r14[r2]
            r2 = r14[r20]
            r5 = r14[r17]
            r7 = r14[r16]
            int r5 = java.lang.Math.max(r5, r7)
            int r2 = java.lang.Math.max(r2, r5)
            int r2 = java.lang.Math.max(r4, r2)
            int r3 = r3 + r2
            int r15 = java.lang.Math.max(r15, r3)
        L_0x0250:
            if (r35 == 0) goto L_0x02a2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == r2) goto L_0x0258
            if (r10 != 0) goto L_0x02a2
        L_0x0258:
            r2 = 0
            r6.f1547f = r2
            r3 = 0
        L_0x025c:
            if (r3 >= r9) goto L_0x02a2
            android.view.View r4 = r6.getChildAt(r3)
            if (r4 != 0) goto L_0x026a
            int r4 = r6.f1547f
            int r4 = r4 + r2
            r6.f1547f = r4
            goto L_0x029e
        L_0x026a:
            int r2 = r4.getVisibility()
            r5 = 8
            if (r2 != r5) goto L_0x0275
            int r3 = r3 + 0
            goto L_0x029e
        L_0x0275:
            android.view.ViewGroup$LayoutParams r2 = r4.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r2
            if (r18 == 0) goto L_0x028b
            int r4 = r6.f1547f
            int r5 = r2.leftMargin
            int r5 = r5 + r12
            int r2 = r2.rightMargin
            int r5 = r5 + r2
            r7 = 0
            int r5 = r5 + r7
            int r4 = r4 + r5
            r6.f1547f = r4
            goto L_0x029e
        L_0x028b:
            r7 = 0
            int r4 = r6.f1547f
            int r5 = r4 + r12
            int r7 = r2.leftMargin
            int r5 = r5 + r7
            int r2 = r2.rightMargin
            int r5 = r5 + r2
            r2 = 0
            int r5 = r5 + r2
            int r2 = java.lang.Math.max(r4, r5)
            r6.f1547f = r2
        L_0x029e:
            int r3 = r3 + 1
            r2 = 0
            goto L_0x025c
        L_0x02a2:
            int r2 = r6.f1547f
            int r3 = r36.getPaddingLeft()
            int r4 = r36.getPaddingRight()
            int r3 = r3 + r4
            int r2 = r2 + r3
            r6.f1547f = r2
            int r2 = r6.f1547f
            int r3 = r36.getSuggestedMinimumWidth()
            int r2 = java.lang.Math.max(r2, r3)
            r7 = r37
            r3 = 0
            int r2 = android.view.View.resolveSizeAndState(r2, r7, r3)
            r3 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = r3 & r2
            int r4 = r6.f1547f
            int r3 = r3 - r4
            if (r22 != 0) goto L_0x0315
            if (r3 == 0) goto L_0x02d1
            int r5 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r5 <= 0) goto L_0x02d1
            goto L_0x0315
        L_0x02d1:
            int r0 = java.lang.Math.max(r1, r8)
            if (r35 == 0) goto L_0x030c
            r1 = 1073741824(0x40000000, float:2.0)
            if (r10 == r1) goto L_0x030c
            r1 = 0
        L_0x02dc:
            if (r1 >= r9) goto L_0x030c
            android.view.View r3 = r6.getChildAt(r1)
            if (r3 == 0) goto L_0x0309
            int r5 = r3.getVisibility()
            r8 = 8
            if (r5 == r8) goto L_0x0309
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r5 = r5.f1551g
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 <= 0) goto L_0x0309
            r5 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r5)
            int r10 = r3.getMeasuredHeight()
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r5)
            r3.measure(r8, r10)
        L_0x0309:
            int r1 = r1 + 1
            goto L_0x02dc
        L_0x030c:
            r3 = r38
            r22 = r9
            r5 = r24
            r4 = 0
            goto L_0x04aa
        L_0x0315:
            float r5 = r6.f1548g
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 <= 0) goto L_0x031c
            r0 = r5
        L_0x031c:
            r5 = 3
            r8 = -1
            r13[r5] = r8
            r13[r16] = r8
            r13[r17] = r8
            r12 = 0
            r13[r12] = r8
            r14[r5] = r8
            r14[r16] = r8
            r14[r17] = r8
            r14[r12] = r8
            r6.f1547f = r12
            r8 = r1
            r5 = r24
            r12 = -1
            r1 = r0
            r0 = 0
        L_0x0337:
            if (r0 >= r9) goto L_0x0450
            android.view.View r15 = r6.getChildAt(r0)
            if (r15 == 0) goto L_0x043d
            int r4 = r15.getVisibility()
            r7 = 8
            if (r4 == r7) goto L_0x043d
            android.view.ViewGroup$LayoutParams r4 = r15.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            float r7 = r4.f1551g
            int r22 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r22 <= 0) goto L_0x03a6
            r22 = r9
            float r9 = (float) r3
            float r9 = r9 * r7
            float r9 = r9 / r1
            int r9 = (int) r9
            float r1 = r1 - r7
            int r3 = r3 - r9
            int r7 = r36.getPaddingTop()
            int r24 = r36.getPaddingBottom()
            int r7 = r7 + r24
            r24 = r1
            int r1 = r4.topMargin
            int r7 = r7 + r1
            int r1 = r4.bottomMargin
            int r7 = r7 + r1
            int r1 = r4.height
            r29 = r3
            r3 = r38
            int r1 = getChildMeasureSpec(r3, r7, r1)
            int r7 = r4.width
            if (r7 != 0) goto L_0x0387
            r7 = 1073741824(0x40000000, float:2.0)
            if (r10 == r7) goto L_0x0381
            goto L_0x0387
        L_0x0381:
            if (r9 <= 0) goto L_0x0385
            r7 = r9
            goto L_0x038f
        L_0x0385:
            r7 = 0
            goto L_0x038f
        L_0x0387:
            int r7 = r15.getMeasuredWidth()
            int r7 = r7 + r9
            if (r7 >= 0) goto L_0x038f
            goto L_0x0385
        L_0x038f:
            r9 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            r15.measure(r7, r1)
            int r1 = r15.getMeasuredState()
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r7
            int r5 = android.view.View.combineMeasuredStates(r5, r1)
            r1 = r24
            goto L_0x03ad
        L_0x03a6:
            r7 = r3
            r22 = r9
            r3 = r38
            r29 = r7
        L_0x03ad:
            if (r18 == 0) goto L_0x03c3
            int r7 = r6.f1547f
            int r9 = r15.getMeasuredWidth()
            r24 = r1
            int r1 = r4.leftMargin
            int r9 = r9 + r1
            int r1 = r4.rightMargin
            int r9 = r9 + r1
            r1 = 0
            int r9 = r9 + r1
            int r7 = r7 + r9
            r6.f1547f = r7
            goto L_0x03db
        L_0x03c3:
            r24 = r1
            r1 = 0
            int r7 = r6.f1547f
            int r9 = r15.getMeasuredWidth()
            int r9 = r9 + r7
            int r1 = r4.leftMargin
            int r9 = r9 + r1
            int r1 = r4.rightMargin
            int r9 = r9 + r1
            r1 = 0
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r7, r9)
            r6.f1547f = r1
        L_0x03db:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r11 == r1) goto L_0x03e6
            int r1 = r4.height
            r7 = -1
            if (r1 != r7) goto L_0x03e6
            r1 = 1
            goto L_0x03e7
        L_0x03e6:
            r1 = 0
        L_0x03e7:
            int r7 = r4.topMargin
            int r9 = r4.bottomMargin
            int r7 = r7 + r9
            int r9 = r15.getMeasuredHeight()
            int r9 = r9 + r7
            int r12 = java.lang.Math.max(r12, r9)
            if (r1 == 0) goto L_0x03f8
            goto L_0x03f9
        L_0x03f8:
            r7 = r9
        L_0x03f9:
            int r1 = java.lang.Math.max(r8, r7)
            if (r25 == 0) goto L_0x0406
            int r7 = r4.height
            r8 = -1
            if (r7 != r8) goto L_0x0407
            r7 = 1
            goto L_0x0408
        L_0x0406:
            r8 = -1
        L_0x0407:
            r7 = 0
        L_0x0408:
            if (r28 == 0) goto L_0x0435
            int r15 = r15.getBaseline()
            if (r15 == r8) goto L_0x0435
            int r8 = r4.f1552h
            if (r8 >= 0) goto L_0x0417
            int r4 = r6.f1546e
            goto L_0x0419
        L_0x0417:
            int r4 = r4.f1552h
        L_0x0419:
            r4 = r4 & 112(0x70, float:1.57E-43)
            r23 = 4
            int r4 = r4 >> 4
            r4 = r4 & -2
            int r4 = r4 >> 1
            r8 = r13[r4]
            int r8 = java.lang.Math.max(r8, r15)
            r13[r4] = r8
            r8 = r14[r4]
            int r9 = r9 - r15
            int r8 = java.lang.Math.max(r8, r9)
            r14[r4] = r8
            goto L_0x0437
        L_0x0435:
            r23 = 4
        L_0x0437:
            r8 = r1
            r25 = r7
            r1 = r24
            goto L_0x0446
        L_0x043d:
            r7 = r3
            r22 = r9
            r23 = 4
            r3 = r38
            r29 = r7
        L_0x0446:
            int r0 = r0 + 1
            r7 = r37
            r9 = r22
            r3 = r29
            goto L_0x0337
        L_0x0450:
            r3 = r38
            r22 = r9
            int r0 = r6.f1547f
            int r1 = r36.getPaddingLeft()
            int r4 = r36.getPaddingRight()
            int r1 = r1 + r4
            int r0 = r0 + r1
            r6.f1547f = r0
            r0 = r13[r17]
            r1 = -1
            if (r0 != r1) goto L_0x0479
            r0 = 0
            r4 = r13[r0]
            if (r4 != r1) goto L_0x0479
            r0 = r13[r16]
            if (r0 != r1) goto L_0x0479
            r0 = 3
            r4 = r13[r0]
            if (r4 == r1) goto L_0x0476
            goto L_0x047a
        L_0x0476:
            r15 = r12
            r4 = 0
            goto L_0x04a9
        L_0x0479:
            r0 = 3
        L_0x047a:
            r1 = r13[r0]
            r4 = 0
            r7 = r13[r4]
            r9 = r13[r17]
            r10 = r13[r16]
            int r9 = java.lang.Math.max(r9, r10)
            int r7 = java.lang.Math.max(r7, r9)
            int r1 = java.lang.Math.max(r1, r7)
            r0 = r14[r0]
            r7 = r14[r4]
            r9 = r14[r17]
            r10 = r14[r16]
            int r9 = java.lang.Math.max(r9, r10)
            int r7 = java.lang.Math.max(r7, r9)
            int r0 = java.lang.Math.max(r0, r7)
            int r1 = r1 + r0
            int r0 = java.lang.Math.max(r12, r1)
            r15 = r0
        L_0x04a9:
            r0 = r8
        L_0x04aa:
            if (r25 != 0) goto L_0x04b1
            r1 = 1073741824(0x40000000, float:2.0)
            if (r11 == r1) goto L_0x04b1
            r15 = r0
        L_0x04b1:
            int r0 = r36.getPaddingTop()
            int r1 = r36.getPaddingBottom()
            int r0 = r0 + r1
            int r15 = r15 + r0
            int r0 = r36.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r15, r0)
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1 = r1 & r5
            r1 = r1 | r2
            int r2 = r5 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r3, r2)
            r6.setMeasuredDimension(r1, r0)
            if (r26 == 0) goto L_0x0518
            int r0 = r36.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r8 = r22
            r9 = 0
        L_0x04df:
            if (r9 >= r8) goto L_0x0518
            android.view.View r1 = r6.getChildAt(r9)
            int r0 = r1.getVisibility()
            r5 = 8
            if (r0 == r5) goto L_0x0512
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            r10 = r0
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            int r0 = r10.height
            r4 = -1
            if (r0 != r4) goto L_0x0512
            int r11 = r10.width
            int r0 = r1.getMeasuredWidth()
            r10.width = r0
            r3 = 0
            r12 = 0
            r0 = r36
            r2 = r37
            r13 = -1
            r4 = r7
            r14 = 8
            r5 = r12
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r10.width = r11
            goto L_0x0515
        L_0x0512:
            r13 = -1
            r14 = 8
        L_0x0515:
            int r9 = r9 + 1
            goto L_0x04df
        L_0x0518:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int):void");
    }

    private void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r25, int r26, int r27, int r28, int r29) {
        /*
            r24 = this;
            r0 = r24
            int r1 = r0.f1545d
            r2 = 8
            r3 = 80
            r4 = 16
            r5 = 5
            r6 = 8388615(0x800007, float:1.1754953E-38)
            r7 = 2
            r8 = 1
            if (r1 != r8) goto L_0x00b6
            int r1 = r24.getPaddingLeft()
            int r10 = r28 - r26
            int r11 = r24.getPaddingRight()
            int r11 = r10 - r11
            int r10 = r10 - r1
            int r12 = r24.getPaddingRight()
            int r10 = r10 - r12
            int r12 = r24.getVirtualChildCount()
            int r13 = r0.f1546e
            r14 = r13 & 112(0x70, float:1.57E-43)
            r6 = r6 & r13
            if (r14 == r4) goto L_0x0042
            if (r14 == r3) goto L_0x0036
            int r3 = r24.getPaddingTop()
            goto L_0x004d
        L_0x0036:
            int r3 = r24.getPaddingTop()
            int r3 = r3 + r29
            int r3 = r3 - r27
            int r4 = r0.f1547f
            int r3 = r3 - r4
            goto L_0x004d
        L_0x0042:
            int r3 = r24.getPaddingTop()
            int r4 = r29 - r27
            int r13 = r0.f1547f
            int r4 = r4 - r13
            int r4 = r4 / r7
            int r3 = r3 + r4
        L_0x004d:
            r4 = r3
            r3 = 0
        L_0x004f:
            if (r3 >= r12) goto L_0x00b5
            android.view.View r13 = r0.getChildAt(r3)
            if (r13 != 0) goto L_0x005a
            int r4 = r4 + 0
            goto L_0x00b0
        L_0x005a:
            int r14 = r13.getVisibility()
            if (r14 == r2) goto L_0x00b0
            int r14 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r16 = r13.getLayoutParams()
            r2 = r16
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r2 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r2
            int r9 = r2.f1552h
            if (r9 >= 0) goto L_0x0075
            r9 = r6
        L_0x0075:
            int r7 = androidx.core.h.u.j(r24)
            int r7 = androidx.core.h.e.a(r9, r7)
            r7 = r7 & 7
            if (r7 == r8) goto L_0x008c
            if (r7 == r5) goto L_0x0087
            int r7 = r2.leftMargin
            int r7 = r7 + r1
            goto L_0x0097
        L_0x0087:
            int r7 = r11 - r14
            int r9 = r2.rightMargin
            goto L_0x0096
        L_0x008c:
            int r7 = r10 - r14
            r9 = 2
            int r7 = r7 / r9
            int r7 = r7 + r1
            int r9 = r2.leftMargin
            int r7 = r7 + r9
            int r9 = r2.rightMargin
        L_0x0096:
            int r7 = r7 - r9
        L_0x0097:
            boolean r9 = r0.a((int) r3)
            if (r9 == 0) goto L_0x00a0
            int r9 = r0.m
            int r4 = r4 + r9
        L_0x00a0:
            int r9 = r2.topMargin
            int r4 = r4 + r9
            int r9 = r4 + 0
            b(r13, r7, r9, r14, r15)
            int r2 = r2.bottomMargin
            int r15 = r15 + r2
            r2 = 0
            int r15 = r15 + r2
            int r4 = r4 + r15
            int r3 = r3 + 0
        L_0x00b0:
            int r3 = r3 + r8
            r2 = 8
            r7 = 2
            goto L_0x004f
        L_0x00b5:
            return
        L_0x00b6:
            boolean r1 = androidx.appcompat.widget.ai.a(r24)
            int r2 = r24.getPaddingTop()
            int r7 = r29 - r27
            int r9 = r24.getPaddingBottom()
            int r9 = r7 - r9
            int r7 = r7 - r2
            int r10 = r24.getPaddingBottom()
            int r7 = r7 - r10
            int r10 = r24.getVirtualChildCount()
            int r11 = r0.f1546e
            r6 = r6 & r11
            r11 = r11 & 112(0x70, float:1.57E-43)
            boolean r12 = r0.f1542a
            int[] r13 = r0.f1550i
            int[] r14 = r0.j
            int r15 = androidx.core.h.u.j(r24)
            int r6 = androidx.core.h.e.a(r6, r15)
            if (r6 == r8) goto L_0x00f8
            if (r6 == r5) goto L_0x00ec
            int r5 = r24.getPaddingLeft()
            goto L_0x0104
        L_0x00ec:
            int r5 = r24.getPaddingLeft()
            int r5 = r5 + r28
            int r5 = r5 - r26
            int r6 = r0.f1547f
            int r5 = r5 - r6
            goto L_0x0104
        L_0x00f8:
            int r5 = r24.getPaddingLeft()
            int r6 = r28 - r26
            int r15 = r0.f1547f
            int r6 = r6 - r15
            r15 = 2
            int r6 = r6 / r15
            int r5 = r5 + r6
        L_0x0104:
            if (r1 == 0) goto L_0x010b
            int r1 = r10 + -1
            r15 = r1
            r1 = -1
            goto L_0x010d
        L_0x010b:
            r1 = 1
            r15 = 0
        L_0x010d:
            r17 = r5
            r5 = 0
        L_0x0110:
            if (r5 >= r10) goto L_0x01dc
            int r18 = r1 * r5
            int r8 = r15 + r18
            android.view.View r3 = r0.getChildAt(r8)
            if (r3 != 0) goto L_0x012b
            int r17 = r17 + 0
            r27 = r1
            r29 = r10
            r20 = r11
            r21 = r12
            r1 = 0
            r3 = 1
            r12 = -1
            goto L_0x01cc
        L_0x012b:
            int r4 = r3.getVisibility()
            r6 = 8
            if (r4 == r6) goto L_0x01c1
            int r4 = r3.getMeasuredWidth()
            int r6 = r3.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r20 = r3.getLayoutParams()
            r27 = r1
            r1 = r20
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r1 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r1
            r29 = r10
            if (r12 == 0) goto L_0x0155
            int r10 = r1.height
            r20 = r11
            r11 = -1
            if (r10 == r11) goto L_0x0157
            int r10 = r3.getBaseline()
            goto L_0x0158
        L_0x0155:
            r20 = r11
        L_0x0157:
            r10 = -1
        L_0x0158:
            int r11 = r1.f1552h
            if (r11 >= 0) goto L_0x015e
            r11 = r20
        L_0x015e:
            r11 = r11 & 112(0x70, float:1.57E-43)
            r21 = r12
            r12 = 16
            if (r11 == r12) goto L_0x0198
            r12 = 48
            if (r11 == r12) goto L_0x0187
            r12 = 80
            if (r11 == r12) goto L_0x0171
            r10 = r2
            r12 = -1
            goto L_0x01a4
        L_0x0171:
            int r11 = r9 - r6
            int r12 = r1.bottomMargin
            int r11 = r11 - r12
            r12 = -1
            if (r10 == r12) goto L_0x0196
            int r22 = r3.getMeasuredHeight()
            int r22 = r22 - r10
            r10 = 2
            r23 = r14[r10]
            int r23 = r23 - r22
            int r10 = r11 - r23
            goto L_0x01a4
        L_0x0187:
            r12 = -1
            int r11 = r1.topMargin
            int r11 = r11 + r2
            if (r10 == r12) goto L_0x0196
            r19 = 1
            r22 = r13[r19]
            int r22 = r22 - r10
            int r10 = r11 + r22
            goto L_0x01a4
        L_0x0196:
            r10 = r11
            goto L_0x01a4
        L_0x0198:
            r12 = -1
            int r10 = r7 - r6
            r11 = 2
            int r10 = r10 / r11
            int r10 = r10 + r2
            int r11 = r1.topMargin
            int r10 = r10 + r11
            int r11 = r1.bottomMargin
            int r10 = r10 - r11
        L_0x01a4:
            boolean r8 = r0.a((int) r8)
            if (r8 == 0) goto L_0x01ae
            int r8 = r0.l
            int r17 = r17 + r8
        L_0x01ae:
            int r8 = r1.leftMargin
            int r17 = r17 + r8
            int r8 = r17 + 0
            b(r3, r8, r10, r4, r6)
            int r1 = r1.rightMargin
            int r4 = r4 + r1
            r1 = 0
            int r4 = r4 + r1
            int r17 = r17 + r4
            int r5 = r5 + 0
            goto L_0x01cb
        L_0x01c1:
            r27 = r1
            r29 = r10
            r20 = r11
            r21 = r12
            r1 = 0
            r12 = -1
        L_0x01cb:
            r3 = 1
        L_0x01cc:
            int r5 = r5 + r3
            r1 = r27
            r10 = r29
            r11 = r20
            r12 = r21
            r3 = 80
            r4 = 16
            r8 = 1
            goto L_0x0110
        L_0x01dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    private static void b(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    public void setOrientation(int i2) {
        if (this.f1545d != i2) {
            this.f1545d = i2;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f1545d;
    }

    public void setGravity(int i2) {
        if (this.f1546e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1546e = i2;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.f1546e;
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f1546e;
        if ((8388615 & i4) != i3) {
            this.f1546e = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f1546e;
        if ((i4 & 112) != i3) {
            this.f1546e = i3 | (i4 & -113);
            requestLayout();
        }
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public LayoutParams generateDefaultLayoutParams() {
        int i2 = this.f1545d;
        if (i2 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i2 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: g  reason: collision with root package name */
        public float f1551g;

        /* renamed from: h  reason: collision with root package name */
        public int f1552h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1552h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.f1551g = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1552h = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f1552h = -1;
            this.f1551g = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1552h = -1;
        }
    }
}
