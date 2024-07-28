package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    final JSONObject f30959a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30960b;

    public final String toString() {
        return "SkuDetails: " + this.f30960b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f30960b, ((i) obj).f30960b);
    }

    public final int hashCode() {
        return this.f30960b.hashCode();
    }
}
