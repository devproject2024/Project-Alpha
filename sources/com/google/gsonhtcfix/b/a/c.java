package com.google.gsonhtcfix.b.a;

import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.d.b;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.y;
import com.google.gsonhtcfix.z;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class c extends y<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final z f39649a = new z() {
        public final <T> y<T> a(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f39650b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c  reason: collision with root package name */
    private final DateFormat f39651c = DateFormat.getDateTimeInstance(2, 2);

    /* renamed from: d  reason: collision with root package name */
    private final DateFormat f39652d;

    public c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppConstants.DATE_FORMAT, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.f39652d = simpleDateFormat;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        return r2.f39652d.parse(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        throw new com.google.gsonhtcfix.v(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        return r2.f39650b.parse(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.Date a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.text.DateFormat r0 = r2.f39651c     // Catch:{ ParseException -> 0x000b }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x000b }
            monitor-exit(r2)
            return r3
        L_0x0009:
            r3 = move-exception
            goto L_0x0022
        L_0x000b:
            java.text.DateFormat r0 = r2.f39650b     // Catch:{ ParseException -> 0x0013 }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x0013 }
            monitor-exit(r2)
            return r3
        L_0x0013:
            java.text.DateFormat r0 = r2.f39652d     // Catch:{ ParseException -> 0x001b }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x001b }
            monitor-exit(r2)
            return r3
        L_0x001b:
            r0 = move-exception
            com.google.gsonhtcfix.v r1 = new com.google.gsonhtcfix.v     // Catch:{ all -> 0x0009 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x0022:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.b.a.c.a(java.lang.String):java.util.Date");
    }

    /* access modifiers changed from: private */
    public synchronized void a(com.google.gsonhtcfix.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.e();
        } else {
            cVar.b(this.f39650b.format(date));
        }
    }

    public final /* synthetic */ Object a(com.google.gsonhtcfix.d.a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return a(aVar.i());
        }
        aVar.k();
        return null;
    }
}
