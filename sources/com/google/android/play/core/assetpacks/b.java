package com.google.android.play.core.assetpacks;

import com.google.android.play.core.splitcompat.r;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37039a = new ah(1, (String) null, (String) null);

    static b a(String str, String str2) {
        r.a(str, (Object) "STORAGE_FILES location path must be non-null");
        r.a(str, (Object) "STORAGE_FILES assetsPath must be non-null");
        return new ah(0, str, str2);
    }

    public abstract int a();

    public abstract String b();

    public abstract String c();
}
