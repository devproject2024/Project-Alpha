package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class DisablePaymentMode extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "channels")
    private List<? extends Object> channels;
    @b(a = "mode")
    private String mode;

    public DisablePaymentMode() {
        this((String) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ DisablePaymentMode copy$default(DisablePaymentMode disablePaymentMode, String str, List<? extends Object> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = disablePaymentMode.mode;
        }
        if ((i2 & 2) != 0) {
            list = disablePaymentMode.channels;
        }
        return disablePaymentMode.copy(str, list);
    }

    public final String component1() {
        return this.mode;
    }

    public final List<Object> component2() {
        return this.channels;
    }

    public final DisablePaymentMode copy(String str, List<? extends Object> list) {
        return new DisablePaymentMode(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisablePaymentMode)) {
            return false;
        }
        DisablePaymentMode disablePaymentMode = (DisablePaymentMode) obj;
        return k.a((Object) this.mode, (Object) disablePaymentMode.mode) && k.a((Object) this.channels, (Object) disablePaymentMode.channels);
    }

    public final int hashCode() {
        String str = this.mode;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<? extends Object> list = this.channels;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "DisablePaymentMode(mode=" + this.mode + ", channels=" + this.channels + ")";
    }

    public DisablePaymentMode(String str, List<? extends Object> list) {
        this.mode = str;
        this.channels = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DisablePaymentMode(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final Object clone() {
        return super.clone();
    }

    public final List<Object> getChannels() {
        return this.channels;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setChannels(List<? extends Object> list) {
        this.channels = list;
    }

    public final void setMode(String str) {
        this.mode = str;
    }
}
