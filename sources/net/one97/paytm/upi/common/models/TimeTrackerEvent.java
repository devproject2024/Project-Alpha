package net.one97.paytm.upi.common.models;

import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class TimeTrackerEvent implements IJRDataModel {
    private final long eventEndTime;
    private final String eventName;
    private final long eventStartTime;
    private final String flow;
    private final String status;
    private final long timeTaken;

    public static /* synthetic */ TimeTrackerEvent copy$default(TimeTrackerEvent timeTrackerEvent, String str, long j, long j2, long j3, String str2, String str3, int i2, Object obj) {
        TimeTrackerEvent timeTrackerEvent2 = timeTrackerEvent;
        return timeTrackerEvent.copy((i2 & 1) != 0 ? timeTrackerEvent2.eventName : str, (i2 & 2) != 0 ? timeTrackerEvent2.eventStartTime : j, (i2 & 4) != 0 ? timeTrackerEvent2.eventEndTime : j2, (i2 & 8) != 0 ? timeTrackerEvent2.timeTaken : j3, (i2 & 16) != 0 ? timeTrackerEvent2.status : str2, (i2 & 32) != 0 ? timeTrackerEvent2.flow : str3);
    }

    public final String component1() {
        return this.eventName;
    }

    public final long component2() {
        return this.eventStartTime;
    }

    public final long component3() {
        return this.eventEndTime;
    }

    public final long component4() {
        return this.timeTaken;
    }

    public final String component5() {
        return this.status;
    }

    public final String component6() {
        return this.flow;
    }

    public final TimeTrackerEvent copy(String str, long j, long j2, long j3, String str2, String str3) {
        k.c(str, "eventName");
        String str4 = str2;
        k.c(str4, "status");
        String str5 = str3;
        k.c(str5, "flow");
        return new TimeTrackerEvent(str, j, j2, j3, str4, str5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeTrackerEvent)) {
            return false;
        }
        TimeTrackerEvent timeTrackerEvent = (TimeTrackerEvent) obj;
        return k.a((Object) this.eventName, (Object) timeTrackerEvent.eventName) && this.eventStartTime == timeTrackerEvent.eventStartTime && this.eventEndTime == timeTrackerEvent.eventEndTime && this.timeTaken == timeTrackerEvent.timeTaken && k.a((Object) this.status, (Object) timeTrackerEvent.status) && k.a((Object) this.flow, (Object) timeTrackerEvent.flow);
    }

    public final int hashCode() {
        String str = this.eventName;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.eventStartTime;
        long j2 = this.eventEndTime;
        long j3 = this.timeTaken;
        int i3 = ((((((hashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        String str2 = this.status;
        int hashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.flow;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public TimeTrackerEvent(String str, long j, long j2, long j3, String str2, String str3) {
        k.c(str, "eventName");
        k.c(str2, "status");
        k.c(str3, "flow");
        this.eventName = str;
        this.eventStartTime = j;
        this.eventEndTime = j2;
        this.timeTaken = j3;
        this.status = str2;
        this.flow = str3;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final long getEventStartTime() {
        return this.eventStartTime;
    }

    public final long getEventEndTime() {
        return this.eventEndTime;
    }

    public final long getTimeTaken() {
        return this.timeTaken;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String toString() {
        return "{eventName:" + this.eventName + ",eventStartTime:" + this.eventStartTime + ",eventEndTime:" + this.eventEndTime + ",timeTaken:" + this.timeTaken + ",status:" + this.status + ",flow:" + this.flow + '}';
    }
}
