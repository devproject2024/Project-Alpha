package com.travel.train.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.l;
import com.travel.train.model.trainticket.e;

public final class af extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27776a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f27777b;

    /* renamed from: c  reason: collision with root package name */
    private l f27778c;

    public af(View view, l lVar) {
        super(view);
        this.f27776a = (TextView) view.findViewById(R.id.text_view_email);
        this.f27777b = (ImageView) view.findViewById(R.id.image_view_remove);
        this.f27778c = lVar;
        this.f27777b.setImageResource(com.travel.common.R.drawable.travel_res_common_close);
        this.f27777b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                af.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f27778c.a(e.EMAIL, getAdapterPosition());
    }
}
