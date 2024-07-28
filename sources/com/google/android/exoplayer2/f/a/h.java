package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.f.l;
import java.io.IOException;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final f f32344a = $$Lambda$h$lu9VlN6tcUP5zkQ3Sx2_hs7U0ZA.INSTANCE;

    /* access modifiers changed from: private */
    public static /* synthetic */ String a(l lVar) {
        return lVar.f32402h != null ? lVar.f32402h : lVar.f32395a.toString();
    }

    static boolean a(IOException iOException) {
        Throwable th;
        while (th != null) {
            if ((th instanceof j) && ((j) th).reason == 0) {
                return true;
            }
            Throwable cause = th.getCause();
            th = iOException;
            th = cause;
        }
        return false;
    }
}
