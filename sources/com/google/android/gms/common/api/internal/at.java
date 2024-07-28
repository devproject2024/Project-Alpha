package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.k;

final class at extends k {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ as f8438a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    at(as asVar, Looper looper) {
        super(looper);
        this.f8438a = asVar;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            as.b(this.f8438a);
        } else if (i2 != 2) {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i3);
        } else {
            as.a(this.f8438a);
        }
    }
}
