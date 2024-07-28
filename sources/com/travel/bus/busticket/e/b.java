package com.travel.bus.busticket.e;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.a.s;

public final class b extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f22130a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f22131b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f22132c;

    /* renamed from: d  reason: collision with root package name */
    public s f22133d;

    /* renamed from: e  reason: collision with root package name */
    public com.travel.bus.busticket.b.b f22134e;

    public b(View view, Context context, com.travel.bus.busticket.b.b bVar) {
        super(view);
        this.f22130a = context;
        this.f22134e = bVar;
        this.f22131b = (RelativeLayout) view.findViewById(R.id.amenity_layout);
        this.f22132c = (RecyclerView) view.findViewById(R.id.amenitieslist);
        AnonymousClass1 r1 = new LinearLayoutManager(this.f22130a) {
            public final boolean canScrollHorizontally() {
                return false;
            }
        };
        r1.setOrientation(0);
        this.f22132c.setLayoutManager(r1);
    }
}
