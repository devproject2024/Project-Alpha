package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.u;
import com.google.android.flexbox.c;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.upi.util.UpiConstants;

public class FlexboxLayout extends ViewGroup implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f7961a;

    /* renamed from: b  reason: collision with root package name */
    private int f7962b;

    /* renamed from: c  reason: collision with root package name */
    private int f7963c;

    /* renamed from: d  reason: collision with root package name */
    private int f7964d;

    /* renamed from: e  reason: collision with root package name */
    private int f7965e;

    /* renamed from: f  reason: collision with root package name */
    private int f7966f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f7967g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f7968h;

    /* renamed from: i  reason: collision with root package name */
    private int f7969i;
    private int j;
    private int k;
    private int l;
    private int[] m;
    private SparseIntArray n;
    private c o;
    private List<b> p;
    private c.a q;

    public final int a(View view) {
        return 0;
    }

    public final void a(int i2, View view) {
    }

    public FlexboxLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7966f = -1;
        this.o = new c(this);
        this.p = new ArrayList();
        this.q = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i2, 0);
        this.f7961a = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.f7962b = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.f7963c = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.f7964d = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 4);
        this.f7965e = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 5);
        this.f7966f = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i3 != 0) {
            this.j = i3;
            this.f7969i = i3;
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i4 != 0) {
            this.j = i4;
        }
        int i5 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i5 != 0) {
            this.f7969i = i5;
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        if (this.o.b(this.n)) {
            this.m = this.o.a(this.n);
        }
        int i4 = this.f7961a;
        if (i4 == 0 || i4 == 1) {
            a(i2, i3);
        } else if (i4 == 2 || i4 == 3) {
            this.p.clear();
            this.q.a();
            this.o.a(this.q, i2, i3);
            this.p = this.q.f8028a;
            this.o.a(i2, i3);
            this.o.b(i2, i3, getPaddingLeft() + getPaddingRight());
            this.o.a();
            a(this.f7961a, i2, i3, this.q.f8029b);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f7961a);
        }
    }

    public int getFlexItemCount() {
        return getChildCount();
    }

    public final View a(int i2) {
        return getChildAt(i2);
    }

    private View c(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.m;
        if (i2 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i2]);
    }

    public final View b(int i2) {
        return c(i2);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        this.m = this.o.a(view, i2, layoutParams, this.n);
        super.addView(view, i2, layoutParams);
    }

    private void a(int i2, int i3) {
        this.p.clear();
        this.q.a();
        this.o.a(this.q, i2, i3, Integer.MAX_VALUE, 0, -1, (List<b>) null);
        this.p = this.q.f8028a;
        this.o.a(i2, i3, 0);
        if (this.f7964d == 3) {
            for (b next : this.p) {
                int i4 = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < next.f8020h; i5++) {
                    View c2 = c(next.o + i5);
                    if (!(c2 == null || c2.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
                        if (this.f7962b != 2) {
                            i4 = Math.max(i4, c2.getMeasuredHeight() + Math.max(next.l - c2.getBaseline(), layoutParams.topMargin) + layoutParams.bottomMargin);
                        } else {
                            i4 = Math.max(i4, c2.getMeasuredHeight() + layoutParams.topMargin + Math.max((next.l - c2.getMeasuredHeight()) + c2.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                }
                next.f8019g = i4;
            }
        }
        this.o.b(i2, i3, getPaddingTop() + getPaddingBottom());
        this.o.a(0);
        a(this.f7961a, i2, i3, this.q.f8029b);
    }

    private void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            i6 = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            i7 = getLargestMainSize();
        } else if (i2 == 2 || i2 == 3) {
            i6 = getLargestMainSize();
            i7 = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i2)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = i7;
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            i8 = View.resolveSizeAndState(i7, i3, i5);
        } else if (mode == 1073741824) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
                i6 = size2;
            }
            i9 = View.resolveSizeAndState(i6, i4, i5);
        } else if (mode2 == 0) {
            i9 = View.resolveSizeAndState(i6, i4, i5);
        } else if (mode2 == 1073741824) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            }
            i9 = View.resolveSizeAndState(size2, i4, i5);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(i8, i9);
    }

    public int getLargestMainSize() {
        int i2 = Integer.MIN_VALUE;
        for (b bVar : this.p) {
            i2 = Math.max(i2, bVar.f8017e);
        }
        return i2;
    }

    public int getSumOfCrossSize() {
        int i2;
        int i3;
        int size = this.p.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = this.p.get(i5);
            if (d(i5)) {
                if (a()) {
                    i3 = this.k;
                } else {
                    i3 = this.l;
                }
                i4 += i3;
            }
            if (f(i5)) {
                if (a()) {
                    i2 = this.k;
                } else {
                    i2 = this.l;
                }
                i4 += i2;
            }
            i4 += bVar.f8019g;
        }
        return i4;
    }

    public final boolean a() {
        int i2 = this.f7961a;
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int j2 = u.j(this);
        int i6 = this.f7961a;
        boolean z2 = false;
        if (i6 == 0) {
            a(j2 == 1, i2, i3, i4, i5);
        } else if (i6 == 1) {
            a(j2 != 1, i2, i3, i4, i5);
        } else if (i6 == 2) {
            if (j2 == 1) {
                z2 = true;
            }
            a(this.f7962b == 2 ? !z2 : z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            if (j2 == 1) {
                z2 = true;
            }
            a(this.f7962b == 2 ? !z2 : z2, true, i2, i3, i4, i5);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f7961a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            r28 = this;
            r0 = r28
            int r1 = r28.getPaddingLeft()
            int r2 = r28.getPaddingRight()
            int r3 = r33 - r31
            int r4 = r32 - r30
            int r5 = r28.getPaddingBottom()
            int r3 = r3 - r5
            int r5 = r28.getPaddingTop()
            java.util.List<com.google.android.flexbox.b> r6 = r0.p
            int r6 = r6.size()
            r8 = r5
            r5 = r3
            r3 = 0
        L_0x0020:
            if (r3 >= r6) goto L_0x0228
            java.util.List<com.google.android.flexbox.b> r9 = r0.p
            java.lang.Object r9 = r9.get(r3)
            com.google.android.flexbox.b r9 = (com.google.android.flexbox.b) r9
            boolean r10 = r0.d(r3)
            if (r10 == 0) goto L_0x0034
            int r10 = r0.k
            int r5 = r5 - r10
            int r8 = r8 + r10
        L_0x0034:
            int r10 = r0.f7963c
            r15 = 4
            r14 = 2
            r11 = 0
            r13 = 1
            if (r10 == 0) goto L_0x00c9
            if (r10 == r13) goto L_0x00bf
            r12 = 1073741824(0x40000000, float:2.0)
            if (r10 == r14) goto L_0x00ab
            r7 = 3
            if (r10 == r7) goto L_0x0093
            if (r10 == r15) goto L_0x0079
            r7 = 5
            if (r10 != r7) goto L_0x0063
            int r7 = r9.a()
            if (r7 == 0) goto L_0x005b
            int r10 = r9.f8017e
            int r10 = r4 - r10
            float r10 = (float) r10
            int r7 = r7 + 1
            float r7 = (float) r7
            float r7 = r10 / r7
            goto L_0x005c
        L_0x005b:
            r7 = 0
        L_0x005c:
            float r10 = (float) r1
            float r10 = r10 + r7
            int r12 = r4 - r2
            float r12 = (float) r12
            float r12 = r12 - r7
            goto L_0x00ce
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.<init>(r3)
            int r3 = r0.f7963c
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0079:
            int r7 = r9.a()
            if (r7 == 0) goto L_0x0088
            int r10 = r9.f8017e
            int r10 = r4 - r10
            float r10 = (float) r10
            float r7 = (float) r7
            float r7 = r10 / r7
            goto L_0x0089
        L_0x0088:
            r7 = 0
        L_0x0089:
            float r10 = (float) r1
            float r12 = r7 / r12
            float r10 = r10 + r12
            int r14 = r4 - r2
            float r14 = (float) r14
            float r12 = r14 - r12
            goto L_0x00ce
        L_0x0093:
            float r10 = (float) r1
            int r7 = r9.a()
            if (r7 == r13) goto L_0x009e
            int r7 = r7 + -1
            float r7 = (float) r7
            goto L_0x00a0
        L_0x009e:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x00a0:
            int r12 = r9.f8017e
            int r12 = r4 - r12
            float r12 = (float) r12
            float r7 = r12 / r7
            int r12 = r4 - r2
            float r12 = (float) r12
            goto L_0x00ce
        L_0x00ab:
            float r7 = (float) r1
            int r10 = r9.f8017e
            int r10 = r4 - r10
            float r10 = (float) r10
            float r10 = r10 / r12
            float r10 = r10 + r7
            int r7 = r4 - r2
            float r7 = (float) r7
            int r14 = r9.f8017e
            int r14 = r4 - r14
            float r14 = (float) r14
            float r14 = r14 / r12
            float r12 = r7 - r14
            goto L_0x00cd
        L_0x00bf:
            int r7 = r9.f8017e
            int r7 = r4 - r7
            int r7 = r7 + r2
            float r10 = (float) r7
            int r7 = r9.f8017e
            int r7 = r7 - r1
            goto L_0x00cc
        L_0x00c9:
            float r10 = (float) r1
            int r7 = r4 - r2
        L_0x00cc:
            float r12 = (float) r7
        L_0x00cd:
            r7 = 0
        L_0x00ce:
            float r7 = java.lang.Math.max(r7, r11)
            r14 = 0
        L_0x00d3:
            int r11 = r9.f8020h
            if (r14 >= r11) goto L_0x021a
            int r11 = r9.o
            int r11 = r11 + r14
            android.view.View r17 = r0.c(r11)
            if (r17 == 0) goto L_0x0208
            int r15 = r17.getVisibility()
            r13 = 8
            if (r15 == r13) goto L_0x0208
            android.view.ViewGroup$LayoutParams r13 = r17.getLayoutParams()
            r15 = r13
            com.google.android.flexbox.FlexboxLayout$LayoutParams r15 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) r15
            int r13 = r15.leftMargin
            float r13 = (float) r13
            float r10 = r10 + r13
            int r13 = r15.rightMargin
            float r13 = (float) r13
            float r12 = r12 - r13
            boolean r11 = r0.b(r11, r14)
            if (r11 == 0) goto L_0x0109
            int r11 = r0.l
            float r13 = (float) r11
            float r10 = r10 + r13
            float r12 = r12 - r13
            r18 = r10
            r20 = r11
            r19 = r12
            goto L_0x010f
        L_0x0109:
            r18 = r10
            r19 = r12
            r20 = 0
        L_0x010f:
            int r10 = r9.f8020h
            r13 = 1
            int r10 = r10 - r13
            if (r14 != r10) goto L_0x0122
            int r10 = r0.j
            r16 = 4
            r10 = r10 & 4
            if (r10 <= 0) goto L_0x0124
            int r10 = r0.l
            r21 = r10
            goto L_0x0126
        L_0x0122:
            r16 = 4
        L_0x0124:
            r21 = 0
        L_0x0126:
            int r10 = r0.f7962b
            r12 = 2
            if (r10 != r12) goto L_0x0188
            if (r29 == 0) goto L_0x015e
            com.google.android.flexbox.c r10 = r0.o
            int r11 = java.lang.Math.round(r19)
            int r22 = r17.getMeasuredWidth()
            int r22 = r11 - r22
            int r11 = r17.getMeasuredHeight()
            int r23 = r5 - r11
            int r24 = java.lang.Math.round(r19)
            r11 = r17
            r25 = 2
            r12 = r9
            r26 = 1
            r13 = r22
            r22 = r14
            r14 = r23
            r23 = r1
            r1 = r15
            r27 = 4
            r15 = r24
            r16 = r5
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (int) r13, (int) r14, (int) r15, (int) r16)
            goto L_0x01d0
        L_0x015e:
            r23 = r1
            r22 = r14
            r1 = r15
            r25 = 2
            r26 = 1
            r27 = 4
            com.google.android.flexbox.c r10 = r0.o
            int r13 = java.lang.Math.round(r18)
            int r11 = r17.getMeasuredHeight()
            int r14 = r5 - r11
            int r11 = java.lang.Math.round(r18)
            int r12 = r17.getMeasuredWidth()
            int r15 = r11 + r12
            r11 = r17
            r12 = r9
            r16 = r5
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (int) r13, (int) r14, (int) r15, (int) r16)
            goto L_0x01d0
        L_0x0188:
            r23 = r1
            r22 = r14
            r1 = r15
            r25 = 2
            r26 = 1
            r27 = 4
            if (r29 == 0) goto L_0x01b3
            com.google.android.flexbox.c r10 = r0.o
            int r11 = java.lang.Math.round(r19)
            int r12 = r17.getMeasuredWidth()
            int r13 = r11 - r12
            int r15 = java.lang.Math.round(r19)
            int r11 = r17.getMeasuredHeight()
            int r16 = r8 + r11
            r11 = r17
            r12 = r9
            r14 = r8
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (int) r13, (int) r14, (int) r15, (int) r16)
            goto L_0x01d0
        L_0x01b3:
            com.google.android.flexbox.c r10 = r0.o
            int r13 = java.lang.Math.round(r18)
            int r11 = java.lang.Math.round(r18)
            int r12 = r17.getMeasuredWidth()
            int r15 = r11 + r12
            int r11 = r17.getMeasuredHeight()
            int r16 = r8 + r11
            r11 = r17
            r12 = r9
            r14 = r8
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (int) r13, (int) r14, (int) r15, (int) r16)
        L_0x01d0:
            int r10 = r17.getMeasuredWidth()
            float r10 = (float) r10
            float r10 = r10 + r7
            int r11 = r1.rightMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r18 = r18 + r10
            int r10 = r17.getMeasuredWidth()
            float r10 = (float) r10
            float r10 = r10 + r7
            int r1 = r1.leftMargin
            float r1 = (float) r1
            float r10 = r10 + r1
            float r19 = r19 - r10
            if (r29 == 0) goto L_0x01f7
            r13 = 0
            r15 = 0
            r10 = r9
            r11 = r17
            r12 = r21
            r14 = r20
            r10.a(r11, r12, r13, r14, r15)
            goto L_0x0203
        L_0x01f7:
            r13 = 0
            r15 = 0
            r10 = r9
            r11 = r17
            r12 = r20
            r14 = r21
            r10.a(r11, r12, r13, r14, r15)
        L_0x0203:
            r10 = r18
            r12 = r19
            goto L_0x0212
        L_0x0208:
            r23 = r1
            r22 = r14
            r25 = 2
            r26 = 1
            r27 = 4
        L_0x0212:
            int r14 = r22 + 1
            r1 = r23
            r13 = 1
            r15 = 4
            goto L_0x00d3
        L_0x021a:
            r23 = r1
            int r1 = r9.f8019g
            int r8 = r8 + r1
            int r1 = r9.f8019g
            int r5 = r5 - r1
            int r3 = r3 + 1
            r1 = r23
            goto L_0x0020
        L_0x0228:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.a(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            r29 = this;
            r0 = r29
            int r1 = r29.getPaddingTop()
            int r2 = r29.getPaddingBottom()
            int r3 = r29.getPaddingRight()
            int r4 = r29.getPaddingLeft()
            int r5 = r34 - r32
            int r6 = r35 - r33
            int r5 = r5 - r3
            java.util.List<com.google.android.flexbox.b> r3 = r0.p
            int r3 = r3.size()
            r8 = r5
            r5 = r4
            r4 = 0
        L_0x0020:
            if (r4 >= r3) goto L_0x021f
            java.util.List<com.google.android.flexbox.b> r9 = r0.p
            java.lang.Object r9 = r9.get(r4)
            com.google.android.flexbox.b r9 = (com.google.android.flexbox.b) r9
            boolean r10 = r0.d(r4)
            if (r10 == 0) goto L_0x0034
            int r10 = r0.l
            int r5 = r5 + r10
            int r8 = r8 - r10
        L_0x0034:
            int r10 = r0.f7963c
            r15 = 4
            r11 = 0
            r14 = 1
            if (r10 == 0) goto L_0x00cc
            if (r10 == r14) goto L_0x00c2
            r12 = 2
            r13 = 1073741824(0x40000000, float:2.0)
            if (r10 == r12) goto L_0x00ad
            r12 = 3
            if (r10 == r12) goto L_0x0094
            if (r10 == r15) goto L_0x007a
            r12 = 5
            if (r10 != r12) goto L_0x0064
            int r10 = r9.a()
            if (r10 == 0) goto L_0x005b
            int r12 = r9.f8017e
            int r12 = r6 - r12
            float r12 = (float) r12
            int r10 = r10 + 1
            float r10 = (float) r10
            float r10 = r12 / r10
            goto L_0x005c
        L_0x005b:
            r10 = 0
        L_0x005c:
            float r12 = (float) r1
            float r12 = r12 + r10
            int r13 = r6 - r2
            float r13 = (float) r13
            float r13 = r13 - r10
            goto L_0x00d1
        L_0x0064:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.<init>(r3)
            int r3 = r0.f7963c
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x007a:
            int r10 = r9.a()
            if (r10 == 0) goto L_0x0089
            int r12 = r9.f8017e
            int r12 = r6 - r12
            float r12 = (float) r12
            float r10 = (float) r10
            float r10 = r12 / r10
            goto L_0x008a
        L_0x0089:
            r10 = 0
        L_0x008a:
            float r12 = (float) r1
            float r13 = r10 / r13
            float r12 = r12 + r13
            int r7 = r6 - r2
            float r7 = (float) r7
            float r13 = r7 - r13
            goto L_0x00d1
        L_0x0094:
            float r12 = (float) r1
            int r7 = r9.a()
            if (r7 == r14) goto L_0x009f
            int r7 = r7 + -1
            float r7 = (float) r7
            goto L_0x00a1
        L_0x009f:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x00a1:
            int r10 = r9.f8017e
            int r10 = r6 - r10
            float r10 = (float) r10
            float r7 = r10 / r7
            int r10 = r6 - r2
            float r13 = (float) r10
            r10 = r7
            goto L_0x00d1
        L_0x00ad:
            float r7 = (float) r1
            int r10 = r9.f8017e
            int r10 = r6 - r10
            float r10 = (float) r10
            float r10 = r10 / r13
            float r12 = r7 + r10
            int r7 = r6 - r2
            float r7 = (float) r7
            int r10 = r9.f8017e
            int r10 = r6 - r10
            float r10 = (float) r10
            float r10 = r10 / r13
            float r13 = r7 - r10
            goto L_0x00d0
        L_0x00c2:
            int r7 = r9.f8017e
            int r7 = r6 - r7
            int r7 = r7 + r2
            float r12 = (float) r7
            int r7 = r9.f8017e
            int r7 = r7 - r1
            goto L_0x00cf
        L_0x00cc:
            float r12 = (float) r1
            int r7 = r6 - r2
        L_0x00cf:
            float r13 = (float) r7
        L_0x00d0:
            r10 = 0
        L_0x00d1:
            float r7 = java.lang.Math.max(r10, r11)
            r10 = r13
            r13 = 0
        L_0x00d7:
            int r11 = r9.f8020h
            if (r13 >= r11) goto L_0x0215
            int r11 = r9.o
            int r11 = r11 + r13
            android.view.View r18 = r0.c(r11)
            if (r18 == 0) goto L_0x0209
            int r15 = r18.getVisibility()
            r14 = 8
            if (r15 == r14) goto L_0x0209
            android.view.ViewGroup$LayoutParams r14 = r18.getLayoutParams()
            r15 = r14
            com.google.android.flexbox.FlexboxLayout$LayoutParams r15 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) r15
            int r14 = r15.topMargin
            float r14 = (float) r14
            float r12 = r12 + r14
            int r14 = r15.bottomMargin
            float r14 = (float) r14
            float r10 = r10 - r14
            boolean r11 = r0.b(r11, r13)
            if (r11 == 0) goto L_0x010d
            int r11 = r0.k
            float r14 = (float) r11
            float r12 = r12 + r14
            float r10 = r10 - r14
            r20 = r10
            r21 = r11
            r19 = r12
            goto L_0x0113
        L_0x010d:
            r20 = r10
            r19 = r12
            r21 = 0
        L_0x0113:
            int r10 = r9.f8020h
            r14 = 1
            int r10 = r10 - r14
            if (r13 != r10) goto L_0x0126
            int r10 = r0.f7969i
            r16 = 4
            r10 = r10 & 4
            if (r10 <= 0) goto L_0x0128
            int r10 = r0.k
            r22 = r10
            goto L_0x012a
        L_0x0126:
            r16 = 4
        L_0x0128:
            r22 = 0
        L_0x012a:
            if (r30 == 0) goto L_0x0188
            if (r31 == 0) goto L_0x0160
            com.google.android.flexbox.c r10 = r0.o
            r17 = 1
            int r11 = r18.getMeasuredWidth()
            int r23 = r8 - r11
            int r11 = java.lang.Math.round(r20)
            int r12 = r18.getMeasuredHeight()
            int r24 = r11 - r12
            int r25 = java.lang.Math.round(r20)
            r11 = r18
            r12 = r9
            r26 = r13
            r13 = r17
            r27 = 1
            r14 = r23
            r28 = r15
            r23 = 4
            r15 = r24
            r16 = r8
            r17 = r25
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (boolean) r13, (int) r14, (int) r15, (int) r16, (int) r17)
            goto L_0x01cf
        L_0x0160:
            r26 = r13
            r28 = r15
            r23 = 4
            r27 = 1
            com.google.android.flexbox.c r10 = r0.o
            r13 = 1
            int r11 = r18.getMeasuredWidth()
            int r14 = r8 - r11
            int r15 = java.lang.Math.round(r19)
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredHeight()
            int r17 = r11 + r12
            r11 = r18
            r12 = r9
            r16 = r8
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (boolean) r13, (int) r14, (int) r15, (int) r16, (int) r17)
            goto L_0x01cf
        L_0x0188:
            r26 = r13
            r28 = r15
            r23 = 4
            r27 = 1
            if (r31 == 0) goto L_0x01b1
            com.google.android.flexbox.c r10 = r0.o
            r13 = 0
            int r11 = java.lang.Math.round(r20)
            int r12 = r18.getMeasuredHeight()
            int r15 = r11 - r12
            int r11 = r18.getMeasuredWidth()
            int r16 = r5 + r11
            int r17 = java.lang.Math.round(r20)
            r11 = r18
            r12 = r9
            r14 = r5
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (boolean) r13, (int) r14, (int) r15, (int) r16, (int) r17)
            goto L_0x01cf
        L_0x01b1:
            com.google.android.flexbox.c r10 = r0.o
            r13 = 0
            int r15 = java.lang.Math.round(r19)
            int r11 = r18.getMeasuredWidth()
            int r16 = r5 + r11
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredHeight()
            int r17 = r11 + r12
            r11 = r18
            r12 = r9
            r14 = r5
            r10.a((android.view.View) r11, (com.google.android.flexbox.b) r12, (boolean) r13, (int) r14, (int) r15, (int) r16, (int) r17)
        L_0x01cf:
            int r10 = r18.getMeasuredHeight()
            float r10 = (float) r10
            float r10 = r10 + r7
            r14 = r28
            int r11 = r14.bottomMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r19 = r19 + r10
            int r10 = r18.getMeasuredHeight()
            float r10 = (float) r10
            float r10 = r10 + r7
            int r11 = r14.topMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r20 = r20 - r10
            if (r31 == 0) goto L_0x01f8
            r12 = 0
            r14 = 0
            r10 = r9
            r11 = r18
            r13 = r22
            r15 = r21
            r10.a(r11, r12, r13, r14, r15)
            goto L_0x0204
        L_0x01f8:
            r12 = 0
            r14 = 0
            r10 = r9
            r11 = r18
            r13 = r21
            r15 = r22
            r10.a(r11, r12, r13, r14, r15)
        L_0x0204:
            r12 = r19
            r10 = r20
            goto L_0x020f
        L_0x0209:
            r26 = r13
            r23 = 4
            r27 = 1
        L_0x020f:
            int r13 = r26 + 1
            r14 = 1
            r15 = 4
            goto L_0x00d7
        L_0x0215:
            int r7 = r9.f8019g
            int r5 = r5 + r7
            int r7 = r9.f8019g
            int r8 = r8 - r7
            int r4 = r4 + 1
            goto L_0x0020
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.a(boolean, boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f7968h != null || this.f7967g != null) {
            if (this.f7969i != 0 || this.j != 0) {
                int j2 = u.j(this);
                int i2 = this.f7961a;
                boolean z = false;
                boolean z2 = true;
                if (i2 == 0) {
                    boolean z3 = j2 == 1;
                    if (this.f7962b == 2) {
                        z = true;
                    }
                    a(canvas, z3, z);
                } else if (i2 == 1) {
                    boolean z4 = j2 != 1;
                    if (this.f7962b == 2) {
                        z = true;
                    }
                    a(canvas, z4, z);
                } else if (i2 == 2) {
                    if (j2 != 1) {
                        z2 = false;
                    }
                    if (this.f7962b == 2) {
                        z2 = !z2;
                    }
                    b(canvas, z2, false);
                } else if (i2 == 3) {
                    if (j2 == 1) {
                        z = true;
                    }
                    if (this.f7962b == 2) {
                        z = !z;
                    }
                    b(canvas, z, true);
                }
            }
        }
    }

    private void a(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.p.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = this.p.get(i6);
            for (int i7 = 0; i7 < bVar.f8020h; i7++) {
                int i8 = bVar.o + i7;
                View c2 = c(i8);
                if (!(c2 == null || c2.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
                    if (b(i8, i7)) {
                        if (z) {
                            i5 = c2.getRight() + layoutParams.rightMargin;
                        } else {
                            i5 = (c2.getLeft() - layoutParams.leftMargin) - this.l;
                        }
                        a(canvas, i5, bVar.f8014b, bVar.f8019g);
                    }
                    if (i7 == bVar.f8020h - 1 && (this.j & 4) > 0) {
                        if (z) {
                            i4 = (c2.getLeft() - layoutParams.leftMargin) - this.l;
                        } else {
                            i4 = c2.getRight() + layoutParams.rightMargin;
                        }
                        a(canvas, i4, bVar.f8014b, bVar.f8019g);
                    }
                }
            }
            if (d(i6)) {
                if (z2) {
                    i3 = bVar.f8016d;
                } else {
                    i3 = bVar.f8014b - this.k;
                }
                b(canvas, paddingLeft, i3, max);
            }
            if (f(i6) && (this.f7969i & 4) > 0) {
                if (z2) {
                    i2 = bVar.f8014b - this.k;
                } else {
                    i2 = bVar.f8016d;
                }
                b(canvas, paddingLeft, i2, max);
            }
        }
    }

    private void b(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.p.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = this.p.get(i6);
            for (int i7 = 0; i7 < bVar.f8020h; i7++) {
                int i8 = bVar.o + i7;
                View c2 = c(i8);
                if (!(c2 == null || c2.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) c2.getLayoutParams();
                    if (b(i8, i7)) {
                        if (z2) {
                            i5 = c2.getBottom() + layoutParams.bottomMargin;
                        } else {
                            i5 = (c2.getTop() - layoutParams.topMargin) - this.k;
                        }
                        b(canvas, bVar.f8013a, i5, bVar.f8019g);
                    }
                    if (i7 == bVar.f8020h - 1 && (this.f7969i & 4) > 0) {
                        if (z2) {
                            i4 = (c2.getTop() - layoutParams.topMargin) - this.k;
                        } else {
                            i4 = c2.getBottom() + layoutParams.bottomMargin;
                        }
                        b(canvas, bVar.f8013a, i4, bVar.f8019g);
                    }
                }
            }
            if (d(i6)) {
                if (z) {
                    i3 = bVar.f8015c;
                } else {
                    i3 = bVar.f8013a - this.l;
                }
                a(canvas, i3, paddingTop, max);
            }
            if (f(i6) && (this.j & 4) > 0) {
                if (z) {
                    i2 = bVar.f8013a - this.l;
                } else {
                    i2 = bVar.f8015c;
                }
                a(canvas, i2, paddingTop, max);
            }
        }
    }

    private void a(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f7968h;
        if (drawable != null) {
            drawable.setBounds(i2, i3, this.l + i2, i4 + i3);
            this.f7968h.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f7967g;
        if (drawable != null) {
            drawable.setBounds(i2, i3, i4 + i2, this.k + i3);
            this.f7967g.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public int getFlexDirection() {
        return this.f7961a;
    }

    public void setFlexDirection(int i2) {
        if (this.f7961a != i2) {
            this.f7961a = i2;
            requestLayout();
        }
    }

    public int getFlexWrap() {
        return this.f7962b;
    }

    public void setFlexWrap(int i2) {
        if (this.f7962b != i2) {
            this.f7962b = i2;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.f7963c;
    }

    public void setJustifyContent(int i2) {
        if (this.f7963c != i2) {
            this.f7963c = i2;
            requestLayout();
        }
    }

    public int getAlignItems() {
        return this.f7964d;
    }

    public void setAlignItems(int i2) {
        if (this.f7964d != i2) {
            this.f7964d = i2;
            requestLayout();
        }
    }

    public int getAlignContent() {
        return this.f7965e;
    }

    public void setAlignContent(int i2) {
        if (this.f7965e != i2) {
            this.f7965e = i2;
            requestLayout();
        }
    }

    public int getMaxLine() {
        return this.f7966f;
    }

    public void setMaxLine(int i2) {
        if (this.f7966f != i2) {
            this.f7966f = i2;
            requestLayout();
        }
    }

    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.p.size());
        for (b next : this.p) {
            if (next.a() != 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final int a(View view, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (a()) {
            if (b(i2, i3)) {
                i5 = 0 + this.l;
            }
            if ((this.j & 4) <= 0) {
                return i5;
            }
            i4 = this.l;
        } else {
            if (b(i2, i3)) {
                i5 = 0 + this.k;
            }
            if ((this.f7969i & 4) <= 0) {
                return i5;
            }
            i4 = this.k;
        }
        return i5 + i4;
    }

    public final void a(b bVar) {
        if (a()) {
            if ((this.j & 4) > 0) {
                bVar.f8017e += this.l;
                bVar.f8018f += this.l;
            }
        } else if ((this.f7969i & 4) > 0) {
            bVar.f8017e += this.k;
            bVar.f8018f += this.k;
        }
    }

    public final int a(int i2, int i3, int i4) {
        return getChildMeasureSpec(i2, i3, i4);
    }

    public final int b(int i2, int i3, int i4) {
        return getChildMeasureSpec(i2, i3, i4);
    }

    public final void a(View view, int i2, int i3, b bVar) {
        if (!b(i2, i3)) {
            return;
        }
        if (a()) {
            bVar.f8017e += this.l;
            bVar.f8018f += this.l;
            return;
        }
        bVar.f8017e += this.k;
        bVar.f8018f += this.k;
    }

    public void setFlexLines(List<b> list) {
        this.p = list;
    }

    public List<b> getFlexLinesInternal() {
        return this.p;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f7967g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f7968h;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable != this.f7967g) {
            this.f7967g = drawable;
            if (drawable != null) {
                this.k = drawable.getIntrinsicHeight();
            } else {
                this.k = 0;
            }
            b();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable != this.f7968h) {
            this.f7968h = drawable;
            if (drawable != null) {
                this.l = drawable.getIntrinsicWidth();
            } else {
                this.l = 0;
            }
            b();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.j;
    }

    public int getShowDividerHorizontal() {
        return this.f7969i;
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.j) {
            this.j = i2;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.f7969i) {
            this.f7969i = i2;
            requestLayout();
        }
    }

    private void b() {
        if (this.f7967g == null && this.f7968h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean b(int i2, int i3) {
        return c(i2, i3) ? a() ? (this.j & 1) != 0 : (this.f7969i & 1) != 0 : a() ? (this.j & 2) != 0 : (this.f7969i & 2) != 0;
    }

    private boolean c(int i2, int i3) {
        for (int i4 = 1; i4 <= i3; i4++) {
            View c2 = c(i2 - i4);
            if (c2 != null && c2.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean d(int i2) {
        if (i2 >= 0 && i2 < this.p.size()) {
            if (e(i2)) {
                if (a()) {
                    if ((this.f7969i & 1) != 0) {
                        return true;
                    }
                    return false;
                } else if ((this.j & 1) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (a()) {
                if ((this.f7969i & 2) != 0) {
                    return true;
                }
                return false;
            } else if ((this.j & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean e(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.p.get(i3).a() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean f(int i2) {
        if (i2 >= 0 && i2 < this.p.size()) {
            for (int i3 = i2 + 1; i3 < this.p.size(); i3++) {
                if (this.p.get(i3).a() > 0) {
                    return false;
                }
            }
            if (a()) {
                return (this.f7969i & 4) != 0;
            }
            if ((this.j & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new LayoutParams[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private int f7970a = 1;

        /* renamed from: b  reason: collision with root package name */
        private float f7971b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        private float f7972c = 1.0f;

        /* renamed from: d  reason: collision with root package name */
        private int f7973d = -1;

        /* renamed from: e  reason: collision with root package name */
        private float f7974e = -1.0f;

        /* renamed from: f  reason: collision with root package name */
        private int f7975f;

        /* renamed from: g  reason: collision with root package name */
        private int f7976g;

        /* renamed from: h  reason: collision with root package name */
        private int f7977h = 16777215;

        /* renamed from: i  reason: collision with root package name */
        private int f7978i = 16777215;
        private boolean j;

        public int describeContents() {
            return 0;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.f7970a = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f7971b = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f7972c = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f7973d = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f7974e = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f7975f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, 0);
            this.f7976g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, 0);
            this.f7977h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.f7978i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.j = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f7970a = layoutParams.f7970a;
            this.f7971b = layoutParams.f7971b;
            this.f7972c = layoutParams.f7972c;
            this.f7973d = layoutParams.f7973d;
            this.f7974e = layoutParams.f7974e;
            this.f7975f = layoutParams.f7975f;
            this.f7976g = layoutParams.f7976g;
            this.f7977h = layoutParams.f7977h;
            this.f7978i = layoutParams.f7978i;
            this.j = layoutParams.j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int k_() {
            return this.width;
        }

        public final int b() {
            return this.height;
        }

        public final int c() {
            return this.f7970a;
        }

        public final float d() {
            return this.f7971b;
        }

        public final float e() {
            return this.f7972c;
        }

        public final int f() {
            return this.f7973d;
        }

        public final int g() {
            return this.f7975f;
        }

        public final int h() {
            return this.f7976g;
        }

        public final int i() {
            return this.f7977h;
        }

        public final int j() {
            return this.f7978i;
        }

        public final boolean k() {
            return this.j;
        }

        public final float l() {
            return this.f7974e;
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

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f7970a);
            parcel.writeFloat(this.f7971b);
            parcel.writeFloat(this.f7972c);
            parcel.writeInt(this.f7973d);
            parcel.writeFloat(this.f7974e);
            parcel.writeInt(this.f7975f);
            parcel.writeInt(this.f7976g);
            parcel.writeInt(this.f7977h);
            parcel.writeInt(this.f7978i);
            parcel.writeByte(this.j ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z = false;
            this.f7970a = parcel.readInt();
            this.f7971b = parcel.readFloat();
            this.f7972c = parcel.readFloat();
            this.f7973d = parcel.readInt();
            this.f7974e = parcel.readFloat();
            this.f7975f = parcel.readInt();
            this.f7976g = parcel.readInt();
            this.f7977h = parcel.readInt();
            this.f7978i = parcel.readInt();
            this.j = parcel.readByte() != 0 ? true : z;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
