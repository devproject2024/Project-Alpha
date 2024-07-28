package net.one97.paytm.feed.utility;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public final class n extends RecyclerView.h {

    /* renamed from: a  reason: collision with root package name */
    private int f35408a = 3;

    /* renamed from: b  reason: collision with root package name */
    private int f35409b = 50;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35410c = false;

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.f35408a;
        int i3 = childAdapterPosition % i2;
        if (this.f35410c) {
            int i4 = this.f35409b;
            rect.left = i4 - ((i3 * i4) / i2);
            rect.right = ((i3 + 1) * i4) / i2;
            if (childAdapterPosition < i2) {
                rect.top = i4;
            }
            rect.bottom = this.f35409b;
            return;
        }
        r rVar = r.f35432a;
        rect.left = (int) r.a(25.0f, view.getContext());
        int i5 = this.f35409b;
        int i6 = this.f35408a;
        rect.right = i5 - (((i3 + 1) * i5) / i6);
        if (childAdapterPosition >= i6) {
            rect.top = i5;
        }
    }
}
