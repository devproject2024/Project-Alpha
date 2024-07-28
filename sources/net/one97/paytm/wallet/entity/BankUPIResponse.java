package net.one97.paytm.wallet.entity;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;

public final class BankUPIResponse extends IJRPaytmDataModel implements IJRDataModel {
    private List<? extends UpiProfileDefaultBank> profileVpaList;

    public static /* synthetic */ BankUPIResponse copy$default(BankUPIResponse bankUPIResponse, List<? extends UpiProfileDefaultBank> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = bankUPIResponse.profileVpaList;
        }
        return bankUPIResponse.copy(list);
    }

    public final List<UpiProfileDefaultBank> component1() {
        return this.profileVpaList;
    }

    public final BankUPIResponse copy(List<? extends UpiProfileDefaultBank> list) {
        return new BankUPIResponse(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BankUPIResponse) && k.a((Object) this.profileVpaList, (Object) ((BankUPIResponse) obj).profileVpaList);
        }
        return true;
    }

    public final int hashCode() {
        List<? extends UpiProfileDefaultBank> list = this.profileVpaList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "BankUPIResponse(profileVpaList=" + this.profileVpaList + ")";
    }

    public BankUPIResponse(List<? extends UpiProfileDefaultBank> list) {
        this.profileVpaList = list;
    }

    public final List<UpiProfileDefaultBank> getProfileVpaList() {
        return this.profileVpaList;
    }

    public final void setProfileVpaList(List<? extends UpiProfileDefaultBank> list) {
        this.profileVpaList = list;
    }
}
