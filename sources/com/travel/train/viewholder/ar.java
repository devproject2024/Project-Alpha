package com.travel.train.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.train.R;
import com.travel.train.i.p;
import com.travel.train.model.trainticket.c;

public final class ar extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f27855a;

    /* renamed from: b  reason: collision with root package name */
    public c f27856b;

    /* renamed from: c  reason: collision with root package name */
    private p f27857c;

    public ar(View view, p pVar) {
        super(view);
        this.f27855a = (TextView) view.findViewById(R.id.text_view_email_id);
        this.f27857c = pVar;
        this.f27855a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ar.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f27857c.a(this.f27856b);
    }
}
