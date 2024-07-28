package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.r;

public final class f implements r {
    public final Exception a(Status status) {
        if (status.f8360g == 8) {
            return new e(status.e());
        }
        return new b(status.e());
    }
}
