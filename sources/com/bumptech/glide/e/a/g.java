package com.bumptech.glide.e.a;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.e.b.f;
import com.bumptech.glide.i;

public final class g<Z> extends c<Z> {

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f6517b = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            g gVar = (g) message.obj;
            gVar.f6518a.a((j<?>) gVar);
            return true;
        }
    });

    /* renamed from: a  reason: collision with root package name */
    final i f6518a;

    public final void a(Drawable drawable) {
    }

    public static <Z> g<Z> a(i iVar) {
        return new g<>(iVar);
    }

    private g(i iVar) {
        super((byte) 0);
        this.f6518a = iVar;
    }

    public final void a(Z z, f<? super Z> fVar) {
        f6517b.obtainMessage(1, this).sendToTarget();
    }
}
