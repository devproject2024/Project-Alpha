package net.one97.paytm.moneytransfer.b.a.a;

import android.content.Context;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public final class b extends AsyncTask<Object, Object, Object> {

    /* renamed from: a  reason: collision with root package name */
    private String f53534a;

    /* renamed from: b  reason: collision with root package name */
    private String f53535b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Context> f53536c;

    public b(Context context, String str, String str2) {
        this.f53536c = new WeakReference<>(context);
        this.f53534a = str2;
        this.f53535b = str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079 A[Catch:{ IllegalStateException -> 0x0072, Exception -> 0x006c, all -> 0x0069, all -> 0x0065 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doInBackground(java.lang.Object... r7) {
        /*
            r6 = this;
            r7 = 0
            net.one97.paytm.moneytransfer.utils.j r0 = new net.one97.paytm.moneytransfer.utils.j     // Catch:{ Exception -> 0x0094 }
            r0.<init>()     // Catch:{ Exception -> 0x0094 }
            java.lang.ref.WeakReference<android.content.Context> r0 = r6.f53536c     // Catch:{ Exception -> 0x0094 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0094 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = r6.f53535b     // Catch:{ Exception -> 0x0094 }
            java.lang.String r2 = r6.f53534a     // Catch:{ Exception -> 0x0094 }
            net.one97.paytm.upi.database.a r0 = net.one97.paytm.upi.database.a.a(r0)     // Catch:{ Exception -> 0x0094 }
            boolean r3 = r0.b()     // Catch:{ Exception -> 0x0094 }
            if (r3 != 0) goto L_0x0021
            android.database.sqlite.SQLiteDatabase r3 = r0.a()     // Catch:{ Exception -> 0x0094 }
            goto L_0x0023
        L_0x0021:
            android.database.sqlite.SQLiteDatabase r3 = r0.f66667a     // Catch:{ Exception -> 0x0094 }
        L_0x0023:
            r3.beginTransaction()     // Catch:{ Exception -> 0x0094 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0094 }
            java.lang.String r5 = "SELECT * FROM mt_saved_beneficiaries WHERE beneficiary_uuid = '"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0094 }
            r4.append(r1)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = "' AND beneficiary_id = '"
            r4.append(r1)     // Catch:{ Exception -> 0x0094 }
            r4.append(r2)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = "'"
            r4.append(r1)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0094 }
            android.database.Cursor r1 = r3.rawQuery(r1, r7)     // Catch:{ IllegalStateException -> 0x0072, Exception -> 0x006c, all -> 0x0069 }
            boolean r2 = r1.moveToFirst()     // Catch:{ IllegalStateException -> 0x0073, Exception -> 0x0067 }
            if (r2 == 0) goto L_0x007d
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ IllegalStateException -> 0x0073, Exception -> 0x0067 }
            int r2 = r1.getInt(r2)     // Catch:{ IllegalStateException -> 0x0073, Exception -> 0x0067 }
            java.lang.String r4 = "mt_saved_beneficiaries"
            java.lang.String r5 = "id = "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IllegalStateException -> 0x0073, Exception -> 0x0067 }
            java.lang.String r2 = r5.concat(r2)     // Catch:{ IllegalStateException -> 0x0073, Exception -> 0x0067 }
            r3.delete(r4, r2, r7)     // Catch:{ IllegalStateException -> 0x0073, Exception -> 0x0067 }
            goto L_0x007d
        L_0x0065:
            r0 = move-exception
            goto L_0x008a
        L_0x0067:
            r0 = move-exception
            goto L_0x006e
        L_0x0069:
            r0 = move-exception
            r1 = r7
            goto L_0x008a
        L_0x006c:
            r0 = move-exception
            r1 = r7
        L_0x006e:
            r0.printStackTrace()     // Catch:{ all -> 0x0065 }
            goto L_0x007d
        L_0x0072:
            r1 = r7
        L_0x0073:
            boolean r2 = r3.isOpen()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x007d
            android.database.sqlite.SQLiteDatabase r3 = r0.a()     // Catch:{ all -> 0x0065 }
        L_0x007d:
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x0065 }
            r3.endTransaction()     // Catch:{ Exception -> 0x0094 }
            net.one97.paytm.moneytransfer.utils.j.a((android.database.Cursor) r1)     // Catch:{ Exception -> 0x0094 }
            r3.close()     // Catch:{ Exception -> 0x0094 }
            goto L_0x0098
        L_0x008a:
            r3.endTransaction()     // Catch:{ Exception -> 0x0094 }
            net.one97.paytm.moneytransfer.utils.j.a((android.database.Cursor) r1)     // Catch:{ Exception -> 0x0094 }
            r3.close()     // Catch:{ Exception -> 0x0094 }
            throw r0     // Catch:{ Exception -> 0x0094 }
        L_0x0094:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0098:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.b.a.a.b.doInBackground(java.lang.Object[]):java.lang.Object");
    }
}
