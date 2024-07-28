package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class AvailableSlots implements IJRDataModel {
    @b(a = "availability")
    private String availability;
    @b(a = "timeRange")
    private String timeRange;

    public AvailableSlots() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ AvailableSlots copy$default(AvailableSlots availableSlots, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = availableSlots.timeRange;
        }
        if ((i2 & 2) != 0) {
            str2 = availableSlots.availability;
        }
        return availableSlots.copy(str, str2);
    }

    public final String component1() {
        return this.timeRange;
    }

    public final String component2() {
        return this.availability;
    }

    public final AvailableSlots copy(String str, String str2) {
        return new AvailableSlots(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvailableSlots)) {
            return false;
        }
        AvailableSlots availableSlots = (AvailableSlots) obj;
        return k.a((Object) this.timeRange, (Object) availableSlots.timeRange) && k.a((Object) this.availability, (Object) availableSlots.availability);
    }

    public final int hashCode() {
        String str = this.timeRange;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.availability;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AvailableSlots(timeRange=" + this.timeRange + ", availability=" + this.availability + ")";
    }

    public AvailableSlots(String str, String str2) {
        this.timeRange = str;
        this.availability = str2;
    }

    public final String getTimeRange() {
        return this.timeRange;
    }

    public final void setTimeRange(String str) {
        this.timeRange = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvailableSlots(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getAvailability() {
        return this.availability;
    }

    public final void setAvailability(String str) {
        this.availability = str;
    }
}
