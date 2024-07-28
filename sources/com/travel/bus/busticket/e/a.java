package com.travel.bus.busticket.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;

public final class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f22128a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22129b;

    public a(View view) {
        super(view);
        this.f22128a = (ImageView) view.findViewById(R.id.operatorTagIcon);
        this.f22129b = (TextView) view.findViewById(R.id.operatorLable);
    }
}
