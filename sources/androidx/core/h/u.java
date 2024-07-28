package androidx.core.h;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import androidx.core.h.a;
import androidx.core.h.a.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f3120a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    private static Field f3121b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3122c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f3123d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f3124e;

    /* renamed from: f  reason: collision with root package name */
    private static WeakHashMap<View, String> f3125f;

    /* renamed from: g  reason: collision with root package name */
    private static WeakHashMap<View, x> f3126g = null;

    /* renamed from: h  reason: collision with root package name */
    private static Method f3127h;

    /* renamed from: i  reason: collision with root package name */
    private static Field f3128i;
    private static boolean j = false;
    private static ThreadLocal<Rect> k;
    private static final int[] l = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    private static a m = new a();

    public interface f {
        boolean a();
    }

    private static Rect b() {
        if (k == null) {
            k = new ThreadLocal<>();
        }
        Rect rect = k.get();
        if (rect == null) {
            rect = new Rect();
            k.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i2, 0);
        }
    }

    @Deprecated
    public static boolean a(View view, int i2) {
        return view.canScrollHorizontally(i2);
    }

    @Deprecated
    public static boolean b(View view, int i2) {
        return view.canScrollVertically(i2);
    }

    @Deprecated
    public static int a(View view) {
        return view.getOverScrollMode();
    }

    public static void a(View view, a aVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (U(view) instanceof a.C0045a)) {
            aVar = new a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    public static int b(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void c(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(8);
        }
    }

    public static boolean d(View view) {
        return U(view) != null;
    }

    public static a e(View view) {
        View.AccessibilityDelegate U = U(view);
        if (U == null) {
            return null;
        }
        if (U instanceof a.C0045a) {
            return ((a.C0045a) U).f3036a;
        }
        return new a(U);
    }

    private static a T(View view) {
        a e2 = e(view);
        if (e2 == null) {
            e2 = new a();
        }
        a(view, e2);
        return e2;
    }

    private static View.AccessibilityDelegate U(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return V(view);
    }

    private static View.AccessibilityDelegate V(View view) {
        if (j) {
            return null;
        }
        if (f3128i == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f3128i = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                j = true;
                return null;
            }
        }
        try {
            Object obj = f3128i.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            j = true;
            return null;
        }
    }

    public static boolean f(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void g(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        } else {
            view.postInvalidate(i2, i3, i4, i5);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j2) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j2);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j2);
        }
    }

    public static int h(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void c(View view, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (i2 == 4) {
                i2 = 2;
            }
        }
        view.setImportantForAccessibility(i2);
    }

    public static boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i2, bundle);
        }
        return false;
    }

    public static void a(View view, c.a aVar, androidx.core.h.a.f fVar) {
        if (fVar == null) {
            d(view, aVar.a());
            return;
        }
        c.a aVar2 = new c.a((Object) null, aVar.M, fVar, aVar.N);
        if (Build.VERSION.SDK_INT >= 21) {
            T(view);
            a(aVar2.a(), view);
            W(view).add(aVar2);
            i(view, 0);
        }
    }

    public static void d(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i2, view);
            i(view, 0);
        }
    }

    private static void a(int i2, View view) {
        List<c.a> W = W(view);
        for (int i3 = 0; i3 < W.size(); i3++) {
            if (W.get(i3).a() == i2) {
                W.remove(i3);
                return;
            }
        }
    }

    private static List<c.a> W(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static float i(View view) {
        return view.getAlpha();
    }

    @Deprecated
    public static void e(View view, int i2) {
        view.setLayerType(i2, (Paint) null);
    }

    public static void a(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static ViewParent k(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    private static int X(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void l(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(1);
        }
    }

    public static int m(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i2, i3, i4, i5);
        } else {
            view.setPadding(i2, i3, i4, i5);
        }
    }

    @Deprecated
    public static float o(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float p(View view) {
        return view.getTranslationY();
    }

    public static int q(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f3122c) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f3121b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3122c = true;
        }
        Field field = f3121b;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int r(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f3124e) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f3123d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3124e = true;
        }
        Field field = f3123d;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static x s(View view) {
        if (f3126g == null) {
            f3126g = new WeakHashMap<>();
        }
        x xVar = f3126g.get(view);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(view);
        f3126g.put(view, xVar2);
        return xVar2;
    }

    @Deprecated
    public static void a(View view, float f2) {
        view.setTranslationX(f2);
    }

    @Deprecated
    public static void b(View view, float f2) {
        view.setTranslationY(f2);
    }

    @Deprecated
    public static void c(View view, float f2) {
        view.setAlpha(f2);
    }

    @Deprecated
    public static void d(View view, float f2) {
        view.setX(f2);
    }

    @Deprecated
    public static void e(View view, float f2) {
        view.setScaleX(f2);
    }

    @Deprecated
    public static void f(View view, float f2) {
        view.setScaleY(f2);
    }

    @Deprecated
    public static float t(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float u(View view) {
        return view.getY();
    }

    public static void g(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f2);
        }
    }

    public static float v(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void h(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f2);
        }
    }

    public static float w(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void a(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f3125f == null) {
            f3125f = new WeakHashMap<>();
        }
        f3125f.put(view, str);
    }

    public static String x(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f3125f;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int y(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void z(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    @Deprecated
    public static void a(ViewGroup viewGroup) {
        if (f3127h == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f3127h = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
            }
            f3127h.setAccessible(true);
        }
        try {
            f3127h.invoke(viewGroup, new Object[]{Boolean.TRUE});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
        }
    }

    public static boolean A(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void a(View view, final q qVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (qVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return q.this.a(view, ab.a(windowInsets)).e();
                }
            });
        }
    }

    public static ab a(View view, ab abVar) {
        WindowInsets e2;
        if (Build.VERSION.SDK_INT >= 21 && (e2 = abVar.e()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(e2);
            if (!onApplyWindowInsets.equals(e2)) {
                return ab.a(onApplyWindowInsets);
            }
        }
        return abVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r3.e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.h.ab b(android.view.View r2, androidx.core.h.ab r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L_0x001b
            android.view.WindowInsets r0 = r3.e()
            if (r0 == 0) goto L_0x001b
            android.view.WindowInsets r2 = r2.dispatchApplyWindowInsets(r0)
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x001b
            androidx.core.h.ab r2 = androidx.core.h.ab.a(r0)
            return r2
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.h.u.b(android.view.View, androidx.core.h.ab):androidx.core.h.ab");
    }

    public static ab B(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ab.a(d.a(view));
        }
        return null;
    }

    public static ab a(View view, ab abVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? c.a(view, abVar, rect) : abVar;
    }

    public static boolean C(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean D(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void a(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static ColorStateList E(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof t) {
            ((t) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode F(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof t) {
            return ((t) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void a(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof t) {
            ((t) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void c(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof i) {
            ((i) view).setNestedScrollingEnabled(z);
        }
    }

    public static boolean G(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof i) {
            return ((i) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void H(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof i) {
            ((i) view).stopNestedScroll();
        }
    }

    public static void I(View view) {
        if (view instanceof j) {
            ((j) view).stopNestedScroll(1);
        }
    }

    public static boolean J(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float K(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void i(View view, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f2);
        }
    }

    public static void f(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b2 = b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            j(view, i2);
            if (z && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        } else {
            j(view, i2);
        }
    }

    private static void j(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            Y(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                Y((View) parent);
            }
        }
    }

    public static void g(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect b2 = b();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                b2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !b2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            k(view, i2);
            if (z && b2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(b2);
            }
        } else {
            k(view, i2);
        }
    }

    private static void k(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            Y(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                Y((View) parent);
            }
        }
    }

    private static void Y(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect L(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean M(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean N(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void h(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i2, 3);
        }
    }

    public static void a(View view, s sVar) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (sVar != null) {
                obj = sVar.f3119a;
            } else {
                obj = null;
            }
            view.setPointerIcon((PointerIcon) obj);
        }
    }

    public static Display O(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (M(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static int a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = f3120a.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!f3120a.compareAndSet(i2, i3));
        return i2;
    }

    static boolean a(View view, KeyEvent keyEvent) {
        int indexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        g a2 = g.a(view);
        if (a2.f3136c == null || a2.f3136c.get() != keyEvent) {
            a2.f3136c = new WeakReference<>(keyEvent);
            WeakReference weakReference = null;
            SparseArray<WeakReference<View>> a3 = a2.a();
            if (keyEvent.getAction() == 1 && (indexOfKey = a3.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = a3.valueAt(indexOfKey);
                a3.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = a3.get(keyEvent.getKeyCode());
            }
            if (weakReference != null) {
                View view2 = (View) weakReference.get();
                if (view2 != null && M(view2)) {
                    g.b(view2);
                }
                return true;
            }
        }
        return false;
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        g a2 = g.a(view);
        if (keyEvent.getAction() == 0) {
            if (a2.f3135b != null) {
                a2.f3135b.clear();
            }
            if (!g.f3134a.isEmpty()) {
                synchronized (g.f3134a) {
                    if (a2.f3135b == null) {
                        a2.f3135b = new WeakHashMap<>();
                    }
                    for (int size = g.f3134a.size() - 1; size >= 0; size--) {
                        View view2 = (View) g.f3134a.get(size).get();
                        if (view2 == null) {
                            g.f3134a.remove(size);
                        } else {
                            a2.f3135b.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                a2.f3135b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a3 = a2.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a3 != null && !KeyEvent.isModifierKey(keyCode)) {
                a2.a().put(keyCode, new WeakReference(a3));
            }
        }
        if (a3 != null) {
            return true;
        }
        return false;
    }

    public static boolean R(View view) {
        Boolean b2 = c().b(view);
        if (b2 == null) {
            return false;
        }
        return b2.booleanValue();
    }

    public static void S(View view) {
        b<Boolean> c2 = c();
        Boolean bool = Boolean.TRUE;
        if (c2.a()) {
            c2.a(view, bool);
        } else if (b.b() && c2.a(c2.b(view), bool)) {
            T(view);
            view.setTag(c2.f3131a, bool);
            i(view, 0);
        }
    }

    private static b<Boolean> c() {
        return new b<Boolean>(R.id.tag_accessibility_heading, Boolean.class) {
            /* access modifiers changed from: package-private */
            public final /* synthetic */ void a(View view, Object obj) {
                view.setAccessibilityHeading(((Boolean) obj).booleanValue());
            }

            /* access modifiers changed from: package-private */
            public final /* bridge */ /* synthetic */ boolean a(Object obj, Object obj2) {
                return !a((Boolean) obj, (Boolean) obj2);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object a(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    static abstract class b<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f3131a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<T> f3132b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3133c;

        /* access modifiers changed from: package-private */
        public abstract T a(View view);

        /* access modifiers changed from: package-private */
        public abstract void a(View view, T t);

        b(int i2, Class<T> cls) {
            this(i2, cls, (byte) 0);
        }

        b(int i2, Class<T> cls, byte b2) {
            this.f3131a = i2;
            this.f3132b = cls;
            this.f3133c = 28;
        }

        /* access modifiers changed from: package-private */
        public final T b(View view) {
            if (a()) {
                return a(view);
            }
            if (!b()) {
                return null;
            }
            T tag = view.getTag(this.f3131a);
            if (this.f3132b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return Build.VERSION.SDK_INT >= this.f3133c;
        }

        static boolean b() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* access modifiers changed from: package-private */
        public boolean a(T t, T t2) {
            return !t2.equals(t);
        }

        static boolean a(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }
    }

    static void i(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = Q(view) != null;
            if (X(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : EmiUtil.EMI_PLAN_REQUEST_CODE);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(view.getParent().getClass().getSimpleName());
                    sb.append(" does not fully implement ViewParent");
                }
            }
        }
    }

    static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f3130a = new WeakHashMap<>();

        public final void onViewDetachedFromWindow(View view) {
        }

        a() {
        }

        public final void onGlobalLayout() {
            for (Map.Entry next : this.f3130a.entrySet()) {
                View view = (View) next.getKey();
                boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
                boolean z = view.getVisibility() == 0;
                if (booleanValue != z) {
                    if (z) {
                        u.i(view, 16);
                    }
                    this.f3130a.put(view, Boolean.valueOf(z));
                }
            }
        }

        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    static class g {

        /* renamed from: a  reason: collision with root package name */
        static final ArrayList<WeakReference<View>> f3134a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        WeakHashMap<View, Boolean> f3135b = null;

        /* renamed from: c  reason: collision with root package name */
        WeakReference<KeyEvent> f3136c = null;

        /* renamed from: d  reason: collision with root package name */
        private SparseArray<WeakReference<View>> f3137d = null;

        g() {
        }

        /* access modifiers changed from: package-private */
        public final SparseArray<WeakReference<View>> a() {
            if (this.f3137d == null) {
                this.f3137d = new SparseArray<>();
            }
            return this.f3137d;
        }

        static g a(View view) {
            g gVar = (g) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (gVar != null) {
                return gVar;
            }
            g gVar2 = new g();
            view.setTag(R.id.tag_unhandled_key_event_manager, gVar2);
            return gVar2;
        }

        /* access modifiers changed from: package-private */
        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f3135b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a2 = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                }
                if (b(view)) {
                    return view;
                }
            }
            return null;
        }

        static boolean b(View view) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((f) arrayList.get(size)).a()) {
                    return true;
                }
            }
            return false;
        }
    }

    static class c {
        static ab a(View view, ab abVar, Rect rect) {
            WindowInsets e2 = abVar.e();
            if (e2 != null) {
                return ab.a(view.computeSystemWindowInsets(e2, rect));
            }
            rect.setEmpty();
            return abVar;
        }
    }

    static class d {
        public static WindowInsets a(View view) {
            return view.getRootWindowInsets();
        }
    }

    static class e {
        static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void a(View view, androidx.core.h.a.c cVar) {
        view.onInitializeAccessibilityNodeInfo(cVar.f3041a);
    }

    public static boolean P(View view) {
        Boolean bool = (Boolean) new b<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class) {
            /* access modifiers changed from: package-private */
            public final /* synthetic */ void a(View view, Object obj) {
                view.setScreenReaderFocusable(((Boolean) obj).booleanValue());
            }

            /* access modifiers changed from: package-private */
            public final /* bridge */ /* synthetic */ boolean a(Object obj, Object obj2) {
                return !a((Boolean) obj, (Boolean) obj2);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object a(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        }.b(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static CharSequence Q(View view) {
        return (CharSequence) new b<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class) {
            /* access modifiers changed from: package-private */
            public final /* synthetic */ void a(View view, Object obj) {
                view.setAccessibilityPaneTitle((CharSequence) obj);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ boolean a(Object obj, Object obj2) {
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object a(View view) {
                return view.getAccessibilityPaneTitle();
            }
        }.b(view);
    }
}
