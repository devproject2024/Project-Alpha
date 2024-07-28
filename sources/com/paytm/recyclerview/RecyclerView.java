package com.paytm.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.core.h.u;
import androidx.core.h.v;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.recyclerview.a;
import com.paytm.recyclerview.b;
import com.paytm.recyclerview.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

@Deprecated
public class RecyclerView extends ViewGroup implements androidx.core.h.i {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f15206a = (Build.VERSION.SDK_INT >= 23);
    /* access modifiers changed from: private */
    public static final Interpolator aq = new Interpolator() {
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final int[] q = {16843830};
    /* access modifiers changed from: private */
    public static final boolean r = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);
    private static final Class<?>[] s = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    /* access modifiers changed from: private */
    public final ArrayList<Object> A;
    private final ArrayList<g> B;
    private g C;
    private boolean D;
    private boolean E;
    private int F;
    /* access modifiers changed from: private */
    public boolean G;
    /* access modifiers changed from: private */
    public boolean H;
    private boolean I;
    private int J;
    private boolean K;
    private final boolean L;
    private final AccessibilityManager M;
    private List<Object> N;
    private int O;
    private int P;
    private int Q;
    private VelocityTracker R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private final int aa;
    private final int ab;
    private float ac;
    /* access modifiers changed from: private */
    public final p ad;
    private h ae;
    private List<h> af;
    private e.a ag;
    /* access modifiers changed from: private */
    public boolean ah;
    /* access modifiers changed from: private */
    public f ai;
    private d aj;
    private final int[] ak;
    private androidx.core.h.l al;
    private final int[] am;
    private final int[] an;
    private final int[] ao;
    private Runnable ap;
    private final i.b ar;

    /* renamed from: b  reason: collision with root package name */
    final j f15207b;

    /* renamed from: c  reason: collision with root package name */
    a f15208c;

    /* renamed from: d  reason: collision with root package name */
    b f15209d;

    /* renamed from: e  reason: collision with root package name */
    final i f15210e;

    /* renamed from: f  reason: collision with root package name */
    LayoutManager f15211f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f15212g;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f15213h;

    /* renamed from: i  reason: collision with root package name */
    androidx.core.widget.d f15214i;
    androidx.core.widget.d j;
    androidx.core.widget.d k;
    androidx.core.widget.d l;
    e m;
    final n n;
    boolean o;
    boolean p;
    private final l t;
    private SavedState u;
    private boolean v;
    private final Runnable w;
    /* access modifiers changed from: private */
    public final Rect x;
    /* access modifiers changed from: private */
    public a y;
    /* access modifiers changed from: private */
    public k z;

    static class b extends Observable<c> {
    }

    public static abstract class c {
    }

    public interface d {
        int a();
    }

    public interface g {
        boolean a();
    }

    public static abstract class h {
    }

    public interface k {
    }

    public static abstract class o {
        public abstract View a();
    }

    public void scrollTo(int i2, int i3) {
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        this.t = new l(this, (byte) 0);
        this.f15207b = new j();
        this.f15210e = new i();
        this.w = new Runnable() {
            public final void run() {
                if (RecyclerView.this.f15212g && !RecyclerView.this.isLayoutRequested()) {
                    if (RecyclerView.this.H) {
                        boolean unused = RecyclerView.this.G = true;
                    } else {
                        RecyclerView.this.j();
                    }
                }
            }
        };
        this.x = new Rect();
        this.A = new ArrayList<>();
        this.B = new ArrayList<>();
        this.F = 0;
        this.f15213h = false;
        this.O = 0;
        this.m = new c();
        this.P = 0;
        this.Q = -1;
        this.ac = Float.MIN_VALUE;
        this.ad = new p();
        this.n = new n();
        this.o = false;
        this.p = false;
        this.ag = new f(this, (byte) 0);
        this.ah = false;
        this.ak = new int[2];
        this.am = new int[2];
        this.an = new int[2];
        this.ao = new int[2];
        this.ap = new Runnable() {
            public final void run() {
                if (RecyclerView.this.m != null) {
                    RecyclerView.this.m.a();
                }
                boolean unused = RecyclerView.this.ah = false;
            }
        };
        this.ar = new i.b() {
            public final void a(q qVar, e.b bVar, e.b bVar2) {
                RecyclerView.this.f15207b.b(qVar);
                RecyclerView.a(RecyclerView.this, qVar, bVar, bVar2);
            }

            public final void b(q qVar, e.b bVar, e.b bVar2) {
                RecyclerView.b(RecyclerView.this, qVar, bVar, bVar2);
            }

            public final void c(q qVar, e.b bVar, e.b bVar2) {
                qVar.a(false);
                if (RecyclerView.this.f15213h) {
                    if (RecyclerView.this.m.a(qVar, qVar, bVar, bVar2)) {
                        RecyclerView.this.u();
                    }
                } else if (RecyclerView.this.m.c(qVar, bVar, bVar2)) {
                    RecyclerView.this.u();
                }
            }

            public final void a(q qVar) {
                LayoutManager layoutManager = RecyclerView.this.f15211f;
                View view = qVar.f15282a;
                j jVar = RecyclerView.this.f15207b;
                b bVar = layoutManager.f15223h;
                int a2 = bVar.f15303a.a(view);
                if (a2 >= 0) {
                    if (bVar.f15304b.d(a2)) {
                        bVar.b(view);
                    }
                    bVar.f15303a.a(a2);
                }
                jVar.a(view);
            }
        };
        boolean z2 = true;
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.L = Build.VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.W = viewConfiguration.getScaledTouchSlop();
        this.aa = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ab = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(u.a((View) this) == 2);
        this.m.f15233h = this.ag;
        this.f15208c = new a(new a.C0205a() {
            public final q a(int i2) {
                q qVar;
                RecyclerView recyclerView = RecyclerView.this;
                int b2 = recyclerView.f15209d.b();
                int i3 = 0;
                while (true) {
                    if (i3 >= b2) {
                        qVar = null;
                        break;
                    }
                    qVar = RecyclerView.b(recyclerView.f15209d.c(i3));
                    if (qVar != null && !qVar.n() && qVar.f15283b == i2) {
                        break;
                    }
                    i3++;
                }
                if (qVar != null && !RecyclerView.this.f15209d.d(qVar.f15282a)) {
                    return qVar;
                }
                return null;
            }

            public final void a(int i2, int i3) {
                RecyclerView.this.a(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.o = true;
                recyclerView.n.f15270e += i3;
            }

            public final void b(int i2, int i3) {
                RecyclerView.this.a(i2, i3, false);
                RecyclerView.this.o = true;
            }

            public final void a(int i2, int i3, Object obj) {
                int d2;
                RecyclerView recyclerView = RecyclerView.this;
                int b2 = recyclerView.f15209d.b();
                int i4 = i3 + i2;
                for (int i5 = 0; i5 < b2; i5++) {
                    View c2 = recyclerView.f15209d.c(i5);
                    q b3 = RecyclerView.b(c2);
                    if (b3 != null && !b3.c() && b3.f15283b >= i2 && b3.f15283b < i4) {
                        b3.b(2);
                        b3.a(obj);
                        ((LayoutParams) c2.getLayoutParams()).f15227c = true;
                    }
                }
                j jVar = recyclerView.f15207b;
                for (int size = jVar.f15245c.size() - 1; size >= 0; size--) {
                    q qVar = jVar.f15245c.get(size);
                    if (qVar != null && (d2 = qVar.d()) >= i2 && d2 < i4) {
                        qVar.b(2);
                        jVar.b(size);
                    }
                }
                RecyclerView.this.p = true;
            }

            public final void c(int i2, int i3) {
                RecyclerView recyclerView = RecyclerView.this;
                int b2 = recyclerView.f15209d.b();
                for (int i4 = 0; i4 < b2; i4++) {
                    q b3 = RecyclerView.b(recyclerView.f15209d.c(i4));
                    if (b3 != null && !b3.c() && b3.f15283b >= i2) {
                        b3.a(i3, false);
                        recyclerView.n.f15271f = true;
                    }
                }
                j jVar = recyclerView.f15207b;
                int size = jVar.f15245c.size();
                for (int i5 = 0; i5 < size; i5++) {
                    q qVar = jVar.f15245c.get(i5);
                    if (qVar != null && qVar.f15283b >= i2) {
                        qVar.a(i3, true);
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.o = true;
            }

            public final void d(int i2, int i3) {
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                int i9;
                RecyclerView recyclerView = RecyclerView.this;
                int b2 = recyclerView.f15209d.b();
                if (i2 < i3) {
                    i6 = i2;
                    i5 = i3;
                    i4 = -1;
                } else {
                    i5 = i2;
                    i6 = i3;
                    i4 = 1;
                }
                for (int i10 = 0; i10 < b2; i10++) {
                    q b3 = RecyclerView.b(recyclerView.f15209d.c(i10));
                    if (b3 != null && b3.f15283b >= i6 && b3.f15283b <= i5) {
                        if (b3.f15283b == i2) {
                            b3.a(i3 - i2, false);
                        } else {
                            b3.a(i4, false);
                        }
                        recyclerView.n.f15271f = true;
                    }
                }
                j jVar = recyclerView.f15207b;
                if (i2 < i3) {
                    i9 = i2;
                    i8 = i3;
                    i7 = -1;
                } else {
                    i8 = i2;
                    i9 = i3;
                    i7 = 1;
                }
                int size = jVar.f15245c.size();
                for (int i11 = 0; i11 < size; i11++) {
                    q qVar = jVar.f15245c.get(i11);
                    if (qVar != null && qVar.f15283b >= i9 && qVar.f15283b <= i8) {
                        if (qVar.f15283b == i2) {
                            qVar.a(i3 - i2, false);
                        } else {
                            qVar.a(i7, false);
                        }
                    }
                }
                recyclerView.requestLayout();
                RecyclerView.this.o = true;
            }
        });
        this.f15209d = new b(new b.C0206b() {
            public final int a() {
                return RecyclerView.this.getChildCount();
            }

            public final void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.a(RecyclerView.this, view);
            }

            public final int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public final void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.e(childAt);
                }
                RecyclerView.this.removeViewAt(i2);
            }

            public final View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            public final q b(View view) {
                return RecyclerView.b(view);
            }

            public final void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                q b2 = RecyclerView.b(view);
                if (b2 != null) {
                    if (b2.o() || b2.c()) {
                        b2.j();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: ".concat(String.valueOf(b2)));
                    }
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            public final void c(int i2) {
                q b2;
                View b3 = b(i2);
                if (!(b3 == null || (b2 = RecyclerView.b(b3)) == null)) {
                    if (!b2.o() || b2.c()) {
                        b2.b((int) UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child ".concat(String.valueOf(b2)));
                    }
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            public final void c(View view) {
                q b2 = RecyclerView.b(view);
                if (b2 != null) {
                    q.a(b2);
                }
            }

            public final void d(View view) {
                q b2 = RecyclerView.b(view);
                if (b2 != null) {
                    q.b(b2);
                }
            }

            public final void b() {
                int childCount = RecyclerView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    RecyclerView.this.e(b(i2));
                }
                RecyclerView.this.removeAllViews();
            }
        });
        if (u.h(this) == 0) {
            u.c((View) this, 1);
        }
        this.M = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new f(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, 0);
            String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            if (string != null) {
                String trim = string.trim();
                if (trim.length() != 0) {
                    if (trim.charAt(0) == '.') {
                        trim = context.getPackageName() + trim;
                    } else if (!trim.contains(AppUtility.CENTER_DOT)) {
                        trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                    }
                    try {
                        if (isInEditMode()) {
                            classLoader = getClass().getClassLoader();
                        } else {
                            classLoader = context.getClassLoader();
                        }
                        Class<? extends U> asSubclass = classLoader.loadClass(trim).asSubclass(LayoutManager.class);
                        Object[] objArr = null;
                        try {
                            constructor = asSubclass.getConstructor(s);
                            objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), 0};
                        } catch (NoSuchMethodException e2) {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        }
                        constructor.setAccessible(true);
                        setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e3);
                    } catch (ClassNotFoundException e4) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                    } catch (InvocationTargetException e5) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e5);
                    } catch (InstantiationException e6) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                    } catch (IllegalAccessException e7) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e7);
                    } catch (ClassCastException e8) {
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e8);
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, q, i2, 0);
                z2 = obtainStyledAttributes2.getBoolean(0, true);
                obtainStyledAttributes2.recycle();
            }
        }
        setNestedScrollingEnabled(z2);
    }

    public f getCompatAccessibilityDelegate() {
        return this.ai;
    }

    public void setAccessibilityDelegateCompat(f fVar) {
        this.ai = fVar;
        u.a((View) this, (androidx.core.h.a) this.ai);
    }

    public void setHasFixedSize(boolean z2) {
        this.E = z2;
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.v) {
            n();
        }
        this.v = z2;
        super.setClipToPadding(z2);
        if (this.f15212g) {
            requestLayout();
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder("setScrollingTouchSlop(): bad argument constant ");
                sb.append(i2);
                sb.append("; using default value");
            } else {
                this.W = v.a(viewConfiguration);
                return;
            }
        }
        this.W = viewConfiguration.getScaledTouchSlop();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a aVar2 = this.y;
        if (aVar2 != null) {
            aVar2.f15230a.unregisterObserver(this.t);
        }
        e eVar = this.m;
        if (eVar != null) {
            eVar.d();
        }
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null) {
            layoutManager.b(this.f15207b);
            this.f15211f.a(this.f15207b);
        }
        this.f15207b.a();
        this.f15208c.a();
        a aVar3 = this.y;
        this.y = aVar;
        if (aVar != null) {
            aVar.f15230a.registerObserver(this.t);
        }
        j jVar = this.f15207b;
        a aVar4 = this.y;
        jVar.a();
        i b2 = jVar.b();
        if (aVar3 != null) {
            b2.c();
        }
        if (b2.f15241b == 0) {
            b2.f15240a.clear();
        }
        if (aVar4 != null) {
            b2.b();
        }
        this.n.f15271f = true;
        E();
        requestLayout();
    }

    public a getAdapter() {
        return this.y;
    }

    public void setRecyclerListener(k kVar) {
        this.z = kVar;
    }

    public int getBaseline() {
        if (this.f15211f != null) {
            return -1;
        }
        return super.getBaseline();
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.f15211f) {
            k();
            LayoutManager layoutManager2 = this.f15211f;
            if (layoutManager2 != null) {
                if (this.D) {
                    layoutManager2.b(this, this.f15207b);
                }
                this.f15211f.a((RecyclerView) null);
            }
            this.f15207b.a();
            b bVar = this.f15209d;
            b.a aVar = bVar.f15304b;
            while (true) {
                aVar.f15306a = 0;
                if (aVar.f15307b == null) {
                    break;
                }
                aVar = aVar.f15307b;
            }
            for (int size = bVar.f15305c.size() - 1; size >= 0; size--) {
                bVar.f15303a.d(bVar.f15305c.get(size));
                bVar.f15305c.remove(size);
            }
            bVar.f15303a.b();
            this.f15211f = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.f15224i == null) {
                    this.f15211f.a(this);
                    if (this.D) {
                        this.f15211f.k = true;
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView: " + layoutManager.f15224i);
                }
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.u;
        if (savedState2 != null) {
            savedState.f15229a = savedState2.f15229a;
        } else {
            LayoutManager layoutManager = this.f15211f;
            if (layoutManager != null) {
                savedState.f15229a = layoutManager.b();
            } else {
                savedState.f15229a = null;
            }
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.u = (SavedState) parcelable;
        super.onRestoreInstanceState(this.u.getSuperState());
        if (this.f15211f != null && this.u.f15229a != null) {
            this.f15211f.a(this.u.f15229a);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void a(q qVar) {
        View view = qVar.f15282a;
        boolean z2 = view.getParent() == this;
        this.f15207b.b(a(view));
        if (qVar.o()) {
            this.f15209d.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.f15209d.a(view, -1, true);
        } else {
            b bVar = this.f15209d;
            int a2 = bVar.f15303a.a(view);
            if (a2 >= 0) {
                bVar.f15304b.a(a2);
                bVar.a(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot OnPayChannelRecyclerViewHide ".concat(String.valueOf(view)));
        }
    }

    public LayoutManager getLayoutManager() {
        return this.f15211f;
    }

    public i getRecycledViewPool() {
        return this.f15207b.b();
    }

    public void setRecycledViewPool(i iVar) {
        j jVar = this.f15207b;
        if (jVar.f15248f != null) {
            jVar.f15248f.c();
        }
        jVar.f15248f = iVar;
        if (iVar != null) {
            i iVar2 = jVar.f15248f;
            RecyclerView.this.getAdapter();
            iVar2.b();
        }
    }

    public void setViewCacheExtension(o oVar) {
        this.f15207b.f15249g = oVar;
    }

    public void setItemViewCacheSize(int i2) {
        j jVar = this.f15207b;
        jVar.f15247e = i2;
        for (int size = jVar.f15245c.size() - 1; size >= 0 && jVar.f15245c.size() > i2; size--) {
            jVar.b(size);
        }
    }

    public int getScrollState() {
        return this.P;
    }

    /* access modifiers changed from: private */
    public void setScrollState(int i2) {
        if (i2 != this.P) {
            this.P = i2;
            if (i2 != 2) {
                l();
            }
            List<h> list = this.af;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.af.get(size);
                }
            }
        }
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.aj) {
            this.aj = dVar;
            setChildrenDrawingOrderEnabled(this.aj != null);
        }
    }

    @Deprecated
    public void setOnScrollListener(h hVar) {
        this.ae = hVar;
    }

    public void scrollBy(int i2, int i3) {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && !this.H) {
            boolean c2 = layoutManager.c();
            boolean d2 = this.f15211f.d();
            if (c2 || d2) {
                if (!c2) {
                    i2 = 0;
                }
                if (!d2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.f15212g) {
            if (this.f15213h) {
                androidx.core.d.m.a("RV FullInvalidate");
                x();
                androidx.core.d.m.a();
            } else if (this.f15208c.d()) {
                if (this.f15208c.a(4) && !this.f15208c.a(11)) {
                    androidx.core.d.m.a("RV PartialInvalidate");
                    a();
                    this.f15208c.b();
                    if (!this.G) {
                        int a2 = this.f15209d.a();
                        boolean z2 = false;
                        int i2 = 0;
                        while (true) {
                            if (i2 < a2) {
                                q b2 = b(this.f15209d.b(i2));
                                if (b2 != null && !b2.c() && b2.t()) {
                                    z2 = true;
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                        if (z2) {
                            x();
                        } else {
                            this.f15208c.c();
                        }
                    }
                    a(true);
                    androidx.core.d.m.a();
                } else if (this.f15208c.d()) {
                    androidx.core.d.m.a("RV FullInvalidate");
                    x();
                    androidx.core.d.m.a();
                }
            }
        }
    }

    private boolean a(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        j();
        if (this.y != null) {
            a();
            q();
            androidx.core.d.m.a("RV Scroll");
            if (i2 != 0) {
                i7 = this.f15211f.a(i2, this.f15207b, this.n);
                i6 = i2 - i7;
            } else {
                i7 = 0;
                i6 = 0;
            }
            if (i3 != 0) {
                i5 = this.f15211f.b(i3, this.f15207b, this.n);
                i4 = i3 - i5;
            } else {
                i5 = 0;
                i4 = 0;
            }
            androidx.core.d.m.a();
            F();
            r();
            a(false);
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.A.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i7, i5, i6, i4, this.am)) {
            int i8 = this.U;
            int[] iArr = this.am;
            this.U = i8 - iArr[0];
            this.V -= iArr[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            }
            int[] iArr2 = this.ao;
            int i9 = iArr2[0];
            int[] iArr3 = this.am;
            iArr2[0] = i9 + iArr3[0];
            iArr2[1] = iArr2[1] + iArr3[1];
        } else if (u.a((View) this) != 2) {
            if (motionEvent != null) {
                a(motionEvent.getX(), (float) i6, motionEvent.getY(), (float) i4);
            }
            b(i2, i3);
        }
        if (!(i7 == 0 && i5 == 0)) {
            g();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (i7 == 0 && i5 == 0) {
            return false;
        }
        return true;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && layoutManager.c()) {
            return this.f15211f.a(this.n);
        }
        return 0;
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && layoutManager.c()) {
            return this.f15211f.c(this.n);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && layoutManager.c()) {
            return this.f15211f.e(this.n);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && layoutManager.d()) {
            return this.f15211f.b(this.n);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && layoutManager.d()) {
            return this.f15211f.d(this.n);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null && layoutManager.d()) {
            return this.f15211f.f(this.n);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.F++;
        if (this.F == 1 && !this.H) {
            this.G = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        if (this.F <= 0) {
            this.F = 1;
        }
        if (!z2) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z2 && this.G && !this.H && this.f15211f != null && this.y != null) {
                x();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 == this.H) {
            return;
        }
        if (t()) {
            throw new IllegalStateException("Do not setLayoutFrozen in layout or scroll");
        } else if (!z2) {
            this.H = false;
            if (!(!this.G || this.f15211f == null || this.y == null)) {
                requestLayout();
            }
            this.G = false;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.H = true;
            this.I = true;
            k();
        }
    }

    private void k() {
        setScrollState(0);
        l();
    }

    private void l() {
        this.ad.b();
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null) {
            layoutManager.m();
        }
    }

    public int getMinFlingVelocity() {
        return this.aa;
    }

    public int getMaxFlingVelocity() {
        return this.ab;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.b()
            androidx.core.widget.d r3 = r6.f15214i
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            r3.a((float) r4, (float) r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.c()
            androidx.core.widget.d r3 = r6.k
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            r3.a((float) r4, (float) r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.d()
            androidx.core.widget.d r9 = r6.j
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            r9.a((float) r0, (float) r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.e()
            androidx.core.widget.d r9 = r6.l
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            r9.a((float) r3, (float) r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.h.u.g(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.RecyclerView.a(float, float, float, float):void");
    }

    private void m() {
        androidx.core.widget.d dVar = this.f15214i;
        boolean a2 = dVar != null ? dVar.a() : false;
        androidx.core.widget.d dVar2 = this.j;
        if (dVar2 != null) {
            a2 |= dVar2.a();
        }
        androidx.core.widget.d dVar3 = this.k;
        if (dVar3 != null) {
            a2 |= dVar3.a();
        }
        androidx.core.widget.d dVar4 = this.l;
        if (dVar4 != null) {
            a2 |= dVar4.a();
        }
        if (a2) {
            u.g(this);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3) {
        androidx.core.widget.d dVar = this.f15214i;
        boolean a2 = (dVar == null || dVar.f3191a.isFinished() || i2 <= 0) ? false : this.f15214i.a();
        androidx.core.widget.d dVar2 = this.k;
        if (dVar2 != null && !dVar2.f3191a.isFinished() && i2 < 0) {
            a2 |= this.k.a();
        }
        androidx.core.widget.d dVar3 = this.j;
        if (dVar3 != null && !dVar3.f3191a.isFinished() && i3 > 0) {
            a2 |= this.j.a();
        }
        androidx.core.widget.d dVar4 = this.l;
        if (dVar4 != null && !dVar4.f3191a.isFinished() && i3 < 0) {
            a2 |= this.l.a();
        }
        if (a2) {
            u.g(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.f15214i == null) {
            this.f15214i = new androidx.core.widget.d(getContext());
            if (this.v) {
                this.f15214i.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f15214i.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.k == null) {
            this.k = new androidx.core.widget.d(getContext());
            if (this.v) {
                this.k.a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.k.a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.j == null) {
            this.j = new androidx.core.widget.d(getContext());
            if (this.v) {
                this.j.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.j.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        if (this.l == null) {
            this.l = new androidx.core.widget.d(getContext());
            if (this.v) {
                this.l.a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.l.a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    private void n() {
        this.l = null;
        this.j = null;
        this.k = null;
        this.f15214i = null;
    }

    public View focusSearch(View view, int i2) {
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus == null && this.y != null && this.f15211f != null && !t() && !this.H) {
            a();
            findNextFocus = this.f15211f.c(i2, this.f15207b, this.n);
            a(false);
        }
        if (findNextFocus != null) {
            return findNextFocus;
        }
        return super.focusSearch(view, i2);
    }

    public void requestChildFocus(View view, View view2) {
        LayoutManager layoutManager = this.f15211f;
        if (!((layoutManager.j != null && layoutManager.j.f15254c) || t()) && view2 != null) {
            this.x.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                if (!layoutParams2.f15227c) {
                    Rect rect = layoutParams2.f15226b;
                    this.x.left -= rect.left;
                    this.x.right += rect.right;
                    this.x.top -= rect.top;
                    this.x.bottom += rect.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.x);
            offsetRectIntoDescendantCoords(view, this.x);
            requestChildRectangleOnScreen(view, this.x, !this.f15212g);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        int i2;
        LayoutManager layoutManager = this.f15211f;
        int i3 = layoutManager.i();
        int j2 = layoutManager.j();
        int k2 = layoutManager.n - layoutManager.k();
        int l2 = layoutManager.o - layoutManager.l();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int width = rect.width() + left;
        int height = rect.height() + top;
        int i4 = left - i3;
        int min = Math.min(0, i4);
        int i5 = top - j2;
        int min2 = Math.min(0, i5);
        int i6 = width - k2;
        int max = Math.max(0, i6);
        int max2 = Math.max(0, height - l2);
        if (u.j(layoutManager.f15224i) != 1) {
            if (min == 0) {
                min = Math.min(i4, max);
            }
            max = min;
        } else if (max == 0) {
            max = Math.max(min, i6);
        }
        if (min2 != 0) {
            i2 = min2;
        } else {
            i2 = Math.min(i5, max2);
        }
        if (max == 0 && i2 == 0) {
            return false;
        }
        if (z2) {
            scrollBy(max, i2);
        } else {
            LayoutManager layoutManager2 = this.f15211f;
            if (layoutManager2 != null && !this.H) {
                if (!layoutManager2.c()) {
                    max = 0;
                }
                if (!this.f15211f.d()) {
                    i2 = 0;
                }
                if (!(max == 0 && i2 == 0)) {
                    this.ad.a(max, i2);
                }
            }
        }
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        super.addFocusables(arrayList, i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.O = 0;
        this.D = true;
        this.f15212g = false;
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null) {
            layoutManager.k = true;
        }
        this.ah = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.m;
        if (eVar != null) {
            eVar.d();
        }
        this.f15212g = false;
        k();
        this.D = false;
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null) {
            layoutManager.b(this, this.f15207b);
        }
        removeCallbacks(this.ap);
        i.a.b();
    }

    public boolean isAttachedToWindow() {
        return this.D;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        if (this.H) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.C = null;
        }
        int size = this.B.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                z2 = false;
                break;
            }
            g gVar = this.B.get(i4);
            if (gVar.a() && action != 3) {
                this.C = gVar;
                z2 = true;
                break;
            }
            i4++;
        }
        if (z2) {
            p();
            return true;
        }
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager == null) {
            return false;
        }
        boolean c2 = layoutManager.c();
        boolean d2 = this.f15211f.d();
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.Q = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.U = x2;
            this.S = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.V = y2;
            this.T = y2;
            if (this.P == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.ao;
            iArr[1] = 0;
            iArr[0] = 0;
            if (d2) {
                c2 |= true;
            }
            startNestedScroll(c2 ? 1 : 0);
        } else if (actionMasked == 1) {
            this.R.clear();
            stopNestedScroll();
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.Q);
            if (findPointerIndex < 0) {
                StringBuilder sb = new StringBuilder("Error processing scroll; pointer index for id ");
                sb.append(this.Q);
                sb.append(" not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.P != 1) {
                int i5 = x3 - this.S;
                int i6 = y3 - this.T;
                int i7 = -1;
                if (!c2 || Math.abs(i5) <= (i3 = this.W)) {
                    z3 = false;
                } else {
                    this.U = this.S + (i3 * (i5 < 0 ? -1 : 1));
                    z3 = true;
                }
                if (d2 && Math.abs(i6) > (i2 = this.W)) {
                    int i8 = this.T;
                    if (i6 >= 0) {
                        i7 = 1;
                    }
                    this.V = i8 + (i2 * i7);
                    z3 = true;
                }
                if (z3) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            p();
        } else if (actionMasked == 5) {
            this.Q = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.U = x4;
            this.S = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.V = y4;
            this.T = y4;
        } else if (actionMasked == 6) {
            a(motionEvent);
        }
        if (this.P == 1) {
            return true;
        }
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.B.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.B.get(i2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x021a, code lost:
        if (r1 != false) goto L_0x021f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            boolean r2 = r0.H
            r3 = 0
            if (r2 != 0) goto L_0x0250
            boolean r2 = r0.I
            if (r2 == 0) goto L_0x000f
            goto L_0x0250
        L_0x000f:
            int r2 = r22.getAction()
            com.paytm.recyclerview.RecyclerView$g r4 = r0.C
            r5 = 3
            r6 = 1
            if (r4 == 0) goto L_0x0027
            r4 = 0
            if (r2 != 0) goto L_0x001f
            r0.C = r4
            goto L_0x0027
        L_0x001f:
            if (r2 == r5) goto L_0x0023
            if (r2 != r6) goto L_0x0025
        L_0x0023:
            r0.C = r4
        L_0x0025:
            r2 = 1
            goto L_0x0047
        L_0x0027:
            if (r2 == 0) goto L_0x0046
            java.util.ArrayList<com.paytm.recyclerview.RecyclerView$g> r2 = r0.B
            int r2 = r2.size()
            r4 = 0
        L_0x0030:
            if (r4 >= r2) goto L_0x0046
            java.util.ArrayList<com.paytm.recyclerview.RecyclerView$g> r7 = r0.B
            java.lang.Object r7 = r7.get(r4)
            com.paytm.recyclerview.RecyclerView$g r7 = (com.paytm.recyclerview.RecyclerView.g) r7
            boolean r8 = r7.a()
            if (r8 == 0) goto L_0x0043
            r0.C = r7
            goto L_0x0025
        L_0x0043:
            int r4 = r4 + 1
            goto L_0x0030
        L_0x0046:
            r2 = 0
        L_0x0047:
            if (r2 == 0) goto L_0x004d
            r21.p()
            return r6
        L_0x004d:
            com.paytm.recyclerview.RecyclerView$LayoutManager r2 = r0.f15211f
            if (r2 != 0) goto L_0x0052
            return r3
        L_0x0052:
            boolean r2 = r2.c()
            com.paytm.recyclerview.RecyclerView$LayoutManager r4 = r0.f15211f
            boolean r4 = r4.d()
            android.view.VelocityTracker r7 = r0.R
            if (r7 != 0) goto L_0x0066
            android.view.VelocityTracker r7 = android.view.VelocityTracker.obtain()
            r0.R = r7
        L_0x0066:
            android.view.MotionEvent r7 = android.view.MotionEvent.obtain(r22)
            int r8 = r22.getActionMasked()
            int r9 = r22.getActionIndex()
            if (r8 != 0) goto L_0x007a
            int[] r10 = r0.ao
            r10[r6] = r3
            r10[r3] = r3
        L_0x007a:
            int[] r10 = r0.ao
            r11 = r10[r3]
            float r11 = (float) r11
            r10 = r10[r6]
            float r10 = (float) r10
            r7.offsetLocation(r11, r10)
            r10 = 1056964608(0x3f000000, float:0.5)
            if (r8 == 0) goto L_0x0224
            r11 = 2
            if (r8 == r6) goto L_0x016b
            if (r8 == r11) goto L_0x00be
            if (r8 == r5) goto L_0x00b9
            r2 = 5
            if (r8 == r2) goto L_0x009d
            r2 = 6
            if (r8 == r2) goto L_0x0098
            goto L_0x0245
        L_0x0098:
            r21.a((android.view.MotionEvent) r22)
            goto L_0x0245
        L_0x009d:
            int r2 = r1.getPointerId(r9)
            r0.Q = r2
            float r2 = r1.getX(r9)
            float r2 = r2 + r10
            int r2 = (int) r2
            r0.U = r2
            r0.S = r2
            float r1 = r1.getY(r9)
            float r1 = r1 + r10
            int r1 = (int) r1
            r0.V = r1
            r0.T = r1
            goto L_0x0245
        L_0x00b9:
            r21.p()
            goto L_0x0245
        L_0x00be:
            int r5 = r0.Q
            int r5 = r1.findPointerIndex(r5)
            if (r5 >= 0) goto L_0x00d8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error processing scroll; pointer index for id "
            r1.<init>(r2)
            int r2 = r0.Q
            r1.append(r2)
            java.lang.String r2 = " not found. Did any MotionEvents get skipped?"
            r1.append(r2)
            return r3
        L_0x00d8:
            float r8 = r1.getX(r5)
            float r8 = r8 + r10
            int r8 = (int) r8
            float r1 = r1.getY(r5)
            float r1 = r1 + r10
            int r1 = (int) r1
            int r5 = r0.U
            int r5 = r5 - r8
            int r9 = r0.V
            int r9 = r9 - r1
            int[] r10 = r0.an
            int[] r11 = r0.am
            boolean r10 = r0.dispatchNestedPreScroll(r5, r9, r10, r11)
            if (r10 == 0) goto L_0x0119
            int[] r10 = r0.an
            r11 = r10[r3]
            int r5 = r5 - r11
            r10 = r10[r6]
            int r9 = r9 - r10
            int[] r10 = r0.am
            r11 = r10[r3]
            float r11 = (float) r11
            r10 = r10[r6]
            float r10 = (float) r10
            r7.offsetLocation(r11, r10)
            int[] r10 = r0.ao
            r11 = r10[r3]
            int[] r12 = r0.am
            r13 = r12[r3]
            int r11 = r11 + r13
            r10[r3] = r11
            r11 = r10[r6]
            r12 = r12[r6]
            int r11 = r11 + r12
            r10[r6] = r11
        L_0x0119:
            int r10 = r0.P
            if (r10 == r6) goto L_0x0144
            if (r2 == 0) goto L_0x012e
            int r10 = java.lang.Math.abs(r5)
            int r11 = r0.W
            if (r10 <= r11) goto L_0x012e
            if (r5 <= 0) goto L_0x012b
            int r5 = r5 - r11
            goto L_0x012c
        L_0x012b:
            int r5 = r5 + r11
        L_0x012c:
            r10 = 1
            goto L_0x012f
        L_0x012e:
            r10 = 0
        L_0x012f:
            if (r4 == 0) goto L_0x013f
            int r11 = java.lang.Math.abs(r9)
            int r12 = r0.W
            if (r11 <= r12) goto L_0x013f
            if (r9 <= 0) goto L_0x013d
            int r9 = r9 - r12
            goto L_0x013e
        L_0x013d:
            int r9 = r9 + r12
        L_0x013e:
            r10 = 1
        L_0x013f:
            if (r10 == 0) goto L_0x0144
            r0.setScrollState(r6)
        L_0x0144:
            int r10 = r0.P
            if (r10 != r6) goto L_0x0245
            int[] r10 = r0.am
            r11 = r10[r3]
            int r8 = r8 - r11
            r0.U = r8
            r8 = r10[r6]
            int r1 = r1 - r8
            r0.V = r1
            if (r2 == 0) goto L_0x0157
            goto L_0x0158
        L_0x0157:
            r5 = 0
        L_0x0158:
            if (r4 == 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r9 = 0
        L_0x015c:
            boolean r1 = r0.a((int) r5, (int) r9, (android.view.MotionEvent) r7)
            if (r1 == 0) goto L_0x0245
            android.view.ViewParent r1 = r21.getParent()
            r1.requestDisallowInterceptTouchEvent(r6)
            goto L_0x0245
        L_0x016b:
            android.view.VelocityTracker r1 = r0.R
            r1.addMovement(r7)
            android.view.VelocityTracker r1 = r0.R
            r5 = 1000(0x3e8, float:1.401E-42)
            int r8 = r0.ab
            float r8 = (float) r8
            r1.computeCurrentVelocity(r5, r8)
            r1 = 0
            if (r2 == 0) goto L_0x0187
            android.view.VelocityTracker r2 = r0.R
            int r5 = r0.Q
            float r2 = r2.getXVelocity(r5)
            float r2 = -r2
            goto L_0x0188
        L_0x0187:
            r2 = 0
        L_0x0188:
            if (r4 == 0) goto L_0x0194
            android.view.VelocityTracker r4 = r0.R
            int r5 = r0.Q
            float r4 = r4.getYVelocity(r5)
            float r4 = -r4
            goto L_0x0195
        L_0x0194:
            r4 = 0
        L_0x0195:
            int r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x019d
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x021c
        L_0x019d:
            int r1 = (int) r2
            int r2 = (int) r4
            com.paytm.recyclerview.RecyclerView$LayoutManager r4 = r0.f15211f
            if (r4 == 0) goto L_0x0219
            boolean r5 = r0.H
            if (r5 != 0) goto L_0x0219
            boolean r4 = r4.c()
            com.paytm.recyclerview.RecyclerView$LayoutManager r5 = r0.f15211f
            boolean r5 = r5.d()
            if (r4 == 0) goto L_0x01bb
            int r8 = java.lang.Math.abs(r1)
            int r9 = r0.aa
            if (r8 >= r9) goto L_0x01bc
        L_0x01bb:
            r1 = 0
        L_0x01bc:
            if (r5 == 0) goto L_0x01c6
            int r8 = java.lang.Math.abs(r2)
            int r9 = r0.aa
            if (r8 >= r9) goto L_0x01c7
        L_0x01c6:
            r2 = 0
        L_0x01c7:
            if (r1 != 0) goto L_0x01cb
            if (r2 == 0) goto L_0x0219
        L_0x01cb:
            float r8 = (float) r1
            float r9 = (float) r2
            boolean r10 = r0.dispatchNestedPreFling(r8, r9)
            if (r10 != 0) goto L_0x0219
            if (r4 != 0) goto L_0x01da
            if (r5 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r4 = 0
            goto L_0x01db
        L_0x01da:
            r4 = 1
        L_0x01db:
            r0.dispatchNestedFling(r8, r9, r4)
            if (r4 == 0) goto L_0x0219
            int r4 = r0.ab
            int r5 = -r4
            int r1 = java.lang.Math.min(r1, r4)
            int r15 = java.lang.Math.max(r5, r1)
            int r1 = r0.ab
            int r4 = -r1
            int r1 = java.lang.Math.min(r2, r1)
            int r16 = java.lang.Math.max(r4, r1)
            com.paytm.recyclerview.RecyclerView$p r1 = r0.ad
            com.paytm.recyclerview.RecyclerView r2 = com.paytm.recyclerview.RecyclerView.this
            r2.setScrollState(r11)
            r1.f15276b = r3
            r1.f15275a = r3
            androidx.core.widget.h r2 = r1.f15277c
            android.widget.OverScroller r12 = r2.f3197a
            r13 = 0
            r14 = 0
            r17 = -2147483648(0xffffffff80000000, float:-0.0)
            r18 = 2147483647(0x7fffffff, float:NaN)
            r19 = -2147483648(0xffffffff80000000, float:-0.0)
            r20 = 2147483647(0x7fffffff, float:NaN)
            r12.fling(r13, r14, r15, r16, r17, r18, r19, r20)
            r1.a()
            r1 = 1
            goto L_0x021a
        L_0x0219:
            r1 = 0
        L_0x021a:
            if (r1 != 0) goto L_0x021f
        L_0x021c:
            r0.setScrollState(r3)
        L_0x021f:
            r21.o()
            r3 = 1
            goto L_0x0245
        L_0x0224:
            int r5 = r1.getPointerId(r3)
            r0.Q = r5
            float r5 = r22.getX()
            float r5 = r5 + r10
            int r5 = (int) r5
            r0.U = r5
            r0.S = r5
            float r1 = r22.getY()
            float r1 = r1 + r10
            int r1 = (int) r1
            r0.V = r1
            r0.T = r1
            if (r4 == 0) goto L_0x0242
            r2 = r2 | 2
        L_0x0242:
            r0.startNestedScroll(r2)
        L_0x0245:
            if (r3 != 0) goto L_0x024c
            android.view.VelocityTracker r1 = r0.R
            r1.addMovement(r7)
        L_0x024c:
            r7.recycle()
            return r6
        L_0x0250:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void o() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll();
        m();
    }

    private void p() {
        o();
        setScrollState(0);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        if (this.f15211f != null && !this.H && (motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            float f3 = this.f15211f.d() ? -motionEvent.getAxisValue(9) : 0.0f;
            if (this.f15211f.c()) {
                f2 = motionEvent.getAxisValue(10);
            } else {
                f2 = 0.0f;
            }
            if (!(f3 == 0.0f && f2 == 0.0f)) {
                float scrollFactor = getScrollFactor();
                a((int) (f2 * scrollFactor), (int) (f3 * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    private float getScrollFactor() {
        if (this.ac == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.ac = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ac;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager == null) {
            a(i2, i3);
            return;
        }
        boolean z2 = false;
        if (layoutManager.f15221b) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.f15211f.c(i2, i3);
            if (!z2 && this.y != null) {
                if (this.n.f15267b == 1) {
                    y();
                }
                this.f15211f.a(i2, i3);
                this.n.k = true;
                z();
                this.f15211f.b(i2, i3);
                if (this.f15211f.e()) {
                    this.f15211f.a(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.n.k = true;
                    z();
                    this.f15211f.b(i2, i3);
                }
            }
        } else if (this.E) {
            this.f15211f.c(i2, i3);
        } else {
            if (this.K) {
                a();
                w();
                if (this.n.f15274i) {
                    this.n.f15272g = true;
                } else {
                    this.f15208c.e();
                    this.n.f15272g = false;
                }
                this.K = false;
                a(false);
            }
            a aVar = this.y;
            if (aVar != null) {
                this.n.f15268c = aVar.c();
            } else {
                this.n.f15268c = 0;
            }
            a();
            this.f15211f.c(i2, i3);
            a(false);
            this.n.f15272g = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3) {
        setMeasuredDimension(LayoutManager.a(i2, getPaddingLeft() + getPaddingRight(), u.q(this)), LayoutManager.a(i3, getPaddingTop() + getPaddingBottom(), u.r(this)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            n();
        }
    }

    public void setItemAnimator(e eVar) {
        e eVar2 = this.m;
        if (eVar2 != null) {
            eVar2.d();
            this.m.f15233h = null;
        }
        this.m = eVar;
        e eVar3 = this.m;
        if (eVar3 != null) {
            eVar3.f15233h = this.ag;
        }
    }

    /* access modifiers changed from: private */
    public void q() {
        this.O++;
    }

    /* access modifiers changed from: private */
    public void r() {
        this.O--;
        if (this.O <= 0) {
            this.O = 0;
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        AccessibilityManager accessibilityManager = this.M;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void s() {
        int i2 = this.J;
        this.J = 0;
        if (i2 != 0 && f()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(EmiUtil.EMI_PLAN_REQUEST_CODE);
            androidx.core.h.a.b.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean t() {
        return this.O > 0;
    }

    public e getItemAnimator() {
        return this.m;
    }

    /* access modifiers changed from: private */
    public void u() {
        if (!this.ah && this.D) {
            u.a((View) this, this.ap);
            this.ah = true;
        }
    }

    private boolean v() {
        return this.m != null && this.f15211f.f();
    }

    private void w() {
        if (this.f15213h) {
            this.f15208c.a();
            E();
        }
        if (v()) {
            this.f15208c.b();
        } else {
            this.f15208c.e();
        }
        boolean z2 = false;
        boolean z3 = this.o || this.p;
        this.n.f15273h = this.f15212g && this.m != null && (this.f15213h || z3 || this.f15211f.f15220a) && (!this.f15213h || this.y.f15231b);
        n nVar = this.n;
        if (nVar.f15273h && z3 && !this.f15213h && v()) {
            z2 = true;
        }
        nVar.f15274i = z2;
    }

    private void x() {
        if (this.y != null && this.f15211f != null) {
            n nVar = this.n;
            nVar.k = false;
            if (nVar.f15267b == 1) {
                y();
                this.f15211f.b(this);
                z();
            } else if (!this.f15208c.f() && this.f15211f.n == getWidth() && this.f15211f.o == getHeight()) {
                this.f15211f.b(this);
            } else {
                this.f15211f.b(this);
                z();
            }
            A();
        }
    }

    private void y() {
        boolean z2 = true;
        this.n.a(1);
        this.n.k = false;
        a();
        this.f15210e.a();
        q();
        w();
        n nVar = this.n;
        if (!nVar.f15273h || !this.p) {
            z2 = false;
        }
        nVar.j = z2;
        this.p = false;
        this.o = false;
        n nVar2 = this.n;
        nVar2.f15272g = nVar2.f15274i;
        this.n.f15268c = this.y.c();
        a(this.ak);
        if (this.n.f15273h) {
            int a2 = this.f15209d.a();
            for (int i2 = 0; i2 < a2; i2++) {
                q b2 = b(this.f15209d.b(i2));
                if (!b2.c() && (!b2.k() || this.y.f15231b)) {
                    e.e(b2);
                    b2.q();
                    this.f15210e.a(b2, new e.b().a(b2));
                    if (this.n.j && b2.t() && !b2.n() && !b2.c() && !b2.k()) {
                        this.f15210e.a(b(b2), b2);
                    }
                }
            }
        }
        if (this.n.f15274i) {
            C();
            boolean z3 = this.n.f15271f;
            n nVar3 = this.n;
            nVar3.f15271f = false;
            this.f15211f.a(this.f15207b, nVar3);
            this.n.f15271f = z3;
            for (int i3 = 0; i3 < this.f15209d.a(); i3++) {
                q b3 = b(this.f15209d.b(i3));
                if (!b3.c() && !this.f15210e.b(b3)) {
                    e.e(b3);
                    boolean a3 = b3.a((int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                    b3.q();
                    e.b a4 = new e.b().a(b3);
                    if (a3) {
                        a(b3, a4);
                    } else {
                        this.f15210e.b(b3, a4);
                    }
                }
            }
            D();
        } else {
            D();
        }
        r();
        a(false);
        this.n.f15267b = 2;
    }

    private void z() {
        a();
        q();
        this.n.a(6);
        this.f15208c.e();
        this.n.f15268c = this.y.c();
        n nVar = this.n;
        nVar.f15270e = 0;
        nVar.f15272g = false;
        this.f15211f.a(this.f15207b, nVar);
        n nVar2 = this.n;
        nVar2.f15271f = false;
        this.u = null;
        nVar2.f15273h = nVar2.f15273h && this.m != null;
        this.n.f15267b = 4;
        r();
        a(false);
    }

    private void A() {
        this.n.a(4);
        a();
        q();
        n nVar = this.n;
        nVar.f15267b = 1;
        if (nVar.f15273h) {
            for (int a2 = this.f15209d.a() - 1; a2 >= 0; a2--) {
                q b2 = b(this.f15209d.b(a2));
                if (!b2.c()) {
                    long b3 = b(b2);
                    e.b a3 = new e.b().a(b2);
                    q a4 = this.f15210e.a(b3);
                    if (a4 != null && !a4.c()) {
                        boolean a5 = this.f15210e.a(a4);
                        boolean a6 = this.f15210e.a(b2);
                        if (!a5 || a4 != b2) {
                            e.b a7 = this.f15210e.a(a4, 4);
                            this.f15210e.c(b2, a3);
                            e.b a8 = this.f15210e.a(b2, 8);
                            if (a7 == null) {
                                a(b3, b2, a4);
                            } else {
                                a(a4, b2, a7, a8, a5, a6);
                            }
                        }
                    }
                    this.f15210e.c(b2, a3);
                }
            }
            this.f15210e.a(this.ar);
        }
        this.f15211f.a(this.f15207b);
        n nVar2 = this.n;
        nVar2.f15269d = nVar2.f15268c;
        this.f15213h = false;
        n nVar3 = this.n;
        nVar3.f15273h = false;
        nVar3.f15274i = false;
        boolean unused = this.f15211f.f15220a = false;
        if (this.f15207b.f15244b != null) {
            this.f15207b.f15244b.clear();
        }
        r();
        a(false);
        this.f15210e.a();
        int[] iArr = this.ak;
        if (c(iArr[0], iArr[1])) {
            g();
        }
    }

    private void a(long j2, q qVar, q qVar2) {
        int a2 = this.f15209d.a();
        int i2 = 0;
        while (i2 < a2) {
            q b2 = b(this.f15209d.b(i2));
            if (b2 == qVar || b(b2) != j2) {
                i2++;
            } else {
                a aVar = this.y;
                if (aVar == null || !aVar.f15231b) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + b2 + " \n View SelectOtherBankHolder 2:" + qVar);
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + b2 + " \n View SelectOtherBankHolder 2:" + qVar);
            }
        }
        StringBuilder sb = new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        sb.append(qVar2);
        sb.append(" cannot be found but it is necessary for ");
        sb.append(qVar);
    }

    /* access modifiers changed from: private */
    public void a(q qVar, e.b bVar) {
        qVar.a(0, (int) FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        if (this.n.j && qVar.t() && !qVar.n() && !qVar.c()) {
            this.f15210e.a(b(qVar), qVar);
        }
        this.f15210e.a(qVar, bVar);
    }

    private void a(int[] iArr) {
        int a2 = this.f15209d.a();
        if (a2 == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            q b2 = b(this.f15209d.b(i4));
            if (!b2.c()) {
                int d2 = b2.d();
                if (d2 < i2) {
                    i2 = d2;
                }
                if (d2 > i3) {
                    i3 = d2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean c(int i2, int i3) {
        if (this.f15209d.a() == 0) {
            return (i2 == 0 && i3 == 0) ? false : true;
        }
        a(this.ak);
        int[] iArr = this.ak;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        q b2 = b(view);
        if (b2 != null) {
            if (b2.o()) {
                b2.j();
            } else if (!b2.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached.".concat(String.valueOf(b2)));
            }
        }
        e(view);
        super.removeDetachedView(view, z2);
    }

    private long b(q qVar) {
        if (this.y.f15231b) {
            return qVar.f15285d;
        }
        return (long) qVar.f15283b;
    }

    private void a(q qVar, q qVar2, e.b bVar, e.b bVar2, boolean z2, boolean z3) {
        qVar.a(false);
        if (z2) {
            a(qVar);
        }
        if (qVar != qVar2) {
            if (z3) {
                a(qVar2);
            }
            qVar.f15288g = qVar2;
            a(qVar);
            this.f15207b.b(qVar);
            qVar2.a(false);
            qVar2.f15289h = qVar;
        }
        if (this.m.a(qVar, qVar2, bVar, bVar2)) {
            u();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.d.m.a("RV OnLayout");
        x();
        androidx.core.d.m.a();
        this.f15212g = true;
    }

    public void requestLayout() {
        if (this.F != 0 || this.H) {
            this.G = true;
        } else {
            super.requestLayout();
        }
    }

    private void B() {
        int b2 = this.f15209d.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((LayoutParams) this.f15209d.c(i2).getLayoutParams()).f15227c = true;
        }
        j jVar = this.f15207b;
        int size = jVar.f15245c.size();
        for (int i3 = 0; i3 < size; i3++) {
            LayoutParams layoutParams = (LayoutParams) jVar.f15245c.get(i3).f15282a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f15227c = true;
            }
        }
    }

    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.A.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.A.get(i2);
        }
        androidx.core.widget.d dVar = this.f15214i;
        if (dVar == null || dVar.f3191a.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.v ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            androidx.core.widget.d dVar2 = this.f15214i;
            z2 = dVar2 != null && dVar2.a(canvas);
            canvas.restoreToCount(save);
        }
        androidx.core.widget.d dVar3 = this.j;
        if (dVar3 != null && !dVar3.f3191a.isFinished()) {
            int save2 = canvas.save();
            if (this.v) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            androidx.core.widget.d dVar4 = this.j;
            z2 |= dVar4 != null && dVar4.a(canvas);
            canvas.restoreToCount(save2);
        }
        androidx.core.widget.d dVar5 = this.k;
        if (dVar5 != null && !dVar5.f3191a.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.v ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            androidx.core.widget.d dVar6 = this.k;
            z2 |= dVar6 != null && dVar6.a(canvas);
            canvas.restoreToCount(save3);
        }
        androidx.core.widget.d dVar7 = this.l;
        if (dVar7 == null || dVar7.f3191a.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.v) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            androidx.core.widget.d dVar8 = this.l;
            if (dVar8 != null && dVar8.a(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.m != null && this.A.size() > 0 && this.m.b()) {
            z3 = true;
        }
        if (z3) {
            u.g(this);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.A.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A.get(i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && LayoutManager.a((LayoutParams) layoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.f15211f;
        if (layoutManager != null) {
            return layoutManager.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f15211f != null) {
            return LayoutManager.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.f15211f != null) {
            return LayoutManager.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    private void C() {
        int b2 = this.f15209d.b();
        for (int i2 = 0; i2 < b2; i2++) {
            q b3 = b(this.f15209d.c(i2));
            if (!b3.c()) {
                b3.b();
            }
        }
    }

    private void D() {
        int b2 = this.f15209d.b();
        for (int i2 = 0; i2 < b2; i2++) {
            q b3 = b(this.f15209d.c(i2));
            if (!b3.c()) {
                b3.a();
            }
        }
        this.f15207b.d();
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.f15209d.b();
        for (int i5 = 0; i5 < b2; i5++) {
            q b3 = b(this.f15209d.c(i5));
            if (b3 != null && !b3.c()) {
                if (b3.f15283b >= i4) {
                    b3.a(-i3, z2);
                    this.n.f15271f = true;
                } else if (b3.f15283b >= i2) {
                    b3.b(8);
                    b3.a(-i3, z2);
                    b3.f15283b = i2 - 1;
                    this.n.f15271f = true;
                }
            }
        }
        j jVar = this.f15207b;
        for (int size = jVar.f15245c.size() - 1; size >= 0; size--) {
            q qVar = jVar.f15245c.get(size);
            if (qVar != null) {
                if (qVar.f15283b >= i4) {
                    qVar.a(-i3, z2);
                } else if (qVar.f15283b >= i2) {
                    qVar.b(8);
                    jVar.b(size);
                }
            }
        }
        requestLayout();
    }

    private void E() {
        int b2 = this.f15209d.b();
        for (int i2 = 0; i2 < b2; i2++) {
            q b3 = b(this.f15209d.c(i2));
            if (b3 != null && !b3.c()) {
                b3.b(6);
            }
        }
        B();
        this.f15207b.c();
    }

    public final q a(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return b(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static q b(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f15225a;
    }

    public static int c(View view) {
        q b2 = b(view);
        if (b2 != null) {
            return b2.d();
        }
        return -1;
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public final Rect d(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f15227c) {
            return layoutParams.f15226b;
        }
        Rect rect = layoutParams.f15226b;
        rect.set(0, 0, 0, 0);
        int size = this.A.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.x.set(0, 0, 0, 0);
            this.A.get(i2);
            Rect rect2 = this.x;
            view.getLayoutParams();
            rect2.set(0, 0, 0, 0);
            rect.left += this.x.left;
            rect.top += this.x.top;
            rect.right += this.x.right;
            rect.bottom += this.x.bottom;
        }
        layoutParams.f15227c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        List<h> list = this.af;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.af.get(size);
            }
        }
    }

    class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f15275a;

        /* renamed from: b  reason: collision with root package name */
        int f15276b;

        /* renamed from: c  reason: collision with root package name */
        androidx.core.widget.h f15277c;

        /* renamed from: e  reason: collision with root package name */
        private Interpolator f15279e = RecyclerView.aq;

        /* renamed from: f  reason: collision with root package name */
        private boolean f15280f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f15281g = false;

        public p() {
            this.f15277c = androidx.core.widget.h.a(RecyclerView.this.getContext(), RecyclerView.aq);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f8, code lost:
            if (r12 > 0) goto L_0x00fc;
         */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r17 = this;
                r0 = r17
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$LayoutManager r1 = r1.f15211f
                if (r1 != 0) goto L_0x000c
                r17.b()
                return
            L_0x000c:
                r1 = 0
                r0.f15281g = r1
                r2 = 1
                r0.f15280f = r2
                com.paytm.recyclerview.RecyclerView r3 = com.paytm.recyclerview.RecyclerView.this
                r3.j()
                androidx.core.widget.h r3 = r0.f15277c
                com.paytm.recyclerview.RecyclerView r4 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$LayoutManager r4 = r4.f15211f
                com.paytm.recyclerview.RecyclerView$m r4 = r4.j
                android.widget.OverScroller r5 = r3.f3197a
                boolean r5 = r5.computeScrollOffset()
                if (r5 == 0) goto L_0x01b1
                android.widget.OverScroller r5 = r3.f3197a
                int r5 = r5.getCurrX()
                android.widget.OverScroller r6 = r3.f3197a
                int r6 = r6.getCurrY()
                int r7 = r0.f15275a
                int r7 = r5 - r7
                int r8 = r0.f15276b
                int r8 = r6 - r8
                r0.f15275a = r5
                r0.f15276b = r6
                com.paytm.recyclerview.RecyclerView r9 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$a r9 = r9.y
                if (r9 == 0) goto L_0x00b9
                com.paytm.recyclerview.RecyclerView r9 = com.paytm.recyclerview.RecyclerView.this
                r9.a()
                com.paytm.recyclerview.RecyclerView r9 = com.paytm.recyclerview.RecyclerView.this
                r9.q()
                java.lang.String r9 = "RV Scroll"
                androidx.core.d.m.a(r9)
                if (r7 == 0) goto L_0x006b
                com.paytm.recyclerview.RecyclerView r9 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$LayoutManager r9 = r9.f15211f
                com.paytm.recyclerview.RecyclerView r10 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$j r10 = r10.f15207b
                com.paytm.recyclerview.RecyclerView r11 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r11 = r11.n
                int r9 = r9.a((int) r7, (com.paytm.recyclerview.RecyclerView.j) r10, (com.paytm.recyclerview.RecyclerView.n) r11)
                int r10 = r7 - r9
                goto L_0x006d
            L_0x006b:
                r9 = 0
                r10 = 0
            L_0x006d:
                if (r8 == 0) goto L_0x0082
                com.paytm.recyclerview.RecyclerView r11 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$LayoutManager r11 = r11.f15211f
                com.paytm.recyclerview.RecyclerView r12 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$j r12 = r12.f15207b
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r13 = r13.n
                int r11 = r11.b((int) r8, (com.paytm.recyclerview.RecyclerView.j) r12, (com.paytm.recyclerview.RecyclerView.n) r13)
                int r12 = r8 - r11
                goto L_0x0084
            L_0x0082:
                r11 = 0
                r12 = 0
            L_0x0084:
                androidx.core.d.m.a()
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                r13.F()
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                r13.r()
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                r13.a((boolean) r1)
                if (r4 == 0) goto L_0x00bd
                boolean r13 = r4.f15253b
                if (r13 != 0) goto L_0x00bd
                boolean r13 = r4.f15254c
                if (r13 == 0) goto L_0x00bd
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r13 = r13.n
                int r13 = r13.a()
                if (r13 != 0) goto L_0x00ae
                r4.a()
                goto L_0x00bd
            L_0x00ae:
                int r14 = r4.f15252a
                if (r14 < r13) goto L_0x00b5
                int r13 = r13 - r2
                r4.f15252a = r13
            L_0x00b5:
                com.paytm.recyclerview.RecyclerView.m.a((com.paytm.recyclerview.RecyclerView.m) r4)
                goto L_0x00bd
            L_0x00b9:
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
            L_0x00bd:
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                java.util.ArrayList r13 = r13.A
                boolean r13 = r13.isEmpty()
                if (r13 != 0) goto L_0x00ce
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                r13.invalidate()
            L_0x00ce:
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                int r13 = androidx.core.h.u.a((android.view.View) r13)
                r14 = 2
                if (r13 == r14) goto L_0x00dc
                com.paytm.recyclerview.RecyclerView r13 = com.paytm.recyclerview.RecyclerView.this
                r13.b((int) r7, (int) r8)
            L_0x00dc:
                if (r10 != 0) goto L_0x00e0
                if (r12 == 0) goto L_0x0156
            L_0x00e0:
                android.widget.OverScroller r13 = r3.f3197a
                float r13 = r13.getCurrVelocity()
                int r13 = (int) r13
                if (r10 == r5) goto L_0x00f1
                if (r10 >= 0) goto L_0x00ed
                int r15 = -r13
                goto L_0x00f2
            L_0x00ed:
                if (r10 <= 0) goto L_0x00f1
                r15 = r13
                goto L_0x00f2
            L_0x00f1:
                r15 = 0
            L_0x00f2:
                if (r12 == r6) goto L_0x00fb
                if (r12 >= 0) goto L_0x00f8
                int r13 = -r13
                goto L_0x00fc
            L_0x00f8:
                if (r12 <= 0) goto L_0x00fb
                goto L_0x00fc
            L_0x00fb:
                r13 = 0
            L_0x00fc:
                com.paytm.recyclerview.RecyclerView r2 = com.paytm.recyclerview.RecyclerView.this
                int r2 = androidx.core.h.u.a((android.view.View) r2)
                if (r2 == r14) goto L_0x0139
                com.paytm.recyclerview.RecyclerView r2 = com.paytm.recyclerview.RecyclerView.this
                if (r15 >= 0) goto L_0x0112
                r2.b()
                androidx.core.widget.d r14 = r2.f15214i
                int r1 = -r15
                r14.a((int) r1)
                goto L_0x011c
            L_0x0112:
                if (r15 <= 0) goto L_0x011c
                r2.c()
                androidx.core.widget.d r1 = r2.k
                r1.a((int) r15)
            L_0x011c:
                if (r13 >= 0) goto L_0x0128
                r2.d()
                androidx.core.widget.d r1 = r2.j
                int r14 = -r13
                r1.a((int) r14)
                goto L_0x0132
            L_0x0128:
                if (r13 <= 0) goto L_0x0132
                r2.e()
                androidx.core.widget.d r1 = r2.l
                r1.a((int) r13)
            L_0x0132:
                if (r15 != 0) goto L_0x0136
                if (r13 == 0) goto L_0x0139
            L_0x0136:
                androidx.core.h.u.g(r2)
            L_0x0139:
                if (r15 != 0) goto L_0x0145
                if (r10 == r5) goto L_0x0145
                android.widget.OverScroller r1 = r3.f3197a
                int r1 = r1.getFinalX()
                if (r1 != 0) goto L_0x0156
            L_0x0145:
                if (r13 != 0) goto L_0x0151
                if (r12 == r6) goto L_0x0151
                android.widget.OverScroller r1 = r3.f3197a
                int r1 = r1.getFinalY()
                if (r1 != 0) goto L_0x0156
            L_0x0151:
                android.widget.OverScroller r1 = r3.f3197a
                r1.abortAnimation()
            L_0x0156:
                if (r9 != 0) goto L_0x015a
                if (r11 == 0) goto L_0x015f
            L_0x015a:
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                r1.g()
            L_0x015f:
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                boolean r1 = r1.awakenScrollBars()
                if (r1 != 0) goto L_0x016c
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                r1.invalidate()
            L_0x016c:
                if (r8 == 0) goto L_0x017c
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$LayoutManager r1 = r1.f15211f
                boolean r1 = r1.d()
                if (r1 == 0) goto L_0x017c
                if (r11 != r8) goto L_0x017c
                r1 = 1
                goto L_0x017d
            L_0x017c:
                r1 = 0
            L_0x017d:
                if (r7 == 0) goto L_0x018d
                com.paytm.recyclerview.RecyclerView r2 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$LayoutManager r2 = r2.f15211f
                boolean r2 = r2.c()
                if (r2 == 0) goto L_0x018d
                if (r9 != r7) goto L_0x018d
                r2 = 1
                goto L_0x018e
            L_0x018d:
                r2 = 0
            L_0x018e:
                if (r7 != 0) goto L_0x0192
                if (r8 == 0) goto L_0x019a
            L_0x0192:
                if (r2 != 0) goto L_0x019a
                if (r1 == 0) goto L_0x0197
                goto L_0x019a
            L_0x0197:
                r16 = 0
                goto L_0x019c
            L_0x019a:
                r16 = 1
            L_0x019c:
                android.widget.OverScroller r1 = r3.f3197a
                boolean r1 = r1.isFinished()
                if (r1 != 0) goto L_0x01ab
                if (r16 != 0) goto L_0x01a7
                goto L_0x01ab
            L_0x01a7:
                r17.a()
                goto L_0x01b1
            L_0x01ab:
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                r2 = 0
                r1.setScrollState(r2)
            L_0x01b1:
                if (r4 == 0) goto L_0x01c1
                boolean r1 = r4.f15253b
                if (r1 == 0) goto L_0x01ba
                com.paytm.recyclerview.RecyclerView.m.a((com.paytm.recyclerview.RecyclerView.m) r4)
            L_0x01ba:
                boolean r1 = r0.f15281g
                if (r1 != 0) goto L_0x01c1
                r4.a()
            L_0x01c1:
                r1 = 0
                r0.f15280f = r1
                boolean r1 = r0.f15281g
                if (r1 == 0) goto L_0x01cb
                r17.a()
            L_0x01cb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.RecyclerView.p.run():void");
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.f15280f) {
                this.f15281g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            u.a((View) RecyclerView.this, (Runnable) this);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3) {
            a(i2, i3, b(i2, i3));
        }

        private static float a(float f2) {
            return (float) Math.sin((double) ((float) (((double) (f2 - 0.5f)) * 0.4712389167638204d)));
        }

        private int b(int i2, int i3) {
            int i4;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt(0.0d);
            int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i3 * i3)));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i5;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i4 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i4 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i4, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY);
        }

        public final void a(int i2, int i3, int i4) {
            a(i2, i3, i4, RecyclerView.aq);
        }

        public final void a(int i2, int i3, int i4, Interpolator interpolator) {
            if (this.f15279e != interpolator) {
                this.f15279e = interpolator;
                this.f15277c = androidx.core.widget.h.a(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.f15276b = 0;
            this.f15275a = 0;
            this.f15277c.a(0, 0, i2, i3, i4);
            a();
        }

        public final void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f15277c.f3197a.abortAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        int a2 = this.f15209d.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View b2 = this.f15209d.b(i2);
            q a3 = a(b2);
            if (!(a3 == null || a3.f15289h == null)) {
                View view = a3.f15289h.f15282a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    class l extends c {
        private l() {
        }

        /* synthetic */ l(RecyclerView recyclerView, byte b2) {
            this();
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<ArrayList<q>> f15240a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        int f15241b = 0;

        /* renamed from: c  reason: collision with root package name */
        private SparseIntArray f15242c = new SparseIntArray();

        public final q a() {
            ArrayList arrayList = this.f15240a.get(0);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            q qVar = (q) arrayList.get(size);
            arrayList.remove(size);
            return qVar;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f15241b++;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.f15241b--;
        }

        public final void a(q qVar) {
            int i2 = qVar.f15286e;
            ArrayList arrayList = this.f15240a.get(i2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f15240a.put(i2, arrayList);
                if (this.f15242c.indexOfKey(i2) < 0) {
                    this.f15242c.put(i2, 5);
                }
            }
            if (this.f15242c.get(i2) > arrayList.size()) {
                qVar.r();
                arrayList.add(qVar);
            }
        }
    }

    public final class j {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<q> f15243a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<q> f15244b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<q> f15245c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final List<q> f15246d = Collections.unmodifiableList(this.f15243a);

        /* renamed from: e  reason: collision with root package name */
        int f15247e = 2;

        /* renamed from: f  reason: collision with root package name */
        i f15248f;

        /* renamed from: g  reason: collision with root package name */
        o f15249g;

        public j() {
        }

        public final void a() {
            this.f15243a.clear();
            e();
        }

        private boolean c(q qVar) {
            if (qVar.n()) {
                return RecyclerView.this.n.f15272g;
            }
            if (qVar.f15283b < 0 || qVar.f15283b >= RecyclerView.this.y.c()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position".concat(String.valueOf(qVar)));
            }
            if (!RecyclerView.this.n.f15272g) {
                a unused = RecyclerView.this.y;
                if (qVar.f15286e != 0) {
                    return false;
                }
            }
            if (!RecyclerView.this.y.f15231b) {
                return true;
            }
            long j = qVar.f15285d;
            a unused2 = RecyclerView.this.y;
            if (j == -1) {
                return true;
            }
            return false;
        }

        public final View a(int i2) {
            return c(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0121  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x013e  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0141  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0181  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x018f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.view.View c(int r8) {
            /*
                r7 = this;
                if (r8 < 0) goto L_0x01b4
                com.paytm.recyclerview.RecyclerView r0 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r0 = r0.n
                int r0 = r0.a()
                if (r8 >= r0) goto L_0x01b4
                com.paytm.recyclerview.RecyclerView r0 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r0 = r0.n
                boolean r0 = r0.f15272g
                r1 = 0
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x001f
                com.paytm.recyclerview.RecyclerView$q r0 = r7.d((int) r8)
                if (r0 == 0) goto L_0x0020
                r4 = 1
                goto L_0x0021
            L_0x001f:
                r0 = r1
            L_0x0020:
                r4 = 0
            L_0x0021:
                if (r0 != 0) goto L_0x0053
                com.paytm.recyclerview.RecyclerView$q r0 = r7.e((int) r8)
                if (r0 == 0) goto L_0x0053
                boolean r5 = r7.c((com.paytm.recyclerview.RecyclerView.q) r0)
                if (r5 != 0) goto L_0x0052
                r5 = 4
                r0.b((int) r5)
                boolean r5 = r0.f()
                if (r5 == 0) goto L_0x0044
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                android.view.View r6 = r0.f15282a
                r5.removeDetachedView(r6, r3)
                r0.g()
                goto L_0x004d
            L_0x0044:
                boolean r5 = r0.h()
                if (r5 == 0) goto L_0x004d
                r0.i()
            L_0x004d:
                r7.a((com.paytm.recyclerview.RecyclerView.q) r0)
                r0 = r1
                goto L_0x0053
            L_0x0052:
                r4 = 1
            L_0x0053:
                if (r0 != 0) goto L_0x0104
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.a r1 = r1.f15208c
                int r1 = r1.b((int) r8)
                if (r1 < 0) goto L_0x00d8
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$a r5 = r5.y
                int r5 = r5.c()
                if (r1 >= r5) goto L_0x00d8
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView.a unused = r5.y
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$a r5 = r5.y
                boolean r5 = r5.f15231b
                if (r5 == 0) goto L_0x0088
                com.paytm.recyclerview.RecyclerView r0 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView.a unused = r0.y
                com.paytm.recyclerview.RecyclerView$q r0 = r7.f()
                if (r0 == 0) goto L_0x0088
                r0.f15283b = r1
                r4 = 1
            L_0x0088:
                if (r0 != 0) goto L_0x00b3
                com.paytm.recyclerview.RecyclerView$o r1 = r7.f15249g
                if (r1 == 0) goto L_0x00b3
                android.view.View r1 = r1.a()
                if (r1 == 0) goto L_0x00b3
                com.paytm.recyclerview.RecyclerView r0 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$q r0 = r0.a((android.view.View) r1)
                if (r0 == 0) goto L_0x00ab
                boolean r1 = r0.c()
                if (r1 != 0) goto L_0x00a3
                goto L_0x00b3
            L_0x00a3:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r8.<init>(r0)
                throw r8
            L_0x00ab:
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r8.<init>(r0)
                throw r8
            L_0x00b3:
                if (r0 != 0) goto L_0x00cb
                com.paytm.recyclerview.RecyclerView$i r0 = r7.b()
                com.paytm.recyclerview.RecyclerView$q r0 = r0.a()
                if (r0 == 0) goto L_0x00cb
                r0.r()
                boolean r1 = com.paytm.recyclerview.RecyclerView.r
                if (r1 == 0) goto L_0x00cb
                r7.d((com.paytm.recyclerview.RecyclerView.q) r0)
            L_0x00cb:
                if (r0 != 0) goto L_0x0104
                com.paytm.recyclerview.RecyclerView r0 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$a r0 = r0.y
                com.paytm.recyclerview.RecyclerView$q r0 = r0.b()
                goto L_0x0104
            L_0x00d8:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "Inconsistency detected. Invalid item position "
                r2.<init>(r3)
                r2.append(r8)
                java.lang.String r8 = "(offset:"
                r2.append(r8)
                r2.append(r1)
                java.lang.String r8 = ").state:"
                r2.append(r8)
                com.paytm.recyclerview.RecyclerView r8 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r8 = r8.n
                int r8 = r8.a()
                r2.append(r8)
                java.lang.String r8 = r2.toString()
                r0.<init>(r8)
                throw r0
            L_0x0104:
                if (r4 == 0) goto L_0x0130
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r1 = r1.n
                boolean r1 = r1.f15272g
                if (r1 != 0) goto L_0x0130
                r1 = 8192(0x2000, float:1.14794E-41)
                boolean r5 = r0.a((int) r1)
                if (r5 == 0) goto L_0x0130
                r0.a((int) r3, (int) r1)
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r1 = r1.n
                boolean r1 = r1.f15273h
                if (r1 == 0) goto L_0x0130
                com.paytm.recyclerview.RecyclerView.e.e(r0)
                r0.q()
                com.paytm.recyclerview.RecyclerView$e$b r1 = com.paytm.recyclerview.RecyclerView.e.d(r0)
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                r5.a((com.paytm.recyclerview.RecyclerView.q) r0, (com.paytm.recyclerview.RecyclerView.e.b) r1)
            L_0x0130:
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r1 = r1.n
                boolean r1 = r1.f15272g
                if (r1 == 0) goto L_0x0141
                boolean r1 = r0.m()
                if (r1 == 0) goto L_0x0141
                r0.f15287f = r8
                goto L_0x0154
            L_0x0141:
                boolean r1 = r0.m()
                if (r1 == 0) goto L_0x0156
                boolean r1 = r0.l()
                if (r1 != 0) goto L_0x0156
                boolean r1 = r0.k()
                if (r1 == 0) goto L_0x0154
                goto L_0x0156
            L_0x0154:
                r8 = 0
                goto L_0x0179
            L_0x0156:
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.a r1 = r1.f15208c
                int r1 = r1.b((int) r8)
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                r0.k = r5
                com.paytm.recyclerview.RecyclerView$a r5 = r5.y
                r5.a(r0, r1)
                android.view.View r1 = r0.f15282a
                r7.d((android.view.View) r1)
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r1 = r1.n
                boolean r1 = r1.f15272g
                if (r1 == 0) goto L_0x0178
                r0.f15287f = r8
            L_0x0178:
                r8 = 1
            L_0x0179:
                android.view.View r1 = r0.f15282a
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x018f
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                com.paytm.recyclerview.RecyclerView$LayoutParams r1 = (com.paytm.recyclerview.RecyclerView.LayoutParams) r1
                android.view.View r5 = r0.f15282a
                r5.setLayoutParams(r1)
                goto L_0x01a7
            L_0x018f:
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                boolean r5 = r5.checkLayoutParams(r1)
                if (r5 != 0) goto L_0x01a5
                com.paytm.recyclerview.RecyclerView r5 = com.paytm.recyclerview.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r5.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                com.paytm.recyclerview.RecyclerView$LayoutParams r1 = (com.paytm.recyclerview.RecyclerView.LayoutParams) r1
                android.view.View r5 = r0.f15282a
                r5.setLayoutParams(r1)
                goto L_0x01a7
            L_0x01a5:
                com.paytm.recyclerview.RecyclerView$LayoutParams r1 = (com.paytm.recyclerview.RecyclerView.LayoutParams) r1
            L_0x01a7:
                r1.f15225a = r0
                if (r4 == 0) goto L_0x01ae
                if (r8 == 0) goto L_0x01ae
                goto L_0x01af
            L_0x01ae:
                r2 = 0
            L_0x01af:
                r1.f15228d = r2
                android.view.View r8 = r0.f15282a
                return r8
            L_0x01b4:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Invalid item position "
                r1.<init>(r2)
                r1.append(r8)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r8)
                java.lang.String r8 = "). Item count:"
                r1.append(r8)
                com.paytm.recyclerview.RecyclerView r8 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$n r8 = r8.n
                int r8 = r8.a()
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                r0.<init>(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.RecyclerView.j.c(int):android.view.View");
        }

        private void d(View view) {
            if (RecyclerView.this.f()) {
                if (u.h(view) == 0) {
                    u.c(view, 1);
                }
                if (!u.d(view)) {
                    u.a(view, RecyclerView.this.ai.f15354b);
                }
            }
        }

        private void d(q qVar) {
            if (qVar.f15282a instanceof ViewGroup) {
                a((ViewGroup) qVar.f15282a, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void a(View view) {
            q b2 = RecyclerView.b(view);
            if (b2.o()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (b2.f()) {
                b2.g();
            } else if (b2.h()) {
                b2.i();
            }
            a(b2);
        }

        private void e() {
            for (int size = this.f15245c.size() - 1; size >= 0; size--) {
                b(size);
            }
            this.f15245c.clear();
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2) {
            e(this.f15245c.get(i2));
            this.f15245c.remove(i2);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.paytm.recyclerview.RecyclerView.q r6) {
            /*
                r5 = this;
                boolean r0 = r6.f()
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x008b
                android.view.View r0 = r6.f15282a
                android.view.ViewParent r0 = r0.getParent()
                if (r0 == 0) goto L_0x0012
                goto L_0x008b
            L_0x0012:
                boolean r0 = r6.o()
                if (r0 != 0) goto L_0x007b
                boolean r0 = r6.c()
                if (r0 != 0) goto L_0x0073
                boolean r0 = com.paytm.recyclerview.RecyclerView.q.c(r6)
                com.paytm.recyclerview.RecyclerView r3 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView$a r3 = r3.y
                if (r3 == 0) goto L_0x0031
                if (r0 == 0) goto L_0x0031
                com.paytm.recyclerview.RecyclerView r3 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.RecyclerView.a unused = r3.y
            L_0x0031:
                boolean r3 = r6.s()
                if (r3 == 0) goto L_0x0061
                r3 = 14
                boolean r3 = r6.a((int) r3)
                if (r3 != 0) goto L_0x0059
                java.util.ArrayList<com.paytm.recyclerview.RecyclerView$q> r3 = r5.f15245c
                int r3 = r3.size()
                int r4 = r5.f15247e
                if (r3 != r4) goto L_0x004e
                if (r3 <= 0) goto L_0x004e
                r5.b((int) r2)
            L_0x004e:
                int r4 = r5.f15247e
                if (r3 >= r4) goto L_0x0059
                java.util.ArrayList<com.paytm.recyclerview.RecyclerView$q> r3 = r5.f15245c
                r3.add(r6)
                r3 = 1
                goto L_0x005a
            L_0x0059:
                r3 = 0
            L_0x005a:
                if (r3 != 0) goto L_0x0062
                r5.e((com.paytm.recyclerview.RecyclerView.q) r6)
                r2 = 1
                goto L_0x0062
            L_0x0061:
                r3 = 0
            L_0x0062:
                com.paytm.recyclerview.RecyclerView r1 = com.paytm.recyclerview.RecyclerView.this
                com.paytm.recyclerview.i r1 = r1.f15210e
                r1.e(r6)
                if (r3 != 0) goto L_0x0072
                if (r2 != 0) goto L_0x0072
                if (r0 == 0) goto L_0x0072
                r0 = 0
                r6.k = r0
            L_0x0072:
                return
            L_0x0073:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle."
                r6.<init>(r0)
                throw r6
            L_0x007b:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r6 = java.lang.String.valueOf(r6)
                java.lang.String r1 = "Tmp detached view should be removed from RecyclerView before it can be recycled: "
                java.lang.String r6 = r1.concat(r6)
                r0.<init>(r6)
                throw r0
            L_0x008b:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Scrapped or attached views may not be recycled. isScrap:"
                r3.<init>(r4)
                boolean r4 = r6.f()
                r3.append(r4)
                java.lang.String r4 = " isAttached:"
                r3.append(r4)
                android.view.View r6 = r6.f15282a
                android.view.ViewParent r6 = r6.getParent()
                if (r6 == 0) goto L_0x00a9
                goto L_0x00aa
            L_0x00a9:
                r1 = 0
            L_0x00aa:
                r3.append(r1)
                java.lang.String r6 = r3.toString()
                r0.<init>(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.RecyclerView.j.a(com.paytm.recyclerview.RecyclerView$q):void");
        }

        private void e(q qVar) {
            u.a(qVar.f15282a, (androidx.core.h.a) null);
            f(qVar);
            qVar.k = null;
            b().a(qVar);
        }

        /* access modifiers changed from: package-private */
        public final void b(View view) {
            q b2 = RecyclerView.b(view);
            j unused = b2.o = null;
            boolean unused2 = b2.p = false;
            b2.i();
            a(b2);
        }

        /* access modifiers changed from: package-private */
        public final void c(View view) {
            q b2 = RecyclerView.b(view);
            if (!b2.a(12) && b2.t() && !RecyclerView.a(RecyclerView.this, b2)) {
                if (this.f15244b == null) {
                    this.f15244b = new ArrayList<>();
                }
                b2.a(this, true);
                this.f15244b.add(b2);
            } else if (!b2.k() || b2.n() || RecyclerView.this.y.f15231b) {
                b2.a(this, false);
                this.f15243a.add(b2);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(q qVar) {
            if (qVar.p) {
                this.f15244b.remove(qVar);
            } else {
                this.f15243a.remove(qVar);
            }
            j unused = qVar.o = null;
            boolean unused2 = qVar.p = false;
            qVar.i();
        }

        private q d(int i2) {
            int size;
            int a2;
            ArrayList<q> arrayList = this.f15244b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    q qVar = this.f15244b.get(i4);
                    if (qVar.h() || qVar.d() != i2) {
                        i4++;
                    } else {
                        qVar.b(32);
                        return qVar;
                    }
                }
                if (RecyclerView.this.y.f15231b && (a2 = RecyclerView.this.f15208c.a(i2, 0)) > 0 && a2 < RecyclerView.this.y.c()) {
                    a unused = RecyclerView.this.y;
                    while (i3 < size) {
                        q qVar2 = this.f15244b.get(i3);
                        if (qVar2.h() || qVar2.f15285d != -1) {
                            i3++;
                        } else {
                            qVar2.b(32);
                            return qVar2;
                        }
                    }
                }
            }
            return null;
        }

        private q e(int i2) {
            View view;
            int size = this.f15243a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                q qVar = this.f15243a.get(i4);
                if (qVar.h() || qVar.d() != i2 || qVar.k() || (!RecyclerView.this.n.f15272g && qVar.n())) {
                    i4++;
                } else {
                    qVar.b(32);
                    return qVar;
                }
            }
            b bVar = RecyclerView.this.f15209d;
            int size2 = bVar.f15305c.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size2) {
                    view = null;
                    break;
                }
                view = bVar.f15305c.get(i5);
                q b2 = bVar.f15303a.b(view);
                if (b2.d() == i2 && !b2.k() && !b2.n()) {
                    break;
                }
                i5++;
            }
            if (view != null) {
                q b3 = RecyclerView.b(view);
                b bVar2 = RecyclerView.this.f15209d;
                int a2 = bVar2.f15303a.a(view);
                if (a2 < 0) {
                    throw new IllegalArgumentException("view is not a child, cannot OnPayChannelRecyclerViewHide ".concat(String.valueOf(view)));
                } else if (bVar2.f15304b.c(a2)) {
                    bVar2.f15304b.b(a2);
                    bVar2.b(view);
                    int c2 = RecyclerView.this.f15209d.c(view);
                    if (c2 != -1) {
                        RecyclerView.this.f15209d.d(c2);
                        c(view);
                        b3.b(8224);
                        return b3;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:".concat(String.valueOf(b3)));
                } else {
                    throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
                }
            } else {
                int size3 = this.f15245c.size();
                while (i3 < size3) {
                    q qVar2 = this.f15245c.get(i3);
                    if (qVar2.k() || qVar2.d() != i2) {
                        i3++;
                    } else {
                        this.f15245c.remove(i3);
                        return qVar2;
                    }
                }
                return null;
            }
        }

        private q f() {
            int size = this.f15243a.size();
            while (true) {
                size--;
                if (size >= 0) {
                    q qVar = this.f15243a.get(size);
                    if (qVar.f15285d == -1 && !qVar.h()) {
                        if (qVar.f15286e == 0) {
                            qVar.b(32);
                            if (qVar.n() && !RecyclerView.this.n.f15272g) {
                                qVar.a(2, 14);
                            }
                            return qVar;
                        }
                        this.f15243a.remove(size);
                        RecyclerView.this.removeDetachedView(qVar.f15282a, false);
                        b(qVar.f15282a);
                    }
                } else {
                    for (int size2 = this.f15245c.size() - 1; size2 >= 0; size2--) {
                        q qVar2 = this.f15245c.get(size2);
                        if (qVar2.f15285d == -1) {
                            if (qVar2.f15286e == 0) {
                                this.f15245c.remove(size2);
                                return qVar2;
                            }
                            b(size2);
                        }
                    }
                    return null;
                }
            }
        }

        private void f(q qVar) {
            if (RecyclerView.this.z != null) {
                k unused = RecyclerView.this.z;
            }
            if (RecyclerView.this.y != null) {
                a unused2 = RecyclerView.this.y;
            }
            if (RecyclerView.this.n != null) {
                RecyclerView.this.f15210e.e(qVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final i b() {
            if (this.f15248f == null) {
                this.f15248f = new i();
            }
            return this.f15248f;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            if (RecyclerView.this.y == null || !RecyclerView.this.y.f15231b) {
                e();
                return;
            }
            int size = this.f15245c.size();
            for (int i2 = 0; i2 < size; i2++) {
                q qVar = this.f15245c.get(i2);
                if (qVar != null) {
                    qVar.b(6);
                    qVar.a((Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            int size = this.f15245c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f15245c.get(i2).a();
            }
            int size2 = this.f15243a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f15243a.get(i3).a();
            }
            ArrayList<q> arrayList = this.f15244b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f15244b.get(i4).a();
                }
            }
        }
    }

    public static abstract class a<VH extends q> {

        /* renamed from: a  reason: collision with root package name */
        final b f15230a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15231b;

        public abstract VH a();

        public abstract int c();

        public final VH b() {
            androidx.core.d.m.a("RV CreateView");
            VH a2 = a();
            a2.f15286e = 0;
            androidx.core.d.m.a();
            return a2;
        }

        public final void a(VH vh, int i2) {
            vh.f15283b = i2;
            if (this.f15231b) {
                vh.f15285d = -1;
            }
            vh.a(1, 519);
            androidx.core.d.m.a("RV OnBindView");
            vh.q();
            vh.p();
            androidx.core.d.m.a();
        }
    }

    /* access modifiers changed from: private */
    public void e(View view) {
        b(view);
        List<Object> list = this.N;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.N.get(size);
            }
        }
    }

    public static abstract class LayoutManager {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f15220a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f15221b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15222c = true;

        /* renamed from: h  reason: collision with root package name */
        b f15223h;

        /* renamed from: i  reason: collision with root package name */
        RecyclerView f15224i;
        m j;
        boolean k = false;
        int l;
        int m;
        int n;
        int o;

        public static class Properties {
        }

        public static boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public int a(int i2, j jVar, n nVar) {
            return 0;
        }

        public int a(n nVar) {
            return 0;
        }

        public abstract LayoutParams a();

        public void a(Parcelable parcelable) {
        }

        public void a(j jVar, n nVar) {
        }

        public void a(RecyclerView recyclerView, j jVar) {
        }

        public int b(int i2, j jVar, n nVar) {
            return 0;
        }

        public int b(n nVar) {
            return 0;
        }

        public Parcelable b() {
            return null;
        }

        public void b(int i2) {
        }

        public int c(n nVar) {
            return 0;
        }

        public View c(int i2, j jVar, n nVar) {
            return null;
        }

        public boolean c() {
            return false;
        }

        public int d(n nVar) {
            return 0;
        }

        public boolean d() {
            return false;
        }

        public int e(n nVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return false;
        }

        public int f(n nVar) {
            return 0;
        }

        public boolean f() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void a(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f15224i = null;
                this.f15223h = null;
                this.n = 0;
                this.o = 0;
            } else {
                this.f15224i = recyclerView;
                this.f15223h = recyclerView.f15209d;
                this.n = recyclerView.getWidth();
                this.o = recyclerView.getHeight();
            }
            this.l = 1073741824;
            this.m = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3) {
            this.n = View.MeasureSpec.getSize(i2);
            this.l = View.MeasureSpec.getMode(i2);
            if (this.l == 0 && !RecyclerView.f15206a) {
                this.n = 0;
            }
            this.o = View.MeasureSpec.getSize(i3);
            this.m = View.MeasureSpec.getMode(i3);
            if (this.m == 0 && !RecyclerView.f15206a) {
                this.o = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2, int i3) {
            int h2 = h();
            if (h2 == 0) {
                this.f15224i.a(i2, i3);
                return;
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < h2; i8++) {
                View e2 = e(i8);
                LayoutParams layoutParams = (LayoutParams) e2.getLayoutParams();
                int e3 = e(e2) - layoutParams.leftMargin;
                int g2 = g(e2) + layoutParams.rightMargin;
                int f2 = f(e2) - layoutParams.topMargin;
                int h3 = h(e2) + layoutParams.bottomMargin;
                if (e3 < i4) {
                    i4 = e3;
                }
                if (g2 > i6) {
                    i6 = g2;
                }
                if (f2 < i5) {
                    i5 = f2;
                }
                if (h3 > i7) {
                    i7 = h3;
                }
            }
            this.f15224i.x.set(i4, i5, i6, i7);
            a(this.f15224i.x, i2, i3);
        }

        private void a(Rect rect, int i2, int i3) {
            e(a(i2, rect.width() + i() + k(), u.q(this.f15224i)), a(i3, rect.height() + j() + l(), u.r(this.f15224i)));
        }

        public final void g() {
            RecyclerView recyclerView = this.f15224i;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int a(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        /* access modifiers changed from: package-private */
        public final void b(RecyclerView recyclerView, j jVar) {
            this.k = false;
            a(recyclerView, jVar);
        }

        public static LayoutParams a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public static LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public final void a(View view, int i2) {
            a(view, i2, true);
        }

        public final void b(View view, int i2) {
            a(view, i2, false);
        }

        private void a(View view, int i2, boolean z) {
            q b2 = RecyclerView.b(view);
            if (z || b2.n()) {
                this.f15224i.f15210e.c(b2);
            } else {
                this.f15224i.f15210e.d(b2);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (b2.h() || b2.f()) {
                if (b2.f()) {
                    b2.g();
                } else {
                    b2.i();
                }
                this.f15223h.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f15224i) {
                int c2 = this.f15223h.c(view);
                if (i2 == -1) {
                    i2 = this.f15223h.a();
                }
                if (c2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f15224i.indexOfChild(view));
                } else if (c2 != i2) {
                    this.f15224i.f15211f.d(c2, i2);
                }
            } else {
                this.f15223h.a(view, i2, false);
                layoutParams.f15227c = true;
                m mVar = this.j;
                if (mVar != null && mVar.f15254c) {
                    this.j.a(view);
                }
            }
            if (layoutParams.f15228d) {
                b2.f15282a.invalidate();
                layoutParams.f15228d = false;
            }
        }

        public final void c(int i2) {
            if (e(i2) != null) {
                this.f15223h.a(i2);
            }
        }

        public static int a(View view) {
            return ((LayoutParams) view.getLayoutParams()).f15225a.d();
        }

        public View a(int i2) {
            int h2 = h();
            for (int i3 = 0; i3 < h2; i3++) {
                View e2 = e(i3);
                q b2 = RecyclerView.b(e2);
                if (b2 != null && b2.d() == i2 && !b2.c() && (this.f15224i.n.f15272g || !b2.n())) {
                    return e2;
                }
            }
            return null;
        }

        public final void d(int i2) {
            e(i2);
            f(i2);
        }

        private void f(int i2) {
            this.f15223h.d(i2);
        }

        private void c(View view, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            q b2 = RecyclerView.b(view);
            if (b2.n()) {
                this.f15224i.f15210e.c(b2);
            } else {
                this.f15224i.f15210e.d(b2);
            }
            this.f15223h.a(view, i2, layoutParams, b2.n());
        }

        private void d(int i2, int i3) {
            View e2 = e(i2);
            if (e2 != null) {
                d(i2);
                c(e2, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:".concat(String.valueOf(i2)));
        }

        public final void a(int i2, j jVar) {
            View e2 = e(i2);
            c(i2);
            jVar.a(e2);
        }

        public final int h() {
            b bVar = this.f15223h;
            if (bVar != null) {
                return bVar.a();
            }
            return 0;
        }

        public final View e(int i2) {
            b bVar = this.f15223h;
            if (bVar != null) {
                return bVar.b(i2);
            }
            return null;
        }

        public final int i() {
            RecyclerView recyclerView = this.f15224i;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public final int j() {
            RecyclerView recyclerView = this.f15224i;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public final int k() {
            RecyclerView recyclerView = this.f15224i;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public final int l() {
            RecyclerView recyclerView = this.f15224i;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        private boolean a(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.f15222c || !b(view.getWidth(), i2, layoutParams.width) || !b(view.getHeight(), i3, layoutParams.height);
        }

        private static boolean b(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public final void b(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect d2 = this.f15224i.d(view);
            int a2 = a(this.n, this.l, i() + k() + layoutParams.leftMargin + layoutParams.rightMargin + d2.left + d2.right + 0, layoutParams.width, c());
            int a3 = a(this.o, this.m, j() + l() + layoutParams.topMargin + layoutParams.bottomMargin + d2.top + d2.bottom + 0, layoutParams.height, d());
            if (a(view, a2, a3, layoutParams)) {
                view.measure(a2, a3);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002e
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002e
                if (r5 == r3) goto L_0x0021
                goto L_0x002e
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r6 = 1073741824(0x40000000, float:2.0)
                goto L_0x002f
            L_0x001f:
                if (r7 != r1) goto L_0x0024
            L_0x0021:
                r7 = r4
                r6 = r5
                goto L_0x002f
            L_0x0024:
                if (r7 != r0) goto L_0x002e
                if (r5 == r2) goto L_0x002a
                if (r5 != r3) goto L_0x002c
            L_0x002a:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
            L_0x002c:
                r7 = r4
                goto L_0x002f
            L_0x002e:
                r7 = 0
            L_0x002f:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.recyclerview.RecyclerView.LayoutManager.a(int, int, int, int, boolean):int");
        }

        public static int c(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f15226b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public static int d(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f15226b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public static void a(View view, int i2, int i3, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f15226b;
            view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
        }

        public static int e(View view) {
            return view.getLeft() - k(view);
        }

        public static int f(View view) {
            return view.getTop() - i(view);
        }

        public static int g(View view) {
            return view.getRight() + l(view);
        }

        public static int h(View view) {
            return view.getBottom() + j(view);
        }

        private static int i(View view) {
            return ((LayoutParams) view.getLayoutParams()).f15226b.top;
        }

        private static int j(View view) {
            return ((LayoutParams) view.getLayoutParams()).f15226b.bottom;
        }

        private static int k(View view) {
            return ((LayoutParams) view.getLayoutParams()).f15226b.left;
        }

        private static int l(View view) {
            return ((LayoutParams) view.getLayoutParams()).f15226b.right;
        }

        public final void c(int i2, int i3) {
            this.f15224i.a(i2, i3);
        }

        private void e(int i2, int i3) {
            this.f15224i.setMeasuredDimension(i2, i3);
        }

        /* access modifiers changed from: package-private */
        public final void m() {
            m mVar = this.j;
            if (mVar != null) {
                mVar.a();
            }
        }

        public final void b(j jVar) {
            for (int h2 = h() - 1; h2 >= 0; h2--) {
                if (!RecyclerView.b(e(h2)).c()) {
                    a(h2, jVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void b(RecyclerView recyclerView) {
            a(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public final void a(j jVar) {
            int size = jVar.f15243a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = jVar.f15243a.get(i2).f15282a;
                q b2 = RecyclerView.b(view);
                if (!b2.c()) {
                    b2.a(false);
                    if (b2.o()) {
                        this.f15224i.removeDetachedView(view, false);
                    }
                    if (this.f15224i.m != null) {
                        this.f15224i.m.c(b2);
                    }
                    b2.a(true);
                    jVar.b(view);
                }
            }
            jVar.f15243a.clear();
            if (jVar.f15244b != null) {
                jVar.f15244b.clear();
            }
            if (size > 0) {
                this.f15224i.invalidate();
            }
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            androidx.core.h.a.e a2 = androidx.core.h.a.b.a(accessibilityEvent);
            RecyclerView recyclerView = this.f15224i;
            if (recyclerView != null) {
                boolean z = true;
                if (!u.b((View) recyclerView, 1) && !u.b((View) this.f15224i, -1) && !u.a((View) this.f15224i, -1) && !u.a((View) this.f15224i, 1)) {
                    z = false;
                }
                a2.f3058a.setScrollable(z);
                if (this.f15224i.y != null) {
                    a2.f3058a.setItemCount(this.f15224i.y.c());
                }
            }
        }

        static /* synthetic */ void a(LayoutManager layoutManager, m mVar) {
            if (layoutManager.j == mVar) {
                layoutManager.j = null;
            }
        }
    }

    public static abstract class q {
        private static final List<Object> m = Collections.EMPTY_LIST;

        /* renamed from: a  reason: collision with root package name */
        public final View f15282a;

        /* renamed from: b  reason: collision with root package name */
        int f15283b;

        /* renamed from: c  reason: collision with root package name */
        int f15284c;

        /* renamed from: d  reason: collision with root package name */
        long f15285d;

        /* renamed from: e  reason: collision with root package name */
        int f15286e;

        /* renamed from: f  reason: collision with root package name */
        int f15287f;

        /* renamed from: g  reason: collision with root package name */
        q f15288g;

        /* renamed from: h  reason: collision with root package name */
        q f15289h;

        /* renamed from: i  reason: collision with root package name */
        List<Object> f15290i;
        List<Object> j;
        RecyclerView k;
        /* access modifiers changed from: private */
        public int l;
        private int n;
        /* access modifiers changed from: private */
        public j o;
        /* access modifiers changed from: private */
        public boolean p;
        private int q;

        /* access modifiers changed from: package-private */
        public final void a(int i2, boolean z) {
            if (this.f15284c == -1) {
                this.f15284c = this.f15283b;
            }
            if (this.f15287f == -1) {
                this.f15287f = this.f15283b;
            }
            if (z) {
                this.f15287f += i2;
            }
            this.f15283b += i2;
            if (this.f15282a.getLayoutParams() != null) {
                ((LayoutParams) this.f15282a.getLayoutParams()).f15227c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f15284c = -1;
            this.f15287f = -1;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            if (this.f15284c == -1) {
                this.f15284c = this.f15283b;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean c() {
            return (this.l & 128) != 0;
        }

        public final int d() {
            int i2 = this.f15287f;
            return i2 == -1 ? this.f15283b : i2;
        }

        public final int e() {
            RecyclerView recyclerView = this.k;
            if (recyclerView == null) {
                return -1;
            }
            return RecyclerView.b(recyclerView, this);
        }

        /* access modifiers changed from: package-private */
        public final boolean f() {
            return this.o != null;
        }

        /* access modifiers changed from: package-private */
        public final void g() {
            this.o.b(this);
        }

        /* access modifiers changed from: package-private */
        public final boolean h() {
            return (this.l & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void i() {
            this.l &= -33;
        }

        /* access modifiers changed from: package-private */
        public final void j() {
            this.l &= -257;
        }

        /* access modifiers changed from: package-private */
        public final void a(j jVar, boolean z) {
            this.o = jVar;
            this.p = z;
        }

        /* access modifiers changed from: package-private */
        public final boolean k() {
            return (this.l & 4) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean l() {
            return (this.l & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean m() {
            return (this.l & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean n() {
            return (this.l & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(int i2) {
            return (i2 & this.l) != 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean o() {
            return (this.l & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0;
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3) {
            this.l = (i2 & i3) | (this.l & (~i3));
        }

        /* access modifiers changed from: package-private */
        public final void b(int i2) {
            this.l = i2 | this.l;
        }

        /* access modifiers changed from: package-private */
        public final void a(Object obj) {
            if (obj == null) {
                b((int) TarConstants.EOF_BLOCK);
            } else if ((1024 & this.l) == 0) {
                u();
                this.f15290i.add(obj);
            }
        }

        private void u() {
            if (this.f15290i == null) {
                this.f15290i = new ArrayList();
                this.j = Collections.unmodifiableList(this.f15290i);
            }
        }

        /* access modifiers changed from: package-private */
        public final void p() {
            List<Object> list = this.f15290i;
            if (list != null) {
                list.clear();
            }
            this.l &= -1025;
        }

        /* access modifiers changed from: package-private */
        public final List<Object> q() {
            if ((this.l & TarConstants.EOF_BLOCK) != 0) {
                return m;
            }
            List<Object> list = this.f15290i;
            if (list == null || list.size() == 0) {
                return m;
            }
            return this.j;
        }

        /* access modifiers changed from: package-private */
        public final void r() {
            this.l = 0;
            this.f15283b = -1;
            this.f15284c = -1;
            this.f15285d = -1;
            this.f15287f = -1;
            this.n = 0;
            this.f15288g = null;
            this.f15289h = null;
            p();
            this.q = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f15283b + " id=" + this.f15285d + ", oldPos=" + this.f15284c + ", pLpos:" + this.f15287f);
            if (f()) {
                sb.append(" scrap ");
                sb.append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (k()) {
                sb.append(" invalid");
            }
            if (!m()) {
                sb.append(" unbound");
            }
            if (l()) {
                sb.append(" update");
            }
            if (n()) {
                sb.append(" removed");
            }
            if (c()) {
                sb.append(" ignored");
            }
            if (o()) {
                sb.append(" tmpDetached");
            }
            if (!s()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if ((this.l & 512) != 0 || k()) {
                sb.append(" undefined adapter position");
            }
            if (this.f15282a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void a(boolean z) {
            int i2 = this.n;
            this.n = z ? i2 - 1 : i2 + 1;
            int i3 = this.n;
            if (i3 < 0) {
                this.n = 0;
                new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
            } else if (!z && i3 == 1) {
                this.l |= 16;
            } else if (z && this.n == 0) {
                this.l &= -17;
            }
        }

        public final boolean s() {
            return (this.l & 16) == 0 && !u.f(this.f15282a);
        }

        /* access modifiers changed from: package-private */
        public final boolean t() {
            return (this.l & 2) != 0;
        }

        static /* synthetic */ void a(q qVar) {
            qVar.q = u.h(qVar.f15282a);
            u.c(qVar.f15282a, 4);
        }

        static /* synthetic */ void b(q qVar) {
            u.c(qVar.f15282a, qVar.q);
            qVar.q = 0;
        }

        static /* synthetic */ boolean c(q qVar) {
            return (qVar.l & 16) == 0 && u.f(qVar.f15282a);
        }

        static /* synthetic */ boolean g(q qVar) {
            return (qVar.l & 16) != 0;
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f3109a;
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().a(i2, 0);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().b(0);
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a(0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        q f15225a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f15226b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f15227c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f15228d = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static abstract class m {

        /* renamed from: a  reason: collision with root package name */
        int f15252a;

        /* renamed from: b  reason: collision with root package name */
        boolean f15253b;

        /* renamed from: c  reason: collision with root package name */
        boolean f15254c;

        /* renamed from: d  reason: collision with root package name */
        private RecyclerView f15255d;

        /* renamed from: e  reason: collision with root package name */
        private LayoutManager f15256e;

        /* renamed from: f  reason: collision with root package name */
        private View f15257f;

        /* renamed from: g  reason: collision with root package name */
        private final a f15258g;

        /* access modifiers changed from: protected */
        public final void a() {
            if (this.f15254c) {
                this.f15255d.n.f15266a = -1;
                this.f15257f = null;
                this.f15252a = -1;
                this.f15253b = false;
                this.f15254c = false;
                LayoutManager.a(this.f15256e, this);
                this.f15256e = null;
                this.f15255d = null;
            }
        }

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            int f15259a;

            /* renamed from: b  reason: collision with root package name */
            private int f15260b;

            /* renamed from: c  reason: collision with root package name */
            private int f15261c;

            /* renamed from: d  reason: collision with root package name */
            private int f15262d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f15263e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f15264f;

            /* renamed from: g  reason: collision with root package name */
            private int f15265g;

            /* access modifiers changed from: package-private */
            public final void a(RecyclerView recyclerView) {
                int i2 = this.f15259a;
                if (i2 >= 0) {
                    this.f15259a = -1;
                    RecyclerView.c(recyclerView, i2);
                    this.f15264f = false;
                } else if (!this.f15264f) {
                    this.f15265g = 0;
                } else if (this.f15263e == null || this.f15262d > 0) {
                    int i3 = this.f15262d;
                    if (i3 > 0) {
                        if (this.f15263e != null) {
                            recyclerView.ad.a(this.f15260b, this.f15261c, this.f15262d, this.f15263e);
                        } else if (i3 == Integer.MIN_VALUE) {
                            recyclerView.ad.a(this.f15260b, this.f15261c);
                        } else {
                            recyclerView.ad.a(this.f15260b, this.f15261c, this.f15262d);
                        }
                        this.f15265g++;
                        this.f15264f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void a(View view) {
            if (RecyclerView.c(view) == this.f15252a) {
                this.f15257f = view;
            }
        }

        static /* synthetic */ void a(m mVar) {
            RecyclerView recyclerView = mVar.f15255d;
            if (!mVar.f15254c || mVar.f15252a == -1 || recyclerView == null) {
                mVar.a();
            }
            boolean z = false;
            mVar.f15253b = false;
            View view = mVar.f15257f;
            if (view != null) {
                if (RecyclerView.c(view) == mVar.f15252a) {
                    mVar.f15258g.a(recyclerView);
                    mVar.a();
                } else {
                    mVar.f15257f = null;
                }
            }
            if (mVar.f15254c) {
                if (mVar.f15258g.f15259a >= 0) {
                    z = true;
                }
                mVar.f15258g.a(recyclerView);
                if (!z) {
                    return;
                }
                if (mVar.f15254c) {
                    mVar.f15253b = true;
                    recyclerView.ad.a();
                    return;
                }
                mVar.a();
            }
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public Parcelable f15229a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f15229a = parcel.readParcelable(LayoutManager.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f15229a, 0);
        }
    }

    public static class n {

        /* renamed from: a  reason: collision with root package name */
        int f15266a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f15267b = 1;

        /* renamed from: c  reason: collision with root package name */
        int f15268c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f15269d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f15270e = 0;

        /* renamed from: f  reason: collision with root package name */
        boolean f15271f = false;

        /* renamed from: g  reason: collision with root package name */
        boolean f15272g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f15273h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f15274i = false;
        boolean j = false;
        boolean k = false;
        private SparseArray<Object> l;

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            if ((this.f15267b & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f15267b));
            }
        }

        public final int a() {
            return this.f15272g ? this.f15269d - this.f15270e : this.f15268c;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.f15266a + ", mData=" + this.l + ", mItemCount=" + this.f15268c + ", mPreviousLayoutItemCount=" + this.f15269d + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f15270e + ", mStructureChanged=" + this.f15271f + ", mInPreLayout=" + this.f15272g + ", mRunSimpleAnimations=" + this.f15273h + ", mRunPredictiveAnimations=" + this.f15274i + '}';
        }
    }

    class f implements e.a {
        private f() {
        }

        /* synthetic */ f(RecyclerView recyclerView, byte b2) {
            this();
        }

        public final void a(q qVar) {
            qVar.a(true);
            if (qVar.f15288g != null && qVar.f15289h == null) {
                qVar.f15288g = null;
            }
            qVar.f15289h = null;
            if (!q.g(qVar) && !RecyclerView.c(RecyclerView.this, qVar.f15282a) && qVar.o()) {
                RecyclerView.this.removeDetachedView(qVar.f15282a, false);
            }
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Object> f15232a = new ArrayList<>();

        /* renamed from: h  reason: collision with root package name */
        a f15233h = null;

        /* renamed from: i  reason: collision with root package name */
        long f15234i = 120;
        long j = 120;
        long k = 250;
        long l = 250;

        interface a {
            void a(q qVar);
        }

        public abstract void a();

        public abstract boolean a(q qVar, b bVar, b bVar2);

        public abstract boolean a(q qVar, q qVar2, b bVar, b bVar2);

        public abstract boolean b();

        public abstract boolean b(q qVar, b bVar, b bVar2);

        public abstract void c(q qVar);

        public abstract boolean c(q qVar, b bVar, b bVar2);

        public abstract void d();

        public boolean g(q qVar) {
            return true;
        }

        static int e(q qVar) {
            int h2 = qVar.l & 14;
            if (qVar.k()) {
                return 4;
            }
            if ((h2 & 4) != 0) {
                return h2;
            }
            int i2 = qVar.f15284c;
            int e2 = qVar.e();
            return (i2 == -1 || e2 == -1 || i2 == e2) ? h2 : h2 | EmiUtil.EMI_PLAN_REQUEST_CODE;
        }

        public final void f(q qVar) {
            a aVar = this.f15233h;
            if (aVar != null) {
                aVar.a(qVar);
            }
        }

        public boolean a(q qVar, List<Object> list) {
            return g(qVar);
        }

        public final void e() {
            int size = this.f15232a.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f15232a.get(i2);
            }
            this.f15232a.clear();
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f15235a;

            /* renamed from: b  reason: collision with root package name */
            public int f15236b;

            /* renamed from: c  reason: collision with root package name */
            public int f15237c;

            /* renamed from: d  reason: collision with root package name */
            public int f15238d;

            public final b a(q qVar) {
                View view = qVar.f15282a;
                this.f15235a = view.getLeft();
                this.f15236b = view.getTop();
                this.f15237c = view.getRight();
                this.f15238d = view.getBottom();
                return this;
            }
        }

        public static b d(q qVar) {
            return new b().a(qVar);
        }
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.aj;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a();
    }

    private androidx.core.h.l getScrollingChildHelper() {
        if (this.al == null) {
            this.al = new androidx.core.h.l(this);
        }
        return this.al;
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.Q) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.Q = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.U = x2;
            this.S = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.V = y2;
            this.T = y2;
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        boolean z2 = false;
        if (t()) {
            int b2 = accessibilityEvent != null ? androidx.core.h.a.b.b(accessibilityEvent) : 0;
            if (b2 == 0) {
                b2 = 0;
            }
            this.J = b2 | this.J;
            z2 = true;
        }
        if (!z2) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, q qVar, e.b bVar, e.b bVar2) {
        recyclerView.a(qVar);
        qVar.a(false);
        if (recyclerView.m.a(qVar, bVar, bVar2)) {
            recyclerView.u();
        }
    }

    static /* synthetic */ void b(RecyclerView recyclerView, q qVar, e.b bVar, e.b bVar2) {
        qVar.a(false);
        if (recyclerView.m.b(qVar, bVar, bVar2)) {
            recyclerView.u();
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        b(view);
        List<Object> list = recyclerView.N;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                recyclerView.N.get(size);
            }
        }
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, q qVar) {
        e eVar = recyclerView.m;
        return eVar == null || eVar.a(qVar, qVar.q());
    }

    static /* synthetic */ int b(RecyclerView recyclerView, q qVar) {
        if (qVar.a(524) || !qVar.m()) {
            return -1;
        }
        a aVar = recyclerView.f15208c;
        int i2 = qVar.f15283b;
        int size = aVar.f15291a.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.f15291a.get(i3);
            int i4 = bVar.f15299a;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 8) {
                        if (bVar.f15300b == i2) {
                            i2 = bVar.f15302d;
                        } else {
                            if (bVar.f15300b < i2) {
                                i2--;
                            }
                            if (bVar.f15302d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.f15300b > i2) {
                    continue;
                } else if (bVar.f15300b + bVar.f15302d > i2) {
                    return -1;
                } else {
                    i2 -= bVar.f15302d;
                }
            } else if (bVar.f15300b <= i2) {
                i2 += bVar.f15302d;
            }
        }
        return i2;
    }

    static /* synthetic */ void c(RecyclerView recyclerView, int i2) {
        LayoutManager layoutManager = recyclerView.f15211f;
        if (layoutManager != null) {
            layoutManager.b(i2);
            recyclerView.awakenScrollBars();
        }
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        recyclerView.a();
        b bVar = recyclerView.f15209d;
        int a2 = bVar.f15303a.a(view);
        boolean z2 = true;
        if (a2 == -1) {
            bVar.b(view);
        } else if (bVar.f15304b.c(a2)) {
            bVar.f15304b.d(a2);
            bVar.b(view);
            bVar.f15303a.a(a2);
        } else {
            z2 = false;
        }
        if (z2) {
            q b2 = b(view);
            recyclerView.f15207b.b(b2);
            recyclerView.f15207b.a(b2);
        }
        recyclerView.a(!z2);
        return z2;
    }
}
