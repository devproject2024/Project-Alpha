package com.travel.flight.flightticket.j;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightticket.f.k;
import com.travel.flight.pojo.flightticket.FlightSellingBundleResponseData;
import java.util.List;

public final class c extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private Context f25123a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f25124b = ((RecyclerView) this.f25126d.findViewById(R.id.recyler_view));

    /* renamed from: c  reason: collision with root package name */
    private com.travel.flight.flightticket.a.c f25125c;

    /* renamed from: d  reason: collision with root package name */
    private View f25126d;

    /* renamed from: e  reason: collision with root package name */
    private Context f25127e;

    /* renamed from: f  reason: collision with root package name */
    private List<FlightSellingBundleResponseData> f25128f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, Context context, List<FlightSellingBundleResponseData> list, k kVar, String str) {
        super(view);
        kotlin.g.b.k.c(view, "view");
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(list, "data");
        kotlin.g.b.k.c(kVar, "mIternaryActionListener");
        kotlin.g.b.k.c(str, "totalFare");
        this.f25126d = view;
        this.f25127e = context;
        this.f25128f = list;
        Context context2 = this.f25127e;
        this.f25123a = context2;
        this.f25125c = new com.travel.flight.flightticket.a.c(this.f25128f, context2, kVar, str);
        RecyclerView recyclerView = this.f25124b;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.f25125c);
        }
    }
}
