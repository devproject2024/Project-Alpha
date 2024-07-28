package com.google.firebase.remoteconfig;

public final class k extends j {
    private final long throttleEndTimeMillis;

    public k(long j) {
        this("Fetch was throttled.", j);
    }

    public k(String str, long j) {
        super(str);
        this.throttleEndTimeMillis = j;
    }

    public final long getThrottleEndTimeMillis() {
        return this.throttleEndTimeMillis;
    }
}
