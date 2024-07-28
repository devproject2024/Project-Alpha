package net.one97.paytm.acceptPayment.storefront;

import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.model.GAEvent;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    final List<GAEvent> f52124a;

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof a) && k.a((Object) this.f52124a, (Object) ((a) obj).f52124a);
        }
        return true;
    }

    public final int hashCode() {
        List<GAEvent> list = this.f52124a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "AddGAEvent(events=" + this.f52124a + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(List<GAEvent> list) {
        super((byte) 0);
        k.d(list, EventsModuleManager.MODULE_NAME);
        this.f52124a = list;
    }
}
