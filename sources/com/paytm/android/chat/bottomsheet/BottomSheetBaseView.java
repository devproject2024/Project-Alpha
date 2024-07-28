package com.paytm.android.chat.bottomsheet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.android.chat.R;
import java.util.HashMap;
import kotlin.g.b.k;

public abstract class BottomSheetBaseView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final com.google.android.material.bottomsheet.a f41815a;

    /* renamed from: b  reason: collision with root package name */
    boolean f41816b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41817c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f41818d;

    public View a(int i2) {
        if (this.f41818d == null) {
            this.f41818d = new HashMap();
        }
        View view = (View) this.f41818d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41818d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int b();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetBaseView(Context context) {
        super(context);
        View findViewById;
        k.c(context, "context");
        this.f41815a = new com.google.android.material.bottomsheet.a(context);
        View inflate = FrameLayout.inflate(context, b(), this);
        k.a((Object) inflate, "v");
        if (a()) {
            inflate.getViewTreeObserver().addOnGlobalLayoutListener(new b(this, inflate));
        } else {
            View findViewById2 = inflate.findViewById(R.id.container);
            k.a((Object) findViewById2, "v.findViewById<View>(R.id.container)");
            ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
            layoutParams.height = getHeightMethod();
            inflate.setLayoutParams(layoutParams);
        }
        this.f41815a.setContentView((View) this);
        Window window = this.f41815a.getWindow();
        if (!(window == null || (findViewById = window.findViewById(com.google.android.material.R.id.design_bottom_sheet)) == null)) {
            findViewById.setBackgroundResource(17170445);
        }
        BottomSheetBehavior<View> bottomSheetBehaviour = getBottomSheetBehaviour();
        if (bottomSheetBehaviour != null) {
            bottomSheetBehaviour.setBottomSheetCallback(new a(bottomSheetBehaviour, this));
        }
    }

    /* access modifiers changed from: protected */
    public final com.google.android.material.bottomsheet.a getMBottomSheetDialog() {
        return this.f41815a;
    }

    public final void setExpandable(boolean z) {
        this.f41816b = z;
    }

    public final void setExpanded(boolean z) {
        this.f41817c = z;
    }

    public static final class a extends BottomSheetBehavior.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBehavior f41819a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BottomSheetBaseView f41820b;

        public final void onSlide(View view, float f2) {
            k.c(view, "bottomSheet");
        }

        a(BottomSheetBehavior bottomSheetBehavior, BottomSheetBaseView bottomSheetBaseView) {
            this.f41819a = bottomSheetBehavior;
            this.f41820b = bottomSheetBaseView;
        }

        public final void onStateChanged(View view, int i2) {
            k.c(view, "bottomSheet");
            if (!this.f41820b.f41816b && i2 == 1) {
                this.f41819a.setState(4);
                this.f41820b.setExpanded(false);
            } else if (i2 == 5) {
                this.f41820b.f41815a.dismiss();
                this.f41820b.setExpanded(false);
            } else if (i2 == 3) {
                this.f41820b.setExpanded(true);
            }
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BottomSheetBaseView f41821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f41822b;

        b(BottomSheetBaseView bottomSheetBaseView, View view) {
            this.f41821a = bottomSheetBaseView;
            this.f41822b = view;
        }

        public final void onGlobalLayout() {
            this.f41821a.setPeekHeight(this.f41822b.getHeight());
            View findViewById = this.f41822b.findViewById(R.id.container);
            k.a((Object) findViewById, "v.findViewById<View>(R.id.container)");
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = this.f41821a.getHeightMethod();
            this.f41822b.setLayoutParams(layoutParams);
            this.f41822b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getDisplayMetrics();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getHeightMethod() {
        /*
            r2 = this;
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
            r1 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 * r1
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.bottomsheet.BottomSheetBaseView.getHeightMethod():int");
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
        this.f41815a.setCancelable(z);
    }
}
