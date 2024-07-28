package com.alipay.mobile.rome.syncsdk.d.b;

import com.alipay.mobile.rome.syncsdk.e.h;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15030a = c.class.getSimpleName();

    public static a a(int i2) {
        if (b.f15028b == i2) {
            return new d();
        }
        String str = f15030a;
        h.d(str, "getPacket: protoVersion not supported [ protoVersion=" + i2 + " ]");
        return null;
    }
}
