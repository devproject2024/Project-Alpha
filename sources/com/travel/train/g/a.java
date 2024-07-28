package com.travel.train.g;

import com.business.merchant_payments.common.utility.AppConstants;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.j.b;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27250a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final b<Object> f27251b = b.a();

    private a() {
    }

    public static void a(Object obj) {
        k.c(obj, AppConstants.NOTIFICATION_DETAILS.EVENT);
        f27251b.onNext(obj);
    }

    public static <T> p<T> a(Class<T> cls) {
        k.c(cls, "eventType");
        p<U> ofType = f27251b.ofType(cls);
        k.a((Object) ofType, "publisher.ofType(eventType)");
        return ofType;
    }
}
