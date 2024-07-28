package com.travel.flight.flightorder.j;

import android.view.View;
import com.travel.flight.b.bg;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.g.b;
import com.travel.flight.pojo.ModifiedParentOrder;
import kotlin.g.b.k;

public final class l extends com.travel.flight.flightorder.f.a {

    /* renamed from: a  reason: collision with root package name */
    final ModifiedParentOrder f24537a;

    /* renamed from: b  reason: collision with root package name */
    final b f24538b;

    /* renamed from: c  reason: collision with root package name */
    private final bg f24539c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(bg bgVar, ModifiedParentOrder modifiedParentOrder, b bVar) {
        super(bgVar.getRoot());
        k.c(bgVar, "layoutModifiedOrderSummaryItemBinding");
        k.c(modifiedParentOrder, "modifiedParentOrder");
        k.c(bVar, "fragmentInteractionListener");
        this.f24539c = bgVar;
        this.f24537a = modifiedParentOrder;
        this.f24538b = bVar;
    }

    public final void a(b.C0467b bVar) {
        ModifiedParentOrder modifiedParentOrder = this.f24537a;
        if (modifiedParentOrder != null) {
            this.f24539c.a(modifiedParentOrder);
            this.f24539c.f23691b.setOnClickListener(new a(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24540a;

        a(l lVar) {
            this.f24540a = lVar;
        }

        public final void onClick(View view) {
            this.f24540a.f24538b.a(this.f24540a.f24537a.getOrderId());
        }
    }
}
