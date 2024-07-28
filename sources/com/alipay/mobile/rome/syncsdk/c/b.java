package com.alipay.mobile.rome.syncsdk.c;

import android.content.Context;
import com.alipay.mobile.rome.syncsdk.e.h;
import java.io.File;

public abstract class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15009b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static String f15010c = "com.alipay.android.phone.rome.syncsdk";

    /* renamed from: a  reason: collision with root package name */
    protected String f15011a = "";

    /* renamed from: d  reason: collision with root package name */
    private Context f15012d;

    public abstract void a(String str);

    public abstract boolean a(a aVar);

    public abstract void b(a aVar);

    public b(Context context) {
        this.f15012d = context;
    }

    /* access modifiers changed from: protected */
    public final String a() {
        String str = this.f15012d.getFilesDir().getPath() + "/";
        String str2 = str + f15010c + File.separatorChar;
        h.a(f15009b, "getMsgDir() strLonglink=".concat(String.valueOf(str2)));
        new File(str).mkdir();
        new File(str2).mkdir();
        return str2;
    }
}
