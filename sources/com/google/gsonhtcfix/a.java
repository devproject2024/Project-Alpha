package com.google.gsonhtcfix;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

final class a implements k<Date>, u<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f39640a;

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f39641b;

    /* renamed from: c  reason: collision with root package name */
    private final DateFormat f39642c;

    a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    a(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    public a(int i2, int i3) {
        this(DateFormat.getDateTimeInstance(i2, i3, Locale.US), DateFormat.getDateTimeInstance(i2, i3));
    }

    private a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f39640a = dateFormat;
        this.f39641b = dateFormat2;
        this.f39642c = new SimpleDateFormat(AppConstants.DATE_FORMAT, Locale.US);
        this.f39642c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* access modifiers changed from: private */
    public l a(Date date) {
        s sVar;
        synchronized (this.f39641b) {
            sVar = new s(this.f39640a.format(date));
        }
        return sVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = r3.f39642c.parse(r4.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        throw new com.google.gsonhtcfix.v(r4.b(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4 = r3.f39640a.parse(r4.b());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Date a(com.google.gsonhtcfix.l r4) {
        /*
            r3 = this;
            java.text.DateFormat r0 = r3.f39641b
            monitor-enter(r0)
            java.text.DateFormat r1 = r3.f39641b     // Catch:{ ParseException -> 0x0011 }
            java.lang.String r2 = r4.b()     // Catch:{ ParseException -> 0x0011 }
            java.util.Date r4 = r1.parse(r2)     // Catch:{ ParseException -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r4
        L_0x000f:
            r4 = move-exception
            goto L_0x0034
        L_0x0011:
            java.text.DateFormat r1 = r3.f39640a     // Catch:{ ParseException -> 0x001d }
            java.lang.String r2 = r4.b()     // Catch:{ ParseException -> 0x001d }
            java.util.Date r4 = r1.parse(r2)     // Catch:{ ParseException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r4
        L_0x001d:
            java.text.DateFormat r1 = r3.f39642c     // Catch:{ ParseException -> 0x0029 }
            java.lang.String r2 = r4.b()     // Catch:{ ParseException -> 0x0029 }
            java.util.Date r4 = r1.parse(r2)     // Catch:{ ParseException -> 0x0029 }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r4
        L_0x0029:
            r1 = move-exception
            com.google.gsonhtcfix.v r2 = new com.google.gsonhtcfix.v     // Catch:{ all -> 0x000f }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x000f }
            r2.<init>(r4, r1)     // Catch:{ all -> 0x000f }
            throw r2     // Catch:{ all -> 0x000f }
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gsonhtcfix.a.a(com.google.gsonhtcfix.l):java.util.Date");
    }

    public final String toString() {
        return a.class.getSimpleName() + '(' + this.f39641b.getClass().getSimpleName() + ')';
    }

    public final /* synthetic */ Object a(l lVar, Type type) throws p {
        if (lVar instanceof s) {
            Date a2 = a(lVar);
            if (type == Date.class) {
                return a2;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a2.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a2.getTime());
            }
            throw new IllegalArgumentException(getClass() + " cannot deserialize to " + type);
        }
        throw new p("The date should be a string value");
    }
}
