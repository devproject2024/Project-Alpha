package com.travel.bus.orders.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import kotlin.g.b.k;

public final class c extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private final int f22644a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22645b = 3;

    public c(Context context) {
        k.c(context, "context");
        this.f22644a = b.a(-8.0f, context);
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        if (recyclerView.getChildAdapterPosition(view) != this.f22645b) {
            rect.right = this.f22644a;
        }
    }
}
