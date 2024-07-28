package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.g.e;
import androidx.core.h.ab;
import androidx.core.h.n;
import androidx.core.h.o;
import androidx.core.h.p;
import androidx.core.h.q;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements n, o {

    /* renamed from: a  reason: collision with root package name */
    static final String f2591a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f2592b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f2593c = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<View> f2594d;

    /* renamed from: h  reason: collision with root package name */
    private static final e.a<Rect> f2595h = new e.c(12);

    /* renamed from: e  reason: collision with root package name */
    ab f2596e;

    /* renamed from: f  reason: collision with root package name */
    boolean f2597f;

    /* renamed from: g  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f2598g;

    /* renamed from: i  reason: collision with root package name */
    private final List<View> f2599i;
    private final a<View> j;
    private final List<View> k;
    private final List<View> l;
    private Paint m;
    private final int[] n;
    private final int[] o;
    private boolean p;
    private boolean q;
    private int[] r;
    private View s;
    private View t;
    private e u;
    private boolean v;
    private Drawable w;
    private q x;
    private final p y;

    public interface a {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> a();
    }

    private static int c(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int d(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private static int e(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            f2591a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$f
            r0.<init>()
            f2594d = r0
            goto L_0x0021
        L_0x001f:
            f2594d = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f2592b = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f2593c = r0
            androidx.core.g.e$c r0 = new androidx.core.g.e$c
            r1 = 12
            r0.<init>(r1)
            f2595h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    private static Rect a() {
        Rect a2 = f2595h.a();
        return a2 == null ? new Rect() : a2;
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f2595h.a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        this.f2599i = new ArrayList();
        this.j = new a<>();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.n = new int[2];
        this.o = new int[2];
        this.y = new p();
        if (i2 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i2, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArray, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArray, i2, 0);
            }
        }
        int resourceId = typedArray.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.r = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.r.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.r;
                iArr[i3] = (int) (((float) iArr[i3]) * f2);
            }
        }
        this.w = typedArray.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArray.recycle();
        c();
        super.setOnHierarchyChangeListener(new c());
        if (u.h(this) == 0) {
            u.c((View) this, 1);
        }
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2598g = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.v) {
            if (this.u == null) {
                this.u = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.u);
        }
        if (this.f2596e == null && u.A(this)) {
            u.z(this);
        }
        this.q = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.v && this.u != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.u);
        }
        View view = this.t;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.q = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.w;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.w = drawable3;
            Drawable drawable4 = this.w;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.w.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.w, u.j(this));
                this.w.setVisible(getVisibility() == 0, false);
                this.w.setCallback(this);
            }
            u.g(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.w;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.w;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.w;
        if (drawable != null && drawable.isVisible() != z) {
            this.w.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? androidx.core.content.b.a(getContext(), i2) : null);
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public final ab getLastWindowInsets() {
        return this.f2596e;
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Behavior behavior = ((d) childAt.getLayoutParams()).f2603a;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((d) getChildAt(i3).getLayoutParams()).m = false;
        }
        this.s = null;
        this.p = false;
    }

    private boolean a(MotionEvent motionEvent, int i2) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.k;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i4) : i4));
        }
        Comparator<View> comparator = f2594d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z3 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view = list.get(i5);
            d dVar = (d) view.getLayoutParams();
            Behavior behavior = dVar.f2603a;
            boolean z5 = true;
            if ((!z3 && !z4) || actionMasked == 0) {
                if (!z3 && behavior != null) {
                    if (i3 == 0) {
                        z3 = behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i3 == 1) {
                        z3 = behavior.onTouchEvent(this, view, motionEvent2);
                    }
                    if (z3) {
                        this.s = view;
                    }
                }
                if (dVar.f2603a == null) {
                    dVar.m = false;
                }
                boolean z6 = dVar.m;
                if (dVar.m) {
                    z = true;
                } else {
                    boolean z7 = dVar.m;
                    if (dVar.f2603a != null) {
                        z2 = dVar.f2603a.blocksInteractionBelow(this, view);
                    } else {
                        z2 = false;
                    }
                    z = z2 | z7;
                    dVar.m = z;
                }
                if (!z || z6) {
                    z5 = false;
                }
                if (z && !z5) {
                    break;
                }
                z4 = z5;
            } else if (behavior != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    behavior.onInterceptTouchEvent(this, view, motionEvent3);
                } else if (i3 == 1) {
                    behavior.onTouchEvent(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z3;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.s
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.a((android.view.MotionEvent) r1, (int) r4)
            if (r3 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.s
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f2603a
            if (r6 == 0) goto L_0x0029
            android.view.View r7 = r0.s
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            android.view.View r7 = r0.s
            r8 = 0
            if (r7 != 0) goto L_0x0035
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x0048
        L_0x0035:
            if (r3 == 0) goto L_0x0048
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x0048:
            if (r8 == 0) goto L_0x004d
            r8.recycle()
        L_0x004d:
            if (r2 == r4) goto L_0x0052
            r1 = 3
            if (r2 != r1) goto L_0x0055
        L_0x0052:
            r0.a((boolean) r5)
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.p) {
            a(false);
            this.p = true;
        }
    }

    private int b(int i2) {
        int[] iArr = this.r;
        if (iArr == null) {
            StringBuilder sb = new StringBuilder("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            StringBuilder sb2 = new StringBuilder("Keyline index ");
            sb2.append(i2);
            sb2.append(" out of range for ");
            sb2.append(this);
            return 0;
        }
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(AppUtility.CENTER_DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f2591a)) {
            str = f2591a + '.' + str;
        }
        try {
            Map map = f2593c.get();
            if (map == null) {
                map = new HashMap();
                f2593c.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f2592b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), e2);
        }
    }

    private static d d(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.f2604b) {
            if (view instanceof a) {
                dVar.a(((a) view).getBehavior());
                dVar.f2604b = true;
            } else {
                b bVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a((Behavior) bVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception unused) {
                        StringBuilder sb = new StringBuilder("Default behavior class ");
                        sb.append(bVar.a().getName());
                        sb.append(" could not be instantiated. Did you forget a default constructor?");
                    }
                }
                dVar.f2604b = true;
            }
        }
        return dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r5 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0168 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r11 = this;
            java.util.List<android.view.View> r0 = r11.f2599i
            r0.clear()
            androidx.coordinatorlayout.widget.a<android.view.View> r0 = r11.j
            androidx.a.g<T, java.util.ArrayList<T>> r1 = r0.f2614b
            int r1 = r1.size()
            r2 = 0
            r3 = 0
        L_0x000f:
            if (r3 >= r1) goto L_0x0026
            androidx.a.g<T, java.util.ArrayList<T>> r4 = r0.f2614b
            java.lang.Object r4 = r4.c(r3)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 == 0) goto L_0x0023
            r4.clear()
            androidx.core.g.e$a<java.util.ArrayList<T>> r5 = r0.f2613a
            r5.a(r4)
        L_0x0023:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0026:
            androidx.a.g<T, java.util.ArrayList<T>> r0 = r0.f2614b
            r0.clear()
            int r0 = r11.getChildCount()
            r1 = 0
        L_0x0030:
            if (r1 >= r0) goto L_0x0196
            android.view.View r3 = r11.getChildAt(r1)
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r4 = d((android.view.View) r3)
            int r5 = r4.f2608f
            r6 = -1
            r7 = 0
            r8 = 1
            if (r5 != r6) goto L_0x0047
            r4.l = r7
            r4.k = r7
            goto L_0x00d9
        L_0x0047:
            android.view.View r5 = r4.k
            if (r5 == 0) goto L_0x007c
            android.view.View r5 = r4.k
            int r5 = r5.getId()
            int r6 = r4.f2608f
            if (r5 == r6) goto L_0x0057
        L_0x0055:
            r5 = 0
            goto L_0x007a
        L_0x0057:
            android.view.View r5 = r4.k
            android.view.View r6 = r4.k
            android.view.ViewParent r6 = r6.getParent()
        L_0x005f:
            if (r6 == r11) goto L_0x0077
            if (r6 == 0) goto L_0x0072
            if (r6 != r3) goto L_0x0066
            goto L_0x0072
        L_0x0066:
            boolean r9 = r6 instanceof android.view.View
            if (r9 == 0) goto L_0x006d
            r5 = r6
            android.view.View r5 = (android.view.View) r5
        L_0x006d:
            android.view.ViewParent r6 = r6.getParent()
            goto L_0x005f
        L_0x0072:
            r4.l = r7
            r4.k = r7
            goto L_0x0055
        L_0x0077:
            r4.l = r5
            r5 = 1
        L_0x007a:
            if (r5 != 0) goto L_0x00d9
        L_0x007c:
            int r5 = r4.f2608f
            android.view.View r5 = r11.findViewById(r5)
            r4.k = r5
            android.view.View r5 = r4.k
            if (r5 == 0) goto L_0x00cf
            android.view.View r5 = r4.k
            if (r5 != r11) goto L_0x009f
            boolean r5 = r11.isInEditMode()
            if (r5 == 0) goto L_0x0097
            r4.l = r7
            r4.k = r7
            goto L_0x00d9
        L_0x0097:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "View can not be anchored to the the parent CoordinatorLayout"
            r0.<init>(r1)
            throw r0
        L_0x009f:
            android.view.View r5 = r4.k
            android.view.View r6 = r4.k
            android.view.ViewParent r6 = r6.getParent()
        L_0x00a7:
            if (r6 == r11) goto L_0x00cc
            if (r6 == 0) goto L_0x00cc
            if (r6 != r3) goto L_0x00c0
            boolean r5 = r11.isInEditMode()
            if (r5 == 0) goto L_0x00b8
            r4.l = r7
            r4.k = r7
            goto L_0x00d9
        L_0x00b8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Anchor must not be a descendant of the anchored view"
            r0.<init>(r1)
            throw r0
        L_0x00c0:
            boolean r9 = r6 instanceof android.view.View
            if (r9 == 0) goto L_0x00c7
            r5 = r6
            android.view.View r5 = (android.view.View) r5
        L_0x00c7:
            android.view.ViewParent r6 = r6.getParent()
            goto L_0x00a7
        L_0x00cc:
            r4.l = r5
            goto L_0x00d9
        L_0x00cf:
            boolean r5 = r11.isInEditMode()
            if (r5 == 0) goto L_0x0170
            r4.l = r7
            r4.k = r7
        L_0x00d9:
            androidx.coordinatorlayout.widget.a<android.view.View> r5 = r11.j
            r5.a(r3)
            r5 = 0
        L_0x00df:
            if (r5 >= r0) goto L_0x016c
            if (r5 == r1) goto L_0x0168
            android.view.View r6 = r11.getChildAt(r5)
            android.view.View r7 = r4.l
            if (r6 == r7) goto L_0x011a
            int r7 = androidx.core.h.u.j(r11)
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r9
            int r9 = r9.f2609g
            int r9 = androidx.core.h.e.a(r9, r7)
            if (r9 == 0) goto L_0x0108
            int r10 = r4.f2610h
            int r7 = androidx.core.h.e.a(r10, r7)
            r7 = r7 & r9
            if (r7 != r9) goto L_0x0108
            r7 = 1
            goto L_0x0109
        L_0x0108:
            r7 = 0
        L_0x0109:
            if (r7 != 0) goto L_0x011a
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r7 = r4.f2603a
            if (r7 == 0) goto L_0x0118
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r7 = r4.f2603a
            boolean r7 = r7.layoutDependsOn(r11, r3, r6)
            if (r7 == 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r7 = 0
            goto L_0x011b
        L_0x011a:
            r7 = 1
        L_0x011b:
            if (r7 == 0) goto L_0x0168
            androidx.coordinatorlayout.widget.a<android.view.View> r7 = r11.j
            androidx.a.g<T, java.util.ArrayList<T>> r7 = r7.f2614b
            boolean r7 = r7.containsKey(r6)
            if (r7 != 0) goto L_0x012c
            androidx.coordinatorlayout.widget.a<android.view.View> r7 = r11.j
            r7.a(r6)
        L_0x012c:
            androidx.coordinatorlayout.widget.a<android.view.View> r7 = r11.j
            androidx.a.g<T, java.util.ArrayList<T>> r9 = r7.f2614b
            boolean r9 = r9.containsKey(r6)
            if (r9 == 0) goto L_0x0160
            androidx.a.g<T, java.util.ArrayList<T>> r9 = r7.f2614b
            boolean r9 = r9.containsKey(r3)
            if (r9 == 0) goto L_0x0160
            androidx.a.g<T, java.util.ArrayList<T>> r9 = r7.f2614b
            java.lang.Object r9 = r9.get(r6)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 != 0) goto L_0x015c
            androidx.core.g.e$a<java.util.ArrayList<T>> r9 = r7.f2613a
            java.lang.Object r9 = r9.a()
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 != 0) goto L_0x0157
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x0157:
            androidx.a.g<T, java.util.ArrayList<T>> r7 = r7.f2614b
            r7.put(r6, r9)
        L_0x015c:
            r9.add(r3)
            goto L_0x0168
        L_0x0160:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "All nodes must be present in the graph before being added as an edge"
            r0.<init>(r1)
            throw r0
        L_0x0168:
            int r5 = r5 + 1
            goto L_0x00df
        L_0x016c:
            int r1 = r1 + 1
            goto L_0x0030
        L_0x0170:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Could not find CoordinatorLayout descendant view with id "
            r1.<init>(r2)
            android.content.res.Resources r2 = r11.getResources()
            int r4 = r4.f2608f
            java.lang.String r2 = r2.getResourceName(r4)
            r1.append(r2)
            java.lang.String r2 = " to anchor view "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0196:
            java.util.List<android.view.View> r0 = r11.f2599i
            androidx.coordinatorlayout.widget.a<android.view.View> r1 = r11.j
            java.util.ArrayList r1 = r1.a()
            r0.addAll(r1)
            java.util.List<android.view.View> r0 = r11.f2599i
            java.util.Collections.reverse(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.b():void");
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public final void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0188, code lost:
        if (r0.onMeasureChild(r30, r20, r8, r21, r23, 0) == false) goto L_0x0197;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.b()
            int r0 = r30.getChildCount()
            r8 = 0
            r1 = 0
        L_0x000b:
            r2 = 1
            if (r1 >= r0) goto L_0x003a
            android.view.View r3 = r7.getChildAt(r1)
            androidx.coordinatorlayout.widget.a<android.view.View> r4 = r7.j
            androidx.a.g<T, java.util.ArrayList<T>> r5 = r4.f2614b
            int r5 = r5.size()
            r6 = 0
        L_0x001b:
            if (r6 >= r5) goto L_0x0032
            androidx.a.g<T, java.util.ArrayList<T>> r9 = r4.f2614b
            java.lang.Object r9 = r9.c(r6)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 == 0) goto L_0x002f
            boolean r9 = r9.contains(r3)
            if (r9 == 0) goto L_0x002f
            r3 = 1
            goto L_0x0033
        L_0x002f:
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 == 0) goto L_0x0037
            r0 = 1
            goto L_0x003b
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x000b
        L_0x003a:
            r0 = 0
        L_0x003b:
            boolean r1 = r7.v
            if (r0 == r1) goto L_0x006f
            if (r0 == 0) goto L_0x005c
            boolean r0 = r7.q
            if (r0 == 0) goto L_0x0059
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r0 = r7.u
            if (r0 != 0) goto L_0x0050
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$e
            r0.<init>()
            r7.u = r0
        L_0x0050:
            android.view.ViewTreeObserver r0 = r30.getViewTreeObserver()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r1 = r7.u
            r0.addOnPreDrawListener(r1)
        L_0x0059:
            r7.v = r2
            goto L_0x006f
        L_0x005c:
            boolean r0 = r7.q
            if (r0 == 0) goto L_0x006d
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r0 = r7.u
            if (r0 == 0) goto L_0x006d
            android.view.ViewTreeObserver r0 = r30.getViewTreeObserver()
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r1 = r7.u
            r0.removeOnPreDrawListener(r1)
        L_0x006d:
            r7.v = r8
        L_0x006f:
            int r9 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r10 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r11 = androidx.core.h.u.j(r30)
            if (r11 != r2) goto L_0x0087
            r12 = 1
            goto L_0x0088
        L_0x0087:
            r12 = 0
        L_0x0088:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r9 + r10
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.h.ab r3 = r7.f2596e
            if (r3 == 0) goto L_0x00b1
            boolean r3 = androidx.core.h.u.A(r30)
            if (r3 == 0) goto L_0x00b1
            r19 = 1
            goto L_0x00b3
        L_0x00b1:
            r19 = 0
        L_0x00b3:
            java.util.List<android.view.View> r2 = r7.f2599i
            int r6 = r2.size()
            r4 = r0
            r2 = r1
            r3 = 0
            r5 = 0
        L_0x00bd:
            if (r5 >= r6) goto L_0x01e6
            java.util.List<android.view.View> r0 = r7.f2599i
            java.lang.Object r0 = r0.get(r5)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x01d7
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r1
            int r0 = r1.f2607e
            if (r0 < 0) goto L_0x011c
            if (r13 == 0) goto L_0x011c
            int r0 = r1.f2607e
            int r0 = r7.b((int) r0)
            int r8 = r1.f2605c
            int r8 = d((int) r8)
            int r8 = androidx.core.h.e.a(r8, r11)
            r8 = r8 & 7
            r22 = r2
            r2 = 3
            if (r8 != r2) goto L_0x00f7
            if (r12 == 0) goto L_0x00fc
        L_0x00f7:
            r2 = 5
            if (r8 != r2) goto L_0x0108
            if (r12 == 0) goto L_0x0108
        L_0x00fc:
            int r2 = r14 - r10
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r8 = 0
            goto L_0x0120
        L_0x0108:
            if (r8 != r2) goto L_0x010c
            if (r12 == 0) goto L_0x0111
        L_0x010c:
            r2 = 3
            if (r8 != r2) goto L_0x011a
            if (r12 == 0) goto L_0x011a
        L_0x0111:
            int r0 = r0 - r9
            r8 = 0
            int r0 = java.lang.Math.max(r8, r0)
            r21 = r0
            goto L_0x0120
        L_0x011a:
            r8 = 0
            goto L_0x011e
        L_0x011c:
            r22 = r2
        L_0x011e:
            r21 = 0
        L_0x0120:
            if (r19 == 0) goto L_0x0162
            boolean r0 = androidx.core.h.u.A(r20)
            if (r0 != 0) goto L_0x0162
            androidx.core.h.ab r0 = r7.f2596e
            androidx.core.h.ab$e r0 = r0.f3061b
            androidx.core.graphics.b r0 = r0.g()
            int r0 = r0.f2973b
            androidx.core.h.ab r2 = r7.f2596e
            androidx.core.h.ab$e r2 = r2.f3061b
            androidx.core.graphics.b r2 = r2.g()
            int r2 = r2.f2975d
            int r0 = r0 + r2
            androidx.core.h.ab r2 = r7.f2596e
            androidx.core.h.ab$e r2 = r2.f3061b
            androidx.core.graphics.b r2 = r2.g()
            int r2 = r2.f2974c
            androidx.core.h.ab r8 = r7.f2596e
            androidx.core.h.ab$e r8 = r8.f3061b
            androidx.core.graphics.b r8 = r8.g()
            int r8 = r8.f2976e
            int r2 = r2 + r8
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r8 = r0
            r23 = r2
            goto L_0x0166
        L_0x0162:
            r8 = r31
            r23 = r32
        L_0x0166:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f2603a
            if (r0 == 0) goto L_0x018b
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r27 = r3
            r3 = r8
            r28 = r4
            r4 = r21
            r22 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.onMeasureChild(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x01a4
            goto L_0x0197
        L_0x018b:
            r26 = r1
            r27 = r3
            r28 = r4
            r29 = r6
            r25 = r22
            r22 = r5
        L_0x0197:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r8
            r3 = r21
            r4 = r23
            r0.a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
        L_0x01a4:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            r2 = r28
            int r0 = java.lang.Math.max(r2, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r25
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r8 = r27
            int r2 = android.view.View.combineMeasuredStates(r8, r2)
            r4 = r0
            r3 = r2
            goto L_0x01de
        L_0x01d7:
            r1 = r2
            r8 = r3
            r2 = r4
            r22 = r5
            r29 = r6
        L_0x01de:
            r2 = r1
            int r5 = r22 + 1
            r6 = r29
            r8 = 0
            goto L_0x00bd
        L_0x01e6:
            r1 = r2
            r8 = r3
            r2 = r4
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r8
            r3 = r31
            int r0 = android.view.View.resolveSizeAndState(r2, r3, r0)
            int r2 = r8 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public final void b(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        int i3 = 0;
        if (dVar.k == null && dVar.f2608f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.k != null) {
            View view2 = dVar.k;
            Rect a2 = a();
            Rect a3 = a();
            try {
                b.a((ViewGroup) this, view2, a2);
                d dVar2 = (d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                a(i2, a2, a3, dVar2, measuredWidth, measuredHeight);
                a(dVar2, a3, measuredWidth, measuredHeight);
                view.layout(a3.left, a3.top, a3.right, a3.bottom);
            } finally {
                a(a2);
                a(a3);
            }
        } else if (dVar.f2607e >= 0) {
            int i4 = dVar.f2607e;
            d dVar3 = (d) view.getLayoutParams();
            int a4 = androidx.core.h.e.a(d(dVar3.f2605c), i2);
            int i5 = a4 & 7;
            int i6 = a4 & 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight2 = view.getMeasuredHeight();
            if (i2 == 1) {
                i4 = width - i4;
            }
            int b2 = b(i4) - measuredWidth2;
            if (i5 == 1) {
                b2 += measuredWidth2 / 2;
            } else if (i5 == 5) {
                b2 += measuredWidth2;
            }
            if (i6 == 16) {
                i3 = 0 + (measuredHeight2 / 2);
            } else if (i6 == 80) {
                i3 = measuredHeight2 + 0;
            }
            int max = Math.max(getPaddingLeft() + dVar3.leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth2) - dVar3.rightMargin));
            int max2 = Math.max(getPaddingTop() + dVar3.topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight2) - dVar3.bottomMargin));
            view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
        } else {
            d dVar4 = (d) view.getLayoutParams();
            Rect a5 = a();
            a5.set(getPaddingLeft() + dVar4.leftMargin, getPaddingTop() + dVar4.topMargin, (getWidth() - getPaddingRight()) - dVar4.rightMargin, (getHeight() - getPaddingBottom()) - dVar4.bottomMargin);
            if (this.f2596e != null && u.A(this) && !u.A(view)) {
                a5.left += this.f2596e.f3061b.g().f2973b;
                a5.top += this.f2596e.f3061b.g().f2974c;
                a5.right -= this.f2596e.f3061b.g().f2975d;
                a5.bottom -= this.f2596e.f3061b.g().f2976e;
            }
            Rect a6 = a();
            androidx.core.h.e.a(c(dVar4.f2605c), view.getMeasuredWidth(), view.getMeasuredHeight(), a5, a6, i2);
            view.layout(a6.left, a6.top, a6.right, a6.bottom);
            a(a5);
            a(a6);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Behavior behavior;
        int j2 = u.j(this);
        int size = this.f2599i.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f2599i.get(i6);
            if (view.getVisibility() != 8 && ((behavior = ((d) view.getLayoutParams()).f2603a) == null || !behavior.onLayoutChild(this, view, j2))) {
                b(view, j2);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.f2597f && this.w != null) {
            ab abVar = this.f2596e;
            if (abVar != null) {
                i2 = abVar.f3061b.g().f2974c;
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                this.w.setBounds(0, 0, getWidth(), i2);
                this.w.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        c();
    }

    private void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            b.a((ViewGroup) this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    private static void a(int i2, Rect rect, Rect rect2, d dVar, int i3, int i4) {
        int i5;
        int i6;
        int a2 = androidx.core.h.e.a(e(dVar.f2605c), i2);
        int a3 = androidx.core.h.e.a(c(dVar.f2606d), i2);
        int i7 = a2 & 7;
        int i8 = a2 & 112;
        int i9 = a3 & 7;
        int i10 = a3 & 112;
        if (i9 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i9 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i10 == 16) {
            i6 = rect.top + (rect.height() / 2);
        } else if (i10 != 80) {
            i6 = rect.top;
        } else {
            i6 = rect.bottom;
        }
        if (i7 == 1) {
            i5 -= i3 / 2;
        } else if (i7 != 5) {
            i5 -= i3;
        }
        if (i8 == 16) {
            i6 -= i4 / 2;
        } else if (i8 != 80) {
            i6 -= i4;
        }
        rect2.set(i5, i6, i3 + i5, i4 + i6);
    }

    private void a(d dVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - dVar.bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.f2603a != null) {
            float scrimOpacity = dVar.f2603a.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.m == null) {
                    this.m = new Paint();
                }
                this.m.setColor(dVar.f2603a.getScrimColor(this, view));
                Paint paint = this.m;
                int round = Math.round(scrimOpacity * 255.0f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = PriceRangeSeekBar.INVALID_POINTER_ID;
                }
                paint.setAlpha(round);
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.m);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int i3;
        Rect rect;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        int width;
        int i5;
        int height;
        int i6;
        d dVar;
        int i7;
        int i8;
        int i9;
        Rect rect2;
        int i10;
        d dVar2;
        Behavior behavior;
        int i11 = i2;
        int j2 = u.j(this);
        int size = this.f2599i.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        int i12 = 0;
        while (i12 < size) {
            View view = this.f2599i.get(i12);
            d dVar3 = (d) view.getLayoutParams();
            if (i11 == 0 && view.getVisibility() == 8) {
                i4 = size;
                rect = a4;
                i3 = i12;
            } else {
                int i13 = 0;
                while (i13 < i12) {
                    if (dVar3.l == this.f2599i.get(i13)) {
                        d dVar4 = (d) view.getLayoutParams();
                        if (dVar4.k != null) {
                            Rect a5 = a();
                            Rect a6 = a();
                            Rect a7 = a();
                            b.a((ViewGroup) this, dVar4.k, a5);
                            a(view, false, a6);
                            int measuredWidth = view.getMeasuredWidth();
                            i9 = size;
                            int measuredHeight = view.getMeasuredHeight();
                            i8 = i12;
                            Rect rect3 = a6;
                            Rect rect4 = a5;
                            d dVar5 = dVar4;
                            int i14 = measuredWidth;
                            rect2 = a4;
                            boolean z4 = true;
                            i7 = i13;
                            dVar = dVar3;
                            a(j2, a5, a7, dVar5, i14, measuredHeight);
                            if (a7.left == rect3.left && a7.top == rect3.top) {
                                dVar2 = dVar5;
                                i10 = i14;
                                z4 = false;
                            } else {
                                dVar2 = dVar5;
                                i10 = i14;
                            }
                            a(dVar2, a7, i10, measuredHeight);
                            int i15 = a7.left - rect3.left;
                            int i16 = a7.top - rect3.top;
                            if (i15 != 0) {
                                u.g(view, i15);
                            }
                            if (i16 != 0) {
                                u.f(view, i16);
                            }
                            if (z4 && (behavior = dVar2.f2603a) != null) {
                                behavior.onDependentViewChanged(this, view, dVar2.k);
                            }
                            a(rect4);
                            a(rect3);
                            a(a7);
                            i13 = i7 + 1;
                            a4 = rect2;
                            size = i9;
                            i12 = i8;
                            dVar3 = dVar;
                        }
                    }
                    i7 = i13;
                    dVar = dVar3;
                    i9 = size;
                    rect2 = a4;
                    i8 = i12;
                    i13 = i7 + 1;
                    a4 = rect2;
                    size = i9;
                    i12 = i8;
                    dVar3 = dVar;
                }
                int i17 = size;
                Rect rect5 = a4;
                i3 = i12;
                a(view, true, a3);
                d dVar6 = dVar3;
                if (dVar6.f2609g != 0 && !a3.isEmpty()) {
                    int a8 = androidx.core.h.e.a(dVar6.f2609g, j2);
                    int i18 = a8 & 112;
                    if (i18 == 48) {
                        a2.top = Math.max(a2.top, a3.bottom);
                    } else if (i18 == 80) {
                        a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                    }
                    int i19 = a8 & 7;
                    if (i19 == 3) {
                        a2.left = Math.max(a2.left, a3.right);
                    } else if (i19 == 5) {
                        a2.right = Math.max(a2.right, getWidth() - a3.left);
                    }
                }
                if (dVar6.f2610h != 0 && view.getVisibility() == 0 && u.J(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                    d dVar7 = (d) view.getLayoutParams();
                    Behavior behavior2 = dVar7.f2603a;
                    Rect a9 = a();
                    Rect a10 = a();
                    a10.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (behavior2 == null || !behavior2.getInsetDodgeRect(this, view, a9)) {
                        a9.set(a10);
                    } else if (!a10.contains(a9)) {
                        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a9.toShortString() + " | Bounds:" + a10.toShortString());
                    }
                    a(a10);
                    if (!a9.isEmpty()) {
                        int a11 = androidx.core.h.e.a(dVar7.f2610h, j2);
                        if ((a11 & 48) != 48 || (i6 = (a9.top - dVar7.topMargin) - dVar7.j) >= a2.top) {
                            z2 = false;
                        } else {
                            d(view, a2.top - i6);
                            z2 = true;
                        }
                        if ((a11 & 80) == 80 && (height = ((getHeight() - a9.bottom) - dVar7.bottomMargin) + dVar7.j) < a2.bottom) {
                            d(view, height - a2.bottom);
                            z2 = true;
                        }
                        if (!z2) {
                            d(view, 0);
                        }
                        if ((a11 & 3) != 3 || (i5 = (a9.left - dVar7.leftMargin) - dVar7.f2611i) >= a2.left) {
                            z3 = false;
                        } else {
                            c(view, a2.left - i5);
                            z3 = true;
                        }
                        if ((a11 & 5) == 5 && (width = ((getWidth() - a9.right) - dVar7.rightMargin) + dVar7.f2611i) < a2.right) {
                            c(view, width - a2.right);
                            z3 = true;
                        }
                        if (!z3) {
                            c(view, 0);
                        }
                    }
                    a(a9);
                }
                if (i11 != 2) {
                    rect = rect5;
                    rect.set(((d) view.getLayoutParams()).o);
                    if (!rect.equals(a3)) {
                        ((d) view.getLayoutParams()).o.set(a3);
                    } else {
                        i4 = i17;
                    }
                } else {
                    rect = rect5;
                }
                i4 = i17;
                for (int i20 = i3 + 1; i20 < i4; i20++) {
                    View view2 = this.f2599i.get(i20);
                    d dVar8 = (d) view2.getLayoutParams();
                    Behavior behavior3 = dVar8.f2603a;
                    if (behavior3 != null && behavior3.layoutDependsOn(this, view2, view)) {
                        if (i11 != 0 || !dVar8.n) {
                            if (i11 != 2) {
                                z = behavior3.onDependentViewChanged(this, view2, view);
                            } else {
                                behavior3.onDependentViewRemoved(this, view2, view);
                                z = true;
                            }
                            if (i11 == 1) {
                                dVar8.n = z;
                            }
                        } else {
                            dVar8.n = false;
                        }
                    }
                }
            }
            i12 = i3 + 1;
            size = i4;
            a4 = rect;
        }
        a(a2);
        a(a3);
        a(a4);
    }

    private static void c(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.f2611i != i2) {
            u.g(view, i2 - dVar.f2611i);
            dVar.f2611i = i2;
        }
    }

    private static void d(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.j != i2) {
            u.f(view, i2 - dVar.j);
            dVar.j = i2;
        }
    }

    public final void a(View view) {
        List b2 = this.j.b(view);
        if (b2 != null && !b2.isEmpty()) {
            for (int i2 = 0; i2 < b2.size(); i2++) {
                View view2 = (View) b2.get(i2);
                Behavior behavior = ((d) view2.getLayoutParams()).f2603a;
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    public final List<View> b(View view) {
        a<View> aVar = this.j;
        int size = aVar.f2614b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayList c2 = aVar.f2614b.c(i2);
            if (c2 != null && c2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar.f2614b.b(i2));
            }
        }
        this.l.clear();
        if (arrayList != null) {
            this.l.addAll(arrayList);
        }
        return this.l;
    }

    public final List<View> c(View view) {
        List b2 = this.j.b(view);
        this.l.clear();
        if (b2 != null) {
            this.l.addAll(b2);
        }
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        b();
        return Collections.unmodifiableList(this.f2599i);
    }

    public final boolean a(View view, int i2, int i3) {
        Rect a2 = a();
        b.a((ViewGroup) this, view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            a(a2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    public final boolean a(View view, View view2, int i2, int i3) {
        int i4 = i3;
        int childCount = getChildCount();
        boolean z = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior behavior = dVar.f2603a;
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view, view2, i2, i3);
                    dVar.a(i4, onStartNestedScroll);
                    z |= onStartNestedScroll;
                } else {
                    dVar.a(i4, false);
                }
            }
        }
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    public final void b(View view, View view2, int i2, int i3) {
        Behavior behavior;
        this.y.a(i2, i3);
        this.t = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i3) && (behavior = dVar.f2603a) != null) {
                behavior.onNestedScrollAccepted(this, childAt, view, view2, i2, i3);
            }
        }
    }

    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    public final void a(View view, int i2) {
        this.y.a(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i2)) {
                Behavior behavior = dVar.f2603a;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i2);
                }
                dVar.a(i2, false);
                dVar.n = false;
            }
        }
        this.t = null;
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(view, i2, i3, i4, i5, 0, this.o);
    }

    public final void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        Behavior behavior;
        int i7;
        int i8;
        int childCount = getChildCount();
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i6) && (behavior = dVar.f2603a) != null) {
                    int[] iArr2 = this.n;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.n;
                    if (i4 > 0) {
                        i7 = Math.max(i9, iArr3[0]);
                    } else {
                        i7 = Math.min(i9, iArr3[0]);
                    }
                    if (i5 > 0) {
                        i8 = Math.max(i10, this.n[1]);
                    } else {
                        i8 = Math.min(i10, this.n[1]);
                    }
                    i9 = i7;
                    i10 = i8;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (z) {
            a(1);
        }
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    public final void a(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior behavior;
        int i5;
        int i6;
        int childCount = getChildCount();
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i4) && (behavior = dVar.f2603a) != null) {
                    int[] iArr2 = this.n;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.n;
                    if (i2 > 0) {
                        i5 = Math.max(i7, iArr3[0]);
                    } else {
                        i5 = Math.min(i7, iArr3[0]);
                    }
                    int[] iArr4 = this.n;
                    if (i3 > 0) {
                        i6 = Math.max(i8, iArr4[1]);
                    } else {
                        i6 = Math.min(i8, iArr4[1]);
                    }
                    i7 = i5;
                    i8 = i6;
                    z = true;
                }
            } else {
                int i10 = i4;
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z) {
            a(1);
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (behavior = dVar.f2603a) != null) {
                    z2 |= behavior.onNestedFling(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (behavior = dVar.f2603a) != null) {
                    z |= behavior.onNestedPreFling(this, childAt, view, f2, f3);
                }
            }
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.y.a();
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        public final boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            float K = u.K((View) obj);
            float K2 = u.K((View) obj2);
            if (K > K2) {
                return -1;
            }
            return K < K2 ? 1 : 0;
        }
    }

    public static abstract class Behavior<V extends View> {
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public ab onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, ab abVar) {
            return abVar;
        }

        public void onAttachedToLayoutParams(d dVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > 0.0f;
        }

        public static void setTag(View view, Object obj) {
            ((d) view.getLayoutParams()).p = obj;
        }

        public static Object getTag(View view) {
            return ((d) view.getLayoutParams()).p;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return onStartNestedScroll(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i2);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            onNestedScroll(coordinatorLayout, v, view, i2, i3, i4, i5, i6);
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public Behavior f2603a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2604b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2605c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2606d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2607e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2608f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2609g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2610h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f2611i;
        int j;
        View k;
        View l;
        boolean m;
        boolean n;
        final Rect o = new Rect();
        Object p;
        private boolean q;
        private boolean r;

        public d(int i2, int i3) {
            super(i2, i3);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2605c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2608f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2606d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2607e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2609g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2610h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f2604b = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f2604b) {
                this.f2603a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f2603a;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }

        public d(d dVar) {
            super(dVar);
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final Behavior a() {
            return this.f2603a;
        }

        public final void a(Behavior behavior) {
            Behavior behavior2 = this.f2603a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.onDetachedFromLayoutParams();
                }
                this.f2603a = behavior;
                this.p = null;
                this.f2604b = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, boolean z) {
            if (i2 == 0) {
                this.q = z;
            } else if (i2 == 1) {
                this.r = z;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int i2) {
            if (i2 == 0) {
                return this.q;
            }
            if (i2 != 1) {
                return false;
            }
            return this.r;
        }
    }

    class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        public final void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.f2598g != null) {
                CoordinatorLayout.this.f2598g.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.f2598g != null) {
                CoordinatorLayout.this.f2598g.onChildViewRemoved(view, view2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        SparseArray<Parcelable> sparseArray = savedState.f2601a;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior behavior = d(childAt).f2603a;
            if (!(id == -1 || behavior == null || (parcelable2 = sparseArray.get(id)) == null)) {
                behavior.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior behavior = ((d) childAt.getLayoutParams()).f2603a;
            if (!(id == -1 || behavior == null || (onSaveInstanceState = behavior.onSaveInstanceState(this, childAt)) == null)) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        savedState.f2601a = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((d) view.getLayoutParams()).f2603a;
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (u.A(this)) {
                if (this.x == null) {
                    this.x = new q() {
                        public final ab a(View view, ab abVar) {
                            Behavior behavior;
                            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
                            if (!androidx.core.g.c.a(coordinatorLayout.f2596e, abVar)) {
                                coordinatorLayout.f2596e = abVar;
                                boolean z = true;
                                coordinatorLayout.f2597f = abVar != null && abVar.f3061b.g().f2974c > 0;
                                if (coordinatorLayout.f2597f || coordinatorLayout.getBackground() != null) {
                                    z = false;
                                }
                                coordinatorLayout.setWillNotDraw(z);
                                if (!abVar.f3061b.b()) {
                                    int childCount = coordinatorLayout.getChildCount();
                                    for (int i2 = 0; i2 < childCount; i2++) {
                                        View childAt = coordinatorLayout.getChildAt(i2);
                                        if (u.A(childAt) && (behavior = ((d) childAt.getLayoutParams()).f2603a) != null) {
                                            abVar = behavior.onApplyWindowInsets(coordinatorLayout, childAt, abVar);
                                            if (abVar.f3061b.b()) {
                                                break;
                                            }
                                        }
                                    }
                                }
                                coordinatorLayout.requestLayout();
                            }
                            return abVar;
                        }
                    };
                }
                u.a((View) this, this.x);
                setSystemUiVisibility(1280);
                return;
            }
            u.a((View) this, (q) null);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        SparseArray<Parcelable> f2601a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2601a = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f2601a.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f2601a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f2601a.keyAt(i3);
                parcelableArr[i3] = this.f2601a.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    /* access modifiers changed from: protected */
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }
}
