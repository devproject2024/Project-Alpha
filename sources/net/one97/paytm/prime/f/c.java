package net.one97.paytm.prime.f;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class c extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f59797a;

    public c(int i2) {
        this.f59797a = i2;
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2 = this.f59797a;
        rect.left = i2;
        rect.right = i2;
        rect.bottom = i2;
        rect.top = 0;
    }
}
