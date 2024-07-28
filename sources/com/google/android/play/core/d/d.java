package com.google.android.play.core.d;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class d {
    public static d a(int i2, int i3, int i4, long j, long j2, List<String> list, List<String> list2) {
        if (i3 != 8) {
            return new f(i2, i3, i4, j, j2, list, list2, (PendingIntent) null, (List<Intent>) null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    public static d a(Bundle bundle) {
        return new f(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract long d();

    public abstract long e();

    public final List<String> f() {
        return i() != null ? new ArrayList(i()) : new ArrayList();
    }

    public final List<String> g() {
        return j() != null ? new ArrayList(j()) : new ArrayList();
    }

    @Deprecated
    public abstract PendingIntent h();

    /* access modifiers changed from: package-private */
    public abstract List<String> i();

    /* access modifiers changed from: package-private */
    public abstract List<String> j();

    /* access modifiers changed from: package-private */
    public abstract List<Intent> k();
}
