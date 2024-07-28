package com.travel.bus.busticket.e;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.b.a;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;

public final class o extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f22193a;

    /* renamed from: b  reason: collision with root package name */
    public CJRBusTicketFilterItem f22194b;

    /* renamed from: c  reason: collision with root package name */
    private View f22195c;

    /* renamed from: d  reason: collision with root package name */
    private a f22196d;

    public o(View view, a aVar) {
        super(view);
        this.f22196d = aVar;
        this.f22195c = view;
        this.f22193a = (TextView) view.findViewById(R.id.text_view_filter_name);
        this.f22195c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                o.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a aVar = this.f22196d;
        if (aVar != null) {
            aVar.onFilterRemoved(this.f22194b);
        }
    }
}
