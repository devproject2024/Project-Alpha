package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.h.h;
import com.google.android.gms.maps.a.a;
import com.google.android.gms.maps.a.v;
import com.google.android.gms.maps.a.y;
import com.google.android.gms.maps.model.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f11547a = false;

    public static synchronized int a(Context context) {
        synchronized (d.class) {
            s.a(context, (Object) "Context is null");
            if (f11547a) {
                return 0;
            }
            try {
                y a2 = v.a(context);
                try {
                    b.f11544a = (a) s.a(a2.a());
                    h b2 = a2.b();
                    if (b.f11664a == null) {
                        b.f11664a = (h) s.a(b2);
                    }
                    f11547a = true;
                    return 0;
                } catch (RemoteException e2) {
                    throw new com.google.android.gms.maps.model.d(e2);
                }
            } catch (e e3) {
                return e3.errorCode;
            }
        }
    }
}
