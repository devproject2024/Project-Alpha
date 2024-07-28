package net.one97.paytm.hotel4.service.model.details;

import java.util.List;
import kotlin.g.b.g;

public final class Images {
    private List<String> full;

    public Images() {
        this((List) null, 1, (g) null);
    }

    public Images(List<String> list) {
        this.full = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Images(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<String> getFull() {
        return this.full;
    }

    public final void setFull(List<String> list) {
        this.full = list;
    }
}
