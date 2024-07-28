package com.google.android.play.core.assetpacks;

final class ax extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    final int f37021a;

    ax(String str) {
        super(str);
        this.f37021a = -1;
    }

    ax(String str, int i2) {
        super(str);
        this.f37021a = i2;
    }

    ax(String str, Exception exc) {
        super(str, exc);
        this.f37021a = -1;
    }

    ax(String str, Exception exc, int i2) {
        super(str, exc);
        this.f37021a = i2;
    }
}
