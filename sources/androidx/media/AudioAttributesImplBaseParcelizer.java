package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(a aVar) {
        c cVar = new c();
        cVar.f3830a = aVar.b(cVar.f3830a, 1);
        cVar.f3831b = aVar.b(cVar.f3831b, 2);
        cVar.f3832c = aVar.b(cVar.f3832c, 3);
        cVar.f3833d = aVar.b(cVar.f3833d, 4);
        return cVar;
    }

    public static void write(c cVar, a aVar) {
        aVar.a(cVar.f3830a, 1);
        aVar.a(cVar.f3831b, 2);
        aVar.a(cVar.f3832c, 3);
        aVar.a(cVar.f3833d, 4);
    }
}
