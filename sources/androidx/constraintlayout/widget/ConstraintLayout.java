package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.a.b;
import androidx.constraintlayout.a.a.d;
import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import androidx.constraintlayout.a.a.h;
import androidx.constraintlayout.a.e;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected b mConstraintLayoutSpec = null;
    private c mConstraintSet = null;
    private int mConstraintSetId = -1;
    private d mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    public f mLayoutWidget = new f();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    a mMeasurer = new a(this);
    private e mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mOptimizationLevel = 257;
    private SparseArray<androidx.constraintlayout.a.a.e> mTempMapIdToWidget = new SparseArray<>();

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void setDesignInformation(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object getDesignInformation(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(attributeSet, i2, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init(attributeSet, i2, i3);
    }

    public void setId(int i2) {
        this.mChildrenByIds.remove(getId());
        super.setId(i2);
        this.mChildrenByIds.put(getId(), this);
    }

    class a implements b.C0030b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f2493a;

        /* renamed from: b  reason: collision with root package name */
        int f2494b;

        /* renamed from: c  reason: collision with root package name */
        int f2495c;

        /* renamed from: d  reason: collision with root package name */
        int f2496d;

        /* renamed from: e  reason: collision with root package name */
        int f2497e;

        /* renamed from: f  reason: collision with root package name */
        int f2498f;

        /* renamed from: g  reason: collision with root package name */
        int f2499g;

        public a(ConstraintLayout constraintLayout) {
            this.f2493a = constraintLayout;
        }

        private static boolean a(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i4 == size) {
                return true;
            }
            return false;
        }

        public final void a() {
            int childCount = this.f2493a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f2493a.getChildAt(i2);
                if (childAt instanceof Placeholder) {
                    Placeholder placeholder = (Placeholder) childAt;
                    if (placeholder.f2503b != null) {
                        LayoutParams layoutParams = (LayoutParams) placeholder.getLayoutParams();
                        LayoutParams layoutParams2 = (LayoutParams) placeholder.f2503b.getLayoutParams();
                        layoutParams2.an.an = 0;
                        if (layoutParams.an.U[0] != e.a.FIXED) {
                            layoutParams.an.g(layoutParams2.an.n());
                        }
                        if (layoutParams.an.U[1] != e.a.FIXED) {
                            layoutParams.an.h(layoutParams2.an.o());
                        }
                        layoutParams2.an.an = 8;
                    }
                }
            }
            int size = this.f2493a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    this.f2493a.mConstraintHelpers.get(i3);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:198:0x02b4 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:203:0x02be  */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x02c3  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x02c7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(androidx.constraintlayout.a.a.e r19, androidx.constraintlayout.a.a.a.b.a r20) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                r2 = r20
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r1.an
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001b
                boolean r3 = r1.F
                if (r3 != 0) goto L_0x001b
                r2.f2014h = r5
                r2.f2015i = r5
                r2.j = r5
                return
            L_0x001b:
                androidx.constraintlayout.a.a.e r3 = r1.V
                if (r3 != 0) goto L_0x0020
                return
            L_0x0020:
                androidx.constraintlayout.a.a.e$a r3 = r2.f2010d
                androidx.constraintlayout.a.a.e$a r4 = r2.f2011e
                int r6 = r2.f2012f
                int r7 = r2.f2013g
                int r8 = r0.f2494b
                int r9 = r0.f2495c
                int r8 = r8 + r9
                int r9 = r0.f2496d
                java.lang.Object r10 = r1.am
                android.view.View r10 = (android.view.View) r10
                int[] r11 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.f2482a
                int r12 = r3.ordinal()
                r11 = r11[r12]
                r12 = 4
                r13 = 3
                r14 = 2
                r15 = -2
                r5 = 1
                if (r11 == r5) goto L_0x00bd
                if (r11 == r14) goto L_0x00b6
                if (r11 == r13) goto L_0x0098
                if (r11 == r12) goto L_0x004b
                r6 = 0
                goto L_0x00c3
            L_0x004b:
                int r6 = r0.f2498f
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r15)
                int r9 = r1.p
                if (r9 != r5) goto L_0x0057
                r9 = 1
                goto L_0x0058
            L_0x0057:
                r9 = 0
            L_0x0058:
                int r11 = r2.m
                int r12 = androidx.constraintlayout.a.a.a.b.a.f2008b
                if (r11 == r12) goto L_0x0064
                int r11 = r2.m
                int r12 = androidx.constraintlayout.a.a.a.b.a.f2009c
                if (r11 != r12) goto L_0x00c3
            L_0x0064:
                int r11 = r10.getMeasuredHeight()
                int r12 = r19.o()
                if (r11 != r12) goto L_0x0070
                r11 = 1
                goto L_0x0071
            L_0x0070:
                r11 = 0
            L_0x0071:
                int r12 = r2.m
                int r13 = androidx.constraintlayout.a.a.a.b.a.f2009c
                if (r12 == r13) goto L_0x008a
                if (r9 == 0) goto L_0x008a
                if (r9 == 0) goto L_0x007d
                if (r11 != 0) goto L_0x008a
            L_0x007d:
                boolean r9 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r9 != 0) goto L_0x008a
                boolean r9 = r19.b()
                if (r9 == 0) goto L_0x0088
                goto L_0x008a
            L_0x0088:
                r9 = 0
                goto L_0x008b
            L_0x008a:
                r9 = 1
            L_0x008b:
                if (r9 == 0) goto L_0x00c3
                int r6 = r19.n()
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
                goto L_0x00c3
            L_0x0098:
                int r6 = r0.f2498f
                androidx.constraintlayout.a.a.d r11 = r1.J
                if (r11 == 0) goto L_0x00a5
                androidx.constraintlayout.a.a.d r11 = r1.J
                int r11 = r11.f2088g
                r12 = 0
                int r11 = r11 + r12
                goto L_0x00a6
            L_0x00a5:
                r11 = 0
            L_0x00a6:
                androidx.constraintlayout.a.a.d r12 = r1.L
                if (r12 == 0) goto L_0x00af
                androidx.constraintlayout.a.a.d r12 = r1.L
                int r12 = r12.f2088g
                int r11 = r11 + r12
            L_0x00af:
                int r9 = r9 + r11
                r11 = -1
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r11)
                goto L_0x00c3
            L_0x00b6:
                int r6 = r0.f2498f
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r15)
                goto L_0x00c3
            L_0x00bd:
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            L_0x00c3:
                int[] r9 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.f2482a
                int r11 = r4.ordinal()
                r9 = r9[r11]
                if (r9 == r5) goto L_0x014d
                if (r9 == r14) goto L_0x0145
                r7 = 3
                if (r9 == r7) goto L_0x0126
                r7 = 4
                if (r9 == r7) goto L_0x00d9
                r7 = 0
            L_0x00d6:
                r11 = 0
                goto L_0x0154
            L_0x00d9:
                int r7 = r0.f2499g
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r15)
                int r8 = r1.q
                if (r8 != r5) goto L_0x00e5
                r8 = 1
                goto L_0x00e6
            L_0x00e5:
                r8 = 0
            L_0x00e6:
                int r9 = r2.m
                int r11 = androidx.constraintlayout.a.a.a.b.a.f2008b
                if (r9 == r11) goto L_0x00f2
                int r9 = r2.m
                int r11 = androidx.constraintlayout.a.a.a.b.a.f2009c
                if (r9 != r11) goto L_0x00d6
            L_0x00f2:
                int r9 = r10.getMeasuredWidth()
                int r11 = r19.n()
                if (r9 != r11) goto L_0x00fe
                r9 = 1
                goto L_0x00ff
            L_0x00fe:
                r9 = 0
            L_0x00ff:
                int r11 = r2.m
                int r12 = androidx.constraintlayout.a.a.a.b.a.f2009c
                if (r11 == r12) goto L_0x0118
                if (r8 == 0) goto L_0x0118
                if (r8 == 0) goto L_0x010b
                if (r9 != 0) goto L_0x0118
            L_0x010b:
                boolean r8 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r8 != 0) goto L_0x0118
                boolean r8 = r19.c()
                if (r8 == 0) goto L_0x0116
                goto L_0x0118
            L_0x0116:
                r8 = 0
                goto L_0x0119
            L_0x0118:
                r8 = 1
            L_0x0119:
                if (r8 == 0) goto L_0x00d6
                int r7 = r19.o()
                r8 = 1073741824(0x40000000, float:2.0)
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r8)
                goto L_0x00d6
            L_0x0126:
                int r7 = r0.f2499g
                androidx.constraintlayout.a.a.d r9 = r1.J
                if (r9 == 0) goto L_0x0133
                androidx.constraintlayout.a.a.d r9 = r1.K
                int r9 = r9.f2088g
                r11 = 0
                int r9 = r9 + r11
                goto L_0x0135
            L_0x0133:
                r11 = 0
                r9 = 0
            L_0x0135:
                androidx.constraintlayout.a.a.d r12 = r1.L
                if (r12 == 0) goto L_0x013e
                androidx.constraintlayout.a.a.d r12 = r1.M
                int r12 = r12.f2088g
                int r9 = r9 + r12
            L_0x013e:
                int r8 = r8 + r9
                r9 = -1
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r9)
                goto L_0x0154
            L_0x0145:
                r11 = 0
                int r7 = r0.f2499g
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r15)
                goto L_0x0154
            L_0x014d:
                r8 = 1073741824(0x40000000, float:2.0)
                r11 = 0
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r8)
            L_0x0154:
                androidx.constraintlayout.a.a.e r8 = r1.V
                androidx.constraintlayout.a.a.f r8 = (androidx.constraintlayout.a.a.f) r8
                if (r8 == 0) goto L_0x01cc
                androidx.constraintlayout.widget.ConstraintLayout r9 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r9 = r9.mOptimizationLevel
                r12 = 256(0x100, float:3.59E-43)
                boolean r9 = androidx.constraintlayout.a.a.k.a(r9, r12)
                if (r9 == 0) goto L_0x01cc
                int r9 = r10.getMeasuredWidth()
                int r12 = r19.n()
                if (r9 != r12) goto L_0x01cc
                int r9 = r10.getMeasuredWidth()
                int r12 = r8.n()
                if (r9 >= r12) goto L_0x01cc
                int r9 = r10.getMeasuredHeight()
                int r12 = r19.o()
                if (r9 != r12) goto L_0x01cc
                int r9 = r10.getMeasuredHeight()
                int r8 = r8.o()
                if (r9 >= r8) goto L_0x01cc
                int r8 = r10.getBaseline()
                int r9 = r1.ag
                if (r8 != r9) goto L_0x01cc
                boolean r8 = r19.i()
                if (r8 != 0) goto L_0x01cc
                int r8 = r1.H
                int r9 = r19.n()
                boolean r8 = a(r8, r6, r9)
                if (r8 == 0) goto L_0x01b8
                int r8 = r1.I
                int r9 = r19.o()
                boolean r8 = a(r8, r7, r9)
                if (r8 == 0) goto L_0x01b8
                r8 = 1
                goto L_0x01b9
            L_0x01b8:
                r8 = 0
            L_0x01b9:
                if (r8 == 0) goto L_0x01cc
                int r3 = r19.n()
                r2.f2014h = r3
                int r3 = r19.o()
                r2.f2015i = r3
                int r1 = r1.ag
                r2.j = r1
                return
            L_0x01cc:
                androidx.constraintlayout.a.a.e$a r8 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
                if (r3 != r8) goto L_0x01d2
                r8 = 1
                goto L_0x01d3
            L_0x01d2:
                r8 = 0
            L_0x01d3:
                androidx.constraintlayout.a.a.e$a r9 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT
                if (r4 != r9) goto L_0x01d9
                r9 = 1
                goto L_0x01da
            L_0x01d9:
                r9 = 0
            L_0x01da:
                androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.MATCH_PARENT
                if (r4 == r12) goto L_0x01e5
                androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.FIXED
                if (r4 != r12) goto L_0x01e3
                goto L_0x01e5
            L_0x01e3:
                r4 = 0
                goto L_0x01e6
            L_0x01e5:
                r4 = 1
            L_0x01e6:
                androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.MATCH_PARENT
                if (r3 == r12) goto L_0x01f1
                androidx.constraintlayout.a.a.e$a r12 = androidx.constraintlayout.a.a.e.a.FIXED
                if (r3 != r12) goto L_0x01ef
                goto L_0x01f1
            L_0x01ef:
                r3 = 0
                goto L_0x01f2
            L_0x01f1:
                r3 = 1
            L_0x01f2:
                r12 = 0
                if (r8 == 0) goto L_0x01fd
                float r13 = r1.Y
                int r13 = (r13 > r12 ? 1 : (r13 == r12 ? 0 : -1))
                if (r13 <= 0) goto L_0x01fd
                r13 = 1
                goto L_0x01fe
            L_0x01fd:
                r13 = 0
            L_0x01fe:
                if (r9 == 0) goto L_0x0208
                float r14 = r1.Y
                int r12 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
                if (r12 <= 0) goto L_0x0208
                r12 = 1
                goto L_0x0209
            L_0x0208:
                r12 = 0
            L_0x0209:
                if (r10 != 0) goto L_0x020c
                return
            L_0x020c:
                android.view.ViewGroup$LayoutParams r14 = r10.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r14 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r14
                int r15 = r2.m
                int r11 = androidx.constraintlayout.a.a.a.b.a.f2008b
                if (r15 == r11) goto L_0x0231
                int r11 = r2.m
                int r15 = androidx.constraintlayout.a.a.a.b.a.f2009c
                if (r11 == r15) goto L_0x0231
                if (r8 == 0) goto L_0x0231
                int r8 = r1.p
                if (r8 != 0) goto L_0x0231
                if (r9 == 0) goto L_0x0231
                int r8 = r1.q
                if (r8 == 0) goto L_0x022b
                goto L_0x0231
            L_0x022b:
                r0 = 0
                r3 = 0
                r4 = -1
                r5 = 0
                goto L_0x02de
            L_0x0231:
                boolean r8 = r10 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r8 == 0) goto L_0x0243
                boolean r8 = r1 instanceof androidx.constraintlayout.a.a.l
                if (r8 == 0) goto L_0x0243
                r8 = r1
                androidx.constraintlayout.a.a.l r8 = (androidx.constraintlayout.a.a.l) r8
                r9 = r10
                androidx.constraintlayout.widget.VirtualLayout r9 = (androidx.constraintlayout.widget.VirtualLayout) r9
                r9.a(r8, r6, r7)
                goto L_0x0246
            L_0x0243:
                r10.measure(r6, r7)
            L_0x0246:
                r1.c(r6, r7)
                int r8 = r10.getMeasuredWidth()
                int r9 = r10.getMeasuredHeight()
                int r11 = r10.getBaseline()
                int r15 = r1.s
                if (r15 <= 0) goto L_0x0260
                int r15 = r1.s
                int r15 = java.lang.Math.max(r15, r8)
                goto L_0x0261
            L_0x0260:
                r15 = r8
            L_0x0261:
                int r5 = r1.t
                if (r5 <= 0) goto L_0x026b
                int r5 = r1.t
                int r15 = java.lang.Math.min(r5, r15)
            L_0x026b:
                int r5 = r1.v
                if (r5 <= 0) goto L_0x0278
                int r5 = r1.v
                int r5 = java.lang.Math.max(r5, r9)
                r16 = r6
                goto L_0x027b
            L_0x0278:
                r16 = r6
                r5 = r9
            L_0x027b:
                int r6 = r1.w
                if (r6 <= 0) goto L_0x0285
                int r6 = r1.w
                int r5 = java.lang.Math.min(r6, r5)
            L_0x0285:
                androidx.constraintlayout.widget.ConstraintLayout r6 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r6 = r6.mOptimizationLevel
                r0 = 1
                boolean r6 = androidx.constraintlayout.a.a.k.a(r6, r0)
                if (r6 != 0) goto L_0x02b0
                r0 = 1056964608(0x3f000000, float:0.5)
                if (r13 == 0) goto L_0x02a5
                if (r4 == 0) goto L_0x02a5
                float r3 = r1.Y
                float r4 = (float) r5
                float r4 = r4 * r3
                float r4 = r4 + r0
                int r0 = (int) r4
                r17 = r5
                r5 = r0
                r0 = r17
                goto L_0x02b2
            L_0x02a5:
                if (r12 == 0) goto L_0x02b0
                if (r3 == 0) goto L_0x02b0
                float r3 = r1.Y
                float r4 = (float) r15
                float r4 = r4 / r3
                float r4 = r4 + r0
                int r0 = (int) r4
                goto L_0x02b1
            L_0x02b0:
                r0 = r5
            L_0x02b1:
                r5 = r15
            L_0x02b2:
                if (r8 != r5) goto L_0x02ba
                if (r9 == r0) goto L_0x02b7
                goto L_0x02ba
            L_0x02b7:
                r3 = r11
            L_0x02b8:
                r4 = -1
                goto L_0x02de
            L_0x02ba:
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == r5) goto L_0x02c3
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r3)
                goto L_0x02c5
            L_0x02c3:
                r6 = r16
            L_0x02c5:
                if (r9 == r0) goto L_0x02cb
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            L_0x02cb:
                r10.measure(r6, r7)
                r1.c(r6, r7)
                int r5 = r10.getMeasuredWidth()
                int r0 = r10.getMeasuredHeight()
                int r3 = r10.getBaseline()
                goto L_0x02b8
            L_0x02de:
                if (r3 == r4) goto L_0x02e2
                r4 = 1
                goto L_0x02e3
            L_0x02e2:
                r4 = 0
            L_0x02e3:
                int r6 = r2.f2012f
                if (r5 != r6) goto L_0x02ee
                int r6 = r2.f2013g
                if (r0 == r6) goto L_0x02ec
                goto L_0x02ee
            L_0x02ec:
                r6 = 0
                goto L_0x02ef
            L_0x02ee:
                r6 = 1
            L_0x02ef:
                r2.l = r6
                boolean r6 = r14.Y
                if (r6 == 0) goto L_0x02f6
                r4 = 1
            L_0x02f6:
                if (r4 == 0) goto L_0x0302
                r6 = -1
                if (r3 == r6) goto L_0x0302
                int r1 = r1.ag
                if (r1 == r3) goto L_0x0302
                r1 = 1
                r2.l = r1
            L_0x0302:
                r2.f2014h = r5
                r2.f2015i = r0
                r2.k = r4
                r2.j = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.a(androidx.constraintlayout.a.a.e, androidx.constraintlayout.a.a.a.b$a):void");
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2482a = new int[e.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                androidx.constraintlayout.a.a.e$a[] r0 = androidx.constraintlayout.a.a.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2482a = r0
                int[] r0 = f2482a     // Catch:{ NoSuchFieldError -> 0x0014 }
                androidx.constraintlayout.a.a.e$a r1 = androidx.constraintlayout.a.a.e.a.FIXED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2482a     // Catch:{ NoSuchFieldError -> 0x001f }
                androidx.constraintlayout.a.a.e$a r1 = androidx.constraintlayout.a.a.e.a.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2482a     // Catch:{ NoSuchFieldError -> 0x002a }
                androidx.constraintlayout.a.a.e$a r1 = androidx.constraintlayout.a.a.e.a.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f2482a     // Catch:{ NoSuchFieldError -> 0x0035 }
                androidx.constraintlayout.a.a.e$a r1 = androidx.constraintlayout.a.a.e.a.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.<clinit>():void");
        }
    }

    private void init(AttributeSet attributeSet, int i2, int i3) {
        f fVar = this.mLayoutWidget;
        fVar.am = this;
        fVar.a((b.C0030b) this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.mConstraintSet = new c();
                        this.mConstraintSet.b(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.o(this.mOptimizationLevel);
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i2) {
        this.mConstraintLayoutSpec = new b(getContext(), this, i2);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        androidx.constraintlayout.a.a.e viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof h)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.an = new h();
            layoutParams.Z = true;
            ((h) layoutParams.an).o(layoutParams.S);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.b();
            ((LayoutParams) view.getLayoutParams()).aa = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.b(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void setMinWidth(int i2) {
        if (i2 != this.mMinWidth) {
            this.mMinWidth = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.mMinHeight) {
            this.mMinHeight = i2;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.mMaxWidth) {
            this.mMaxWidth = i2;
            requestLayout();
        }
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.mMaxHeight) {
            this.mMaxHeight = i2;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            androidx.constraintlayout.a.a.e viewWidget = getViewWidget(getChildAt(i2));
            if (viewWidget != null) {
                viewWidget.j();
            }
        }
        if (isInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).ao = resourceName;
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        c cVar = this.mConstraintSet;
        if (cVar != null) {
            cVar.e(this);
        }
        this.mLayoutWidget.bh.clear();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.mConstraintHelpers.get(i5).b(this);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt3 = getChildAt(i6);
            if (childAt3 instanceof Placeholder) {
                Placeholder placeholder = (Placeholder) childAt3;
                if (placeholder.f2502a == -1 && !placeholder.isInEditMode()) {
                    placeholder.setVisibility(placeholder.f2504c);
                }
                placeholder.f2503b = findViewById(placeholder.f2502a);
                if (placeholder.f2503b != null) {
                    ((LayoutParams) placeholder.f2503b.getLayoutParams()).ab = true;
                    placeholder.f2503b.setVisibility(0);
                    placeholder.setVisibility(0);
                }
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt4 = getChildAt(i7);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt5 = getChildAt(i8);
            androidx.constraintlayout.a.a.e viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, (LayoutParams) childAt5.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    public void applyConstraintsFromLayoutParams(boolean z, View view, androidx.constraintlayout.a.a.e eVar, LayoutParams layoutParams, SparseArray<androidx.constraintlayout.a.a.e> sparseArray) {
        int i2;
        int i3;
        int i4;
        float f2;
        androidx.constraintlayout.a.a.e eVar2;
        androidx.constraintlayout.a.a.e eVar3;
        androidx.constraintlayout.a.a.e eVar4;
        androidx.constraintlayout.a.a.e eVar5;
        View view2 = view;
        androidx.constraintlayout.a.a.e eVar6 = eVar;
        LayoutParams layoutParams2 = layoutParams;
        SparseArray<androidx.constraintlayout.a.a.e> sparseArray2 = sparseArray;
        layoutParams.a();
        int i5 = 0;
        layoutParams2.ao = false;
        eVar6.an = view.getVisibility();
        if (layoutParams2.ab) {
            eVar6.F = true;
            eVar6.an = 8;
        }
        eVar6.am = view2;
        if (view2 instanceof ConstraintHelper) {
            ((ConstraintHelper) view2).a(eVar6, this.mLayoutWidget.f2106d);
        }
        if (layoutParams2.Z) {
            h hVar = (h) eVar6;
            int i6 = layoutParams2.ak;
            int i7 = layoutParams2.al;
            float f3 = layoutParams2.am;
            if (Build.VERSION.SDK_INT < 17) {
                i6 = layoutParams2.f2483a;
                i7 = layoutParams2.f2484b;
                f3 = layoutParams2.f2485c;
            }
            if (f3 != -1.0f) {
                hVar.a(f3);
            } else if (i6 != -1) {
                hVar.p(i6);
            } else if (i7 != -1) {
                hVar.q(i7);
            }
        } else {
            int i8 = layoutParams2.ad;
            int i9 = layoutParams2.ae;
            int i10 = layoutParams2.af;
            int i11 = layoutParams2.ag;
            int i12 = layoutParams2.ah;
            int i13 = layoutParams2.ai;
            float f4 = layoutParams2.aj;
            if (Build.VERSION.SDK_INT < 17) {
                i8 = layoutParams2.f2486d;
                i4 = layoutParams2.f2487e;
                int i14 = layoutParams2.f2488f;
                i11 = layoutParams2.f2489g;
                int i15 = layoutParams2.t;
                int i16 = layoutParams2.v;
                f4 = layoutParams2.z;
                if (i8 == -1 && i4 == -1) {
                    if (layoutParams2.q != -1) {
                        i8 = layoutParams2.q;
                    } else if (layoutParams2.p != -1) {
                        i4 = layoutParams2.p;
                    }
                }
                if (i14 == -1 && i11 == -1) {
                    if (layoutParams2.r != -1) {
                        i14 = layoutParams2.r;
                    } else if (layoutParams2.s != -1) {
                        i11 = layoutParams2.s;
                    }
                }
                i3 = i14;
                i2 = i16;
                i12 = i15;
            } else {
                i4 = i9;
                i2 = i13;
                i3 = i10;
            }
            float f5 = f4;
            int i17 = i11;
            float f6 = f5;
            if (layoutParams2.m != -1) {
                androidx.constraintlayout.a.a.e eVar7 = sparseArray2.get(layoutParams2.m);
                if (eVar7 != null) {
                    float f7 = layoutParams2.o;
                    androidx.constraintlayout.a.a.e eVar8 = eVar;
                    eVar8.a(d.a.CENTER, eVar7, d.a.CENTER, layoutParams2.n, 0);
                    eVar6.D = f7;
                }
            } else {
                if (i8 != -1) {
                    androidx.constraintlayout.a.a.e eVar9 = sparseArray2.get(i8);
                    if (eVar9 != null) {
                        f2 = f6;
                        eVar.a(d.a.LEFT, eVar9, d.a.LEFT, layoutParams2.leftMargin, i12);
                    } else {
                        f2 = f6;
                    }
                } else {
                    f2 = f6;
                    if (!(i4 == -1 || (eVar5 = sparseArray2.get(i4)) == null)) {
                        eVar.a(d.a.LEFT, eVar5, d.a.RIGHT, layoutParams2.leftMargin, i12);
                    }
                }
                if (i3 != -1) {
                    androidx.constraintlayout.a.a.e eVar10 = sparseArray2.get(i3);
                    if (eVar10 != null) {
                        eVar.a(d.a.RIGHT, eVar10, d.a.LEFT, layoutParams2.rightMargin, i2);
                    }
                } else if (!(i17 == -1 || (eVar4 = sparseArray2.get(i17)) == null)) {
                    eVar.a(d.a.RIGHT, eVar4, d.a.RIGHT, layoutParams2.rightMargin, i2);
                }
                if (layoutParams2.f2490h != -1) {
                    androidx.constraintlayout.a.a.e eVar11 = sparseArray2.get(layoutParams2.f2490h);
                    if (eVar11 != null) {
                        eVar.a(d.a.TOP, eVar11, d.a.TOP, layoutParams2.topMargin, layoutParams2.u);
                    }
                } else if (!(layoutParams2.f2491i == -1 || (eVar3 = sparseArray2.get(layoutParams2.f2491i)) == null)) {
                    eVar.a(d.a.TOP, eVar3, d.a.BOTTOM, layoutParams2.topMargin, layoutParams2.u);
                }
                if (layoutParams2.j != -1) {
                    androidx.constraintlayout.a.a.e eVar12 = sparseArray2.get(layoutParams2.j);
                    if (eVar12 != null) {
                        eVar.a(d.a.BOTTOM, eVar12, d.a.TOP, layoutParams2.bottomMargin, layoutParams2.w);
                    }
                } else if (!(layoutParams2.k == -1 || (eVar2 = sparseArray2.get(layoutParams2.k)) == null)) {
                    eVar.a(d.a.BOTTOM, eVar2, d.a.BOTTOM, layoutParams2.bottomMargin, layoutParams2.w);
                }
                if (layoutParams2.l != -1) {
                    View view3 = this.mChildrenByIds.get(layoutParams2.l);
                    androidx.constraintlayout.a.a.e eVar13 = sparseArray2.get(layoutParams2.l);
                    if (!(eVar13 == null || view3 == null || !(view3.getLayoutParams() instanceof LayoutParams))) {
                        LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                        layoutParams2.Y = true;
                        layoutParams3.Y = true;
                        eVar6.a(d.a.BASELINE).a(eVar13.a(d.a.BASELINE), 0, -1, true);
                        eVar6.E = true;
                        layoutParams3.an.E = true;
                        eVar6.a(d.a.TOP).f();
                        eVar6.a(d.a.BOTTOM).f();
                    }
                }
                float f8 = f2;
                if (f8 >= 0.0f) {
                    eVar6.ak = f8;
                }
                if (layoutParams2.A >= 0.0f) {
                    eVar6.al = layoutParams2.A;
                }
            }
            if (z && !(layoutParams2.Q == -1 && layoutParams2.R == -1)) {
                eVar6.d(layoutParams2.Q, layoutParams2.R);
            }
            if (layoutParams2.W) {
                eVar6.U[0] = e.a.FIXED;
                eVar6.g(layoutParams2.width);
                if (layoutParams2.width == -2) {
                    eVar6.U[0] = e.a.WRAP_CONTENT;
                }
            } else if (layoutParams2.width == -1) {
                if (layoutParams2.T) {
                    eVar6.U[0] = e.a.MATCH_CONSTRAINT;
                } else {
                    eVar6.U[0] = e.a.MATCH_PARENT;
                }
                eVar6.a(d.a.LEFT).f2088g = layoutParams2.leftMargin;
                eVar6.a(d.a.RIGHT).f2088g = layoutParams2.rightMargin;
            } else {
                eVar6.U[0] = e.a.MATCH_CONSTRAINT;
                eVar6.g(0);
            }
            if (layoutParams2.X) {
                eVar6.U[1] = e.a.FIXED;
                eVar6.h(layoutParams2.height);
                if (layoutParams2.height == -2) {
                    eVar6.U[1] = e.a.WRAP_CONTENT;
                }
            } else if (layoutParams2.height == -1) {
                if (layoutParams2.U) {
                    eVar6.U[1] = e.a.MATCH_CONSTRAINT;
                } else {
                    eVar6.U[1] = e.a.MATCH_PARENT;
                }
                eVar6.a(d.a.TOP).f2088g = layoutParams2.topMargin;
                eVar6.a(d.a.BOTTOM).f2088g = layoutParams2.bottomMargin;
            } else {
                eVar6.U[1] = e.a.MATCH_CONSTRAINT;
                eVar6.h(0);
            }
            eVar6.a(layoutParams2.B);
            eVar6.aE[0] = layoutParams2.E;
            eVar6.aE[1] = layoutParams2.F;
            eVar6.aA = layoutParams2.G;
            eVar6.aB = layoutParams2.H;
            int i18 = layoutParams2.I;
            int i19 = layoutParams2.K;
            int i20 = layoutParams2.M;
            float f9 = layoutParams2.O;
            eVar6.p = i18;
            eVar6.s = i19;
            if (i20 == Integer.MAX_VALUE) {
                i20 = 0;
            }
            eVar6.t = i20;
            eVar6.u = f9;
            if (f9 > 0.0f && f9 < 1.0f && eVar6.p == 0) {
                eVar6.p = 2;
            }
            int i21 = layoutParams2.J;
            int i22 = layoutParams2.L;
            int i23 = layoutParams2.N;
            float f10 = layoutParams2.P;
            eVar6.q = i21;
            eVar6.v = i22;
            if (i23 != Integer.MAX_VALUE) {
                i5 = i23;
            }
            eVar6.w = i5;
            eVar6.x = f10;
            if (f10 > 0.0f && f10 < 1.0f && eVar6.q == 0) {
                eVar6.q = 2;
            }
        }
    }

    private final androidx.constraintlayout.a.a.e getTargetWidget(int i2) {
        if (i2 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).an;
    }

    public final androidx.constraintlayout.a.a.e getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).an;
    }

    public void fillMetrics(androidx.constraintlayout.a.e eVar) {
        this.mMetrics = eVar;
        this.mLayoutWidget.aL = eVar;
        androidx.constraintlayout.a.d.a(eVar);
    }

    public void resolveSystem(f fVar, int i2, int i3, int i4) {
        int i5;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i6 = max + max2;
        int paddingWidth = getPaddingWidth();
        a aVar = this.mMeasurer;
        aVar.f2494b = max;
        aVar.f2495c = max2;
        aVar.f2496d = paddingWidth;
        aVar.f2497e = i6;
        aVar.f2498f = i3;
        aVar.f2499g = i4;
        if (Build.VERSION.SDK_INT >= 17) {
            i5 = Math.max(0, getPaddingStart());
            int max3 = Math.max(0, getPaddingEnd());
            if (i5 <= 0 && max3 <= 0) {
                i5 = Math.max(0, getPaddingLeft());
            } else if (isRtl()) {
                i5 = max3;
            }
        } else {
            i5 = Math.max(0, getPaddingLeft());
        }
        int i7 = size2 - i6;
        int i8 = mode;
        int i9 = size - paddingWidth;
        int i10 = mode2;
        int i11 = i7;
        setSelfDimensionBehaviour(fVar, i8, i9, i10, i11);
        fVar.a(i2, i8, i9, i10, i11, i5, max);
    }

    public void resolveMeasuredDimension(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        int i6 = this.mMeasurer.f2497e;
        int i7 = i4 + this.mMeasurer.f2496d;
        int i8 = i5 + i6;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolveSizeAndState = resolveSizeAndState(i7, i2, 0);
            int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
            int min2 = Math.min(this.mMaxHeight, resolveSizeAndState(i8, i3, 0) & 16777215);
            if (z) {
                min |= 16777216;
            }
            if (z2) {
                min2 |= 16777216;
            }
            setMeasuredDimension(min, min2);
            this.mLastMeasureWidth = min;
            this.mLastMeasureHeight = min2;
            return;
        }
        setMeasuredDimension(i7, i8);
        this.mLastMeasureWidth = i7;
        this.mLastMeasureHeight = i8;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                } else if (getChildAt(i4).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (!this.mDirtyHierarchy) {
            if (this.mOnMeasureWidthMeasureSpec == i2 && this.mOnMeasureHeightMeasureSpec == i3) {
                resolveMeasuredDimension(i2, i3, this.mLayoutWidget.n(), this.mLayoutWidget.o(), this.mLayoutWidget.bc, this.mLayoutWidget.bd);
                return;
            } else if (this.mOnMeasureWidthMeasureSpec == i2 && View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i3) >= this.mLayoutWidget.o()) {
                this.mOnMeasureWidthMeasureSpec = i2;
                this.mOnMeasureHeightMeasureSpec = i3;
                resolveMeasuredDimension(i2, i3, this.mLayoutWidget.n(), this.mLayoutWidget.o(), this.mLayoutWidget.bc, this.mLayoutWidget.bd);
                return;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i2;
        this.mOnMeasureHeightMeasureSpec = i3;
        this.mLayoutWidget.f2106d = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.e();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i2, i3);
        resolveMeasuredDimension(i2, i3, this.mLayoutWidget.n(), this.mLayoutWidget.o(), this.mLayoutWidget.bc, this.mLayoutWidget.bd);
    }

    public boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) {
            if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
                return false;
            }
            return true;
        }
        return false;
    }

    private int getPaddingWidth() {
        int i2 = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i2 > 0 ? i2 : max;
    }

    /* access modifiers changed from: protected */
    public void setSelfDimensionBehaviour(f fVar, int i2, int i3, int i4, int i5) {
        int i6 = this.mMeasurer.f2497e;
        int i7 = this.mMeasurer.f2496d;
        e.a aVar = e.a.FIXED;
        e.a aVar2 = e.a.FIXED;
        int childCount = getChildCount();
        if (i2 != Integer.MIN_VALUE) {
            if (i2 == 0) {
                aVar = e.a.WRAP_CONTENT;
                if (childCount == 0) {
                    i3 = Math.max(0, this.mMinWidth);
                }
            } else if (i2 == 1073741824) {
                i3 = Math.min(this.mMaxWidth - i7, i3);
            }
            i3 = 0;
        } else {
            aVar = e.a.WRAP_CONTENT;
            if (childCount == 0) {
                i3 = Math.max(0, this.mMinWidth);
            }
        }
        if (i4 != Integer.MIN_VALUE) {
            if (i4 == 0) {
                aVar2 = e.a.WRAP_CONTENT;
                if (childCount == 0) {
                    i5 = Math.max(0, this.mMinHeight);
                }
            } else if (i4 == 1073741824) {
                i5 = Math.min(this.mMaxHeight - i6, i5);
            }
            i5 = 0;
        } else {
            aVar2 = e.a.WRAP_CONTENT;
            if (childCount == 0) {
                i5 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i3 == fVar.n() && i5 == fVar.o())) {
            fVar.f2104b.f2020c = true;
        }
        fVar.e(0);
        fVar.f(0);
        fVar.C[0] = this.mMaxWidth - i7;
        fVar.C[1] = this.mMaxHeight - i6;
        fVar.i(0);
        fVar.j(0);
        fVar.U[0] = aVar;
        fVar.g(i3);
        fVar.U[1] = aVar2;
        fVar.h(i5);
        fVar.i(this.mMinWidth - i7);
        fVar.j(this.mMinHeight - i6);
    }

    public void setState(int i2, int i3, int i4) {
        b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.a(i2, (float) i3, (float) i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            androidx.constraintlayout.a.a.e eVar = layoutParams.an;
            if ((childAt.getVisibility() != 8 || layoutParams.Z || layoutParams.aa || layoutParams.ac || isInEditMode) && !layoutParams.ab) {
                int l = eVar.l();
                int m = eVar.m();
                int n = eVar.n() + l;
                int o = eVar.o() + m;
                childAt.layout(l, m, n, o);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(l, m, n, o);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.mConstraintHelpers.get(i7).a();
            }
        }
    }

    public void setOptimizationLevel(int i2) {
        this.mOptimizationLevel = i2;
        this.mLayoutWidget.o(i2);
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.ba;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void setConstraintSet(c cVar) {
        this.mConstraintSet = cVar;
    }

    public View getViewById(int i2) {
        return this.mChildrenByIds.get(i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.mConstraintHelpers.get(i2).a(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(AppConstants.COMMA);
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i4 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i5 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i4;
                        float f3 = (float) i5;
                        float f4 = (float) (i4 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f5 = f3;
                        float f6 = f3;
                        float f7 = f4;
                        float f8 = f2;
                        Paint paint2 = paint;
                        canvas2.drawLine(f2, f5, f7, f6, paint);
                        float parseInt4 = (float) (i5 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f9 = f4;
                        float f10 = parseInt4;
                        canvas2.drawLine(f9, f6, f7, f10, paint);
                        float f11 = parseInt4;
                        float f12 = f8;
                        canvas2.drawLine(f9, f11, f12, f10, paint);
                        float f13 = f8;
                        canvas2.drawLine(f13, f11, f12, f6, paint);
                        paint.setColor(-16711936);
                        float f14 = f4;
                        Paint paint3 = paint;
                        canvas2.drawLine(f13, f6, f14, parseInt4, paint);
                        canvas2.drawLine(f13, parseInt4, f14, f6, paint);
                    }
                }
            }
        }
    }

    public void setOnConstraintsChanged(d dVar) {
        this.mConstraintsChangedListener = dVar;
        b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.f2518d = dVar;
        }
    }

    public void loadLayoutDescription(int i2) {
        if (i2 != 0) {
            try {
                this.mConstraintLayoutSpec = new b(getContext(), this, i2);
                return;
            } catch (Resources.NotFoundException unused) {
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        float C = 0.0f;
        int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        public String V = null;
        boolean W = true;
        boolean X = true;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f2483a = -1;
        boolean aa = false;
        boolean ab = false;
        boolean ac = false;
        int ad = -1;
        int ae = -1;
        int af = -1;
        int ag = -1;
        int ah = -1;
        int ai = -1;
        float aj = 0.5f;
        int ak;
        int al;
        float am;
        public androidx.constraintlayout.a.a.e an = new androidx.constraintlayout.a.a.e();
        public boolean ao = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2484b = -1;

        /* renamed from: c  reason: collision with root package name */
        public float f2485c = -1.0f;

        /* renamed from: d  reason: collision with root package name */
        public int f2486d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f2487e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2488f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2489g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f2490h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f2491i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = 0;
        public float o = 0.0f;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f2483a = layoutParams.f2483a;
            this.f2484b = layoutParams.f2484b;
            this.f2485c = layoutParams.f2485c;
            this.f2486d = layoutParams.f2486d;
            this.f2487e = layoutParams.f2487e;
            this.f2488f = layoutParams.f2488f;
            this.f2489g = layoutParams.f2489g;
            this.f2490h = layoutParams.f2490h;
            this.f2491i = layoutParams.f2491i;
            this.j = layoutParams.j;
            this.k = layoutParams.k;
            this.l = layoutParams.l;
            this.m = layoutParams.m;
            this.n = layoutParams.n;
            this.o = layoutParams.o;
            this.p = layoutParams.p;
            this.q = layoutParams.q;
            this.r = layoutParams.r;
            this.s = layoutParams.s;
            this.t = layoutParams.t;
            this.u = layoutParams.u;
            this.v = layoutParams.v;
            this.w = layoutParams.w;
            this.x = layoutParams.x;
            this.y = layoutParams.y;
            this.z = layoutParams.z;
            this.A = layoutParams.A;
            this.B = layoutParams.B;
            this.C = layoutParams.C;
            this.D = layoutParams.D;
            this.E = layoutParams.E;
            this.F = layoutParams.F;
            this.G = layoutParams.G;
            this.H = layoutParams.H;
            this.T = layoutParams.T;
            this.U = layoutParams.U;
            this.I = layoutParams.I;
            this.J = layoutParams.J;
            this.K = layoutParams.K;
            this.M = layoutParams.M;
            this.L = layoutParams.L;
            this.N = layoutParams.N;
            this.O = layoutParams.O;
            this.P = layoutParams.P;
            this.Q = layoutParams.Q;
            this.R = layoutParams.R;
            this.S = layoutParams.S;
            this.W = layoutParams.W;
            this.X = layoutParams.X;
            this.Y = layoutParams.Y;
            this.Z = layoutParams.Z;
            this.ad = layoutParams.ad;
            this.ae = layoutParams.ae;
            this.af = layoutParams.af;
            this.ag = layoutParams.ag;
            this.ah = layoutParams.ah;
            this.ai = layoutParams.ai;
            this.aj = layoutParams.aj;
            this.V = layoutParams.V;
            this.an = layoutParams.an;
        }

        static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f2492a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2492a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f2492a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                f2492a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = a.f2492a.get(index);
                switch (i4) {
                    case 0:
                        break;
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m != -1) {
                            break;
                        } else {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f2 = this.o;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f2483a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2483a);
                        break;
                    case 6:
                        this.f2484b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2484b);
                        break;
                    case 7:
                        this.f2485c = obtainStyledAttributes.getFloat(index, this.f2485c);
                        break;
                    case 8:
                        this.f2486d = obtainStyledAttributes.getResourceId(index, this.f2486d);
                        if (this.f2486d != -1) {
                            break;
                        } else {
                            this.f2486d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        this.f2487e = obtainStyledAttributes.getResourceId(index, this.f2487e);
                        if (this.f2487e != -1) {
                            break;
                        } else {
                            this.f2487e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        this.f2488f = obtainStyledAttributes.getResourceId(index, this.f2488f);
                        if (this.f2488f != -1) {
                            break;
                        } else {
                            this.f2488f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        this.f2489g = obtainStyledAttributes.getResourceId(index, this.f2489g);
                        if (this.f2489g != -1) {
                            break;
                        } else {
                            this.f2489g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        this.f2490h = obtainStyledAttributes.getResourceId(index, this.f2490h);
                        if (this.f2490h != -1) {
                            break;
                        } else {
                            this.f2490h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        this.f2491i = obtainStyledAttributes.getResourceId(index, this.f2491i);
                        if (this.f2491i != -1) {
                            break;
                        } else {
                            this.f2491i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        this.j = obtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j != -1) {
                            break;
                        } else {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        this.k = obtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k != -1) {
                            break;
                        } else {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        this.l = obtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l != -1) {
                            break;
                        } else {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p != -1) {
                            break;
                        } else {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q != -1) {
                            break;
                        } else {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r != -1) {
                            break;
                        } else {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s != -1) {
                            break;
                        } else {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        int i5 = this.I;
                        break;
                    case 32:
                        this.J = obtainStyledAttributes.getInt(index, 0);
                        int i6 = this.J;
                        break;
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) != -2) {
                                break;
                            } else {
                                this.K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) != -2) {
                                break;
                            } else {
                                this.M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) != -2) {
                                break;
                            } else {
                                this.L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) != -2) {
                                break;
                            } else {
                                this.N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        this.J = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                this.B = obtainStyledAttributes.getString(index);
                                this.C = Float.NaN;
                                this.D = -1;
                                String str = this.B;
                                if (str == null) {
                                    break;
                                } else {
                                    int length = str.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase(AppConstants.CAROUSEL_SUB_TYPE)) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i2, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.D != 1) {
                                                        this.C = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    } else {
                                                        this.C = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i2);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            this.C = Float.parseFloat(substring4);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                            case 51:
                                this.V = obtainStyledAttributes.getString(index);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public final void a() {
            this.Z = false;
            this.W = true;
            this.X = true;
            if (this.width == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            if (this.height == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.W = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.X = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.f2485c != -1.0f || this.f2483a != -1 || this.f2484b != -1) {
                this.Z = true;
                this.W = true;
                this.X = true;
                if (!(this.an instanceof h)) {
                    this.an = new h();
                }
                ((h) this.an).o(this.S);
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0082  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 0
                r4 = 1
                r5 = 17
                if (r2 < r5) goto L_0x0017
                super.resolveLayoutDirection(r7)
                int r7 = r6.getLayoutDirection()
                if (r4 != r7) goto L_0x0017
                r7 = 1
                goto L_0x0018
            L_0x0017:
                r7 = 0
            L_0x0018:
                r2 = -1
                r6.af = r2
                r6.ag = r2
                r6.ad = r2
                r6.ae = r2
                r6.ah = r2
                r6.ai = r2
                int r5 = r6.t
                r6.ah = r5
                int r5 = r6.v
                r6.ai = r5
                float r5 = r6.z
                r6.aj = r5
                int r5 = r6.f2483a
                r6.ak = r5
                int r5 = r6.f2484b
                r6.al = r5
                float r5 = r6.f2485c
                r6.am = r5
                if (r7 == 0) goto L_0x00a0
                int r7 = r6.p
                if (r7 == r2) goto L_0x0047
                r6.af = r7
            L_0x0045:
                r3 = 1
                goto L_0x004e
            L_0x0047:
                int r7 = r6.q
                if (r7 == r2) goto L_0x004e
                r6.ag = r7
                goto L_0x0045
            L_0x004e:
                int r7 = r6.r
                if (r7 == r2) goto L_0x0055
                r6.ae = r7
                r3 = 1
            L_0x0055:
                int r7 = r6.s
                if (r7 == r2) goto L_0x005c
                r6.ad = r7
                r3 = 1
            L_0x005c:
                int r7 = r6.x
                if (r7 == r2) goto L_0x0062
                r6.ai = r7
            L_0x0062:
                int r7 = r6.y
                if (r7 == r2) goto L_0x0068
                r6.ah = r7
            L_0x0068:
                r7 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0072
                float r3 = r6.z
                float r3 = r7 - r3
                r6.aj = r3
            L_0x0072:
                boolean r3 = r6.Z
                if (r3 == 0) goto L_0x00c4
                int r3 = r6.S
                if (r3 != r4) goto L_0x00c4
                float r3 = r6.f2485c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x008a
                float r7 = r7 - r3
                r6.am = r7
                r6.ak = r2
                r6.al = r2
                goto L_0x00c4
            L_0x008a:
                int r7 = r6.f2483a
                if (r7 == r2) goto L_0x0095
                r6.al = r7
                r6.ak = r2
                r6.am = r4
                goto L_0x00c4
            L_0x0095:
                int r7 = r6.f2484b
                if (r7 == r2) goto L_0x00c4
                r6.ak = r7
                r6.al = r2
                r6.am = r4
                goto L_0x00c4
            L_0x00a0:
                int r7 = r6.p
                if (r7 == r2) goto L_0x00a6
                r6.ae = r7
            L_0x00a6:
                int r7 = r6.q
                if (r7 == r2) goto L_0x00ac
                r6.ad = r7
            L_0x00ac:
                int r7 = r6.r
                if (r7 == r2) goto L_0x00b2
                r6.af = r7
            L_0x00b2:
                int r7 = r6.s
                if (r7 == r2) goto L_0x00b8
                r6.ag = r7
            L_0x00b8:
                int r7 = r6.x
                if (r7 == r2) goto L_0x00be
                r6.ah = r7
            L_0x00be:
                int r7 = r6.y
                if (r7 == r2) goto L_0x00c4
                r6.ai = r7
            L_0x00c4:
                int r7 = r6.r
                if (r7 != r2) goto L_0x010e
                int r7 = r6.s
                if (r7 != r2) goto L_0x010e
                int r7 = r6.q
                if (r7 != r2) goto L_0x010e
                int r7 = r6.p
                if (r7 != r2) goto L_0x010e
                int r7 = r6.f2488f
                if (r7 == r2) goto L_0x00e3
                r6.af = r7
                int r7 = r6.rightMargin
                if (r7 > 0) goto L_0x00f1
                if (r1 <= 0) goto L_0x00f1
                r6.rightMargin = r1
                goto L_0x00f1
            L_0x00e3:
                int r7 = r6.f2489g
                if (r7 == r2) goto L_0x00f1
                r6.ag = r7
                int r7 = r6.rightMargin
                if (r7 > 0) goto L_0x00f1
                if (r1 <= 0) goto L_0x00f1
                r6.rightMargin = r1
            L_0x00f1:
                int r7 = r6.f2486d
                if (r7 == r2) goto L_0x0100
                r6.ad = r7
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x010e
                if (r0 <= 0) goto L_0x010e
                r6.leftMargin = r0
                return
            L_0x0100:
                int r7 = r6.f2487e
                if (r7 == r2) goto L_0x010e
                r6.ae = r7
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x010e
                if (r0 <= 0) goto L_0x010e
                r6.leftMargin = r0
            L_0x010e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }
}
