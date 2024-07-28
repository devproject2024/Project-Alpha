package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.f;

public final class u {
    @Deprecated
    public static Task<Void> a(Task<Boolean> task) {
        return task.a((a<Boolean, TContinuationResult>) new by());
    }

    public static void a(Status status, f<Void> fVar) {
        if (status.c()) {
            fVar.a(null);
        } else {
            fVar.a((Exception) new ApiException(status));
        }
    }
}
