package com.paytm.recyclerview;

import android.view.View;
import com.paytm.recyclerview.RecyclerView;

final class g {
    static int a(RecyclerView.n nVar, e eVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int i2;
        if (layoutManager.h() == 0 || nVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(RecyclerView.LayoutManager.a(view), RecyclerView.LayoutManager.a(view2));
        int max = Math.max(RecyclerView.LayoutManager.a(view), RecyclerView.LayoutManager.a(view2));
        if (z2) {
            i2 = Math.max(0, (nVar.a() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(eVar.b(view2) - eVar.a(view))) / ((float) (Math.abs(RecyclerView.LayoutManager.a(view) - RecyclerView.LayoutManager.a(view2)) + 1)))) + ((float) (eVar.b() - eVar.a(view))));
    }

    static int a(RecyclerView.n nVar, e eVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.h() == 0 || nVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(RecyclerView.LayoutManager.a(view) - RecyclerView.LayoutManager.a(view2)) + 1;
        }
        return Math.min(eVar.e(), eVar.b(view2) - eVar.a(view));
    }

    static int b(RecyclerView.n nVar, e eVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.h() == 0 || nVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return nVar.a();
        }
        return (int) ((((float) (eVar.b(view2) - eVar.a(view))) / ((float) (Math.abs(RecyclerView.LayoutManager.a(view) - RecyclerView.LayoutManager.a(view2)) + 1))) * ((float) nVar.a()));
    }
}
