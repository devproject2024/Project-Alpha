package com.travel.train.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.i.o;
import com.travel.train.model.trainticket.a;
import com.travel.utils.n;

public final class aq extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f27848a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27849b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27850c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27851d;

    /* renamed from: e  reason: collision with root package name */
    public a f27852e;

    /* renamed from: f  reason: collision with root package name */
    private View f27853f;

    /* renamed from: g  reason: collision with root package name */
    private o f27854g;

    public aq(View view, o oVar) {
        super(view);
        this.f27853f = view;
        this.f27848a = (ImageView) view.findViewById(R.id.image_view_contact);
        ResourceUtils.loadBusImagesFromCDN(this.f27848a, "", false, false, n.a.V1);
        this.f27849b = (TextView) view.findViewById(R.id.text_view_contact_name);
        this.f27850c = (TextView) view.findViewById(R.id.text_view_contact_number);
        this.f27851d = (TextView) view.findViewById(R.id.text_view_display_char);
        this.f27854g = oVar;
        this.f27853f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                aq.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f27854g.a(this.f27852e);
    }
}
