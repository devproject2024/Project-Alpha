package net.one97.paytm.vipcashback.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class c extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private Rect f21065a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21066b;

    public c(int i2, int i3, int i4) {
        this.f21065a = new Rect(i2, i3, i4, 0);
    }

    public c(int i2, int i3) {
        this.f21065a = new Rect(i2, 0, i3, 0);
        this.f21066b = true;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        int i3;
        int i4;
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        boolean z = true;
        int i5 = 0;
        if (this.f21066b) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition != sVar.a() - 1) {
                z = false;
            }
            if (!z || childAdapterPosition == 10) {
                Rect rect2 = this.f21065a;
                i3 = rect2 != null ? rect2.right : 0;
            } else {
                Rect rect3 = this.f21065a;
                i3 = (rect3 != null ? rect3.right : 0) * 2;
            }
            rect.right = i3;
            if (childAdapterPosition == 0) {
                Rect rect4 = this.f21065a;
                i4 = (rect4 != null ? rect4.left : 0) * 2;
            } else {
                Rect rect5 = this.f21065a;
                i4 = rect5 != null ? rect5.left : 0;
            }
            rect.left = i4;
            Rect rect6 = this.f21065a;
            rect.top = rect6 != null ? rect6.top : 0;
            Rect rect7 = this.f21065a;
            if (rect7 != null) {
                i5 = rect7.bottom;
            }
            rect.bottom = i5;
            return;
        }
        int childAdapterPosition2 = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition2 == 0 || childAdapterPosition2 == 1) {
            Rect rect8 = this.f21065a;
            int i6 = rect8 != null ? rect8.top : 0;
            Rect rect9 = this.f21065a;
            i2 = i6 + ((rect9 != null ? rect9.top : 0) / 4);
        } else {
            Rect rect10 = this.f21065a;
            i2 = rect10 != null ? rect10.top : 0;
        }
        rect.top = i2;
        Rect rect11 = this.f21065a;
        rect.right = rect11 != null ? rect11.right : 0;
        Rect rect12 = this.f21065a;
        rect.bottom = rect12 != null ? rect12.bottom : 0;
        Rect rect13 = this.f21065a;
        if (rect13 != null) {
            i5 = rect13.left;
        }
        rect.left = i5;
    }
}
