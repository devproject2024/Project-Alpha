package com.travel.bus.busticket.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;

public final class j extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f22163a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22164b;

    public j(View view) {
        super(view);
        this.f22163a = (ImageView) view.findViewById(R.id.amenityGridIcon);
        this.f22164b = (TextView) view.findViewById(R.id.amenityName);
    }
}
