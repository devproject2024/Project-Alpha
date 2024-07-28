package com.travel.bus.busticket.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.busticket.e.a;
import java.util.ArrayList;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f21620a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<com.travel.bus.model.a> f21621b;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        Context context = this.f21620a;
        com.travel.bus.model.a aVar2 = this.f21621b.get(i2);
        if (aVar2 == null || TextUtils.isEmpty(aVar2.f22541b)) {
            aVar.f22128a.setVisibility(8);
        } else {
            aVar.f22128a.setVisibility(0);
            if (URLUtil.isValidUrl(aVar2.f22541b)) {
                b.a.C0750a a2 = b.a(context);
                a2.f43753a = aVar2.f22541b;
                a2.m = true;
                b.a.C0750a.a(a2, aVar.f22128a, (com.paytm.utility.b.b.b) null, 2);
            }
        }
        if (aVar2 == null || aVar2.f22540a == null || TextUtils.isEmpty(aVar2.f22540a)) {
            aVar.f22129b.setVisibility(8);
            aVar.f22128a.setVisibility(8);
            return;
        }
        aVar.f22129b.setText(aVar2.f22540a);
        aVar.f22129b.setVisibility(0);
    }

    public c(Context context, ArrayList<com.travel.bus.model.a> arrayList) {
        this.f21620a = context;
        this.f21621b = arrayList;
    }

    public final int getItemCount() {
        return this.f21621b.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f21620a).inflate(R.layout.pre_b_item_bus_operator_tag, (ViewGroup) null));
    }
}
