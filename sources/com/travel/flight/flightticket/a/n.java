package com.travel.flight.flightticket.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.flight.R;
import com.travel.flight.pojo.flightticket.e;
import com.travel.flight.pojo.flightticket.h;

public final class n extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f24713a;

    /* renamed from: b  reason: collision with root package name */
    private h[] f24714b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        h hVar = this.f24714b[i2];
        e[] content = hVar.getContent();
        if (content != null && content.length >= 2) {
            e eVar = content[0];
            e eVar2 = content[1];
            aVar.f24715a.setText(eVar.getText());
            if (TextUtils.isEmpty(eVar.getSubText())) {
                aVar.f24716b.setVisibility(8);
            } else {
                aVar.f24716b.setVisibility(0);
                aVar.f24716b.setText(eVar.getSubText());
            }
            aVar.f24718d.setText(eVar2.getText());
            if (TextUtils.isEmpty(eVar2.getSubText())) {
                aVar.f24719e.setVisibility(8);
            } else {
                aVar.f24719e.setVisibility(0);
                aVar.f24719e.setText(eVar2.getSubText());
            }
        }
        b.a.C0750a a2 = b.a(aVar.f24717c.getContext());
        a2.f43753a = hVar.getImgUrl();
        b.a.C0750a.a(a2.a((Object) Integer.valueOf(R.color.gray)).b(Integer.valueOf(R.color.gray)), aVar.f24717c, (com.paytm.utility.b.b.b) null, 2);
    }

    public n(LayoutInflater layoutInflater, h[] hVarArr) {
        this.f24713a = layoutInflater;
        this.f24714b = hVarArr;
        h[] hVarArr2 = this.f24714b;
    }

    public final int getItemCount() {
        return this.f24714b.length;
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f24715a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24716b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f24717c;

        /* renamed from: d  reason: collision with root package name */
        TextView f24718d;

        /* renamed from: e  reason: collision with root package name */
        TextView f24719e;

        public a(View view) {
            super(view);
            this.f24715a = (TextView) view.findViewById(R.id.text_view_mam_row_header);
            this.f24716b = (TextView) view.findViewById(R.id.text_view_mam_row_sub_header);
            this.f24717c = (ImageView) view.findViewById(R.id.img_view_mam_row_info);
            this.f24718d = (TextView) view.findViewById(R.id.text_view_mam_row_duration_header);
            this.f24719e = (TextView) view.findViewById(R.id.text_view_mam_row_duration_sub_header);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(this.f24713a.inflate(R.layout.pre_f_multi_airline_message_row, viewGroup, false));
    }
}
