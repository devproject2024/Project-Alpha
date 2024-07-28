package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.h;
import com.google.firebase.appindexing.a;
import com.google.firebase.appindexing.d;
import com.google.firebase.appindexing.f;

public final class p extends f {

    /* renamed from: a  reason: collision with root package name */
    private r f38038a;

    public p(Context context) {
        this.f38038a = new r(context);
    }

    public final Task<Void> a(a aVar) {
        return a(1, aVar);
    }

    public final Task<Void> b(a aVar) {
        return a(2, aVar);
    }

    private final Task<Void> a(int i2, a aVar) {
        zza[] zzaArr = new zza[1];
        if (aVar != null) {
            if (!(aVar instanceof zza)) {
                return h.a((Exception) new d("Custom Action objects are not allowed. Please use the 'Actions' or 'ActionBuilder' class for creating Action objects."));
            }
            zzaArr[0] = (zza) aVar;
            zzaArr[0].f38043a.f38050a = i2;
        }
        return this.f38038a.doWrite(new s(zzaArr));
    }
}
