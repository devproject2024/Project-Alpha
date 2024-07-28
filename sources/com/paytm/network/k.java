package com.paytm.network;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;

public final class k extends RequestQueue {

    /* renamed from: a  reason: collision with root package name */
    boolean f42958a;

    public final void stop() {
    }

    public k(Cache cache, Network network, int i2) {
        super(cache, network, i2);
    }

    public final void start() {
        if (!this.f42958a) {
            super.start();
        }
    }
}
