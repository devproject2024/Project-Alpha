package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class TimeSlots implements IJRDataModel {
    @b(a = "availableSlots")
    private List<AvailableSlots> availableSlots;
    @b(a = "date")
    private String date;

    public TimeSlots() {
        this((String) null, (List) null, 3, (g) null);
    }

    public static /* synthetic */ TimeSlots copy$default(TimeSlots timeSlots, String str, List<AvailableSlots> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = timeSlots.date;
        }
        if ((i2 & 2) != 0) {
            list = timeSlots.availableSlots;
        }
        return timeSlots.copy(str, list);
    }

    public final String component1() {
        return this.date;
    }

    public final List<AvailableSlots> component2() {
        return this.availableSlots;
    }

    public final TimeSlots copy(String str, List<AvailableSlots> list) {
        return new TimeSlots(str, list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeSlots)) {
            return false;
        }
        TimeSlots timeSlots = (TimeSlots) obj;
        return k.a((Object) this.date, (Object) timeSlots.date) && k.a((Object) this.availableSlots, (Object) timeSlots.availableSlots);
    }

    public final int hashCode() {
        String str = this.date;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<AvailableSlots> list = this.availableSlots;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TimeSlots(date=" + this.date + ", availableSlots=" + this.availableSlots + ")";
    }

    public TimeSlots(String str, List<AvailableSlots> list) {
        this.date = str;
        this.availableSlots = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeSlots(String str, List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : list);
    }

    public final List<AvailableSlots> getAvailableSlots() {
        return this.availableSlots;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setAvailableSlots(List<AvailableSlots> list) {
        this.availableSlots = list;
    }

    public final void setDate(String str) {
        this.date = str;
    }
}
