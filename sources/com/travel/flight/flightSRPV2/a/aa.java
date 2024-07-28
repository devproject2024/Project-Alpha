package com.travel.flight.flightSRPV2.a;

import com.travel.flight.pojo.flightticket.CJRFlightDetailsItem;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.utils.c;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;

public final class aa extends x {

    /* renamed from: a  reason: collision with root package name */
    public final int f24074a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24075b;

    public final boolean c() {
        return false;
    }

    public final int e() {
        return 4;
    }

    public final String g() {
        return "Price";
    }

    public final int i() {
        return 0;
    }

    static final class a extends l implements kotlin.g.a.b<CJRFlightDetailsItem, Boolean> {
        final /* synthetic */ aa this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(aa aaVar) {
            super(1);
            this.this$0 = aaVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRFlightDetailsItem) obj));
        }

        public final boolean invoke(CJRFlightDetailsItem cJRFlightDetailsItem) {
            int parseDouble;
            k.c(cJRFlightDetailsItem, "it");
            Collection collection = cJRFlightDetailsItem.getmPrice();
            String str = !(collection == null || collection.isEmpty()) ? cJRFlightDetailsItem.getmPrice().get(0).getmDisplayPrice() : null;
            CharSequence charSequence = str;
            return !(charSequence == null || p.a(charSequence)) && this.this$0.f24074a <= (parseDouble = (int) Double.parseDouble(str)) && parseDouble <= this.this$0.f24075b;
        }
    }

    static final class b extends l implements kotlin.g.a.b<CJRIntlFlightMapping, Boolean> {
        final /* synthetic */ aa this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(aa aaVar) {
            super(1);
            this.this$0 = aaVar;
        }

        public final /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(invoke((CJRIntlFlightMapping) obj));
        }

        public final boolean invoke(CJRIntlFlightMapping cJRIntlFlightMapping) {
            int parseDouble;
            k.c(cJRIntlFlightMapping, "it");
            String str = cJRIntlFlightMapping.getPricing().getmDisplayPrice();
            CharSequence charSequence = str;
            return !(charSequence == null || p.a(charSequence)) && this.this$0.f24074a <= (parseDouble = (int) Double.parseDouble(str)) && parseDouble <= this.this$0.f24075b;
        }
    }

    public aa(boolean z, int i2, int i3) {
        super(z);
        this.f24074a = i2;
        this.f24075b = i3;
    }

    public final String a() {
        return "Price ₹ " + c.a((double) this.f24074a) + " to ₹ " + c.a((double) this.f24075b);
    }

    public final kotlin.g.a.b<CJRFlightDetailsItem, Boolean> f() {
        return new a(this);
    }

    public final kotlin.g.a.b<CJRIntlFlightMapping, Boolean> j() {
        return new b(this);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Object obj) {
        if (!super.a(obj)) {
            return false;
        }
        int i2 = this.f24074a;
        if (obj != null) {
            aa aaVar = (aa) obj;
            return i2 == aaVar.f24074a && this.f24075b == aaVar.f24075b;
        }
        throw new u("null cannot be cast to non-null type com.travel.flight.flightSRPV2.datalayer.SRPPriceFilter");
    }

    public final /* synthetic */ Object b() {
        return new aa(this.f24136c, this.f24074a, this.f24075b);
    }
}
