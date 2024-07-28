package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.a;

final class by implements a<Boolean, Void> {
    by() {
    }

    public final /* synthetic */ Object a(Task task) throws Exception {
        if (((Boolean) task.d()).booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }
}
