package androidx.room;

import androidx.sqlite.db.c;
import java.io.File;

final class p implements c.C0072c {

    /* renamed from: a  reason: collision with root package name */
    private final String f4499a;

    /* renamed from: b  reason: collision with root package name */
    private final File f4500b;

    /* renamed from: c  reason: collision with root package name */
    private final c.C0072c f4501c;

    p(String str, File file, c.C0072c cVar) {
        this.f4499a = str;
        this.f4500b = file;
        this.f4501c = cVar;
    }

    public final c a(c.b bVar) {
        return new o(bVar.f4542a, this.f4499a, this.f4500b, bVar.f4544c.f4541a, this.f4501c.a(bVar));
    }
}
