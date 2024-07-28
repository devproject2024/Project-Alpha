package com.squareup.b;

import com.squareup.b.c;

final class e<T extends c<?>> {

    /* renamed from: a  reason: collision with root package name */
    Object[] f16053a = new Object[2];

    /* renamed from: b  reason: collision with root package name */
    int f16054b;

    public <E> e(d<T, E> dVar, E e2) {
        Object[] objArr = this.f16053a;
        objArr[0] = dVar;
        objArr[1] = e2;
        this.f16054b = 1;
    }

    public final d<T, ?> a(int i2) {
        if (i2 >= 0 && i2 < this.f16054b) {
            return (d) this.f16053a[i2];
        }
        throw new IndexOutOfBoundsException(String.valueOf(i2));
    }

    public final Object b(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.f16054b)) {
            return this.f16053a[i3 + i2];
        }
        throw new IndexOutOfBoundsException(String.valueOf(i2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f16054b != eVar.f16054b) {
            return false;
        }
        for (int i2 = 0; i2 < this.f16054b * 2; i2++) {
            if (!this.f16053a[i2].equals(eVar.f16053a[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f16054b * 2; i3++) {
            i2 = (i2 * 37) + this.f16053a[i3].hashCode();
        }
        return i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str = "";
        int i2 = 0;
        while (i2 < this.f16054b) {
            sb.append(str);
            sb.append(((d) this.f16053a[i2]).f16050e);
            sb.append("=");
            sb.append(this.f16053a[this.f16054b + i2]);
            i2++;
            str = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
