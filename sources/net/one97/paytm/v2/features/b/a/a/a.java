package net.one97.paytm.v2.features.b.a.a;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import kotlin.g.b.k;
import net.one97.paytm.v2.a.c;
import net.one97.paytm.v2.a.d;
import net.one97.paytm.v2.a.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final FragmentActivity f20067a;

    public a(FragmentActivity fragmentActivity) {
        k.c(fragmentActivity, "activity");
        this.f20067a = fragmentActivity;
    }

    public static d a(c cVar) {
        k.c(cVar, "remoteDataSource");
        return new e(cVar);
    }

    public static c a(Context context) {
        k.c(context, "context");
        return new c(context);
    }
}
