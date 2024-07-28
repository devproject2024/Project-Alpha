package net.one97.paytm.utils;

import android.content.Context;
import com.paytm.utility.a.a;
import com.paytm.utility.a.c;
import kotlin.g.b.k;
import net.one97.paytm.utils.au;

public final class aj implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final aj f69609a = new aj();

    private aj() {
    }

    public final <T> void a(T t, Context context) {
        k.c(context, "context");
        c cVar = (c) t;
        au.e eVar = new au.e();
        eVar.p = cVar.f43683a;
        eVar.u = cVar.f43684b;
        eVar.o = cVar.f43685c;
        eVar.l = cVar.f43686d;
        eVar.m = cVar.f43687e;
        eVar.t = au.f.USER_FACING.toString();
        au.a(eVar, au.c.ImgLog.stringValue, context);
    }
}
