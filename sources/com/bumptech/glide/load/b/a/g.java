package com.bumptech.glide.load.b.a;

public final class g implements a<byte[]> {
    public final String a() {
        return "ByteArrayPool";
    }

    public final int b() {
        return 1;
    }

    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return ((byte[]) obj).length;
    }

    public final /* bridge */ /* synthetic */ Object a(int i2) {
        return new byte[i2];
    }
}
