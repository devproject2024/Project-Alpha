package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface bk {
    ConnectionResult a(TimeUnit timeUnit);

    <A extends a.b, R extends l, T extends d.a<R, A>> T a(T t);

    void a();

    void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    boolean a(q qVar);

    <A extends a.b, T extends d.a<? extends l, A>> T b(T t);

    void b();

    boolean d();

    boolean e();

    void f();

    void g();
}
