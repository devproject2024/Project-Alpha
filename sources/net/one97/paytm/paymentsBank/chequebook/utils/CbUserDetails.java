package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbUserDetails extends IJRPaytmDataModel {
    @b(a = "phoneNumber")
    private final Integer phoneNumber;
    @b(a = "userAddress")
    private final CbUserAddress userAddress;

    public static /* synthetic */ CbUserDetails copy$default(CbUserDetails cbUserDetails, Integer num, CbUserAddress cbUserAddress, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cbUserDetails.phoneNumber;
        }
        if ((i2 & 2) != 0) {
            cbUserAddress = cbUserDetails.userAddress;
        }
        return cbUserDetails.copy(num, cbUserAddress);
    }

    public final Integer component1() {
        return this.phoneNumber;
    }

    public final CbUserAddress component2() {
        return this.userAddress;
    }

    public final CbUserDetails copy(Integer num, CbUserAddress cbUserAddress) {
        return new CbUserDetails(num, cbUserAddress);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbUserDetails)) {
            return false;
        }
        CbUserDetails cbUserDetails = (CbUserDetails) obj;
        return k.a((Object) this.phoneNumber, (Object) cbUserDetails.phoneNumber) && k.a((Object) this.userAddress, (Object) cbUserDetails.userAddress);
    }

    public final int hashCode() {
        Integer num = this.phoneNumber;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        CbUserAddress cbUserAddress = this.userAddress;
        if (cbUserAddress != null) {
            i2 = cbUserAddress.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CbUserDetails(phoneNumber=" + this.phoneNumber + ", userAddress=" + this.userAddress + ")";
    }

    public final Integer getPhoneNumber() {
        return this.phoneNumber;
    }

    public CbUserDetails(Integer num, CbUserAddress cbUserAddress) {
        this.phoneNumber = num;
        this.userAddress = cbUserAddress;
    }

    public final CbUserAddress getUserAddress() {
        return this.userAddress;
    }
}
