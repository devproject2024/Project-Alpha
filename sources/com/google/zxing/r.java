package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final String f40577a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f40578b;

    /* renamed from: c  reason: collision with root package name */
    public t[] f40579c;

    /* renamed from: d  reason: collision with root package name */
    public final a f40580d;

    /* renamed from: e  reason: collision with root package name */
    public Map<s, Object> f40581e;

    /* renamed from: f  reason: collision with root package name */
    private final int f40582f;

    /* renamed from: g  reason: collision with root package name */
    private final long f40583g;

    public r(String str, byte[] bArr, t[] tVarArr, a aVar) {
        this(str, bArr, tVarArr, aVar, System.currentTimeMillis());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public r(String str, byte[] bArr, t[] tVarArr, a aVar, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, tVarArr, aVar, j);
    }

    public r(String str, byte[] bArr, int i2, t[] tVarArr, a aVar, long j) {
        this.f40577a = str;
        this.f40578b = bArr;
        this.f40582f = i2;
        this.f40579c = tVarArr;
        this.f40580d = aVar;
        this.f40581e = null;
        this.f40583g = j;
    }

    public final void a(s sVar, Object obj) {
        if (this.f40581e == null) {
            this.f40581e = new EnumMap(s.class);
        }
        this.f40581e.put(sVar, obj);
    }

    public final void a(Map<s, Object> map) {
        if (map != null) {
            Map<s, Object> map2 = this.f40581e;
            if (map2 == null) {
                this.f40581e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public final String toString() {
        return this.f40577a;
    }
}
