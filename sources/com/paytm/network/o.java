package com.paytm.network;

import com.paytm.utility.q;
import okhttp3.ConnectionPool;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final o f42974a = new o();

    /* renamed from: b  reason: collision with root package name */
    private ConnectionPool f42975b;

    public static o a() {
        return f42974a;
    }

    private o() {
        if (this.f42975b == null) {
            this.f42975b = new ConnectionPool();
        }
    }

    public final ConnectionPool b() {
        q.a(" connectionCount " + this.f42975b.connectionCount());
        q.a(" idleConnectionCount " + this.f42975b.idleConnectionCount());
        return this.f42975b;
    }
}
