package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.d;
import com.google.android.datatransport.runtime.a.a;
import java.net.URL;

final /* synthetic */ class c implements com.google.android.datatransport.runtime.b.c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f7708a = new c();

    private c() {
    }

    public static com.google.android.datatransport.runtime.b.c a() {
        return f7708a;
    }

    public final Object a(Object obj, Object obj2) {
        d.a aVar = (d.a) obj;
        d.b bVar = (d.b) obj2;
        URL url = bVar.f7719b;
        if (url == null) {
            return null;
        }
        a.a("CctTransportBackend", "Following redirect to: %s", (Object) url);
        return new d.a(bVar.f7719b, aVar.f7716b, aVar.f7717c);
    }
}
