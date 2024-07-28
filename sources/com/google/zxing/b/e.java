package com.google.zxing.b;

import java.util.List;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f39910a;

    /* renamed from: b  reason: collision with root package name */
    public int f39911b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39912c;

    /* renamed from: d  reason: collision with root package name */
    public final List<byte[]> f39913d;

    /* renamed from: e  reason: collision with root package name */
    public final String f39914e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f39915f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f39916g;

    /* renamed from: h  reason: collision with root package name */
    public Object f39917h;

    /* renamed from: i  reason: collision with root package name */
    public final int f39918i;
    public final int j;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        int i4;
        this.f39910a = bArr;
        if (bArr == null) {
            i4 = 0;
        } else {
            i4 = bArr.length * 8;
        }
        this.f39911b = i4;
        this.f39912c = str;
        this.f39913d = list;
        this.f39914e = str2;
        this.f39918i = i3;
        this.j = i2;
    }
}
