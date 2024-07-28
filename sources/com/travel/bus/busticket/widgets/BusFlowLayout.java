package com.travel.bus.busticket.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class BusFlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22484a = BusFlowLayout.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f22485b;

    /* renamed from: c  reason: collision with root package name */
    private int f22486c;

    /* renamed from: d  reason: collision with root package name */
    private int f22487d;

    /* renamed from: e  reason: collision with root package name */
    private int f22488e;

    /* renamed from: f  reason: collision with root package name */
    private float f22489f;

    /* renamed from: g  reason: collision with root package name */
    private float f22490g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22491h;

    /* renamed from: i  reason: collision with root package name */
    private int f22492i;
    private int j;
    private int k;
    private List<Float> l;
    private List<Integer> m;
    private List<Integer> n;
    private List<Integer> o;

    public BusFlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c1, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c2, code lost:
        r7.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c5, code lost:
        throw r8;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0099 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BusFlowLayout(android.content.Context r7, android.util.AttributeSet r8) {
        /*
            r6 = this;
            r6.<init>(r7, r8)
            r0 = 1
            r6.f22485b = r0
            r1 = 0
            r6.f22486c = r1
            r6.f22487d = r1
            r2 = -65538(0xfffffffffffefffe, float:NaN)
            r6.f22488e = r2
            r3 = 0
            r6.f22489f = r3
            r6.f22490g = r3
            r6.f22491h = r1
            r3 = 2147483647(0x7fffffff, float:NaN)
            r6.f22492i = r3
            r4 = -1
            r6.j = r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.l = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.m = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.n = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.o = r5
            android.content.res.Resources$Theme r7 = r7.getTheme()
            int[] r5 = com.travel.bus.R.styleable.FlowLayoutBus
            android.content.res.TypedArray r7 = r7.obtainStyledAttributes(r8, r5, r1, r1)
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flFlow     // Catch:{ all -> 0x00c1 }
            boolean r8 = r7.getBoolean(r8, r0)     // Catch:{ all -> 0x00c1 }
            r6.f22485b = r8     // Catch:{ all -> 0x00c1 }
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flChildSpacingBus     // Catch:{ NumberFormatException -> 0x0056 }
            int r8 = r7.getInt(r8, r1)     // Catch:{ NumberFormatException -> 0x0056 }
            r6.f22486c = r8     // Catch:{ NumberFormatException -> 0x0056 }
            goto L_0x0063
        L_0x0056:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flChildSpacingBus     // Catch:{ all -> 0x00c1 }
            float r0 = r6.a()     // Catch:{ all -> 0x00c1 }
            int r0 = (int) r0     // Catch:{ all -> 0x00c1 }
            int r8 = r7.getDimensionPixelSize(r8, r0)     // Catch:{ all -> 0x00c1 }
            r6.f22486c = r8     // Catch:{ all -> 0x00c1 }
        L_0x0063:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flMinChildSpacing     // Catch:{ NumberFormatException -> 0x006c }
            int r8 = r7.getInt(r8, r1)     // Catch:{ NumberFormatException -> 0x006c }
            r6.f22487d = r8     // Catch:{ NumberFormatException -> 0x006c }
            goto L_0x0079
        L_0x006c:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flMinChildSpacing     // Catch:{ all -> 0x00c1 }
            float r0 = r6.a()     // Catch:{ all -> 0x00c1 }
            int r0 = (int) r0     // Catch:{ all -> 0x00c1 }
            int r8 = r7.getDimensionPixelSize(r8, r0)     // Catch:{ all -> 0x00c1 }
            r6.f22487d = r8     // Catch:{ all -> 0x00c1 }
        L_0x0079:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flChildSpacingBusForLastRow     // Catch:{ NumberFormatException -> 0x0082 }
            int r8 = r7.getInt(r8, r2)     // Catch:{ NumberFormatException -> 0x0082 }
            r6.f22488e = r8     // Catch:{ NumberFormatException -> 0x0082 }
            goto L_0x008f
        L_0x0082:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flChildSpacingBusForLastRow     // Catch:{ all -> 0x00c1 }
            float r0 = r6.a()     // Catch:{ all -> 0x00c1 }
            int r0 = (int) r0     // Catch:{ all -> 0x00c1 }
            int r8 = r7.getDimensionPixelSize(r8, r0)     // Catch:{ all -> 0x00c1 }
            r6.f22488e = r8     // Catch:{ all -> 0x00c1 }
        L_0x008f:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flRowSpacingBus     // Catch:{ NumberFormatException -> 0x0099 }
            int r8 = r7.getInt(r8, r1)     // Catch:{ NumberFormatException -> 0x0099 }
            float r8 = (float) r8     // Catch:{ NumberFormatException -> 0x0099 }
            r6.f22489f = r8     // Catch:{ NumberFormatException -> 0x0099 }
            goto L_0x00a5
        L_0x0099:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flRowSpacingBus     // Catch:{ all -> 0x00c1 }
            float r0 = r6.a()     // Catch:{ all -> 0x00c1 }
            float r8 = r7.getDimension(r8, r0)     // Catch:{ all -> 0x00c1 }
            r6.f22489f = r8     // Catch:{ all -> 0x00c1 }
        L_0x00a5:
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flMaxRows     // Catch:{ all -> 0x00c1 }
            int r8 = r7.getInt(r8, r3)     // Catch:{ all -> 0x00c1 }
            r6.f22492i = r8     // Catch:{ all -> 0x00c1 }
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_flRtl     // Catch:{ all -> 0x00c1 }
            boolean r8 = r7.getBoolean(r8, r1)     // Catch:{ all -> 0x00c1 }
            r6.f22491h = r8     // Catch:{ all -> 0x00c1 }
            int r8 = com.travel.bus.R.styleable.FlowLayoutBus_android_gravity     // Catch:{ all -> 0x00c1 }
            int r8 = r7.getInt(r8, r4)     // Catch:{ all -> 0x00c1 }
            r6.j = r8     // Catch:{ all -> 0x00c1 }
            r7.recycle()
            return
        L_0x00c1:
            r8 = move-exception
            r7.recycle()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.widgets.BusFlowLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View view;
        int i20;
        int i21;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.f22485b;
        int i22 = (this.f22486c == -65536 && mode == 0) ? 0 : this.f22486c;
        float f3 = i22 == -65536 ? (float) this.f22487d : (float) i22;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (i25 < childCount) {
            float f4 = f3;
            View childAt = getChildAt(i25);
            int i30 = i23;
            if (childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i10 = childCount;
                    i18 = i30;
                    i12 = size2;
                    i19 = i24;
                    i9 = i25;
                    i8 = mode2;
                    f2 = f4;
                    i13 = size;
                    view = childAt;
                    i17 = i22;
                    i11 = mode;
                    measureChildWithMargins(childAt, i2, 0, i3, i28);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i21 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i20 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i31 = i2;
                    int i32 = i3;
                } else {
                    i9 = i25;
                    i17 = i22;
                    i11 = mode;
                    i8 = mode2;
                    i10 = childCount;
                    f2 = f4;
                    i18 = i30;
                    i13 = size;
                    i12 = size2;
                    i19 = i24;
                    view = childAt;
                    measureChild(view, i2, i3);
                    i21 = 0;
                    i20 = 0;
                }
                i16 = view.getMeasuredWidth() + i21;
                int measuredHeight = view.getMeasuredHeight() + i20;
                if (!z || i27 + i16 <= paddingLeft) {
                    i15 = i17;
                    i14 = i18 + 1;
                    i16 += i19;
                    i29 = Math.max(i29, measuredHeight);
                    i27 = (int) (((float) i27) + ((float) i16) + f2);
                } else {
                    i15 = i17;
                    this.l.add(Float.valueOf(b(i15, paddingLeft, i19, i18)));
                    this.o.add(Integer.valueOf(i18));
                    this.m.add(Integer.valueOf(i29));
                    int i33 = (int) f2;
                    this.n.add(Integer.valueOf(i27 - i33));
                    if (this.l.size() <= this.f22492i) {
                        i28 += i29;
                    }
                    i29 = measuredHeight;
                    i26 = Math.max(i26, i27);
                    i27 = i33 + i16;
                    i14 = 1;
                }
            } else {
                int i34 = i2;
                i9 = i25;
                i15 = i22;
                i11 = mode;
                i8 = mode2;
                i10 = childCount;
                int i35 = i29;
                f2 = f4;
                int i36 = i30;
                i13 = size;
                i12 = size2;
                int i37 = i24;
                int i38 = i3;
                i16 = i37;
                i14 = i36;
            }
            i25 = i9 + 1;
            i24 = i16;
            i22 = i15;
            i23 = i14;
            f3 = f2;
            size = i13;
            size2 = i12;
            mode = i11;
            childCount = i10;
            mode2 = i8;
        }
        int i39 = i23;
        int i40 = i22;
        int i41 = size;
        int i42 = mode;
        int i43 = size2;
        int i44 = mode2;
        int i45 = i24;
        float f5 = f3;
        int i46 = i29;
        int i47 = this.f22488e;
        if (i47 == -65537) {
            if (this.l.size() > 0) {
                List<Float> list = this.l;
                list.add(list.get(list.size() - 1));
            } else {
                this.l.add(Float.valueOf(b(i40, paddingLeft, i45, i39)));
            }
        } else if (i47 != -65538) {
            this.l.add(Float.valueOf(b(i47, paddingLeft, i45, i39)));
        } else {
            this.l.add(Float.valueOf(b(i40, paddingLeft, i45, i39)));
        }
        this.o.add(Integer.valueOf(i39));
        this.m.add(Integer.valueOf(i46));
        this.n.add(Integer.valueOf(i27 - ((int) f5)));
        if (this.l.size() <= this.f22492i) {
            i28 += i46;
        }
        int max = Math.max(i26, i27);
        if (i40 == -65536) {
            i5 = i41;
            i4 = i5;
        } else if (i42 == 0) {
            i4 = max + getPaddingLeft() + getPaddingRight();
            i5 = i41;
        } else {
            i5 = i41;
            i4 = Math.min(max + getPaddingLeft() + getPaddingRight(), i5);
        }
        int paddingTop = i28 + getPaddingTop() + getPaddingBottom();
        int min = Math.min(this.l.size(), this.f22492i);
        float f6 = (this.f22489f == -65536.0f && i44 == 0) ? 0.0f : this.f22489f;
        if (f6 == -65536.0f) {
            if (min > 1) {
                this.f22490g = (float) ((i43 - paddingTop) / (min - 1));
            } else {
                this.f22490g = 0.0f;
            }
            i7 = i43;
            i6 = i7;
        } else {
            this.f22490g = f6;
            if (min > 1) {
                float f7 = ((float) paddingTop) + (this.f22490g * ((float) (min - 1)));
                if (i44 == 0) {
                    i6 = (int) f7;
                    i7 = i43;
                } else {
                    i7 = i43;
                    i6 = Math.min((int) f7, i7);
                }
            } else {
                i7 = i43;
                i6 = paddingTop;
            }
        }
        this.k = i6;
        if (i42 == 1073741824) {
            i4 = i5;
        }
        if (i44 != 1073741824) {
            i7 = i6;
        }
        setMeasuredDimension(i4, i7);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r21, int r22, int r23, int r24, int r25) {
        /*
            r20 = this;
            r0 = r20
            int r1 = r20.getPaddingLeft()
            int r2 = r20.getPaddingRight()
            int r3 = r20.getPaddingTop()
            int r4 = r20.getPaddingBottom()
            boolean r5 = r0.f22491h
            if (r5 == 0) goto L_0x001c
            int r5 = r20.getWidth()
            int r5 = r5 - r2
            goto L_0x001d
        L_0x001c:
            r5 = r1
        L_0x001d:
            int r6 = r0.j
            r7 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 & 7
            r8 = 16
            if (r7 == r8) goto L_0x0034
            r8 = 80
            if (r7 == r8) goto L_0x002c
            goto L_0x003e
        L_0x002c:
            int r7 = r25 - r23
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.k
            int r7 = r7 - r4
            goto L_0x003d
        L_0x0034:
            int r7 = r25 - r23
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.k
            int r7 = r7 - r4
            int r7 = r7 / 2
        L_0x003d:
            int r3 = r3 + r7
        L_0x003e:
            int r4 = r1 + r2
            int r7 = r24 - r22
            r8 = 0
            int r9 = r0.a(r6, r7, r4, r8)
            int r5 = r5 + r9
            java.util.List<java.lang.Integer> r9 = r0.o
            int r9 = r9.size()
            r11 = r3
            r10 = r5
            r3 = 0
            r5 = 0
        L_0x0052:
            if (r3 >= r9) goto L_0x0134
            java.util.List<java.lang.Integer> r12 = r0.o
            java.lang.Object r12 = r12.get(r3)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            java.util.List<java.lang.Integer> r13 = r0.m
            java.lang.Object r13 = r13.get(r3)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            java.util.List<java.lang.Float> r14 = r0.l
            java.lang.Object r14 = r14.get(r3)
            java.lang.Float r14 = (java.lang.Float) r14
            float r14 = r14.floatValue()
            r15 = r10
            r10 = r5
            r5 = 0
        L_0x007b:
            if (r5 >= r12) goto L_0x0105
            int r8 = r20.getChildCount()
            if (r10 >= r8) goto L_0x0105
            int r8 = r10 + 1
            android.view.View r10 = r0.getChildAt(r10)
            r16 = r1
            int r1 = r10.getVisibility()
            r22 = r8
            r8 = 8
            if (r1 == r8) goto L_0x00fe
            int r5 = r5 + 1
            android.view.ViewGroup$LayoutParams r1 = r10.getLayoutParams()
            boolean r8 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r8 == 0) goto L_0x00ac
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r8 = r1.leftMargin
            r23 = r5
            int r5 = r1.rightMargin
            int r1 = r1.topMargin
            r24 = r9
            goto L_0x00b3
        L_0x00ac:
            r23 = r5
            r24 = r9
            r1 = 0
            r5 = 0
            r8 = 0
        L_0x00b3:
            int r9 = r10.getMeasuredWidth()
            int r17 = r10.getMeasuredHeight()
            r25 = r12
            boolean r12 = r0.f22491h
            if (r12 == 0) goto L_0x00d8
            int r12 = r15 - r5
            r18 = r13
            int r13 = r12 - r9
            int r1 = r1 + r11
            r19 = r4
            int r4 = r1 + r17
            r10.layout(r13, r1, r12, r4)
            float r1 = (float) r15
            float r4 = (float) r9
            float r4 = r4 + r14
            float r8 = (float) r8
            float r4 = r4 + r8
            float r5 = (float) r5
            float r4 = r4 + r5
            float r1 = r1 - r4
            goto L_0x00ee
        L_0x00d8:
            r19 = r4
            r18 = r13
            int r4 = r15 + r8
            int r1 = r1 + r11
            int r12 = r4 + r9
            int r13 = r1 + r17
            r10.layout(r4, r1, r12, r13)
            float r1 = (float) r15
            float r4 = (float) r9
            float r4 = r4 + r14
            float r8 = (float) r8
            float r4 = r4 + r8
            float r5 = (float) r5
            float r4 = r4 + r5
            float r1 = r1 + r4
        L_0x00ee:
            int r15 = (int) r1
            r10 = r22
            r5 = r23
            r9 = r24
            r12 = r25
            r1 = r16
            r13 = r18
            r4 = r19
            goto L_0x0102
        L_0x00fe:
            r10 = r22
            r1 = r16
        L_0x0102:
            r8 = 0
            goto L_0x007b
        L_0x0105:
            r16 = r1
            r19 = r4
            r24 = r9
            r18 = r13
            boolean r1 = r0.f22491h
            if (r1 == 0) goto L_0x0117
            int r1 = r20.getWidth()
            int r1 = r1 - r2
            goto L_0x0119
        L_0x0117:
            r1 = r16
        L_0x0119:
            int r3 = r3 + 1
            r4 = r19
            int r5 = r0.a(r6, r7, r4, r3)
            int r1 = r1 + r5
            float r5 = (float) r11
            r8 = r18
            float r8 = (float) r8
            float r9 = r0.f22490g
            float r8 = r8 + r9
            float r5 = r5 + r8
            int r11 = (int) r5
            r9 = r24
            r5 = r10
            r8 = 0
            r10 = r1
            r1 = r16
            goto L_0x0052
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.busticket.widgets.BusFlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    private int a(int i2, int i3, int i4, int i5) {
        if (this.f22486c == -65536 || i5 >= this.n.size() || i5 >= this.o.size() || this.o.get(i5).intValue() <= 0) {
            return 0;
        }
        if (i2 == 1) {
            return ((i3 - i4) - this.n.get(i5).intValue()) / 2;
        }
        if (i2 != 5) {
            return 0;
        }
        return (i3 - i4) - this.n.get(i5).intValue();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void setFlow(boolean z) {
        this.f22485b = z;
        requestLayout();
    }

    public int getChildSpacing() {
        return this.f22486c;
    }

    public void setChildSpacing(int i2) {
        this.f22486c = i2;
        requestLayout();
    }

    public int getChildSpacingForLastRow() {
        return this.f22488e;
    }

    public void setChildSpacingForLastRow(int i2) {
        this.f22488e = i2;
        requestLayout();
    }

    public float getRowSpacing() {
        return this.f22489f;
    }

    public void setRowSpacing(float f2) {
        this.f22489f = f2;
        requestLayout();
    }

    public int getMaxRows() {
        return this.f22492i;
    }

    public void setMaxRows(int i2) {
        this.f22492i = i2;
        requestLayout();
    }

    public void setGravity(int i2) {
        if (this.j != i2) {
            this.j = i2;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.f22491h = z;
        requestLayout();
    }

    public int getMinChildSpacing() {
        return this.f22487d;
    }

    public void setMinChildSpacing(int i2) {
        this.f22487d = i2;
        requestLayout();
    }

    private static float b(int i2, int i3, int i4, int i5) {
        if (i2 != -65536) {
            return (float) i2;
        }
        if (i5 > 1) {
            return (float) ((i3 - i4) / (i5 - 1));
        }
        return 0.0f;
    }

    private float a() {
        return TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics());
    }
}
