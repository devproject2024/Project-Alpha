package net.one97.paytm.passbook.subWallet.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ToggleButton;
import java.util.List;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.customview.ToggleStatusButton;
import net.one97.paytm.passbook.transactionDetail.b.a;

public class FlowLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final String f58920a = FlowLayout.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f58921b;

    /* renamed from: c  reason: collision with root package name */
    private int f58922c;

    /* renamed from: d  reason: collision with root package name */
    private int f58923d;

    /* renamed from: e  reason: collision with root package name */
    private int f58924e;

    /* renamed from: f  reason: collision with root package name */
    private float f58925f;

    /* renamed from: g  reason: collision with root package name */
    private float f58926g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f58927h;

    /* renamed from: i  reason: collision with root package name */
    private int f58928i;
    private int j;
    private int k;
    private int l;
    private List<Float> m;
    private List<Integer> n;
    private List<Integer> o;
    /* access modifiers changed from: private */
    public List<Integer> p;
    private List<View> q;
    private boolean r;
    private ViewTreeObserver.OnGlobalLayoutListener s;
    private a.C1138a t;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d4, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d5, code lost:
        r8.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d8, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0077 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlowLayout(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            r7.<init>(r8, r9)
            r0 = 1
            r7.f58921b = r0
            r1 = 0
            r7.f58922c = r1
            r7.f58923d = r1
            r2 = -65538(0xfffffffffffefffe, float:NaN)
            r7.f58924e = r2
            r3 = 0
            r7.f58925f = r3
            r7.f58926g = r3
            r7.f58927h = r1
            r3 = 2147483647(0x7fffffff, float:NaN)
            r7.f58928i = r3
            r4 = -1
            r7.j = r4
            r5 = -65536(0xffffffffffff0000, float:NaN)
            r7.k = r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7.m = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7.n = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7.o = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7.p = r6
            net.one97.paytm.passbook.subWallet.widget.FlowLayout$1 r6 = new net.one97.paytm.passbook.subWallet.widget.FlowLayout$1
            r6.<init>()
            r7.s = r6
            android.content.res.Resources$Theme r8 = r8.getTheme()
            int[] r6 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook
            android.content.res.TypedArray r8 = r8.obtainStyledAttributes(r9, r6, r1, r1)
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpFlow     // Catch:{ all -> 0x00d4 }
            boolean r9 = r8.getBoolean(r9, r0)     // Catch:{ all -> 0x00d4 }
            r7.f58921b = r9     // Catch:{ all -> 0x00d4 }
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpChildSpacing     // Catch:{ NumberFormatException -> 0x0061 }
            int r9 = r8.getInt(r9, r1)     // Catch:{ NumberFormatException -> 0x0061 }
            r7.f58922c = r9     // Catch:{ NumberFormatException -> 0x0061 }
            goto L_0x006e
        L_0x0061:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpChildSpacing     // Catch:{ all -> 0x00d4 }
            float r0 = r7.c()     // Catch:{ all -> 0x00d4 }
            int r0 = (int) r0     // Catch:{ all -> 0x00d4 }
            int r9 = r8.getDimensionPixelSize(r9, r0)     // Catch:{ all -> 0x00d4 }
            r7.f58922c = r9     // Catch:{ all -> 0x00d4 }
        L_0x006e:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpMinChildSpacing     // Catch:{ NumberFormatException -> 0x0077 }
            int r9 = r8.getInt(r9, r1)     // Catch:{ NumberFormatException -> 0x0077 }
            r7.f58923d = r9     // Catch:{ NumberFormatException -> 0x0077 }
            goto L_0x0084
        L_0x0077:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpMinChildSpacing     // Catch:{ all -> 0x00d4 }
            float r0 = r7.c()     // Catch:{ all -> 0x00d4 }
            int r0 = (int) r0     // Catch:{ all -> 0x00d4 }
            int r9 = r8.getDimensionPixelSize(r9, r0)     // Catch:{ all -> 0x00d4 }
            r7.f58923d = r9     // Catch:{ all -> 0x00d4 }
        L_0x0084:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpChildSpacingForLastRow     // Catch:{ NumberFormatException -> 0x008d }
            int r9 = r8.getInt(r9, r2)     // Catch:{ NumberFormatException -> 0x008d }
            r7.f58924e = r9     // Catch:{ NumberFormatException -> 0x008d }
            goto L_0x009a
        L_0x008d:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpChildSpacingForLastRow     // Catch:{ all -> 0x00d4 }
            float r0 = r7.c()     // Catch:{ all -> 0x00d4 }
            int r0 = (int) r0     // Catch:{ all -> 0x00d4 }
            int r9 = r8.getDimensionPixelSize(r9, r0)     // Catch:{ all -> 0x00d4 }
            r7.f58924e = r9     // Catch:{ all -> 0x00d4 }
        L_0x009a:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpRowSpacing     // Catch:{ NumberFormatException -> 0x00a4 }
            int r9 = r8.getInt(r9, r1)     // Catch:{ NumberFormatException -> 0x00a4 }
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x00a4 }
            r7.f58925f = r9     // Catch:{ NumberFormatException -> 0x00a4 }
            goto L_0x00b0
        L_0x00a4:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpRowSpacing     // Catch:{ all -> 0x00d4 }
            float r0 = r7.c()     // Catch:{ all -> 0x00d4 }
            float r9 = r8.getDimension(r9, r0)     // Catch:{ all -> 0x00d4 }
            r7.f58925f = r9     // Catch:{ all -> 0x00d4 }
        L_0x00b0:
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpMaxRows     // Catch:{ all -> 0x00d4 }
            int r9 = r8.getInt(r9, r3)     // Catch:{ all -> 0x00d4 }
            r7.f58928i = r9     // Catch:{ all -> 0x00d4 }
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpRtl     // Catch:{ all -> 0x00d4 }
            boolean r9 = r8.getBoolean(r9, r1)     // Catch:{ all -> 0x00d4 }
            r7.f58927h = r9     // Catch:{ all -> 0x00d4 }
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_android_gravity     // Catch:{ all -> 0x00d4 }
            int r9 = r8.getInt(r9, r4)     // Catch:{ all -> 0x00d4 }
            r7.j = r9     // Catch:{ all -> 0x00d4 }
            int r9 = net.one97.paytm.passbook.R.styleable.FlowLayoutPassbook_flpRowVerticalGravity     // Catch:{ all -> 0x00d4 }
            int r9 = r8.getInt(r9, r5)     // Catch:{ all -> 0x00d4 }
            r7.k = r9     // Catch:{ all -> 0x00d4 }
            r8.recycle()
            return
        L_0x00d4:
            r9 = move-exception
            r8.recycle()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.subWallet.widget.FlowLayout.<init>(android.content.Context, android.util.AttributeSet):void");
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
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.p.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.f58921b;
        int i22 = (this.f58922c == -65536 && mode == 0) ? 0 : this.f58922c;
        float f3 = i22 == -65536 ? (float) this.f58923d : (float) i22;
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
                    this.m.add(Float.valueOf(b(i15, paddingLeft, i19, i18)));
                    this.p.add(Integer.valueOf(i18));
                    this.n.add(Integer.valueOf(i29));
                    int i33 = (int) f2;
                    this.o.add(Integer.valueOf(i27 - i33));
                    if (this.m.size() <= this.f58928i) {
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
        int i47 = this.f58924e;
        if (i47 == -65537) {
            if (this.m.size() > 0) {
                List<Float> list = this.m;
                list.add(list.get(list.size() - 1));
            } else {
                this.m.add(Float.valueOf(b(i40, paddingLeft, i45, i39)));
            }
        } else if (i47 != -65538) {
            this.m.add(Float.valueOf(b(i47, paddingLeft, i45, i39)));
        } else {
            this.m.add(Float.valueOf(b(i40, paddingLeft, i45, i39)));
        }
        this.p.add(Integer.valueOf(i39));
        this.n.add(Integer.valueOf(i46));
        this.o.add(Integer.valueOf(i27 - ((int) f5)));
        if (this.m.size() <= this.f58928i) {
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
        int min = Math.min(this.m.size(), this.f58928i);
        float f6 = (this.f58925f == -65536.0f && i44 == 0) ? 0.0f : this.f58925f;
        if (f6 == -65536.0f) {
            if (min > 1) {
                this.f58926g = (float) ((i43 - paddingTop) / (min - 1));
            } else {
                this.f58926g = 0.0f;
            }
            i7 = i43;
            i6 = i7;
        } else {
            this.f58926g = f6;
            if (min > 1) {
                float f7 = ((float) paddingTop) + (this.f58926g * ((float) (min - 1)));
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
        this.l = i6;
        if (i42 == 1073741824) {
            i4 = i5;
        }
        if (i44 != 1073741824) {
            i7 = i6;
        }
        setMeasuredDimension(i4, i7);
    }

    /* access modifiers changed from: protected */
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
            boolean r5 = r0.f58927h
            if (r5 == 0) goto L_0x001c
            int r5 = r22.getWidth()
            int r5 = r5 - r2
            goto L_0x001d
        L_0x001c:
            r5 = r1
        L_0x001d:
            int r6 = r0.j
            r7 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 & 7
            r8 = 80
            r9 = 16
            if (r7 == r9) goto L_0x0034
            if (r7 == r8) goto L_0x002c
            goto L_0x003e
        L_0x002c:
            int r7 = r27 - r25
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.l
            int r7 = r7 - r4
            goto L_0x003d
        L_0x0034:
            int r7 = r27 - r25
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.l
            int r7 = r7 - r4
            int r7 = r7 / 2
        L_0x003d:
            int r3 = r3 + r7
        L_0x003e:
            int r4 = r1 + r2
            int r7 = r26 - r24
            r10 = 0
            int r11 = r0.a(r6, r7, r4, r10)
            int r5 = r5 + r11
            int r11 = r0.k
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.util.List<java.lang.Integer> r12 = r0.p
            int r12 = r12.size()
            r13 = r3
            r3 = 0
            r14 = 0
        L_0x0055:
            if (r3 >= r12) goto L_0x0177
            java.util.List<java.lang.Integer> r15 = r0.p
            java.lang.Object r15 = r15.get(r3)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            java.util.List<java.lang.Integer> r10 = r0.n
            java.lang.Object r10 = r10.get(r3)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.util.List<java.lang.Float> r9 = r0.m
            java.lang.Object r9 = r9.get(r3)
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            r16 = r5
            r5 = 0
        L_0x007e:
            if (r5 >= r15) goto L_0x0142
            int r8 = r22.getChildCount()
            if (r14 >= r8) goto L_0x0142
            int r8 = r14 + 1
            android.view.View r14 = r0.getChildAt(r14)
            r17 = r1
            int r1 = r14.getVisibility()
            r24 = r8
            r8 = 8
            if (r1 == r8) goto L_0x0134
            int r5 = r5 + 1
            android.view.ViewGroup$LayoutParams r1 = r14.getLayoutParams()
            boolean r8 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r8 == 0) goto L_0x00b9
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
            goto L_0x00c3
        L_0x00b9:
            r25 = r5
            r26 = r12
            r27 = r15
            r1 = 0
            r5 = 0
            r8 = 0
            r12 = 0
        L_0x00c3:
            int r15 = r14.getMeasuredWidth()
            int r18 = r14.getMeasuredHeight()
            int r19 = r13 + r5
            r20 = r4
            r4 = 80
            if (r11 != r4) goto L_0x00dd
            int r5 = r13 + r10
            int r5 = r5 - r1
            int r19 = r5 - r18
            r1 = r19
            r4 = 16
            goto L_0x00ec
        L_0x00dd:
            r4 = 16
            if (r11 != r4) goto L_0x00ea
            int r5 = r10 - r5
            int r5 = r5 - r1
            int r5 = r5 - r18
            int r5 = r5 / 2
            int r19 = r19 + r5
        L_0x00ea:
            r1 = r19
        L_0x00ec:
            int r5 = r1 + r18
            boolean r4 = r0.f58927h
            if (r4 == 0) goto L_0x0108
            r4 = r16
            r16 = r11
            int r11 = r4 - r12
            r18 = r10
            int r10 = r11 - r15
            r14.layout(r10, r1, r11, r5)
            float r1 = (float) r4
            float r4 = (float) r15
            float r4 = r4 + r9
            float r5 = (float) r8
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 - r4
            goto L_0x011d
        L_0x0108:
            r18 = r10
            r4 = r16
            r16 = r11
            int r10 = r4 + r8
            int r11 = r10 + r15
            r14.layout(r10, r1, r11, r5)
            float r1 = (float) r4
            float r4 = (float) r15
            float r4 = r4 + r9
            float r5 = (float) r8
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 + r4
        L_0x011d:
            int r1 = (int) r1
            r14 = r24
            r5 = r25
            r12 = r26
            r15 = r27
            r11 = r16
            r10 = r18
            r4 = r20
            r8 = 80
            r16 = r1
            r1 = r17
            goto L_0x007e
        L_0x0134:
            r20 = r4
            r4 = r16
            r14 = r24
            r1 = r17
            r4 = r20
            r8 = 80
            goto L_0x007e
        L_0x0142:
            r17 = r1
            r20 = r4
            r18 = r10
            r16 = r11
            r26 = r12
            boolean r1 = r0.f58927h
            if (r1 == 0) goto L_0x0156
            int r1 = r22.getWidth()
            int r1 = r1 - r2
            goto L_0x0158
        L_0x0156:
            r1 = r17
        L_0x0158:
            int r3 = r3 + 1
            r4 = r20
            int r5 = r0.a(r6, r7, r4, r3)
            int r5 = r5 + r1
            float r1 = (float) r13
            r8 = r18
            float r8 = (float) r8
            float r9 = r0.f58926g
            float r8 = r8 + r9
            float r1 = r1 + r8
            int r13 = (int) r1
            r12 = r26
            r11 = r16
            r1 = r17
            r8 = 80
            r9 = 16
            r10 = 0
            goto L_0x0055
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.subWallet.widget.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    private int a(int i2, int i3, int i4, int i5) {
        if (this.f58922c == -65536 || i5 >= this.o.size() || i5 >= this.p.size() || this.p.get(i5).intValue() <= 0) {
            return 0;
        }
        if (i2 == 1) {
            return ((i3 - i4) - this.o.get(i5).intValue()) / 2;
        }
        if (i2 != 5) {
            return 0;
        }
        return (i3 - i4) - this.o.get(i5).intValue();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void setFlow(boolean z) {
        this.f58921b = z;
        requestLayout();
    }

    public int getChildSpacing() {
        return this.f58922c;
    }

    public void setChildSpacing(int i2) {
        this.f58922c = i2;
        requestLayout();
    }

    public int getChildSpacingForLastRow() {
        return this.f58924e;
    }

    public void setChildSpacingForLastRow(int i2) {
        this.f58924e = i2;
        requestLayout();
    }

    public float getRowSpacing() {
        return this.f58925f;
    }

    public void setRowSpacing(float f2) {
        this.f58925f = f2;
        requestLayout();
    }

    public int getMaxRows() {
        return this.f58928i;
    }

    public void setMaxRows(int i2) {
        this.f58928i = i2;
        requestLayout();
    }

    public void setGravity(int i2) {
        if (this.j != i2) {
            this.j = i2;
            requestLayout();
        }
    }

    public void setRowVerticalGravity(int i2) {
        if (this.k != i2) {
            this.k = i2;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.f58927h = z;
        requestLayout();
    }

    public int getMinChildSpacing() {
        return this.f58923d;
    }

    public void setMinChildSpacing(int i2) {
        this.f58923d = i2;
        requestLayout();
    }

    public int getRowsCount() {
        return this.p.size();
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

    private float c() {
        return TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics());
    }

    public final void a(List<View> list) {
        this.q = list;
        setMaxRows(2);
        for (int i2 = 0; i2 < list.size(); i2++) {
            addView(list.get(i2));
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.s);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_search_toggle_button, this, false);
        ToggleButton toggleButton = (ToggleButton) inflate.findViewById(R.id.tb_pb_search);
        String str = "+ " + Math.min(i2, 4);
        toggleButton.setText(str);
        toggleButton.setTextOn(str);
        toggleButton.setTextOff(str);
        toggleButton.setTextColor(getResources().getColor(R.color.paytm_blue));
        super.addView(inflate);
        inflate.setOnClickListener(new View.OnClickListener(i2) {
            private final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                FlowLayout.this.a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        removeView(view);
        int childCount = getChildCount();
        int i3 = childCount;
        while (i3 < this.q.size() && i3 < childCount + 4) {
            if (this.q.get(i3).getParent() == null) {
                addView(this.q.get(i3));
            }
            i3++;
        }
        int i4 = i2 - 4;
        if (i4 > 0) {
            a(i4);
        }
        setMaxRows(Integer.MAX_VALUE);
    }

    public void addView(View view) {
        super.addView(view);
        if (view instanceof ToggleStatusButton) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    FlowLayout.this.a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ToggleStatusButton) {
                ((ToggleStatusButton) childAt).setChecked(false);
            }
        }
        if (view instanceof ToggleStatusButton) {
            ToggleStatusButton toggleStatusButton = (ToggleStatusButton) view;
            toggleStatusButton.setChecked(true);
            a.C1138a aVar = this.t;
            if (aVar != null) {
                indexOfChild(view);
                aVar.a(toggleStatusButton);
            }
        }
    }

    public final void a() {
        this.r = false;
    }

    public final void b() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ToggleStatusButton) {
                ((ToggleStatusButton) childAt).setChecked(false);
            }
        }
    }

    public int getSelectedViewIndex() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof ToggleStatusButton) && ((ToggleStatusButton) childAt).getToggleBtn().isChecked()) {
                return i2;
            }
        }
        return -1;
    }

    public void setOnSelectListener(a.C1138a aVar) {
        this.t = aVar;
    }
}
