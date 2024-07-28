package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

final class x {
    static int a(RecyclerView.s sVar, u uVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        int i2;
        if (layoutManager.getChildCount() == 0 || sVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z2) {
            i2 = Math.max(0, (sVar.a() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(uVar.b(view2) - uVar.a(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (uVar.b() - uVar.a(view))));
    }

    static int a(RecyclerView.s sVar, u uVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || sVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(uVar.e(), uVar.b(view2) - uVar.a(view));
    }

    static int b(RecyclerView.s sVar, u uVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || sVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return sVar.a();
        }
        return (int) ((((float) (uVar.b(view2) - uVar.a(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) sVar.a()));
    }
}
