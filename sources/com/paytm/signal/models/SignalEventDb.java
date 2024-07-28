package com.paytm.signal.models;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SignalEventDb {
    private Long deviceDateTime;
    private long id;
    private Integer priority;
    private String signalEvent;

    public SignalEventDb() {
        this(0, (Integer) null, (Long) null, (String) null, 15, (g) null);
    }

    public static /* synthetic */ SignalEventDb copy$default(SignalEventDb signalEventDb, long j, Integer num, Long l, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = signalEventDb.id;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            num = signalEventDb.priority;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            l = signalEventDb.deviceDateTime;
        }
        Long l2 = l;
        if ((i2 & 8) != 0) {
            str = signalEventDb.signalEvent;
        }
        return signalEventDb.copy(j2, num2, l2, str);
    }

    public final long component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.priority;
    }

    public final Long component3() {
        return this.deviceDateTime;
    }

    public final String component4() {
        return this.signalEvent;
    }

    public final SignalEventDb copy(long j, Integer num, Long l, String str) {
        return new SignalEventDb(j, num, l, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignalEventDb)) {
            return false;
        }
        SignalEventDb signalEventDb = (SignalEventDb) obj;
        return this.id == signalEventDb.id && k.a((Object) this.priority, (Object) signalEventDb.priority) && k.a((Object) this.deviceDateTime, (Object) signalEventDb.deviceDateTime) && k.a((Object) this.signalEvent, (Object) signalEventDb.signalEvent);
    }

    public final int hashCode() {
        long j = this.id;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        Integer num = this.priority;
        int i3 = 0;
        int hashCode = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.deviceDateTime;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.signalEvent;
        if (str != null) {
            i3 = str.hashCode();
        }
        return hashCode2 + i3;
    }

    public final String toString() {
        return "SignalEventDb(id=" + this.id + ", priority=" + this.priority + ", deviceDateTime=" + this.deviceDateTime + ", signalEvent=" + this.signalEvent + ")";
    }

    public SignalEventDb(long j, Integer num, Long l, String str) {
        this.id = j;
        this.priority = num;
        this.deviceDateTime = l;
        this.signalEvent = str;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SignalEventDb(long r5, java.lang.Integer r7, java.lang.Long r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0008
            r2 = r0
            goto L_0x0009
        L_0x0008:
            r2 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x0012
            r5 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
        L_0x0012:
            r11 = r7
            r5 = r10 & 4
            if (r5 == 0) goto L_0x001b
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
        L_0x001b:
            r0 = r8
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0021
            r9 = 0
        L_0x0021:
            r10 = r9
            r5 = r4
            r6 = r2
            r8 = r11
            r9 = r0
            r5.<init>(r6, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.models.SignalEventDb.<init>(long, java.lang.Integer, java.lang.Long, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final Long getDeviceDateTime() {
        return this.deviceDateTime;
    }

    public final void setDeviceDateTime(Long l) {
        this.deviceDateTime = l;
    }

    public final String getSignalEvent() {
        return this.signalEvent;
    }

    public final void setSignalEvent(String str) {
        this.signalEvent = str;
    }
}
