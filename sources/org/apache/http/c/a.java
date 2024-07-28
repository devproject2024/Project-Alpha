package org.apache.http.c;

@Deprecated
public abstract class a implements d {
    protected a() {
    }

    public final d a(String str, int i2) {
        a(str, (Object) Integer.valueOf(i2));
        return this;
    }

    public final d a(String str) {
        a(str, (Object) Boolean.FALSE);
        return this;
    }
}
