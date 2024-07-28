package net.one97.paytm.feed.ui.feed.h.b;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f35066a;

    private a(int i2) {
        this.f35066a = i2;
    }

    public a(Context context, int i2) {
        this(context.getResources().getDimensionPixelSize(i2));
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        super.getItemOffsets(rect, view, recyclerView, sVar);
        int i2 = this.f35066a;
        rect.set(i2, i2, i2, i2);
    }
}
