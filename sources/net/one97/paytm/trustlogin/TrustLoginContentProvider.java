package net.one97.paytm.trustlogin;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.net.Uri;
import com.sendbird.android.constant.StringSet;

public class TrustLoginContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    static final UriMatcher f65176a;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f65176a = uriMatcher;
        uriMatcher.addURI("net.one97.paytm.trustlogin.TrustInfo", StringSet.user, 1);
        f65176a.addURI("net.one97.paytm.trustlogin.TrustInfo", "user/token", 2);
        f65176a.addURI("net.one97.paytm.trustlogin.TrustInfo", "user/instruments", 3);
        f65176a.addURI("net.one97.paytm.trustlogin.TrustInfo", "user/validAuthCode", 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00aa, code lost:
        if (r11 == false) goto L_0x02de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r20, java.lang.String[] r21, java.lang.String r22, java.lang.String[] r23, java.lang.String r24) {
        /*
            r19 = this;
            android.database.MatrixCursor r1 = new android.database.MatrixCursor
            java.lang.String r2 = "mask_mobile"
            java.lang.String r3 = "user_name"
            java.lang.String r4 = "image_url"
            java.lang.String r5 = "auth_code"
            java.lang.String r6 = "custom_data"
            java.lang.String r7 = "error_msg"
            java.lang.String r8 = "is_success"
            java.lang.String[] r0 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8}
            r1.<init>(r0)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0308 }
            r3 = r22
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r3 = "client_id"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r4 = "build_type"
            r2.optString(r4)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r4 = "mobile"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r5 = "app_name"
            r2.optString(r5)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r5 = "package"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r6 = "mid"
            java.lang.String r6 = r2.optString(r6)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r7 = "savedAuthCode"
            java.lang.String r7 = r2.optString(r7)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r8 = "wallet"
            boolean r8 = r2.optBoolean(r8)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r9 = "saved_card"
            boolean r9 = r2.optBoolean(r9)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r10 = "saved_vpa"
            boolean r10 = r2.optBoolean(r10)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r11 = "isTrusted"
            boolean r11 = r2.optBoolean(r11)     // Catch:{ JSONException -> 0x0308 }
            java.lang.String r12 = "shouldMatchMobile"
            boolean r2 = r2.optBoolean(r12)     // Catch:{ JSONException -> 0x0308 }
            android.content.Context r12 = r19.getContext()
            android.content.pm.PackageManager r12 = r12.getPackageManager()
            int r13 = android.os.Binder.getCallingUid()
            java.lang.String r12 = r12.getNameForUid(r13)
            if (r11 == 0) goto L_0x0077
            r12 = r5
        L_0x0077:
            android.content.Context r5 = r19.getContext()
            java.lang.String r13 = "release"
            net.one97.paytm.common.entity.trustLogin.SavedAppData$AppData r5 = net.one97.paytm.trustlogin.b.a(r5, r13, r12)
            java.lang.String r13 = "FALSE"
            r14 = 7
            r16 = 0
            java.lang.String r15 = ""
            if (r5 == 0) goto L_0x02de
            if (r11 != 0) goto L_0x00ac
            android.content.Context r11 = r19.getContext()
            if (r5 == 0) goto L_0x00a9
            if (r12 != 0) goto L_0x0095
            goto L_0x00a9
        L_0x0095:
            java.lang.String r11 = net.one97.paytm.trustlogin.b.a(r11, r12)
            java.lang.String r12 = r5.getSha1_signature()
            if (r11 == 0) goto L_0x00a9
            if (r12 == 0) goto L_0x00a9
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x00a9
            r11 = 1
            goto L_0x00aa
        L_0x00a9:
            r11 = 0
        L_0x00aa:
            if (r11 == 0) goto L_0x02de
        L_0x00ac:
            android.content.Context r11 = r19.getContext()
            java.lang.String r11 = net.one97.paytm.utils.t.b((android.content.Context) r11)
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x00e3
            java.lang.Object[] r0 = new java.lang.Object[r14]
            r0[r16] = r15
            r2 = 1
            r0[r2] = r15
            r2 = 2
            r0[r2] = r15
            r2 = 3
            r0[r2] = r15
            r2 = 4
            r0[r2] = r15
            android.content.Context r2 = r19.getContext()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131964482(0x7f133242, float:1.9565747E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 5
            r0[r3] = r2
            r2 = 6
            r0[r2] = r13
            r1.addRow(r0)
            return r1
        L_0x00e3:
            android.content.Context r11 = r19.getContext()
            java.lang.String r11 = com.paytm.utility.a.b((android.content.Context) r11)
            android.content.Context r12 = r19.getContext()
            java.lang.String r12 = com.paytm.utility.b.h((android.content.Context) r12)
            android.content.Context r17 = r19.getContext()
            java.lang.String r17 = com.paytm.utility.b.al(r17)
            boolean r18 = android.text.TextUtils.isEmpty(r11)
            if (r18 == 0) goto L_0x012a
            java.lang.Object[] r0 = new java.lang.Object[r14]
            r0[r16] = r15
            r2 = 1
            r0[r2] = r15
            r2 = 2
            r0[r2] = r15
            r2 = 3
            r0[r2] = r15
            r2 = 4
            r0[r2] = r15
            android.content.Context r2 = r19.getContext()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131964479(0x7f13323f, float:1.956574E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 5
            r0[r3] = r2
            r2 = 6
            r0[r2] = r13
            r1.addRow(r0)
            return r1
        L_0x012a:
            java.lang.String r5 = r5.getApp_client_id()
            boolean r18 = android.text.TextUtils.isEmpty(r5)
            if (r18 == 0) goto L_0x0135
            goto L_0x0136
        L_0x0135:
            r3 = r5
        L_0x0136:
            android.content.UriMatcher r5 = f65176a
            r0 = r20
            int r0 = r5.match(r0)
            java.lang.String r5 = "TRUE"
            r14 = 1
            if (r0 == r14) goto L_0x028f
            r14 = 2
            if (r0 == r14) goto L_0x022a
            java.lang.String r2 = "type"
            java.lang.String r4 = "query"
            java.lang.String r11 = "TrustLoginContentProvider"
            r12 = 3
            if (r0 == r12) goto L_0x01ed
            r12 = 4
            if (r0 == r12) goto L_0x017b
            r6 = 7
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r16] = r15
            r2 = 1
            r0[r2] = r15
            r0[r14] = r15
            r2 = 3
            r0[r2] = r15
            r0[r12] = r15
            android.content.Context r2 = r19.getContext()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131964477(0x7f13323d, float:1.9565737E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 5
            r0[r3] = r2
            r2 = 6
            r0[r2] = r13
            r1.addRow(r0)
            goto L_0x02dd
        L_0x017b:
            android.content.Context r0 = r19.getContext()
            boolean r6 = com.paytm.utility.a.p(r0)
            if (r6 == 0) goto L_0x01b7
            android.content.Context r6 = r0.getApplicationContext()
            com.paytm.b.a.a r6 = net.one97.paytm.utils.ag.a(r6)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = com.paytm.utility.a.a((android.content.Context) r0)
            r8.append(r0)
            r8.append(r3)
            java.lang.String r0 = "-AuthCode"
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r3 = 1
            java.lang.String r0 = r6.b((java.lang.String) r0, (java.lang.String) r15, (boolean) r3)
            if (r0 == 0) goto L_0x01b7
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01b7
            boolean r0 = r0.equals(r7)
            goto L_0x01b8
        L_0x01b7:
            r0 = 0
        L_0x01b8:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01cc }
            r3.<init>()     // Catch:{ JSONException -> 0x01cc }
            java.lang.String r6 = "saved_auth_code"
            r3.put(r2, r6)     // Catch:{ JSONException -> 0x01cc }
            java.lang.String r2 = "data"
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x01cc }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x01cc }
            goto L_0x01d1
        L_0x01cc:
            r0 = move-exception
            net.one97.paytm.utils.r.a((java.lang.String) r11, (java.lang.String) r4, (java.lang.Throwable) r0)
            r0 = r15
        L_0x01d1:
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r16] = r15
            r3 = 1
            r2[r3] = r15
            r3 = 2
            r2[r3] = r15
            r3 = 3
            r2[r3] = r15
            r3 = 4
            r2[r3] = r0
            r3 = 5
            r2[r3] = r15
            r3 = 6
            r2[r3] = r5
            r1.addRow(r2)
            goto L_0x02dd
        L_0x01ed:
            android.content.Context r0 = r19.getContext()
            java.util.HashMap r0 = net.one97.paytm.trustlogin.a.a(r0, r6, r8, r9, r10)
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0209 }
            r3.<init>()     // Catch:{ JSONException -> 0x0209 }
            java.lang.String r6 = "saved_instruments"
            r3.put(r2, r6)     // Catch:{ JSONException -> 0x0209 }
            java.lang.String r2 = "data"
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x0209 }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x0209 }
            goto L_0x020e
        L_0x0209:
            r0 = move-exception
            net.one97.paytm.utils.r.a((java.lang.String) r11, (java.lang.String) r4, (java.lang.Throwable) r0)
            r0 = r15
        L_0x020e:
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r16] = r15
            r3 = 1
            r2[r3] = r15
            r3 = 2
            r2[r3] = r15
            r3 = 3
            r2[r3] = r15
            r3 = 4
            r2[r3] = r0
            r3 = 5
            r2[r3] = r15
            r3 = 6
            r2[r3] = r5
            r1.addRow(r2)
            goto L_0x02dd
        L_0x022a:
            if (r2 == 0) goto L_0x0260
            if (r4 == 0) goto L_0x0235
            boolean r0 = r4.equals(r11)
            if (r0 == 0) goto L_0x0235
            goto L_0x0260
        L_0x0235:
            r2 = 7
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r16] = r15
            r2 = 1
            r0[r2] = r15
            r2 = 2
            r0[r2] = r15
            r2 = 3
            r0[r2] = r15
            r2 = 4
            r0[r2] = r15
            android.content.Context r2 = r19.getContext()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131964478(0x7f13323e, float:1.9565739E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 5
            r0[r3] = r2
            r2 = 6
            r0[r2] = r13
            r1.addRow(r0)
            goto L_0x02dd
        L_0x0260:
            android.content.Context r0 = r19.getContext()
            net.one97.paytm.common.entity.trustLogin.TrustLoginObject r0 = net.one97.paytm.trustlogin.a.b(r0, r3)
            if (r0 == 0) goto L_0x028d
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r16] = r11
            r3 = 1
            r2[r3] = r12
            r3 = 2
            r2[r3] = r17
            java.lang.String r3 = r0.getData()
            r4 = 3
            r2[r4] = r3
            r3 = 4
            r2[r3] = r15
            java.lang.String r0 = r0.getResponseMessage()
            r3 = 5
            r2[r3] = r0
            r3 = 6
            r2[r3] = r5
            r1.addRow(r2)
            goto L_0x02dd
        L_0x028d:
            r1 = 0
            goto L_0x02dd
        L_0x028f:
            android.content.Context r0 = r19.getContext()
            boolean r0 = net.one97.paytm.trustlogin.a.a(r0, r3)
            if (r0 == 0) goto L_0x02b4
            r2 = 7
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r16] = r11
            r3 = 1
            r0[r3] = r12
            r4 = 2
            r0[r4] = r17
            r6 = 3
            r0[r6] = r15
            r7 = 4
            r0[r7] = r15
            r2 = 5
            r0[r2] = r15
            r2 = 6
            r0[r2] = r5
            r1.addRow(r0)
            goto L_0x02dd
        L_0x02b4:
            r2 = 7
            r3 = 1
            r4 = 2
            r6 = 3
            r7 = 4
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r16] = r15
            r0[r3] = r15
            r0[r4] = r15
            r0[r6] = r15
            r0[r7] = r15
            android.content.Context r2 = r19.getContext()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131964480(0x7f133240, float:1.9565743E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 5
            r0[r3] = r2
            r2 = 6
            r0[r2] = r13
            r1.addRow(r0)
        L_0x02dd:
            return r1
        L_0x02de:
            r2 = 7
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r16] = r15
            r2 = 1
            r0[r2] = r15
            r2 = 2
            r0[r2] = r15
            r2 = 3
            r0[r2] = r15
            r2 = 4
            r0[r2] = r15
            android.content.Context r2 = r19.getContext()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131964481(0x7f133241, float:1.9565745E38)
            java.lang.String r2 = r2.getString(r3)
            r3 = 5
            r0[r3] = r2
            r2 = 6
            r0[r2] = r13
            r1.addRow(r0)
            return r1
        L_0x0308:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.trustlogin.TrustLoginContentProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }
}
