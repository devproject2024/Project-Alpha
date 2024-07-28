package com.travel.train.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.o;
import com.travel.train.model.trainticket.a;

public final class ao extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f27832a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27833b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27834c;

    /* renamed from: d  reason: collision with root package name */
    public a f27835d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f27836e;

    /* renamed from: f  reason: collision with root package name */
    private View f27837f;

    /* renamed from: g  reason: collision with root package name */
    private o f27838g;

    public ao(View view, o oVar) {
        super(view);
        this.f27837f = view;
        this.f27832a = (ImageView) view.findViewById(R.id.image_view_contact);
        this.f27833b = (TextView) view.findViewById(R.id.text_view_contact_name);
        this.f27834c = (TextView) view.findViewById(R.id.text_view_display_char);
        this.f27836e = (ImageView) view.findViewById(R.id.image_view_remove_contact);
        this.f27838g = oVar;
        this.f27837f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ao.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f27838g.b(this.f27835d);
    }
}
