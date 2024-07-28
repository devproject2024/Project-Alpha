package com.sendbird.android;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;

final class x {

    /* renamed from: a  reason: collision with root package name */
    y f45338a;

    /* renamed from: b  reason: collision with root package name */
    private JsonObject f45339b;

    x(JsonElement jsonElement) {
        this.f45339b = jsonElement.getAsJsonObject();
        this.f45338a = y.from(this.f45339b.has("cat") ? this.f45339b.get("cat").getAsInt() : 0);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a() {
        if (this.f45339b.has("data")) {
            return this.f45339b.get("data").getAsJsonObject();
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass() && this.f45338a == ((x) obj).f45338a) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "UserEvent{obj=" + this.f45339b + ", category=" + this.f45338a + '}';
    }

    public final int hashCode() {
        return p.a(this.f45338a);
    }
}
