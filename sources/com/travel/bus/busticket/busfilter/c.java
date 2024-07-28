package com.travel.bus.busticket.busfilter;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.travel.bus.pojo.busticket.CJRBusTicketFilters;
import kotlin.g.b.k;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<CJRBusTicketFilters> f22105a = new y<>();

    public final void a(CJRBusTicketFilters cJRBusTicketFilters) {
        k.c(cJRBusTicketFilters, "item");
        y<CJRBusTicketFilters> yVar = this.f22105a;
        if (yVar == null) {
            k.a();
        }
        yVar.setValue(cJRBusTicketFilters);
    }
}
