package com.alipay.imobile.network.quake.h.a;

import java.io.IOException;
import java.io.InputStream;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    InputStream f14874a;

    /* renamed from: b  reason: collision with root package name */
    String f14875b;

    /* renamed from: c  reason: collision with root package name */
    long f14876c;

    /* renamed from: d  reason: collision with root package name */
    private String f14877d;

    public g(String str, long j, String str2, InputStream inputStream) {
        this.f14877d = str;
        this.f14876c = j;
        this.f14875b = str2;
        this.f14874a = inputStream;
    }

    public final void a() throws IOException {
        InputStream inputStream = this.f14874a;
        if (inputStream != null) {
            inputStream.close();
            this.f14874a = null;
        }
    }
}
