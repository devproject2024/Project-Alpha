package net.one97.paytm.hotel4.service.model.details;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;

public final class TnC extends IJRPaytmDataModel {
    private List<String> conditions;

    public TnC() {
        this((List) null, 1, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TnC(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<String> getConditions() {
        return this.conditions;
    }

    public final void setConditions(List<String> list) {
        this.conditions = list;
    }

    public TnC(List<String> list) {
        this.conditions = list;
    }
}
