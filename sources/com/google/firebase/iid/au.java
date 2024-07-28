package com.google.firebase.iid;

import android.content.Intent;
import android.os.Binder;
import com.google.android.gms.tasks.Task;

public final class au extends Binder {

    /* renamed from: a  reason: collision with root package name */
    final a f38842a;

    public interface a {
        Task<Void> a(Intent intent);
    }

    public au(a aVar) {
        this.f38842a = aVar;
    }
}
