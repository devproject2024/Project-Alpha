package com.travel.train.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;

public final class i extends RecyclerView.v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f28133a;

    /* renamed from: b  reason: collision with root package name */
    private Context f28134b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f28135c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f28136d;

    public i(View view) {
        super(view);
        this.f28134b = view.getContext();
        this.f28136d = (ImageView) view.findViewById(R.id.tooltip_close);
        this.f28136d.setOnClickListener(this);
        this.f28135c = (LinearLayout) view.findViewById(R.id.payment_tooltip);
        this.f28133a = (TextView) view.findViewById(R.id.tooltip_contenttv);
    }

    public final void a(int i2) {
        LinearLayout linearLayout = this.f28135c;
        if (linearLayout != null) {
            linearLayout.setVisibility(i2);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.tooltip_close) {
            a(8);
        }
    }
}
