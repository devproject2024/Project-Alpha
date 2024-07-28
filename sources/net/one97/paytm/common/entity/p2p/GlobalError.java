package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class GlobalError extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "errorList")
    private List<PCError> errorList;

    public GlobalError() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ GlobalError copy$default(GlobalError globalError, List<PCError> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = globalError.errorList;
        }
        return globalError.copy(list);
    }

    public final List<PCError> component1() {
        return this.errorList;
    }

    public final GlobalError copy(List<PCError> list) {
        return new GlobalError(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GlobalError) && k.a((Object) this.errorList, (Object) ((GlobalError) obj).errorList);
        }
        return true;
    }

    public final int hashCode() {
        List<PCError> list = this.errorList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "GlobalError(errorList=" + this.errorList + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public GlobalError(List<PCError> list) {
        this.errorList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobalError(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<PCError> getErrorList() {
        return this.errorList;
    }

    public final void setErrorList(List<PCError> list) {
        this.errorList = list;
    }
}
