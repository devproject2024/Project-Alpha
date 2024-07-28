package com.travel.flight.flightticket.j;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import kotlin.g.b.k;

public final class t extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f25209a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f25210b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f25211c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(View view) {
        super(view);
        k.c(view, "view");
        View findViewById = view.findViewById(R.id.title);
        k.a((Object) findViewById, "view.findViewById(R.id.title)");
        this.f25209a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        k.a((Object) findViewById2, "view.findViewById(R.id.subtitle)");
        this.f25210b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.img);
        k.a((Object) findViewById3, "view.findViewById(R.id.img)");
        this.f25211c = (ImageView) findViewById3;
    }
}
