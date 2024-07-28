package com.travel.train.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.l;
import com.travel.train.model.trainticket.e;

public final class ae extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27772a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27773b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f27774c;

    /* renamed from: d  reason: collision with root package name */
    private l f27775d;

    public ae(View view, l lVar) {
        super(view);
        this.f27772a = (TextView) view.findViewById(R.id.text_view_contact_name);
        this.f27773b = (TextView) view.findViewById(R.id.text_view_contact_number);
        this.f27774c = (ImageView) view.findViewById(R.id.image_view_remove);
        this.f27774c.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.f27775d = lVar;
        this.f27774c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ae.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f27775d.a(e.CONTACT, getAdapterPosition());
    }
}
