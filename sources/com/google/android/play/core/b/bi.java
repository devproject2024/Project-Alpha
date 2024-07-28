package com.google.android.play.core.b;

public final class bi<T> implements bl<T> {

    /* renamed from: a  reason: collision with root package name */
    private bl<T> f37287a;

    public static <T> void a(bl<T> blVar, bl<T> blVar2) {
        bi biVar = (bi) blVar;
        if (biVar.f37287a == null) {
            biVar.f37287a = blVar2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T a() {
        bl<T> blVar = this.f37287a;
        if (blVar != null) {
            return blVar.a();
        }
        throw new IllegalStateException();
    }
}
