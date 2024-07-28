package com.travel.bus.orders.i;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import kotlin.g.b.k;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f22647a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        k.c(view, "itemView");
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.ivPhoto);
        k.a((Object) appCompatImageView, "itemView.ivPhoto");
        this.f22647a = appCompatImageView;
    }
}
