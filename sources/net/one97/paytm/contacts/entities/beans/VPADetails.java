package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class VPADetails extends IJRPaytmDataModel implements IJRDataModel {
    private final String name;
    private final String vpa;

    public static /* synthetic */ VPADetails copy$default(VPADetails vPADetails, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = vPADetails.vpa;
        }
        if ((i2 & 2) != 0) {
            str2 = vPADetails.name;
        }
        return vPADetails.copy(str, str2);
    }

    public final String component1() {
        return this.vpa;
    }

    public final String component2() {
        return this.name;
    }

    public final VPADetails copy(String str, String str2) {
        k.c(str, "vpa");
        k.c(str2, "name");
        return new VPADetails(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VPADetails)) {
            return false;
        }
        VPADetails vPADetails = (VPADetails) obj;
        return k.a((Object) this.vpa, (Object) vPADetails.vpa) && k.a((Object) this.name, (Object) vPADetails.name);
    }

    public final int hashCode() {
        String str = this.vpa;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "VPADetails(vpa=" + this.vpa + ", name=" + this.name + ")";
    }

    public VPADetails(String str, String str2) {
        k.c(str, "vpa");
        k.c(str2, "name");
        this.vpa = str;
        this.name = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getVpa() {
        return this.vpa;
    }
}
