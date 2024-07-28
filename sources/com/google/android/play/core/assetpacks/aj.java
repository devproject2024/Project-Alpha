package com.google.android.play.core.assetpacks;

import java.util.Map;

final class aj extends d {

    /* renamed from: a  reason: collision with root package name */
    private final long f36972a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, c> f36973b;

    aj(long j, Map<String, c> map) {
        this.f36972a = j;
        this.f36973b = map;
    }

    public final long a() {
        return this.f36972a;
    }

    public final Map<String, c> b() {
        return this.f36973b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f36972a == dVar.a() && this.f36973b.equals(dVar.b());
        }
    }

    public final int hashCode() {
        long j = this.f36972a;
        return this.f36973b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final String toString() {
        long j = this.f36972a;
        String valueOf = String.valueOf(this.f36973b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
