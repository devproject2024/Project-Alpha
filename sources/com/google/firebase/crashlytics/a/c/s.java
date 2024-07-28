package com.google.firebase.crashlytics.a.c;

import com.google.firebase.crashlytics.a.k.a.b;

public enum s {
    NONE,
    JAVA_ONLY,
    ALL;
    
    static final int REPORT_UPLOAD_VARIANT_DATATRANSPORT = 2;
    static final int REPORT_UPLOAD_VARIANT_LEGACY = 1;

    static s getState(boolean z, boolean z2) {
        if (!z) {
            return NONE;
        }
        if (!z2) {
            return JAVA_ONLY;
        }
        return ALL;
    }

    static s getState(b bVar) {
        boolean z = true;
        boolean z2 = bVar.f38668h == 2;
        if (bVar.f38669i != 2) {
            z = false;
        }
        return getState(z2, z);
    }
}
