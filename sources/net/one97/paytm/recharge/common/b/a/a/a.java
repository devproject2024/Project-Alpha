package net.one97.paytm.recharge.common.b.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.b.a.b.a;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60878a = new a();

    private a() {
    }

    public static void a(Context context) {
        k.c(context, "context");
        net.one97.paytm.recharge.common.b.a.c.a aVar = net.one97.paytm.recharge.common.b.a.c.a.f60883b;
        net.one97.paytm.recharge.common.b.a.c.a.a(context);
    }

    public static void a(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "categoryId");
        k.c(str2, Payload.RESPONSE);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("categoryid", str);
            contentValues.put(Payload.RESPONSE, str2);
            if (a(context, str) == null) {
                net.one97.paytm.recharge.common.b.a.c.a aVar = net.one97.paytm.recharge.common.b.a.c.a.f60883b;
                Context applicationContext = context.getApplicationContext();
                k.a((Object) applicationContext, "context.applicationContext");
                SQLiteDatabase b2 = net.one97.paytm.recharge.common.b.a.c.a.b(applicationContext);
                if (b2 != null) {
                    a.C1173a aVar2 = net.one97.paytm.recharge.common.b.a.b.a.f60879a;
                    b2.insert(net.one97.paytm.recharge.common.b.a.b.a.f60880b, (String) null, contentValues);
                }
            }
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    public static void b(Context context, String str, String str2) {
        k.c(context, "context");
        k.c(str, "categoryId");
        k.c(str2, Payload.RESPONSE);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("categoryid", str);
            contentValues.put(Payload.RESPONSE, str2);
            Context applicationContext = context.getApplicationContext();
            k.a((Object) applicationContext, "context.applicationContext");
            if (!TextUtils.isEmpty(a(applicationContext, str))) {
                net.one97.paytm.recharge.common.b.a.c.a aVar = net.one97.paytm.recharge.common.b.a.c.a.f60883b;
                Context applicationContext2 = context.getApplicationContext();
                k.a((Object) applicationContext2, "context.applicationContext");
                SQLiteDatabase b2 = net.one97.paytm.recharge.common.b.a.c.a.b(applicationContext2);
                if (b2 != null) {
                    a.C1173a aVar2 = net.one97.paytm.recharge.common.b.a.b.a.f60879a;
                    b2.update(net.one97.paytm.recharge.common.b.a.b.a.f60880b, contentValues, "categoryid = ".concat(String.valueOf(str)), (String[]) null);
                    return;
                }
                return;
            }
            Context applicationContext3 = context.getApplicationContext();
            k.a((Object) applicationContext3, "context.applicationContext");
            a(applicationContext3, str, str2);
        } catch (Throwable th) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ad, code lost:
        if (r0.isClosed() == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00af, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c8, code lost:
        if (r0.isClosed() == false) goto L_0x00af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c4 A[Catch:{ Exception -> 0x00a5, all -> 0x00a3, all -> 0x00cb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "context.applicationContext"
            java.lang.String r1 = "context"
            kotlin.g.b.k.c(r5, r1)
            java.lang.String r2 = "categoryId"
            kotlin.g.b.k.c(r6, r2)
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = "Select * from "
            r3.<init>(r4)     // Catch:{ all -> 0x00cb }
            net.one97.paytm.recharge.common.b.a.b.a$a r4 = net.one97.paytm.recharge.common.b.a.b.a.f60879a     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = net.one97.paytm.recharge.common.b.a.b.a.f60880b     // Catch:{ all -> 0x00cb }
            r3.append(r4)     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = " where categoryid = "
            r3.append(r4)     // Catch:{ all -> 0x00cb }
            r3.append(r6)     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cb }
            net.one97.paytm.recharge.common.b.a.c.a r4 = net.one97.paytm.recharge.common.b.a.c.a.f60883b     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            android.content.Context r4 = r5.getApplicationContext()     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            kotlin.g.b.k.c(r4, r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            net.one97.paytm.recharge.common.b.a.b.a r1 = net.one97.paytm.recharge.common.b.a.c.a.f60882a     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            if (r1 != 0) goto L_0x0043
            android.content.Context r1 = r4.getApplicationContext()     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            net.one97.paytm.recharge.common.b.a.c.a.a(r1)     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
        L_0x0043:
            net.one97.paytm.recharge.common.b.a.b.a r0 = net.one97.paytm.recharge.common.b.a.c.a.f60882a     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            if (r0 == 0) goto L_0x004c
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            goto L_0x004d
        L_0x004c:
            r0 = r2
        L_0x004d:
            if (r0 == 0) goto L_0x0054
            android.database.Cursor r0 = r0.rawQuery(r3, r2)     // Catch:{ Exception -> 0x00c1, all -> 0x00b3 }
            goto L_0x0055
        L_0x0054:
            r0 = r2
        L_0x0055:
            if (r0 == 0) goto L_0x00a7
            r0.moveToFirst()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
        L_0x005a:
            java.lang.String r1 = "response"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r1 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x006b
            r0.close()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
        L_0x006b:
            if (r0 == 0) goto L_0x0076
            boolean r5 = r0.isClosed()     // Catch:{ all -> 0x00cb }
            if (r5 != 0) goto L_0x0076
            r0.close()     // Catch:{ all -> 0x00cb }
        L_0x0076:
            return r1
        L_0x0077:
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r1 != 0) goto L_0x005a
            r0.close()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            kotlin.x r1 = kotlin.x.f47997a     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r1.<init>()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            r1.append(r6)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r6 = "_getcategory.json"
            r1.append(r6)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            java.lang.String r5 = net.one97.paytm.recharge.legacy.catalog.b.e.a(r5, r6)     // Catch:{ Exception -> 0x00a5, all -> 0x00a3 }
            if (r0 == 0) goto L_0x00a2
            boolean r6 = r0.isClosed()     // Catch:{ all -> 0x00cb }
            if (r6 != 0) goto L_0x00a2
            r0.close()     // Catch:{ all -> 0x00cb }
        L_0x00a2:
            return r5
        L_0x00a3:
            r5 = move-exception
            goto L_0x00b5
        L_0x00a5:
            goto L_0x00c2
        L_0x00a7:
            if (r0 == 0) goto L_0x00d1
            boolean r5 = r0.isClosed()     // Catch:{ all -> 0x00cb }
            if (r5 != 0) goto L_0x00d1
        L_0x00af:
            r0.close()     // Catch:{ all -> 0x00cb }
            goto L_0x00d1
        L_0x00b3:
            r5 = move-exception
            r0 = r2
        L_0x00b5:
            if (r0 == 0) goto L_0x00c0
            boolean r6 = r0.isClosed()     // Catch:{ all -> 0x00cb }
            if (r6 != 0) goto L_0x00c0
            r0.close()     // Catch:{ all -> 0x00cb }
        L_0x00c0:
            throw r5     // Catch:{ all -> 0x00cb }
        L_0x00c1:
            r0 = r2
        L_0x00c2:
            if (r0 == 0) goto L_0x00d1
            boolean r5 = r0.isClosed()     // Catch:{ all -> 0x00cb }
            if (r5 != 0) goto L_0x00d1
            goto L_0x00af
        L_0x00cb:
            r5 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r6 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            r6.debugLogExceptions(r5)
        L_0x00d1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.a.a.a.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
