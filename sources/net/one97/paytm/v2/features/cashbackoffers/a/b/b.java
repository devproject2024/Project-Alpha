package net.one97.paytm.v2.features.cashbackoffers.a.b;

import androidx.appcompat.app.AppCompatActivity;
import dagger.a.c;
import dagger.a.g;

public final class b implements c<AppCompatActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final a f20322a;

    private b(a aVar) {
        this.f20322a = aVar;
    }

    public static b a(a aVar) {
        return new b(aVar);
    }

    public final /* synthetic */ Object get() {
        return (AppCompatActivity) g.a(this.f20322a.f20321a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
