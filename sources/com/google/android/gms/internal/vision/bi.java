package com.google.android.gms.internal.vision;

final class bi extends ay<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzmb;

    bi(Object[] objArr, int i2, int i3) {
        this.zzmb = objArr;
        this.offset = i2;
        this.size = i3;
    }

    public final Object get(int i2) {
        al.a(i2, this.size);
        return this.zzmb[(i2 * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }
}
