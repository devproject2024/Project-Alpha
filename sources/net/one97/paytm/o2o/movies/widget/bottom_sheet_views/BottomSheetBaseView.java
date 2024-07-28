package net.one97.paytm.o2o.movies.widget.bottom_sheet_views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;

public abstract class BottomSheetBaseView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.android.material.bottomsheet.a f76195a;

    /* renamed from: b  reason: collision with root package name */
    boolean f76196b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f76197c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f76198d;

    /* access modifiers changed from: protected */
    public float a() {
        return 100.0f;
    }

    public View a(int i2) {
        if (this.f76198d == null) {
            this.f76198d = new HashMap();
        }
        View view = (View) this.f76198d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f76198d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract int c();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetBaseView(Context context) {
        super(context);
        View findViewById;
        View findViewById2;
        k.c(context, "context");
        this.f76195a = new com.google.android.material.bottomsheet.a(context);
        View inflate = FrameLayout.inflate(context, c(), this);
        if (b()) {
            k.a((Object) inflate, "v");
            View findViewById3 = inflate.findViewById(R.id.container);
            k.a((Object) findViewById3, "v.findViewById<View>(R.id.container)");
            ViewGroup.LayoutParams layoutParams = findViewById3.getLayoutParams();
            layoutParams.height = getHeightMethod();
            inflate.setLayoutParams(layoutParams);
            this.f76195a.setContentView((View) this);
            Window window = this.f76195a.getWindow();
            if (!(window == null || (findViewById2 = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                findViewById2.setBackgroundResource(17170445);
            }
        } else {
            int heightMethod = getHeightMethod();
            View findViewById4 = inflate.findViewById(R.id.container);
            k.a((Object) findViewById4, "v.findViewById<View>(R.id.container)");
            ViewGroup.LayoutParams layoutParams2 = findViewById4.getLayoutParams();
            layoutParams2.height = heightMethod;
            k.a((Object) inflate, "v");
            inflate.setLayoutParams(layoutParams2);
            this.f76195a.setContentView((View) this);
            Window window2 = this.f76195a.getWindow();
            if (!(window2 == null || (findViewById = window2.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
                findViewById.setBackgroundResource(17170445);
            }
            setPeekHeight(heightMethod);
        }
        BottomSheetBehavior<View> bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour != null) {
            bottomSheetBehaviour.setBottomSheetCallback(new a(bottomSheetBehaviour, this));
        }
    }

    /* access modifiers changed from: protected */
    public final com.google.android.material.bottomsheet.a getMBottomSheetDialog() {
        return this.f76195a;
    }

    public final void setExpandable(boolean z) {
        this.f76196b = z;
    }

    public final void setExpanded(boolean z) {
        this.f76197c = z;
    }

    public static final class a extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f76199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBaseView f76200b;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        a(BottomSheetBehavior bottomSheetBehavior, BottomSheetBaseView bottomSheetBaseView) {
            this.f76199a = bottomSheetBehavior;
            this.f76200b = bottomSheetBaseView;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (!this.f76200b.f76196b && i2 == 1) {
                this.f76199a.setState(4);
                this.f76200b.setExpanded(false);
            } else if (i2 == 5) {
                this.f76200b.f76195a.dismiss();
                this.f76200b.setExpanded(false);
            } else if (i2 == 3) {
                this.f76200b.setExpanded(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getDisplayMetrics();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getHeightMethod() {
        /*
            r3 = this;
            android.content.res.Resources r0 = android.content.res.Resources.getSystem()
            if (r0 == 0) goto L_0x0010
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.heightPixels
            float r0 = (float) r0
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            float r1 = r3.a()
            r2 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r2
            float r0 = r0 * r1
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.widget.bottom_sheet_views.BottomSheetBaseView.getHeightMethod():int");
    }

    /* access modifiers changed from: protected */
    public final void setPeekHeight(int i2) {
        BottomSheetBehavior from;
        ViewParent parent = getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        if (view != null && (from = BottomSheetBehavior.from(view)) != null) {
            k.a((Object) from, "behavior");
            from.setPeekHeight(i2);
        }
    }

    public final BottomSheetBehavior<View> getBottomSheetBehaviour() {
        ViewParent parent = getParent();
        if (!(parent instanceof View)) {
            parent = null;
        }
        View view = (View) parent;
        if (view == null) {
            return null;
        }
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(view);
        if (from != null) {
            return from;
        }
        throw null;
    }

    public final void setCancelable(boolean z) {
        this.f76195a.setCancelable(z);
    }
}
