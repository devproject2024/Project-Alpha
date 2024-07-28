package com.travel.bus.orders.f;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;

public interface i {
    int a(int i2);

    RecyclerView.v a(ViewGroup viewGroup, int i2);

    void a(RecyclerView.v vVar);

    void a(CJRActionResponse cJRActionResponse);

    void b(CJRBusOrderSummary cJRBusOrderSummary);

    void f();
}
