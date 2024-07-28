package a.a.a.a.a.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final f f678a;

    /* renamed from: b  reason: collision with root package name */
    final f f679b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f680c;

    private c(f fVar, f fVar2) {
        this.f678a = fVar;
        if (fVar2 == null) {
            this.f679b = f.NONE;
        } else {
            this.f679b = fVar2;
        }
        this.f680c = false;
    }

    public static c a(f fVar, f fVar2) {
        a.a.a.a.a.e.c.a((Object) fVar, "Impression owner is null");
        if (!fVar.equals(f.NONE)) {
            return new c(fVar, fVar2);
        }
        throw new IllegalArgumentException("Impression owner is none");
    }
}
