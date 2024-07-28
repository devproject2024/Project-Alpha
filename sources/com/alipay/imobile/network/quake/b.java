package com.alipay.imobile.network.quake;

import java.io.Serializable;
import java.util.Map;

public final class b implements Serializable {
    public final byte[] data;
    public final Map<String, String> extData;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    public b(int i2, byte[] bArr) {
        this(i2, bArr, (Map<String, String>) null, false, 0);
    }

    public b(int i2, byte[] bArr, Map<String, String> map) {
        this(i2, bArr, map, false, 0);
    }

    public b(int i2, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.statusCode = i2;
        this.data = bArr;
        this.extData = map;
        this.notModified = z;
        this.networkTimeMs = j;
    }

    public b(int i2, byte[] bArr, boolean z) {
        this(i2, bArr, (Map<String, String>) null, z, 0);
    }

    public b(byte[] bArr) {
        this(0, bArr, (Map<String, String>) null, false, 0);
    }
}
