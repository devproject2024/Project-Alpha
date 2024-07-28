package com.travel.bus.orders.f;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

public interface a {
    void a(com.travel.bus.orders.b.a aVar, CJROrderSummaryAction cJROrderSummaryAction);

    ScheduledExecutorService b();

    Context c();
}
