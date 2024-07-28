package com.google.firebase.crashlytics.a.g;

import android.content.Context;
import com.google.firebase.crashlytics.a.b;
import java.io.File;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38598a;

    public i(Context context) {
        this.f38598a = context;
    }

    public final File a() {
        File file = new File(this.f38598a.getFilesDir(), ".com.google.firebase.crashlytics");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        b.a().a(5);
        return null;
    }

    public final String b() {
        return new File(this.f38598a.getFilesDir(), ".com.google.firebase.crashlytics").getPath();
    }
}
