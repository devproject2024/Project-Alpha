package com.business.merchant_payments.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class MpFlowLayout extends ViewGroup {
    public static final int DEFAULT_CHILD_SPACING = 0;
    public static final int DEFAULT_CHILD_SPACING_FOR_LAST_ROW = -65538;
    public static final boolean DEFAULT_FLOW = true;
    public static final int DEFAULT_MAX_ROWS = Integer.MAX_VALUE;
    public static final float DEFAULT_ROW_SPACING = 0.0f;
    public static final boolean DEFAULT_RTL = false;
    public static final String LOG_TAG = MpFlowLayout.class.getSimpleName();
    public static final int ROW_VERTICAL_GRAVITY_AUTO = -65536;
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;
    public static final int SPACING_UNDEFINED = -65538;
    public static final int UNSPECIFIED_GRAVITY = -1;
    public float mAdjustedRowSpacing;
    public List<Integer> mChildNumForRow;
    public int mChildSpacing;
    public int mChildSpacingForLastRow;
    public int mExactMeasuredHeight;
    public boolean mFlow;
    public int mGravity;
    public List<Integer> mHeightForRow;
    public List<Float> mHorizontalSpacingForRow;
    public int mMaxRows;
    public int mMinChildSpacing;
    public float mRowSpacing;
    public int mRowVerticalGravity;
    public boolean mRtl;
    public List<Integer> mWidthForRow;

    public MpFlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x009d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x005a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0070 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MpFlowLayout(android.content.Context r9, android.util.AttributeSet r10) {
        /*
            r8 = this;
            r8.<init>(r9, r10)
            r0 = 1
            r8.mFlow = r0
            r1 = 0
            r8.mChildSpacing = r1
            r8.mMinChildSpacing = r1
            r2 = -65538(0xfffffffffffefffe, float:NaN)
            r8.mChildSpacingForLastRow = r2
            r3 = 0
            r8.mRowSpacing = r3
            r8.mAdjustedRowSpacing = r3
            r8.mRtl = r1
            r4 = 2147483647(0x7fffffff, float:NaN)
            r8.mMaxRows = r4
            r5 = -1
            r8.mGravity = r5
            r6 = -65536(0xffffffffffff0000, float:NaN)
            r8.mRowVerticalGravity = r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mHorizontalSpacingForRow = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mHeightForRow = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mWidthForRow = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8.mChildNumForRow = r7
            android.content.res.Resources$Theme r9 = r9.getTheme()
            int[] r7 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r10, r7, r1, r1)
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflFlow     // Catch:{ all -> 0x00cd }
            boolean r10 = r9.getBoolean(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mFlow = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflChildSpacing     // Catch:{ NumberFormatException -> 0x005a }
            int r10 = r9.getInt(r10, r1)     // Catch:{ NumberFormatException -> 0x005a }
            r8.mChildSpacing = r10     // Catch:{ NumberFormatException -> 0x005a }
            goto L_0x0067
        L_0x005a:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflChildSpacing     // Catch:{ all -> 0x00cd }
            float r0 = r8.dpToPx(r3)     // Catch:{ all -> 0x00cd }
            int r0 = (int) r0     // Catch:{ all -> 0x00cd }
            int r10 = r9.getDimensionPixelSize(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mChildSpacing = r10     // Catch:{ all -> 0x00cd }
        L_0x0067:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflMinChildSpacing     // Catch:{ NumberFormatException -> 0x0070 }
            int r10 = r9.getInt(r10, r1)     // Catch:{ NumberFormatException -> 0x0070 }
            r8.mMinChildSpacing = r10     // Catch:{ NumberFormatException -> 0x0070 }
            goto L_0x007d
        L_0x0070:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflMinChildSpacing     // Catch:{ all -> 0x00cd }
            float r0 = r8.dpToPx(r3)     // Catch:{ all -> 0x00cd }
            int r0 = (int) r0     // Catch:{ all -> 0x00cd }
            int r10 = r9.getDimensionPixelSize(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mMinChildSpacing = r10     // Catch:{ all -> 0x00cd }
        L_0x007d:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflChildSpacingForLastRow     // Catch:{ NumberFormatException -> 0x0086 }
            int r10 = r9.getInt(r10, r2)     // Catch:{ NumberFormatException -> 0x0086 }
            r8.mChildSpacingForLastRow = r10     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0093
        L_0x0086:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflChildSpacingForLastRow     // Catch:{ all -> 0x00cd }
            float r0 = r8.dpToPx(r3)     // Catch:{ all -> 0x00cd }
            int r0 = (int) r0     // Catch:{ all -> 0x00cd }
            int r10 = r9.getDimensionPixelSize(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mChildSpacingForLastRow = r10     // Catch:{ all -> 0x00cd }
        L_0x0093:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflRowSpacing     // Catch:{ NumberFormatException -> 0x009d }
            int r10 = r9.getInt(r10, r1)     // Catch:{ NumberFormatException -> 0x009d }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x009d }
            r8.mRowSpacing = r10     // Catch:{ NumberFormatException -> 0x009d }
            goto L_0x00a9
        L_0x009d:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflRowSpacing     // Catch:{ all -> 0x00cd }
            float r0 = r8.dpToPx(r3)     // Catch:{ all -> 0x00cd }
            float r10 = r9.getDimension(r10, r0)     // Catch:{ all -> 0x00cd }
            r8.mRowSpacing = r10     // Catch:{ all -> 0x00cd }
        L_0x00a9:
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflMaxRows     // Catch:{ all -> 0x00cd }
            int r10 = r9.getInt(r10, r4)     // Catch:{ all -> 0x00cd }
            r8.mMaxRows = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflRtl     // Catch:{ all -> 0x00cd }
            boolean r10 = r9.getBoolean(r10, r1)     // Catch:{ all -> 0x00cd }
            r8.mRtl = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_android_gravity     // Catch:{ all -> 0x00cd }
            int r10 = r9.getInt(r10, r5)     // Catch:{ all -> 0x00cd }
            r8.mGravity = r10     // Catch:{ all -> 0x00cd }
            int r10 = com.business.merchant_payments.R.styleable.MpPfbFlowLayout_mppfbflRowVerticalGravity     // Catch:{ all -> 0x00cd }
            int r10 = r9.getInt(r10, r6)     // Catch:{ all -> 0x00cd }
            r8.mRowVerticalGravity = r10     // Catch:{ all -> 0x00cd }
            r9.recycle()
            return
        L_0x00cd:
            r10 = move-exception
            r9.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.widget.MpFlowLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

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
        View view;
        int i18;
        int i19;
        int i20;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.mHorizontalSpacingForRow.clear();
        this.mHeightForRow.clear();
        this.mWidthForRow.clear();
        this.mChildNumForRow.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.mFlow;
        int i21 = (this.mChildSpacing == -65536 && mode == 0) ? 0 : this.mChildSpacing;
        float f3 = i21 == -65536 ? (float) this.mMinChildSpacing : (float) i21;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        while (i24 < childCount) {
            float f4 = f3;
            View childAt = getChildAt(i24);
            int i29 = i22;
            if (childAt.getVisibility() == 8) {
                int i30 = i2;
                i8 = i24;
                i14 = i21;
                i10 = mode;
                i7 = mode2;
                i9 = childCount;
                i15 = i29;
                i11 = size2;
                i13 = i23;
                int i31 = i3;
                float f5 = f4;
                i12 = size;
                f2 = f5;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i9 = childCount;
                    i17 = i29;
                    i11 = size2;
                    i18 = i23;
                    i8 = i24;
                    i7 = mode2;
                    view = childAt;
                    float f6 = f4;
                    i12 = size;
                    f2 = f6;
                    i16 = i21;
                    i10 = mode;
                    measureChildWithMargins(childAt, i2, 0, i3, i28);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i20 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i19 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i32 = i2;
                    int i33 = i3;
                } else {
                    i8 = i24;
                    i16 = i21;
                    i10 = mode;
                    i7 = mode2;
                    i9 = childCount;
                    i17 = i29;
                    view = childAt;
                    i11 = size2;
                    i18 = i23;
                    float f7 = f4;
                    i12 = size;
                    f2 = f7;
                    measureChild(view, i2, i3);
                    i20 = 0;
                    i19 = 0;
                }
                i15 = view.getMeasuredWidth() + i20;
                int measuredHeight = view.getMeasuredHeight() + i19;
                if (!z || i26 + i15 <= paddingLeft) {
                    i14 = i16;
                    i13 = i18 + 1;
                    i15 += i17;
                    i27 = Math.max(i27, measuredHeight);
                    i26 = (int) (((float) i26) + ((float) i15) + f2);
                } else {
                    i14 = i16;
                    this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(i14, paddingLeft, i17, i18)));
                    this.mChildNumForRow.add(Integer.valueOf(i18));
                    this.mHeightForRow.add(Integer.valueOf(i27));
                    int i34 = (int) f2;
                    this.mWidthForRow.add(Integer.valueOf(i26 - i34));
                    if (this.mHorizontalSpacingForRow.size() <= this.mMaxRows) {
                        i28 += i27;
                    }
                    i27 = measuredHeight;
                    i25 = Math.max(i25, i26);
                    i26 = i34 + i15;
                    i13 = 1;
                }
            }
            i24 = i8 + 1;
            i22 = i15;
            i21 = i14;
            f3 = f2;
            i23 = i13;
            size = i12;
            size2 = i11;
            mode = i10;
            childCount = i9;
            mode2 = i7;
        }
        int i35 = i22;
        int i36 = i21;
        int i37 = size;
        int i38 = mode;
        int i39 = size2;
        int i40 = mode2;
        int i41 = i23;
        float f8 = f3;
        int i42 = i27;
        int i43 = this.mChildSpacingForLastRow;
        if (i43 == -65537) {
            if (this.mHorizontalSpacingForRow.size() > 0) {
                List<Float> list = this.mHorizontalSpacingForRow;
                list.add(list.get(list.size() - 1));
            } else {
                this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(i36, paddingLeft, i35, i41)));
            }
        } else if (i43 != -65538) {
            this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(i43, paddingLeft, i35, i41)));
        } else {
            this.mHorizontalSpacingForRow.add(Float.valueOf(getSpacingForRow(i36, paddingLeft, i35, i41)));
        }
        this.mChildNumForRow.add(Integer.valueOf(i41));
        this.mHeightForRow.add(Integer.valueOf(i42));
        this.mWidthForRow.add(Integer.valueOf(i26 - ((int) f8)));
        if (this.mHorizontalSpacingForRow.size() <= this.mMaxRows) {
            i28 += i42;
        }
        int max = Math.max(i25, i26);
        if (i36 == -65536) {
            i5 = i37;
            i4 = i5;
        } else if (i38 == 0) {
            i4 = max + getPaddingLeft() + getPaddingRight();
            i5 = i37;
        } else {
            i5 = i37;
            i4 = Math.min(max + getPaddingLeft() + getPaddingRight(), i5);
        }
        int paddingTop = i28 + getPaddingTop() + getPaddingBottom();
        int min = Math.min(this.mHorizontalSpacingForRow.size(), this.mMaxRows);
        float f9 = (this.mRowSpacing == -65536.0f && i40 == 0) ? 0.0f : this.mRowSpacing;
        if (f9 == -65536.0f) {
            if (min > 1) {
                this.mAdjustedRowSpacing = (float) ((i39 - paddingTop) / (min - 1));
            } else {
                this.mAdjustedRowSpacing = 0.0f;
            }
            i6 = i39;
            paddingTop = i6;
        } else {
            this.mAdjustedRowSpacing = f9;
            if (min > 1) {
                float f10 = ((float) paddingTop) + (f9 * ((float) (min - 1)));
                if (i40 == 0) {
                    paddingTop = (int) f10;
                } else {
                    i6 = i39;
                    paddingTop = Math.min((int) f10, i6);
                }
            }
            i6 = i39;
        }
        this.mExactMeasuredHeight = paddingTop;
        if (i38 == 1073741824) {
            i4 = i5;
        }
        if (i40 != 1073741824) {
            i6 = paddingTop;
        }
        setMeasuredDimension(i4, i6);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r22
            int r1 = r22.getPaddingLeft()
            int r2 = r22.getPaddingRight()
            int r3 = r22.getPaddingTop()
            int r4 = r22.getPaddingBottom()
            boolean r5 = r0.mRtl
            if (r5 == 0) goto L_0x001c
            int r5 = r22.getWidth()
            int r5 = r5 - r2
            goto L_0x001d
        L_0x001c:
            r5 = r1
        L_0x001d:
            int r6 = r0.mGravity
            r7 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 & 7
            r8 = 80
            r9 = 16
            if (r7 == r9) goto L_0x0033
            if (r7 != r8) goto L_0x003d
            int r7 = r27 - r25
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.mExactMeasuredHeight
            int r7 = r7 - r4
            goto L_0x003c
        L_0x0033:
            int r7 = r27 - r25
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.mExactMeasuredHeight
            int r7 = r7 - r4
            int r7 = r7 / 2
        L_0x003c:
            int r3 = r3 + r7
        L_0x003d:
            int r4 = r1 + r2
            int r7 = r26 - r24
            r10 = 0
            int r11 = r0.getHorizontalGravityOffsetForRow(r6, r7, r4, r10)
            int r5 = r5 + r11
            int r11 = r0.mRowVerticalGravity
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.util.List<java.lang.Integer> r12 = r0.mChildNumForRow
            int r12 = r12.size()
            r14 = r3
            r13 = r5
            r3 = 0
            r5 = 0
        L_0x0055:
            if (r3 >= r12) goto L_0x017a
            java.util.List<java.lang.Integer> r15 = r0.mChildNumForRow
            java.lang.Object r15 = r15.get(r3)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            java.util.List<java.lang.Integer> r10 = r0.mHeightForRow
            java.lang.Object r10 = r10.get(r3)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.util.List<java.lang.Float> r9 = r0.mHorizontalSpacingForRow
            java.lang.Object r9 = r9.get(r3)
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            r16 = r13
            r13 = r5
            r5 = 0
        L_0x007f:
            if (r5 >= r15) goto L_0x0143
            int r8 = r22.getChildCount()
            if (r13 >= r8) goto L_0x0143
            int r8 = r13 + 1
            android.view.View r13 = r0.getChildAt(r13)
            r17 = r1
            int r1 = r13.getVisibility()
            r24 = r8
            r8 = 8
            if (r1 == r8) goto L_0x0135
            int r5 = r5 + 1
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            boolean r8 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r8 == 0) goto L_0x00ba
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r8 = r1.leftMargin
            r25 = r5
            int r5 = r1.rightMargin
            r26 = r5
            int r5 = r1.topMargin
            int r1 = r1.bottomMargin
            r27 = r15
            r21 = r12
            r12 = r26
            r26 = r21
            goto L_0x00c4
        L_0x00ba:
            r25 = r5
            r26 = r12
            r27 = r15
            r1 = 0
            r5 = 0
            r8 = 0
            r12 = 0
        L_0x00c4:
            int r15 = r13.getMeasuredWidth()
            int r18 = r13.getMeasuredHeight()
            int r19 = r14 + r5
            r20 = r4
            r4 = 80
            if (r11 != r4) goto L_0x00de
            int r5 = r14 + r10
            int r5 = r5 - r1
            int r19 = r5 - r18
            r1 = r19
            r4 = 16
            goto L_0x00ed
        L_0x00de:
            r4 = 16
            if (r11 != r4) goto L_0x00eb
            int r5 = r10 - r5
            int r5 = r5 - r1
            int r5 = r5 - r18
            int r5 = r5 / 2
            int r19 = r19 + r5
        L_0x00eb:
            r1 = r19
        L_0x00ed:
            int r5 = r1 + r18
            boolean r4 = r0.mRtl
            if (r4 == 0) goto L_0x0109
            r4 = r16
            r16 = r11
            int r11 = r4 - r12
            r18 = r10
            int r10 = r11 - r15
            r13.layout(r10, r1, r11, r5)
            float r1 = (float) r4
            float r4 = (float) r15
            float r4 = r4 + r9
            float r5 = (float) r8
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 - r4
            goto L_0x011e
        L_0x0109:
            r18 = r10
            r4 = r16
            r16 = r11
            int r10 = r4 + r8
            int r11 = r10 + r15
            r13.layout(r10, r1, r11, r5)
            float r1 = (float) r4
            float r4 = (float) r15
            float r4 = r4 + r9
            float r5 = (float) r8
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 + r4
        L_0x011e:
            int r1 = (int) r1
            r13 = r24
            r5 = r25
            r12 = r26
            r15 = r27
            r11 = r16
            r10 = r18
            r4 = r20
            r8 = 80
            r16 = r1
            r1 = r17
            goto L_0x007f
        L_0x0135:
            r20 = r4
            r4 = r16
            r13 = r24
            r1 = r17
            r4 = r20
            r8 = 80
            goto L_0x007f
        L_0x0143:
            r17 = r1
            r20 = r4
            r18 = r10
            r16 = r11
            r26 = r12
            boolean r1 = r0.mRtl
            if (r1 == 0) goto L_0x0157
            int r1 = r22.getWidth()
            int r1 = r1 - r2
            goto L_0x0159
        L_0x0157:
            r1 = r17
        L_0x0159:
            int r3 = r3 + 1
            r4 = r20
            int r5 = r0.getHorizontalGravityOffsetForRow(r6, r7, r4, r3)
            int r1 = r1 + r5
            float r5 = (float) r14
            r8 = r18
            float r8 = (float) r8
            float r9 = r0.mAdjustedRowSpacing
            float r8 = r8 + r9
            float r5 = r5 + r8
            int r14 = (int) r5
            r12 = r26
            r5 = r13
            r11 = r16
            r8 = 80
            r9 = 16
            r10 = 0
            r13 = r1
            r1 = r17
            goto L_0x0055
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.widget.MpFlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    private int getHorizontalGravityOffsetForRow(int i2, int i3, int i4, int i5) {
        if (this.mChildSpacing == -65536 || i5 >= this.mWidthForRow.size() || i5 >= this.mChildNumForRow.size() || this.mChildNumForRow.get(i5).intValue() <= 0) {
            return 0;
        }
        if (i2 == 1) {
            return ((i3 - i4) - this.mWidthForRow.get(i5).intValue()) / 2;
        }
        if (i2 == 5) {
            return (i3 - i4) - this.mWidthForRow.get(i5).intValue();
        }
        return 0;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean isFlow() {
        return this.mFlow;
    }

    public void setFlow(boolean z) {
        this.mFlow = z;
        requestLayout();
    }

    public int getChildSpacing() {
        return this.mChildSpacing;
    }

    public void setChildSpacing(int i2) {
        this.mChildSpacing = i2;
        requestLayout();
    }

    public int getChildSpacingForLastRow() {
        return this.mChildSpacingForLastRow;
    }

    public void setChildSpacingForLastRow(int i2) {
        this.mChildSpacingForLastRow = i2;
        requestLayout();
    }

    public float getRowSpacing() {
        return this.mRowSpacing;
    }

    public void setRowSpacing(float f2) {
        this.mRowSpacing = f2;
        requestLayout();
    }

    public int getMaxRows() {
        return this.mMaxRows;
    }

    public void setMaxRows(int i2) {
        this.mMaxRows = i2;
        requestLayout();
    }

    public void setGravity(int i2) {
        if (this.mGravity != i2) {
            this.mGravity = i2;
            requestLayout();
        }
    }

    public void setRowVerticalGravity(int i2) {
        if (this.mRowVerticalGravity != i2) {
            this.mRowVerticalGravity = i2;
            requestLayout();
        }
    }

    public boolean isRtl() {
        return this.mRtl;
    }

    public void setRtl(boolean z) {
        this.mRtl = z;
        requestLayout();
    }

    public int getMinChildSpacing() {
        return this.mMinChildSpacing;
    }

    public void setMinChildSpacing(int i2) {
        this.mMinChildSpacing = i2;
        requestLayout();
    }

    public int getRowsCount() {
        return this.mChildNumForRow.size();
    }

    private float getSpacingForRow(int i2, int i3, int i4, int i5) {
        if (i2 != -65536) {
            return (float) i2;
        }
        if (i5 > 1) {
            return (float) ((i3 - i4) / (i5 - 1));
        }
        return 0.0f;
    }

    private float dpToPx(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }
}
