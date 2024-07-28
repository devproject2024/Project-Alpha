package com.google.android.play.core.appupdate;

final class s extends e {

    /* renamed from: a  reason: collision with root package name */
    private final int f36935a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f36936b;

    /* synthetic */ s(int i2, boolean z) {
        this.f36935a = i2;
        this.f36936b = z;
    }

    public final int a() {
        return this.f36935a;
    }

    public final boolean b() {
        return this.f36936b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.f36935a == eVar.a() && this.f36936b == eVar.b();
        }
    }

    public final int hashCode() {
        return ((this.f36935a ^ 1000003) * 1000003) ^ (true != this.f36936b ? 1237 : 1231);
    }

    public final String toString() {
        int i2 = this.f36935a;
        boolean z = this.f36936b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i2);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
