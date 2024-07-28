package com.travel.bus.busticket.i;

import com.business.merchant_payments.common.utility.AppConstants;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.j.b;
import kotlin.g.b.k;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final y f22482a = new y();

    /* renamed from: b  reason: collision with root package name */
    private static final b<Object> f22483b = b.a();

    private y() {
    }

    public static void a(Object obj) {
        k.c(obj, AppConstants.NOTIFICATION_DETAILS.EVENT);
        f22483b.onNext(obj);
    }

    public static <T> p<T> a(Class<T> cls) {
        k.c(cls, "eventType");
        p<U> ofType = f22483b.ofType(cls);
        k.a((Object) ofType, "publisher.ofType(eventType)");
        return ofType;
    }
}
