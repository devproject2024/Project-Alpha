package com.google.android.play.core.d;

import com.google.android.play.core.e.q;

public final class a extends q {

    /* renamed from: a  reason: collision with root package name */
    private final int f37338a;

    public a(int i2) {
        super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i2), com.google.android.play.core.d.a.a.a(i2)}));
        if (i2 != 0) {
            this.f37338a = i2;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    public final int getErrorCode() {
        return this.f37338a;
    }
}
