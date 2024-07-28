package com.alipay.plus.android.a.a;

import com.alibaba.a.e;
import com.alipay.plus.android.a.a.a.d;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15168a = d.a("ConfigMerger");

    /* renamed from: b  reason: collision with root package name */
    private final com.alipay.plus.android.a.a.a.c f15169b = new com.alipay.plus.android.a.a.a.c();

    /* renamed from: c  reason: collision with root package name */
    protected a f15170c = a.Invalid;

    /* renamed from: d  reason: collision with root package name */
    protected long f15171d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected e f15172e;

    /* renamed from: f  reason: collision with root package name */
    public final com.alipay.plus.android.a.a.a.a f15173f = new com.alipay.plus.android.a.a.a.a();

    /* renamed from: g  reason: collision with root package name */
    protected final Object f15174g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private final com.alipay.plus.android.a.a.a.e f15175h = new com.alipay.plus.android.a.a.a.e();

    /* renamed from: i  reason: collision with root package name */
    private final List<Object> f15176i = Collections.synchronizedList(new ArrayList());

    public enum a {
        Invalid,
        Initialized,
        Shutdown;

        public final boolean isInitialized() {
            return this == Initialized;
        }

        public final boolean isInitializedOrShutdown() {
            return isInitialized() || isShutdown();
        }

        public final boolean isShutdown() {
            return this == Shutdown;
        }
    }

    /* access modifiers changed from: protected */
    public final e b() {
        e eVar = null;
        if (this.f15170c.isShutdown()) {
            return null;
        }
        synchronized (this.f15174g) {
            if (this.f15172e != null) {
                eVar = this.f15172e.getJSONObject(Constants.EASY_PAY_CONFIG_PREF_KEY);
            }
        }
        return eVar;
    }
}
