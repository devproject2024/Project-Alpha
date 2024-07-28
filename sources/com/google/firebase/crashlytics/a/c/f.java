package com.google.firebase.crashlytics.a.c;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f38180a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private static String f38181b;

    f(v vVar) {
        long time = new Date().getTime();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) (time / 1000));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        byte[] array = allocate.array();
        byte[] a2 = a(time % 1000);
        byte[] a3 = a(f38180a.incrementAndGet());
        byte[] a4 = a((long) Integer.valueOf(Process.myPid()).shortValue());
        byte[] bArr = {array[0], array[1], array[2], array[3], a2[0], a2[1], a3[0], a3[1], a4[0], a4[1]};
        String a5 = g.a(vVar.a());
        String a6 = g.a(bArr);
        f38181b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a6.substring(0, 12), a6.substring(12, 16), a6.subSequence(16, 20), a5.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public final String toString() {
        return f38181b;
    }
}
