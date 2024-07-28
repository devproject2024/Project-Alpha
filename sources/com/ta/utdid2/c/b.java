package com.ta.utdid2.c;

import android.content.Context;
import com.business.merchant_payments.utility.StringUtility;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.e;
import java.util.zip.Adler32;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static String f16157a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";

    /* renamed from: b  reason: collision with root package name */
    static final Object f16158b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static a f16159c;

    private static a b(Context context) {
        long j;
        if (context == null) {
            return null;
        }
        new a();
        synchronized (f16158b) {
            String a2 = d.a(context).a();
            if (e.a(a2)) {
                return null;
            }
            if (a2.endsWith(StringUtility.NEW_LINE)) {
                a2 = a2.substring(0, a2.length() - 1);
            }
            a aVar = new a();
            long currentTimeMillis = System.currentTimeMillis();
            String a3 = d.a(context);
            String b2 = d.b(context);
            aVar.f16153c = a3;
            aVar.f16151a = a3;
            aVar.f16155e = currentTimeMillis;
            aVar.f16152b = b2;
            aVar.f16154d = a2;
            String format = String.format("%s%s%s%s%s", new Object[]{aVar.f16154d, aVar.f16153c, Long.valueOf(aVar.f16155e), aVar.f16152b, aVar.f16151a});
            if (!e.a(format)) {
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(format.getBytes());
                j = adler32.getValue();
            } else {
                j = 0;
            }
            aVar.f16156f = j;
            return aVar;
        }
    }

    public static synchronized a a(Context context) {
        synchronized (b.class) {
            if (f16159c != null) {
                a aVar = f16159c;
                return aVar;
            } else if (context == null) {
                return null;
            } else {
                a b2 = b(context);
                f16159c = b2;
                return b2;
            }
        }
    }
}
