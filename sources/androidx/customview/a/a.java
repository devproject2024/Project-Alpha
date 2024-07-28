package androidx.customview.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.a.h;
import androidx.core.h.a.c;
import androidx.core.h.a.d;
import androidx.core.h.a.e;
import androidx.core.h.u;
import androidx.core.h.w;
import androidx.customview.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class a extends androidx.core.h.a {

    /* renamed from: d  reason: collision with root package name */
    private static final Rect f3220d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<c> l = new b.a<c>() {
        public final /* bridge */ /* synthetic */ void a(Object obj, Rect rect) {
            ((c) obj).a(rect);
        }
    };
    private static final b.C0053b<h<c>, c> m = new b.C0053b<h<c>, c>() {
        public final /* synthetic */ int a(Object obj) {
            return ((h) obj).b();
        }

        public final /* synthetic */ Object a(Object obj, int i2) {
            return (c) ((h) obj).c(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f3221a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f3222b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f3223c = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f3224e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f3225f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final Rect f3226g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private final int[] f3227h = new int[2];

    /* renamed from: i  reason: collision with root package name */
    private final AccessibilityManager f3228i;
    private final View j;
    private C0052a k;

    /* access modifiers changed from: protected */
    public abstract int a(float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract void a(int i2, c cVar);

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean b(int i2, int i3, Bundle bundle);

    public a(View view) {
        if (view != null) {
            this.j = view;
            this.f3228i = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (u.h(view) == 0) {
                u.c(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public d getAccessibilityNodeProvider(View view) {
        if (this.k == null) {
            this.k = new C0052a();
        }
        return this.k;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.f3228i.isEnabled() && this.f3228i.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int a2 = a(motionEvent.getX(), motionEvent.getY());
                b(a2);
                if (a2 != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action != 10 || this.f3223c == Integer.MIN_VALUE) {
                return false;
            } else {
                b(Integer.MIN_VALUE);
                return true;
            }
        }
        return false;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            int i3 = 66;
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        if (keyCode == 19) {
                            i3 = 33;
                        } else if (keyCode == 21) {
                            i3 = 17;
                        } else if (keyCode != 22) {
                            i3 = 130;
                        }
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && b(i3, (Rect) null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            int i4 = this.f3222b;
            if (i4 != Integer.MIN_VALUE) {
                b(i4, 16, (Bundle) null);
            }
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return b(1, (Rect) null);
            }
            return false;
        }
    }

    public final void a(boolean z, int i2, Rect rect) {
        int i3 = this.f3222b;
        if (i3 != Integer.MIN_VALUE) {
            e(i3);
        }
        if (z) {
            b(i2, rect);
        }
    }

    private void a(int i2, Rect rect) {
        c(i2).a(rect);
    }

    private boolean b(int i2, Rect rect) {
        c cVar;
        h<c> a2 = a();
        int i3 = this.f3222b;
        int i4 = Integer.MIN_VALUE;
        c a3 = i3 == Integer.MIN_VALUE ? null : a2.a(i3, null);
        if (i2 == 1 || i2 == 2) {
            cVar = (c) b.a(a2, m, l, a3, i2, u.j(this.j) == 1);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.f3222b;
            if (i5 != Integer.MIN_VALUE) {
                a(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.j, i2, rect2);
            }
            cVar = (c) b.a(a2, m, l, a3, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (cVar != null) {
            i4 = a2.b(a2.a(cVar));
        }
        return d(i4);
    }

    private h<c> a() {
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        h<c> hVar = new h<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.b(i2, g(i2));
        }
        return hVar;
    }

    private static Rect a(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public final boolean a(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f3228i.isEnabled() || (parent = this.j.getParent()) == null) {
            return false;
        }
        return w.a(parent, this.j, b(i2, i3));
    }

    public void b(int i2) {
        int i3 = this.f3223c;
        if (i3 != i2) {
            this.f3223c = i2;
            a(i2, 128);
            a(i3, (int) UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        }
    }

    private AccessibilityEvent b(int i2, int i3) {
        if (i2 != -1) {
            return c(i2, i3);
        }
        return f(i3);
    }

    private AccessibilityEvent f(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.j.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    private AccessibilityEvent c(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        c c2 = c(i2);
        obtain.getText().add(c2.d());
        obtain.setContentDescription(c2.f3041a.getContentDescription());
        obtain.setScrollable(c2.f3041a.isScrollable());
        obtain.setPassword(c2.f3041a.isPassword());
        obtain.setEnabled(c2.f3041a.isEnabled());
        obtain.setChecked(c2.f3041a.isChecked());
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(c2.f3041a.getClassName());
            e.a(obtain, this.j, i2);
            obtain.setPackageName(this.j.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: package-private */
    public final c c(int i2) {
        if (i2 == -1) {
            return b();
        }
        return g(i2);
    }

    private c b() {
        c a2 = c.a(this.j);
        u.a(this.j, a2);
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        if (a2.f3041a.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2.b(this.j, ((Integer) arrayList.get(i2)).intValue());
            }
            return a2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
        super.onInitializeAccessibilityNodeInfo(view, cVar);
        a(cVar);
    }

    private c g(int i2) {
        c a2 = c.a();
        a2.i(true);
        a2.b(true);
        a2.b((CharSequence) "android.view.View");
        a2.b(f3220d);
        a2.d(f3220d);
        a2.d(this.j);
        a(i2, a2);
        if (a2.d() == null && a2.f3041a.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        a2.a(this.f3225f);
        if (!this.f3225f.equals(f3220d)) {
            int actions = a2.f3041a.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                a2.a((CharSequence) this.j.getContext().getPackageName());
                a2.a(this.j, i2);
                if (this.f3221a == i2) {
                    a2.e(true);
                    a2.a(128);
                } else {
                    a2.e(false);
                    a2.a(64);
                }
                boolean z = this.f3222b == i2;
                if (z) {
                    a2.a(2);
                } else if (a2.f3041a.isFocusable()) {
                    a2.a(1);
                }
                a2.c(z);
                this.j.getLocationOnScreen(this.f3227h);
                a2.c(this.f3224e);
                if (this.f3224e.equals(f3220d)) {
                    a2.a(this.f3224e);
                    if (a2.f3042b != -1) {
                        c a3 = c.a();
                        for (int i3 = a2.f3042b; i3 != -1; i3 = a3.f3042b) {
                            a3.e(this.j);
                            a3.b(f3220d);
                            a(i3, a3);
                            a3.a(this.f3225f);
                            this.f3224e.offset(this.f3225f.left, this.f3225f.top);
                        }
                        a3.f3041a.recycle();
                    }
                    this.f3224e.offset(this.f3227h[0] - this.j.getScrollX(), this.f3227h[1] - this.j.getScrollY());
                }
                if (this.j.getLocalVisibleRect(this.f3226g)) {
                    this.f3226g.offset(this.f3227h[0] - this.j.getScrollX(), this.f3227h[1] - this.j.getScrollY());
                    if (this.f3224e.intersect(this.f3226g)) {
                        a2.d(this.f3224e);
                        if (a(this.f3224e)) {
                            a2.d(true);
                        }
                    }
                }
                return a2;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.j.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.j.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private boolean h(int i2) {
        if (this.f3221a != i2) {
            return false;
        }
        this.f3221a = Integer.MIN_VALUE;
        this.j.invalidate();
        a(i2, 65536);
        return true;
    }

    public final boolean d(int i2) {
        int i3;
        if ((!this.j.isFocused() && !this.j.requestFocus()) || (i3 = this.f3222b) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            e(i3);
        }
        this.f3222b = i2;
        a(i2, true);
        a(i2, 8);
        return true;
    }

    public final boolean e(int i2) {
        if (this.f3222b != i2) {
            return false;
        }
        this.f3222b = Integer.MIN_VALUE;
        a(i2, false);
        a(i2, 8);
        return true;
    }

    /* renamed from: androidx.customview.a.a$a  reason: collision with other inner class name */
    class C0052a extends d {
        C0052a() {
        }

        public final c a(int i2) {
            return c.a(a.this.c(i2));
        }

        public final boolean a(int i2, int i3, Bundle bundle) {
            return a.this.a(i2, i3, bundle);
        }

        public final c b(int i2) {
            int i3 = i2 == 2 ? a.this.f3221a : a.this.f3222b;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i3);
        }
    }

    public final void a(int i2) {
        ViewParent parent;
        if (i2 != Integer.MIN_VALUE && this.f3228i.isEnabled() && (parent = this.j.getParent()) != null) {
            AccessibilityEvent b2 = b(i2, (int) EmiUtil.EMI_PLAN_REQUEST_CODE);
            androidx.core.h.a.b.a(b2, 0);
            w.a(parent, this.j, b2);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int i2, int i3, Bundle bundle) {
        int i4;
        if (i2 == -1) {
            return u.a(this.j, i3, bundle);
        }
        if (i3 == 1) {
            return d(i2);
        }
        if (i3 == 2) {
            return e(i2);
        }
        if (i3 != 64) {
            if (i3 != 128) {
                return b(i2, i3, bundle);
            }
            return h(i2);
        } else if (!this.f3228i.isEnabled() || !this.f3228i.isTouchExplorationEnabled() || (i4 = this.f3221a) == i2) {
            return false;
        } else {
            if (i4 != Integer.MIN_VALUE) {
                h(i4);
            }
            this.f3221a = i2;
            this.j.invalidate();
            a(i2, 32768);
            return true;
        }
    }
}
