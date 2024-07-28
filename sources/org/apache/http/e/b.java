package org.apache.http.e;

import java.io.Serializable;
import java.nio.CharBuffer;

public final class b implements Serializable, CharSequence {

    /* renamed from: a  reason: collision with root package name */
    public int f72511a;

    /* renamed from: b  reason: collision with root package name */
    private char[] f72512b = new char[64];

    public b() {
        a.a(64, "Buffer capacity");
    }

    private void b(int i2) {
        char[] cArr = new char[Math.max(this.f72512b.length << 1, i2)];
        System.arraycopy(this.f72512b, 0, cArr, 0, this.f72511a);
        this.f72512b = cArr;
    }

    public final void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i2 = this.f72511a + length;
        if (i2 > this.f72512b.length) {
            b(i2);
        }
        str.getChars(0, length, this.f72512b, this.f72511a);
        this.f72511a = i2;
    }

    public final void a(char c2) {
        int i2 = this.f72511a + 1;
        if (i2 > this.f72512b.length) {
            b(i2);
        }
        this.f72512b[this.f72511a] = c2;
        this.f72511a = i2;
    }

    public final char charAt(int i2) {
        return this.f72512b[i2];
    }

    public final int length() {
        return this.f72511a;
    }

    public final void a(int i2) {
        if (i2 > 0) {
            int length = this.f72512b.length;
            int i3 = this.f72511a;
            if (i2 > length - i3) {
                b(i3 + i2);
            }
        }
    }

    public final CharSequence subSequence(int i2, int i3) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Negative beginIndex: ".concat(String.valueOf(i2)));
        } else if (i3 > this.f72511a) {
            throw new IndexOutOfBoundsException("endIndex: " + i3 + " > length: " + this.f72511a);
        } else if (i2 <= i3) {
            return CharBuffer.wrap(this.f72512b, i2, i3);
        } else {
            throw new IndexOutOfBoundsException("beginIndex: " + i2 + " > endIndex: " + i3);
        }
    }

    public final String toString() {
        return new String(this.f72512b, 0, this.f72511a);
    }
}
