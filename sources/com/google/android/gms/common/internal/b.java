package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.j;

public final class b {
    public static ApiException a(Status status) {
        if (status.b()) {
            return new j(status);
        }
        return new ApiException(status);
    }
}
