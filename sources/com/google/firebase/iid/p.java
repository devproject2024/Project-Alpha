package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.c;

final /* synthetic */ class p implements c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f38881a;

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver.PendingResult f38882b;

    p(boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.f38881a = z;
        this.f38882b = pendingResult;
    }

    public final void a(Task task) {
        FirebaseInstanceIdReceiver.a(this.f38881a, this.f38882b, task);
    }
}
