package com.sendbird.android;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class w {

    /* renamed from: a  reason: collision with root package name */
    int f45334a;

    /* renamed from: b  reason: collision with root package name */
    int f45335b;

    /* renamed from: c  reason: collision with root package name */
    long f45336c;

    /* renamed from: d  reason: collision with root package name */
    Map<String, Integer> f45337d;

    w() {
        a();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f45334a = 0;
        this.f45335b = 0;
        Map<String, Integer> map = this.f45337d;
        if (map == null) {
            this.f45337d = new ConcurrentHashMap();
        } else {
            map.clear();
        }
        this.f45336c = 0;
    }
}
