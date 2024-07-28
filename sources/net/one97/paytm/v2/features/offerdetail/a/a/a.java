package net.one97.paytm.v2.features.offerdetail.a.a;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import kotlin.g.b.k;
import net.one97.paytm.v2.features.offerdetail.b.b;
import net.one97.paytm.v2.features.offerdetail.b.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final FragmentActivity f20438a;

    public a(FragmentActivity fragmentActivity) {
        k.c(fragmentActivity, "activity");
        this.f20438a = fragmentActivity;
    }

    public static b a(net.one97.paytm.v2.features.offerdetail.b.a aVar) {
        k.c(aVar, "remoteDataSource");
        return new c(aVar);
    }

    public static net.one97.paytm.v2.features.offerdetail.b.a a(Context context) {
        k.c(context, "context");
        return new net.one97.paytm.v2.features.offerdetail.b.a(context);
    }
}
