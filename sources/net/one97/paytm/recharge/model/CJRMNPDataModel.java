package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.utils.ac;

public final class CJRMNPDataModel extends IJRPaytmDataModel {
    private final ac data;

    public CJRMNPDataModel() {
        this((ac) null, 1, (g) null);
    }

    public static /* synthetic */ CJRMNPDataModel copy$default(CJRMNPDataModel cJRMNPDataModel, ac acVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            acVar = cJRMNPDataModel.data;
        }
        return cJRMNPDataModel.copy(acVar);
    }

    public final ac component1() {
        return this.data;
    }

    public final CJRMNPDataModel copy(ac acVar) {
        return new CJRMNPDataModel(acVar);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof CJRMNPDataModel) && k.a((Object) this.data, (Object) ((CJRMNPDataModel) obj).data);
        }
        return true;
    }

    public final int hashCode() {
        ac acVar = this.data;
        if (acVar != null) {
            return acVar.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "CJRMNPDataModel(data=" + this.data + ")";
    }

    public CJRMNPDataModel(ac acVar) {
        this.data = acVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMNPDataModel(ac acVar, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : acVar);
    }

    public final ac getData() {
        return this.data;
    }

    public final IJRPaytmDataModel parseResponse(String str, f fVar) {
        return new CJRMNPDataModel(fVar != null ? (ac) fVar.a(str, ac.class) : null);
    }
}
