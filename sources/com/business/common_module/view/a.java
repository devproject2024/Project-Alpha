package com.business.common_module.view;

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
import com.business.common_module.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public final class a extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BottomSheetBehavior<FrameLayout> f7372a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7373b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7374c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7375d;

    /* renamed from: e  reason: collision with root package name */
    private BottomSheetBehavior.a f7376e;

    public final void setContentView(int i2) {
        super.setContentView(a(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    public final void onCreate(Bundle bundle) {
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

    public final void setContentView(View view) {
        super.setContentView(a(0, view, (ViewGroup.LayoutParams) null));
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(a(0, view, layoutParams));
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f7373b != z) {
            this.f7373b = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f7372a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f7372a;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f7373b) {
            this.f7373b = true;
        }
        this.f7374c = z;
        this.f7375d = true;
    }

    private View a(int i2, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.common_design_custom_bottom_sheet_dialog, (ViewGroup) null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) coordinatorLayout.findViewById(R.id.design_bottom_sheet);
        this.f7372a = BottomSheetBehavior.from(frameLayout2);
        this.f7372a.setBottomSheetCallback(this.f7376e);
        this.f7372a.setHideable(this.f7373b);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.this.f7373b && a.this.isShowing() && a.c(a.this)) {
                    a.this.cancel();
                }
            }
        });
        u.a((View) frameLayout2, (androidx.core.h.a) new androidx.core.h.a() {
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                if (a.this.f7373b) {
                    cVar.a(1048576);
                    cVar.k(true);
                    return;
                }
                cVar.k(false);
            }

            public final boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
                if (i2 != 1048576 || !a.this.f7373b) {
                    return super.performAccessibilityAction(view, i2, bundle);
                }
                a.this.cancel();
                return true;
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
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
            int r2 = com.business.common_module.R.attr.bottomSheetDialogTheme
            boolean r1 = r1.resolveAttribute(r2, r5, r0)
            if (r1 == 0) goto L_0x0017
            int r5 = r5.resourceId
            goto L_0x0019
        L_0x0017:
            int r5 = com.business.common_module.R.style.Theme_Design_Light_BottomSheetDialog
        L_0x0019:
            r3.<init>(r4, r5)
            r3.f7373b = r0
            r3.f7374c = r0
            com.business.common_module.view.a$1 r4 = new com.business.common_module.view.a$1
            r4.<init>()
            r3.f7376e = r4
            r3.supportRequestWindowFeature(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common_module.view.a.<init>(android.content.Context, int):void");
    }

    static /* synthetic */ boolean c(a aVar) {
        if (!aVar.f7375d) {
            if (Build.VERSION.SDK_INT < 11) {
                aVar.f7374c = true;
            } else {
                TypedArray obtainStyledAttributes = aVar.getContext().obtainStyledAttributes(new int[]{16843611});
                aVar.f7374c = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            aVar.f7375d = true;
        }
        return aVar.f7374c;
    }
}
