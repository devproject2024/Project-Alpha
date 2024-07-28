package com.google.firebase;

import com.google.android.gms.common.internal.s;

public class e extends Exception {
    @Deprecated
    protected e() {
    }

    public e(String str) {
        super(s.a(str, (Object) "Detail message must not be empty"));
    }

    public e(String str, Throwable th) {
        super(s.a(str, (Object) "Detail message must not be empty"), th);
    }
}
