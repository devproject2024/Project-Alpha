package com.google.android.play.core.assetpacks;

final class ah extends b {

    /* renamed from: a  reason: collision with root package name */
    private final int f36963a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36964b;

    /* renamed from: c  reason: collision with root package name */
    private final String f36965c;

    ah(int i2, String str, String str2) {
        this.f36963a = i2;
        this.f36964b = str;
        this.f36965c = str2;
    }

    public final int a() {
        return this.f36963a;
    }

    public final String b() {
        return this.f36964b;
    }

    public final String c() {
        return this.f36965c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f36963a == bVar.a() && ((str = this.f36964b) == null ? bVar.b() == null : str.equals(bVar.b()))) {
                String str2 = this.f36965c;
                String c2 = bVar.c();
                if (str2 == null ? c2 == null : str2.equals(c2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.f36963a ^ 1000003) * 1000003;
        String str = this.f36964b;
        int i3 = 0;
        int hashCode = (i2 ^ (str != null ? str.hashCode() : 0)) * 1000003;
        String str2 = this.f36965c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode ^ i3;
    }

    public final String toString() {
        int i2 = this.f36963a;
        String str = this.f36964b;
        String str2 = this.f36965c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i2);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
