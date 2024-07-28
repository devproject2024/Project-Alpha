package net.one97.paytm.nativesdk.instruments.upicollect.models;

import java.io.Serializable;
import kotlin.g.b.k;

public final class RecurringDetails implements Serializable {
    private Boolean bankSupportedRecurring;
    private Boolean pspSupportedRecurring;

    public static /* synthetic */ RecurringDetails copy$default(RecurringDetails recurringDetails, Boolean bool, Boolean bool2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = recurringDetails.pspSupportedRecurring;
        }
        if ((i2 & 2) != 0) {
            bool2 = recurringDetails.bankSupportedRecurring;
        }
        return recurringDetails.copy(bool, bool2);
    }

    public final Boolean component1() {
        return this.pspSupportedRecurring;
    }

    public final Boolean component2() {
        return this.bankSupportedRecurring;
    }

    public final RecurringDetails copy(Boolean bool, Boolean bool2) {
        return new RecurringDetails(bool, bool2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecurringDetails)) {
            return false;
        }
        RecurringDetails recurringDetails = (RecurringDetails) obj;
        return k.a((Object) this.pspSupportedRecurring, (Object) recurringDetails.pspSupportedRecurring) && k.a((Object) this.bankSupportedRecurring, (Object) recurringDetails.bankSupportedRecurring);
    }

    public final int hashCode() {
        Boolean bool = this.pspSupportedRecurring;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.bankSupportedRecurring;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "RecurringDetails(pspSupportedRecurring=" + this.pspSupportedRecurring + ", bankSupportedRecurring=" + this.bankSupportedRecurring + ")";
    }

    public RecurringDetails(Boolean bool, Boolean bool2) {
        this.pspSupportedRecurring = bool;
        this.bankSupportedRecurring = bool2;
    }

    public final Boolean getPspSupportedRecurring() {
        return this.pspSupportedRecurring;
    }

    public final void setPspSupportedRecurring(Boolean bool) {
        this.pspSupportedRecurring = bool;
    }

    public final Boolean getBankSupportedRecurring() {
        return this.bankSupportedRecurring;
    }

    public final void setBankSupportedRecurring(Boolean bool) {
        this.bankSupportedRecurring = bool;
    }
}
