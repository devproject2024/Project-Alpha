package com.travel.citybus.brts.utils;

import com.business.merchant_payments.common.utility.AppConstants;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.j.b;
import kotlin.g.b.k;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f23402a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final b<Object> f23403b = b.a();

    private e() {
    }

    public static void a(Object obj) {
        k.c(obj, AppConstants.NOTIFICATION_DETAILS.EVENT);
        f23403b.onNext(obj);
    }

    public static <T> p<T> a(Class<T> cls) {
        k.c(cls, "eventType");
        p<U> ofType = f23403b.ofType(cls);
        k.a((Object) ofType, "publisher.ofType(eventType)");
        return ofType;
    }
}
