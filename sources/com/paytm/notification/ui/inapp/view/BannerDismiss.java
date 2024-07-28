package com.paytm.notification.ui.inapp.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.h.u;
import androidx.customview.a.c;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;

public final class BannerDismiss extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43343a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final float f43344g = f43344g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final float f43345h = f43345h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f43346i = 24;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f43347b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f43348c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public androidx.customview.a.c f43349d;

    /* renamed from: e  reason: collision with root package name */
    private float f43350e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f43351f;

    public interface b {
    }

    public BannerDismiss(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public final float getMinFlingVelocity() {
        return this.f43350e;
    }

    public final void setMinFlingVelocity(float f2) {
        this.f43350e = f2;
    }

    public final float getYFraction() {
        int height = getHeight();
        if (height == 0) {
            return 0.0f;
        }
        return getTranslationY() / ((float) height);
    }

    public static final class e implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BannerDismiss f43360a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f43361b;

        e(BannerDismiss bannerDismiss, float f2) {
            this.f43360a = bannerDismiss;
            this.f43361b = f2;
        }

        public final boolean onPreDraw() {
            this.f43360a.setYFraction(this.f43361b);
            this.f43360a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public final void setYFraction(float f2) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new e(this, f2));
            return;
        }
        setTranslationY(f2 * ((float) getHeight()));
    }

    public final float getXFraction() {
        int width = getWidth();
        if (width == 0) {
            return 0.0f;
        }
        return getTranslationX() / ((float) width);
    }

    public static final class d implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BannerDismiss f43358a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f43359b;

        d(BannerDismiss bannerDismiss, float f2) {
            this.f43358a = bannerDismiss;
            this.f43359b = f2;
        }

        public final boolean onPreDraw() {
            this.f43358a.setXFraction(this.f43359b);
            this.f43358a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public final void setXFraction(float f2) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new d(this, f2));
            return;
        }
        setTranslationX(f2 * ((float) getWidth()));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerDismiss(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
        this.f43348c = "bottom";
        a(context);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerDismiss(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerDismiss(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        k.c(context, "context");
        this.f43348c = "bottom";
        a(context);
    }

    private final void a(Context context) {
        if (!isInEditMode()) {
            this.f43349d = androidx.customview.a.c.a((ViewGroup) this, (c.a) new c());
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            k.a((Object) viewConfiguration, "vc");
            this.f43350e = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            Resources resources = context.getResources();
            k.a((Object) resources, "context.resources");
            this.f43347b = TypedValue.applyDimension(1, (float) f43346i, resources.getDisplayMetrics());
        }
    }

    public final void setListener(b bVar) {
        k.c(bVar, "listener");
        synchronized (this) {
            this.f43351f = bVar;
            x xVar = x.f47997a;
        }
    }

    public final void computeScroll() {
        super.computeScroll();
        androidx.customview.a.c cVar = this.f43349d;
        if (cVar != null) {
            if (cVar == null) {
                k.a();
            }
            if (cVar.f()) {
                u.g(this);
            }
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        androidx.customview.a.c cVar = this.f43349d;
        if (cVar == null) {
            k.a();
        }
        if (cVar.a(motionEvent) || super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        androidx.customview.a.c cVar2 = this.f43349d;
        if (cVar2 == null) {
            k.a();
        }
        if (cVar2.a() == 0 && motionEvent.getActionMasked() == 2) {
            androidx.customview.a.c cVar3 = this.f43349d;
            if (cVar3 == null) {
                k.a();
            }
            if (cVar3.b(2)) {
                androidx.customview.a.c cVar4 = this.f43349d;
                if (cVar4 == null) {
                    k.a();
                }
                View b2 = cVar4.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (b2 != null) {
                    androidx.customview.a.c cVar5 = this.f43349d;
                    if (cVar5 == null) {
                        k.a();
                    }
                    if (!b2.canScrollVertically(cVar5.c())) {
                        androidx.customview.a.c cVar6 = this.f43349d;
                        if (cVar6 == null) {
                            k.a();
                        }
                        cVar6.a(b2, motionEvent.getPointerId(0));
                        androidx.customview.a.c cVar7 = this.f43349d;
                        if (cVar7 == null) {
                            k.a();
                        }
                        if (cVar7.a() == 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, AppConstants.NOTIFICATION_DETAILS.EVENT);
        androidx.customview.a.c cVar = this.f43349d;
        if (cVar == null) {
            k.a();
        }
        cVar.b(motionEvent);
        androidx.customview.a.c cVar2 = this.f43349d;
        if (cVar2 == null) {
            k.a();
        }
        if (cVar2.b() == null && motionEvent.getActionMasked() == 2) {
            androidx.customview.a.c cVar3 = this.f43349d;
            if (cVar3 == null) {
                k.a();
            }
            if (cVar3.b(2)) {
                androidx.customview.a.c cVar4 = this.f43349d;
                if (cVar4 == null) {
                    k.a();
                }
                View b2 = cVar4.b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (b2 != null) {
                    androidx.customview.a.c cVar5 = this.f43349d;
                    if (cVar5 == null) {
                        k.a();
                    }
                    if (!b2.canScrollVertically(cVar5.c())) {
                        androidx.customview.a.c cVar6 = this.f43349d;
                        if (cVar6 == null) {
                            k.a();
                        }
                        cVar6.a(b2, motionEvent.getPointerId(0));
                    }
                }
            }
        }
        androidx.customview.a.c cVar7 = this.f43349d;
        if (cVar7 == null) {
            k.a();
        }
        if (cVar7.b() != null) {
            return true;
        }
        return false;
    }

    public final void setPlacement(String str) {
        k.c(str, "placement");
        this.f43348c = str;
    }

    final class c extends c.a {

        /* renamed from: b  reason: collision with root package name */
        private int f43353b;

        /* renamed from: c  reason: collision with root package name */
        private int f43354c;

        /* renamed from: d  reason: collision with root package name */
        private float f43355d;

        /* renamed from: e  reason: collision with root package name */
        private View f43356e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f43357f;

        public c() {
        }

        public final boolean b(View view, int i2) {
            k.c(view, "view");
            return this.f43356e == null;
        }

        public final int c(View view, int i2) {
            k.c(view, "child");
            return view.getLeft();
        }

        public final int d(View view, int i2) {
            k.c(view, "child");
            String a2 = BannerDismiss.this.f43348c;
            int hashCode = a2.hashCode();
            if (hashCode != -1383228885) {
                if (hashCode == 115029 && a2.equals("top")) {
                    return Math.round(Math.min((float) i2, ((float) this.f43353b) + BannerDismiss.this.f43347b));
                }
            } else if (a2.equals("bottom")) {
                return Math.round(Math.max((float) i2, ((float) this.f43353b) - BannerDismiss.this.f43347b));
            }
            return Math.round(Math.max((float) i2, ((float) this.f43353b) - BannerDismiss.this.f43347b));
        }

        public final void a(View view, int i2) {
            k.c(view, "view");
            this.f43356e = view;
            this.f43353b = view.getTop();
            this.f43354c = view.getLeft();
            this.f43355d = 0.0f;
            this.f43357f = false;
        }

        public final void a(View view, int i2, int i3, int i4, int i5) {
            k.c(view, "view");
            int height = BannerDismiss.this.getHeight();
            int abs = Math.abs(i3 - this.f43353b);
            if (height > 0) {
                this.f43355d = ((float) abs) / ((float) height);
            }
            BannerDismiss.this.invalidate();
        }

        public final void a(int i2) {
            if (this.f43356e != null) {
                synchronized (this) {
                    if (BannerDismiss.this.f43351f != null) {
                        if (BannerDismiss.this.f43351f == null) {
                            k.a();
                        }
                        if (this.f43356e == null) {
                            k.a();
                        }
                    }
                    if (i2 == 0) {
                        if (this.f43357f) {
                            if (BannerDismiss.this.f43351f != null) {
                                if (BannerDismiss.this.f43351f == null) {
                                    k.a();
                                }
                                if (this.f43356e == null) {
                                    k.a();
                                }
                            }
                            BannerDismiss.this.removeView(this.f43356e);
                        }
                        this.f43356e = null;
                    }
                    x xVar = x.f47997a;
                }
            }
        }

        public final void a(View view, float f2, float f3) {
            k.c(view, "view");
            float abs = Math.abs(f3);
            boolean z = true;
            if (!k.a((Object) "top", (Object) BannerDismiss.this.f43348c) ? this.f43353b <= view.getTop() : this.f43353b >= view.getTop()) {
                if (this.f43355d < BannerDismiss.f43344g && abs <= BannerDismiss.this.getMinFlingVelocity() && this.f43355d <= BannerDismiss.f43345h) {
                    z = false;
                }
                this.f43357f = z;
            }
            if (this.f43357f) {
                int height = k.a((Object) "top", (Object) BannerDismiss.this.f43348c) ? -view.getHeight() : view.getHeight() + BannerDismiss.this.getHeight();
                androidx.customview.a.c d2 = BannerDismiss.this.f43349d;
                if (d2 == null) {
                    k.a();
                }
                d2.a(this.f43354c, height);
            } else {
                androidx.customview.a.c d3 = BannerDismiss.this.f43349d;
                if (d3 == null) {
                    k.a();
                }
                d3.a(this.f43354c, this.f43353b);
            }
            BannerDismiss.this.invalidate();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
