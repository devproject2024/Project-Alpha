package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sendbird.android.constant.StringSet;
import com.travel.common.R;
import com.travel.flight.b.co;
import com.travel.flight.flightSRPV2.a.x;
import com.travel.flight.flightSRPV2.a.z;
import java.util.List;
import kotlin.g.b.k;

public final class n extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public List<? extends x> f24212a;

    /* renamed from: b  reason: collision with root package name */
    public z f24213b;

    public n(List<? extends x> list, z zVar) {
        k.c(list, "filterList");
        this.f24212a = list;
        this.f24213b = zVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        x xVar = (x) this.f24212a.get(i2);
        z zVar = this.f24213b;
        int i3 = R.drawable.travel_res_common_close;
        k.c(xVar, StringSet.filter);
        aVar.f24214a.a(xVar);
        aVar.f24214a.a(zVar);
        aVar.f24214a.a(Integer.valueOf(i3));
        aVar.f24214a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        co a2 = co.a(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        k.a((Object) a2, "PreFFlightFilterItemV2Bi….context), parent, false)");
        return new a(a2);
    }

    public final int getItemCount() {
        return this.f24212a.size();
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final co f24214a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(co coVar) {
            super(coVar.getRoot());
            k.c(coVar, "binding");
            this.f24214a = coVar;
        }
    }
}
