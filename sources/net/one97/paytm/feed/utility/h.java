package net.one97.paytm.feed.utility;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class h extends RecyclerView.h {
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        k.c(rect, "outRect");
        k.c(view, "view");
        k.c(recyclerView, "parent");
        k.c(sVar, "state");
        if (recyclerView.getChildAdapterPosition(view) == sVar.a() - 1) {
            r rVar = r.f35432a;
            Context context = view.getContext();
            k.a((Object) context, "view.context");
            rect.right = (int) r.a(20.0f, context);
        } else if (recyclerView.getChildAdapterPosition(view) == 0) {
            r rVar2 = r.f35432a;
            Context context2 = view.getContext();
            k.a((Object) context2, "view.context");
            rect.right = (int) r.a(5.0f, context2);
        } else {
            r rVar3 = r.f35432a;
            Context context3 = view.getContext();
            k.a((Object) context3, "view.context");
            rect.left = (int) r.a(5.0f, context3);
            r rVar4 = r.f35432a;
            Context context4 = view.getContext();
            k.a((Object) context4, "view.context");
            rect.right = (int) r.a(5.0f, context4);
        }
    }
}
