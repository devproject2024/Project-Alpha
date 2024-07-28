package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonObject;

final class n {

    /* renamed from: a  reason: collision with root package name */
    final float f44838a;

    /* renamed from: b  reason: collision with root package name */
    final float f44839b;

    /* renamed from: c  reason: collision with root package name */
    final int f44840c;

    /* renamed from: d  reason: collision with root package name */
    final int f44841d;

    /* renamed from: e  reason: collision with root package name */
    final int f44842e;

    /* renamed from: f  reason: collision with root package name */
    final int f44843f;

    /* renamed from: g  reason: collision with root package name */
    final long f44844g;

    /* renamed from: h  reason: collision with root package name */
    long f44845h;

    /* renamed from: i  reason: collision with root package name */
    final int f44846i;

    n() {
        this.f44842e = 15000;
        this.f44843f = 5000;
        this.f44844g = 0;
        this.f44845h = 500;
        this.f44838a = 3.0f;
        this.f44839b = 24.0f;
        this.f44840c = 2;
        this.f44841d = 5;
        this.f44846i = 1;
    }

    n(JsonObject jsonObject) {
        this.f44842e = jsonObject.has(StringSet.ping_interval) ? jsonObject.get(StringSet.ping_interval).getAsInt() * 1000 : 15000;
        this.f44843f = (!jsonObject.has(StringSet.pong_timeout) || !jsonObject.get(StringSet.pong_timeout).isJsonPrimitive()) ? 5000 : jsonObject.get(StringSet.pong_timeout).getAsInt() * 1000;
        this.f44844g = (!jsonObject.has(StringSet.login_ts) || !jsonObject.get(StringSet.login_ts).isJsonPrimitive()) ? 0 : jsonObject.get(StringSet.login_ts).getAsLong();
        this.f44846i = jsonObject.has(StringSet.max_unread_cnt_on_super_group) ? jsonObject.get(StringSet.max_unread_cnt_on_super_group).getAsInt() : 1;
        this.f44845h = (!jsonObject.has(StringSet.bc_duration) || !jsonObject.get(StringSet.bc_duration).isJsonPrimitive()) ? 0 : (long) jsonObject.get(StringSet.bc_duration).getAsInt();
        long j = this.f44845h;
        if (j == 0) {
            this.f44845h = 500;
        } else if (j > 0) {
            this.f44845h = j * 1000;
        }
        int i2 = 5;
        int i3 = 2;
        float f2 = 24.0f;
        float f3 = 3.0f;
        if (!jsonObject.has(StringSet.reconnect) || !jsonObject.get(StringSet.reconnect).isJsonObject()) {
            this.f44838a = 3.0f;
            this.f44839b = 24.0f;
            this.f44840c = 2;
            this.f44841d = 5;
            return;
        }
        JsonObject asJsonObject = jsonObject.get(StringSet.reconnect).getAsJsonObject();
        this.f44838a = asJsonObject.has(StringSet.interval) ? ((float) Math.round(asJsonObject.get(StringSet.interval).getAsFloat() * 10.0f)) / 10.0f : f3;
        this.f44839b = asJsonObject.has(StringSet.max_interval) ? asJsonObject.get(StringSet.max_interval).getAsFloat() : f2;
        this.f44840c = asJsonObject.has(StringSet.mul) ? asJsonObject.get(StringSet.mul).getAsInt() : i3;
        this.f44841d = asJsonObject.has(StringSet.retry_cnt) ? asJsonObject.get(StringSet.retry_cnt).getAsInt() : i2;
    }

    public final String toString() {
        return "ConnectionConfig{DEFAULT_INTERVAL=3.0, DEFAULT_MAX_INTERVAL=24.0, DEFAULT_MULTIPLIER=2, DEFAULT_RETRY_CUONT=5, baseInterval=" + this.f44838a + ", maxInterval=" + this.f44839b + ", multiplier=" + this.f44840c + ", maxRetryCount=" + this.f44841d + ", pingInterval=" + this.f44842e + ", pongTimeout=" + this.f44843f + ", lastConnectedAt=" + this.f44844g + ", maxUnreadCountOnSuperGroup=" + this.f44846i + ", bcDuration=" + this.f44845h + '}';
    }
}
