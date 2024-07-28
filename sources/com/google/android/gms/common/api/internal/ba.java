package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.k;

final class ba extends k {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ay f8455a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ba(ay ayVar, Looper looper) {
        super(looper);
        this.f8455a = ayVar;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ((ax) message.obj).a(this.f8455a);
        } else if (i2 != 2) {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i3);
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
