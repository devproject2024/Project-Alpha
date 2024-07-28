package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class Address implements IJRDataModel {
    @b(a = "correspondenceAddress")
    private CorrespondenceAddress coresspondenceAddress;
    @b(a = "permanentAddress")
    private PermanentAddress permanentAddress;

    public static /* synthetic */ Address copy$default(Address address, PermanentAddress permanentAddress2, CorrespondenceAddress correspondenceAddress, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            permanentAddress2 = address.permanentAddress;
        }
        if ((i2 & 2) != 0) {
            correspondenceAddress = address.coresspondenceAddress;
        }
        return address.copy(permanentAddress2, correspondenceAddress);
    }

    public final PermanentAddress component1() {
        return this.permanentAddress;
    }

    public final CorrespondenceAddress component2() {
        return this.coresspondenceAddress;
    }

    public final Address copy(PermanentAddress permanentAddress2, CorrespondenceAddress correspondenceAddress) {
        k.c(correspondenceAddress, "coresspondenceAddress");
        return new Address(permanentAddress2, correspondenceAddress);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return k.a((Object) this.permanentAddress, (Object) address.permanentAddress) && k.a((Object) this.coresspondenceAddress, (Object) address.coresspondenceAddress);
    }

    public final int hashCode() {
        PermanentAddress permanentAddress2 = this.permanentAddress;
        int i2 = 0;
        int hashCode = (permanentAddress2 != null ? permanentAddress2.hashCode() : 0) * 31;
        CorrespondenceAddress correspondenceAddress = this.coresspondenceAddress;
        if (correspondenceAddress != null) {
            i2 = correspondenceAddress.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "Address(permanentAddress=" + this.permanentAddress + ", coresspondenceAddress=" + this.coresspondenceAddress + ")";
    }

    public Address(PermanentAddress permanentAddress2, CorrespondenceAddress correspondenceAddress) {
        k.c(correspondenceAddress, "coresspondenceAddress");
        this.permanentAddress = permanentAddress2;
        this.coresspondenceAddress = correspondenceAddress;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Address(PermanentAddress permanentAddress2, CorrespondenceAddress correspondenceAddress, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : permanentAddress2, correspondenceAddress);
    }

    public final PermanentAddress getPermanentAddress() {
        return this.permanentAddress;
    }

    public final void setPermanentAddress(PermanentAddress permanentAddress2) {
        this.permanentAddress = permanentAddress2;
    }

    public final CorrespondenceAddress getCoresspondenceAddress() {
        return this.coresspondenceAddress;
    }

    public final void setCoresspondenceAddress(CorrespondenceAddress correspondenceAddress) {
        k.c(correspondenceAddress, "<set-?>");
        this.coresspondenceAddress = correspondenceAddress;
    }
}
