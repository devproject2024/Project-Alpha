package com.travel.bus.busticket.i;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import kotlin.g.b.k;
import kotlin.u;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f22431a = new e();

    private e() {
    }

    public static final int a(w wVar, boolean z, boolean z2) {
        k.c(wVar, "name");
        int i2 = f.f22432a[wVar.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 5) {
                        if (!z2 || !z) {
                            return (z || z2) ? 3 : 2;
                        }
                        return 4;
                    }
                } else if (!z2 || !z) {
                    return (z || z2) ? 2 : 1;
                } else {
                    return 3;
                }
            } else if (!z) {
                return -1;
            } else {
                return z2 ? 2 : 1;
            }
        } else if (z2) {
            return 1;
        }
        return -1;
    }

    public static final void a(TabLayout tabLayout, int i2, int i3) {
        k.c(tabLayout, "tabLayout");
        View childAt = tabLayout.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) childAt;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = viewGroup.getChildAt(i4);
                k.a((Object) childAt2, "tabView");
                childAt2.setMinimumWidth(0);
                childAt2.setPadding(0, childAt2.getPaddingTop(), 0, childAt2.getPaddingBottom());
                if (childAt2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    if (layoutParams != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (i4 == 0) {
                            a(marginLayoutParams, i2, 0);
                        } else if (i4 == childCount - 1) {
                            a(marginLayoutParams, i3, i2);
                        } else {
                            a(marginLayoutParams, i3, 0);
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                }
            }
            tabLayout.requestLayout();
        }
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i2);
            marginLayoutParams.setMarginEnd(i3);
        }
        marginLayoutParams.leftMargin = i2;
        marginLayoutParams.rightMargin = i3;
    }
}
