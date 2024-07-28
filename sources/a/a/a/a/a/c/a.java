package a.a.a.a.a.c;

import a.a.a.a.a.b.i;
import java.util.ArrayList;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static a f710c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<i> f711a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<i> f712b = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return f710c;
    }

    public final void a(i iVar) {
        boolean b2 = b();
        this.f712b.add(iVar);
        if (!b2) {
            e.a().b();
        }
    }

    public final boolean b() {
        return this.f712b.size() > 0;
    }
}
