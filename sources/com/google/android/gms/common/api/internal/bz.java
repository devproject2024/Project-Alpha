package com.google.android.gms.common.api.internal;

import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.internal.base.k;

final class bz extends k {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ bx f8495a;

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            g<R> gVar = (g) message.obj;
            synchronized (this.f8495a.f8489d) {
                if (gVar == null) {
                    this.f8495a.f8493h.b(new Status(13, "Transform returned null"));
                } else if (gVar instanceof bq) {
                    this.f8495a.f8493h.b(((bq) gVar).f8473a);
                } else {
                    bx e2 = this.f8495a.f8493h;
                    synchronized (e2.f8489d) {
                        e2.f8488c = gVar;
                        if (!(e2.f8486a == null && e2.f8487b == null)) {
                            e eVar = (e) e2.f8491f.get();
                            if (!(e2.f8492g || e2.f8486a == null || eVar == null)) {
                                eVar.a(e2);
                                e2.f8492g = true;
                            }
                            if (e2.f8490e != null) {
                                e2.a(e2.f8490e);
                            } else if (e2.f8488c != null) {
                                e2.f8488c.a(e2);
                            }
                        }
                    }
                }
            }
        } else if (i2 != 1) {
            int i3 = message.what;
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i3);
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            if (valueOf.length() != 0) {
                "Runtime exception on the transformation worker thread: ".concat(valueOf);
            } else {
                new String("Runtime exception on the transformation worker thread: ");
            }
            throw runtimeException;
        }
    }
}
