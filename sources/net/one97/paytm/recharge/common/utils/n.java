package net.one97.paytm.recharge.common.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.loader.a.a;
import androidx.loader.b.b;
import androidx.loader.b.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.ContactItemModel;

public final class n implements a.C0056a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    public static final n f61679a = new n();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static y<List<ContactItemModel>> f61680b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, ContactItemModel> f61681c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static boolean f61682d;

    public final void a(c<Cursor> cVar) {
        k.c(cVar, "loader");
    }

    private n() {
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        k.c(cVar, "loader");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new a((Cursor) obj));
    }

    public final LiveData<List<ContactItemModel>> a(androidx.loader.a.a aVar) {
        k.c(aVar, "loaderManager");
        if (f61680b.getValue() == null) {
            aVar.a(0, (Bundle) null, this);
        }
        return f61680b;
    }

    public final c<Cursor> a(Bundle bundle) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] strArr = {"display_name", "data1", "photo_uri"};
        Context applicationContext = CJRRechargeUtilities.INSTANCE.getApplicationContext();
        if (applicationContext == null) {
            k.a();
        }
        return new b(applicationContext, uri, strArr, (String) null, (String[]) null, "display_name");
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Cursor f61683a;

        a(Cursor cursor) {
            this.f61683a = cursor;
        }

        public final void run() {
            if (this.f61683a != null) {
                n nVar = n.f61679a;
                synchronized (Boolean.valueOf(n.f61682d)) {
                    n nVar2 = n.f61679a;
                    if (!n.f61682d) {
                        n nVar3 = n.f61679a;
                        n.f61682d = true;
                        try {
                            n nVar4 = n.f61679a;
                            ArrayList a2 = n.a(this.f61683a, true);
                            if (!a2.isEmpty()) {
                                n nVar5 = n.f61679a;
                                n.f61680b.postValue(a2);
                            }
                        } catch (Throwable th) {
                            CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
                        }
                    }
                    x xVar = x.f47997a;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static ArrayList<ContactItemModel> a(Cursor cursor, boolean z) {
        ArrayList<ContactItemModel> arrayList = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String string = cursor.getString(cursor.getColumnIndex("display_name"));
            String string2 = cursor.getString(cursor.getColumnIndex("data1"));
            String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
            k.a((Object) string2, "filterNumber");
            String a2 = g.a(p.a(p.a(p.a(p.a(string2, "-", "", false), " ", "", false), "(", "", false), ")", "", false));
            if (a2.length() > 10) {
                a2 = g.b(a2);
            }
            if (com.paytm.utility.b.c(a2) && !TextUtils.isEmpty(string)) {
                if (!z || f61681c.containsKey(a2)) {
                    arrayList.add(new ContactItemModel(string, a2, string3, false));
                } else {
                    f61681c.put(a2, new ContactItemModel(string, a2, string3, false));
                    arrayList.add(new ContactItemModel(string, a2, string3, false));
                }
            }
            cursor.moveToNext();
        }
        cursor.close();
        try {
            Collections.sort(arrayList, new ad());
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLog("Failed to sort phone contact names");
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
        return arrayList;
    }

    public static ContactItemModel a(String str) {
        k.c(str, "rechargeNumber");
        if (f61681c.containsKey(str)) {
            return f61681c.get(str);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<net.one97.paytm.recharge.model.ContactItemModel> a(android.content.Context r8, android.content.Intent r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof android.app.Activity
            if (r1 == 0) goto L_0x000c
            r1 = r8
            android.app.Activity r1 = (android.app.Activity) r1
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            if (r1 != 0) goto L_0x0010
            return r0
        L_0x0010:
            boolean r1 = r1.isFinishing()
            if (r1 == 0) goto L_0x0017
            return r0
        L_0x0017:
            if (r9 == 0) goto L_0x005d
            android.net.Uri r3 = r9.getData()
            if (r3 == 0) goto L_0x005d
            java.lang.String r9 = "display_name"
            java.lang.String r1 = "data1"
            java.lang.String r2 = "photo_uri"
            java.lang.String[] r4 = new java.lang.String[]{r9, r1, r2}     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "display_name"
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            if (r8 == 0) goto L_0x005d
            r9 = 0
            java.util.ArrayList r9 = a((android.database.Cursor) r8, (boolean) r9)     // Catch:{ Exception -> 0x0042 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Exception -> 0x0042 }
            r8.close()
            return r9
        L_0x0042:
            r9 = move-exception
            goto L_0x0048
        L_0x0044:
            r9 = move-exception
            goto L_0x0057
        L_0x0046:
            r9 = move-exception
            r8 = r0
        L_0x0048:
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0055 }
            com.paytm.utility.q.d(r9)     // Catch:{ all -> 0x0055 }
            if (r8 == 0) goto L_0x005d
            r8.close()
            goto L_0x005d
        L_0x0055:
            r9 = move-exception
            r0 = r8
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()
        L_0x005c:
            throw r9
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.utils.n.a(android.content.Context, android.content.Intent):java.util.List");
    }
}
