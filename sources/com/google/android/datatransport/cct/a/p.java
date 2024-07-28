package com.google.android.datatransport.cct.a;

import android.util.SparseArray;

public enum p {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    
    private static final SparseArray<p> zzg = null;

    static {
        DEFAULT = new p("DEFAULT", 0, 0);
        UNMETERED_ONLY = new p("UNMETERED_ONLY", 1, 1);
        UNMETERED_OR_DAILY = new p("UNMETERED_OR_DAILY", 2, 2);
        FAST_IF_RADIO_AWAKE = new p("FAST_IF_RADIO_AWAKE", 3, 3);
        NEVER = new p("NEVER", 4, 4);
        UNRECOGNIZED = new p("UNRECOGNIZED", 5, -1);
        p[] pVarArr = {DEFAULT, UNMETERED_ONLY, UNMETERED_OR_DAILY, FAST_IF_RADIO_AWAKE, NEVER, UNRECOGNIZED};
        SparseArray<p> sparseArray = new SparseArray<>();
        zzg = sparseArray;
        sparseArray.put(0, DEFAULT);
        zzg.put(1, UNMETERED_ONLY);
        zzg.put(2, UNMETERED_OR_DAILY);
        zzg.put(3, FAST_IF_RADIO_AWAKE);
        zzg.put(4, NEVER);
        zzg.put(-1, UNRECOGNIZED);
    }

    private p(int i2) {
    }
}
