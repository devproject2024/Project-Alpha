package com.alipay.mobile.rome.longlinkservice;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private b f14969a;

    /* renamed from: b  reason: collision with root package name */
    private Object f14970b;

    public a(b bVar) {
        this.f14969a = bVar;
        if (this.f14969a == null) {
            this.f14969a = b.ConnectFailed;
        }
    }

    public a(b bVar, Object obj) {
        this.f14969a = bVar;
        this.f14970b = obj;
        if (this.f14969a == null) {
            this.f14969a = b.ConnectFailed;
        }
    }

    public final String toString() {
        return "ConnectionEvent{mEventType=" + this.f14969a + ", connectionStateName='" + this.f14969a.toString() + '\'' + '}';
    }
}
