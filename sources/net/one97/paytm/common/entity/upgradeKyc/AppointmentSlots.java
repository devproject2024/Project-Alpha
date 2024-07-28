package net.one97.paytm.common.entity.upgradeKyc;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class AppointmentSlots extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "timeSlots")
    private List<TimeSlots> timeSlotList;

    public AppointmentSlots() {
        this((List) null, 1, (g) null);
    }

    public static /* synthetic */ AppointmentSlots copy$default(AppointmentSlots appointmentSlots, List<TimeSlots> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = appointmentSlots.timeSlotList;
        }
        return appointmentSlots.copy(list);
    }

    public final List<TimeSlots> component1() {
        return this.timeSlotList;
    }

    public final AppointmentSlots copy(List<TimeSlots> list) {
        return new AppointmentSlots(list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AppointmentSlots) && k.a((Object) this.timeSlotList, (Object) ((AppointmentSlots) obj).timeSlotList);
        }
        return true;
    }

    public final int hashCode() {
        List<TimeSlots> list = this.timeSlotList;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "AppointmentSlots(timeSlotList=" + this.timeSlotList + ")";
    }

    public AppointmentSlots(List<TimeSlots> list) {
        this.timeSlotList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppointmentSlots(List list, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : list);
    }

    public final List<TimeSlots> getTimeSlotList() {
        return this.timeSlotList;
    }

    public final void setTimeSlotList(List<TimeSlots> list) {
        this.timeSlotList = list;
    }
}
