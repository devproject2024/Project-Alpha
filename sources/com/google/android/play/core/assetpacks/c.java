package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.b.bq;

public abstract class c {
    static c a(Bundle bundle, String str, ba baVar, ab abVar) {
        return a(str, abVar.a(bundle.getInt(bq.a("status", str))), bundle.getInt(bq.a("error_code", str)), bundle.getLong(bq.a("bytes_downloaded", str)), bundle.getLong(bq.a("total_bytes_to_download", str)), baVar.b(str));
    }

    public static c a(String str, int i2, int i3, long j, long j2, double d2) {
        return new ai(str, i2, i3, j, j2, (int) Math.rint(100.0d * d2));
    }

    public abstract String a();

    public abstract int b();

    public abstract int c();

    public abstract long d();

    public abstract long e();

    public abstract int f();
}
