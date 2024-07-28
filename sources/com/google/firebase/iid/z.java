package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;
import com.google.firebase.iid.y;

final /* synthetic */ class z implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final y.a f38912a;

    z(y.a aVar) {
        this.f38912a = aVar;
    }

    public final boolean handleMessage(Message message) {
        return this.f38912a.a(message);
    }
}
