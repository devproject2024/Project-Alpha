package com.alibaba.a.c;

import com.business.merchant_payments.common.utility.AppUtility;

public final class ax {

    /* renamed from: a  reason: collision with root package name */
    final ax f6295a;

    /* renamed from: b  reason: collision with root package name */
    final Object f6296b;

    /* renamed from: c  reason: collision with root package name */
    int f6297c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6298d;

    public ax(ax axVar, Object obj, Object obj2, int i2) {
        this.f6295a = axVar;
        this.f6296b = obj;
        this.f6298d = obj2;
        this.f6297c = i2;
    }

    public final String a() {
        if (this.f6295a == null) {
            return "$";
        }
        if (this.f6298d instanceof Integer) {
            return this.f6295a.a() + "[" + this.f6298d + "]";
        }
        return this.f6295a.a() + AppUtility.CENTER_DOT + this.f6298d;
    }

    public final String toString() {
        return a();
    }
}
