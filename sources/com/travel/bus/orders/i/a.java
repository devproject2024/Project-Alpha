package com.travel.bus.orders.i;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import kotlin.g.b.k;

public final class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f22646a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "itemView");
        TextView textView = (TextView) view.findViewById(R.id.tv_more_photos);
        k.a((Object) textView, "itemView.tv_more_photos");
        this.f22646a = textView;
    }
}
