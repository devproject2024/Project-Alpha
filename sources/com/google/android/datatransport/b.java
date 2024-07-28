package com.google.android.datatransport;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f7637a;

    public static b a(String str) {
        return new b(str);
    }

    private b(String str) {
        if (str != null) {
            this.f7637a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f7637a.equals(((b) obj).f7637a);
    }

    public final int hashCode() {
        return this.f7637a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "Encoding{name=\"" + this.f7637a + "\"}";
    }
}
