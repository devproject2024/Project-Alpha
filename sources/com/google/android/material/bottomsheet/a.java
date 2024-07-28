package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.f;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    BottomSheetBehavior<FrameLayout> f36010a;

    /* renamed from: b  reason: collision with root package name */
    boolean f36011b;

    /* renamed from: c  reason: collision with root package name */
    boolean f36012c;

    /* renamed from: d  reason: collision with root package name */
    boolean f36013d;

    /* renamed from: e  reason: collision with root package name */
    boolean f36014e;

    /* renamed from: f  reason: collision with root package name */
    BottomSheetBehavior.a f36015f;

    /* renamed from: g  reason: collision with root package name */
    private FrameLayout f36016g;

    public a(Context context) {
        this(context, 0);
    }

    public void setContentView(int i2) {
        super.setContentView(a(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setLayout(-1, -1);
        }
    }

    public void setContentView(View view) {
        super.setContentView(a(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f36012c != z) {
            this.f36012c = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f36010a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f36010a;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.f36010a.setState(4);
        }
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> a2 = a();
        if (!this.f36011b || a2.getState() == 5) {
            super.cancel();
        } else {
            a2.setState(5);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f36012c) {
            this.f36012c = true;
        }
        this.f36013d = z;
        this.f36014e = true;
    }

    public final BottomSheetBehavior<FrameLayout> a() {
        if (this.f36010a == null) {
            b();
        }
        return this.f36010a;
    }

    private FrameLayout b() {
        if (this.f36016g == null) {
            this.f36016g = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.f36010a = BottomSheetBehavior.from((FrameLayout) this.f36016g.findViewById(R.id.design_bottom_sheet));
            this.f36010a.addBottomSheetCallback(this.f36015f);
            this.f36010a.setHideable(this.f36012c);
        }
        return this.f36016g;
    }

    private View a(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        b();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f36016g.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        FrameLayout frameLayout = (FrameLayout) this.f36016g.findViewById(R.id.design_bottom_sheet);
        frameLayout.removeAllViews();
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.this.f36012c && a.this.isShowing()) {
                    a aVar = a.this;
                    if (!aVar.f36014e) {
                        TypedArray obtainStyledAttributes = aVar.getContext().obtainStyledAttributes(new int[]{16843611});
                        aVar.f36013d = obtainStyledAttributes.getBoolean(0, true);
                        obtainStyledAttributes.recycle();
                        aVar.f36014e = true;
                    }
                    if (aVar.f36013d) {
                        a.this.cancel();
                    }
                }
            }
        });
        u.a((View) frameLayout, (androidx.core.h.a) new androidx.core.h.a() {
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                if (a.this.f36012c) {
                    cVar.a(1048576);
                    cVar.k(true);
                    return;
                }
                cVar.k(false);
            }

            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 != 1048576 || !a.this.f36012c) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                a.this.cancel();
                return true;
            }
        });
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.f36016g;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.content.Context r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 != 0) goto L_0x0019
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources$Theme r1 = r4.getTheme()
            int r2 = com.google.android.material.R.attr.bottomSheetDialogTheme
            boolean r1 = r1.resolveAttribute(r2, r5, r0)
            if (r1 == 0) goto L_0x0017
            int r5 = r5.resourceId
            goto L_0x0019
        L_0x0017:
            int r5 = com.google.android.material.R.style.Theme_Design_Light_BottomSheetDialog
        L_0x0019:
            r3.<init>(r4, r5)
            r3.f36012c = r0
            r3.f36013d = r0
            com.google.android.material.bottomsheet.a$4 r4 = new com.google.android.material.bottomsheet.a$4
            r4.<init>()
            r3.f36015f = r4
            r3.supportRequestWindowFeature(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.a.<init>(android.content.Context, int):void");
    }
}
