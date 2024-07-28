package com.travel.bus.orders.i;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.orders.a.b;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.pojo.hotel.CJRHotelObject;

public final class o extends a {

    /* renamed from: a  reason: collision with root package name */
    private CJRHotelObject f22777a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f22778b;

    /* renamed from: c  reason: collision with root package name */
    private Context f22779c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22780d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f22781e;

    public o(View view, CJRHotelObject cJRHotelObject) {
        super(view);
        this.f22777a = cJRHotelObject;
        this.f22779c = view.getContext();
        this.f22778b = (TextView) view.findViewById(R.id.hotel_layout_title);
        this.f22780d = (TextView) view.findViewById(R.id.hotel_layout_view_all);
        this.f22781e = (RecyclerView) view.findViewById(R.id.hotel_recyclerview);
        this.f22780d.setOnClickListener(new View.OnClickListener(cJRHotelObject) {
            private final /* synthetic */ CJRHotelObject f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                o.this.a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRHotelObject cJRHotelObject, View view) {
        if (cJRHotelObject.getAllHotelsLink() != null && !cJRHotelObject.getAllHotelsLink().isEmpty()) {
            com.travel.bus.a.a();
            com.travel.bus.a.b().b(cJRHotelObject.getAllHotelsLink(), this.f22779c);
        }
    }

    public final void a(c.b bVar) {
        CJRHotelObject cJRHotelObject = this.f22777a;
        if (cJRHotelObject != null) {
            this.f22778b.setText(cJRHotelObject.getWidgetTitle());
            this.f22781e.setAdapter(new b(this.f22779c, this.f22777a.getData()));
            this.f22781e.setLayoutManager(new LinearLayoutManager(this.f22779c, 0, false));
            this.f22781e.setHasFixedSize(true);
        }
    }
}
