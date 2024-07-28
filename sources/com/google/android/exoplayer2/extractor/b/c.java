package com.google.android.exoplayer2.extractor.b;

import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    long f31700a = -9223372036854775807L;

    /* access modifiers changed from: protected */
    public final boolean a(r rVar) {
        return true;
    }

    public c() {
        super(new f());
    }

    private static Boolean b(r rVar) {
        boolean z = true;
        if (rVar.c() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double c(r rVar) {
        return Double.valueOf(Double.longBitsToDouble(rVar.k()));
    }

    private static String d(r rVar) {
        int d2 = rVar.d();
        int i2 = rVar.f32567b;
        rVar.d(d2);
        return new String(rVar.f32566a, i2, d2);
    }

    private static ArrayList<Object> e(r rVar) {
        int n = rVar.n();
        ArrayList<Object> arrayList = new ArrayList<>(n);
        for (int i2 = 0; i2 < n; i2++) {
            Object a2 = a(rVar, rVar.c());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    private static HashMap<String, Object> f(r rVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String d2 = d(rVar);
            int c2 = rVar.c();
            if (c2 == 9) {
                return hashMap;
            }
            Object a2 = a(rVar, c2);
            if (a2 != null) {
                hashMap.put(d2, a2);
            }
        }
    }

    private static HashMap<String, Object> g(r rVar) {
        int n = rVar.n();
        HashMap<String, Object> hashMap = new HashMap<>(n);
        for (int i2 = 0; i2 < n; i2++) {
            String d2 = d(rVar);
            Object a2 = a(rVar, rVar.c());
            if (a2 != null) {
                hashMap.put(d2, a2);
            }
        }
        return hashMap;
    }

    private static Date h(r rVar) {
        Date date = new Date((long) c(rVar).doubleValue());
        rVar.d(2);
        return date;
    }

    private static Object a(r rVar, int i2) {
        if (i2 == 0) {
            return c(rVar);
        }
        if (i2 == 1) {
            return b(rVar);
        }
        if (i2 == 2) {
            return d(rVar);
        }
        if (i2 == 3) {
            return f(rVar);
        }
        if (i2 == 8) {
            return g(rVar);
        }
        if (i2 == 10) {
            return e(rVar);
        }
        if (i2 != 11) {
            return null;
        }
        return h(rVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a(r rVar, long j) throws v {
        if (rVar.c() != 2) {
            throw new v();
        } else if (!"onMetaData".equals(d(rVar)) || rVar.c() != 8) {
            return false;
        } else {
            HashMap<String, Object> g2 = g(rVar);
            if (g2.containsKey(AppConstants.DURATION)) {
                double doubleValue = ((Double) g2.get(AppConstants.DURATION)).doubleValue();
                if (doubleValue > 0.0d) {
                    this.f31700a = (long) (doubleValue * 1000000.0d);
                }
            }
            return false;
        }
    }
}
