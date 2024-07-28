package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.x  reason: invalid package */
public enum x {
    TRACE_EVENT_RATE_LIMITED("_fstec"),
    NETWORK_TRACE_EVENT_RATE_LIMITED("_fsntc"),
    TRACE_STARTED_NOT_STOPPED("_tsns"),
    FRAMES_TOTAL("_fr_tot"),
    FRAMES_SLOW("_fr_slo"),
    FRAMES_FROZEN("_fr_fzn");
    
    private String mName;

    private x(String str) {
        this.mName = str;
    }

    public final String toString() {
        return this.mName;
    }
}
