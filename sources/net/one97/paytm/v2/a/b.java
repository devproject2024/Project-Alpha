package net.one97.paytm.v2.a;

import androidx.lifecycle.y;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.vipcashback.f.h;

public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f20049a;

    public b(f fVar) {
        k.c(fVar, "remoteDataSource");
        this.f20049a = fVar;
    }

    public final void a(y<h<Object>> yVar, String str, int i2, int i3) {
        k.c(yVar, "result");
        this.f20049a.a(yVar, str, i2, i3);
    }

    public final void a(y<h<Object>> yVar, String str, String str2) {
        k.c(yVar, "result");
        k.c(str, StringSet.filter);
        k.c(str2, "pageNo");
        this.f20049a.a(yVar, str, str2);
    }

    public final void a(y<h<Object>> yVar, String str, String str2, Boolean bool) {
        k.c(yVar, "result");
        this.f20049a.a(yVar, str, str2, bool);
    }

    public final void a(y<h<Object>> yVar, String str) {
        k.c(yVar, "result");
        k.c(str, "offersTag");
        this.f20049a.a(yVar, str);
    }
}
