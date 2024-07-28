package com.android.installreferrer.a;

import android.os.Bundle;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f6387a;

    public d(Bundle bundle) {
        this.f6387a = bundle;
    }

    public final String a() {
        return this.f6387a.getString("install_referrer");
    }

    public final long b() {
        return this.f6387a.getLong("referrer_click_timestamp_seconds");
    }

    public final long c() {
        return this.f6387a.getLong("install_begin_timestamp_seconds");
    }
}
