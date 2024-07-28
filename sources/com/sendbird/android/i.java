package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class i {

    /* renamed from: a  reason: collision with root package name */
    final JsonObject f44717a;

    /* renamed from: b  reason: collision with root package name */
    final j f44718b;

    /* renamed from: c  reason: collision with root package name */
    final String f44719c;

    /* renamed from: d  reason: collision with root package name */
    final String f44720d;

    /* renamed from: e  reason: collision with root package name */
    final long f44721e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, JsonElement> f44722f = new ConcurrentHashMap();

    public i(JsonElement jsonElement) {
        this.f44717a = jsonElement.getAsJsonObject();
        this.f44718b = j.from(this.f44717a.has("cat") ? this.f44717a.get("cat").getAsInt() : 0);
        JsonObject asJsonObject = this.f44717a.has("data") ? this.f44717a.get("data").getAsJsonObject() : null;
        if (asJsonObject != null) {
            for (Map.Entry next : asJsonObject.entrySet()) {
                this.f44722f.put(next.getKey(), next.getValue());
            }
        }
        this.f44719c = this.f44717a.has(StringSet.channel_url) ? this.f44717a.get(StringSet.channel_url).getAsString() : "";
        this.f44720d = this.f44717a.has(StringSet.channel_type) ? this.f44717a.get(StringSet.channel_type).getAsString() : BaseChannel.ChannelType.GROUP.value();
        this.f44721e = this.f44717a.has(StringSet.ts) ? this.f44717a.get(StringSet.ts).getAsLong() : 0;
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a() {
        if (this.f44717a.has("data")) {
            return this.f44717a.get("data").getAsJsonObject();
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            i iVar = (i) obj;
            if (this.f44718b == iVar.f44718b && this.f44719c.equals(iVar.f44719c) && this.f44721e == iVar.f44721e) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        return "ChannelEvent{obj=" + this.f44717a + ", category=" + this.f44718b + ", data=" + this.f44722f + ", channelUrl='" + this.f44719c + '\'' + ", channelType='" + this.f44720d + '\'' + ", ts=" + this.f44721e + '}';
    }

    public final int hashCode() {
        return p.a(this.f44718b, this.f44719c, Long.valueOf(this.f44721e));
    }
}
