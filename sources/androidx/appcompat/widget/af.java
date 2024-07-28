package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.h.u;
import androidx.core.h.v;

final class af implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static af j;
    private static af k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1686a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1687b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1688c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1689d = new Runnable() {
        public final void run() {
            af.this.a(false);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1690e = new Runnable() {
        public final void run() {
            af.this.a();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private int f1691f;

    /* renamed from: g  reason: collision with root package name */
    private int f1692g;

    /* renamed from: h  reason: collision with root package name */
    private ag f1693h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1694i;

    public final void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        af afVar = j;
        if (afVar != null && afVar.f1686a == view) {
            a((af) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            af afVar2 = k;
            if (afVar2 != null && afVar2.f1686a == view) {
                afVar2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new af(view, charSequence);
    }

    private af(View view, CharSequence charSequence) {
        this.f1686a = view;
        this.f1687b = charSequence;
        this.f1688c = v.b(ViewConfiguration.get(this.f1686a.getContext()));
        d();
        this.f1686a.setOnLongClickListener(this);
        this.f1686a.setOnHoverListener(this);
    }

    public final boolean onLongClick(View view) {
        this.f1691f = view.getWidth() / 2;
        this.f1692g = view.getHeight() / 2;
        a(true);
        return true;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.f1693h != null && this.f1694i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1686a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d();
                a();
            }
        } else if (this.f1686a.isEnabled() && this.f1693h == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (Math.abs(x - this.f1691f) > this.f1688c || Math.abs(y - this.f1692g) > this.f1688c) {
                this.f1691f = x;
                this.f1692g = y;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a(this);
            }
        }
        return false;
    }

    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        long j2;
        int i2;
        long j3;
        if (u.M(this.f1686a)) {
            a((af) null);
            af afVar = k;
            if (afVar != null) {
                afVar.a();
            }
            k = this;
            this.f1694i = z;
            this.f1693h = new ag(this.f1686a.getContext());
            this.f1693h.a(this.f1686a, this.f1691f, this.f1692g, this.f1694i, this.f1687b);
            this.f1686a.addOnAttachStateChangeListener(this);
            if (this.f1694i) {
                j2 = 2500;
            } else {
                if ((u.y(this.f1686a) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.f1686a.removeCallbacks(this.f1690e);
            this.f1686a.postDelayed(this.f1690e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (k == this) {
            k = null;
            ag agVar = this.f1693h;
            if (agVar != null) {
                agVar.a();
                this.f1693h = null;
                d();
                this.f1686a.removeOnAttachStateChangeListener(this);
            }
        }
        if (j == this) {
            a((af) null);
        }
        this.f1686a.removeCallbacks(this.f1690e);
    }

    private static void a(af afVar) {
        af afVar2 = j;
        if (afVar2 != null) {
            afVar2.c();
        }
        j = afVar;
        if (afVar != null) {
            j.b();
        }
    }

    private void b() {
        this.f1686a.postDelayed(this.f1689d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f1686a.removeCallbacks(this.f1689d);
    }

    private void d() {
        this.f1691f = Integer.MAX_VALUE;
        this.f1692g = Integer.MAX_VALUE;
    }
}
