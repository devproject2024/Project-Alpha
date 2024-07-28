package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

final class u implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f38891a;

    u(ExecutorService executorService) {
        this.f38891a = executorService;
    }

    public final Task<Integer> a(Intent intent) {
        return h.a((Executor) this.f38891a, new v(intent));
    }
}
